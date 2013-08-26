package com.bokecc.platform.playkernel.model.player.monitor {
    import flash.events.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.*;
    import flash.utils.*;
    import com.bokecc.lib.media.core.video.*;

    public class TrafficMonitor extends VideoMonitor {

        public static const Progress:String = "Traffic.Progress";
        public static const RtmpRates:Array = [32, 64, 128];

        private var canSend:Boolean = false;
        private var startTime:int;
        private var curTime:int;
        private var curPlayedTime:Number = 0;
        private var logs:Array;
        private var timer:Timer;
        private var token:Number;
        private var rtmpByte:int;
        private var isRtmp:Boolean;
        private var rtmpRate:uint;

        public function TrafficMonitor(_arg1:IMediaBase=null, _arg2:uint=0, _arg3:IEventDispatcher=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.logs = [];
            this.timer = new Timer(5000);
            super(_arg3);
            if (false){
                5;
                this.count;
                TimerEvent.TIMER;
                this.timer;
            } else {
                this.timer.addEventListener(TimerEvent.TIMER, this.count);
            };
            this.rtmpRate = _arg2;
            if (_arg1){
                if (false){
                    5;
                    _arg1;
                    this;
                } else {
                    this.target(_arg1);
                };
            };
            return;
            /*not popped
            this.count
            */
            /*not popped
            TimerEvent.TIMER
            */
            /*not popped
            this.timer
            */
        }
        override public function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
            if (false){
                5;
                this.onPlayStatus;
                MediaEvent.PlayStatus;
                ;
            } else {
                setEventHandler(MediaEvent.PlayStatus, this.onPlayStatus);
            };
            if (false){
                5;
                this.onLoadStartSoon;
                MediaEvent.LoadStartSoon;
                ;
            } else {
                setEventHandler(MediaEvent.LoadStartSoon, this.onLoadStartSoon);
            };
            if (false){
                5;
                this.onLoadStart;
                MediaEvent.LoadStart;
                ;
            } else {
                setEventHandler(MediaEvent.LoadStart, this.onLoadStart);
            };
            if (false){
                5;
                this.onLoadFinish;
                MediaEvent.LoadFinish;
                ;
            } else {
                setEventHandler(MediaEvent.LoadFinish, this.onLoadFinish);
            };
            return;
            /*not popped
            this.onLoadFinish
            */
            /*not popped
            MediaEvent.LoadFinish
            */
            /*not popped
            this.onLoadStart
            */
            /*not popped
            MediaEvent.LoadStart
            */
            /*not popped
            this.onLoadStartSoon
            */
            /*not popped
            MediaEvent.LoadStartSoon
            */
            /*not popped
            this.onPlayStatus
            */
            /*not popped
            MediaEvent.PlayStatus
            */
        }
        override public function target(_arg1:IMediaBase):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.target(_arg1);
            this.isRtmp = (_arg1 is RTMP);
        }
        public function start(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.canSend = _arg1;
            if (_arg1){
                if (loadFinish){
                    if (false){
                        5;
                        this;
                    } else {
                        this.send();
                    };
                };
            } else {
                if (false){
                    5;
                    this;
                } else {
                    this.stopTimer();
                };
            };
        }
        protected function onPlayStatus():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.isRtmp){
            };
        }
        protected function onLoadStartSoon():void{
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
                this.stopTimer();
            };
            return;
            /*not popped
            this
            */
        }
        protected function onLoadStart():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.curPlayedTime = media.position;
            if (false){
                5;
                this;
            } else {
                this.startTimer();
            };
            return;
            /*not popped
            this
            */
        }
        protected function onLoadFinish():void{
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
                this.stopTimer();
            };
            return;
            /*not popped
            this
            */
        }
        private function stopTimer():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (!isNaN(this.token)){
                if (false){
                    5;
                    this;
                } else {
                    this.count();
                };
            };
            if (false){
                5;
                this.timer;
            } else {
                this.timer.stop();
            };
            this.rtmpByte = 0;
            return;
            /*not popped
            this.timer
            */
        }
        private function startTimer():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.startTime = getTimer();
            this.token = int((Math.random() * 1000000));
            if (false){
                5;
                this.timer;
            } else {
                this.timer.start();
            };
            return;
            /*not popped
            this.timer
            */
        }
        private function count(_arg1:TimerEvent=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local4:Number;
            var _local5:Number;
            var _local2:int = (getTimer() - this.curTime);
            this.rtmpByte = (this.rtmpByte + ((RtmpRates[this.rtmpRate] * 0x0400) * (media.position - this.curPlayedTime)));
            this.curTime = (this.curTime + _local2);
            this.curPlayedTime = media.position;
            var _local3:int = ((this.isRtmp) ? this.rtmpByte : currentByteLoaded);
            if (_local3 > 0){
                _local4 = (this.curTime - this.startTime);
                _local5 = Math.round((_local3 / _local4));
                if (false){
                    5;
                    new TrafficInfo(this.token, _local3, _local4, _local5);
                    this.logs;
                } else {
                    this.logs.push(new TrafficInfo(this.token, _local3, _local4, _local5));
                };
                if (false){
                    5;
                    this;
                } else {
                    this.send();
                };
            } else {
                this.startTime = this.curTime;
            };
        }
        private function send():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:TrafficInfo;
            if (this.canSend){
                if (this.logs.length <= 0){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local1 = this.logs.shift();
                //unresolved if
                if (false){
                    5;
                    new MediaEvent(Progress, _local1);
                    ;
                } else {
                    dispatchEvent(new MediaEvent(Progress, _local1));
                };
                //unresolved if
            };
        }

        if (37 == 34){
            return;
            /*not popped
            TrafficMonitor
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.player.monitor 
