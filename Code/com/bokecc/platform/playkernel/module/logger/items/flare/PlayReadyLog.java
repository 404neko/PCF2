package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.platform.playkernel.api.*;

    public class PlayReadyLog extends FlareItem {

        public static const NAME:String = "Flare.PlayReadyLog";

        public function PlayReadyLog(){
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
            return ([PlayKernelEvent.ViewInitializeError, PlayKernelEvent.ViewLoadError, PlayKernelEvent.PlayInfoLoadError, PlayKernelEvent.PlayInfoVerifyError, PlayKernelEvent.ListLoadError, PlayKernelEvent.ListVerifyError, PlayKernelEvent.AllInfoReady]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                10;
                ;
            } else {
                addFlareParam(10);
            };
            if (false){
                5;
                ((data.isNormal) ? 1 : 0);
                "status";
                ;
            } else {
                addParam("status", ((data.isNormal) ? 1 : 0));
            };
            if (!data.isNormal){
                if (false){
                    5;
                    data.errorCode;
                    "reason";
                    ;
                } else {
                    addParam("reason", data.errorCode);
                };
            };
            if (false){
                5;
                data.pl_time;
                "pl_time";
                ;
            } else {
                addParam("pl_time", data.pl_time);
            };
            if (false){
                5;
                data.pi_time;
                "pi_time";
                ;
            } else {
                addParam("pi_time", data.pi_time);
            };
            if (false){
                5;
                data.guid;
                "uvid";
                ;
            } else {
                addParam("uvid", data.guid);
            };
            if (false){
                5;
                ;
            } else {
                send();
            };
            return;
            /*not popped
            data.guid
            */
            /*not popped
            "uvid"
            */
            /*not popped
            data.pi_time
            */
            /*not popped
            "pi_time"
            */
            /*not popped
            data.pl_time
            */
            /*not popped
            "pl_time"
            */
            /*not popped
            ((data.isNormal) ? 1 : 0)
            */
            /*not popped
            "status"
            */
            /*not popped
            10
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayReadyLog
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
