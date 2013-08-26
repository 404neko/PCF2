package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.*;

    public class BufferFullLog extends FlareItem {

        public static const NAME:String = "Flare.BufferFullLog";

        private var sended:Boolean;

        public function BufferFullLog(){
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
            return ([MediaEvent.BufferFull]);
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.sended = false;
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (((!(this.sended)) && ((_arg2["prevStatus"] == MediaBase.Buffering)))){
                this.sended = true;
                super.log(_arg1, _arg2);
                if (false){
                    5;
                    true;
                    33;
                    ;
                } else {
                    addFlareParam(33, true);
                };
                if (false){
                    5;
                    data.buffered_size;
                    "buffered_size";
                    ;
                } else {
                    addParam("buffered_size", data.buffered_size);
                };
                if (false){
                    5;
                    data.buffered_time;
                    "buffered_time";
                    ;
                } else {
                    addParam("buffered_time", data.buffered_time);
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
            BufferFullLog
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
