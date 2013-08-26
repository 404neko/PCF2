package com.bokecc.sparkview.command {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.proxy.*;
    import com.bokecc.platform.playkernel.api.*;
    import flash.net.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.Module.*;
    import com.bokecc.utils.*;
    import com.bokecc.lib.data.*;

    public class KernelEventHandler extends BasicCommand implements ICommand {

        public static const PlayKernelEventHandler:String = "PlayKernelEventHandler";

        override public function execute(_arg1:INotification):void{
            var _local2:String = _arg1.getType();
            var _local3:Object = _arg1.getBody();
            switch (_local2){
                case PlayKernelEvent.PlayReady:
                    this.eventProxy.status = "";
                    sendNotification(VerifyStep.Step_Verify);
                    this.updateAddress();
                    break;
                case PlayKernelEvent.ListInfoReady:
                    sendNotification(ListViewMediator.ListReady, {
                        listPosition:user.listPosition,
                        listStyle:user.listStyle,
                        listData:playKernel.list
                    });
                    break;
                case PlayKernelEvent.PlayStart:
                    this.onPlayStart();
                    showLoading(false);
                    break;
                case PlayKernelEvent.PlayRealStart:
                    this.onPlayRealStart();
                    break;
                case PlayKernelEvent.PlayerError:
                    this.onPlayError();
                    break;
                case PlayKernelEvent.SwitchQualityStart:
                    sendNotification(BufferStatus.BufferEmpty, false);
                    sendNotification(PanelViewMediator.SetQuality, playKernel.quality);
                    this.jsControlr.onSwitchQuality();
                    (facade.retrieveProxy(SharedObjectProxy.Name) as SharedObjectProxy).setQuality(playKernel.quality);
                    break;
                case PlayKernelEvent.ReconnectSuccess:
                    alert("", false);
                    break;
            };
        }
        protected function onPlayError():void{
            showLoading(false);
            switch (this.eventProxy.code){
                case PlayKernelCode.SpeedTestFailed:
                case PlayKernelCode.PlayFailed:
                case PlayKernelCode.SwitchQualityFailed:
                    alert((("抱歉,网络连接失败,请" + PanelViewMediator.linkText("刷新", PanelEventHandler.Reconnect)) + "重试"));
                    sendNotification(PlayAnalyse.SendReveal, PlayAnalyse.Refresh);
                    break;
                case PlayKernelCode.PlayProtected:
                    sendNotification(PanelViewMediator.ShowProtectedPanel, {
                        url:ccModel.protectPlayURL(),
                        title:videoInfo.title
                    });
                    this.invalid();
                    break;
                case PlayKernelCode.PlayListEmpty:
                case PlayKernelCode.PlayListInvalid:
                case PlayKernelCode.GetListPlayInfoError:
                case PlayKernelCode.GetListInfoError:
                    alert(this.eventProxy.status);
                    this.invalid();
                    break;
                default:
                    showLoading(false);
                    if (param.listMode){
                        alert(this.eventProxy.status, true, "提示", false, "下一个", this.listModeCallback);
                    } else {
                        alert(this.eventProxy.status);
                        this.invalid();
                    };
            };
        }
        protected function onPlayStart():void{
            sendNotification(ControlViewMediator.InitControl, {duration:playKernel.duration});
            sendNotification(BufferStatus.BufferEmpty, false);
            this.jsControlr.onMetaData();
            if (videoInfo.videomarks != null){
                sendNotification(ViewCoreMediator.ShowVideoPoint, ccModel.videoPoint);
            };
            this.invalid();
        }
        protected function onPlayRealStart():void{
            kernelProxy.allowOperate = true;
            showLoading(false);
            sendNotification(ControlViewMediator.ControlBarEnabled, true);
            sendNotification(ControlViewMediator.InitControl, {duration:playKernel.duration});
            sendNotification(ControlViewMediator.SetBufferStart, playKernel.bufferStart);
            sendNotification(ControlViewMediator.SetPlayStatus, {
                playing:playKernel.playing,
                stoped:playKernel.stopped
            });
            sendNotification(RightiMenuMediator.InitRightMenu, {
                autoShow:user.showrightmenu,
                datas:user.menusData
            });
            sendNotification(PanelViewMediator.InitPanel, {
                shareData:{
                    bshare:user.bshare,
                    html:ccModel.htmlCode,
                    swf:ccModel.swfCode,
                    video:ccModel.getVideoPageURL()
                },
                dowloadURL:videoInfo.downloadPath,
                quality:{
                    highestQuality:kernelProxy.highestQuality,
                    defaultQuality:playKernel.quality
                }
            });
            sendNotification(PlayAnalyse.SendReady);
            sendNotification(RecordTime.ShowRecordTimeTip);
            sendNotification(RecordTime.RecordTime, true);
            sendNotification(ProgressTimer.StartTimer, true);
            if (videoInfo.videomarks != null){
                sendNotification(ViewCoreMediator.ShowVideoPoint, ccModel.videoPoint);
            };
            this.jsControlr.onPlayerStart();
        }
        protected function get jsControlr():JSControlProxy{
            return ((facade.retrieveProxy(JSControlProxy.Name) as JSControlProxy));
        }
        protected function get eventProxy():KernelEventProxy{
            return ((facade.retrieveProxy(KernelEventProxy.Name) as KernelEventProxy));
        }
        private function listModeCallback():void{
            sendNotification(PlayFinish.PlayFish);
        }
        private function invalid():void{
            kernelProxy.allowOperate = false;
            sendNotification(ControlViewMediator.ControlBarEnabled, false);
        }
        private function updateAddress():void{
            var _local1:String;
            var _local2:URLVariables;
            if (((!(videoInfo.hasAddr)) && (!(param.listMode)))){
                _local1 = param.referer;
                if (isNull(_local1)){
                    _local1 = param.referer;
                };
                if (!isNull(_local1)){
                    _local2 = new URLVariables();
                    _local2["referer"] = _local1;
                    _local2["videoID"] = param.vid;
                    send2Server(CCURL.UpdateAddress, _local2);
                };
            };
        }

    }
}//package com.bokecc.sparkview.command 
