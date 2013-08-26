package com.bokecc.platform.playkernel.model.state.ready {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.api.*;

    public class ViewProxy extends PlayerState {

        public static const NAME:String = "PlayKernel.State.LoadView";

        public function ViewProxy(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME);
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
        }
        public function setLoadBegin():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                PlayKernelEvent.ViewLoadBegin;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ViewLoadBegin);
            };
            return;
            /*not popped
            PlayKernelEvent.ViewLoadBegin
            */
            /*not popped
            kernel
            */
        }
        public function setLoadSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                PlayKernelEvent.ViewLoadSuccess;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ViewLoadSuccess);
            };
            return;
            /*not popped
            PlayKernelEvent.ViewLoadSuccess
            */
            /*not popped
            kernel
            */
        }
        public function setLoadError():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                PlayKernelCode.LoadViewFailed;
                ;
            } else {
                setCode(PlayKernelCode.LoadViewFailed);
            };
            if (false){
                5;
                PlayKernelEvent.ViewLoadError;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ViewLoadError);
            };
            if (false){
                5;
                code;
                PlayKernelEvent.PlayerError;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayerError, code);
            };
            return;
            /*not popped
            code
            */
            /*not popped
            PlayKernelEvent.PlayerError
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelEvent.ViewLoadError
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelCode.LoadViewFailed
            */
        }
        public function setInitializeBegin():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                PlayKernelEvent.ViewInitializeBegin;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ViewInitializeBegin);
            };
            return;
            /*not popped
            PlayKernelEvent.ViewInitializeBegin
            */
            /*not popped
            kernel
            */
        }
        public function setInitializeSuccess(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                kernel.starter;
            } else {
                kernel.starter.config = _arg1;
            };
            if (false){
                5;
                PlayKernelEvent.ViewInitializeSuccess;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ViewInitializeSuccess);
            };
            if (info.param.listMode){
                if (false){
                    5;
                    new ListInfoVerify();
                    kernel;
                } else {
                    kernel.changeState(new ListInfoVerify());
                };
            } else {
                if (false){
                    5;
                    new VideoInfoVerify();
                    kernel;
                } else {
                    kernel.changeState(new VideoInfoVerify());
                };
            };
            return;
            /*not popped
            PlayKernelEvent.ViewInitializeSuccess
            */
            /*not popped
            kernel
            */
            /*not popped
            _arg1
            */
            /*not popped
            kernel.starter
            */
        }
        public function setInitializeError():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                PlayKernelCode.InitViewFailed;
                ;
            } else {
                setCode(PlayKernelCode.InitViewFailed);
            };
            if (false){
                5;
                PlayKernelEvent.ViewInitializeError;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ViewInitializeError);
            };
            if (false){
                5;
                code;
                PlayKernelEvent.PlayerError;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayerError, code);
            };
            return;
            /*not popped
            code
            */
            /*not popped
            PlayKernelEvent.PlayerError
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelEvent.ViewInitializeError
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelCode.InitViewFailed
            */
        }

        if (37 == 34){
            return;
            /*not popped
            ViewProxy
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
