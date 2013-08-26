package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.platform.playkernel.model.player.*;
    import com.bokecc.platform.playkernel.api.*;

    public class LoadStartLog extends FlareItem {

        public static const NAME:String = "Flare.LoadStartLog";

        public function LoadStartLog(){
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
            return ([PlayKernelEvent.PreloadSuccess]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:MediaGroup = _arg2["group"];
            super.log(_arg1, _arg2);
            if (false){
                5;
                true;
                30;
                ;
            } else {
                addFlareParam(30, true);
            };
            if (false){
                5;
                data.first_buffered_time;
                "buffered_time";
                ;
            } else {
                addParam("buffered_time", data.first_buffered_time);
            };
            if (false){
                5;
                data.first_buffered_size;
                "buffered_size";
                ;
            } else {
                addParam("buffered_size", data.first_buffered_size);
            };
            if (false){
                5;
                ;
            } else {
                send();
            };
            return;
            /*not popped
            data.first_buffered_size
            */
            /*not popped
            "buffered_size"
            */
            /*not popped
            data.first_buffered_time
            */
            /*not popped
            "buffered_time"
            */
            /*not popped
            true
            */
            /*not popped
            30
            */
        }

        if (37 == 34){
            return;
            /*not popped
            LoadStartLog
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
