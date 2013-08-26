package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.*;

    public class BufferEmptyLog extends FlareItem {

        public static const NAME:String = "Flare.BufferEmptyLog";

        public function BufferEmptyLog(){
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
            return ([MediaEvent.BufferEmpty]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if ((((_arg2["status"] == MediaBase.Buffering)) && ((data.bufferPercent < 1)))){
                super.log(_arg1, _arg2);
                if (false){
                    5;
                    true;
                    32;
                    ;
                } else {
                    addFlareParam(32, true);
                };
                if (false){
                    5;
                    data.buffer_left;
                    "buffer_left";
                    ;
                } else {
                    addParam("buffer_left", data.buffer_left);
                };
                if (false){
                    5;
                    ;
                } else {
                    send();
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            BufferEmptyLog
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
