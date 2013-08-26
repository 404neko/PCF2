package com.bokecc.platform.playkernel.module.logger.items.spark {
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.*;
    import com.bokecc.platform.playkernel.module.logger.items.base.*;
    import com.bokecc.platform.playkernel.api.*;

    public class PlayLog extends LogItem {

        public static const NAME:String = "Spark.PlayLog";

        private var emptyTime:int;

        public function PlayLog(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME, "http://click.bokecc.com/playlog.php");
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.emptyTime = 0;
        }
        override public function get events():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ([PlayKernelEvent.PlayRealStart, MediaEvent.BufferEmpty, MediaEvent.PlayError]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            /*switch (){
                    if (false){
                        5;
                        this;
                    } else {
                        this.playConut();
                    };
                    if (false){
                        5;
                        0;
                        this;
                    } else {
                        this.sendLog(0);
                    };
                    break;
                    if ((((_arg2["status"] == MediaBase.Buffering)) && ((data.bufferPercent < 1)))){
                        var _local3 = this;
                        var _local4 = (_local3.emptyTime + 1);
                        if (false){
                            5;
                            _local4;
                            _local3;
                        } else {
                            _local3.emptyTime = _local4;
                        };
                        if ((((this.emptyTime == 1)) || ((this.emptyTime == 3)))){
                            if (false){
                                5;
                                this.emptyTime;
                                this;
                            } else {
                                this.sendLog(this.emptyTime);
                            };
                        };
                    };
                    break;
                    if (false){
                        5;
                        2;
                        this;
                    } else {
                        this.sendLog(2);
                    };
                    break;
            }*/;
        }
        private function sendLog(_arg1:int):void{
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
                data.playID;
                "id";
                ;
            } else {
                addParam("id", data.playID);
            };
            if (false){
                5;
                ((data.isBusinessUsers) ? 2 : 0);
                "VIP";
                ;
            } else {
                addParam("VIP", ((data.isBusinessUsers) ? 2 : 0));
            };
            if (false){
                5;
                _arg1;
                "action";
                ;
            } else {
                addParam("action", _arg1);
            };
            if (_arg1 == 2){
                if (false){
                    5;
                    data.play_url;
                    "flvURL";
                    ;
                } else {
                    addParam("flvURL", data.play_url);
                };
                if (false){
                    5;
                    1;
                    "playing";
                    ;
                } else {
                    addParam("playing", 1);
                };
            } else {
                if (false){
                    5;
                    data.play_url;
                    "flvURL";
                    ;
                } else {
                    addParam("flvURL", data.play_url);
                };
                if (false){
                    5;
                    data.bufferPercent;
                    "bufferPercent";
                    ;
                } else {
                    addParam("bufferPercent", data.bufferPercent);
                };
            };
            if (false){
                5;
                data.userid;
                "userID";
                ;
            } else {
                addParam("userID", data.userid);
            };
            if (false){
                5;
                data.videoid;
                "videoID";
                ;
            } else {
                addParam("videoID", data.videoid);
            };
            if (false){
                5;
                2;
                "status";
                ;
            } else {
                addParam("status", 2);
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
            2
            */
            /*not popped
            "status"
            */
            /*not popped
            data.videoid
            */
            /*not popped
            "videoID"
            */
            /*not popped
            data.userid
            */
            /*not popped
            "userID"
            */
            /*not popped
            _arg1
            */
            /*not popped
            "action"
            */
            /*not popped
            ((data.isBusinessUsers) ? 2 : 0)
            */
            /*not popped
            "VIP"
            */
            /*not popped
            data.playID
            */
            /*not popped
            "id"
            */
        }
        private function playConut():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                "http://play.bokecc.com/servlet/PlayVideo";
                ;
            } else {
                initURL("http://play.bokecc.com/servlet/PlayVideo");
            };
            if (false){
                5;
                data.videoid;
                "videoID";
                ;
            } else {
                addParam("videoID", data.videoid);
            };
            if (false){
                5;
                data.userid;
                "userID";
                ;
            } else {
                addParam("userID", data.userid);
            };
            if (false){
                5;
                data.serverDomain;
                "serverDomain";
                ;
            } else {
                addParam("serverDomain", data.serverDomain);
            };
            if (false){
                5;
                data.uid_vid;
                "videourl";
                ;
            } else {
                addParam("videourl", data.uid_vid);
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
            data.uid_vid
            */
            /*not popped
            "videourl"
            */
            /*not popped
            data.serverDomain
            */
            /*not popped
            "serverDomain"
            */
            /*not popped
            data.userid
            */
            /*not popped
            "userID"
            */
            /*not popped
            data.videoid
            */
            /*not popped
            "videoID"
            */
            /*not popped
            "http://play.bokecc.com/servlet/PlayVideo"
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayLog
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
