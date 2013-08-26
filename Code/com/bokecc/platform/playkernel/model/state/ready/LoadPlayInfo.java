package com.bokecc.platform.playkernel.model.state.ready {
    import com.bokecc.platform.playkernel.api.*;

    public class LoadPlayInfo extends GetInfoState {

        public static const NAME:String = "PlayKernel.State.LoadPlayInfo";

        public function LoadPlayInfo(){
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
            var _local1:Boolean = hasPlayInfo();
            if (!_local1){
                if (false){
                    5;
                    SinglePlayMode;
                    ;
                } else {
                    loadPlayInfo(SinglePlayMode);
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
                kernel.starter.parseVersion(_arg1);
            };
            if (false){
                5;
                _arg1;
                kernel.starter;
            } else {
                kernel.starter.parseUser(_arg1);
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
            /*not popped
            _arg1
            */
            /*not popped
            kernel.starter
            */
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
            if (false){
                5;
                PlayKernelCode.GetSinglePlayInfoError;
                ;
            } else {
                setCode(PlayKernelCode.GetSinglePlayInfoError);
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
            PlayKernelCode.GetSinglePlayInfoError
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
                info.getViewURL();
                kernel;
            } else {
                kernel.initPlayerView(info.getViewURL());
            };
            return;
            /*not popped
            info.getViewURL()
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
            LoadPlayInfo
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
