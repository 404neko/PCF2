package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.lib.media.*;

    public class PlayPauseLog extends FlareItem {

        public static const NAME:String = "Flare.PlayPauseLog";

        public function PlayPauseLog(){
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
            return ([MediaEvent.PlayPause]);
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
                35;
                ;
            } else {
                addFlareParam(35);
            };
            if (false){
                5;
                0;
                "type";
                ;
            } else {
                addParam("type", 0);
            };
            if (false){
                5;
                ;
            } else {
                send();
            };
            return;
            /*not popped
            0
            */
            /*not popped
            "type"
            */
            /*not popped
            35
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayPauseLog
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
    //unresolved jump
}//package com.bokecc.platform.playkernel.module.logger.items.flare 
