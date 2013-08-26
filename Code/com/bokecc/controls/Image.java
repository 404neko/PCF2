package com.bokecc.controls {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import com.bokecc.containers.layout.*;
    import flash.net.*;

    public class Image extends Component implements ILayoutClient {

        public static const LAYOUT_CHANGE:String = "layoutChange";

        private var _top:Number = NaN;
        private var _bottom:Number = NaN;
        private var _left:Number = NaN;
        private var _right:Number = NaN;
        private var _horizontalCenter:Number = NaN;
        private var _verticalCenter:Number = NaN;
        private var _percentWidth:Number = NaN;
        private var _percentHeight:Number = NaN;
        protected var _loader:Loader;
        private var _url:String;
        private var imageOldWidth:Number;
        private var imageOldHeight:Number;
        private var isLoader:Boolean = false;

        public function get url():String{
            return (this._url);
        }
        public function set url(_arg1:String):void{
            if (this._url != _arg1){
                this._url = _arg1;
                if (((!((null == this._url))) && (!(("" == this._url))))){
                    this.loader.load(new URLRequest(this._url));
                    this.loader.contentLoaderInfo.addEventListener(Event.COMPLETE, this.loaderOnComplete);
                    this.loader.contentLoaderInfo.addEventListener(IOErrorEvent.IO_ERROR, this.loaderOnIoError);
                } else {
                    this.loader.contentLoaderInfo.addEventListener(Event.UNLOAD, this.imageOnUnload);
                    this.loader.unload();
                };
            };
        }
        private function imageOnUnload(_arg1:Event):void{
            this.loader.contentLoaderInfo.removeEventListener(Event.UNLOAD, this.imageOnUnload);
            this.loader.width = 0;
            this.loader.height = 0;
            this.updateDisplayList();
            dispatchEvent(new Event("unload"));
        }
        private function loaderOnIoError(_arg1:IOErrorEvent):void{
            dispatchEvent(new Event("loaderError"));
            this.loader.contentLoaderInfo.removeEventListener(Event.COMPLETE, this.loaderOnComplete);
            this.loader.contentLoaderInfo.removeEventListener(IOErrorEvent.IO_ERROR, this.loaderOnIoError);
        }
        private function loaderOnComplete(_arg1:Event):void{
            this.imageOldWidth = this.loader.width;
            this.imageOldHeight = this.loader.height;
            this.isLoader = true;
            this.updateDisplayList();
            this.loader.contentLoaderInfo.removeEventListener(Event.COMPLETE, this.loaderOnComplete);
            this.loader.contentLoaderInfo.removeEventListener(IOErrorEvent.IO_ERROR, this.loaderOnIoError);
            dispatchEvent(new Event(LAYOUT_CHANGE));
            dispatchEvent(new Event("loadComplete"));
        }
        public function get loader():Loader{
            if (!this._loader){
                this._loader = new Loader();
            };
            return (this._loader);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.loader);
        }
        override public function updateDisplayList():void{
            if (((isNaN(this._width)) || (isNaN(this._height)))){
                this.measure();
            } else {
                if (this.isLoader){
                    this.loader.width = this.width;
                    this.loader.height = this.height;
                };
            };
        }
        override protected function measure():void{
            super.measure();
            if (((!(isNaN(this.imageOldWidth))) && (!(isNaN(this.imageOldHeight))))){
                this.loader.width = this.imageOldWidth;
                this.loader.height = this.imageOldHeight;
            };
        }
        public function get bottom():Number{
            return (this._bottom);
        }
        public function set bottom(_arg1:Number):void{
            if (this._bottom != _arg1){
                this._bottom = _arg1;
                this._verticalCenter = NaN;
                this._percentHeight = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get left():Number{
            return (this._left);
        }
        public function set left(_arg1:Number):void{
            if (this._left != _arg1){
                this._left = _arg1;
                this._horizontalCenter = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get right():Number{
            return (this._right);
        }
        public function set right(_arg1:Number):void{
            if (this._right != _arg1){
                this._right = _arg1;
                this._horizontalCenter = NaN;
                this._percentWidth = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get top():Number{
            return (this._top);
        }
        public function set top(_arg1:Number):void{
            if (this._top != _arg1){
                this._top = _arg1;
                this._verticalCenter = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get horizontalCenter():Number{
            return (this._horizontalCenter);
        }
        public function set horizontalCenter(_arg1:Number):void{
            if (this._horizontalCenter != _arg1){
                this._horizontalCenter = _arg1;
                this._left = NaN;
                this._right = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get verticalCenter():Number{
            return (this._verticalCenter);
        }
        public function set verticalCenter(_arg1:Number):void{
            if (this._verticalCenter != _arg1){
                this._verticalCenter = _arg1;
                this._top = NaN;
                this._bottom = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get percentWidth():Number{
            return (this._percentWidth);
        }
        public function set percentWidth(_arg1:Number):void{
            if (this._percentWidth != _arg1){
                this._percentWidth = _arg1;
                this._right = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get percentHeight():Number{
            return (this._percentHeight);
        }
        public function set percentHeight(_arg1:Number):void{
            if (this._percentHeight != _arg1){
                this._percentHeight = _arg1;
                this._bottom = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        override public function setSize(_arg1:Number, _arg2:Number):void{
            super.setSize(_arg1, _arg2);
            dispatchEvent(new Event(LAYOUT_CHANGE));
        }

    }
}//package com.bokecc.controls 
