package com.bokecc.sparkview.view {
    import flash.events.*;
    import com.bokecc.controls.*;
    import flash.system.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.player.ui.*;
    import com.bokecc.player.events.*;
    import flash.net.*;
    import com.bokecc.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.player.ui.setuppanel.*;
    import org.puremvc.as3.patterns.mediator.*;
    import com.bokecc.sparkview.command.*;
    import com.bokecc.sparkview.Module.*;
    import com.bokecc.lib.data.*;

    public class PanelViewMediator extends Mediator implements IMediator {

        public static const Name:String = "SparkView.PanelViewMediator.Name";
        public static const InitPanel:String = "SparkView.InitPanel";
        public static const HidenAllPanel:String = "SparkView.HidenAllPanel";
        public static const ShowAlert:String = "SparkView.ShowAlert";
        public static const ShowProtectedPanel:String = "SparkView.ShowProtectedPanel";
        public static const ShowLoading:String = "SparkView.ShowLoading";
        public static const ShowVideoFeedbackPanel:String = "SparkView.ShowVideoFeedbackPanel";
        public static const ShowTipPanel:String = "SparkView.ShowTipPanel";
        public static const ShowDownLoadPanel:String = "SparkView.ShowDownLoadPanel";
        public static const SetQuality:String = "SparkView.SetQuality";
        public static const SetBrightness:String = "SparkView.SetBrightness";
        public static const SetContrast:String = "SparkView.SetContrast";
        public static const SetVideoScale:String = "SparkView.SetVideoScale";

        public function PanelViewMediator(_arg1:Object){
            super(Name, _arg1);
        }
        public static function linkText(_arg1:String, _arg2:String):String{
            return ((((("<a href='event:" + _arg2) + "'><font color='#e77b21'>") + _arg1) + "</font></a>"));
        }

        public function get view():PlayerView{
            return ((viewComponent as PlayerView));
        }
        public function get playerUI():PlayerUI{
            return (this.view.playerUI);
        }
        override public function onRegister():void{
            this.playerUI.addEventListener(CCTextEvent.LINK, this.onPanelEvent);
            this.playerUI.addEventListener(SetUpPanelDataEvent.ARTICULATION_CHANGE, this.onPanelEvent);
            this.playerUI.addEventListener(SetUpPanelDataEvent.CONTRASTVALUE_CHANGE, this.onPanelEvent);
            this.playerUI.addEventListener(SetUpPanelDataEvent.LIGHTVALUE_CHANGE, this.onPanelEvent);
            this.playerUI.addEventListener(SetUpPanelDataEvent.LIGHTVALUE_CONTRASTVALUE_REST, this.onPanelEvent);
            this.playerUI.addEventListener(SetUpPanelDataEvent.VIDEO_SCALE_CHANGE, this.onPanelEvent);
            this.playerUI.addEventListener(DownloadePanelEvent.COPY, this.onPanelEvent);
            this.playerUI.addEventListener(DownloadePanelEvent.DOWNLOADE, this.onPanelEvent);
            this.playerUI.addEventListener(ShareEvent.COPY_FLASHURL, this.onPanelEvent);
            this.playerUI.addEventListener(ShareEvent.COPY_HTMLCODE, this.onPanelEvent);
            this.playerUI.addEventListener(ShareEvent.COPY_VIDEOURL, this.onPanelEvent);
            this.playerUI.addEventListener(ShareEvent.SHARE_KAIXIN, this.onPanelEvent);
            this.playerUI.addEventListener(ShareEvent.SHARE_QQ, this.onPanelEvent);
            this.playerUI.addEventListener(ShareEvent.SHARE_RENREN, this.onPanelEvent);
            this.playerUI.addEventListener(ShareEvent.SHARE_TENXUN, this.onPanelEvent);
            this.playerUI.addEventListener(ShareEvent.SHARE_XINLANG, this.onPanelEvent);
            this.playerUI.addEventListener("selectNominateList", this.onPanelEvent);
            this.playerUI.addEventListener("selectShareCanvas", this.onPanelEvent);
            this.playerUI.addEventListener("customPanelClick", this.onPanelEvent);
            this.playerUI.addEventListener(ReportPanelEvent.COMMIT, this.onPanelEvent);
            this.playerUI.addEventListener(SafeguardModeCanvasEvent.SAFEGUARDMODE_CLICK, this.onPanelEvent);
            this.playerUI.addEventListener(SafeguardModeCanvasEvent.SAFEGUARDMODE_COPY, this.onPanelEvent);
        }
        override public function listNotificationInterests():Array{
            return ([InitPanel, HidenAllPanel, ShowAlert, ShowProtectedPanel, ShowDownLoadPanel, ShowLoading, ShowTipPanel, SetBrightness, SetContrast, SetQuality, SetVideoScale, ShowVideoFeedbackPanel]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local3:String;
            var _local2:Object = _arg1.getBody();
            switch (_arg1.getName()){
                case InitPanel:
                    this.onInitPanel(_local2);
                    break;
                case HidenAllPanel:
                    Alert.hidenAllAlert(this.view.application);
                    this.playerUI.hidenRecoverMessage();
                    this.playerUI.showOrHidenPanel(this.playerUI.currentShowPanel, false);
                    break;
                case ShowAlert:
                    this.showAlert(_local2["msg"], toBoolean(_local2["isShow"]), _local2["title"], toBoolean(_local2["canClose"]), _local2["btnName"], _local2["btnCallback"]);
                    break;
                case ShowProtectedPanel:
                    this.view.showPlayList = false;
                    this.playerUI.safeguardModeVideoUrl = _local2["url"];
                    this.playerUI.safeguardModeTitle = _local2["title"];
                    this.playerUI.showSafeguardModeCanvas(true);
                    break;
                case ShowLoading:
                    this.showLoading(_local2["isShow"], _local2["msg"]);
                    break;
                case ShowTipPanel:
                    if (_local2["isShow"]){
                        this.playerUI.showRecoverMessage(_local2["msg"], _local2["time"]);
                    } else {
                        this.playerUI.hidenRecoverMessage();
                    };
                    break;
                case ShowDownLoadPanel:
                    this.playerUI.showDownloadPanel = true;
                    break;
                case SetBrightness:
                    this.playerUI.setUpPanelData.lightValue = ((Number(_local2) / 100) + 0.5);
                    break;
                case SetContrast:
                    this.playerUI.setUpPanelData.contrastValue = ((Number(_local2) / 100) + 0.5);
                    break;
                case SetVideoScale:
                    this.playerUI.setUpPanelData.videoScale = String(_local2);
                    break;
                case SetQuality:
                    switch (Number(_local2)){
                        case 2:
                            _local3 = ArticulationCanvas.HIGH_DEFINITION;
                            break;
                        case 1:
                            _local3 = ArticulationCanvas.DEFINITION;
                            break;
                        case 0:
                            _local3 = ArticulationCanvas.NORMAL_DEFINITION;
                            break;
                    };
                    this.playerUI.settingPanel.settingtab.setUpPanelData.articulation = _local3;
                    break;
                case ShowVideoFeedbackPanel:
                    this.playerUI.showReportPanel = Boolean(_local2);
                    break;
            };
        }
        private function onInitPanel(_arg1:Object):void{
            var _local2:Object = _arg1["shareData"];
            var _local3:Object = _arg1["quality"];
            this.initQualityPanel(_local3);
            this.initShareData(_local2);
            this.playerUI.downloaderUrl = _arg1["dowloadURL"];
            this.playerUI.settingPanel.settingtab.setUpPanelData.videoScale = VideoScaleCanvas.ORIGINAL;
            this.playerUI.settingPanel.settingtab.setUpPanelData.lightValue = 0.5;
            this.playerUI.settingPanel.settingtab.setUpPanelData.contrastValue = 0.5;
        }
        private function initShareData(_arg1:Object):void{
            var _local2:String = _arg1["bshare"];
            var _local3:Array = _local2.split(",");
            this.playerUI.shareOptionDatas = _local3;
            this.playerUI.flashUrl = _arg1["swf"];
            this.playerUI.htmlUrl = _arg1["html"];
            this.playerUI.videoUrl = _arg1["video"];
        }
        private function initQualityPanel(_arg1:Object):void{
            var _local4:int;
            var _local5:String;
            var _local2:int = int(_arg1["highestQuality"]);
            var _local3:int = int(_arg1["defaultQuality"]);
            if (_local2 == 2){
                _local4 = 7;
            } else {
                if (_local2 == 1){
                    _local4 = 6;
                } else {
                    _local4 = 4;
                };
            };
            if (_local3 == 2){
                _local5 = ArticulationCanvas.HIGH_DEFINITION;
            } else {
                if (_local3 == 1){
                    _local5 = ArticulationCanvas.DEFINITION;
                } else {
                    _local5 = ArticulationCanvas.NORMAL_DEFINITION;
                };
            };
            this.playerUI.settingPanel.settingtab.setUpPanelData.articulationEnabled = _local4;
            this.playerUI.settingPanel.settingtab.setUpPanelData.articulation = _local5;
        }
        private function showLoading(_arg1:Boolean, _arg2:String):void{
            if (_arg1){
                this.playerUI.showLoading();
            } else {
                this.playerUI.hidenLoading();
            };
            this.playerUI.loadingText(_arg2);
        }
        private function showAlert(_arg1:String, _arg2:Boolean=true, _arg3:String="提示", _arg4:Boolean=false, _arg5:String="", _arg6:Function=null):void{
            var alert:* = null;
            var msg:* = _arg1;
            var isShow:Boolean = _arg2;
            var title:String = _arg3;
            var canClose:Boolean = _arg4;
            var btnName:String = _arg5;
            var btnCallback = _arg6;
            this.playerUI.hidenLoading();
            alert = this.playerUI.alertPanel;
            alert.messageText = msg;
            alert.title = title;
            alert.showClose = canClose;
            alert.showCancelButton(false);
            alert.showOkButton(!(isNull(btnName)));
            if (!isNull(btnName)){
                alert.okButton.label = btnName;
            };
            if (btnCallback != null){
                alert.addEventListener(CloseEvent.CLOSE, function onClose (_arg1:CloseEvent):void{
                    btnCallback();
                    playerUI.showAlertPanel = false;
                    alert.removeEventListener(CloseEvent.CLOSE, onClose);
                });
            };
            this.playerUI.showAlertPanel = isShow;
        }
        private function onPanelEvent(_arg1:Event):void{
            var _local3:SetUpPanelVO;
            var _local4:int;
            var _local5:Number;
            var _local6:Number;
            var _local2:String = _arg1.type;
            _local3 = this.playerUI.settingPanel.settingtab.setUpPanelData;
            switch (_local2){
                case CCTextEvent.LINK:
                    this.playerUI.hidenRecoverMessage();
                    this.playerUI.showAlertPanel = false;
                    sendNotification(PanelEventHandler.PanelEvent, null, _arg1["text"]);
                    break;
                case SetUpPanelDataEvent.ARTICULATION_CHANGE:
                    switch (_local3.articulation){
                        case ArticulationCanvas.HIGH_DEFINITION:
                            _local4 = 2;
                            break;
                        case ArticulationCanvas.DEFINITION:
                            _local4 = 1;
                            break;
                        case ArticulationCanvas.NORMAL_DEFINITION:
                            _local4 = 0;
                            break;
                    };
                    this.sendPanelEvent(PanelEventHandler.ToSetQuality, _local4);
                    break;
                case SetUpPanelDataEvent.CONTRASTVALUE_CHANGE:
                    _local5 = ((_local3.contrastValue - 0.5) * 100);
                    this.sendPanelEvent(PanelEventHandler.ToSetContrast, _local5);
                    break;
                case SetUpPanelDataEvent.LIGHTVALUE_CHANGE:
                    _local6 = ((_local3.lightValue - 0.5) * 100);
                    this.sendPanelEvent(PanelEventHandler.ToSetBrightness, _local6);
                    break;
                case SetUpPanelDataEvent.LIGHTVALUE_CONTRASTVALUE_REST:
                    this.sendPanelEvent(PanelEventHandler.ToSetBrightness, 0);
                    this.sendPanelEvent(PanelEventHandler.ToSetContrast, 0);
                    break;
                case SetUpPanelDataEvent.VIDEO_SCALE_CHANGE:
                    this.sendPanelEvent(PanelEventHandler.ToSetVideoScale, _local3.videoScale);
                    break;
                case DownloadePanelEvent.COPY:
                    this.copy(this.playerUI.downloaderUrl);
                    break;
                case DownloadePanelEvent.DOWNLOADE:
                    this.openURL(this.playerUI.downloaderUrl);
                    break;
                case ShareEvent.COPY_FLASHURL:
                    this.copy(this.playerUI.flashUrl, "flashcode");
                    break;
                case ShareEvent.COPY_HTMLCODE:
                    this.copy(this.playerUI.htmlUrl, "htmlcode");
                    break;
                case ShareEvent.COPY_VIDEOURL:
                    this.copy(this.playerUI.videoUrl, "cccode");
                    break;
                case ShareEvent.SHARE_KAIXIN:
                    this.bshare("kaixin001");
                    break;
                case ShareEvent.SHARE_QQ:
                    this.bshare("qzone");
                    break;
                case ShareEvent.SHARE_RENREN:
                    this.bshare("renren");
                    break;
                case ShareEvent.SHARE_TENXUN:
                    this.bshare("qqmb");
                    break;
                case ShareEvent.SHARE_XINLANG:
                    this.bshare("sinaminiblog");
                    break;
                case "selectShareCanvas":
                    sendNotification(PlayAnalyse.SendClick, PlayAnalyse.Trail_share);
                    break;
                case "customPanelClick":
                    sendNotification(PlayAnalyse.SendClick, PlayAnalyse.Popup_link);
                    break;
                case ReportPanelEvent.COMMIT:
                    if (!isNull(_arg1["message"])){
                        this.sendPanelEvent(PanelEventHandler.OnSubmitVideoFeedbackPanel, _arg1["message"]);
                    };
                    break;
                case SafeguardModeCanvasEvent.SAFEGUARDMODE_CLICK:
                    this.openURL(this.playerUI.safeguardModeVideoUrl);
                    break;
                case SafeguardModeCanvasEvent.SAFEGUARDMODE_COPY:
                    this.copy(this.playerUI.safeguardModeVideoUrl);
                    break;
            };
        }
        private function sendPanelEvent(_arg1:String, _arg2=null):void{
            sendNotification(PanelEventHandler.PanelEvent, _arg2, _arg1);
        }
        private function copy(_arg1:String, _arg2:String=""):void{
            if (!isNull(_arg1)){
                System.setClipboard(_arg1);
            };
            this.sendPanelEvent(PanelEventHandler.CopyCode, _arg2);
        }
        private function openURL(_arg1:String):void{
            navigateToURL(new URLRequest(_arg1), "_blank");
        }
        private function bshare(_arg1:String):void{
            this.sendPanelEvent(PanelEventHandler.GoToBShare, _arg1);
        }

    }
}//package com.bokecc.sparkview.view 
