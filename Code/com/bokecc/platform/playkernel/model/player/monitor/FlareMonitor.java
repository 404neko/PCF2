package com.bokecc.platform.playkernel.model.player.monitor {
    import flash.events.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.*;
    import flash.utils.*;

    public class FlareMonitor extends VideoMonitor {

        public static const FirstLoadStart:String = "FlareMonitor.Position.FirstLoadStart";
        public static const LoadStart:String = "FlareMonitor.Position.LoadStart";
        public static const Ready:String = "FlareMonitor.Position.Ready";
        public static const BufferEmpty:String = "FlareMonitor.Position.BufferEmpty";
        public static const BufferFull:String = "FlareMonitor.Position.BufferFull";
        public static const SpeedTestFinish:String = "FlareMonitor.Position.SpeedTestFinish";
        public static const ReadyDuration:String = "FlareMonitor.Duration.ReadyDuration";
        public static const BufferDuration:String = "FlareMonitor.Duration.BufferDuration";
        public static const SpeedTestDuration:String = "FlareMonitor.Duration.SpeedTestDuration";

        private var durations:Object;
        private var positions:Object;
        private var speedTestStatus:int;

        public function FlareMonitor(_arg1:IMediaBase=null, _arg2:IEventDispatcher=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg2);
            if (_arg1){
                if (false){
                    5;
                    _arg1;
                    ;
                } else {
                    target(_arg1);
                };
            };
        }
        override public function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
            this.durations = {};
            this.positions = {};
            if (false){
                5;
                this.onReady;
                MediaEvent.Ready;
                ;
            } else {
                setEventHandler(MediaEvent.Ready, this.onReady);
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
                this.onBufferEmpty;
                MediaEvent.BufferEmpty;
                ;
            } else {
                setEventHandler(MediaEvent.BufferEmpty, this.onBufferEmpty);
            };
            return;
            /*not popped
            this.onBufferEmpty
            */
            /*not popped
            MediaEvent.BufferEmpty
            */
            /*not popped
            this.onLoadStart
            */
            /*not popped
            MediaEvent.LoadStart
            */
            /*not popped
            this.onReady
            */
            /*not popped
            MediaEvent.Ready
            */
        }
        override protected function onMediaEvent(_arg1:MediaEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.onMediaEvent(_arg1);
            if (false){
                5;
                _arg1;
                ;
            } else {
                dispatchEvent(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
        }
        public function setSpeedTestFinish(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.speedTestStatus = _arg1;
            if (false){
                5;
                SpeedTestFinish;
                this;
            } else {
                this.setPosition(SpeedTestFinish);
            };
            if (false){
                5;
                SpeedTestFinish;
                FirstLoadStart;
                SpeedTestDuration;
                this;
            } else {
                this.setDuration(SpeedTestDuration, FirstLoadStart, SpeedTestFinish);
            };
            return;
            /*not popped
            SpeedTestFinish
            */
            /*not popped
            FirstLoadStart
            */
            /*not popped
            SpeedTestDuration
            */
            /*not popped
            this
            */
            /*not popped
            SpeedTestFinish
            */
            /*not popped
            this
            */
        }
        public function getSpeedTestStatus():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.speedTestStatus);
        }
        public function getPosition(_arg1:String):FlarePosition{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.positions[_arg1]);
        }
        public function getDuration(_arg1:String):FlareDuration{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.durations[_arg1]);
        }
        private function setPosition(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                new FlarePosition(getTimer(), currentByteLoaded);
                _arg1;
                this.positions;
            } else {
                this.positions[_arg1] = new FlarePosition(getTimer(), currentByteLoaded);
            };
            return;
            /*not popped
            new FlarePosition(getTimer(), currentByteLoaded)
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.positions
            */
        }
        private function setDuration(_arg1:String, _arg2:String, _arg3:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local4:FlarePosition = this.getPosition(_arg2);
            var _local5:FlarePosition = this.getPosition(_arg3);
            if (((_local4) && (_local5))){
                if (false){
                    5;
                    new FlareDuration(_local4, _local5);
                    _arg1;
                    this.durations;
                } else {
                    this.durations[_arg1] = new FlareDuration(_local4, _local5);
                };
            };
        }
        private function onLoadStart():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:FlarePosition = this.getPosition(FirstLoadStart);
            if (_local1 == null){
                if (false){
                    5;
                    FirstLoadStart;
                    this;
                } else {
                    this.setPosition(FirstLoadStart);
                };
            };
            if (false){
                5;
                LoadStart;
                this;
            } else {
                this.setPosition(LoadStart);
            };
            return;
            /*not popped
            LoadStart
            */
            /*not popped
            this
            */
        }
        private function onReady():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                Ready;
                this;
            } else {
                this.setPosition(Ready);
            };
            if (false){
                5;
                Ready;
                FirstLoadStart;
                ReadyDuration;
                this;
            } else {
                this.setDuration(ReadyDuration, FirstLoadStart, Ready);
            };
            return;
            /*not popped
            Ready
            */
            /*not popped
            FirstLoadStart
            */
            /*not popped
            ReadyDuration
            */
            /*not popped
            this
            */
            /*not popped
            Ready
            */
            /*not popped
            this
            */
        }
        private function onBufferEmpty():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                BufferEmpty;
                this;
            } else {
                this.setPosition(BufferEmpty);
            };
            if (false){
                5;
                this.onBufferFull;
                MediaEvent.BufferFull;
                ;
            } else {
                setEventHandler(MediaEvent.BufferFull, this.onBufferFull);
            };
            return;
            /*not popped
            this.onBufferFull
            */
            /*not popped
            MediaEvent.BufferFull
            */
            /*not popped
            BufferEmpty
            */
            /*not popped
            this
            */
        }
        private function onBufferFull():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.getPosition(BufferEmpty) != null){
                if (false){
                    5;
                    MediaEvent.BufferEmpty;
                    ;
                } else {
                    delEventHandler(MediaEvent.BufferEmpty);
                };
                if (false){
                    5;
                    MediaEvent.BufferFull;
                    ;
                } else {
                    delEventHandler(MediaEvent.BufferFull);
                };
                if (false){
                    5;
                    BufferFull;
                    this;
                } else {
                    this.setPosition(BufferFull);
                };
                if (false){
                    5;
                    BufferFull;
                    BufferEmpty;
                    BufferDuration;
                    this;
                } else {
                    this.setDuration(BufferDuration, BufferEmpty, BufferFull);
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            FlareMonitor
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
