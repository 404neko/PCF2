package com.bokecc.sparkview.step {
    import flash.events.*;
    import flash.utils.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.view.*;

    public class PlayReadyStep extends BasicCommand implements ICommand {

        public static const Step_ReadyPlay:String = "SparkView.PlayReadyStep";
        public static const VerifySuccess:String = "PlayReadyStep.VerifySuccess";
        public static const LoadingImgComplete:String = "PlayReadyStep.LoadingImgComplete";
        public static const JSCallBack:String = "PlayReadyStep.JSCallBack";

        private static var readyStatus:Object;
        private static var loadingImgSuccess:Boolean;
        public static var Showed:Boolean = false;

        public static function initStatus():void{
            readyStatus = {};
            readyStatus[VerifySuccess] = false;
            readyStatus[LoadingImgComplete] = false;
            Showed = (loadingImgSuccess = false);
        }

        override public function execute(_arg1:INotification):void{
            var _local2:String = _arg1.getType();
            var _local3:Object = _arg1.getBody();
            switch (_local2){
                case LoadingImgComplete:
                    loadingImgSuccess = _arg1.getBody();
                    break;
                case VerifySuccess:
                    if (Showed){
                        return;
                    };
                    sendNotification(LoadViewMediator.ShowVideoImg, {isShow:false});
                    sendNotification(BigBtnViewMediator.ShowBigPlayButton, false);
                    break;
            };
            this.checkReady(_local2);
        }
        private function checkReady(_arg1:String):void{
            var _local2:Boolean;
            readyStatus[_arg1] = true;
            for each (_local2 in readyStatus) {
                if (!_local2){
                    return;
                };
            };
            if (!loadingImgSuccess){
                this.onShowImgFinish();
            } else {
                this.showLoadImg();
            };
        }
        private function showLoadImg():void{
            showLoading(false);
            sendNotification(LoadViewMediator.ShowLoadingImg, {isShow:true});
            var _local1:Timer = new Timer(2000, 1);
            _local1.addEventListener(TimerEvent.TIMER_COMPLETE, this.onShowImgFinish);
            _local1.start();
        }
        private function onShowImgFinish(_arg1:TimerEvent=null):void{
            showLoading(true);
            Showed = true;
            sendNotification(LoadViewMediator.ShowLoadingImg, {isShow:false});
            sendNotification(StartPlayStep.Step_StartPlay);
        }

    }
}//package com.bokecc.sparkview.step 
