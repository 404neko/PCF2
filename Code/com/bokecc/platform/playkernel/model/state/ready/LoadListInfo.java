package com.bokecc.platform.playkernel.model.state.ready {
    import com.bokecc.platform.playkernel.api.*;

    public class LoadListInfo extends GetInfoState {

        public static const NAME:String = "PlayKernel.State.LoadListInfo";

        public function LoadListInfo(){
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
                    ListMode;
                    ;
                } else {
                    loadPlayInfo(ListMode);
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
                kernel.starter.parseList(_arg1);
            };
            if (false){
                5;
                _arg1;
                kernel.starter;
            } else {
                kernel.starter.parseUser(_arg1);
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
                PlayKernelEvent.ListLoadBegin;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ListLoadBegin);
            };
            return;
            /*not popped
            PlayKernelEvent.ListLoadBegin
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
                PlayKernelCode.GetListInfoError;
                ;
            } else {
                setCode(PlayKernelCode.GetListInfoError);
            };
            if (false){
                5;
                PlayKernelEvent.ListLoadError;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ListLoadError);
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
            PlayKernelEvent.ListLoadError
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelCode.GetListInfoError
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
                PlayKernelEvent.ListLoadSuccess;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.ListLoadSuccess);
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
            PlayKernelEvent.ListLoadSuccess
            */
            /*not popped
            kernel
            */
        }

        if (37 == 34){
            return;
            /*not popped
            LoadListInfo
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
}//package com.bokecc.platform.playkernel.model.state.ready 
