package com.bokecc.player.ui {
    import flash.events.*;
    import flash.utils.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;
    import com.bokecc.player.ui.playerlist.*;
    import com.greensock.*;

    public class PlayerView extends Canvas {

        public static const TOP:String = "top";
        public static const BOTTOM:String = "bottom";
        public static const LEFT:String = "left";
        public static const RIGHT:String = "right";

        protected var _playerUI:PlayerUI;
        private var playList:BasePlayerList;
        protected var _leftPlayerList:LeftPlayerList;
        protected var _rightPlayerList:RightPlayerList;
        protected var _topPlayerList:TopPlayerList;
        protected var _bottomPlayerList:BottomPlayerList;
        private var duration:Number = 0.2;
        private var contractionWidth:Number = 8;
        private var _showPlayList:Boolean = false;
        private var _playlistLocation:String;
        private var _playListDatas:Array;
        private var _playerListItemStyle:String = "imageStyle";
        private var _playerModeListMode:String = "loop";
        private var _playListHidenTimer:Timer;
        private var _playListSelectIndex:int = -1;

        public function PlayerView(){
            this.addEventListener(MouseEvent.MOUSE_MOVE, this.playerViewOnMouseMove);
        }
        public function get playListSelectIndex():int{
            return (this._playListSelectIndex);
        }
        public function set playListSelectIndex(_arg1:int):void{
            this._playListSelectIndex = _arg1;
            if (this.playList){
                this.playList.selectItemIndex = this._playListSelectIndex;
            };
        }
        public function get playListHidenTimer():Timer{
            if (!this._playListHidenTimer){
                this._playListHidenTimer = new Timer(2000, 1);
                this._playListHidenTimer.addEventListener(TimerEvent.TIMER, this.playListOnTimer);
            };
            return (this._playListHidenTimer);
        }
        private function playListOnTimer(_arg1:TimerEvent):void{
            if (((this._showPlayList) && (!(this.playList.isExpand)))){
                this.playListHidenEffcet();
            };
        }
        private function playerViewOnMouseMove(_arg1:MouseEvent):void{
            stage.removeEventListener(Event.MOUSE_LEAVE, this.baseStageOnMouseLeave);
            stage.addEventListener(Event.MOUSE_LEAVE, this.baseStageOnMouseLeave);
            if (((this._showPlayList) && (!(this.playList.isExpand)))){
                this.playListShowEffcet();
                this.playListHidenTimer.reset();
                this.playListHidenTimer.start();
            };
        }
        private function baseStageOnMouseLeave(_arg1:Event):void{
            if (((this._showPlayList) && (!(this.playList.isExpand)))){
                this.playListHidenEffcet();
            };
        }
        private function playListShowEffcet():void{
            if (this.playList){
                if ((this.playList is TopPlayerList)){
                    this.topPlayerList.addEventListener("move", this.topPlayerListOnMove);
                    TweenNano.to(this.topPlayerList, this.duration, {
                        top:(this.contractionWidth - this.topPlayerList.height),
                        onComplete:this.topPlayerListOnMoveonComplete
                    });
                };
                if ((this.playList is LeftPlayerList)){
                    this.leftPlayerList.addEventListener("move", this.leftPlayerListOnMove);
                    TweenNano.to(this.leftPlayerList, this.duration, {
                        left:(this.contractionWidth - this.leftPlayerList.width),
                        onComplete:this.leftPlayerListOnMoveonComplete
                    });
                };
                if ((this.playList is RightPlayerList)){
                    this.rightPlayerList.addEventListener("move", this.rightPlayerListOnMove);
                    TweenNano.to(this.rightPlayerList, this.duration, {
                        right:(this.contractionWidth - this.rightPlayerList.width),
                        onComplete:this.rightPlayerListOnMoveonComplete
                    });
                };
                if ((this.playList is BottomPlayerList)){
                    this.bottomPlayerList.addEventListener("move", this.bottomPlayerListOnMove);
                    TweenNano.to(this.bottomPlayerList, this.duration, {
                        bottom:(this.contractionWidth - this.bottomPlayerList.height),
                        onComplete:this.bottomPlayerListOnMoveonComplete
                    });
                };
            };
        }
        private function playListHidenEffcet():void{
            if (this.playList){
                if ((this.playList is TopPlayerList)){
                    this.topPlayerList.addEventListener("move", this.topPlayerListOnMove);
                    TweenNano.to(this.topPlayerList, this.duration, {
                        top:-(this.topPlayerList.height),
                        onComplete:this.topPlayerListOnMoveonComplete
                    });
                };
                if ((this.playList is LeftPlayerList)){
                    this.leftPlayerList.addEventListener("move", this.leftPlayerListOnMove);
                    TweenNano.to(this.leftPlayerList, this.duration, {
                        left:-(this.leftPlayerList.width),
                        onComplete:this.leftPlayerListOnMoveonComplete
                    });
                };
                if ((this.playList is RightPlayerList)){
                    this.rightPlayerList.addEventListener("move", this.rightPlayerListOnMove);
                    TweenNano.to(this.rightPlayerList, this.duration, {
                        right:-(this.rightPlayerList.width),
                        onComplete:this.rightPlayerListOnMoveonComplete
                    });
                };
                if ((this.playList is BottomPlayerList)){
                    this.bottomPlayerList.addEventListener("move", this.bottomPlayerListOnMove);
                    TweenNano.to(this.bottomPlayerList, this.duration, {
                        bottom:-(this.bottomPlayerList.height),
                        onComplete:this.bottomPlayerListOnMoveonComplete
                    });
                };
            };
        }
        public function get playListDatas():Array{
            return (this._playListDatas);
        }
        public function set playListDatas(_arg1:Array):void{
            if (_arg1){
                this._playListDatas = _arg1;
                if (((this.playList) && (this.playList.parent))){
                    this.playList.datas = this._playListDatas;
                };
            };
        }
        public function set playerModeListMode(_arg1:String):void{
            if (this._playerModeListMode != _arg1){
                this._playerModeListMode = _arg1;
            };
        }
        public function get playerModeListMode():String{
            return (this._playerModeListMode);
        }
        protected function get leftPlayerList():LeftPlayerList{
            if (!this._leftPlayerList){
                this._leftPlayerList = new LeftPlayerList();
                this._leftPlayerList.skinName = "leftPlayerList";
                this._leftPlayerList.addEventListener(PlayerListEvent.CONTRACTIONBUTTON_CLICK, this.leftOnContractionButtonClick);
                this._leftPlayerList.addEventListener(PlayerModeListEvent.MODE_CHANGE, this.playerListOnModeChange);
                this._leftPlayerList.addEventListener(PlayerListEvent.ITEM_CLICK, this.playerListOnItemClick);
                this._leftPlayerList.addEventListener(PlayerListEvent.NEXT_BUTTON_CLICK, this.playerListOnItemClick);
                this._leftPlayerList.addEventListener(PlayerListEvent.PREVIOUS_BUTTON_CLICK, this.playerListOnItemClick);
                this._leftPlayerList.left = 0;
                this._leftPlayerList.top = 0;
                this._leftPlayerList.bottom = 0;
            };
            return (this._leftPlayerList);
        }
        protected function playerListOnItemClick(_arg1:PlayerListEvent):void{
            dispatchEvent(_arg1.clone());
        }
        protected function playerListOnModeChange(_arg1:PlayerModeListEvent):void{
            this._playerModeListMode = _arg1.modeType;
            dispatchEvent(_arg1.clone());
        }
        protected function leftOnContractionButtonClick(_arg1:PlayerListEvent):void{
            if (this.leftPlayerList.isExpand){
                this.leftPlayerList.addEventListener("move", this.leftPlayerListOnMove);
                TweenNano.to(this.leftPlayerList, this.duration, {
                    left:(this.contractionWidth - this.leftPlayerList.width),
                    onComplete:this.leftPlayerListOnMoveonComplete
                });
                this.leftPlayerList.contraction();
            } else {
                this.leftPlayerList.addEventListener("move", this.leftPlayerListOnMove);
                TweenNano.to(this.leftPlayerList, this.duration, {
                    left:0,
                    onComplete:this.leftPlayerListOnMoveonComplete
                });
                this.leftPlayerList.expand();
            };
        }
        private function leftPlayerListOnMoveonComplete():void{
            this.leftPlayerList.removeEventListener("move", this.leftPlayerListOnMove);
            this.playListHidenTimer.reset();
            this.playListHidenTimer.start();
        }
        private function leftPlayerListOnMove(_arg1:Event):void{
            this.playerUI.left = (this.leftPlayerList.width + this.leftPlayerList.x);
        }
        protected function get rightPlayerList():RightPlayerList{
            if (!this._rightPlayerList){
                this._rightPlayerList = new RightPlayerList();
                this._rightPlayerList.skinName = "rightPlayerList";
                this._rightPlayerList.addEventListener(PlayerListEvent.CONTRACTIONBUTTON_CLICK, this.rightOnContractionButtonClick);
                this._rightPlayerList.addEventListener(PlayerModeListEvent.MODE_CHANGE, this.playerListOnModeChange);
                this._rightPlayerList.addEventListener(PlayerListEvent.ITEM_CLICK, this.playerListOnItemClick);
                this._rightPlayerList.addEventListener(PlayerListEvent.NEXT_BUTTON_CLICK, this.playerListOnItemClick);
                this._rightPlayerList.addEventListener(PlayerListEvent.PREVIOUS_BUTTON_CLICK, this.playerListOnItemClick);
                this._rightPlayerList.right = 0;
                this._rightPlayerList.top = 0;
                this._rightPlayerList.bottom = 0;
            };
            return (this._rightPlayerList);
        }
        protected function rightOnContractionButtonClick(_arg1:PlayerListEvent):void{
            if (this.rightPlayerList.isExpand){
                this.rightPlayerList.addEventListener("move", this.rightPlayerListOnMove);
                TweenNano.to(this.rightPlayerList, this.duration, {
                    right:(this.contractionWidth - this.rightPlayerList.width),
                    onComplete:this.rightPlayerListOnMoveonComplete
                });
                this.rightPlayerList.contraction();
            } else {
                this.rightPlayerList.addEventListener("move", this.rightPlayerListOnMove);
                TweenNano.to(this.rightPlayerList, this.duration, {
                    right:0,
                    onComplete:this.rightPlayerListOnMoveonComplete
                });
                this.rightPlayerList.expand();
            };
        }
        private function rightPlayerListOnMoveonComplete():void{
            this.rightPlayerList.removeEventListener("move", this.rightPlayerListOnMove);
            this.playListHidenTimer.reset();
            this.playListHidenTimer.start();
        }
        private function rightPlayerListOnMove(_arg1:Event):void{
            this.playerUI.right = (this.width - this.rightPlayerList.x);
        }
        protected function get topPlayerList():TopPlayerList{
            if (!this._topPlayerList){
                this._topPlayerList = new TopPlayerList();
                this._topPlayerList.skinName = "topPlayerList";
                this._topPlayerList.addEventListener(PlayerListEvent.CONTRACTIONBUTTON_CLICK, this.topOnContractionButtonClick);
                this._topPlayerList.addEventListener(PlayerModeListEvent.MODE_CHANGE, this.playerListOnModeChange);
                this._topPlayerList.addEventListener(PlayerListEvent.ITEM_CLICK, this.playerListOnItemClick);
                this._topPlayerList.addEventListener(PlayerListEvent.NEXT_BUTTON_CLICK, this.playerListOnItemClick);
                this._topPlayerList.addEventListener(PlayerListEvent.PREVIOUS_BUTTON_CLICK, this.playerListOnItemClick);
                this._topPlayerList.left = 0;
                this._topPlayerList.top = 0;
                this._topPlayerList.right = 0;
            };
            return (this._topPlayerList);
        }
        protected function topOnContractionButtonClick(_arg1:PlayerListEvent):void{
            if (this.topPlayerList.isExpand){
                this.topPlayerList.addEventListener("move", this.topPlayerListOnMove);
                TweenNano.to(this.topPlayerList, this.duration, {
                    top:(this.contractionWidth - this.topPlayerList.height),
                    onComplete:this.topPlayerListOnMoveonComplete
                });
                this.topPlayerList.contraction();
            } else {
                this.topPlayerList.addEventListener("move", this.topPlayerListOnMove);
                TweenNano.to(this.topPlayerList, this.duration, {
                    top:0,
                    onComplete:this.topPlayerListOnMoveonComplete
                });
                this.topPlayerList.expand();
            };
        }
        private function topPlayerListOnMoveonComplete():void{
            this.topPlayerList.removeEventListener("move", this.topPlayerListOnMove);
            this.playListHidenTimer.reset();
            this.playListHidenTimer.start();
        }
        private function topPlayerListOnMove(_arg1:Event):void{
            this.playerUI.top = (this.topPlayerList.height + this.topPlayerList.y);
        }
        protected function get bottomPlayerList():BottomPlayerList{
            if (!this._bottomPlayerList){
                this._bottomPlayerList = new BottomPlayerList();
                this._bottomPlayerList.skinName = "bottomPlayerList";
                this._bottomPlayerList.addEventListener(PlayerListEvent.CONTRACTIONBUTTON_CLICK, this.bottomOnContractionButtonClick);
                this._bottomPlayerList.addEventListener(PlayerModeListEvent.MODE_CHANGE, this.playerListOnModeChange);
                this._bottomPlayerList.addEventListener(PlayerListEvent.ITEM_CLICK, this.playerListOnItemClick);
                this._bottomPlayerList.addEventListener(PlayerListEvent.NEXT_BUTTON_CLICK, this.playerListOnItemClick);
                this._bottomPlayerList.addEventListener(PlayerListEvent.PREVIOUS_BUTTON_CLICK, this.playerListOnItemClick);
                this._bottomPlayerList.left = 0;
                this._bottomPlayerList.right = 0;
                this._bottomPlayerList.bottom = 0;
            };
            return (this._bottomPlayerList);
        }
        protected function bottomOnContractionButtonClick(_arg1:PlayerListEvent):void{
            if (this.bottomPlayerList.isExpand){
                this.bottomPlayerList.addEventListener("move", this.bottomPlayerListOnMove);
                TweenNano.to(this.bottomPlayerList, this.duration, {
                    bottom:(this.contractionWidth - this.bottomPlayerList.height),
                    onComplete:this.bottomPlayerListOnMoveonComplete
                });
                this.bottomPlayerList.contraction();
            } else {
                this.bottomPlayerList.addEventListener("move", this.bottomPlayerListOnMove);
                TweenNano.to(this.bottomPlayerList, this.duration, {
                    bottom:0,
                    onComplete:this.bottomPlayerListOnMoveonComplete
                });
                this.bottomPlayerList.expand();
            };
        }
        private function bottomPlayerListOnMoveonComplete():void{
            this.bottomPlayerList.removeEventListener("move", this.bottomPlayerListOnMove);
            this.playListHidenTimer.reset();
            this.playListHidenTimer.start();
        }
        private function bottomPlayerListOnMove(_arg1:Event):void{
            this.playerUI.bottom = (this.height - this.bottomPlayerList.y);
        }
        public function get playerUI():PlayerUI{
            if (!this._playerUI){
                this._playerUI = new PlayerUI();
                this._playerUI.skinName = "playerSkin";
                this._playerUI.top = 0;
                this._playerUI.right = 0;
                this._playerUI.left = 0;
                this._playerUI.bottom = 0;
                this._playerUI.controlID = ControlList.PLAYER;
            };
            return (this._playerUI);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.playerUI);
        }
        public function set showPlayList(_arg1:Boolean):void{
            this._showPlayList = _arg1;
            if (this._showPlayList){
                if ((((null == this._playlistLocation)) || (("" == this._playlistLocation)))){
                    this.playlistLocation = RIGHT;
                } else {
                    this.playlistLocation = this._playlistLocation;
                };
            } else {
                if (((this.playList) && (this.playList.parent))){
                    this.removeChild(this.playList);
                    switch (this._playlistLocation){
                        case TOP:
                            this.playerUI.top = 0;
                            break;
                        case BOTTOM:
                            this.playerUI.bottom = 0;
                            break;
                        case LEFT:
                            this.playerUI.left = 0;
                            break;
                        case RIGHT:
                            this.playerUI.right = 0;
                            break;
                    };
                };
                this.playList = null;
            };
        }
        public function get playlistLocation():String{
            return (this._playlistLocation);
        }
        public function set playlistLocation(_arg1:String):void{
            var _local2:String = this._playlistLocation;
            this._playlistLocation = _arg1;
            if (this._showPlayList){
                if (((this.playList) && (this.playList.parent))){
                    this.removeChild(this.playList);
                    switch (_local2){
                        case TOP:
                            this.playerUI.top = 0;
                            break;
                        case BOTTOM:
                            this.playerUI.bottom = 0;
                            break;
                        case LEFT:
                            this.playerUI.left = 0;
                            break;
                        case RIGHT:
                            this.playerUI.right = 0;
                            break;
                    };
                };
                switch (this._playlistLocation){
                    case TOP:
                        this.playList = this.topPlayerList;
                        this.topPlayerList.left = 0;
                        this.topPlayerList.top = 0;
                        this.topPlayerList.right = 0;
                        this.topPlayerList.expand();
                        this.addChild(this.playList);
                        this.playerUI.top = this.topPlayerList.height;
                        break;
                    case BOTTOM:
                        this.playList = this.bottomPlayerList;
                        this.bottomPlayerList.left = 0;
                        this.bottomPlayerList.right = 0;
                        this.bottomPlayerList.bottom = 0;
                        this.bottomPlayerList.expand();
                        this.addChild(this.playList);
                        this.playerUI.bottom = this.bottomPlayerList.height;
                        break;
                    case LEFT:
                        this.playList = this.leftPlayerList;
                        this.leftPlayerList.left = 0;
                        this.leftPlayerList.top = 0;
                        this.leftPlayerList.bottom = 0;
                        this.leftPlayerList.expand();
                        this.addChild(this.playList);
                        this.playerUI.left = this.leftPlayerList.width;
                        break;
                    case RIGHT:
                        this.playList = this.rightPlayerList;
                        this.rightPlayerList.right = 0;
                        this.rightPlayerList.top = 0;
                        this.rightPlayerList.bottom = 0;
                        this.rightPlayerList.expand();
                        this.addChild(this.playList);
                        this.playerUI.right = this.rightPlayerList.width;
                        break;
                };
                this.playList.viewStyle = this._playerListItemStyle;
                this.playList.playerModeListMode = this._playerModeListMode;
                this.playList.datas = this.playListDatas;
                this.playList.selectItemIndex = this._playListSelectIndex;
            };
        }
        public function set playerListItemStyle(_arg1:String):void{
            if (this._playerListItemStyle != _arg1){
                this._playerListItemStyle = _arg1;
            };
            if (this.playList){
                this.playList.viewStyle = this._playerListItemStyle;
            };
        }

    }
}//package com.bokecc.player.ui 
