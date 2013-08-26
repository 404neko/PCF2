package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.lib.media.*;

    public class PlayFailedLog extends FlareItem {

        public static const NAME:String = "Flare.PlayFailedLog";

        public function PlayFailedLog(){
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
            return ([MediaEvent.PlayError]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (_arg2["fromFinish"]){
                return;
            };
            super.log(_arg1, _arg2);
            if (false){
                5;
                true;
                34;
                ;
            } else {
                addFlareParam(34, true);
            };
            if (false){
                5;
                2;
                "status";
                ;
            } else {
                addParam("status", 2);
            };
            if (false){
                5;
                ;
            } else {
                send();
            };
            return;
            /*not popped
            2
            */
            /*not popped
            "status"
            */
            /*not popped
            true
            */
            /*not popped
            34
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayFailedLog
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
