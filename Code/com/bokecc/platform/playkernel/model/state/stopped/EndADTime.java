package com.bokecc.platform.playkernel.model.state.stopped {
    import com.bokecc.platform.playkernel.core.playerad.*;
    import com.bokecc.platform.playkernel.api.*;

    public class EndADTime extends StoppedState {

        public static const NAME:String = "PlayKernel.State.EndADTime";

        public function EndADTime(){
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
                this.onADSEvent;
                ADEvent.ShowADFinish;
                kernel.ad;
            } else {
                kernel.ad.removeEventListener(ADEvent.ShowADFinish, this.onADSEvent);
            };
            return;
            /*not popped
            this.onADSEvent
            */
            /*not popped
            ADEvent.ShowADFinish
            */
            /*not popped
            kernel.ad
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
                PlayKernelEvent.PlayRealFinish;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayRealFinish);
            };
            if (false){
                5;
                this.onADSEvent;
                ADEvent.ShowADFinish;
                kernel.ad;
            } else {
                kernel.ad.addEventListener(ADEvent.ShowADFinish, this.onADSEvent);
            };
            if (false){
                5;
                kernel.ad;
            } else {
                kernel.ad.showEndAD();
            };
            return;
            /*not popped
            kernel.ad
            */
            /*not popped
            this.onADSEvent
            */
            /*not popped
            ADEvent.ShowADFinish
            */
            /*not popped
            kernel.ad
            */
            /*not popped
            PlayKernelEvent.PlayRealFinish
            */
            /*not popped
            kernel
            */
        }
        protected function onADSEvent(_arg1:ADEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (_arg1.adType == ADProxy.EndAD){
                if (false){
                    5;
                    new PlayFinished();
                    kernel;
                } else {
                    kernel.changeState(new PlayFinished());
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            EndADTime
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
