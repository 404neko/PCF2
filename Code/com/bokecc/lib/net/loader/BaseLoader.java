package com.bokecc.lib.net.loader {
    import flash.events.*;
    import flash.net.*;
    import flash.utils.*;

    public class BaseLoader extends EventDispatcher implements ILoader {

        private var _requestTime:Number;
        private var _error:Boolean = false;
        private var _loading:Boolean;
        private var _valid:Boolean;
        private var _request:URLRequest;
        protected var _dispatcher:IEventDispatcher;
        private var timeoutTimer:Timer;

        public function BaseLoader(){
            this._request = new URLRequest();
            super();
        }
        public function set url(_arg1:String):void{
            this._request.url = _arg1;
        }
        public function set method(_arg1:String):void{
            this._request.method = _arg1;
        }
        public function set param(_arg1:Object):void{
            this._request.data = _arg1;
        }
        public function load(_arg1:Number=60000):void{
            if (this._request.url){
                this._error = false;
                this._valid = false;
                this._loading = true;
                this._requestTime = getTimer();
                this.eventFlag(false);
                this.newLoader();
                this.eventFlag(true);
                this.clearTimer();
                if (_arg1 > 0){
                    this.timeoutTimer = new Timer(_arg1, 1);
                    this.timeoutTimer.addEventListener(TimerEvent.TIMER_COMPLETE, this.onError);
                    this.timeoutTimer.start();
                };
                this.toLoad(this._request);
            };
        }
        private function clearTimer():void{
            if (this.timeoutTimer){
                this.timeoutTimer.removeEventListener(TimerEvent.TIMER_COMPLETE, this.onError);
                this.timeoutTimer.stop();
            };
        }
        public function unload():void{
            this.eventFlag(false);
            if (this._loading){
                try {
                    this.toUnload();
                } catch(e:Error) {
                };
            };
        }
        public function get error():Boolean{
            return (this._error);
        }
        public function get valid():Boolean{
            return (this._valid);
        }
        public function get loading():Boolean{
            return (this._loading);
        }
        public function get requestTime():Number{
            return (this._requestTime);
        }
        public function get content(){
            return (null);
        }
        private function onFeedback():void{
            this._requestTime = (getTimer() - this._requestTime);
            this._loading = false;
        }
        protected function onError(_arg1:Event):void{
            if (_arg1.type == TimerEvent.TIMER_COMPLETE){
                this.unload();
            } else {
                this.eventFlag(false);
            };
            this.onFeedback();
            this._error = true;
            this.onGetError(_arg1);
            dispatchEvent(_arg1);
        }
        protected function onComplete(_arg1:Event):void{
            this.eventFlag(false);
            this.onFeedback();
            this._valid = true;
            this.onGet(_arg1);
            dispatchEvent(_arg1);
        }
        private function eventFlag(_arg1:Boolean):void{
            this.clearTimer();
            if (this._dispatcher){
                this.eventMap(((_arg1) ? this._dispatcher.addEventListener : this._dispatcher.removeEventListener));
            };
        }
        protected function newLoader():void{
        }
        protected function eventMap(_arg1:Function):void{
            _arg1.apply(null, [Event.COMPLETE, this.onComplete]);
            _arg1.apply(null, [IOErrorEvent.IO_ERROR, this.onError]);
            _arg1.apply(null, [SecurityErrorEvent.SECURITY_ERROR, this.onError]);
        }
        protected function toLoad(_arg1:URLRequest):void{
        }
        protected function toUnload():void{
        }
        protected function onGet(_arg1:Event):void{
        }
        protected function onGetError(_arg1:Event):void{
        }

    }
}//package com.bokecc.lib.net.loader 
