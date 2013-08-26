package com.bokecc.platform.playkernel.model.state.ready {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.controller.api.*;

    public class WaitStart extends PlayerState {

        public static const NAME:String = "PlayKernel.State.WaitStart";

        public function WaitStart(){
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
                KernelProxy.API_Preload;
                kernel;
            } else {
                kernel.removeAPI(KernelProxy.API_Preload);
            };
            return;
            /*not popped
            KernelProxy.API_Preload
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
                kernel.ad;
            } else {
                kernel.ad.updateADInfo();
            };
            if (false){
                5;
                Preload;
                KernelProxy.API_Preload;
                kernel;
            } else {
                kernel.registerAPI(KernelProxy.API_Preload, Preload);
            };
            if (false){
                5;
                Start;
                KernelProxy.API_Start;
                kernel;
            } else {
                kernel.registerAPI(KernelProxy.API_Start, Start);
            };
            if (false){
                5;
                PlayKernelEvent.AllInfoReady;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.AllInfoReady);
            };
            if (false){
                5;
                PlayKernelEvent.PlayReady;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayReady);
            };
            return;
            /*not popped
            PlayKernelEvent.PlayReady
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelEvent.AllInfoReady
            */
            /*not popped
            kernel
            */
            /*not popped
            Start
            */
            /*not popped
            KernelProxy.API_Start
            */
            /*not popped
            kernel
            */
            /*not popped
            Preload
            */
            /*not popped
            KernelProxy.API_Preload
            */
            /*not popped
            kernel
            */
            /*not popped
            kernel.ad
            */
        }

        if (37 == 34){
            return;
            /*not popped
            WaitStart
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.state.ready 
