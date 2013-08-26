package com.bokecc.sparkview.command {
    import flash.events.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.sparkview.proxy.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.Module.*;

    public class MediaEventHandler extends BasicCommand implements ICommand {

        public static const MediaEvent:String = "SparkView.MediaEvent";

        override public function execute(_arg1:INotification):void{
            var _local3:Object;
            var _local4:Boolean;
            var _local2:String = _arg1.getType();
            _local3 = _arg1.getBody();
            switch (_local2){
                case PlayKernelEvent.PlayResume:
                case PlayKernelEvent.PlayPause:
                    sendNotification(ControlViewMediator.SetPlayStatus, {
                        playing:playKernel.playing,
                        stoped:playKernel.stopped
                    });
                    sendNotification(RecordTime.RecordTime, true);
                    sendNotification(ProgressTimer.StartTimer, true);
                    this.jsControl.onPlayStatus();
                    break;
                case PlayKernelEvent.BufferEmpty:
                    sendNotification(BufferStatus.BufferEmpty);
                    this.jsControl.onBufferStatus(true);
                    break;
                case PlayKernelEvent.BufferFull:
                case PlayKernelEvent.SeekBufferFull:
                    sendNotification(BufferStatus.BufferFull);
                    this.jsControl.onBufferStatus(false);
                    break;
                case PlayKernelEvent.LoadPositionRevised:
                    if (kernelProxy.allowOperate){
                        sendNotification(ControlViewMediator.SetBufferStart, playKernel.bufferStart);
                    };
                    break;
                case PlayKernelEvent.SeekComplete:
                    _local4 = _local3["hasBuffer"];
                    this.jsControl.onSeek();
                    if (!_local4){
                        sendNotification(BufferStatus.BufferEmpty);
                    };
                    break;
                case Event.FULLSCREEN:
                    sendNotification(ControlViewMediator.SetFullBtnStatus, StageUtil.instance.isFullScreen);
                    this.jsControl.onFullScreen();
                    break;
                case PlayKernelEvent.VolumeChanged:
                    sendNotification(ControlViewMediator.SetVolume, _local3);
                    this.shared.recordVolume(Number(_local3));
                    this.jsControl.onSetVolume();
                    break;
                case PlayKernelEvent.Click:
                    if (((!(user.isHideControl)) || (this.jsControl.ShowControl))){
                        if (_local3){
                            sendNotification(OperateEventHandler.OperateEvent, null, OperateEventHandler.FullScreen);
                        } else {
                            sendNotification(OperateEventHandler.OperateEvent, null, OperateEventHandler.Pause);
                        };
                    };
                    break;
                case PlayKernelEvent.PlayFinish:
                    this.jsControl.onPlayFinish();
                    sendNotification(PlayFinish.PlayFish);
                    kernelProxy.allowOperate = true;
                    sendNotification(ControlViewMediator.ControlBarEnabled, true);
                    sendNotification(RightiMenuMediator.RightMenuEnabled, true);
                    break;
                case PlayKernelEvent.BrightnessChanged:
                    sendNotification(PanelViewMediator.SetBrightness, playKernel.brightness);
                    break;
                case PlayKernelEvent.ScaleChanged:
                    sendNotification(PanelViewMediator.SetVideoScale, playKernel.presetScale);
                    this.jsControl.onSetVideoScale();
                    break;
                case PlayKernelEvent.ContrastChanged:
                    sendNotification(PanelViewMediator.SetContrast, playKernel.contrast);
                    break;
                case PlayKernelEvent.PlayRealFinish:
                    this.onPlayRealFinish();
                    break;
            };
        }
        private function get shared():SharedObjectProxy{
            return ((facade.retrieveProxy(SharedObjectProxy.Name) as SharedObjectProxy));
        }
        private function get jsControl():JSControlProxy{
            return ((facade.retrieveProxy(JSControlProxy.Name) as JSControlProxy));
        }
        private function onPlayRealFinish():void{
            kernelProxy.allowOperate = false;
            sendNotification(RecordTime.RecordTime, false);
            sendNotification(RecordTime.ClearRecordTime);
            sendNotification(BufferStatus.BufferFull);
            sendNotification(ControlViewMediator.SetPlayStatus, {
                playing:playKernel.playing,
                stoped:playKernel.stopped
            });
            sendNotification(ControlViewMediator.ControlBarEnabled, false);
            sendNotification(RightiMenuMediator.RightMenuEnabled, false);
            sendNotification(ProgressTimer.StartTimer, false);
        }

    }
}//package com.bokecc.sparkview.command 
