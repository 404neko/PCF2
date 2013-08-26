package com.bokecc.lib.net.loader {
    import flash.events.*;
    import flash.display.*;
    import flash.net.*;
    import flash.system.*;
    import flash.utils.*;

    public class SWFLoader extends BaseLoader implements ILoader {

        protected var _context:LoaderContext;
        protected var _loaderInfo:LoaderInfo;
        protected var _loader:Loader;
        private var _readyTime:Number;

        public function SWFLoader(_arg1:ApplicationDomain=null){
            this._context = new LoaderContext();
            this._context.applicationDomain = new ApplicationDomain(_arg1);
        }
        public function get loader():Loader{
            return (this._loader);
        }
        public function get info():LoaderInfo{
            return (this._loaderInfo);
        }
        public function loadDuration():Number{
            return (super.requestTime);
        }
        override public function get requestTime():Number{
            return (this._readyTime);
        }
        override public function get content(){
            return (this._loader.content);
        }
        override protected function newLoader():void{
            this._loader = new Loader();
            _dispatcher = this._loader.contentLoaderInfo;
        }
        override protected function eventMap(_arg1:Function):void{
            super.eventMap(_arg1);
            _arg1.apply(null, [ProgressEvent.PROGRESS, dispatchEvent]);
            _arg1.apply(null, [Event.INIT, this.onSWFInit]);
        }
        override protected function toLoad(_arg1:URLRequest):void{
            this._readyTime = getTimer();
            this._loader.load(_arg1, this._context);
        }
        override protected function toUnload():void{
            this._loader.close();
        }
        protected function onSWFInit(_arg1:Event):void{
            this._readyTime = (getTimer() - this._readyTime);
            this._loaderInfo = (_arg1.currentTarget as LoaderInfo);
            this.onInit();
            dispatchEvent(_arg1);
        }
        protected function onInit():void{
        }

    }
}//package com.bokecc.lib.net.loader 
