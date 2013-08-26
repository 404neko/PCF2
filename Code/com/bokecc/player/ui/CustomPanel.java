package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import flash.net.*;
    import com.bokecc.containers.*;

    public class CustomPanel extends Panel {

        public static const TEXT_LEFT:String = "textLeft";
        public static const TEXT_RIGHT:String = "textRight";
        public static const TEXT_TOP:String = "textTop";
        public static const TEXT_BOTTOM:String = "textBottom";

        private var _contentLyout:String = "textLeft";
        private var _textLabel:Label;
        private var _image:Loader;
        public var contentBox:Box;
        private var _imageUrl:String;
        private var _hrefUrl:String;
        private var _token:String;

        public function CustomPanel(){
            this.headHeight = 50;
            this.width = 288;
            this.height = 215;
            this.titleAlign = Align.CENTER;
        }
        public function get token():String{
            return (this._token);
        }
        public function set token(_arg1:String):void{
            if (this._token != _arg1){
                this._token = _arg1;
            };
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get imageUrl():String{
            return (this._imageUrl);
        }
        public function get hrefUrl():String{
            return (this._hrefUrl);
        }
        public function set hrefUrl(_arg1:String):void{
            if (this._hrefUrl != _arg1){
                this._hrefUrl = _arg1;
            };
        }
        public function get text():String{
            return (this.textLabel.text);
        }
        public function set text(_arg1:String):void{
            this.textLabel.text = _arg1;
            this.textLabel.wordWrap = false;
            this.textLabel.width = NaN;
            this.textLabel.height = NaN;
            this.setTextPosition();
        }
        public function get image():Loader{
            if (!this._image){
                this._image = new Loader();
                this._image.addEventListener(MouseEvent.CLICK, this.boxOnClick);
            };
            return (this._image);
        }
        public function get textLabel():Label{
            if (!this._textLabel){
                this._textLabel = new Label();
                this._textLabel.text = "";
                this._textLabel.mouseChildren = false;
                this._textLabel.buttonMode = true;
                this._textLabel.color = 0xFFFFFF;
                this._textLabel.addEventListener(MouseEvent.CLICK, this.boxOnClick);
            };
            return (this._textLabel);
        }
        private function boxOnClick(_arg1:MouseEvent):void{
            if (((!((null == this._hrefUrl))) && (!(("" == this._hrefUrl))))){
                navigateToURL(new URLRequest(this._hrefUrl));
                dispatchEvent(new Event("customPanelClick"));
            };
        }
        public function get contentLyout():String{
            return (this._contentLyout);
        }
        public function set contentLyout(_arg1:String):void{
            if (this._contentLyout != _arg1){
                this._contentLyout = _arg1;
                this.textLabel.wordWrap = false;
                this.textLabel.width = NaN;
                this.textLabel.height = NaN;
                this.setTextPosition();
            };
        }
        override public function get titleLabel():Label{
            if (!_titleLabel){
                _titleLabel = new Label();
                _titleLabel.fontSize = 15;
                _titleLabel.color = 0xFFFFFF;
                _titleLabel.bold = true;
                _titleLabel.left = titlePadding;
                _titleLabel.verticalCenter = 0;
            };
            return (_titleLabel);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.textLabel);
            this.addChild(this.image);
            this.setTextPosition();
        }
        public function loaderImage(_arg1:String):void{
            if (((!((null == _arg1))) && (!(("" == _arg1))))){
                this.image.contentLoaderInfo.addEventListener(Event.COMPLETE, this.imageOnComplete);
                this.image.contentLoaderInfo.addEventListener(IOErrorEvent.IO_ERROR, this.onIoError);
                this.image.load(new URLRequest(_arg1));
            } else {
                this.image.contentLoaderInfo.addEventListener(Event.UNLOAD, this.imageOnUnload);
                this.image.unload();
            };
            this._imageUrl = _arg1;
        }
        private function imageOnComplete(_arg1:Event):void{
            if (this.image.contentLoaderInfo.width > 100){
                this.image.width = 100;
                this.image.height = ((100 * this.image.contentLoaderInfo.height) / this.image.contentLoaderInfo.width);
            } else {
                this.image.width = this.image.contentLoaderInfo.width;
                this.image.height = this.image.contentLoaderInfo.height;
            };
            this.setTextPosition();
            this.image.contentLoaderInfo.removeEventListener(Event.COMPLETE, this.imageOnComplete);
            this.image.contentLoaderInfo.removeEventListener(IOErrorEvent.IO_ERROR, this.onIoError);
        }
        private function onIoError(_arg1:IOErrorEvent):void{
            this.setTextPosition();
            this.image.contentLoaderInfo.removeEventListener(Event.COMPLETE, this.imageOnComplete);
            this.image.contentLoaderInfo.removeEventListener(IOErrorEvent.IO_ERROR, this.onIoError);
        }
        private function imageOnUnload(_arg1:Event):void{
            this.image.contentLoaderInfo.removeEventListener(Event.UNLOAD, this.imageOnUnload);
            this.image.width = 0;
            this.image.height = 0;
            this.setTextPosition();
        }
        private function setTextPosition():void{
            switch (this._contentLyout){
                case TEXT_LEFT:
                    if (this.textLabel.width > 100){
                        this.textLabel.wordWrap = true;
                        this.textLabel.width = 100;
                        this.textLabel.height = NaN;
                    };
                    this.textLabel.horizontalCenter = NaN;
                    this.computeHLayout(TEXT_LEFT);
                    this.textLabel.verticalCenter = 0;
                    this.image.y = (0.5 * (((this.height / this.scaleX) - this.headHeight) - this.image.height));
                    break;
                case TEXT_RIGHT:
                    if (this.textLabel.width > 100){
                        this.textLabel.wordWrap = true;
                        this.textLabel.width = 100;
                        this.textLabel.height = NaN;
                    };
                    this.textLabel.horizontalCenter = NaN;
                    this.computeHLayout(TEXT_RIGHT);
                    this.textLabel.verticalCenter = 0;
                    this.image.y = (0.5 * (((this.height / this.scaleX) - this.headHeight) - this.image.height));
                    break;
                case TEXT_TOP:
                    this.textLabel.verticalCenter = NaN;
                    this.computeVLayout(TEXT_TOP);
                    this.textLabel.horizontalCenter = 0;
                    this.image.x = (0.5 * ((this.width / this.scaleX) - this.image.width));
                    break;
                case TEXT_BOTTOM:
                    this.textLabel.verticalCenter = NaN;
                    this.computeVLayout(TEXT_BOTTOM);
                    this.textLabel.horizontalCenter = 0;
                    this.image.x = (0.5 * ((this.width / this.scaleX) - this.image.width));
                    break;
            };
        }
        private function computeHLayout(_arg1:String="textLeft"):void{
            var _local2:Number = 10;
            var _local3:Number = ((this.textLabel.width + this.image.width) + _local2);
            var _local4:Number = (0.5 * ((this.width / this.scaleX) - _local3));
            if (_arg1 == TEXT_LEFT){
                this.textLabel.x = _local4;
                this.image.x = ((this.textLabel.x + this.textLabel.width) + _local2);
            } else {
                if (_arg1 == TEXT_RIGHT){
                    this.image.x = _local4;
                    this.textLabel.x = ((this.image.x + this.image.width) + _local2);
                } else {
                    this.textLabel.x = _local4;
                    this.image.x = ((_local4 + this.textLabel.width) + _local2);
                };
            };
        }
        private function computeVLayout(_arg1:String="textTop"):void{
            var _local2:Number = 10;
            var _local3:Number = ((this.textLabel.height + this.image.height) + _local2);
            var _local4:Number = (0.5 * (((this.height / this.scaleX) - this.headHeight) - _local3));
            if (_arg1 == TEXT_TOP){
                this.textLabel.y = _local4;
                this.image.y = ((_local4 + this.textLabel.height) + _local2);
            } else {
                if (_arg1 == TEXT_BOTTOM){
                    this.image.y = _local4;
                    this.textLabel.y = ((this.image.y + this.image.height) + _local2);
                } else {
                    this.textLabel.y = _local4;
                    this.image.y = ((this.textLabel.y + this.textLabel.height) + _local2);
                };
            };
        }

    }
}//package com.bokecc.player.ui 
