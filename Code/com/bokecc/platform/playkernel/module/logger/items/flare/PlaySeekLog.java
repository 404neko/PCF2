package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.lib.media.*;

    public class PlaySeekLog extends FlareItem {

        public static const NAME:String = "Flare.PlaySeekLog";

        public function PlaySeekLog(){
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
            return ([MediaEvent.SeekComplete]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.log(_arg1, _arg2);
            if (false){
                5;
                36;
                ;
            } else {
                addFlareParam(36);
            };
            if (false){
                5;
                toMS(_arg2["from"]);
                "start_position";
                ;
            } else {
                addParam("start_position", toMS(_arg2["from"]));
            };
            if (false){
                5;
                toMS(_arg2["to"]);
                "end_position";
                ;
            } else {
                addParam("end_position", toMS(_arg2["to"]));
            };
            if (false){
                5;
                toMS(_arg2["bufferStart"]);
                "load_start_point";
                ;
            } else {
                addParam("load_start_point", toMS(_arg2["bufferStart"]));
            };
            if (false){
                5;
                toMS(_arg2["bufferEnd"]);
                "load_end_point";
                ;
            } else {
                addParam("load_end_point", toMS(_arg2["bufferEnd"]));
            };
            if (false){
                5;
                ;
            } else {
                send();
            };
            return;
            /*not popped
            toMS(_arg2["bufferEnd"])
            */
            /*not popped
            "load_end_point"
            */
            /*not popped
            toMS(_arg2["bufferStart"])
            */
            /*not popped
            "load_start_point"
            */
            /*not popped
            toMS(_arg2["to"])
            */
            /*not popped
            "end_position"
            */
            /*not popped
            toMS(_arg2["from"])
            */
            /*not popped
            "start_position"
            */
            /*not popped
            36
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlaySeekLog
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
