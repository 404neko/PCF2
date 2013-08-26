package com.bokecc.platform.playkernel.module.logger.items.spark {
    import com.bokecc.platform.playkernel.model.player.*;
    import com.bokecc.platform.playkernel.module.logger.items.base.*;
    import com.bokecc.platform.playkernel.api.*;

    public class FirstBufferFullLog extends LogItem {

        public static const NAME:String = "Spark.FirstBufferFullLog";

        public function FirstBufferFullLog(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME, "http://click.bokecc.com/flash/firstbufferfull");
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
                data.first_buffered_time;
                "time";
                ;
            } else {
                addParam("time", data.first_buffered_time);
            };
            if (false){
                5;
                data.first_buffered_size;
                "bufferedsize";
                ;
            } else {
                addParam("bufferedsize", data.first_buffered_size);
            };
            if (false){
                5;
                data.video_duration;
                "duration";
                ;
            } else {
                addParam("duration", data.video_duration);
            };
            if (false){
                5;
                data.userGroup;
                "group";
                ;
            } else {
                addParam("group", data.userGroup);
            };
            if (false){
                5;
                data.serverDomain;
                "domain";
                ;
            } else {
                addParam("domain", data.serverDomain);
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
            data.serverDomain
            */
            /*not popped
            "domain"
            */
            /*not popped
            data.userGroup
            */
            /*not popped
            "group"
            */
            /*not popped
            data.video_duration
            */
            /*not popped
            "duration"
            */
            /*not popped
            data.first_buffered_size
            */
            /*not popped
            "bufferedsize"
            */
            /*not popped
            data.first_buffered_time
            */
            /*not popped
            "time"
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
            FirstBufferFullLog
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
