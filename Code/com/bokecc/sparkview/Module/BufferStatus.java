package com.bokecc.sparkview.Module {
    import flash.events.*;
    import flash.utils.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.proxy.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.command.*;
    import com.bokecc.lib.data.*;

    public class BufferStatus extends BasicModule {

        public static const Name:String = "";
        public static const BufferEmpty:String = "SparkView.BufferEmpty";
        public static const BufferFull:String = "SparkView.BufferFull";
        public static const qualitys:Array = [linkText("普通版", (PanelEventHandler.TipSetQuality + 0)), linkText("清晰版", (PanelEventHandler.TipSetQuality + 1)), linkText("高清版", (PanelEventHandler.TipSetQuality + 2))];

        private var showCount:int = 0;
        private var _lt:Timer;
        private var _bf:Timer;
        private var record:Boolean;

        public function BufferStatus(){
            super(Name);
        }
        public static function linkText(_arg1:String, _arg2:String):String{
            return ((((("<a href='event:" + _arg2) + "'><font color='#e77b21'>") + _arg1) + "</font></a>"));
        }

        override public function listNotificationInterests():Array{
            return ([BufferEmpty, BufferFull, ControlViewMediator.SetPlayStatus]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:String = _arg1.getName();
            var _local3:Object = _arg1.getBody();
            switch (_local2){
                case BufferEmpty:
                    this.record = toBoolean(String(_local3), true);
                    this.startTimer(true);
                    break;
                case BufferFull:
                    this.showLoading(false);
                    sendNotification(PanelViewMediator.ShowTipPanel, {
                        msg:"",
                        time:-1,
                        isShow:false
                    });
                    break;
                case ControlViewMediator.SetPlayStatus:
                    if (!_local3["playing"]){
                        sendNotification(PanelViewMediator.ShowTipPanel, {
                            msg:"",
                            time:-1,
                            isShow:false
                        });
                    };
                    break;
            };
        }
        private function startTimer(_arg1:Boolean=true):void{
            if (_arg1){
                this.bufferTimer.start();
            } else {
                this.bufferTimer.reset();
            };
        }
        private function get bufferTimer():Timer{
            if (this._bf == null){
                this._bf = new Timer(1000);
            };
            this._bf.addEventListener(TimerEvent.TIMER, this.onShowBufferTip);
            return (this._bf);
        }
        private function onShowBufferTip(_arg1:TimerEvent):void{
            if ((((this.bufferTimer.currentCount == 3)) && (!(this.loadingTimer.running)))){
                this.loadingTimer.start();
            } else {
                if ((((((this.bufferTimer.currentCount == 5)) && (!(playKernel.stopped)))) && (this.record))){
                    sendNotification(PanelViewMediator.ShowTipPanel, {
                        msg:this.getTipMsg(),
                        time:-1,
                        isShow:true
                    });
                    this.startTimer(false);
                    this.showCount++;
                };
            };
        }
        private function getTipMsg():String{
            var _local1:SharedObjectProxy = (facade.retrieveProxy(SharedObjectProxy.Name) as SharedObjectProxy);
            var _local2 = (("<font color='#FFFFFF'>目前您的网速不佳，请</font>" + PanelViewMediator.linkText("暂停", OperateEventHandler.TipToPause)) + "<font color='#FFFFFF'>一会</font>");
            var _local3:int = (((_local1.getQuality() == null)) ? playKernel.quality : int(_local1.getQuality()));
            var _local4 = "<font color='#FFFFFF'>(或选择</font>";
            var _local5:Boolean;
            while (_local3 > 0) {
                var _temp1 = _local3;
                _local3 = (_local3 - 1);
                if (videoInfo.getQualityValidity(_temp1)){
                    _local4 = (_local4 + qualitys[_local3]);
                    if (videoInfo.getQualityValidity((_local3 - 1))){
                        _local4 = (_local4 + "<font color='#FFFFFF'>，</font>");
                    };
                    _local5 = true;
                };
            };
            if (_local5){
                _local2 = (_local2 + (_local4 + "<font color='#FFFFFF'>)</font>"));
            };
            if (((user.allowDownload) && ((this.showCount > 3)))){
                _local2 = (_local2 + (("<font color='#FFFFFF'>或尝试</font>" + linkText("下载", PanelEventHandler.DownLoadVideo)) + "<font color='#FFFFFF'>播放</font>"));
            };
            var _local6:String = PlayAnalyse.Pause;
            _local6 = ((_local5) ? ((_local6 + ",") + PlayAnalyse.Definition) : _local6);
            sendNotification(PlayAnalyse.SendReveal, _local6);
            return (_local2);
        }
        private function get loadingTimer():Timer{
            if (this._lt == null){
                this._lt = new Timer(100);
                this._lt.addEventListener(TimerEvent.TIMER, this.onShowLoading);
            };
            return (this._lt);
        }
        private function onShowLoading(_arg1:TimerEvent=null):void{
            var _local2:Number = playKernel.bufferLength;
            var _local3:Number = playKernel.bufferTime;
            var _local4 = (int(((_local2 / _local3) * 100)) + "%");
            var _local5 = (_local2 < _local3);
            this.showLoading(_local5, _local4);
        }
        override protected function showLoading(_arg1:Boolean, _arg2:String=""):void{
            super.showLoading(_arg1, _arg2);
            if (!_arg1){
                this.loadingTimer.stop();
                this.startTimer(false);
            };
        }

    }
}//package com.bokecc.sparkview.Module 
