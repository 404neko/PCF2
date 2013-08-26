package com.bokecc.platform.playkernel.model.state.closed {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.model.info.*;
    import com.bokecc.lib.media.core.videocore.*;

    public class AllClosed extends PlayerState {

        public static const NAME:String = "PlayKernel.State.AllClosed";

        public function AllClosed(){
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
            if (false){
                5;
                KernelProxy.API_ListPlay;
                kernel;
            } else {
                kernel.removeAPI(KernelProxy.API_ListPlay);
            };
            if (false){
                5;
                PlayProxy.NAME;
                model;
            } else {
                model.removeProxy(PlayProxy.NAME);
            };
            if (false){
                5;
                Connection;
            } else {
                Connection.allClose();
            };
            return;
            /*not popped
            Connection
            */
            /*not popped
            PlayProxy.NAME
            */
            /*not popped
            model
            */
            /*not popped
            KernelProxy.API_ListPlay
            */
            /*not popped
            kernel
            */
        }

        if (37 == 34){
            return;
            /*not popped
            AllClosed
            */
        };
        //unresolved jump
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.state.closed 
