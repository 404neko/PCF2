package com.bokecc.platform.playkernel.module.logger {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.model.player.*;
    import com.bokecc.platform.playkernel.module.logger.items.base.*;
    import com.bokecc.platform.playkernel.model.player.monitor.*;

    public class LoggerData extends BasicProxy {

        public static const NAME:String = "PlayKernel.Proxy.LoggerData";

        private var logs:Array;

        public function LoggerData(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME);
        }
        function addLogData(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:LogData = new LogData(_arg1, _arg2);
            if (false){
                5;
                _local3;
                this.logs;
            } else {
                this.logs.push(_local3);
            };
            return;
            /*not popped
            _local3
            */
            /*not popped
            this.logs
            */
        }
        public function get length():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this.logs) ? this.logs.length : 0));
        }
        public function getLogData(_arg1:int):LogData{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.logs[_arg1]);
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
            this.logs = [];
        }
        private function get flare():FlareMonitor{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.mediaProxy.flare);
        }
        private function get hasMonitor():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (!((kernel.play.mediaProxy.media == null)));
        }
        private function get hasFlare():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this.hasMonitor) && (!((this.flare == null)))));
        }
        public function get hasFlareStatistics():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.user.hasFlare);
        }
        public function get hasTrafficStatistics():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.user.hasTraffic);
        }
        public function get isNormal():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (player.isNormal);
        }
        public function get errorCode():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (player.code);
        }
        public function get guid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.param.guid);
        }
        public function get upid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.video.upid);
        }
        public function get userid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.user.uid);
        }
        public function get videoid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.param.vid);
        }
        public function get page_url():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.param.referer);
        }
        public function get pl_time():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.param.playerloadtime);
        }
        public function get pi_time():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.param.playinfoloadtime);
        }
        public function get group_test_count():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (kernel.play.groupNumber);
        }
        public function get total_test_time():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local4:MediaGroup;
            var _local1:Number = 0;
            var _local2:int = this.group_test_count;
            var _local3:int;
            if (_local3 >= _local2){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local4 = kernel.play.getGroup(_local3);
            _local1 = (_local1 + _local4.duration);
            _local3++;
            //unresolved if
            return (_local1);
        }
        public function get pre_adduration():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.beginADDuration);
        }
        public function get play_url():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasMonitor){
                return (kernel.play.mediaProxy.source.url.split("?")[0]);
            };
            return ("");
        }
        public function get play_domain():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasMonitor){
                return (kernel.play.mediaProxy.source.get(PlayServer.Domain));
            };
            return ("");
        }
        public function get video_duration():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasFlare){
                return ((this.flare.media.duration * 1000));
            };
            return (0);
        }
        public function get video_size():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasFlare){
                return (this.flare.byteTotal);
            };
            return (0);
        }
        public function get buffer_left():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (this.hasFlare){
                return ((this.flare.media.bufferLength * 1000));
            };
            return (0);
        }
        public function get play_position():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasFlare){
                return ((this.flare.media.position * 1000));
            };
            return (0);
        }
        public function get load_start_point():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasFlare){
                return ((this.flare.media.bufferStart * 1000));
            };
            return (0);
        }
        public function get load_end_point():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasFlare){
                return ((this.flare.media.bufferEnd * 1000));
            };
            return (0);
        }
        public function get buffered_size():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:FlareDuration;
            if (this.hasFlare){
                _local1 = this.flare.getDuration(FlareMonitor.BufferDuration);
                if (_local1){
                    return (_local1.loadSize);
                };
            };
            return (NaN);
        }
        public function get buffered_time():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:FlareDuration;
            if (this.hasFlare){
                _local1 = this.flare.getDuration(FlareMonitor.BufferDuration);
                if (_local1){
                    return (_local1.duration);
                };
            };
            return (NaN);
        }
        public function get first_buffered_size():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:FlareDuration;
            if (this.hasFlare){
                _local1 = this.flare.getDuration(FlareMonitor.ReadyDuration);
                if (_local1){
                    return (_local1.loadSize);
                };
            };
            return (NaN);
        }
        public function get first_buffered_time():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:FlareDuration;
            if (this.hasFlare){
                _local1 = this.flare.getDuration(FlareMonitor.ReadyDuration);
                if (_local1){
                    return (_local1.duration);
                };
            };
            return (NaN);
        }
        public function get unFinishErrorRetryTime():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.unFinishErrorRetryTime);
        }
        public function get serverDomain():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasMonitor){
                return (kernel.play.mediaProxy.source.domain);
            };
            return ("");
        }
        public function get isBusinessUsers():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.user.isBusinessUsers);
        }
        public function get playID():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.id);
        }
        public function get uid_vid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.video.videoURL.split("union_")[1]);
        }
        public function get userGroup():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.user.group);
        }
        public function get bufferPercent():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (player.bufferTime == 0){
                return (0);
            };
            return ((player.bufferLength / player.bufferTime));
        }

        if (37 == 34){
            return;
            /*not popped
            LoggerData
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.module.logger 
