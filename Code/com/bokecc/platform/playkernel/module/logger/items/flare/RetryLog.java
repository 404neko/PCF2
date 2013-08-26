package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.platform.playkernel.api.*;

    public class RetryLog extends FlareItem {

        public static const NAME:String = "Flare.RetryLog";

        public function RetryLog(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME);
        }
        override public function get events():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ([PlayKernelEvent.ReconnectSuccess]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:int;
            super.log(_arg1, _arg2);
            if (_arg2){
                _local3 = _arg2["retryType"];
                if (_local3 == 1){
                    if (false){
                        5;
                        true;
                        41;
                        ;
                    } else {
                        addFlareParam(41, true);
                    };
                    if (false){
                        5;
                        data.unFinishErrorRetryTime;
                        "retry";
                        ;
                    } else {
                        addParam("retry", data.unFinishErrorRetryTime);
                    };
                    if (false){
                        5;
                        1;
                        "result";
                        ;
                    } else {
                        addParam("result", 1);
                    };
                    if (false){
                        5;
                        ;
                    } else {
                        send();
                    };
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            RetryLog
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.module.logger.items.flare 
