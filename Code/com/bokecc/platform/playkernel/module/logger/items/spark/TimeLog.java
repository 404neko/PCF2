package com.bokecc.platform.playkernel.module.logger.items.spark {
    import com.bokecc.platform.playkernel.module.logger.items.base.*;
    import com.bokecc.platform.playkernel.api.*;

    public class TimeLog extends LogItem {

        public static const NAME:String = "Spark.TimeLog";

        public function TimeLog(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME, "http://click.bokecc.com/flash/timerecorder");
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
                ;
            } else {
                initURL();
            };
            if (false){
                5;
                data.userid;
                "uid";
                ;
            } else {
                addParam("uid", data.userid);
            };
            if (false){
                5;
                data.videoid;
                "vid";
                ;
            } else {
                addParam("vid", data.videoid);
            };
            if (false){
                5;
                (_arg1 == PlayKernelEvent.AllInfoReady);
                "result";
                ;
            } else {
                addParam("result", (_arg1 == PlayKernelEvent.AllInfoReady));
            };
            if (false){
                5;
                data.playID;
                "id";
                ;
            } else {
                addParam("id", data.playID);
            };
            if (false){
                5;
                data.pl_time;
                "fl_time";
                ;
            } else {
                addParam("fl_time", data.pl_time);
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
                0;
                "ls_time";
                ;
            } else {
                addParam("ls_time", 0);
            };
            if (false){
                5;
                LogEvent.Click;
                ;
            } else {
                send(LogEvent.Click);
            };
            return;
            /*not popped
            LogEvent.Click
            */
            /*not popped
            0
            */
            /*not popped
            "ls_time"
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
            "fl_time"
            */
            /*not popped
            data.playID
            */
            /*not popped
            "id"
            */
            /*not popped
            (_arg1 == PlayKernelEvent.AllInfoReady)
            */
            /*not popped
            "result"
            */
            /*not popped
            data.videoid
            */
            /*not popped
            "vid"
            */
            /*not popped
            data.userid
            */
            /*not popped
            "uid"
            */
        }

        if (37 == 34){
            return;
            /*not popped
            TimeLog
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.module.logger.items.spark 
