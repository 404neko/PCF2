package com.bokecc.platform.playkernel.module.logger.items.traffic {
    import com.bokecc.lib.media.*;
    import com.bokecc.platform.playkernel.model.player.*;
    import com.bokecc.platform.playkernel.module.logger.items.base.*;
    import com.bokecc.platform.playkernel.model.player.monitor.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.adobe.crypto.*;

    public class TrafficLog extends LogItem {

        public static const NAME:String = "Traffic.Log";
        public static const URL:String = "http://traffic.bokecc.com/servlet/playlog";

        private var monitor:TrafficMonitor;

        public function TrafficLog(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME, URL);
        }
        override public function get events():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ([PlayKernelEvent.PreloadStart, PlayKernelEvent.SwitchQualityStart, PlayKernelEvent.ReconnectStart, PlayKernelEvent.PreloadSuccess, PlayKernelEvent.SwitchQualitySuccess, PlayKernelEvent.ReconnectSuccess]);
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.monitor != null){
                if (false){
                    5;
                    this.onMonitorEvent;
                    MediaEvent.ALL;
                    this.monitor;
                } else {
                    this.monitor.removeEventListener(MediaEvent.ALL, this.onMonitorEvent);
                };
                this.monitor = null;
            };
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:MediaProxy;
            /*switch (){
                    if (false){
                        5;
                        this;
                    } else {
                        this.onRemove();
                    };
                    break;
                    _local3 = _arg2["result"];
                    if (false){
                        5;
                        _local3.traffic;
                        this;
                    } else {
                        this.setMonitor(_local3.traffic);
                    };
                    break;
            }*/;
        }
        private function setMonitor(_arg1:TrafficMonitor):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this;
            } else {
                this.onRemove();
            };
            this.monitor = _arg1;
            if (false){
                5;
                this.onMonitorEvent;
                MediaEvent.ALL;
                this.monitor;
            } else {
                this.monitor.addEventListener(MediaEvent.ALL, this.onMonitorEvent);
            };
            if (false){
                5;
                data.hasTrafficStatistics;
                this.monitor;
            } else {
                this.monitor.start(data.hasTrafficStatistics);
            };
            return;
            /*not popped
            data.hasTrafficStatistics
            */
            /*not popped
            this.monitor
            */
            /*not popped
            this.onMonitorEvent
            */
            /*not popped
            MediaEvent.ALL
            */
            /*not popped
            this.monitor
            */
            /*not popped
            this
            */
        }
        private function onMonitorEvent(_arg1:MediaEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:TrafficInfo;
            if (_arg1.code == TrafficMonitor.Progress){
                _local2 = _arg1.value;
                if (false){
                    5;
                    _local2.time;
                    _local2.token;
                    Math.floor((_local2.loaded / 0x0400));
                    this;
                } else {
                    this.trafficLog(Math.floor((_local2.loaded / 0x0400)), _local2.token, _local2.time);
                };
            };
        }
        private function trafficLog(_arg1:Number, _arg2:Number, _arg3:Number):void{
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
                data.videoid;
                "vid";
                ;
            } else {
                addParam("vid", data.videoid);
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
                data.play_domain;
                "url";
                ;
            } else {
                addParam("url", data.play_domain);
            };
            if (false){
                5;
                _arg2;
                "token";
                ;
            } else {
                addParam("token", _arg2);
            };
            if (false){
                5;
                _arg1;
                "amount";
                ;
            } else {
                addParam("amount", _arg1);
            };
            if (false){
                5;
                _arg3;
                "time";
                ;
            } else {
                addParam("time", _arg3);
            };
            if (false){
                5;
                MD5.hash((((data.videoid + _arg2) + _arg1) + "FlowRateLog"));
                "hash";
                ;
            } else {
                addParam("hash", MD5.hash((((data.videoid + _arg2) + _arg1) + "FlowRateLog")));
            };
            if (false){
                5;
                LogEvent.Traffic;
                ;
            } else {
                send(LogEvent.Traffic);
            };
            return;
            /*not popped
            LogEvent.Traffic
            */
            /*not popped
            MD5.hash((((data.videoid + _arg2) + _arg1) + "FlowRateLog"))
            */
            /*not popped
            "hash"
            */
            /*not popped
            _arg3
            */
            /*not popped
            "time"
            */
            /*not popped
            _arg1
            */
            /*not popped
            "amount"
            */
            /*not popped
            _arg2
            */
            /*not popped
            "token"
            */
            /*not popped
            data.play_domain
            */
            /*not popped
            "url"
            */
            /*not popped
            data.userid
            */
            /*not popped
            "uid"
            */
            /*not popped
            data.videoid
            */
            /*not popped
            "vid"
            */
        }

        if (37 == 34){
            return;
            /*not popped
            TrafficLog
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
}//package com.bokecc.platform.playkernel.module.logger.items.traffic 
