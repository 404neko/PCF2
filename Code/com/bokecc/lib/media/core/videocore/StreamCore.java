package com.bokecc.lib.media.core.videocore {
    import flash.events.*;
    import com.bokecc.lib.media.*;
    import flash.net.*;
    import flash.utils.*;
    import com.bokecc.lib.data.*;
    import com.bokecc.lib.media.utils.*;
    import com.bokecc.lib.crypto.*;
    import flash.media.*;

    public class StreamCore extends EventDispatcher implements IVideoCore {

        private static const PCFTagsFields:Array = ["version", "vid", "uid", "reserved"];

        private var des:DES;
        private var pcfInfo:Object;
        private var pcfParseState:int;
        private var _file:String;
        private var _param:String = "";
        private var _volume:Number = 1;
        private var _bufferTime:Number = 3;
        private var _bytesTotal:Number;
        private var headerParsed:Boolean = false;
        private var fileType:String;
        private var fileSize:Number;
        private var playStart:Number = 0;
        private var loadStart:Number = 0;
        private var appendPosition:Number = 0;
        private var loading:Boolean = false;
        private var seeking:Boolean = false;
        private var serverSeek:Boolean = false;
        private var playFinished:Boolean = false;
        private var loadComplete:Boolean = false;
        private var _meta:Meta;
        private var _ns:NetStream;
        private var conn:Connection;
        private var loader:URLStream;
        private var wholeBytes:FileBytes;
        private var metaByteArray:ByteArray;
        private var checkBufferTimer:Timer;
        private var seekTimer:Timer;
        private var fieldLength:int = -1;

        public function StreamCore(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.des = new DES("Iori264A");
            this.checkBufferTimer = new Timer(50);
            this.seekTimer = new Timer(300);
            super();
            if (false){
                5;
                this.des.decode("B0383F168494C8B07D5D636D9B377913");
                this.des;
            } else {
                this.des.key = this.des.decode("B0383F168494C8B07D5D636D9B377913");
            };
            if (false){
                5;
                this.checkBuffer;
                TimerEvent.TIMER;
                this.checkBufferTimer;
            } else {
                this.checkBufferTimer.addEventListener(TimerEvent.TIMER, this.checkBuffer);
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
            this.checkBuffer
            */
            /*not popped
            TimerEvent.TIMER
            */
            /*not popped
            this.checkBufferTimer
            */
            /*not popped
            this.des.decode("B0383F168494C8B07D5D636D9B377913")
            */
            /*not popped
            this.des
            */
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
            this.conn = Connection.getInstance();
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
        private function newNS():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:NetStream = this.conn.getStream(this._file, true);
            var _local2:Boolean = ((!((this.ns == _local1))) || ((this.ns == null)));
            if (_local2){
                if (this.ns){
                    if (false){
                        5;
                        this.onNetStreamStatus;
                        NetStatusEvent.NET_STATUS;
                        this.ns;
                    } else {
                        this.ns.removeEventListener(NetStatusEvent.NET_STATUS, this.onNetStreamStatus);
                    };
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
                if (false){
                    5;
                    {onMetaData:this.onMetaData};
                    this.ns;
                } else {
                    this.ns.client = {onMetaData:this.onMetaData};
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
                    null;
                    this.ns;
                } else {
                    this.ns.play(null);
                };
                this.volume = this._volume;
            };
        }
        private function nsPlay():void{
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
                this.stop();
            };
            if (false){
                5;
                this;
            } else {
                this.newNS();
            };
            this.playFinished = false;
            this.playStart = (this.loadStart = (this.appendPosition = 0));
            this.serverSeek = (this._param.indexOf("start=") > 0);
            var start:* = Number(String(this._param.split("start=")[1]).split("=")[0]);
            if (start == 0){
                this.serverSeek = false;
            };
            if (this.serverSeek){
                this.loadStart = start;
                this.playStart = this.meta.getTime(this.meta.getKeyframeIndex(this.loadStart, false));
            } else {
                this._bytesTotal = 0;
                if (this.metaByteArray){
                    if (false){
                        5;
                        this.metaByteArray;
                    } else {
                        this.metaByteArray.clear();
                    };
                    this.metaByteArray = null;
                };
            };
            if (false){
                5;
                this;
            } else {
                this.clearCache();
            };
            this.pcfParseState = 0;
            this.pcfInfo = {};
            this.fileType = "";
            this.fileSize = 0;
            this.loading = true;
            this.seeking = false;
            this.headerParsed = false;
            this.loadComplete = false;
            this.bufferTime = this._bufferTime;
            this.loader = new URLStream();
            if (false){
                5;
                this.onLoadComplete;
                Event.COMPLETE;
                this.loader;
            } else {
                this.loader.addEventListener(Event.COMPLETE, this.onLoadComplete);
            };
            if (false){
                5;
                this.onProgress;
                ProgressEvent.PROGRESS;
                this.loader;
            } else {
                this.loader.addEventListener(ProgressEvent.PROGRESS, this.onProgress);
            };
            if (false){
                5;
                this.onLoadError;
                IOErrorEvent.IO_ERROR;
                this.loader;
            } else {
                this.loader.addEventListener(IOErrorEvent.IO_ERROR, this.onLoadError);
            };
            if (false){
                5;
                this.onLoadError;
                SecurityErrorEvent.SECURITY_ERROR;
                this.loader;
            } else {
                this.loader.addEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onLoadError);
            };
            try {
                if (false){
                    5;
                    new URLRequest((this._file + this._param));
                    this.loader;
                } else {
                    this.loader.load(new URLRequest((this._file + this._param)));
                };
            } catch(e:Error) {
                if (false){
                    5;
                    ;
                } else {
                    onLoadError();
                };
            };
            return;
            /*not popped
            new URLRequest((this._file + this._param))
            */
            /*not popped
            this.loader
            */
            /*not popped
            this.onLoadError
            */
            /*not popped
            SecurityErrorEvent.SECURITY_ERROR
            */
            /*not popped
            this.loader
            */
            /*not popped
            this.onLoadError
            */
            /*not popped
            IOErrorEvent.IO_ERROR
            */
            /*not popped
            this.loader
            */
            /*not popped
            this.onProgress
            */
            /*not popped
            ProgressEvent.PROGRESS
            */
            /*not popped
            this.loader
            */
            /*not popped
            this.onLoadComplete
            */
            /*not popped
            Event.COMPLETE
            */
            /*not popped
            this.loader
            */
            /*not popped
            this
            */
            /*not popped
            this
            */
            /*not popped
            this
            */
        }
        private function onLoadError(_arg1:Event=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                {code:NetStatus.StreamNotFound};
                VideoCoreEvent.NetStreamStatus;
                this;
            } else {
                this.dispatch(VideoCoreEvent.NetStreamStatus, {code:NetStatus.StreamNotFound});
            };
            if (this.fileSize <= 0){
                if (false){
                    5;
                    {code:NetStatus.BufferEmpty};
                    VideoCoreEvent.NetStreamStatus;
                    this;
                } else {
                    this.dispatch(VideoCoreEvent.NetStreamStatus, {code:NetStatus.BufferEmpty});
                };
            };
            return;
            /*not popped
            {code:NetStatus.StreamNotFound}
            */
            /*not popped
            VideoCoreEvent.NetStreamStatus
            */
            /*not popped
            this
            */
        }
        private function onLoadComplete(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.loadComplete = true;
            if (false){
                5;
                0.1;
                this.ns;
            } else {
                this.ns.bufferTime = 0.1;
            };
            if (false){
                5;
                this;
            } else {
                this.readLoader();
            };
            if (false){
                5;
                this;
            } else {
                this.checkLoadComplete();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            this
            */
            /*not popped
            0.1
            */
            /*not popped
            this.ns
            */
        }
        private function checkLoadComplete():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (((this.loadComplete) && (this.meta))){
                if (this.loadFinish){
                    if (false){
                        5;
                        {code:MediaEvent.LoadFinish};
                        VideoCoreEvent.NetStreamStatus;
                        this;
                    } else {
                        this.dispatch(VideoCoreEvent.NetStreamStatus, {code:MediaEvent.LoadFinish});
                    };
                } else {
                    if (false){
                        5;
                        this;
                    } else {
                        this.onLoadError();
                    };
                };
            };
        }
        private function onProgress(_arg1:ProgressEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.fileSize <= 0){
                this.fileSize = _arg1.bytesTotal;
            };
            if (false){
                5;
                this;
            } else {
                this.readLoader();
            };
            return;
            /*not popped
            this
            */
        }
        private function readLoader():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:Number;
            var _local4:Boolean;
            var _local5:String;
            var _local6:Boolean;
            var _local7:int;
            var _local8:int;
            var _local9:int;
            var _local10:ByteArray;
            var _local11:ByteArray;
            var _local1:ByteArray = new ByteArray();
            var _local2:uint = this.loader.bytesAvailable;
            if (this.headerParsed){
                if (_local2 > 0){
                    _local3 = _local2;
                    if (this.bytesTotal > 0){
                        _local3 = Math.min(_local2, (this.bytesTotal - this.wholeBytes.length));
                    };
                    if (_local3 > 0){
                        if (false){
                            5;
                            _local3;
                            0;
                            _local1;
                            this.loader;
                        } else {
                            this.loader.readBytes(_local1, 0, _local3);
                        };
                        if (false){
                            5;
                            _local1;
                            this.wholeBytes;
                        } else {
                            this.wholeBytes.push(_local1);
                        };
                    };
                };
            } else {
                if (this.fileSize > 0){
                    if (this.fileType == ""){
                        if (_local2 >= 3){
                            this.fileType = this.loader.readMultiByte(3, "utf-8");
                            if (false){
                                5;
                                {
                                    code:MediaEvent.GetFileType,
                                    fileType:this.fileType
                                };
                                VideoCoreEvent.NetStreamStatus;
                                this;
                            } else {
                                this.dispatch(VideoCoreEvent.NetStreamStatus, {
                                    code:MediaEvent.GetFileType,
                                    fileType:this.fileType
                                });
                            };
                        };
                    };
                    if (this.fileType == "PCF"){
                        _local4 = true;
                        while (((_local4) && (!(this.headerParsed)))) {
                            _local2 = this.loader.bytesAvailable;
                            _local5 = PCFTagsFields[this.pcfParseState];
                            //unresolved jump
                            _local4 = (_local2 >= 4);
                            if (_local4){
                                if (false){
                                    5;
                                    this.loader.readInt();
                                    _local5;
                                    this.pcfInfo;
                                } else {
                                    this.pcfInfo[_local5] = this.loader.readInt();
                                };
                                var _local12 = this;
                                var _local13 = (_local12.pcfParseState + 1);
                                if (false){
                                    5;
                                    _local13;
                                    _local12;
                                } else {
                                    _local12.pcfParseState = _local13;
                                };
                            };
                            continue;
                            if (this.fieldLength == -1){
                                _local4 = (_local2 >= 4);
                                if (_local4){
                                    this.fieldLength = this.loader.readInt();
                                };
                            } else {
                                _local4 = (_local2 >= this.fieldLength);
                                if (_local4){
                                    if (false){
                                        5;
                                        this.loader.readMultiByte(this.fieldLength, "utf-8");
                                        _local5;
                                        this.pcfInfo;
                                    } else {
                                        this.pcfInfo[_local5] = this.loader.readMultiByte(this.fieldLength, "utf-8");
                                    };
                                    this.fieldLength = -1;
                                    _local12 = this;
                                    _local13 = (_local12.pcfParseState + 1);
                                    if (false){
                                        5;
                                        _local13;
                                        _local12;
                                    } else {
                                        _local12.pcfParseState = _local13;
                                    };
                                };
                            };
                            continue;
                            _local6 = (this.version == 3);
                            //unresolved if
                            _local7 = 8184;
                            _local8 = ((_local6) ? 5 : 4);
                            _local9 = (_local7 * _local8);
                            _local4 = (_local2 >= _local9);
                            //unresolved if
                            if (_local8 <= 0){
                            } else {
                                //unresolved jump
                            };
                            //unresolved jump
                            _local8--;
                            _local10 = new ByteArray();
                            if (false){
                                5;
                                _local7;
                                0;
                                _local10;
                                this.loader;
                            } else {
                                this.loader.readBytes(_local10, 0, _local7);
                            };
                            if (false){
                                5;
                                _local10;
                                this.des;
                            } else {
                                this.des.decrypt(_local10);
                            };
                            if (false){
                                5;
                                _local10;
                                _local1;
                            } else {
                                _local1.writeBytes(_local10);
                            };
                            //unresolved if
                        };
                    } else {
                        _local2 = this.loader.bytesAvailable;
                        if (_local2 > 10){
                            if (false){
                                5;
                                "F".charCodeAt(0);
                                _local1;
                            } else {
                                _local1.writeByte("F".charCodeAt(0));
                            };
                            if (false){
                                5;
                                "L".charCodeAt(0);
                                _local1;
                            } else {
                                _local1.writeByte("L".charCodeAt(0));
                            };
                            if (false){
                                5;
                                "V".charCodeAt(0);
                                _local1;
                            } else {
                                _local1.writeByte("V".charCodeAt(0));
                            };
                            if (false){
                                5;
                                _local2;
                                3;
                                _local1;
                                this.loader;
                            } else {
                                this.loader.readBytes(_local1, 3, _local2);
                            };
                            this.headerParsed = true;
                        };
                    };
                    if (this.headerParsed){
                        this.wholeBytes = new FileBytes();
                        if (this.serverSeek){
                            if (false){
                                5;
                                13;
                                _local1;
                            } else {
                                _local1.position = 13;
                            };
                            _local11 = new ByteArray();
                            if (false){
                                5;
                                _local11;
                                _local1;
                            } else {
                                _local1.readBytes(_local11);
                            };
                            if (false){
                                5;
                                _local11;
                                this.wholeBytes;
                            } else {
                                this.wholeBytes.push(_local11);
                            };
                            if (false){
                                5;
                                NetStreamAppendBytesAction.RESET_SEEK;
                                0;
                                this;
                            } else {
                                this.appendBytes(0, NetStreamAppendBytesAction.RESET_SEEK);
                            };
                        } else {
                            if (false){
                                5;
                                _local1;
                                this.wholeBytes;
                            } else {
                                this.wholeBytes.push(_local1);
                            };
                            if (false){
                                5;
                                NetStreamAppendBytesAction.RESET_BEGIN;
                                0;
                                this;
                            } else {
                                this.appendBytes(0, NetStreamAppendBytesAction.RESET_BEGIN);
                            };
                        };
                        if (false){
                            5;
                            this.checkBufferTimer;
                        } else {
                            this.checkBufferTimer.start();
                        };
                    };
                };
            };
        }
        private function checkBuffer(_arg1:TimerEvent=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:Boolean;
            var _local2:Boolean = (((this.bytesTotal > 0)) && ((this.appendPosition >= this.bytesTotal)));
            if (!_local2){
                if (false){
                    5;
                    this.appendPosition;
                    this;
                } else {
                    this.appendBytes(this.appendPosition);
                };
                _local2 = (this.appendPosition >= this.bytesTotal);
            };
            if ((((this.duration > 0)) && ((this.position >= this.duration)))){
                if (false){
                    5;
                    this;
                } else {
                    this.checkPlayFinish();
                };
            } else {
                _local3 = (this.bufferLength > this.bufferTime);
                if (((((this.loading) || (this.seeking))) && (((_local3) || (_local2))))){
                    if (false){
                        5;
                        this;
                    } else {
                        this.dispatchBufferFull();
                    };
                };
            };
        }
        private function appendBytes(_arg1:Number, _arg2:String=""):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:ByteArray;
            var _local4:int;
            var _local5:ByteArray;
            if (((this.ns) && (this.wholeBytes))){
                _local3 = this.wholeBytes.getBytes(_arg1, (_arg1 + FileBytes.MAX));
                _local4 = _local3.length;
                if (_local4 > 0){
                    this.appendPosition = (_arg1 + _local4);
                    if (_arg2 != ""){
                        if (_arg2 != NetStreamAppendBytesAction.RESET_BEGIN){
                            _local5 = new ByteArray();
                            if (this.metaByteArray){
                                if (false){
                                    5;
                                    0;
                                    this.metaByteArray;
                                } else {
                                    this.metaByteArray.position = 0;
                                };
                                if (false){
                                    5;
                                    _local5;
                                    this.metaByteArray;
                                } else {
                                    this.metaByteArray.readBytes(_local5);
                                };
                                if (false){
                                    5;
                                    NetStreamAppendBytesAction.RESET_BEGIN;
                                    this.ns;
                                } else {
                                    this.ns.appendBytesAction(NetStreamAppendBytesAction.RESET_BEGIN);
                                };
                                if (false){
                                    5;
                                    _local5;
                                    this.ns;
                                } else {
                                    this.ns.appendBytes(_local5);
                                };
                            };
                        };
                        if (false){
                            5;
                            _arg2;
                            this.ns;
                        } else {
                            this.ns.appendBytesAction(_arg2);
                        };
                    };
                    if (false){
                        5;
                        _local3;
                        this.ns;
                    } else {
                        this.ns.appendBytes(_local3);
                    };
                };
            };
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
            if (!this.seekTimer.running){
                if (false){
                    5;
                    _arg1;
                    this;
                } else {
                    this.nsSeek(_arg1);
                };
                if (false){
                    5;
                    this.seekTimer;
                } else {
                    this.seekTimer.start();
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
            //unresolved jump
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
        private function nsSeek(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if ((((((this.ns == null)) || ((this.meta == null)))) || (!(this.meta.hasKeyframes)))){
                return;
            };
            if ((((this.duration > 0)) && ((_arg1 >= this.duration)))){
                return;
            };
            var _local2:int = this.meta.getKeyframeIndex(_arg1);
            if (_local2 == -1){
                return;
            };
            this.seeking = true;
            this.playFinished = false;
            this.playStart = this.meta.getTime(_local2);
            if (false){
                5;
                this.checkBufferTimer;
            } else {
                this.checkBufferTimer.stop();
            };
            if (false){
                5;
                this;
            } else {
                this.newNS();
            };
            if (false){
                5;
                0;
                this.ns;
            } else {
                this.ns.seek(0);
            };
            var _local3:Number = (this.meta.getFileposition(_local2) - this.loadStart);
            if ((((((this.version == 2)) || ((this.version == 3)))) && ((_local2 == 0)))){
                _local3 = this.metaByteArray.length;
            };
            if (false){
                5;
                NetStreamAppendBytesAction.RESET_SEEK;
                _local3;
                this;
            } else {
                this.appendBytes(_local3, NetStreamAppendBytesAction.RESET_SEEK);
            };
            if (false){
                5;
                this.checkBufferTimer;
            } else {
                this.checkBufferTimer.start();
            };
            return;
            /*not popped
            this.checkBufferTimer
            */
            /*not popped
            NetStreamAppendBytesAction.RESET_SEEK
            */
            /*not popped
            _local3
            */
            /*not popped
            this
            */
            /*not popped
            0
            */
            /*not popped
            this.ns
            */
            /*not popped
            this
            */
            /*not popped
            this.checkBufferTimer
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
                this.checkBufferTimer;
            } else {
                this.checkBufferTimer.stop();
            };
            if (false){
                5;
                this;
            } else {
                this.closeLoader();
            };
            if (false){
                5;
                this;
            } else {
                this.clearCache();
            };
            if (this.ns){
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
                this._ns = null;
            };
            return;
            /*not popped
            this
            */
            /*not popped
            this
            */
            /*not popped
            this.checkBufferTimer
            */
        }
        private function clearCache():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.wholeBytes){
                if (false){
                    5;
                    this.wholeBytes;
                } else {
                    this.wholeBytes.clear();
                };
                this.wholeBytes = null;
            };
        }
        private function closeLoader():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.loader){
                if (false){
                    5;
                    this.onProgress;
                    ProgressEvent.PROGRESS;
                    this.loader;
                } else {
                    this.loader.removeEventListener(ProgressEvent.PROGRESS, this.onProgress);
                };
                if (false){
                    5;
                    this.onLoadError;
                    IOErrorEvent.IO_ERROR;
                    this.loader;
                } else {
                    this.loader.removeEventListener(IOErrorEvent.IO_ERROR, this.onLoadError);
                };
                if (false){
                    5;
                    this.onLoadError;
                    SecurityErrorEvent.SECURITY_ERROR;
                    this.loader;
                } else {
                    this.loader.removeEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onLoadError);
                };
                if (false){
                    5;
                    this.onLoadComplete;
                    Event.COMPLETE;
                    this.loader;
                } else {
                    this.loader.removeEventListener(Event.COMPLETE, this.onLoadComplete);
                };
                try {
                    if (false){
                        5;
                        this.loader;
                    } else {
                        this.loader.close();
                    };
                } catch(e:Error) {
                };
                this.loader = null;
            };
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
            var _local1:Number = this.playStart;
            if (((this.ns) && (!(isNaN(this.ns.time))))){
                _local1 = (_local1 + this.ns.time);
            };
            _local1 = exact(_local1, 3);
            return (_local1);
        }
        public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.meta){
                return (this.meta.duration);
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
            if (this.wholeBytes){
                return (this.wholeBytes.length);
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
            if (this._bytesTotal <= 0){
                return (this._bytesTotal);
            };
            return ((this._bytesTotal - this.loadStart));
        }
        public function get bufferLength():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
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
            if (this.ns){
                return (this.ns.bufferTime);
            };
            return (this._bufferTime);
        }
        public function get version():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.pcfInfo[PCFTagsFields[0]]);
        }
        public function get vid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.pcfInfo[PCFTagsFields[1]]);
        }
        private function onMetaData(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:String;
            var _local3:String;
            var _local4:int;
            var _local5:int;
            var _local6:int;
            if (this.fileType == "CCC"){
                _local2 = _arg1["metadatacreator"];
                if (((!((_local2 == null))) && ((_local2.indexOf("videoid ") == 0)))){
                    if (false){
                        5;
                        _local2.split(" ")[1];
                        PCFTagsFields[1];
                        this.pcfInfo;
                    } else {
                        this.pcfInfo[PCFTagsFields[1]] = _local2.split(" ")[1];
                    };
                };
            };
            if (this.pcfInfo){
                var _local7:int;
                var _local8:* = this.pcfInfo;
                //unexpected hasnext2
                if (!!NULL!){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local3 = //unresolved nextvalue or nextname;
                if (false){
                    5;
                    this.pcfInfo[_local3];
                    _local3;
                    _arg1;
                } else {
                    _arg1[_local3] = this.pcfInfo[_local3];
                };
                //unresolved if
            };
            this._meta = new Meta(_arg1);
            if (this.bufferTime > this.duration){
                if (false){
                    5;
                    0.1;
                    this.ns;
                } else {
                    this.ns.bufferTime = 0.1;
                };
            };
            this._bytesTotal = this.meta.filesize;
            if (this.metaByteArray == null){
                this.metaByteArray = this.wholeBytes.getBytes(0, this.meta.getFileposition(1));
            };
            if ((((((this.version == 2)) || ((this.version == 3)))) && (this.meta.hasKeyframes))){
                if (false){
                    5;
                    0;
                    0;
                    0;
                    this.meta;
                } else {
                    this.meta.setKeyframe(0, 0, 0);
                };
                _local4 = (8176 * (((this.version == 3)) ? 5 : 4));
                _local5 = this.meta.getKeyframeIndex(_local4, false);
                if (_local5 <= 0){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local6 = this.meta.getFileposition(_local5);
                if ((((_local6 < _local4)) && ((_local6 > 0)))){
                    if (false){
                        5;
                        _local5;
                        this.meta;
                    } else {
                        this.meta.removeKeyframes(_local5);
                    };
                };
                _local5--;
                //unresolved if
            };
            if (false){
                5;
                this.meta;
                VideoCoreEvent.MetaData;
                this;
            } else {
                this.dispatch(VideoCoreEvent.MetaData, this.meta);
            };
            if (this.loadComplete){
                if (false){
                    5;
                    this;
                } else {
                    this.checkLoadComplete();
                };
            };
            return;
            /*not popped
            this.meta
            */
            /*not popped
            VideoCoreEvent.MetaData
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
        private function onNetStreamStatus(_arg1:NetStatusEvent):void{
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
                        this.checkPlayFinish();
                    };
                    this.loading = true;
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
        private function checkPlayFinish():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local1:Boolean;
            var _local2:Number;
            var _local3:Number;
            if (!this.playFinished){
                _local1 = false;
                if (this.meta){
                    _local2 = this.meta.duration;
                    _local3 = (_local2 - this.bufferTime);
                    _local1 = (((((_local3 > 0)) && ((this.position > _local3)))) || ((Math.abs((_local2 - this.position)) < 1)));
                };
                if (((this.loadFinish) && (_local1))){
                    this.playFinished = true;
                    if (false){
                        5;
                        {code:NetStatus.PlayStop};
                        VideoCoreEvent.NetStreamStatus;
                        this;
                    } else {
                        this.dispatch(VideoCoreEvent.NetStreamStatus, {code:NetStatus.PlayStop});
                    };
                };
            };
        }
        private function dispatchBufferFull():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.loading = (this.seeking = false);
            if (false){
                5;
                {code:NetStatus.BufferFull};
                VideoCoreEvent.NetStreamStatus;
                this;
            } else {
                this.dispatch(VideoCoreEvent.NetStreamStatus, {code:NetStatus.BufferFull});
            };
            return;
            /*not popped
            {code:NetStatus.BufferFull}
            */
            /*not popped
            VideoCoreEvent.NetStreamStatus
            */
            /*not popped
            this
            */
        }
        private function dispatch(_arg1:String, _arg2:Object):void{
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
            StreamCore
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
