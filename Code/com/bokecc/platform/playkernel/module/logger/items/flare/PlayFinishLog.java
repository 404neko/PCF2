package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.lib.media.*;
    import com.bokecc.platform.playkernel.api.*;

    public class PlayFinishLog extends FlareItem {

        public static const NAME:String = "Flare.PlayFinishLog";

        public function PlayFinishLog(){
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
            return ([MediaEvent.PlayError, PlayKernelEvent.PlayRealFinish]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (_arg1 == MediaEvent.PlayError){
                if (!_arg2["fromFinish"]){
                    return;
                };
            };
            super.log(_arg1, _arg2);
            if (false){
                5;
                true;
                40;
                ;
            } else {
                addFlareParam(40, true);
            };
            if (false){
                5;
                data.video_duration;
                "video_duration";
                ;
            } else {
                addParam("video_duration", data.video_duration);
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
                ;
            } else {
                send();
            };
            return;
            /*not popped
            data.unFinishErrorRetryTime
            */
            /*not popped
            "retry"
            */
            /*not popped
            data.video_duration
            */
            /*not popped
            "video_duration"
            */
            /*not popped
            true
            */
            /*not popped
            40
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayFinishLog
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
