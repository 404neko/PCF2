package com.bokecc.platform.playkernel.model.info {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.core.playerad.*;
    import com.bokecc.platform.playkernel.model.player.*;
    import com.bokecc.platform.playkernel.api.*;

    public class PlayProxy extends BasicProxy {

        public static const NAME:String = "PlayKernel.Proxy.Play";

        public var videoStatus:int = -1;
        public var position:Number = 0;
        public var paused:Boolean;
        private var _preloadType:int;
        private var _preloadTime:Array;
        private var _retryType:int;
        private var _unFinishErrorRetryTime:int;
        private var _normalPlayErrorRetryTime:int;
        private var _playID:String;
        private var _duration:Number = 0;
        private var _quality:int = -1;
        private var _priority:Number;
        private var _sameisp:Boolean;
        private var _mediaGroup:MediaGroup;
        private var _mediaProxy:MediaProxy;
        private var _beginADLoadStarted:Boolean = false;
        private var _beginADFinish:Boolean = false;
        private var _endADFinish:Boolean = false;
        private var durations:Object;

        public function PlayProxy(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._preloadTime = [];
            this.durations = {};
            super(NAME, []);
        }
        private static function get uniqueString():String{
            if (37 == 34){
                return;
                /*not popped
                PlayProxy
                */
            };
            var _local1:Date = new Date();
            var _local2:Number = _local1.getHours();
            var _local3:Number = _local1.getMinutes();
            var _local4:Number = _local1.getSeconds();
            return ((((((_local2 * 3600) + (_local3 * 60)) + _local4).toString(36) + "_") + Math.round((Math.random() * 999999)).toString(36)));
        }

        protected function get map():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (data);
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.onRemove();
            if (false){
                5;
                KernelProxy.API_Start;
                kernel;
            } else {
                kernel.removeAPI(KernelProxy.API_Start);
            };
            if (false){
                5;
                kernel.media;
            } else {
                kernel.media.destroyEntity();
            };
            if (false){
                5;
                this.onShowADFinish;
                ADEvent.ShowADFinish;
                kernel.ad;
            } else {
                kernel.ad.removeEventListener(ADEvent.ShowADFinish, this.onShowADFinish);
            };
            if (false){
                5;
                this.onLoadADBegin;
                ADEvent.LoadADBegin;
                kernel.ad;
            } else {
                kernel.ad.removeEventListener(ADEvent.LoadADBegin, this.onLoadADBegin);
            };
            if (false){
                5;
                this.id;
                PlayKernelEvent.PlayStopped;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayStopped, this.id);
            };
            return;
            /*not popped
            this.id
            */
            /*not popped
            PlayKernelEvent.PlayStopped
            */
            /*not popped
            kernel
            */
            /*not popped
            this.onLoadADBegin
            */
            /*not popped
            ADEvent.LoadADBegin
            */
            /*not popped
            kernel.ad
            */
            /*not popped
            this.onShowADFinish
            */
            /*not popped
            ADEvent.ShowADFinish
            */
            /*not popped
            kernel.ad
            */
            /*not popped
            kernel.media
            */
            /*not popped
            KernelProxy.API_Start
            */
            /*not popped
            kernel
            */
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
            if (false){
                5;
                this.onShowADFinish;
                ADEvent.ShowADFinish;
                kernel.ad;
            } else {
                kernel.ad.addEventListener(ADEvent.ShowADFinish, this.onShowADFinish);
            };
            if (false){
                5;
                this.onLoadADBegin;
                ADEvent.LoadADBegin;
                kernel.ad;
            } else {
                kernel.ad.addEventListener(ADEvent.LoadADBegin, this.onLoadADBegin);
            };
            this._playID = uniqueString;
            if (false){
                5;
                this.id;
                PlayKernelEvent.PlayInitialized;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayInitialized, this.id);
            };
            return;
            /*not popped
            this.id
            */
            /*not popped
            PlayKernelEvent.PlayInitialized
            */
            /*not popped
            kernel
            */
            /*not popped
            this.onLoadADBegin
            */
            /*not popped
            ADEvent.LoadADBegin
            */
            /*not popped
            kernel.ad
            */
            /*not popped
            this.onShowADFinish
            */
            /*not popped
            ADEvent.ShowADFinish
            */
            /*not popped
            kernel.ad
            */
        }
        public function get id():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._playID);
        }
        public function get serverLength():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.video.map.length);
        }
        public function get isNormalVideoStatus():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this.videoStatus == PlayKernelCode.Normal));
        }
        public function get currentServers():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Array = [PlayServer.Quality, PlayServer.Priority, PlayServer.SameIsp];
            var _local2:Array = [this.quality, this.priority, this.sameIsp];
            var _local3:Array = info.video.map;
            var _local4:int = _local1.length;
            var _local5:int;
            if (_local5 >= _local4){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local3 = this.getServers(_local3, _local1[_local5], _local2[_local5]);
            if (_local3.length <= 0){
            } else {
                _local5++;
                //unresolved if
            };
            return (_local3);
        }
        public function getServers(_arg1:Array, _arg2:String, _arg3):Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local7:PlayServer;
            var _local4:Array = [];
            var _local5:int = _arg1.length;
            var _local6:int;
            if (_local6 >= _local5){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local7 = _arg1[_local6];
            if (_local7.get(_arg2) == _arg3){
                if (false){
                    5;
                    _local7;
                    _local4;
                } else {
                    _local4.push(_local7);
                };
            };
            _local6++;
            //unresolved if
            return (_local4);
        }
        public function lowerRequirement():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.sameIsp){
                this._sameisp = false;
            } else {
                if (this.priority > 0){
                    this._sameisp = true;
                    var _local1 = this;
                    var _local2 = (_local1._priority - 1);
                    if (false){
                        5;
                        _local2;
                        _local1;
                    } else {
                        _local1._priority = _local2;
                    };
                } else {
                    return (false);
                };
            };
            return (true);
        }
        public function set quality(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if ((((_arg1 >= 0)) && ((_arg1 <= 2)))){
                this._quality = _arg1;
                this._priority = info.video.highestPriority;
                this._sameisp = true;
            };
        }
        public function get quality():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._quality);
        }
        public function get priority():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._priority);
        }
        public function get sameIsp():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._sameisp);
        }
        public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._duration);
        }
        public function get mediaProxy():MediaProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._mediaProxy);
        }
        public function get mediaGroup():MediaGroup{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._mediaGroup);
        }
        public function get groupNumber():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.map.length);
        }
        public function getGroup(_arg1:int):MediaGroup{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.map[_arg1]);
        }
        public function createGroup(_arg1:String, _arg2:Array):MediaGroup{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            /*switch (){
                    this._preloadType = 0;
                    break;
                    this._preloadType = 1;
                    break;
                    this._preloadType = (((this._retryType == 1)) ? 3 : 2);
                    break;
            }*/;
            var _local3:int = this._preloadTime[this._preloadType];
            if (false){
                5;
                (_local3 + 1);
                this._preloadType;
                this._preloadTime;
            } else {
                this._preloadTime[this._preloadType] = (_local3 + 1);
            };
            this._mediaGroup = new MediaGroup(_arg1, _arg2, this.videoParam);
            if (false){
                5;
                this._mediaGroup;
                this.map;
            } else {
                this.map.push(this._mediaGroup);
            };
            return (this._mediaGroup);
            /*not popped
            this._mediaGroup
            */
            /*not popped
            this.map
            */
            /*not popped
            (_local3 + 1)
            */
            /*not popped
            this._preloadType
            */
            /*not popped
            this._preloadTime
            */
        }
        public function setMedia(_arg1:MediaProxy):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._mediaProxy = _arg1;
            this._duration = _arg1.media.duration;
        }
        public function setPreloadSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._retryType = 0;
        }
        public function retry(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this._retryType == 0){
                if (false){
                    5;
                    _arg1;
                    this;
                } else {
                    this.setRetry(_arg1);
                };
            } else {
                if (false){
                    5;
                    (this._retryType == 1);
                    this;
                } else {
                    this.setRetry((this._retryType == 1));
                };
            };
        }
        private function setRetry(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (_arg1){
                this._retryType = 1;
                var _local2 = this;
                var _local3 = (_local2._unFinishErrorRetryTime + 1);
                if (false){
                    5;
                    _local3;
                    _local2;
                } else {
                    _local2._unFinishErrorRetryTime = _local3;
                };
            } else {
                this._retryType = 2;
                _local2 = this;
                _local3 = (_local2._normalPlayErrorRetryTime + 1);
                if (false){
                    5;
                    _local3;
                    _local2;
                } else {
                    _local2._normalPlayErrorRetryTime = _local3;
                };
            };
        }
        private function get videoParam():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:String = ((("pt=" + this._preloadType) + "&pi=") + this._preloadTime[this._preloadType]);
            if (this._retryType != 0){
                if (this._retryType == 1){
                    _local1 = (_local1 + ("&retry=" + this._unFinishErrorRetryTime));
                } else {
                    _local1 = (_local1 + ("&reconn=" + this._normalPlayErrorRetryTime));
                };
            };
            return (_local1);
        }
        public function get retryType():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._retryType);
        }
        public function get unFinishErrorRetryTime():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._unFinishErrorRetryTime);
        }
        public function get normalPlayErrorRetryTime():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._normalPlayErrorRetryTime);
        }
        public function get beginADLoadStarted():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._beginADLoadStarted);
        }
        public function get beginADFinish():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._beginADFinish);
        }
        public function get endADFinish():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._endADFinish);
        }
        public function get beginADDuration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getDurationLog(ADProxy.BeginAD));
        }
        public function get endADDuration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getDurationLog(ADProxy.EndAD));
        }
        private function onShowADFinish(_arg1:ADEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:String = _arg1.adType;
            /*switch (){
                    if (false){
                        5;
                        this.duration;
                        _local2;
                        this;
                    } else {
                        this.durationLog(_local2, this.duration);
                    };
                    this._beginADFinish = true;
                    break;
                    if (false){
                        5;
                        this.duration;
                        _local2;
                        this;
                    } else {
                        this.durationLog(_local2, this.duration);
                    };
                    this._endADFinish = true;
                    break;
            }*/;
        }
        private function onLoadADBegin(_arg1:ADEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (_arg1.adType == ADProxy.BeginAD){
                this._beginADLoadStarted = true;
            };
        }
        private function getDurationLog(_arg1:String):Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Number = this.durations[_arg1];
            if (isNaN(_local2)){
                _local2 = -1;
            };
            return (_local2);
        }
        private function durationLog(_arg1:String, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (_arg2 > -100){
                if (false){
                    5;
                    _arg2;
                    _arg1;
                    this.durations;
                } else {
                    this.durations[_arg1] = _arg2;
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            PlayProxy
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.info 
