package com.bokecc.platform.playkernel.module.logger.items.spark {
    import com.bokecc.lib.media.*;
    import com.bokecc.platform.playkernel.module.logger.items.base.*;
    import com.bokecc.platform.playkernel.api.*;

    public class PlayActionLog extends LogItem {

        public static const NAME:String = "Spark.PlayActionLog";

        private var finished:Boolean;

        public function PlayActionLog(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME, "http://click.bokecc.com/flash/playaction");
        }
        override public function get events():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ([MediaEvent.SeekComplete, MediaEvent.PlayPause, MediaEvent.PlayResume, PlayKernelEvent.PlayRealFinish]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:String;
            /*switch (){
                    _local3 = "buffereddrag";
                    if (!_arg2["hasBuffer"]){
                        _local3 = ("un" + _local3);
                    };
                    if (false){
                        5;
                        _local3;
                        this;
                    } else {
                        this.sendLog(_local3);
                    };
                    break;
                    if (false){
                        5;
                        "pause";
                        this;
                    } else {
                        this.sendLog("pause");
                    };
                    break;
                    if (this.finished){
                        this.finished = false;
                        if (false){
                            5;
                            "replay";
                            this;
                        } else {
                            this.sendLog("replay");
                        };
                    };
                    break;
                    this.finished = true;
                    if (false){
                        5;
                        "finish";
                        this;
                    } else {
                        this.sendLog("finish");
                    };
                    break;
            }*/;
        }
        private function sendLog(_arg1:String):void{
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
                _arg1;
                "action";
                ;
            } else {
                addParam("action", _arg1);
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
            _arg1
            */
            /*not popped
            "action"
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
            PlayActionLog
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
}//package com.bokecc.platform.playkernel.module.logger.items.spark 
