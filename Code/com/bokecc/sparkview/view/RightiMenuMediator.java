package com.bokecc.sparkview.view {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.player.ui.*;
    import com.bokecc.player.events.*;
    import flash.net.*;
    import com.bokecc.player.vo.*;
    import org.puremvc.as3.patterns.mediator.*;
    import com.bokecc.sparkview.Module.*;
    import flash.external.*;

    public class RightiMenuMediator extends Mediator implements IMediator {

        public static const Name:String = "RightiMenuMediator.Name";
        public static const InitRightMenu:String = "SparkView.InitRightMenu";
        public static const RightMenuEnabled:String = "SparkView.RightMenuEnabled";
        public static const ICON_CUSTOM_JT:String = "setUpMenuIcon1Skin";
        public static const ICON_CUSTOM_FACE:String = "setUpMenuIcon2Skin";
        public static const ICON_CUSTOM_MAIL:String = "setUpMenuIcon3Skin";
        public static const ICON_CUSTOM_HT:String = "setUpMenuIcon4Skin";
        public static const ICON_CUSTOM_SHOPPING:String = "setUpMenuIcon4Skin";
        public static const ICON_QUALITY:String = "setUpMenuIcon5Skin";
        public static const ICON_BRIGHTNESS:String = "setUpMenuIcon6Skin";
        public static const ICON_DOWNLOAD:String = "setUpMenuIcon7Skin";
        public static const ICON_SCALE:String = "setUpMenuIcon8Skin";
        public static const ICON_SHARE:String = "setUpMenuIcon9Skin";
        public static const ICON_SETTING:String = "setUpMenuIcon10Skin";
        private static const ICONS:Array = [ICON_CUSTOM_FACE, ICON_CUSTOM_MAIL, ICON_CUSTOM_JT, ICON_CUSTOM_HT, ICON_QUALITY];
        private static const LAYOUT:Array = [CustomPanel.TEXT_BOTTOM, CustomPanel.TEXT_TOP, CustomPanel.TEXT_LEFT, CustomPanel.TEXT_RIGHT];

        public function RightiMenuMediator(_arg1:Object){
            super(Name, _arg1);
        }
        private function get playerUI():PlayerUI{
            return ((viewComponent as PlayerView).playerUI);
        }
        override public function onRegister():void{
            this.playerUI.showSetUpMenu = false;
            this.playerUI.addEventListener(SetUpMenuEvent.ITEM_CLICK, this.onItemClick);
        }
        override public function listNotificationInterests():Array{
            return ([InitRightMenu, RightMenuEnabled]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:Object;
            var _local3:Array;
            _local2 = _arg1.getBody();
            switch (_arg1.getName()){
                case InitRightMenu:
                    this.playerUI.autoHidenSetupMenu = !(Boolean(_local2["autoShow"]));
                    _local3 = _local2["datas"];
                    this.onInitRightMenu(_local3);
                    this.playerUI.showSetUpMenu = (_local3.length > 0);
                    break;
                case RightMenuEnabled:
                    this.playerUI.setupMenu.enabled = _local2;
                    break;
            };
        }
        private function onInitRightMenu(_arg1:Array):void{
            var _local4:Object;
            var _local5:int;
            var _local6:String;
            var _local7:SetUpMenuItemVO;
            var _local2:Array = [];
            var _local3:int;
            while (_local3 < _arg1.length) {
                _local4 = _arg1[_local3];
                _local5 = int(_local4["type"]);
                _local6 = _local4["name"];
                _local7 = new SetUpMenuItemVO();
                switch (_local6){
                    case "sharebutton":
                        _local7.type = SetUpMenuItemVO.SHARE;
                        _local7.labelText = "分享";
                        _local7.iconName = ICON_SHARE;
                        break;
                    case "videodownload":
                        _local7.type = SetUpMenuItemVO.DOWNLOAD;
                        _local7.labelText = "下载";
                        _local7.iconName = ICON_DOWNLOAD;
                        break;
                    case "definition":
                        _local7.type = SetUpMenuItemVO.ARTICULATION;
                        _local7.labelText = "清晰度";
                        _local7.iconName = ICON_QUALITY;
                        break;
                    case "contrast":
                        _local7.type = SetUpMenuItemVO.LUMINANCE;
                        _local7.labelText = "对比度";
                        _local7.iconName = ICON_BRIGHTNESS;
                        break;
                    case "videoscale":
                        _local7.type = SetUpMenuItemVO.VIDEOSCALE;
                        _local7.labelText = "比例";
                        _local7.iconName = ICON_SCALE;
                        break;
                    case "setting":
                        _local7.type = SetUpMenuItemVO.SETUP;
                        _local7.labelText = "设置";
                        _local7.iconName = ICON_SETTING;
                        break;
                    default:
                        _local7.type = SetUpMenuItemVO.CUSTOM;
                        _local7.labelText = _local6;
                        _local7.iconName = ICONS[(int(_local4["style"]) - 1)];
                        _local7.itemData = _local4;
                };
                _local2.push(_local7);
                _local3++;
            };
            this.playerUI.setupMenuDataProvider = _local2;
        }
        private function onItemClick(_arg1:SetUpMenuEvent):void{
            var data:* = null;
            var param:* = null;
            var e:* = _arg1;
            data = e.itemdata.itemData;
            switch (e.itemdata.type){
                case SetUpMenuItemVO.CUSTOM:
                    switch (data["type"]){
                        case 1:
                            this.showCustomPanel(data);
                            this.sendAnalyseLog(PlayAnalyse.Rightmenu_popup);
                            break;
                        case 2:
                            param = data["content"];
                            try {
                                if ((((((((param.indexOf("(") == -1)) && ((param.indexOf(")") == -1)))) && ((param.indexOf("{") == -1)))) && ((param.indexOf("}") == -1)))){
                                    ExternalInterface.call(param);
                                };
                            } catch(e:Error) {
                            };
                            this.sendAnalyseLog(PlayAnalyse.Rightmenu_script);
                            break;
                        case 3:
                            navigateToURL(new URLRequest(data["content"]));
                            this.sendAnalyseLog(PlayAnalyse.Rightmenu_link);
                            break;
                    };
                    break;
                case SetUpMenuItemVO.SHARE:
                    this.sendAnalyseLog(PlayAnalyse.Rightmenu_share);
                    break;
            };
        }
        private function showCustomPanel(_arg1:Object):void{
            this.playerUI.customPanelTitle = _arg1["name"];
            this.playerUI.customPanelImageHref = _arg1["linkURL"];
            this.playerUI.customPanelImageUrl = _arg1["imgURL"];
            this.playerUI.customPanelText = _arg1["describe"];
            this.playerUI.customPanelTextLayout = LAYOUT[(int(_arg1["frame"]) - 1)];
            this.playerUI.showCustomPanel = true;
        }
        private function sendAnalyseLog(_arg1:String):void{
            sendNotification(PlayAnalyse.SendClick, _arg1);
        }

    }
}//package com.bokecc.sparkview.view 
