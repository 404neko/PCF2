package com.bokecc.sparkview.step {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.proxy.*;
    import flash.net.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.lib.data.*;

    public class VerifyStep extends BasicCommand implements ICommand {

        public static const Step_Verify:String = "SparkView.VerifyStep";

        override public function execute(_arg1:INotification):void{
            PlayReadyStep.Showed = false;
            showLoading(true);
            sendNotification(PanelViewMediator.HidenAllPanel);
            if (this.checkPlayProtected()){
                this.kernelEvent.status = "当前为保护播放";
                this.showProtect();
                this.invalid();
                return;
            };
            if (!ccModel.checkDomain()){
                this.kernelEvent.status = "当前域名未获得播放授权";
                showLoading(false);
                alert(this.kernelEvent.status);
                this.invalid();
                return;
            };
            if (((isNull(this.kernelEvent.status)) && (user.isVod))){
                this.getVodInfo();
            } else {
                this.checkStartPlay();
            };
            if (param.listMode){
                kernelProxy.autostart = true;
            };
        }
        protected function checkStartPlay():void{
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
        protected function get kernelEvent():KernelEventProxy{
            return ((facade.retrieveProxy(KernelEventProxy.Name) as KernelEventProxy));
        }
        private function showProtect():void{
            sendNotification(PanelViewMediator.ShowProtectedPanel, {
                url:ccModel.protectPlayURL(),
                title:videoInfo.title
            });
        }
        private function getVodInfo():void{
            var _local1:String = param.info_hash;
            if (isNull(_local1)){
                _local1 = "";
            };
            var _local2:URLRequest = new URLRequest();
            _local2.url = user.vodApi;
            _local2.method = URLRequestMethod.POST;
            _local2.data = ("info_hash=" + as2_escape(_local1));
            facade.registerProxy(new VodAPIProxy(_local2));
        }
        private function checkPlayProtected():Boolean{
            return (((!(param.protectplay)) && (user.protection)));
        }
        private function invalid():void{
            kernelProxy.allowOperate = false;
            sendNotification(ControlViewMediator.ControlBarEnabled, false);
            sendNotification(BigBtnViewMediator.AlwaysHidePlayButton, true);
        }

    }
}//package com.bokecc.sparkview.step 
