package com.bokecc.platform.playkernel.model.state.preloading {
    import com.bokecc.lib.media.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.controller.api.*;
    import com.bokecc.platform.playkernel.model.state.playing.*;

    public class SwitchQualityPreloading extends Preloading {

        public static const NAME:String = "PlayKernel.State.SwitchQualityPreloading";

        public function SwitchQualityPreloading(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME, Preloading.SwitchQuality);
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super.init();
            if (false){
                5;
                quality;
                kernel.play;
            } else {
                kernel.play.quality = quality;
            };
            if (false){
                5;
                PlayKernelEvent.SwitchQualityStart;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.SwitchQualityStart);
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
            PlayKernelEvent.SwitchQualityStart
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
                PlayKernelCode.SwitchQualityFailed;
                ;
            } else {
                setCode(PlayKernelCode.SwitchQualityFailed);
            };
            if (false){
                5;
                preloadValue;
                PlayKernelEvent.SwitchQualityError;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.SwitchQualityError, preloadValue);
            };
            if (false){
                5;
                new PreloadWaiting(code, Reconnect4SwitchQualityError);
                kernel;
            } else {
                kernel.changeState(new PreloadWaiting(code, Reconnect4SwitchQualityError));
            };
            return;
            /*not popped
            new PreloadWaiting(code, Reconnect4SwitchQualityError)
            */
            /*not popped
            kernel
            */
            /*not popped
            preloadValue
            */
            /*not popped
            PlayKernelEvent.SwitchQualityError
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelCode.SwitchQualityFailed
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
            if (false){
                5;
                preloadValue;
                PlayKernelEvent.SwitchQualitySuccess;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.SwitchQualitySuccess, preloadValue);
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
            preloadValue
            */
            /*not popped
            PlayKernelEvent.SwitchQualitySuccess
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
            SwitchQualityPreloading
            */
        };
        //unresolved jump
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.state.preloading 
