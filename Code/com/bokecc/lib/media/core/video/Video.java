package com.bokecc.lib.media.core.video {
    import flash.events.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.videocore.*;
    import com.bokecc.lib.media.source.*;
    import com.bokecc.lib.media.visual.*;
    import flash.utils.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.lib.data.*;

    public class Video extends VideoBase {

        protected var checkFinishOnSeek:Boolean;
        protected var streamNotFound:Boolean;
        private var seekStart:Number;
        protected var seekEnd:Number = 0;
        private var onceFulled:Boolean;
        private var corePaused:Boolean;
        private var emptyPaused:Boolean;
        private var waitingSeekFull:Boolean;
        private var bufferTimer:Timer;
        private var seekTimer:Timer;

        public function Video(_arg1:IPlaySource, _arg2:IVideoCore=null, _arg3:IVisualization=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.bufferTimer = new Timer(100);
            this.seekTimer = new Timer(500);
            super(_arg1, _arg2, _arg3);
            if (false){
                5;
                this.checkCoreBufferFull;
                TimerEvent.TIMER;
                this.bufferTimer;
            } else {
                this.bufferTimer.addEventListener(TimerEvent.TIMER, this.checkCoreBufferFull);
            };
            if (false){
                5;
                this.resetSeekStart;
                TimerEvent.TIMER;
                this.seekTimer;
            } else {
                this.seekTimer.addEventListener(TimerEvent.TIMER, this.resetSeekStart);
            };
            return;
            /*not popped
            this.resetSeekStart
            */
            /*not popped
            TimerEvent.TIMER
            */
            /*not popped
            this.seekTimer
            */
            /*not popped
            this.checkCoreBufferFull
            */
            /*not popped
            TimerEvent.TIMER
            */
            /*not popped
            this.bufferTimer
            */
        }
        override protected function onFirstMetaData(_arg1:Meta):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            scale = _arg1.scale;
            if (false){
                5;
                _arg1;
                MediaEvent.InfoUpdated;
                ;
            } else {
                dispatch(MediaEvent.InfoUpdated, _arg1);
            };
            if (false){
                5;
                this;
            } else {
                this.checkReady();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            _arg1
            */
            /*not popped
            MediaEvent.InfoUpdated
            */
        }
        override protected function initNetStatusHandler():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                donothing;
                NetStatus.ConnectSuccess;
                ;
            } else {
                addNetStatusHandler(NetStatus.ConnectSuccess, donothing);
            };
            if (false){
                5;
                donothing;
                NetStatus.ConnectClosed;
                ;
            } else {
                addNetStatusHandler(NetStatus.ConnectClosed, donothing);
            };
            if (false){
                5;
                donothing;
                NetStatus.NetworkChange;
                ;
            } else {
                addNetStatusHandler(NetStatus.NetworkChange, donothing);
            };
            if (false){
                5;
                onNetStatus_DisplayUpdated;
                NetStatus.DisplayUpdated;
                ;
            } else {
                addNetStatusHandler(NetStatus.DisplayUpdated, onNetStatus_DisplayUpdated);
            };
            if (false){
                5;
                this.onNetStatus_LoadFinish;
                MediaEvent.LoadFinish;
                ;
            } else {
                addNetStatusHandler(MediaEvent.LoadFinish, this.onNetStatus_LoadFinish);
            };
            if (false){
                5;
                this.onNetStatus_BufferEmpty;
                NetStatus.BufferEmpty;
                ;
            } else {
                addNetStatusHandler(NetStatus.BufferEmpty, this.onNetStatus_BufferEmpty);
            };
            if (false){
                5;
                this.onNetStatus_BufferFull;
                NetStatus.BufferFull;
                ;
            } else {
                addNetStatusHandler(NetStatus.BufferFull, this.onNetStatus_BufferFull);
            };
            if (false){
                5;
                this.onNetStatus_SeekNotify;
                NetStatus.SeekNotify;
                ;
            } else {
                addNetStatusHandler(NetStatus.SeekNotify, this.onNetStatus_SeekNotify);
            };
            if (false){
                5;
                this.onNetStatus_PlayStop;
                NetStatus.PlayStop;
                ;
            } else {
                addNetStatusHandler(NetStatus.PlayStop, this.onNetStatus_PlayStop);
            };
            if (false){
                5;
                this.onNetStatus_StreamNotFound;
                NetStatus.StreamNotFound;
                ;
            } else {
                addNetStatusHandler(NetStatus.StreamNotFound, this.onNetStatus_StreamNotFound);
            };
            return;
            /*not popped
            this.onNetStatus_StreamNotFound
            */
            /*not popped
            NetStatus.StreamNotFound
            */
            /*not popped
            this.onNetStatus_PlayStop
            */
            /*not popped
            NetStatus.PlayStop
            */
            /*not popped
            this.onNetStatus_SeekNotify
            */
            /*not popped
            NetStatus.SeekNotify
            */
            /*not popped
            this.onNetStatus_BufferFull
            */
            /*not popped
            NetStatus.BufferFull
            */
            /*not popped
            this.onNetStatus_BufferEmpty
            */
            /*not popped
            NetStatus.BufferEmpty
            */
            /*not popped
            this.onNetStatus_LoadFinish
            */
            /*not popped
            MediaEvent.LoadFinish
            */
            /*not popped
            onNetStatus_DisplayUpdated
            */
            /*not popped
            NetStatus.DisplayUpdated
            */
            /*not popped
            donothing
            */
            /*not popped
            NetStatus.NetworkChange
            */
            /*not popped
            donothing
            */
            /*not popped
            NetStatus.ConnectClosed
            */
            /*not popped
            donothing
            */
            /*not popped
            NetStatus.ConnectSuccess
            */
        }
        override protected function onConnectionStatus(_arg1:Object):void{
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
                this.setPlayError(false);
            };
            return;
            /*not popped
            false
            */
            /*not popped
            this
            */
        }
        protected function onNetStatus_LoadFinish(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                MediaEvent.LoadFinish;
                ;
            } else {
                dispatch(MediaEvent.LoadFinish);
            };
            return;
            /*not popped
            MediaEvent.LoadFinish
            */
        }
        protected function onNetStatus_BufferEmpty(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.streamNotFound){
                if (false){
                    5;
                    false;
                    this;
                } else {
                    this.setPlayError(false);
                };
            } else {
                if (((!(core.loadFinish)) && (notwaiting))){
                    if (false){
                        5;
                        ;
                    } else {
                        setBuffering();
                    };
                };
            };
        }
        protected function onNetStatus_BufferFull(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.bufferTimer;
            } else {
                this.bufferTimer.start();
            };
            if (false){
                5;
                this;
            } else {
                this.checkCoreBufferFull();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            this.bufferTimer
            */
        }
        protected function onNetStatus_SeekNotify(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.checkFinishOnSeek = false;
        }
        protected function onNetStatus_StreamNotFound(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (waiting){
                if (false){
                    5;
                    false;
                    this;
                } else {
                    this.setPlayError(false);
                };
            } else {
                this.streamNotFound = true;
            };
        }
        protected function onNetStatus_PlayStop(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this;
            } else {
                this.checkFinish();
            };
            return;
            /*not popped
            this
            */
        }
        protected function checkFinish():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Boolean;
            if (((this.corePaused) || (!(isNaN(this.seekStart))))){
                this.checkFinishOnSeek = true;
            } else {
                this.checkFinishOnSeek = false;
                _local1 = (((Math.abs((duration - this.position)) <= 3)) && ((duration > 0)));
                if (((_local1) && (core.loadFinish))){
                    if (false){
                        5;
                        ;
                    } else {
                        setFinished();
                    };
                } else {
                    if (false){
                        5;
                        true;
                        this;
                    } else {
                        this.setPlayError(true);
                    };
                };
            };
        }
        protected function setPlayError(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                {
                    position:this.position,
                    duration:duration,
                    fromFinish:_arg1
                };
                MediaEvent.PlayError;
                ;
            } else {
                dispatch(MediaEvent.PlayError, {
                    position:this.position,
                    duration:duration,
                    fromFinish:_arg1
                });
            };
            return;
            /*not popped
            ((ready) ? if (false){
    5;
    ;
} else {
    setInterrupted();
} : if (false){
    5;
    ;
} else {
    setClosed();
})
            */
            /*not popped
            {
                position:this.position,
                duration:duration,
                fromFinish:_arg1
            }
            */
            /*not popped
            MediaEvent.PlayError
            */
        }
        override public function start():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (closed){
                if (false){
                    5;
                    ;
                } else {
                    setPlaying();
                };
                if (false){
                    5;
                    0;
                    0;
                    ;
                } else {
                    setBufferStart(0, 0);
                };
                if (false){
                    5;
                    this;
                } else {
                    this.nsPlay();
                };
            } else {
                if (((finished) || (interrupted))){
                    if (false){
                        5;
                        0;
                        this;
                    } else {
                        this.seek(0);
                    };
                } else {
                    if (paused){
                        if (false){
                            5;
                            false;
                            this;
                        } else {
                            this.pause(false);
                        };
                    };
                };
            };
        }
        protected function nsPlay(_arg1:String=""):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.waitingSeekFull = false;
            if (false){
                5;
                ;
            } else {
                initWaitingStatus();
            };
            if (false){
                5;
                MediaEvent.LoadStartSoon;
                ;
            } else {
                dispatch(MediaEvent.LoadStartSoon);
            };
            if (false){
                5;
                this.bufferTimer;
            } else {
                this.bufferTimer.stop();
            };
            this.emptyPaused = (this.streamNotFound = (this.corePaused = false));
            if (false){
                5;
                server;
                _arg1;
                file;
                core;
            } else {
                core.play(file, _arg1, server);
            };
            if (false){
                5;
                MediaEvent.LoadStart;
                ;
            } else {
                dispatch(MediaEvent.LoadStart);
            };
            if (false){
                5;
                ;
            } else {
                setLoading();
            };
            return;
            /*not popped
            MediaEvent.LoadStart
            */
            /*not popped
            server
            */
            /*not popped
            _arg1
            */
            /*not popped
            file
            */
            /*not popped
            core
            */
            /*not popped
            this.bufferTimer
            */
            /*not popped
            MediaEvent.LoadStartSoon
            */
        }
        override public function pause(_arg1=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (_arg1 == null){
                _arg1 = playing;
            };
            if (closed){
                if (!_arg1){
                    if (false){
                        5;
                        this;
                    } else {
                        this.start();
                    };
                };
            } else {
                if (((finished) || (interrupted))){
                    if (false){
                        5;
                        0;
                        this;
                    } else {
                        this.seek(0);
                    };
                } else {
                    if (_arg1){
                        if (false){
                            5;
                            0;
                            core;
                        } else {
                            core.volume = 0;
                        };
                        if (false){
                            5;
                            ;
                        } else {
                            setPaused();
                        };
                    } else {
                        if (false){
                            5;
                            ;
                        } else {
                            setPlaying();
                        };
                        if (false){
                            5;
                            volume;
                            core;
                        } else {
                            core.volume = volume;
                        };
                    };
                    if (notwaiting){
                        if (false){
                            5;
                            _arg1;
                            this;
                        } else {
                            this.nsPause(_arg1);
                        };
                    };
                };
            };
        }
        protected function nsPause(_arg1:Boolean=true):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.corePaused = _arg1;
            return;
            /*not popped
            ((_arg1) ? if (false){
    5;
    core;
} else {
    core.pause();
};
core : if (false){
    5;
    core;
} else {
    core.resume();
};
core)
            */
        }
        override protected function onBufferFull(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local2:Boolean;
            var _local3:Boolean;
            if (false){
                5;
                paused;
                this;
            } else {
                this.nsPause(paused);
            };
            if (this.waitingSeekFull){
                this.waitingSeekFull = false;
                _local2 = (_arg1 == Loading);
                _local3 = (_arg1 == Seeking);
                if (((_local2) || (_local3))){
                    if (false){
                        5;
                        {hasBuffer:_local3};
                        MediaEvent.SeekBufferFull;
                        ;
                    } else {
                        dispatch(MediaEvent.SeekBufferFull, {hasBuffer:_local3});
                    };
                };
            };
            super.onBufferFull(_arg1);
            return;
            /*not popped
            paused
            */
            /*not popped
            this
            */
        }
        private function resetSeekStart(_arg1:TimerEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.seekTimer;
            } else {
                this.seekTimer.stop();
            };
            this.seekStart = NaN;
            if (this.checkFinishOnSeek){
                if (false){
                    5;
                    this;
                } else {
                    this.checkFinish();
                };
            };
            return;
            /*not popped
            this.seekTimer
            */
        }
        private function checkCoreBufferFull(_arg1:TimerEvent=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (((isNaN(this.seekStart)) && (((core.loadFinish) || ((bufferLength > bufferTime)))))){
                if (false){
                    5;
                    this.bufferTimer;
                } else {
                    this.bufferTimer.stop();
                };
                if (this.emptyPaused){
                    this.emptyPaused = false;
                    if (false){
                        5;
                        this.corePaused;
                        this;
                    } else {
                        this.nsPause(this.corePaused);
                    };
                };
                if (false){
                    5;
                    this;
                } else {
                    this.realCoreBufferFull();
                };
            } else {
                this.emptyPaused = true;
                if (false){
                    5;
                    core;
                } else {
                    core.pause();
                };
            };
        }
        private function realCoreBufferFull():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.onceFulled = true;
            return;
            /*not popped
            ((ready) ? if (false){
    5;
    ;
} else {
    setNotWaiting();
} : if (false){
    5;
    this;
} else {
    this.checkReady();
};
this)
            */
        }
        private function checkReady():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Number;
            if (((meta) && (this.onceFulled))){
                _local1 = ((SystemUtil.isBelowVersion(11.2)) ? 500 : 50);
                if (false){
                    5;
                    _local1;
                    ;
                } else {
                    setReady(_local1);
                };
            };
        }
        override public function get viewPosition():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (isNaN(this.seekStart)){
                return (this.position);
            };
            return (this.seekEnd);
        }
        override public function get position():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (loading){
                return (this.seekEnd);
            };
            return (((isNaN(core.position)) ? this.seekEnd : Math.max(bufferStart, core.position)));
        }
        override public function get bufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Number;
            var _local2:int;
            var _local3:Number;
            var _local4:Number;
            var _local5:int;
            var _local6:Number;
            var _local7:Number;
            var _local8:Number;
            if (((meta) && (meta.hasKeyframes))){
                _local1 = (bufferStart_filesize + core.bytesLoaded);
                if (_local1 >= meta.filesize){
                    return (duration);
                };
                _local2 = meta.getKeyframeIndex(_local1, false);
                if (_local2 >= 0){
                    _local3 = meta.getTime(_local2);
                    _local4 = meta.getFileposition(_local2);
                    _local5 = (_local2 + 1);
                    if (_local5 < meta.keyframeLength){
                        _local6 = meta.getTime(_local5);
                        _local7 = meta.getFileposition(_local5);
                    } else {
                        _local6 = meta.duration;
                        _local7 = meta.filesize;
                    };
                    if ((((((((_local3 >= 0)) && ((_local6 >= 0)))) && ((_local4 >= 0)))) && ((_local4 >= 0)))){
                        _local8 = ((((_local1 - _local4) * (_local6 - _local3)) / (_local7 - _local4)) + _local3);
                        return (exact(_local8, 3));
                    };
                };
            };
            return (super.bufferEnd);
        }
        override public function seek(_arg1:Number, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:Boolean;
            var _local4:Boolean;
            var _local5:Boolean;
            var _local6:Boolean;
            var _local7:Number;
            var _local8:Number;
            var _local9:Boolean;
            var _local10:Boolean;
            var _local11:int;
            if (((!(closed)) && ((duration > 0)))){
                _local3 = (_arg2 == null);
                _local4 = (_arg2 == true);
                _local5 = ((_local4) || (_local3));
                _local6 = isNaN(this.seekStart);
                if ((((_arg1 < 0)) || ((_arg1 >= duration)))){
                    if (((_local6) && (_local3))){
                        if (_arg1 < 0){
                            _arg1 = 0;
                        } else {
                            if (_arg1 >= duration){
                                if (((meta) && (meta.hasKeyframes))){
                                    _local11 = (meta.keyframeLength - ((meta.canSeekToEnd) ? 2 : 1));
                                    _arg1 = meta.getTime(_local11);
                                } else {
                                    _arg1 = (duration - 1);
                                };
                            };
                        };
                    } else {
                        _arg1 = this.seekEnd;
                    };
                };
                if (finished){
                    if (false){
                        5;
                        ;
                    } else {
                        setPlaying();
                    };
                };
                this.seekEnd = exact(_arg1, 3);
                if (_local6){
                    if (false){
                        5;
                        this.bufferTimer;
                    } else {
                        this.bufferTimer.stop();
                    };
                    this.emptyPaused = false;
                    if (false){
                        5;
                        true;
                        this;
                    } else {
                        this.nsPause(true);
                    };
                    if (false){
                        5;
                        this.seekTimer;
                    } else {
                        this.seekTimer.stop();
                    };
                    this.seekStart = this.position;
                };
                _local7 = bufferStart;
                _local8 = this.bufferEnd;
                _local9 = true;
                _local10 = ((!(interrupted)) && (bufferRange(this.seekEnd)));
                if (false){
                    5;
                    _local10;
                    ;
                } else {
                    enabled(_local10);
                };
                if (_local10){
                    if (false){
                        5;
                        _local3;
                        _local4;
                        this;
                    } else {
                        this.toLocalSeek(_local4, _local3);
                    };
                } else {
                    if (_local5){
                        if (interrupted){
                            if (false){
                                5;
                                ;
                            } else {
                                setPlaying();
                            };
                        };
                        _local9 = this.serverSeek();
                    };
                };
                if (_local5){
                    if (false){
                        5;
                        true;
                        ;
                    } else {
                        enabled(true);
                    };
                    if (_local9){
                        this.waitingSeekFull = true;
                        if (false){
                            5;
                            false;
                            this;
                        } else {
                            this.nsPause(false);
                        };
                        if (false){
                            5;
                            {
                                from:this.seekStart,
                                to:this.seekEnd,
                                hasBuffer:_local10,
                                bufferStart:_local7,
                                bufferEnd:_local8
                            };
                            MediaEvent.SeekComplete;
                            ;
                        } else {
                            dispatch(MediaEvent.SeekComplete, {
                                from:this.seekStart,
                                to:this.seekEnd,
                                hasBuffer:_local10,
                                bufferStart:_local7,
                                bufferEnd:_local8
                            });
                        };
                        if (false){
                            5;
                            this.seekTimer;
                        } else {
                            this.seekTimer.stop();
                        };
                        if (false){
                            5;
                            this.seekTimer;
                        } else {
                            this.seekTimer.start();
                        };
                    };
                };
            };
        }
        protected function toLocalSeek(_arg1:Boolean, _arg2:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (((_arg2) || (!(_arg1)))){
                if (false){
                    5;
                    this;
                } else {
                    this.localSeek();
                };
            };
        }
        protected function localSeek():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                ;
            } else {
                setSeeking();
            };
            if (false){
                5;
                this.seekEnd;
                core;
            } else {
                core.seek(this.seekEnd);
            };
            return;
            /*not popped
            this.seekEnd
            */
            /*not popped
            core
            */
        }
        protected function serverSeek():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                0;
                0;
                ;
            } else {
                setBufferStart(0, 0);
            };
            return (false);
            /*not popped
            0
            */
            /*not popped
            0
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Video
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.core.video 
