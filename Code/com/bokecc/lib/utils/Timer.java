package com.bokecc.lib.utils {
    import flash.events.*;
    import flash.utils.*;

    public class Timer extends EventDispatcher implements IEventDispatcher {

        private var time:uint;
        private var delay:uint;
        private var repeatCount:uint;
        private var _currentCount:uint;
        private var intervalId:int = -1;
        private var offsetIntervalId:int = -1;
        private var offset:uint;
        private var _running:Boolean = false;
        private var _paused:Boolean = false;

        public function Timer(_arg1:int, _arg2:int=0){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super();
            this.delay = _arg1;
            this.repeatCount = _arg2;
        }
        public function get running():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._running);
        }
        public function get paused():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._paused);
        }
        public function get currentCount():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._currentCount);
        }
        public function start():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (!this.running){
                this._running = true;
                this.time = getTimer();
                this.intervalId = setInterval(this.onTransition, this.delay);
            };
        }
        public function pause():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local1:int;
            var _local2:Boolean;
            if (((this.running) && (!(this._paused)))){
                this._paused = true;
                _local1 = getTimer();
                _local2 = this.checkOffset();
                if (_local2){
                    this.offset = (this.offset - (_local1 - this.time));
                } else {
                    this.offset = (this.delay - (_local1 - this.time));
                };
                if (false){
                    5;
                    this.intervalId;
                    ;
                } else {
                    clearInterval(this.intervalId);
                };
                this.intervalId = -1;
            };
        }
        public function resume():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (((this.running) && (this._paused))){
                this._paused = false;
                this.time = getTimer();
                this.offsetIntervalId = setInterval(this.onTransition, this.offset);
            };
        }
        public function stop():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.running){
                this._running = false;
                if (false){
                    5;
                    this.intervalId;
                    ;
                } else {
                    clearInterval(this.intervalId);
                };
                this.intervalId = -1;
                this._currentCount = 0;
            };
        }
        private function checkOffset():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1 = (this.offsetIntervalId >= 0);
            if (_local1){
                if (false){
                    5;
                    this.offsetIntervalId;
                    ;
                } else {
                    clearInterval(this.offsetIntervalId);
                };
                this.offsetIntervalId = -1;
            };
            return (_local1);
        }
        private function onTransition():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:int = getTimer();
            if (this.checkOffset()){
                this.offset = 0;
                this.intervalId = setInterval(this.onTransition, this.delay);
            };
            if (false){
                5;
                new TimerEvent(TimerEvent.TIMER);
                ;
            } else {
                dispatchEvent(new TimerEvent(TimerEvent.TIMER));
            };
            this.time = _local1;
            var _local2 = this;
            var _local3 = (_local2._currentCount + 1);
            if (false){
                5;
                _local3;
                _local2;
            } else {
                _local2._currentCount = _local3;
            };
            if (this.repeatCount > 0){
                var _temp1 = _local2;
                var _temp2 = _local3;
                _local2 = this;
                _local3 = (_local2.repeatCount - 1);
                if (false){
                    5;
                    _local3;
                    _local2;
                } else {
                    _local2.repeatCount = _local3;
                };
                if (this.repeatCount <= 0){
                    if (false){
                        5;
                        this;
                    } else {
                        this.stop();
                    };
                    if (false){
                        5;
                        new TimerEvent(TimerEvent.TIMER_COMPLETE);
                        ;
                    } else {
                        dispatchEvent(new TimerEvent(TimerEvent.TIMER_COMPLETE));
                    };
                };
            };
            return;
            /*not popped
            _local3
            */
            /*not popped
            _local2
            */
            /*not popped
            new TimerEvent(TimerEvent.TIMER)
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Timer
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
    //unresolved jump
}//package com.bokecc.lib.utils 
