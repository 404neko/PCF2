package com.bokecc.sparkview.step {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.proxy.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.command.*;
    import com.bokecc.lib.data.*;

    public class StartPlayStep extends BasicCommand implements ICommand {

        public static const Step_StartPlay:String = "SparkView.StartPlayStep";

        override public function execute(_arg1:INotification):void{
            var _local2:SharedObjectProxy = (facade.retrieveProxy(SharedObjectProxy.Name) as SharedObjectProxy);
            sendNotification(ViewCoreMediator.AddContextMenu, {
                caption:"举报该视频",
                enabled:true,
                callback:this.feedback,
                separatorBefore:true
            });
            var _local3:Number = _local2.getVolume();
            sendNotification(ControlViewMediator.SetVolume, _local3);
            playKernel.volume = _local3;
            var _local4:Number = 0;
            if (!user.isVod){
                _local4 = _local2.getPlayTime(param.vid);
            };
            _local4 = (((Number(kernelProxy.getParam("playstart")) > 0)) ? Number(kernelProxy.getParam("playstart")) : _local4);
            var _local5:Object = _local2.getQuality();
            _local5 = (((_local5 == null)) ? videoInfo.defaultquality : _local5);
            var _local6:KernelEventProxy = (facade.retrieveProxy(KernelEventProxy.Name) as KernelEventProxy);
            if (isNull(_local6.status)){
                playKernel.start(_local4, int(_local5));
            } else {
                sendNotification(KernelEventHandler.PlayKernelEventHandler, null, PlayKernelEvent.PlayerError);
            };
        }
        private function feedback():void{
            sendNotification(PanelViewMediator.ShowVideoFeedbackPanel, true);
        }

    }
}//package com.bokecc.sparkview.step 
