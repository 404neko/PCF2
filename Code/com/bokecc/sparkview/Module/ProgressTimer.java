package com.bokecc.sparkview.Module {
    import flash.events.*;
    import flash.utils.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.view.*;

    public class ProgressTimer extends BasicModule {

        public static const Name:String = "SparkView.ProgressTimer";
        public static const StartTimer:String = "SparkView.StartTimer";

        private var _timer:Timer;

        public function ProgressTimer(){
            super(Name);
        }
        override public function listNotificationInterests():Array{
            return ([StartTimer]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:* = _arg1.getBody();
            switch (_arg1.getName()){
                case StartTimer:
                    this.startTimer((_local2 as Boolean));
                    break;
            };
        }
        private function startTimer(_arg1:Boolean=true):void{
            if (_arg1){
                this.timer.start();
            } else {
                this.timer.stop();
            };
        }
        private function get timer():Timer{
            if (!this._timer){
                this._timer = new Timer(50);
                this._timer.addEventListener(TimerEvent.TIMER, this.onTimer);
            };
            return (this._timer);
        }
        private function onTimer(_arg1:TimerEvent):void{
            sendNotification(ControlViewMediator.SetProgress, {
                position:playKernel.viewPosition,
                bufferEnd:playKernel.bufferEnd
            });
        }

    }
}//package com.bokecc.sparkview.Module 
