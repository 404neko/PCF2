package com.bokecc.lib.media.utils {
    import flash.events.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.*;

    public class MediaMonitor extends EventDispatcher {

        private var _mediaEventHandlerMap:Object;
        protected var _media:IMediaBase;
        protected var e:MediaEvent;

        public function MediaMonitor(_arg1:IEventDispatcher=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
            if (false){
                5;
                this;
            } else {
                this.init();
            };
            return;
            /*not popped
            this
            */
        }
        public function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._mediaEventHandlerMap = {};
        }
        public function target(_arg1:IMediaBase):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.media != null){
                if (false){
                    5;
                    this.onMediaEvent;
                    MediaEvent.ALL;
                    this.media;
                } else {
                    this.media.removeEventListener(MediaEvent.ALL, this.onMediaEvent);
                };
            };
            this._media = _arg1;
            if (this.media != null){
                if (false){
                    5;
                    this.onMediaEvent;
                    MediaEvent.ALL;
                    this.media;
                } else {
                    this.media.addEventListener(MediaEvent.ALL, this.onMediaEvent);
                };
            };
        }
        protected function onMediaEvent(_arg1:MediaEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Function = this._mediaEventHandlerMap[_arg1.code];
            if (false){
                5;
                _arg1;
                this;
            } else {
                this.e = _arg1;
            };
            if (_local2 != null){
                _local2();
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this
            */
        }
        public function destroyEvent():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:String;
            if (this.media != null){
                if (false){
                    5;
                    this.onMediaEvent;
                    MediaEvent.ALL;
                    this.media;
                } else {
                    this.media.removeEventListener(MediaEvent.ALL, this.onMediaEvent);
                };
            };
            var _local2:int;
            var _local3:* = this._mediaEventHandlerMap;
            //unexpected hasnext2
            if (!!NULL!){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local1 = //unresolved nextvalue or nextname;
            if (false){
                5;
                _local1;
                this;
            } else {
                this.delEventHandler(_local1);
            };
            //unresolved if
            return;
            /*not popped
            _local1
            */
            /*not popped
            this
            */
        }
        public function setEventHandler(_arg1:String, _arg2:Function):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                _arg2;
                _arg1;
                this._mediaEventHandlerMap;
            } else {
                this._mediaEventHandlerMap[_arg1] = _arg2;
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this._mediaEventHandlerMap
            */
        }
        public function delEventHandler(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            delete this._mediaEventHandlerMap[_arg1];
        }
        public function get media():IMediaBase{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._media);
        }

        if (37 == 34){
            return;
            /*not popped
            MediaMonitor
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.utils 
