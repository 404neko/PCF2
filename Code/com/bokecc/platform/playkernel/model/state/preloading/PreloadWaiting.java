package com.bokecc.platform.playkernel.model.state.preloading {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.api.*;

    public class PreloadWaiting extends PlayerState {

        public static const NAME:String = "PlayKernel.State.PreloadWaiting";

        private var preloadCommand:Class;
        private var errorCode:int;

        public function PreloadWaiting(_arg1:int, _arg2:Class){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME);
            this.errorCode = _arg1;
            this.preloadCommand = _arg2;
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
                KernelProxy.API_Reconnect;
                kernel;
            } else {
                kernel.removeAPI(KernelProxy.API_Reconnect);
            };
            return;
            /*not popped
            KernelProxy.API_Reconnect
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
            if (this.preloadCommand){
                if (false){
                    5;
                    this.preloadCommand;
                    KernelProxy.API_Reconnect;
                    kernel;
                } else {
                    kernel.registerAPI(KernelProxy.API_Reconnect, this.preloadCommand);
                };
            };
            if (this.errorCode > 0){
                if (false){
                    5;
                    this.errorCode;
                    ;
                } else {
                    setCode(this.errorCode);
                };
                if (false){
                    5;
                    this.errorCode;
                    PlayKernelEvent.PlayerError;
                    kernel;
                } else {
                    kernel.dispatchKernelEvent(PlayKernelEvent.PlayerError, this.errorCode);
                };
            };
        }
        override public function get viewPosition():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.position);
        }
        override public function get position():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.position);
        }
        override public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.duration);
        }
        override public function get bufferStart():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.position);
        }
        override public function get bufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.position);
        }
        override public function get quality():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.quality);
        }

        if (37 == 34){
            return;
            /*not popped
            PreloadWaiting
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
