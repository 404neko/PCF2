package com.bokecc.lib.media.core.videocore {
    import flash.events.*;
    import com.bokecc.lib.media.*;
    import flash.net.*;
    import flash.utils.*;
    import flash.media.*;

    public class VideoCore extends EventDispatcher implements IVideoCore {

        private var _file:String;
        private var _param:String = "";
        private var _volume:Number = 1;
        private var _bufferTime:Number = 3;
        private var _bytesLoaded:Number = 0;
        private var _bytesTotal:Number = 0;
        private var _meta:Meta;
        private var _ns:NetStream;
        private var conn:Connection;
        private var timer:Timer;
        private var seekTimer:Timer;

        public function VideoCore(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.timer = new Timer(50);
            this.seekTimer = new Timer(100);
            super();
            if (false){
                5;
                this.checkLoadFinish;
                TimerEvent.TIMER;
                this.timer;
            } else {
                this.timer.addEventListener(TimerEvent.TIMER, this.checkLoadFinish);
            };
            if (false){
                5;
                this.seekTimeOut;
                TimerEvent.TIMER;
                this.seekTimer;
            } else {
                this.seekTimer.addEventListener(TimerEvent.TIMER, this.seekTimeOut);
            };
            return;
            /*not popped
            this.seekTimeOut
            */
            /*not popped
            TimerEvent.TIMER
            */
            /*not popped
            this.seekTimer
            */
            /*not popped
            this.checkLoadFinish
            */
            /*not popped
            TimerEvent.TIMER
            */
            /*not popped
            this.timer
            */
        }
        private function checkLoadFinish(_arg1:TimerEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Number = this.ns.bytesTotal;
            if ((((((this._bytesTotal > 0)) && (!((this._bytesTotal == _local2))))) || ((_local2 == 0xFFFFFFFF)))){
                return;
            };
            this._bytesLoaded = this.ns.bytesLoaded;
            this._bytesTotal = _local2;
            if (this.loadFinish){
                if (false){
                    5;
                    this.timer;
                } else {
                    this.timer.stop();
                };
                if (false){
                    5;
                    {code:MediaEvent.LoadFinish};
                    VideoCoreEvent.NetStreamStatus;
                    this;
                } else {
                    this.dispatch(VideoCoreEvent.NetStreamStatus, {code:MediaEvent.LoadFinish});
                };
            };
        }
        public function get connection():Connection{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.conn);
        }
        public function get ns():NetStream{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._ns);
        }
        public function play(_arg1:String, _arg2:String="", _arg3:String=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._param = _arg2;
            this._file = _arg1;
            this.conn = Connection.getInstance(_arg3);
            if (false){
                5;
                this.onNetConnectionStatus;
                NetStatusEvent.NET_STATUS;
                this.conn;
            } else {
                this.conn.addEventListener(NetStatusEvent.NET_STATUS, this.onNetConnectionStatus);
            };
            return;
            /*not popped
            ((this.conn.connected) ? if (false){
    5;
    this;
} else {
    this.nsPlay();
};
this : if (false){
    5;
    this.conn;
} else {
    this.conn.connect();
};
this.conn)
            */
            /*not popped
            this.onNetConnectionStatus
            */
            /*not popped
            NetStatusEvent.NET_STATUS
            */
            /*not popped
            this.conn
            */
        }
        protected function nsPlay():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:Object;
            var _local1:NetStream = this.conn.getStream(this._file, false);
            var _local2:Boolean = ((!((this.ns == _local1))) || ((this.ns == null)));
            if (_local2){
                if (false){
                    5;
                    this;
                } else {
                    this.stop();
                };
                this._ns = _local1;
                if (false){
                    5;
                    {
                        code:NetStatus.DisplayUpdated,
                        displayobject:this.ns
                    };
                    VideoCoreEvent.NetStreamStatus;
                    this;
                } else {
                    this.dispatch(VideoCoreEvent.NetStreamStatus, {
                        code:NetStatus.DisplayUpdated,
                        displayobject:this.ns
                    });
                };
                _local3 = {};
                if (false){
                    5;
                    this.onMetaData;
                    "onMetaData";
                    _local3;
                } else {
                    _local3["onMetaData"] = this.onMetaData;
                };
                if (this.conn.isRTMP){
                    if (false){
                        5;
                        this.onRtmpPlayStatus;
                        "onPlayStatus";
                        _local3;
                    } else {
                        _local3["onPlayStatus"] = this.onRtmpPlayStatus;
                    };
                    if (false){
                        5;
                        true;
                        this.ns;
                    } else {
                        this.ns.inBufferSeek = true;
                    };
                };
                if (false){
                    5;
                    _local3;
                    this.ns;
                } else {
                    this.ns.client = _local3;
                };
                this.volume = this._volume;
                this.bufferTime = this._bufferTime;
            };
            this._bytesLoaded = (this._bytesTotal = 0);
            if (!this.conn.isRTMP){
                if (false){
                    5;
                    this.timer;
                } else {
                    this.timer.start();
                };
            };
            if (false){
                5;
                this.onNetStreamStatus;
                NetStatusEvent.NET_STATUS;
                this.ns;
            } else {
                this.ns.addEventListener(NetStatusEvent.NET_STATUS, this.onNetStreamStatus);
            };
            if (false){
                5;
                (this._file + this._param);
                this.ns;
            } else {
                this.ns.play((this._file + this._param));
            };
            return;
            /*not popped
            (this._file + this._param)
            */
            /*not popped
            this.ns
            */
            /*not popped
            this.onNetStreamStatus
            */
            /*not popped
            NetStatusEvent.NET_STATUS
            */
            /*not popped
            this.ns
            */
        }
        public function pause():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.ns){
                if (false){
                    5;
                    this.ns;
                } else {
                    this.ns.pause();
                };
            };
        }
        public function resume():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.ns){
                if (false){
                    5;
                    this.ns;
                } else {
                    this.ns.resume();
                };
            };
        }
        public function seek(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.ns){
                if (!this.seekTimer.running){
                    if (false){
                        5;
                        _arg1;
                        this.ns;
                    } else {
                        this.ns.seek(_arg1);
                    };
                    if (false){
                        5;
                        this.seekTimer;
                    } else {
                        this.seekTimer.start();
                    };
                };
            };
        }
        private function seekTimeOut(_arg1:TimerEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.seekTimer;
            } else {
                this.seekTimer.stop();
            };
            return;
            /*not popped
            this.seekTimer
            */
        }
        public function stop():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.timer;
            } else {
                this.timer.stop();
            };
            if (this.ns == null){
                return;
                /*not popped
                this.timer
                */
            };
            if (false){
                5;
                this.onNetStreamStatus;
                NetStatusEvent.NET_STATUS;
                this.ns;
            } else {
                this.ns.removeEventListener(NetStatusEvent.NET_STATUS, this.onNetStreamStatus);
            };
            if (false){
                5;
                this.ns;
            } else {
                this.ns.close();
            };
            return;
            /*not popped
            this.ns
            */
            /*not popped
            this.onNetStreamStatus
            */
            /*not popped
            NetStatusEvent.NET_STATUS
            */
            /*not popped
            this.ns
            */
            /*not popped
            this.timer
            */
        }
        public function get meta():Meta{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._meta);
        }
        public function set volume(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._volume = _arg1;
            if (this.ns == null){
                return;
            };
            var _local2:SoundTransform = this.ns.soundTransform;
            if (false){
                5;
                _arg1;
                _local2;
            } else {
                _local2.volume = _arg1;
            };
            if (false){
                5;
                _local2;
                this.ns;
            } else {
                this.ns.soundTransform = _local2;
            };
            return;
            /*not popped
            _local2
            */
            /*not popped
            this.ns
            */
            /*not popped
            _arg1
            */
            /*not popped
            _local2
            */
        }
        public function get volume():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._volume);
        }
        public function get position():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.ns){
                return (this.ns.time);
            };
            return (NaN);
        }
        public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this._meta){
                return (this._meta.duration);
            };
            return (0);
        }
        public function get loadFinish():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((((this.bytesTotal > 0)) && ((this.bytesLoaded >= this.bytesTotal))));
        }
        public function get bytesLoaded():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.ns){
                return (this.ns.bytesLoaded);
            };
            return (0);
        }
        public function get bytesTotal():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.ns){
                return (this.ns.bytesTotal);
            };
            return (0);
        }
        public function get bufferLength():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.ns){
                return (this.ns.bufferLength);
            };
            return (0);
        }
        public function set bufferTime(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this._bufferTime = _arg1;
            if (((this.ns) && (!((this.ns.bufferTime == _arg1))))){
                if (false){
                    5;
                    _arg1;
                    this.ns;
                } else {
                    this.ns.bufferTime = _arg1;
                };
            };
        }
        public function get bufferTime():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (this.ns){
                return (this.ns.bufferTime);
            };
            return (this._bufferTime);
        }
        protected function onMetaData(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._meta = new Meta(_arg1);
            if (this.conn.isRTMP){
                this._bytesTotal = this._meta.filesize;
            };
            if (false){
                5;
                this._meta;
                VideoCoreEvent.MetaData;
                this;
            } else {
                this.dispatch(VideoCoreEvent.MetaData, this._meta);
            };
            return;
            /*not popped
            this._meta
            */
            /*not popped
            VideoCoreEvent.MetaData
            */
            /*not popped
            this
            */
        }
        private function onRtmpPlayStatus(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                VideoCoreEvent.NetStreamStatus;
                this;
            } else {
                this.dispatch(VideoCoreEvent.NetStreamStatus, _arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            VideoCoreEvent.NetStreamStatus
            */
            /*not popped
            this
            */
        }
        private function onNetConnectionStatus(_arg1:NetStatusEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:String = _arg1.info["code"];
            /*switch (){
                    if (false){
                        5;
                        this;
                    } else {
                        this.nsPlay();
                    };
                    break;
            }*/;
            if (false){
                5;
                _arg1.info;
                VideoCoreEvent.NetConnectionStatus;
                this;
            } else {
                this.dispatch(VideoCoreEvent.NetConnectionStatus, _arg1.info);
            };
            return;
            /*not popped
            _arg1.info
            */
            /*not popped
            VideoCoreEvent.NetConnectionStatus
            */
            /*not popped
            this
            */
        }
        protected function onNetStreamStatus(_arg1:NetStatusEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:String = _arg1.info["code"];
            /*switch (){
                    if (false){
                        5;
                        this.timer;
                    } else {
                        this.timer.stop();
                    };
                    break;
                    if (false){
                        5;
                        _arg1.info["details"];
                        this;
                    } else {
                        this.seek(_arg1.info["details"]);
                    };
                    break;
            }*/;
            if (false){
                5;
                _arg1.info;
                VideoCoreEvent.NetStreamStatus;
                this;
            } else {
                this.dispatch(VideoCoreEvent.NetStreamStatus, _arg1.info);
            };
            return;
            /*not popped
            _arg1.info
            */
            /*not popped
            VideoCoreEvent.NetStreamStatus
            */
            /*not popped
            this
            */
        }
        protected function dispatch(_arg1:String, _arg2:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new VideoCoreEvent(_arg1, _arg2);
                ;
            } else {
                dispatchEvent(new VideoCoreEvent(_arg1, _arg2));
            };
            return;
            /*not popped
            new VideoCoreEvent(_arg1, _arg2)
            */
        }

        if (37 == 34){
            return;
            /*not popped
            VideoCore
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.core.videocore 
