package com.bokecc.platform.playkernel.core.playerview {
    import flash.events.*;
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.controller.*;
    import flash.utils.*;
    import com.bokecc.lib.utils.*;
    import flash.external.*;

    public class PureAPIView extends PlayerView {

        public static const ListPlay:String = "listPlay";
        public static const Preload:String = "preload";
        public static const Start:String = "start";
        public static const Seek:String = "seek";
        public static const Pause:String = "pause";
        public static const SetSize:String = "setSize";
        public static const SetVolume:String = "setVolume";
        public static const SetVideoScale:String = "setVideoScale";
        public static const SetVideoZScale:String = "setVideoZScale";
        public static const SetBrightness:String = "setBrightness";
        public static const SetContrast:String = "setContrast";
        public static const SetQuality:String = "setQuality";
        public static const Reconnect:String = "reconnect";
        public static const GetVolume:String = "getVolume";
        public static const GetVideoScale:String = "getVideoScale";
        public static const GetVideoZScale:String = "getVideoZScale";
        public static const GetBrightness:String = "getBrightness";
        public static const GetContrast:String = "getContrast";
        public static const GetQuality:String = "getQuality";
        public static const GetListArray:String = "getListArray";
        public static const GetQualityValidity:String = "getQualityValidity";
        public static const GetCode:String = "getCode";
        public static const GetBufferTime:String = "getBufferTime";
        public static const GetBufferLength:String = "getBufferLength";
        public static const GetLoading:String = "getLoading";
        public static const GetPlaying:String = "getPlaying";
        public static const GetPaused:String = "getPaused";
        public static const GetStopped:String = "getStopped";
        public static const GetPosition:String = "getPosition";
        public static const GetDuration:String = "getDuration";
        public static const GetBufferStart:String = "getBufferStart";
        public static const GetBufferEnd:String = "getBufferEnd";

        protected var info:InfoProxy;
        protected var player:PlayerProxy;
        private var handler:String;

        public function PureAPIView(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(PlayerView.PureAPIMode);
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.info = (model.proxy(InfoProxy.NAME) as InfoProxy);
            this.player = (model.proxy(PlayerProxy.NAME) as PlayerProxy);
            super.init();
            new ContextMenuUtil(kernel.document, true);
            if (false){
                5;
                this;
            } else {
                this.initAPI();
            };
            if (false){
                5;
                ;
            } else {
                setLoadSuccess();
            };
            return;
            /*not popped
            this
            */
        }
        override public function eventHandler(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:String;
            var _local4:*;
            var _local2:CommandEvent = (_arg1 as CommandEvent);
            if (_local2){
                _local3 = _local2.value("code");
                _local4 = _local2.value("value");
                if (false){
                    5;
                    _local3;
                    "] PlayKernelEvent :";
                    getTimer();
                    "[";
                    ;
                } else {
                    trace("[", getTimer(), "] PlayKernelEvent :", _local3);
                };
                if (false){
                    5;
                    _local4;
                    _local3;
                    this.player;
                } else {
                    this.player.dispatchPlatformPlayerEvent(_local3, _local4);
                };
                if (false){
                    5;
                    _local3;
                    this;
                } else {
                    this.jsCallback(_local3);
                };
                /*switch (){
                        if (this.info.param.autostart){
                            if (false){
                                5;
                                this.player;
                            } else {
                                this.player.start();
                            };
                        };
                        break;
                }*/;
            };
        }
        private function jsCallback(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (((this.handler) && (_arg1))){
                _arg1 = (".on" + _arg1.split(".").join(""));
                if (false){
                    5;
                    (this.handler + _arg1);
                    ExternalInterface;
                } else {
                    ExternalInterface.call((this.handler + _arg1));
                };
            };
        }
        private function addPlatformPlayerAPI(_arg1:String, _arg2:Function):void{
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
                this.player;
            } else {
                this.player.addPlatformPlayerAPI(_arg1, _arg2);
            };
            if (false){
                5;
                _arg2;
                _arg1;
                ExternalInterface;
            } else {
                ExternalInterface.addCallback(_arg1, _arg2);
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            ExternalInterface
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.player
            */
        }
        private function initAPI():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.handler = this.info.param.getParam("jshandler");
            if (false){
                5;
                this.player;
            } else {
                this.player.initPlatformPlayerAPI();
            };
            if (false){
                5;
                this.info.list.toArray;
                GetListArray;
                this;
            } else {
                this.addPlatformPlayerAPI(GetListArray, this.info.list.toArray);
            };
            if (false){
                5;
                this.info.video.getQualityValidity;
                GetQualityValidity;
                this;
            } else {
                this.addPlatformPlayerAPI(GetQualityValidity, this.info.video.getQualityValidity);
            };
            if (false){
                5;
                this.getCode;
                GetCode;
                this;
            } else {
                this.addPlatformPlayerAPI(GetCode, this.getCode);
            };
            if (false){
                5;
                this.getVideoScale;
                GetVideoScale;
                this;
            } else {
                this.addPlatformPlayerAPI(GetVideoScale, this.getVideoScale);
            };
            if (false){
                5;
                this.getVideoZScale;
                GetVideoZScale;
                this;
            } else {
                this.addPlatformPlayerAPI(GetVideoZScale, this.getVideoZScale);
            };
            if (false){
                5;
                this.getBrightness;
                GetBrightness;
                this;
            } else {
                this.addPlatformPlayerAPI(GetBrightness, this.getBrightness);
            };
            if (false){
                5;
                this.getContrast;
                GetContrast;
                this;
            } else {
                this.addPlatformPlayerAPI(GetContrast, this.getContrast);
            };
            if (false){
                5;
                this.getQuality;
                GetQuality;
                this;
            } else {
                this.addPlatformPlayerAPI(GetQuality, this.getQuality);
            };
            if (false){
                5;
                this.getVolume;
                GetVolume;
                this;
            } else {
                this.addPlatformPlayerAPI(GetVolume, this.getVolume);
            };
            if (false){
                5;
                this.getBufferTime;
                GetBufferTime;
                this;
            } else {
                this.addPlatformPlayerAPI(GetBufferTime, this.getBufferTime);
            };
            if (false){
                5;
                this.getBufferLength;
                GetBufferLength;
                this;
            } else {
                this.addPlatformPlayerAPI(GetBufferLength, this.getBufferLength);
            };
            if (false){
                5;
                this.getLoading;
                GetLoading;
                this;
            } else {
                this.addPlatformPlayerAPI(GetLoading, this.getLoading);
            };
            if (false){
                5;
                this.getPlaying;
                GetPlaying;
                this;
            } else {
                this.addPlatformPlayerAPI(GetPlaying, this.getPlaying);
            };
            if (false){
                5;
                this.getPaused;
                GetPaused;
                this;
            } else {
                this.addPlatformPlayerAPI(GetPaused, this.getPaused);
            };
            if (false){
                5;
                this.getStopped;
                GetStopped;
                this;
            } else {
                this.addPlatformPlayerAPI(GetStopped, this.getStopped);
            };
            if (false){
                5;
                this.getPosition;
                GetPosition;
                this;
            } else {
                this.addPlatformPlayerAPI(GetPosition, this.getPosition);
            };
            if (false){
                5;
                this.getDuration;
                GetDuration;
                this;
            } else {
                this.addPlatformPlayerAPI(GetDuration, this.getDuration);
            };
            if (false){
                5;
                this.getBufferStart;
                GetBufferStart;
                this;
            } else {
                this.addPlatformPlayerAPI(GetBufferStart, this.getBufferStart);
            };
            if (false){
                5;
                this.getBufferEnd;
                GetBufferEnd;
                this;
            } else {
                this.addPlatformPlayerAPI(GetBufferEnd, this.getBufferEnd);
            };
            if (false){
                5;
                this.player.listPlay;
                ListPlay;
                this;
            } else {
                this.addPlatformPlayerAPI(ListPlay, this.player.listPlay);
            };
            if (false){
                5;
                this.player.preload;
                Preload;
                this;
            } else {
                this.addPlatformPlayerAPI(Preload, this.player.preload);
            };
            if (false){
                5;
                this.player.start;
                Start;
                this;
            } else {
                this.addPlatformPlayerAPI(Start, this.player.start);
            };
            if (false){
                5;
                this.player.seek;
                Seek;
                this;
            } else {
                this.addPlatformPlayerAPI(Seek, this.player.seek);
            };
            if (false){
                5;
                this.player.pause;
                Pause;
                this;
            } else {
                this.addPlatformPlayerAPI(Pause, this.player.pause);
            };
            if (false){
                5;
                this.player.setSize;
                SetSize;
                this;
            } else {
                this.addPlatformPlayerAPI(SetSize, this.player.setSize);
            };
            if (false){
                5;
                this.setVolume;
                SetVolume;
                this;
            } else {
                this.addPlatformPlayerAPI(SetVolume, this.setVolume);
            };
            if (false){
                5;
                this.setVideoScale;
                SetVideoScale;
                this;
            } else {
                this.addPlatformPlayerAPI(SetVideoScale, this.setVideoScale);
            };
            if (false){
                5;
                this.setVideoZScale;
                SetVideoZScale;
                this;
            } else {
                this.addPlatformPlayerAPI(SetVideoZScale, this.setVideoZScale);
            };
            if (false){
                5;
                this.setBrightness;
                SetBrightness;
                this;
            } else {
                this.addPlatformPlayerAPI(SetBrightness, this.setBrightness);
            };
            if (false){
                5;
                this.setContrast;
                SetContrast;
                this;
            } else {
                this.addPlatformPlayerAPI(SetContrast, this.setContrast);
            };
            if (false){
                5;
                this.setQuality;
                SetQuality;
                this;
            } else {
                this.addPlatformPlayerAPI(SetQuality, this.setQuality);
            };
            return;
            /*not popped
            this.setQuality
            */
            /*not popped
            SetQuality
            */
            /*not popped
            this
            */
            /*not popped
            this.setContrast
            */
            /*not popped
            SetContrast
            */
            /*not popped
            this
            */
            /*not popped
            this.setBrightness
            */
            /*not popped
            SetBrightness
            */
            /*not popped
            this
            */
            /*not popped
            this.setVideoZScale
            */
            /*not popped
            SetVideoZScale
            */
            /*not popped
            this
            */
            /*not popped
            this.setVideoScale
            */
            /*not popped
            SetVideoScale
            */
            /*not popped
            this
            */
            /*not popped
            this.setVolume
            */
            /*not popped
            SetVolume
            */
            /*not popped
            this
            */
            /*not popped
            this.player.setSize
            */
            /*not popped
            SetSize
            */
            /*not popped
            this
            */
            /*not popped
            this.player.pause
            */
            /*not popped
            Pause
            */
            /*not popped
            this
            */
            /*not popped
            this.player.seek
            */
            /*not popped
            Seek
            */
            /*not popped
            this
            */
            /*not popped
            this.player.start
            */
            /*not popped
            Start
            */
            /*not popped
            this
            */
            /*not popped
            this.player.preload
            */
            /*not popped
            Preload
            */
            /*not popped
            this
            */
            /*not popped
            this.player.listPlay
            */
            /*not popped
            ListPlay
            */
            /*not popped
            this
            */
            /*not popped
            this.getBufferEnd
            */
            /*not popped
            GetBufferEnd
            */
            /*not popped
            this
            */
            /*not popped
            this.getBufferStart
            */
            /*not popped
            GetBufferStart
            */
            /*not popped
            this
            */
            /*not popped
            this.getDuration
            */
            /*not popped
            GetDuration
            */
            /*not popped
            this
            */
            /*not popped
            this.getPosition
            */
            /*not popped
            GetPosition
            */
            /*not popped
            this
            */
            /*not popped
            this.getStopped
            */
            /*not popped
            GetStopped
            */
            /*not popped
            this
            */
            /*not popped
            this.getPaused
            */
            /*not popped
            GetPaused
            */
            /*not popped
            this
            */
            /*not popped
            this.getPlaying
            */
            /*not popped
            GetPlaying
            */
            /*not popped
            this
            */
            /*not popped
            this.getLoading
            */
            /*not popped
            GetLoading
            */
            /*not popped
            this
            */
            /*not popped
            this.getBufferLength
            */
            /*not popped
            GetBufferLength
            */
            /*not popped
            this
            */
            /*not popped
            this.getBufferTime
            */
            /*not popped
            GetBufferTime
            */
            /*not popped
            this
            */
            /*not popped
            this.getVolume
            */
            /*not popped
            GetVolume
            */
            /*not popped
            this
            */
            /*not popped
            this.getQuality
            */
            /*not popped
            GetQuality
            */
            /*not popped
            this
            */
            /*not popped
            this.getContrast
            */
            /*not popped
            GetContrast
            */
            /*not popped
            this
            */
            /*not popped
            this.getBrightness
            */
            /*not popped
            GetBrightness
            */
            /*not popped
            this
            */
            /*not popped
            this.getVideoZScale
            */
            /*not popped
            GetVideoZScale
            */
            /*not popped
            this
            */
            /*not popped
            this.getVideoScale
            */
            /*not popped
            GetVideoScale
            */
            /*not popped
            this
            */
            /*not popped
            this.getCode
            */
            /*not popped
            GetCode
            */
            /*not popped
            this
            */
            /*not popped
            this.info.video.getQualityValidity
            */
            /*not popped
            GetQualityValidity
            */
            /*not popped
            this
            */
            /*not popped
            this.info.list.toArray
            */
            /*not popped
            GetListArray
            */
            /*not popped
            this
            */
            /*not popped
            this.player
            */
        }
        private function setQuality(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                _arg1;
                this.player;
            } else {
                this.player.quality = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.player
            */
        }
        private function setContrast(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.player;
            } else {
                this.player.contrast = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.player
            */
        }
        private function setBrightness(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.player;
            } else {
                this.player.brightness = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.player
            */
        }
        private function setVideoZScale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.player;
            } else {
                this.player.videoZScale = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.player
            */
        }
        private function setVideoScale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                _arg1;
                this.player;
            } else {
                this.player.videoScale = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.player
            */
        }
        private function setVolume(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.player;
            } else {
                this.player.volume = _arg1;
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.player
            */
        }
        private function getBufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.bufferEnd);
        }
        private function getBufferStart():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.bufferStart);
        }
        private function getDuration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.duration);
        }
        private function getPosition():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.position);
        }
        private function getStopped():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.stopped);
        }
        private function getPaused():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.paused);
        }
        private function getPlaying():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.playing);
        }
        private function getLoading():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.loading);
        }
        private function getBufferLength():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.bufferLength);
        }
        private function getBufferTime():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.player.bufferTime);
        }
        private function getVolume():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.volume);
        }
        private function getQuality():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.player.quality);
        }
        private function getContrast():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.contrast);
        }
        private function getBrightness():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.brightness);
        }
        private function getVideoZScale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.videoZScale);
        }
        private function getVideoScale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.videoScale);
        }
        private function getCode():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.player.code);
        }
        override public function initView():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.initView();
            if (false){
                5;
                null;
                ;
            } else {
                setInitializeSuccess(null);
            };
            return;
            /*not popped
            null
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PureAPIView
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.core.playerview 
