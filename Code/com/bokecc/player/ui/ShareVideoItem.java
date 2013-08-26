package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class ShareVideoItem extends HBox {

        private var _playCountLabel:Label;
        private var _playCountBox:HBox;
        private var _videoNameLabel:Label;
        private var _videoNameBox:VBox;
        private var _imageBox:Canvas;
        private var _image:Image;
        protected var mouseOver:Boolean = false;
        private var _overColor:uint = 0x333333;
        private var _data:ShareVideoItemVO;

        public function ShareVideoItem(){
            this.mouseChildren = false;
            this.height = 65;
            this.width = 450;
            this.addEventListener(MouseEvent.ROLL_OVER, this.onRollOver);
            this.addEventListener(MouseEvent.ROLL_OUT, this.onRollOut);
        }
        public function get data():ShareVideoItemVO{
            return (this._data);
        }
        public function set data(_arg1:ShareVideoItemVO):void{
            if (_arg1){
                this._data = _arg1;
                this.image.url = this._data.imageUrl;
                this.videoNameLabel.text = this._data.videoName;
                this.playCountLabel.text = ("播放次数:" + this._data.playCount);
                this.updateDisplayList();
            };
        }
        public function set overColor(_arg1:uint):void{
            if (this._overColor != _arg1){
                this._overColor = _arg1;
            };
        }
        public function get overColor():uint{
            return (this._overColor);
        }
        private function onRollOut(_arg1:MouseEvent):void{
            this.mouseOver = false;
            this.updateDisplayList();
        }
        private function onRollOver(_arg1:MouseEvent):void{
            this.mouseOver = true;
            this.updateDisplayList();
        }
        public function get image():Image{
            if (!this._image){
                this._image = new Image();
                this._image.left = 5;
                this._image.right = 5;
                this._image.top = 5;
                this._image.bottom = 5;
            };
            return (this._image);
        }
        public function get imageBox():Canvas{
            if (!this._imageBox){
                this._imageBox = new Canvas();
                this._imageBox.width = 80;
                this._imageBox.height = 58;
                this._imageBox.addChild(this.image);
            };
            return (this._imageBox);
        }
        public function get videoNameBox():VBox{
            if (!this._videoNameBox){
                this._videoNameBox = new VBox();
                this._videoNameBox.percentWidth = 1;
                this._videoNameBox.percentHeight = 1;
                this._videoNameBox.paddingTop = 0;
                this._videoNameBox.horizontalAlign = Align.CENTER;
                this._videoNameBox.addChild(this.videoNameLabel);
            };
            return (this._videoNameBox);
        }
        public function get videoNameLabel():Label{
            if (!this._videoNameLabel){
                this._videoNameLabel = new Label();
                this._videoNameLabel.color = 0xBBBBBB;
                this._videoNameLabel.wordWrap = true;
                this._videoNameLabel.height = 50;
                this._videoNameLabel.width = 200;
                this._videoNameLabel.fontSize = 13;
            };
            return (this._videoNameLabel);
        }
        public function get playCountBox():HBox{
            if (!this._playCountBox){
                this._playCountBox = new HBox();
                this._playCountBox.width = 100;
                this._playCountBox.height = 60;
                this._playCountBox.paddingBottom = 15;
                this._playCountBox.verticalAlign = Align.BOTTOM;
                this._playCountBox.addChild(this.playCountLabel);
            };
            return (this._playCountBox);
        }
        public function get playCountLabel():Label{
            if (!this._playCountLabel){
                this._playCountLabel = new Label();
                this._playCountLabel.color = 0xBBBBBB;
            };
            return (this._playCountLabel);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.imageBox);
            this.addChild(this.playCountBox);
            this.addChild(this.videoNameBox);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            var _local1:Graphics = this.imageBox.graphics;
            _local1.clear();
            _local1.beginFill(0);
            _local1.drawRect(0, 0, this.imageBox.width, this.imageBox.height);
            _local1.endFill();
            var _local2:Graphics = this.graphics;
            _local2.clear();
            _local2.lineStyle(1, 0xA8A8A8);
            if (this.mouseOver){
                _local2.beginFill(this._overColor);
            } else {
                _local2.beginFill(0x1A1A1A);
            };
            _local2.drawRect(0, 0, this.width, this.height);
            _local2.endFill();
        }

    }
}//package com.bokecc.player.ui 
