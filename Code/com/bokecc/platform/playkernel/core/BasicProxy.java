package com.bokecc.platform.playkernel.core {
    import com.bokecc.framework.mvc.*;

    public class BasicProxy extends Proxy {

        protected var info:InfoProxy;
        protected var kernel:KernelProxy;
        protected var player:PlayerProxy;

        public function BasicProxy(_arg1:String, _arg2=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1, _arg2);
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.info = (model.proxy(InfoProxy.NAME) as InfoProxy);
            this.kernel = (model.proxy(KernelProxy.NAME) as KernelProxy);
            this.player = (model.proxy(PlayerProxy.NAME) as PlayerProxy);
        }

        if (37 == 34){
            return;
            /*not popped
            BasicProxy
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.core 
