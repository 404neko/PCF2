package com.bokecc.player.ui.playerlist {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.ui.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class PlayerListImageItem extends Canvas implements IDataRenderer {

        private var _image:Image;
        private var _timeLabel:TextItem;
        private var _videoNameLabel:HorizontalScrollText;
        private var _data:PlayerListItemVO;
        private var mouseOver:Boolean = false;
        private var _overColor:uint = 6908007;
        private var _textColor:uint = 0xFFFFFF;
        private var _textOverColor:uint = 16090679;

        public function PlayerListImageItem(){
            this.buttonMode = true;
            this.width = 110;
            this.height = 105;
            this.mouseChildren = false;
            this.addEventListener(MouseEvent.ROLL_OVER, this.itemOnRollOver);
            this.addEventListener(MouseEvent.ROLL_OUT, this.itemOnRollOut);
        }
        public static function newInstance():PlayerListImageItem{
            var _local1:PlayerListImageItem = new (PlayerListImageItem)();
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
                this._videoNameLabel.textColor = this._textColor;
                this._videoNameLabel.height = 24;
                this._videoNameLabel.left = 5;
                this._videoNameLabel.right = 5;
                this._videoNameLabel.bottom = 0;
            };
            return (this._videoNameLabel);
        }
        public function get timeLabel():TextItem{
            if (!this._timeLabel){
                this._timeLabel = new TextItem();
                this._timeLabel.textAlign = Align.RIGHT;
                this._timeLabel.left = 5;
                this._timeLabel.right = 5;
                this._timeLabel.bottom = 24;
                this._timeLabel.textColor = this._textColor;
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
                this.videoNameLabel.textColor = this._textOverColor;
            } else {
                this.videoNameLabel.textColor = this._textColor;
            };
        }

    }
}//package com.bokecc.player.ui.playerlist 
