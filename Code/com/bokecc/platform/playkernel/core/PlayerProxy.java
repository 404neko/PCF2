package com.bokecc.platform.playkernel.core {
    import flash.display.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.platform.playkernel.controller.*;
    import com.bokecc.framework.mvc.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.utils.*;

    public class PlayerProxy extends Proxy {

        public static const STATE:String = "PlayKernel.Proxy.PlayerState";
        public static const NAME:String = "PlayKernel.Proxy.Player";

        private var info:InfoProxy;
        private var kernel:KernelProxy;
        private var exProperties:Object;
        private var _presetScale:String;

        public function PlayerProxy(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.exProperties = {};
            super(NAME);
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.onMediaEvent;
                MediaEvent.ALL;
                this.kernel.media;
            } else {
                this.kernel.media.removeEventListener(MediaEvent.ALL, this.onMediaEvent);
            };
            return;
            /*not popped
            this.onMediaEvent
            */
            /*not popped
            MediaEvent.ALL
            */
            /*not popped
            this.kernel.media
            */
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.info = (model.proxy(InfoProxy.NAME) as InfoProxy);
            this.kernel = (model.proxy(KernelProxy.NAME) as KernelProxy);
            if (false){
                5;
                this.onMediaEvent;
                MediaEvent.ALL;
                this.kernel.media;
            } else {
                this.kernel.media.addEventListener(MediaEvent.ALL, this.onMediaEvent);
            };
            return;
            /*not popped
            this.onMediaEvent
            */
            /*not popped
            MediaEvent.ALL
            */
            /*not popped
            this.kernel.media
            */
        }
        private function onMediaEvent(_arg1:MediaEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            /*switch (){
                    if (false){
                        5;
                        _arg1.value;
                        _arg1.code;
                        this;
                    } else {
                        this.dispatchKernelEvent(_arg1.code, _arg1.value);
                    };
                    break;
            }*/;
        }
        protected function dispatchKernelEvent(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new PlayKernelEvent(_arg1, _arg2);
                ;
            } else {
                dispatchEvent(new PlayKernelEvent(_arg1, _arg2));
            };
            if (false){
                5;
                new CommandEvent(CommandEvent.SendKernelEvent, {
                    code:_arg1,
                    value:_arg2
                });
                ;
            } else {
                dispatchEvent(new CommandEvent(CommandEvent.SendKernelEvent, {
                    code:_arg1,
                    value:_arg2
                }));
            };
            return;
            /*not popped
            new CommandEvent(CommandEvent.SendKernelEvent, {
                code:_arg1,
                value:_arg2
            })
            */
            /*not popped
            new PlayKernelEvent(_arg1, _arg2)
            */
        }
        protected function get state():PlayerState{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((model.proxy(STATE) as PlayerState));
        }
        public function get displayObject():DisplayObject{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.kernel.displayObject);
        }
        public function get isPlatformKernel():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this.kernel.document.loaderInfo.url.indexOf(CCURL.PLATFORM) == 0));
        }
        public function set volume(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.kernel.media;
            } else {
                this.kernel.media.volume = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.kernel.media
            */
        }
        public function get volume():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.kernel.media.volume);
        }
        public function set videoZScale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.kernel.media;
            } else {
                this.kernel.media.zscale = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.kernel.media
            */
        }
        public function get videoZScale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.kernel.media.zscale);
        }
        public function set videoScale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.kernel.media;
            } else {
                this.kernel.media.scale = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.kernel.media
            */
        }
        public function get videoScale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.kernel.media.scale);
        }
        public function get originalScale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.kernel.media.oscale);
        }
        public function set presetScale(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Number;
            this._presetScale = _arg1;
            /*switch (){
                    _local2 = this.originalScale;
                    break;
                    _local2 = 0;
                    break;
                    _local2 = (4 / 3);
                    break;
                    _local2 = (16 / 9);
                    break;
                    return;
            }*/;
            this.videoScale = _local2;
        }
        public function get presetScale():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._presetScale);
        }
        public function set brightness(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.kernel.media;
            } else {
                this.kernel.media.brightness = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.kernel.media
            */
        }
        public function get brightness():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.kernel.media.brightness);
        }
        public function set contrast(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.kernel.media;
            } else {
                this.kernel.media.contrast = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.kernel.media
            */
        }
        public function get contrast():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.kernel.media.contrast);
        }
        public function get mediaInfo(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.kernel.media.info);
        }
        public function setSize(_arg1:Number, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg2;
                _arg1;
                this.kernel.displayObject;
            } else {
                this.kernel.displayObject.setSize(_arg1, _arg2);
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.kernel.displayObject
            */
        }
        public function get width():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.kernel.media.width);
        }
        public function get height():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.kernel.media.height);
        }
        public function get stateName():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.stateName);
        }
        public function get viewPosition():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.viewPosition);
        }
        public function get position():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.position);
        }
        public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.duration);
        }
        public function get bufferStart():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.bufferStart);
        }
        public function get bufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.bufferEnd);
        }
        public function get loading():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.state.loading);
        }
        public function get playing():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.playing);
        }
        public function get paused():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.paused);
        }
        public function get stopped():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.stopped);
        }
        public function get bufferTime():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.bufferTime);
        }
        public function get bufferLength():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.bufferLength);
        }
        public function get code():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.code);
        }
        public function get isNormal():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this.code == PlayKernelCode.Normal));
        }
        public function set quality(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                {quality:_arg1};
                KernelProxy.API_SetQuality;
                this.kernel;
            } else {
                this.kernel.callAPI(KernelProxy.API_SetQuality, {quality:_arg1});
            };
            return;
            /*not popped
            {quality:_arg1}
            */
            /*not popped
            KernelProxy.API_SetQuality
            */
            /*not popped
            this.kernel
            */
        }
        public function get quality():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.state.quality);
        }
        public function reset():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                KernelProxy.API_Reset;
                this.kernel;
            } else {
                this.kernel.callAPI(KernelProxy.API_Reset);
            };
            return;
            /*not popped
            KernelProxy.API_Reset
            */
            /*not popped
            this.kernel
            */
        }
        public function startup(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                KernelProxy.API_Startup;
                this.kernel;
            } else {
                this.kernel.callAPI(KernelProxy.API_Startup, _arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            KernelProxy.API_Startup
            */
            /*not popped
            this.kernel
            */
        }
        public function listPlay(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                {index:_arg1};
                KernelProxy.API_ListPlay;
                this.kernel;
            } else {
                this.kernel.callAPI(KernelProxy.API_ListPlay, {index:_arg1});
            };
            return;
            /*not popped
            {index:_arg1}
            */
            /*not popped
            KernelProxy.API_ListPlay
            */
            /*not popped
            this.kernel
            */
        }
        public function preload(_arg1:Number=0, _arg2:int=-1):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                {
                    position:_arg1,
                    quality:_arg2
                };
                KernelProxy.API_Preload;
                this.kernel;
            } else {
                this.kernel.callAPI(KernelProxy.API_Preload, {
                    position:_arg1,
                    quality:_arg2
                });
            };
            return;
            /*not popped
            {
                position:_arg1,
                quality:_arg2
            }
            */
            /*not popped
            KernelProxy.API_Preload
            */
            /*not popped
            this.kernel
            */
        }
        public function start(_arg1:Number=0, _arg2:int=-1):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                {
                    position:_arg1,
                    quality:_arg2
                };
                KernelProxy.API_Start;
                this.kernel;
            } else {
                this.kernel.callAPI(KernelProxy.API_Start, {
                    position:_arg1,
                    quality:_arg2
                });
            };
            return;
            /*not popped
            {
                position:_arg1,
                quality:_arg2
            }
            */
            /*not popped
            KernelProxy.API_Start
            */
            /*not popped
            this.kernel
            */
        }
        public function pause(_arg1=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                {flag:_arg1};
                KernelProxy.API_Pause;
                this.kernel;
            } else {
                this.kernel.callAPI(KernelProxy.API_Pause, {flag:_arg1});
            };
            return;
            /*not popped
            {flag:_arg1}
            */
            /*not popped
            KernelProxy.API_Pause
            */
            /*not popped
            this.kernel
            */
        }
        public function seek(_arg1:Number, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                {
                    position:_arg1,
                    finish:_arg2
                };
                KernelProxy.API_Seek;
                this.kernel;
            } else {
                this.kernel.callAPI(KernelProxy.API_Seek, {
                    position:_arg1,
                    finish:_arg2
                });
            };
            return;
            /*not popped
            {
                position:_arg1,
                finish:_arg2
            }
            */
            /*not popped
            KernelProxy.API_Seek
            */
            /*not popped
            this.kernel
            */
        }
        public function reconnect():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                KernelProxy.API_Reconnect;
                this.kernel;
            } else {
                this.kernel.callAPI(KernelProxy.API_Reconnect);
            };
            return;
            /*not popped
            KernelProxy.API_Reconnect
            */
            /*not popped
            this.kernel
            */
        }
        public function initPlatformPlayerAPI():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:String;
            var _local2:int;
            var _local3:* = this.exProperties;
            //unexpected hasnext2
            if (!!NULL!){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local1 = //unresolved nextvalue or nextname;
            //unresolved if
            delete this.kernel.loader[_local1];
            delete this.exProperties[_local1];
            //unresolved if
        }
        public function addPlatformPlayerAPI(_arg1:String, _arg2:Function):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (!this.kernel.loader.hasOwnProperty(_arg1)){
                if (false){
                    5;
                    _arg2;
                    _arg1;
                    this.kernel.loader;
                } else {
                    this.kernel.loader[_arg1] = _arg2;
                };
                if (false){
                    5;
                    true;
                    _arg1;
                    this.exProperties;
                } else {
                    this.exProperties[_arg1] = true;
                };
            };
        }
        public function dispatchPlatformPlayerEvent(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new PlayKernelEvent(_arg1, _arg2);
                this.kernel.loader;
            } else {
                this.kernel.loader.dispatchEvent(new PlayKernelEvent(_arg1, _arg2));
            };
            return;
            /*not popped
            new PlayKernelEvent(_arg1, _arg2)
            */
            /*not popped
            this.kernel.loader
            */
        }
        public function setSharedValue(_arg1:String, _arg2):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3 = this.kernel.loader;
            _local3["setSharedValue"](_arg1, _arg2);
        }
        public function getSharedValue(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.kernel.loader["getSharedValue"](_arg1));
        }

        if (37 == 34){
            return;
            /*not popped
            PlayerProxy
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.core 
