package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.platform.playkernel.api.*;

    public class PlayStartLog extends FlareItem {

        public static const NAME:String = "Flare.PlayStartLog";

        public function PlayStartLog(){
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
            return ([PlayKernelEvent.PlayRealStart]);
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
                true;
                31;
                ;
            } else {
                addFlareParam(31, true);
            };
            if (false){
                5;
                data.pre_adduration;
                "pre_adduration";
                ;
            } else {
                addParam("pre_adduration", data.pre_adduration);
            };
            if (false){
                5;
                data.group_test_count;
                "group_test_count";
                ;
            } else {
                addParam("group_test_count", data.group_test_count);
            };
            if (false){
                5;
                data.total_test_time;
                "total_test_time";
                ;
            } else {
                addParam("total_test_time", data.total_test_time);
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
                data.video_size;
                "video_size";
                ;
            } else {
                addParam("video_size", data.video_size);
            };
            if (false){
                5;
                data.page_url;
                "page_url";
                ;
            } else {
                addParam("page_url", data.page_url);
            };
            if (false){
                5;
                data.guid;
                "uvid";
                ;
            } else {
                addParam("uvid", data.guid);
            };
            if (false){
                5;
                ;
            } else {
                send();
            };
            return;
            /*not popped
            data.guid
            */
            /*not popped
            "uvid"
            */
            /*not popped
            data.page_url
            */
            /*not popped
            "page_url"
            */
            /*not popped
            data.video_size
            */
            /*not popped
            "video_size"
            */
            /*not popped
            data.video_duration
            */
            /*not popped
            "video_duration"
            */
            /*not popped
            data.total_test_time
            */
            /*not popped
            "total_test_time"
            */
            /*not popped
            data.group_test_count
            */
            /*not popped
            "group_test_count"
            */
            /*not popped
            data.pre_adduration
            */
            /*not popped
            "pre_adduration"
            */
            /*not popped
            true
            */
            /*not popped
            31
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayStartLog
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
