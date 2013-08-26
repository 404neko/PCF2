package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.platform.playkernel.model.player.*;
    import com.bokecc.platform.playkernel.model.player.monitor.*;
    import com.bokecc.platform.playkernel.api.*;

    public class PreloadStatusLog extends FlareItem {

        public static const NAME:String = "Flare.PreloadStatusLog";

        public function PreloadStatusLog(){
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
            return ([PlayKernelEvent.PreloadSuccess, PlayKernelEvent.PreloadError]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local4:int;
            var _local5:int;
            var _local6:MediaProxy;
            var _local7:FlareDuration;
            var _local3:MediaGroup = _arg2["group"];
            if (_local3){
                _local4 = _local3.length;
                _local5 = 0;
                if (_local5 >= _local4){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local6 = _local3.getMediaProxy(_local5);
                if (false){
                    5;
                    ;
                } else {
                    initURL();
                };
                if (false){
                    5;
                    20;
                    ;
                } else {
                    addFlareParam(20);
                };
                _local7 = _local6.flare.getDuration(FlareMonitor.SpeedTestDuration);
                if (false){
                    5;
                    _local6.source.url.split("?")[0];
                    "test_url";
                    ;
                } else {
                    addParam("test_url", _local6.source.url.split("?")[0]);
                };
                if (false){
                    5;
                    _local7.duration;
                    "test_time";
                    ;
                } else {
                    addParam("test_time", _local7.duration);
                };
                if (false){
                    5;
                    _local7.loadSize;
                    "test_size";
                    ;
                } else {
                    addParam("test_size", _local7.loadSize);
                };
                if (false){
                    5;
                    _local6.status;
                    "test_result";
                    ;
                } else {
                    addParam("test_result", _local6.status);
                };
                if (false){
                    5;
                    ;
                } else {
                    send();
                };
                _local5++;
                //unresolved if
            };
        }

        if (37 == 34){
            return;
            /*not popped
            PreloadStatusLog
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
