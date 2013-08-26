package com.bokecc.platform.playkernel.model.state.stopped {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.controller.api.*;

    public class PlayFinished extends StoppedState {

        public static const NAME:String = "PlayKernel.State.PlayFinished";

        public function PlayFinished(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME);
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.onRemove();
            if (false){
                5;
                KernelProxy.API_Pause;
                kernel;
            } else {
                kernel.removeAPI(KernelProxy.API_Pause);
            };
            if (false){
                5;
                KernelProxy.API_Seek;
                kernel;
            } else {
                kernel.removeAPI(KernelProxy.API_Seek);
            };
            return;
            /*not popped
            KernelProxy.API_Seek
            */
            /*not popped
            kernel
            */
            /*not popped
            KernelProxy.API_Pause
            */
            /*not popped
            kernel
            */
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
                Pause4Finished;
                KernelProxy.API_Pause;
                kernel;
            } else {
                kernel.registerAPI(KernelProxy.API_Pause, Pause4Finished);
            };
            if (false){
                5;
                Seek4Finished;
                KernelProxy.API_Seek;
                kernel;
            } else {
                kernel.registerAPI(KernelProxy.API_Seek, Seek4Finished);
            };
            if (false){
                5;
                PlayKernelEvent.PlayFinish;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayFinish);
            };
            return;
            /*not popped
            PlayKernelEvent.PlayFinish
            */
            /*not popped
            kernel
            */
            /*not popped
            Seek4Finished
            */
            /*not popped
            KernelProxy.API_Seek
            */
            /*not popped
            kernel
            */
            /*not popped
            Pause4Finished
            */
            /*not popped
            KernelProxy.API_Pause
            */
            /*not popped
            kernel
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayFinished
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
    //unresolved jump
}//package com.bokecc.platform.playkernel.model.state.stopped 
