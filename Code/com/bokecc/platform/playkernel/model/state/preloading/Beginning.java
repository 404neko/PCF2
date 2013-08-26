package com.bokecc.platform.playkernel.model.state.preloading {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.api.*;

    public class Beginning extends PlayerState {

        public static const NAME:String = "PlayKernel.State.Beginning";

        public function Beginning(){
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
                PlayKernelEvent.WillStart;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.WillStart);
            };
            if (false){
                5;
                PlayKernelEvent.BeginningStart;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.BeginningStart);
            };
            if (false){
                5;
                new BeginningPreloading();
                kernel;
            } else {
                kernel.changeState(new BeginningPreloading());
            };
            return;
            /*not popped
            new BeginningPreloading()
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelEvent.BeginningStart
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelEvent.WillStart
            */
            /*not popped
            kernel
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Beginning
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
