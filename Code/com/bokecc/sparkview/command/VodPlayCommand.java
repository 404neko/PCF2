package com.bokecc.sparkview.command {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.proxy.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.Module.*;

    public class VodPlayCommand extends BasicCommand implements ICommand {

        public static const VODPlayHandler:String = "SparkView.VodPlayCommand";

        override public function execute(_arg1:INotification):void{
            var _local2:VodAPIProxy = (facade.retrieveProxy(VodAPIProxy.Name) as VodAPIProxy);
            var _local3:Boolean = _arg1.getBody();
            if (_local3){
                if (((_local2.enable) || ((_local2.freetime == -1)))){
                    this.checkStartPlay();
                } else {
                    if (_local2.freetime > 0){
                        facade.registerMediator(new VodVerify());
                        this.checkStartPlay();
                    } else {
                        alert(_local2.message);
                        this.invalid();
                    };
                };
            } else {
                alert("获取信息失败");
                this.invalid();
            };
        }
        private function checkStartPlay():void{
            (facade.retrieveProxy(JSControlProxy.Name) as JSControlProxy).onPlayerReady();
            if (kernelProxy.autostart){
                sendNotification(PlayReadyStep.Step_ReadyPlay, null, PlayReadyStep.VerifySuccess);
            } else {
                showLoading(false);
                sendNotification(BigBtnViewMediator.ShowBigPlayButton, true);
                sendNotification(LoadViewMediator.ShowVideoImg, {
                    isShow:true,
                    url:videoInfo.imgPath
                });
            };
        }
        private function invalid():void{
            kernelProxy.allowOperate = false;
            sendNotification(ControlViewMediator.ControlBarEnabled, false);
            sendNotification(BigBtnViewMediator.AlwaysHidePlayButton, true);
        }

    }
}//package com.bokecc.sparkview.command 
