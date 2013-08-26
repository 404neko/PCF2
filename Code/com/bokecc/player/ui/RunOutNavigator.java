package com.bokecc.player.ui {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.events.*;
    import com.bokecc.containers.*;

    public class RunOutNavigator extends TabNavigator {

        private var _shareCanvas:ShareCanvas;
        private var _playList:NominateList;
        private var _nextButton:BaseButton;
        private var _backButton:BaseButton;
        private var _currentIndexLabel:Label;
        private var _pageCountLabel:Label;
        private var _buttonBox:HBox;
        private var _canvas:Canvas;

        public function RunOutNavigator(){
            this.width = 460;
            this.height = 305;
            _tabHeight = 20;
            this.addEventListener(IndexChangedEvent.CHILD_INDEX_CHANGE, this.onChildIndexChange);
        }
        public function get canvas():Canvas{
            if (!this._canvas){
                this._canvas = new Canvas();
                this._canvas.skinName = "shareCanvasSkin";
                this._canvas.label = "分享";
                this._canvas.left = 0;
                this._canvas.right = 0;
                this._canvas.top = 0;
                this._canvas.bottom = 0;
                this._canvas.addChild(this.shareCanvas);
            };
            return (this._canvas);
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get pageCountLabel():Label{
            if (!this._pageCountLabel){
                this._pageCountLabel = new Label();
                this._pageCountLabel.color = 0xFFFFFF;
            };
            return (this._pageCountLabel);
        }
        public function get currentIndexLabel():Label{
            if (!this._currentIndexLabel){
                this._currentIndexLabel = new Label();
                this._currentIndexLabel.color = 0xFFFFFF;
            };
            return (this._currentIndexLabel);
        }
        public function get buttonBox():HBox{
            var _local1:Label;
            if (!this._buttonBox){
                this._buttonBox = new HBox();
                this._buttonBox.setSize(80, 24);
                this._buttonBox.x = 380;
                this._buttonBox.y = 0;
                this._buttonBox.paddingTop = 0;
                this._buttonBox.horizontalGap = 0;
                this._buttonBox.verticalAlign = Align.CENTER;
                this._buttonBox.addChild(this.backButton);
                this._buttonBox.addChild(this.currentIndexLabel);
                _local1 = new Label();
                _local1.text = "/";
                _local1.color = 0xFFFFFF;
                this._buttonBox.addChild(_local1);
                this._buttonBox.addChild(this.pageCountLabel);
                this._buttonBox.addChild(this.nextButton);
            };
            return (this._buttonBox);
        }
        public function get backButton():BaseButton{
            if (!this._backButton){
                this._backButton = new BaseButton();
                this._backButton.skinName = "RunOutNavigator_backButton";
                this._backButton.addEventListener(MouseEvent.CLICK, this.backButtonOnClick);
            };
            return (this._backButton);
        }
        private function backButtonOnClick(_arg1:MouseEvent):void{
            this.playList.currentPage = (this.playList.currentPage - 1);
        }
        public function get nextButton():BaseButton{
            if (!this._nextButton){
                this._nextButton = new BaseButton();
                this._nextButton.skinName = "RunOutNavigator_nextButton";
                this._nextButton.addEventListener(MouseEvent.CLICK, this.nextButtononOnClick);
            };
            return (this._nextButton);
        }
        private function nextButtononOnClick(_arg1:MouseEvent):void{
            this.playList.currentPage = (this.playList.currentPage + 1);
        }
        private function onChildIndexChange(_arg1:IndexChangedEvent):void{
            if (selectedChild == this.playList){
                this.buttonBox.visible = true;
            } else {
                this.buttonBox.visible = false;
            };
        }
        public function get playList():NominateList{
            if (!this._playList){
                this._playList = new NominateList();
                this._playList.skinName = "nominateListSkin";
                this._playList.left = 0;
                this._playList.right = 0;
                this._playList.top = 0;
                this._playList.bottom = 0;
                this._playList.addEventListener(NominateListEvent.ITEM_CLICK, this.playListOnItemClick);
                this._playList.addEventListener(NominateList.DATA_CHANGE, this.onDataChange);
                this._playList.verticalGap = 5;
                this._playList.label = "推荐";
            };
            return (this._playList);
        }
        private function playListOnItemClick(_arg1:NominateListEvent):void{
            dispatchEvent(_arg1.clone());
        }
        private function onDataChange(_arg1:Event):void{
            var _local4:int;
            if (0 == this.playList.pageCount){
                this.pageCountLabel.text = "1";
            } else {
                this.pageCountLabel.text = String(this.playList.pageCount);
            };
            var _local2:int = (this.pageCountLabel.text.length - String((this.playList.currentPage + 1)).length);
            var _local3 = "";
            if (_local2 > 0){
                _local4 = 0;
                while (_local4 < _local2) {
                    _local3 = (_local3 + "  ");
                    _local4++;
                };
            };
            this.currentIndexLabel.text = (_local3 + String((this.playList.currentPage + 1)));
            this.buttonBox.updateDisplayList();
        }
        public function get shareCanvas():ShareCanvas{
            if (!this._shareCanvas){
                this._shareCanvas = new ShareCanvas();
                this._shareCanvas.addEventListener(ShareEvent.COPY_FLASHURL, this.shareCanvasEventHandler);
                this._shareCanvas.addEventListener(ShareEvent.COPY_HTMLCODE, this.shareCanvasEventHandler);
                this._shareCanvas.addEventListener(ShareEvent.COPY_VIDEOURL, this.shareCanvasEventHandler);
                this._shareCanvas.addEventListener(ShareEvent.SHARE_XINLANG, this.shareCanvasEventHandler);
                this._shareCanvas.addEventListener(ShareEvent.SHARE_TENXUN, this.shareCanvasEventHandler);
                this._shareCanvas.addEventListener(ShareEvent.SHARE_QQ, this.shareCanvasEventHandler);
                this._shareCanvas.addEventListener(ShareEvent.SHARE_RENREN, this.shareCanvasEventHandler);
                this._shareCanvas.addEventListener(ShareEvent.SHARE_KAIXIN, this.shareCanvasEventHandler);
                this._shareCanvas.verticalCenter = 0;
                this._shareCanvas.horizontalCenter = 0;
            };
            return (this._shareCanvas);
        }
        private function shareCanvasEventHandler(_arg1:ShareEvent):void{
            dispatchEvent(_arg1.clone());
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.playList);
            this.addChild(this.canvas);
            this.rawChildren.addChild(this.buttonBox);
        }
        public function get showPlayList():Boolean{
            if (this.playList.parent){
                return (true);
            };
            return (false);
        }
        public function set showPlayList(_arg1:Boolean):void{
            if (_arg1){
                if (!this.playList.parent){
                    this.addChildAt(this.playList, 0);
                };
                this.selectedChild = this.playList;
            } else {
                if (this.playList.parent){
                    this.removeChild(this.playList);
                };
            };
        }
        public function get showShareCanvas():Boolean{
            if (this.canvas.parent){
                return (true);
            };
            return (false);
        }
        public function set showShareCanvas(_arg1:Boolean):void{
            if (_arg1){
                if (!this.canvas.parent){
                    this.addChild(this.canvas);
                };
                this.selectedChild = this.canvas;
            } else {
                if (this.canvas.parent){
                    this.removeChild(this.canvas);
                };
            };
        }
        override protected function createTab(_arg1:Container):TextButton{
            var _local2:TextButton = new TextButton();
            _local2.blendMode = BlendMode.LAYER;
            _local2.hPadding = 15;
            _local2.labelColor = 0xAAAAAA;
            _local2.selectTextColor = 0xFFFFFF;
            _local2.skinName = "RunOutNavigator_tabButton";
            _local2.label = _arg1.label;
            _local2.addEventListener(MouseEvent.CLICK, this.tabOnClick);
            return (_local2);
        }
        override protected function tabOnClick(_arg1:MouseEvent):void{
            var _local2:TextButton = TextButton(_arg1.target);
            var _local3:int = tabBox.getChildIndex(_local2);
            if (_local3 != selectedIndex){
                if (selectedChild == this.playList){
                    dispatchEvent(new Event("selectShareCanvas"));
                };
                if (selectedChild == this.canvas){
                    dispatchEvent(new Event("selectNominateList"));
                };
            };
            selectedIndex = _local3;
        }

    }
}//package com.bokecc.player.ui 
