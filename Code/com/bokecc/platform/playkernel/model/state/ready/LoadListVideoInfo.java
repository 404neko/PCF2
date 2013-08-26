package com.bokecc.platform.playkernel.model.state.ready {
    import com.bokecc.platform.playkernel.api.*;

    public class LoadListVideoInfo extends GetInfoState {

        public static const NAME:String = "PlayKernel.State.LoadListVideoInfo";

        public function LoadListVideoInfo(){
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
            if (info.param.listMode){
                if (false){
                    5;
                    kernel.starter.listIndex;
                    PlayKernelEvent.ListPlayStart;
                    kernel;
                } else {
                    kernel.dispatchKernelEvent(PlayKernelEvent.ListPlayStart, kernel.starter.listIndex);
                };
                if (false){
                    5;
                    ListPlayMode;
                    ;
                } else {
                    loadPlayInfo(ListPlayMode);
                };
            };
        }
        override protected function setInfo(_arg1:XML):void{
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
                kernel.starter.parseVideo(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            kernel.starter
            */
        }
        override protected function dispatchLoadBegin():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                PlayKernelEvent.PlayInfoLoadBegin;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayInfoLoadBegin);
            };
            return;
            /*not popped
            PlayKernelEvent.PlayInfoLoadBegin
            */
            /*not popped
            kernel
            */
        }
        override protected function dispatchLoadError():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                PlayKernelCode.GetListPlayInfoError;
                ;
            } else {
                setCode(PlayKernelCode.GetListPlayInfoError);
            };
            if (false){
                5;
                PlayKernelEvent.PlayInfoLoadError;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayInfoLoadError);
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
            PlayKernelEvent.PlayInfoLoadError
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelCode.GetListPlayInfoError
            */
        }
        override protected function dispatchLoadSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                PlayKernelEvent.PlayInfoLoadSuccess;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayInfoLoadSuccess);
            };
            if (false){
                5;
                new VideoInfoVerify();
                kernel;
            } else {
                kernel.changeState(new VideoInfoVerify());
            };
            return;
            /*not popped
            new VideoInfoVerify()
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelEvent.PlayInfoLoadSuccess
            */
            /*not popped
            kernel
            */
        }

        if (37 == 34){
            return;
            /*not popped
            LoadListVideoInfo
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
