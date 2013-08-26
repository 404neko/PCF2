package com.bokecc.platform.playkernel.model.state.preloading {
    import com.bokecc.lib.media.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.controller.api.*;
    import com.bokecc.platform.playkernel.model.state.playing.*;

    public class PlayReconnectPreloading extends Preloading {

        public static const NAME:String = "PlayKernel.State.PlayReconnectPreloading";

        private var errorFromFinish:Boolean;

        public function PlayReconnectPreloading(_arg1:Boolean=false){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME, Preloading.PlayReconnect);
            this.errorFromFinish = _arg1;
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
            if (false){
                5;
                this.errorFromFinish;
                kernel.play;
            } else {
                kernel.play.retry(this.errorFromFinish);
            };
            if (false){
                5;
                quality;
                kernel.play;
            } else {
                kernel.play.quality = quality;
            };
            if (false){
                5;
                PlayKernelEvent.ReconnectStart;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ReconnectStart);
            };
            if (false){
                5;
                bufferStart;
                MediaEvent.LoadPositionRevised;
                kernel;
            } else {
                kernel.dispatchKernelEvent(MediaEvent.LoadPositionRevised, bufferStart);
            };
            if (false){
                5;
                ;
            } else {
                preload();
            };
            return;
            /*not popped
            bufferStart
            */
            /*not popped
            MediaEvent.LoadPositionRevised
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelEvent.ReconnectStart
            */
            /*not popped
            kernel
            */
            /*not popped
            quality
            */
            /*not popped
            kernel.play
            */
            /*not popped
            this.errorFromFinish
            */
            /*not popped
            kernel.play
            */
        }
        override protected function onPreloadFailed():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                PlayKernelCode.PlayFailed;
                ;
            } else {
                setCode(PlayKernelCode.PlayFailed);
            };
            if (false){
                5;
                preloadValue;
                PlayKernelEvent.ReconnectError;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ReconnectError, preloadValue);
            };
            if (false){
                5;
                new PreloadWaiting(code, Reconnect4PlayError);
                kernel;
            } else {
                kernel.changeState(new PreloadWaiting(code, Reconnect4PlayError));
            };
            return;
            /*not popped
            new PreloadWaiting(code, Reconnect4PlayError)
            */
            /*not popped
            kernel
            */
            /*not popped
            preloadValue
            */
            /*not popped
            PlayKernelEvent.ReconnectError
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelCode.PlayFailed
            */
        }
        override protected function onPreloadSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                PlayKernelCode.Normal;
                ;
            } else {
                setCode(PlayKernelCode.Normal);
            };
            var _local1:Object = {
                group:preloader.group,
                result:preloader.result,
                retryType:kernel.play.retryType,
                unFinishErrorRetryTime:kernel.play.unFinishErrorRetryTime,
                normalPlayErrorRetryTime:kernel.play.normalPlayErrorRetryTime
            };
            if (false){
                5;
                _local1;
                PlayKernelEvent.ReconnectSuccess;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ReconnectSuccess, _local1);
            };
            if (false){
                5;
                new SwitchPlaying();
                kernel;
            } else {
                kernel.changeState(new SwitchPlaying());
            };
            return;
            /*not popped
            new SwitchPlaying()
            */
            /*not popped
            kernel
            */
            /*not popped
            _local1
            */
            /*not popped
            PlayKernelEvent.ReconnectSuccess
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelCode.Normal
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayReconnectPreloading
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.state.preloading 
