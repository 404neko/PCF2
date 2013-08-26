package com.bokecc.player.ui.playerlist {
    import flash.events.*;
    import flash.display.*;
    import flash.utils.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class HPlayerList extends BasePlayerList {

        private var _viewPort:Canvas;
        private var _content:HBox;
        private var _hScrollBar:HScrollBar;
        private var _controlButtonBox:HBox;
        private var _previousButton:BaseButton;
        private var _nextButton:BaseButton;
        private var _modeButton:BaseButton;
        private var _contractionButton:BaseButton;
        private var _datas:Array;
        private var _viewStyle:String = "imageStyle";
        private var selectItem:DisplayObject;
        private var _modeListTimer:Timer;

        public function HPlayerList(){
            this.height = 158;
        }
        override protected function onMouseWheel(_arg1:MouseEvent):void{
            super.onMouseWheel(_arg1);
            this.hScrollBar.thumbMove((this.hScrollBar.thumbButton.x - _arg1.delta));
        }
        public function get modeListTimer():Timer{
            if (!this._modeListTimer){
                this._modeListTimer = new Timer(300, 1);
                this._modeListTimer.addEventListener(TimerEvent.TIMER, this.modeListOnTimer);
            };
            return (this._modeListTimer);
        }
        private function modeListOnTimer(_arg1:TimerEvent):void{
            playerModeList.visible = false;
        }
        override public function playerModeListOnItemClick(_arg1:PlayerModeListEvent):void{
            this.playerModeListMode = _arg1.modeType;
        }
        override public function playerModeListOnRollOut(_arg1:MouseEvent):void{
            this.modeListTimer.start();
        }
        override public function playerModeListOnRollOver(_arg1:MouseEvent):void{
            this.modeListTimer.stop();
            this.modeListTimer.reset();
        }
        override public function set playerModeListMode(_arg1:String):void{
            if (playerModeList.mode != _arg1){
                playerModeList.mode = _arg1;
                this.modeButton.skinName = _arg1;
                dispatchEvent(new PlayerModeListEvent(PlayerModeListEvent.MODE_CHANGE, playerModeList.mode));
            };
        }
        public function get contractionButton():BaseButton{
            if (!this._contractionButton){
                this._contractionButton = new BaseButton();
                this._contractionButton.addEventListener(MouseEvent.CLICK, this.contractionOnClick);
            };
            return (this._contractionButton);
        }
        private function contractionOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new PlayerListEvent(PlayerListEvent.CONTRACTIONBUTTON_CLICK, null, null, 0));
        }
        public function get controlButtonBox():HBox{
            if (!this._controlButtonBox){
                this._controlButtonBox = new HBox();
                this._controlButtonBox.right = 0;
                this._controlButtonBox.top = 0;
                this._controlButtonBox.width = 144;
                this._controlButtonBox.height = 38;
                this._controlButtonBox.horizontalGap = 33;
                this._controlButtonBox.paddingLeft = 16;
                this._controlButtonBox.paddingRight = 16;
                this._controlButtonBox.verticalAlign = Align.CENTER;
                this._controlButtonBox.skinName = "hPlayerListControlButtonBox";
                this._controlButtonBox.addChild(this.previousButton);
                this._controlButtonBox.addChild(this.nextButton);
                this._controlButtonBox.addChild(this.modeButton);
            };
            return (this._controlButtonBox);
        }
        public function get modeButton():BaseButton{
            if (!this._modeButton){
                this._modeButton = new BaseButton();
                this._modeButton.skinName = playerModeList.mode;
                this._modeButton.addEventListener(MouseEvent.ROLL_OVER, this.modeButtonOnOver);
                this._modeButton.addEventListener(MouseEvent.ROLL_OUT, this.modeButtonOnRollOut);
            };
            return (this._modeButton);
        }
        private function modeButtonOnRollOut(_arg1:MouseEvent):void{
            this.modeListTimer.start();
        }
        private function modeButtonOnOver(_arg1:MouseEvent):void{
            playerModeList.visible = true;
        }
        public function get nextButton():BaseButton{
            if (!this._nextButton){
                this._nextButton = new BaseButton();
                this._nextButton.skinName = "playerListNextButton";
                this._nextButton.addEventListener(MouseEvent.CLICK, this.nextButtonOnClick);
            };
            return (this._nextButton);
        }
        private function nextButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new PlayerListEvent(PlayerListEvent.NEXT_BUTTON_CLICK, null, null, -1));
        }
        public function get previousButton():BaseButton{
            if (!this._previousButton){
                this._previousButton = new BaseButton();
                this._previousButton.skinName = "playerListPreviousButton";
                this._previousButton.addEventListener(MouseEvent.CLICK, this.previousButtonOnClick);
            };
            return (this._previousButton);
        }
        private function previousButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new PlayerListEvent(PlayerListEvent.PREVIOUS_BUTTON_CLICK, null, null, -1));
        }
        public function get viewPort():Canvas{
            if (!this._viewPort){
                this._viewPort = new Canvas();
                this._viewPort.height = 105;
                this._viewPort.left = 5;
                this._viewPort.right = 5;
                this._viewPort.addChild(this.content);
            };
            return (this._viewPort);
        }
        public function get content():HBox{
            if (!this._content){
                this._content = new HBox();
                this._content.horizontalGap = 5;
                this._content.paddingLeft = 5;
                this._content.paddingRight = 5;
                this._content.verticalCenter = 0;
            };
            return (this._content);
        }
        public function get hScrollBar():HScrollBar{
            if (!this._hScrollBar){
                this._hScrollBar = new HScrollBar();
                this._hScrollBar.height = 6;
                this._hScrollBar.left = 10;
                this._hScrollBar.top = 13;
                this._hScrollBar.right = 154;
                this._hScrollBar.content = this.content;
                this._hScrollBar.viewPort = this.viewPort;
            };
            return (this._hScrollBar);
        }
        override public function get datas():Array{
            return (this._datas);
        }
        override public function set datas(_arg1:Array):void{
            if (_arg1){
                this._datas = _arg1;
                this.setupDatas(this._datas);
            };
        }
        override public function get viewStyle():String{
            return (this._viewStyle);
        }
        override public function set viewStyle(_arg1:String):void{
            if (this._viewStyle != _arg1){
                this._viewStyle = _arg1;
                if (this._datas){
                    this.setupDatas(this._datas);
                };
            };
        }
        protected function setupDatas(_arg1:Array):void{
            var _local4:DisplayObject;
            var _local5:IDataRenderer;
            var _local2:int = (this.content.numChildren - 1);
            while (_local2 >= 0) {
                _local4 = this.content.removeChildAt(_local2);
                _local4.removeEventListener(PlayerListEvent.ITEM_CLICK, this.itemOnItemClick);
                _local2--;
            };
            var _local3:int;
            while (_local3 < _arg1.length) {
                if (IMAGE_STYLE == this.viewStyle){
                    _local5 = new PlayerListImageItem();
                } else {
                    if (TEXT_IMAGE_STYLE == this.viewStyle){
                        _local5 = new PlayerListTextImageItem();
                    } else {
                        _local5 = new PlayerListImageItem();
                    };
                };
                DisplayObject(_local5).addEventListener(MouseEvent.CLICK, this.itemOnItemClick);
                _local5.data = _arg1[_local3];
                this.content.addChild(DisplayObject(_local5));
                _local3++;
            };
        }
        protected function itemOnItemClick(_arg1:MouseEvent):void{
            var _local2:PlayerListItemVO = PlayerListItemVO(_arg1.target.data);
            var _local3:DisplayObject = DisplayObject(_arg1.target);
            var _local4:int = this.content.getChildIndex(_local3);
            dispatchEvent(new PlayerListEvent(PlayerListEvent.ITEM_CLICK, _local2, _local3, _local4));
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.viewPort);
            this.addChild(this.hScrollBar);
            this.addChild(this.controlButtonBox);
            this.addChild(this.contractionButton);
            this.addChild(playerModeList);
        }
        override public function get selectItemIndex():int{
            if (this.selectItem){
                return (this.content.getChildIndex(this.selectItem));
            };
            return (-1);
        }
        override public function set selectItemIndex(_arg1:int):void{
            var _local2:DisplayObject;
            var _local3:Number;
            var _local4:Number;
            if (this.selectItem){
                PlayerListItemVO(IDataRenderer(this.selectItem).data).select = false;
            };
            if (_arg1 > -1){
                _local2 = this.content.getChildAt(_arg1);
                if (_local2){
                    _local3 = (_local2.x + this.content.x);
                    _local4 = ((_local2.x + _local2.width) + this.content.x);
                    if ((((_local3 < 0)) || ((_local4 > this.viewPort.width)))){
                        this.hScrollBar.thumbMove(((_local2.x * this.hScrollBar.width) / this.content.width));
                    };
                    PlayerListItemVO(IDataRenderer(_local2).data).select = true;
                    this.selectItem = _local2;
                    playerModeList.visible = false;
                };
            };
        }
        override public function get selectItemRenderer():DisplayObject{
            return (this.selectItem);
        }
        override public function set selectItemRenderer(_arg1:DisplayObject):void{
            var _local2:int = this.content.getChildIndex(_arg1);
            if (_local2 > -1){
                this.selectItemIndex = _local2;
            };
        }
        override public function contraction():void{
            this.contractionButton.selected = true;
            _isExpand = false;
        }
        override public function expand():void{
            this.contractionButton.selected = false;
            _isExpand = true;
        }

    }
}//package com.bokecc.player.ui.playerlist 
