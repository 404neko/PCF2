package com.bokecc.sparkview.Module {
    import flash.events.*;
    import flash.utils.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.proxy.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.command.*;

    public class RecordTime extends BasicModule {

        public static const Name:String = "RecordTime.Name";
        public static const ShowRecordTimeTip:String = "SparkView.ShowRecordTimeTip";
        public static const RecordTime:String = "SparkView.RecordTime";
        public static const ClearRecordTime:String = "SparkView.ClearRecordTime";

        private var _timer:Timer;

        public function RecordTime(){
            super(Name);
        }
        private function get sharedProxy():SharedObjectProxy{
            return ((facade.retrieveProxy(SharedObjectProxy.Name) as SharedObjectProxy));
        }
        override public function onRegister():void{
            this._timer = new Timer(1000);
            this._timer.addEventListener(TimerEvent.TIMER, this.onTimer);
        }
        override public function listNotificationInterests():Array{
            return ([ShowRecordTimeTip, RecordTime, ClearRecordTime]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:Object = _arg1.getBody();
            switch (_arg1.getName()){
                case ShowRecordTimeTip:
                    this.showTipPanel();
                    break;
                case RecordTime:
                    if (Boolean(_local2)){
                        this._timer.start();
                    } else {
                        this._timer.stop();
                    };
                    break;
                case ClearRecordTime:
                    this.sharedProxy.recordPlayTime(param.vid, 0);
                    break;
            };
        }
        private function showTipPanel():void{
            var _local1:Number = this.sharedProxy.getPlayTime(param.vid);
            if ((((_local1 > 0)) && (!(user.isVod)))){
                sendNotification(PanelViewMediator.ShowTipPanel, {
                    msg:this.getTipMsg(_local1),
                    time:6000,
                    isShow:true
                });
                sendNotification(PlayAnalyse.SendReveal, PlayAnalyse.Replay);
            };
        }
        private function getTipMsg(_arg1:Number):String{
            var _local2:String = ((("<font color='#FFFFFF'>已从上次结束" + this.toTimeString(_arg1)) + "处开始播放,</font>") + PanelViewMediator.linkText("重新观看", PanelEventHandler.ReplayCommand));
            return (_local2);
        }
        private function toTimeString(_arg1:Number):String{
            var _local2:Number = Math.floor((_arg1 / 60));
            var _local3:Number = Math.floor((_arg1 % 60));
            return (((this.addZero(_local2) + ":") + this.addZero(_local3)));
        }
        private function addZero(_arg1:Number):String{
            var _local2:String = _arg1.toString();
            if (_arg1 < 10){
                _local2 = ("0" + _local2);
            };
            return (_local2);
        }
        private function onTimer(_arg1:TimerEvent):void{
            this.sharedProxy.recordPlayTime(param.vid, playKernel.position);
        }

    }
}//package com.bokecc.sparkview.Module 
