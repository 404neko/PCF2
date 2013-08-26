package com.bokecc.sparkview.view {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.player.ui.*;
    import com.bokecc.platform.playkernel.api.model.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.player.ui.playerlist.*;
    import org.puremvc.as3.patterns.mediator.*;
    import com.bokecc.sparkview.command.*;

    public class ListViewMediator extends Mediator implements IMediator {

        public static const Name:String = "ListViewMediator.Name";
        public static const ListReady:String = "SprakView.ListReady";
        public static const ToListPlay:String = "SprakView.ToListPlay";
        private static const pos:Array = ["right", "bottom", "left", "top"];
        private static const style:Array = ["imageStyle", "imageStyle", "textStyle", "textImageStyle"];

        public function ListViewMediator(_arg1:Object){
            super(Name, _arg1);
        }
        private function get view():PlayerView{
            return ((viewComponent as PlayerView));
        }
        private function get playerUI():PlayerUI{
            return (this.view.playerUI);
        }
        override public function onRegister():void{
            this.view.addEventListener(PlayerListEvent.NEXT_BUTTON_CLICK, this.onButtonClick);
            this.view.addEventListener(PlayerListEvent.PREVIOUS_BUTTON_CLICK, this.onButtonClick);
            this.view.addEventListener(PlayerListEvent.ITEM_CLICK, this.onListClick);
        }
        override public function listNotificationInterests():Array{
            return ([ListReady, ToListPlay]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:String = _arg1.getName();
            var _local3:Object = _arg1.getBody();
            switch (_local2){
                case ListReady:
                    this.initList(_local3["listPosition"], _local3["listStyle"], _local3["listData"]);
                    break;
                case ToListPlay:
                    this.playFinish();
                    break;
            };
        }
        private function initList(_arg1:int, _arg2:int, _arg3:ListInfo):void{
            var _local7:Object;
            var _local8:PlayerListItemVO;
            var _local4:int = _arg3.length;
            var _local5:Array = new Array();
            var _local6:int;
            while (_local6 < _local4) {
                _local7 = _arg3.getNode(_local6);
                _local8 = new PlayerListItemVO();
                _local8.videoName = _local7["title"];
                _local8.time = _local7["playtime"];
                _local8.imageUrl = _local7["imgurl"];
                _local5.push(_local8);
                _local6++;
            };
            this.view.playlistLocation = pos[(_arg1 - 1)];
            this.view.playerListItemStyle = style[_arg2];
            this.view.playListDatas = _local5;
            this.view.showPlayList = true;
            this.view.playerModeListMode = PlayerModeList.LOOP;
            this.toPlay(0);
        }
        protected function onButtonClick(_arg1:PlayerListEvent):void{
            var _local2 = (_arg1.type == PlayerListEvent.PREVIOUS_BUTTON_CLICK);
            var _local3:int = this.view.playListDatas.length;
            var _local4:int = this.view.playListSelectIndex;
            var _local5:String = this.view.playerModeListMode;
            _local4 = ((_local2) ? ((_local4 - 1) % _local3) : ((_local4 + 1) % _local3));
            _local4 = (((_local4 < 0)) ? (_local3 - 1) : _local4);
            if (_local5 == PlayerModeList.RANDOM){
                _local4 = int((Math.random() * _local3));
            };
            this.toPlay(_local4);
        }
        private function playFinish(_arg1:Boolean=false):void{
            var _local2:String = this.view.playerModeListMode;
            var _local3:int = this.view.playListSelectIndex;
            var _local4:int = this.view.playListDatas.length;
            switch (_local2){
                case PlayerModeList.LOOP:
                    _local3 = ((_local3 + 1) % _local4);
                    break;
                case PlayerModeList.RANDOM:
                    _local3 = (Math.random() * _local4);
                    break;
                case PlayerModeList.SEQUENCE:
                    _local3 = (_local3 + 1);
                    break;
                case PlayerModeList.SINGLE:
                    break;
            };
            this.toPlay(_local3);
        }
        private function toPlay(_arg1:int):void{
            this.view.playListSelectIndex = _arg1;
            sendNotification(OperateEventHandler.OperateEvent, _arg1, OperateEventHandler.PlayKernelListPlay);
        }
        private function onListClick(_arg1:PlayerListEvent):void{
            this.toPlay(_arg1.index);
        }

    }
}//package com.bokecc.sparkview.view 
