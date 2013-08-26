package com.bokecc.platform.playkernel.module.logger.items.flare {
    import flash.events.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.lib.utils.*;

    public class PlayProgressLog extends FlareItem {

        public static const NAME:String = "Flare.PlayProgressLog";

        private var timer:Timer;
        private var position:Number;

        public function PlayProgressLog(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME);
        }
        override public function get events():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ([PlayKernelEvent.PlayRealStart, MediaEvent.PlayStatus, MediaEvent.WaitingStatus]);
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.timer){
                if (false){
                    5;
                    this.sendLog;
                    TimerEvent.TIMER;
                    this.timer;
                } else {
                    this.timer.removeEventListener(TimerEvent.TIMER, this.sendLog);
                };
                if (false){
                    5;
                    this.timer;
                } else {
                    this.timer.stop();
                };
            };
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            /*switch (){
                    if (false){
                        5;
                        this;
                    } else {
                        this.startTimer();
                    };
                    break;
                    if (false){
                        5;
                        !((_arg2 == MediaBase.Playing));
                        this;
                    } else {
                        this.pauseTimer(!((_arg2 == MediaBase.Playing)));
                    };
                    break;
                    if (false){
                        5;
                        !((_arg2 == MediaBase.NotWaiting));
                        this;
                    } else {
                        this.pauseTimer(!((_arg2 == MediaBase.NotWaiting)));
                    };
                    break;
            }*/;
        }
        private function startTimer():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.timer == null){
                this.timer = new Timer((1000 * 10));
                if (false){
                    5;
                    this.sendLog;
                    TimerEvent.TIMER;
                    this.timer;
                } else {
                    this.timer.addEventListener(TimerEvent.TIMER, this.sendLog);
                };
            };
            if (false){
                5;
                this.timer;
            } else {
                this.timer.stop();
            };
            if (false){
                5;
                this.timer;
            } else {
                this.timer.start();
            };
            if (false){
                5;
                this;
            } else {
                this.sendLog();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            this.timer
            */
            /*not popped
            this.timer
            */
        }
        private function pauseTimer(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.timer == null){
                return;
            };
            return;
            /*not popped
            ((_arg1) ? if (false){
    5;
    this.timer;
} else {
    this.timer.pause();
};
this.timer : if (false){
    5;
    this.timer;
} else {
    this.timer.resume();
};
this.timer)
            */
        }
        private function sendLog(_arg1:TimerEvent=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Number = data.play_position;
            if (this.position != _local2){
                this.position = _local2;
                if (false){
                    5;
                    ;
                } else {
                    initURL();
                };
                if (false){
                    5;
                    77;
                    ;
                } else {
                    addFlareParam(77);
                };
                if (false){
                    5;
                    this.position;
                    "play_position";
                    ;
                } else {
                    addParam("play_position", this.position);
                };
                if (false){
                    5;
                    data.video_duration;
                    "video_duration";
                    ;
                } else {
                    addParam("video_duration", data.video_duration);
                };
                if (false){
                    5;
                    ;
                } else {
                    send();
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            PlayProgressLog
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.module.logger.items.flare 
