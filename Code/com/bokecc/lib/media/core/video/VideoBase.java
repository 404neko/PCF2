package com.bokecc.lib.media.core.video {
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.*;
    import com.bokecc.lib.media.core.videocore.*;
    import com.bokecc.lib.media.source.*;
    import com.bokecc.lib.media.visual.*;
    import com.bokecc.lib.data.*;

    public class VideoBase extends MediaBase {

        protected var server:String;
        protected var file:String;
        protected var core:IVideoCore;
        protected var meta:Meta;
        protected var bufferStart_time:Number;
        protected var bufferStart_filesize:Number;
        private var vol:Number = 1;
        private var netStatusHandlers:Object;

        public function VideoBase(_arg1:IPlaySource, _arg2:IVideoCore=null, _arg3:IVisualization=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.netStatusHandlers = {};
            if (_arg3 == null){
                _arg3 = new NetStreamVisualization();
            };
            super(_arg1, _arg3);
            if (false){
                5;
                _arg1.url;
                this;
            } else {
                this.parseSrc(_arg1.url);
            };
            if (_arg2 == null){
                _arg2 = new VideoCore();
            };
            if (false){
                5;
                this;
            } else {
                this.initNetStatusHandler();
            };
            this.core = _arg2;
            if (false){
                5;
                this.onMetaDataHandler;
                VideoCoreEvent.MetaData;
                this.core;
            } else {
                this.core.addEventListener(VideoCoreEvent.MetaData, this.onMetaDataHandler);
            };
            if (false){
                5;
                this.onStreamStatusHandler;
                VideoCoreEvent.NetStreamStatus;
                this.core;
            } else {
                this.core.addEventListener(VideoCoreEvent.NetStreamStatus, this.onStreamStatusHandler);
            };
            if (false){
                5;
                this.onConnectionStatusHandler;
                VideoCoreEvent.NetConnectionStatus;
                this.core;
            } else {
                this.core.addEventListener(VideoCoreEvent.NetConnectionStatus, this.onConnectionStatusHandler);
            };
            return;
            /*not popped
            this.onConnectionStatusHandler
            */
            /*not popped
            VideoCoreEvent.NetConnectionStatus
            */
            /*not popped
            this.core
            */
            /*not popped
            this.onStreamStatusHandler
            */
            /*not popped
            VideoCoreEvent.NetStreamStatus
            */
            /*not popped
            this.core
            */
            /*not popped
            this.onMetaDataHandler
            */
            /*not popped
            VideoCoreEvent.MetaData
            */
            /*not popped
            this.core
            */
            /*not popped
            this
            */
            /*not popped
            _arg1.url
            */
            /*not popped
            this
            */
        }
        private function onMetaDataHandler(_arg1:VideoCoreEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Meta = (_arg1.info as Meta);
            if (this.meta == null){
                this.meta = _local2;
                if (this.duration <= 0){
                    if (false){
                        5;
                        this.meta.duration;
                        source;
                    } else {
                        source.duration = this.meta.duration;
                    };
                };
                if (source.size <= 0){
                    if (false){
                        5;
                        this.meta.filesize;
                        source;
                    } else {
                        source.size = this.meta.filesize;
                    };
                };
                if (source.size <= 0){
                    if (false){
                        5;
                        this.core.bytesTotal;
                        source;
                    } else {
                        source.size = this.core.bytesTotal;
                    };
                };
                if (false){
                    5;
                    this.meta;
                    this;
                } else {
                    this.onFirstMetaData(this.meta);
                };
            } else {
                if (false){
                    5;
                    _local2;
                    this;
                } else {
                    this.onMetaData(_local2);
                };
            };
        }
        private function onConnectionStatusHandler(_arg1:VideoCoreEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Boolean = this.statusHandle(_arg1.info);
            if (!_local2){
                if (false){
                    5;
                    _arg1.info;
                    this;
                } else {
                    this.onConnectionStatus(_arg1.info);
                };
            };
        }
        private function onStreamStatusHandler(_arg1:VideoCoreEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Boolean = this.statusHandle(_arg1.info);
            if (!_local2){
                if (false){
                    5;
                    _arg1.info;
                    this;
                } else {
                    this.onStreamStatus(_arg1.info);
                };
            };
        }
        final protected function addNetStatusHandler(_arg1:String, _arg2:Function):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg2;
                _arg1;
                this.netStatusHandlers;
            } else {
                this.netStatusHandlers[_arg1] = _arg2;
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.netStatusHandlers
            */
        }
        final protected function delNetStatusHandler(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            delete this.netStatusHandlers[_arg1];
        }
        final protected function statusHandle(_arg1:Object):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Function = this.netStatusHandlers[_arg1["code"]];
            if (_local2 != null){
                _local2(_arg1);
                return (true);
            };
            return (false);
        }
        final protected function donothing(_arg1:Object=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        final protected function onNetStatus_DisplayUpdated(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.displayData;
                ;
            } else {
                display(this.displayData);
            };
            return;
            /*not popped
            this.displayData
            */
        }
        protected function parseSrc(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.file = _arg1;
        }
        protected function initNetStatusHandler():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        protected function onFirstMetaData(_arg1:Meta):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        protected function onMetaData(_arg1:Meta):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        protected function onConnectionStatus(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        protected function onStreamStatus(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
        }
        protected function bufferRange(_arg1:Number):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((((this.bufferStart <= _arg1)) && ((_arg1 <= this.bufferEnd))));
        }
        protected function setBufferStart(_arg1:Number, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.bufferStart_time = exact(_arg1, 3);
            this.bufferStart_filesize = _arg2;
            if (false){
                5;
                this.bufferStart_time;
                MediaEvent.LoadPositionRevised;
                ;
            } else {
                dispatch(MediaEvent.LoadPositionRevised, this.bufferStart_time);
            };
            return;
            /*not popped
            this.bufferStart_time
            */
            /*not popped
            MediaEvent.LoadPositionRevised
            */
        }
        override public function stop():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.core;
            } else {
                this.core.stop();
            };
            return;
            /*not popped
            this.core
            */
            /*not popped
            ((ready) ? if (false){
    5;
    ;
} else {
    setInterrupted();
} : if (false){
    5;
    ;
} else {
    setClosed();
})
            */
        }
        override public function get volume():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.vol);
        }
        override public function set volume(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                (this.vol = _arg1);
                this.core;
            } else {
                this.core.volume = (this.vol = _arg1);
            };
            if (false){
                5;
                this.volume;
                MediaEvent.VolumeChanged;
                ;
            } else {
                dispatch(MediaEvent.VolumeChanged, this.volume);
            };
            return;
            /*not popped
            this.volume
            */
            /*not popped
            MediaEvent.VolumeChanged
            */
            /*not popped
            (this.vol = _arg1)
            */
            /*not popped
            this.core
            */
        }
        override public function get displayData(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.core.ns);
        }
        override public function get primaryData(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.core);
        }
        override public function get info(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.meta);
        }
        override public function get bufferTime():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.core.bufferTime);
        }
        override public function get bufferLength():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.core.bufferLength);
        }
        override public function set bufferTime(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (!isNaN(_arg1)){
                if (false){
                    5;
                    _arg1;
                    this.core;
                } else {
                    this.core.bufferTime = _arg1;
                };
            };
        }
        override public function get oscale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.meta){
                return (this.meta.scale);
            };
            return (NaN);
        }
        override public function get viewPosition():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.position);
        }
        override public function get position():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (Math.max(this.bufferStart, this.core.position));
        }
        override public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (exact(source.duration, 3));
        }
        public function get filesize():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (source.size);
        }
        override public function get bufferStart():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.bufferStart_time);
        }
        override public function get bufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Number = 0;
            var _local2:Number = (this.filesize - this.bufferStart_filesize);
            if (_local2 > 0){
                _local1 = ((this.core.bytesLoaded / _local2) * (this.duration - this.bufferStart));
            };
            return (exact((this.bufferStart + _local1), 3));
        }

        if (37 == 34){
            return;
            /*not popped
            VideoBase
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.core.video 
