package com.bokecc.player.ui.playerlist {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.player.ui.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class PlayerListTextImageItem extends Canvas implements IDataRenderer {

        private var _image:Image;
        private var _timeLabel:Label;
        private var _videoNameLabel:HorizontalScrollText;
        private var _data:PlayerListItemVO;
        private var mouseOver:Boolean = false;
        private var _overColor:uint = 6908007;
        private var _textColor:uint = 0xFFFFFF;
        private var _textOverColor:uint = 16090679;

        public function PlayerListTextImageItem(){
            this.buttonMode = true;
            this.width = 110;
            this.height = 105;
            this.mouseChildren = false;
            this.addEventListener(MouseEvent.ROLL_OVER, this.itemOnRollOver);
            this.addEventListener(MouseEvent.ROLL_OUT, this.itemOnRollOut);
        }
        public static function newInstance():PlayerListTextImageItem{
            var _local1:PlayerListTextImageItem = new (PlayerListTextImageItem)();
            return (_local1);
        }

        public function get textColor():uint{
            return (this._textColor);
        }
        public function set textColor(_arg1:uint):void{
            this._textColor = _arg1;
        }
        private function itemOnRollOut(_arg1:MouseEvent):void{
            this.mouseOver = false;
            this.updateDisplayList();
            this.videoNameLabel.stopScroll();
        }
        private function itemOnRollOver(_arg1:MouseEvent):void{
            this.mouseOver = true;
            this.updateDisplayList();
            this.videoNameLabel.startScroll();
        }
        public function get overColor():uint{
            return (this._overColor);
        }
        public function set overColor(_arg1:uint):void{
            if (this._overColor != _arg1){
                this._overColor = _arg1;
                this.updateDisplayList();
            };
        }
        public function get data():Object{
            return (this._data);
        }
        public function set data(_arg1:Object):void{
            if (_arg1){
                this._data = PlayerListItemVO(_arg1);
                this._data.addEventListener(Event.CHANGE, this.dataOnChange);
                this.image.url = this._data.imageUrl;
                this.timeLabel.text = this._data.time;
                this.videoNameLabel.text = this._data.videoName;
            };
        }
        private function dataOnChange(_arg1:Event):void{
            this.updateDisplayList();
        }
        public function get videoNameLabel():HorizontalScrollText{
            if (!this._videoNameLabel){
                this._videoNameLabel = new HorizontalScrollText();
                this._videoNameLabel.overScroll = false;
                this._videoNameLabel.textColor = this._textColor;
                this._videoNameLabel.showBackground = true;
                this._videoNameLabel.left = 5;
                this._videoNameLabel.bottom = 24;
                this._videoNameLabel.right = 5;
                this._videoNameLabel.top = 5;
            };
            return (this._videoNameLabel);
        }
        public function get timeLabel():Label{
            if (!this._timeLabel){
                this._timeLabel = new Label();
                this._timeLabel.bottom = 0;
                this._timeLabel.horizontalCenter = 0;
                this._timeLabel.color = this._textColor;
            };
            return (this._timeLabel);
        }
        public function get image():Image{
            if (!this._image){
                this._image = new Image();
                this._image.left = 5;
                this._image.right = 5;
                this._image.top = 5;
                this._image.bottom = 24;
            };
            return (this._image);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.image);
            this.addChild(this.timeLabel);
            this.addChild(this.videoNameLabel);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            var _local1:Graphics = this.graphics;
            _local1.clear();
            if (((this.mouseOver) || (((this._data) && (this._data.select))))){
                _local1.beginFill(this.overColor);
                _local1.drawRect(0, 0, this.width, this.height);
                _local1.endFill();
                this.videoNameLabel.backgroundAlpha = 0.7;
                this.videoNameLabel.textColor = this._textOverColor;
                this.videoNameLabel.top = NaN;
                this.videoNameLabel.height = 25;
                this.videoNameLabel.showBorder = false;
            } else {
                this.videoNameLabel.backgroundAlpha = 1;
                this.videoNameLabel.textColor = this._textColor;
                this.videoNameLabel.top = 5;
                this.videoNameLabel.bgColor = 0x2E2E2E;
                this.videoNameLabel.showBorder = true;
                this.videoNameLabel.borderColor = 0x101010;
                this.videoNameLabel.borderWidth = 2;
            };
        }

    }
}//package com.bokecc.player.ui.playerlist 
