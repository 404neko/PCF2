package com.bokecc.platform.playkernel.model.player {
    import flash.events.*;
    import com.bokecc.lib.media.*;
    import flash.utils.*;

    public class Preloader extends EventDispatcher {

        public static const SpeedTesting:String = "_Preloader.SpeedTesting";
        public static const Buffering:String = "_Preloader.Buffering";
        public static const Seeking:String = "_Preloader.Seeking";
        public static const Stoped:String = "_Preloader.Stoped";

        private var status:String;
        private var speedTestTimer:Timer;
        private var startPoint:Number = 0;
        private var mediaGroup:MediaGroup;
        private var preloadResult:MediaProxy;

        public function Preloader(_arg1:MediaGroup, _arg2:Number=0){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this.mediaGroup = _arg1;
            this.startPoint = _arg2;
            this.status = Stoped;
            this.speedTestTimer = new Timer(1000);
            if (false){
                5;
                this.onSpeedTesting;
                TimerEvent.TIMER;
                this.speedTestTimer;
            } else {
                this.speedTestTimer.addEventListener(TimerEvent.TIMER, this.onSpeedTesting);
            };
            return;
            /*not popped
            this.onSpeedTesting
            */
            /*not popped
            TimerEvent.TIMER
            */
            /*not popped
            this.speedTestTimer
            */
        }
        public function get group():MediaGroup{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.mediaGroup);
        }
        public function get result():MediaProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.preloadResult);
        }
        public function get running():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (!((this.status == Stoped)));
        }
        public function get bufferStart():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.startPoint);
        }
        public function get bufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.result){
                return (Math.max(this.result.media.bufferEnd, this.bufferStart));
            };
            return (this.bufferStart);
        }
        public function get bufferLength():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Number;
            var _local3:Number;
            var _local4:Boolean;
            var _local5:Boolean;
            var _local1:Number = 0;
            if (this.preloadResult){
                _local2 = this.preloadResult.media.bufferTime;
                _local3 = Math.min(_local2, this.preloadResult.media.bufferLength);
                _local4 = (this.status == Seeking);
                _local5 = (this.status == Buffering);
                if (this.startPoint > 0){
                    if (_local5){
                        _local1 = (_local3 * 0.5);
                    } else {
                        if (_local4){
                            _local1 = ((_local2 * 0.5) + (_local3 * 0.5));
                        } else {
                            _local1 = _local2;
                        };
                    };
                } else {
                    if (_local5){
                        _local1 = _local3;
                    } else {
                        _local1 = _local2;
                    };
                };
            };
            return (_local1);
        }
        public function destroy():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.running){
                if (false){
                    5;
                    MediaProxy.Status_Break;
                    this;
                } else {
                    this.stopAllOther(MediaProxy.Status_Break);
                };
                if (false){
                    5;
                    true;
                    this;
                } else {
                    this.setStoped(true);
                };
                if (false){
                    5;
                    null;
                    false;
                    this.mediaGroup;
                } else {
                    this.mediaGroup.preloadFinish(false, null);
                };
            };
        }
        public function preload():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.group;
                this;
            } else {
                this.setSpeedTesting(this.group);
            };
            return;
            /*not popped
            this.group
            */
            /*not popped
            this
            */
        }
        private function stopAllOther(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local2:int;
            var _local3:int;
            var _local4:MediaProxy;
            if (false){
                5;
                this.speedTestTimer;
            } else {
                this.speedTestTimer.stop();
            };
            if (this.mediaGroup != null){
                _local2 = this.mediaGroup.length;
                _local3 = 0;
                if (_local3 >= _local2){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local4 = this.mediaGroup.getMediaProxy(_local3);
                if (_local4 != this.preloadResult){
                    if (false){
                        5;
                        this.onMediaEvent;
                        MediaEvent.ALL;
                        _local4;
                    } else {
                        _local4.removeEventListener(MediaEvent.ALL, this.onMediaEvent);
                    };
                    if (_local4.status == MediaProxy.Status_None){
                        if (false){
                            5;
                            _arg1;
                            _local4;
                        } else {
                            _local4.status = _arg1;
                        };
                    };
                    if (false){
                        5;
                        _local4.media;
                    } else {
                        _local4.media.stop();
                    };
                };
                _local3++;
                //unresolved if
            };
            return;
            /*not popped
            this.speedTestTimer
            */
        }
        private function setSpeedTesting(_arg1:MediaGroup):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:int;
            var _local4:MediaProxy;
            this.status = SpeedTesting;
            if (false){
                5;
                _arg1;
                this;
            } else {
                this.mediaGroup = _arg1;
            };
            if (false){
                5;
                _arg1;
            } else {
                _arg1.preloadBegin();
            };
            var _local2:int = _arg1.length;
            if (_local2 > 0){
                if (false){
                    5;
                    this.speedTestTimer;
                } else {
                    this.speedTestTimer.start();
                };
                _local3 = 0;
                if (_local3 >= _local2){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local4 = _arg1.getMediaProxy(_local3);
                if (false){
                    5;
                    this.onMediaEvent;
                    MediaEvent.ALL;
                    _local4;
                } else {
                    _local4.addEventListener(MediaEvent.ALL, this.onMediaEvent);
                };
                if (false){
                    5;
                    _local4;
                } else {
                    _local4.start();
                };
                _local3++;
                //unresolved if
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            _arg1
            */
            /*not popped
            this
            */
        }
        private function setBuffering(_arg1:MediaProxy):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.preloadResult = _arg1;
            if (false){
                5;
                MediaProxy.Status_Success;
                this.preloadResult;
            } else {
                this.preloadResult.status = MediaProxy.Status_Success;
            };
            if (false){
                5;
                new PreloadEvent(PreloadEvent.SpeedTestSuccess);
                ;
            } else {
                dispatchEvent(new PreloadEvent(PreloadEvent.SpeedTestSuccess));
            };
            if (false){
                5;
                MediaProxy.Status_None;
                this;
            } else {
                this.stopAllOther(MediaProxy.Status_None);
            };
            this.status = Buffering;
            if (this.preloadResult.media.ready){
                if (false){
                    5;
                    this;
                } else {
                    this.setSeeking();
                };
            };
            return;
            /*not popped
            MediaProxy.Status_None
            */
            /*not popped
            this
            */
            /*not popped
            new PreloadEvent(PreloadEvent.SpeedTestSuccess)
            */
            /*not popped
            MediaProxy.Status_Success
            */
            /*not popped
            this.preloadResult
            */
        }
        private function setSeeking():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.status = Seeking;
            if (false){
                5;
                this.startPoint;
                this.preloadResult.media;
            } else {
                this.preloadResult.media.seek(this.startPoint);
            };
            return;
            /*not popped
            this.startPoint
            */
            /*not popped
            this.preloadResult.media
            */
        }
        private function setFinish():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                false;
                this;
            } else {
                this.setStoped(false);
            };
            if (false){
                5;
                this.result;
                true;
                this.mediaGroup;
            } else {
                this.mediaGroup.preloadFinish(true, this.result);
            };
            if (false){
                5;
                new PreloadEvent(PreloadEvent.Success);
                ;
            } else {
                dispatchEvent(new PreloadEvent(PreloadEvent.Success));
            };
            return;
            /*not popped
            new PreloadEvent(PreloadEvent.Success)
            */
            /*not popped
            this.result
            */
            /*not popped
            true
            */
            /*not popped
            this.mediaGroup
            */
            /*not popped
            false
            */
            /*not popped
            this
            */
        }
        private function setStoped(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.status = Stoped;
            if (this.preloadResult){
                if (false){
                    5;
                    this.onMediaEvent;
                    MediaEvent.ALL;
                    this.preloadResult;
                } else {
                    this.preloadResult.removeEventListener(MediaEvent.ALL, this.onMediaEvent);
                };
                if (_arg1){
                    if (false){
                        5;
                        this.preloadResult.media;
                    } else {
                        this.preloadResult.media.stop();
                    };
                };
            };
        }
        private function onMediaEvent(_arg1:MediaEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:MediaProxy;
            if (!this.running){
                return;
            };
            var _local2:String = (_arg1.code + this.status);
            /*switch (){
                    if (false){
                        5;
                        this;
                    } else {
                        this.setSeeking();
                    };
                    break;
                    if (false){
                        5;
                        this;
                    } else {
                        this.setFinish();
                    };
                    break;
                    _local3 = (_arg1.target as MediaProxy);
                    if (false){
                        5;
                        MediaProxy.Status_Error;
                        _local3;
                    } else {
                        _local3.status = MediaProxy.Status_Error;
                    };
                    if (this.mediaGroup.isAllDisabled){
                        if (false){
                            5;
                            true;
                            this;
                        } else {
                            this.setStoped(true);
                        };
                        if (false){
                            5;
                            null;
                            false;
                            this.mediaGroup;
                        } else {
                            this.mediaGroup.preloadFinish(false, null);
                        };
                        if (false){
                            5;
                            new PreloadEvent(PreloadEvent.Failed);
                            ;
                        } else {
                            dispatchEvent(new PreloadEvent(PreloadEvent.Failed));
                        };
                    };
                    break;
            }*/;
        }
        private function onSpeedTesting(_arg1:TimerEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local3:MediaProxy;
            var _local6:MediaProxy;
            var _local7:Number;
            if (this.status != SpeedTesting){
                return;
            };
            var _local2:Number = 0;
            var _local4:int = this.mediaGroup.length;
            var _local5:int;
            if (_local5 >= _local4){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local6 = this.mediaGroup.getMediaProxy(_local5);
            _local7 = _local6.byteLoaded;
            if (_local7 > _local2){
                _local2 = _local7;
                _local3 = _local6;
            };
            _local5++;
            //unresolved if
            if ((((_local2 > 0)) && (!((_local3 == null))))){
                if (false){
                    5;
                    _local3;
                    this;
                } else {
                    this.setBuffering(_local3);
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            Preloader
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.player 
