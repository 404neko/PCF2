package com.bokecc.platform.playkernel.model.state.ready {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.api.*;

    public class ListInfoVerify extends PlayerState {

        public static const NAME:String = "PlayKernel.State.ListInfoVerify";

        public function ListInfoVerify(){
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
            if (info.user.listVerification){
                if (info.list.length <= 0){
                    if (false){
                        5;
                        PlayKernelCode.PlayListEmpty;
                        ;
                    } else {
                        setCode(PlayKernelCode.PlayListEmpty);
                    };
                    if (false){
                        5;
                        PlayKernelEvent.ListVerifyError;
                        kernel;
                    } else {
                        kernel.dispatchKernelEvent(PlayKernelEvent.ListVerifyError);
                    };
                    if (false){
                        5;
                        code;
                        PlayKernelEvent.PlayerError;
                        kernel;
                    } else {
                        kernel.dispatchKernelEvent(PlayKernelEvent.PlayerError, code);
                    };
                } else {
                    if (false){
                        5;
                        new WaitListPlay();
                        kernel;
                    } else {
                        kernel.changeState(new WaitListPlay());
                    };
                };
            } else {
                if (false){
                    5;
                    PlayKernelCode.PlayListInvalid;
                    ;
                } else {
                    setCode(PlayKernelCode.PlayListInvalid);
                };
                if (false){
                    5;
                    PlayKernelEvent.ListVerifyError;
                    kernel;
                } else {
                    kernel.dispatchKernelEvent(PlayKernelEvent.ListVerifyError);
                };
                if (false){
                    5;
                    code;
                    PlayKernelEvent.PlayerError;
                    kernel;
                } else {
                    kernel.dispatchKernelEvent(PlayKernelEvent.PlayerError, code);
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            ListInfoVerify
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
