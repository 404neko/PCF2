package com.bokecc.lib.media.core {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.source.*;
    import com.bokecc.lib.media.visual.*;
    import flash.utils.*;
    import com.bokecc.lib.utils.*;

    public class MediaBase extends Sprite implements IMediaBase {

        public static const DefaultW:int = 500;
        public static const DefaultH:int = 400;
        public static const Closed:int = 0;
        public static const Playing:int = 1;
        public static const Paused:int = 2;
        public static const Finished:int = 3;
        public static const Interrupted:int = 4;
        public static const NotWaiting:int = 0;
        public static const Loading:int = 1;
        public static const Buffering:int = 2;
        public static const Seeking:int = 3;

        private var zoom:Zoom;
        private var bg:Shape;
        private var dc:DoubleClickUtil;
        private var visualization:IVisualization;
        private var colorFilters:ColorFilters;
        private var bgVisible:Boolean = true;
        private var bgColor:int = 0;
        private var bgAlpha:Number = 1;
        protected var source:IPlaySource;
        private var _ready:uint;
        private var _playStatus:uint = 0;
        private var _waitingStatus:uint = 0;

        public function MediaBase(_arg1:IPlaySource, _arg2:IVisualization){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.bg = new Shape();
            this.colorFilters = new ColorFilters();
            super();
            this.visualization = _arg2;
            this.zoom = new Zoom(DefaultW, DefaultH);
            if (false){
                5;
                DefaultH;
                DefaultW;
                this;
            } else {
                this.setSize(DefaultW, DefaultH);
            };
            if (false){
                5;
                this.bg;
                ;
            } else {
                addChild(this.bg);
            };
            if (false){
                5;
                this;
                _arg2;
            } else {
                _arg2.addTo(this);
            };
            this.source = _arg1;
            this.dc = new DoubleClickUtil(this);
            if (false){
                5;
                this.onDoubleClick;
                MouseEvent.DOUBLE_CLICK;
                this.dc;
            } else {
                this.dc.addEventListener(MouseEvent.DOUBLE_CLICK, this.onDoubleClick);
            };
            return;
            /*not popped
            this.onDoubleClick
            */
            /*not popped
            MouseEvent.DOUBLE_CLICK
            */
            /*not popped
            this.dc
            */
            /*not popped
            this
            */
            /*not popped
            _arg2
            */
            /*not popped
            this.bg
            */
            /*not popped
            DefaultH
            */
            /*not popped
            DefaultW
            */
            /*not popped
            this
            */
        }
        private function onDoubleClick(_arg1:MouseEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.dc.isDoubleClick;
                MediaEvent.Click;
                this;
            } else {
                this.dispatch(MediaEvent.Click, this.dc.isDoubleClick);
            };
            return;
            /*not popped
            this.dc.isDoubleClick
            */
            /*not popped
            MediaEvent.Click
            */
            /*not popped
            this
            */
        }
        public function get ready():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._ready == 2));
        }
        protected function notReady():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this._ready = 0;
        }
        protected function setReady(_arg1:int=0):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this._ready == 0){
                if (_arg1 == 0){
                    if (false){
                        5;
                        this;
                    } else {
                        this.setReadyHandler();
                    };
                } else {
                    this._ready = 1;
                    if (false){
                        5;
                        _arg1;
                        this.setReadyHandler;
                        ;
                    } else {
                        setTimeout(this.setReadyHandler, _arg1);
                    };
                };
            };
        }
        private function setReadyHandler():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._ready = 2;
            if (false){
                5;
                this;
            } else {
                this.setNotWaiting();
            };
            if (false){
                5;
                MediaEvent.Ready;
                this;
            } else {
                this.dispatch(MediaEvent.Ready);
            };
            return;
            /*not popped
            MediaEvent.Ready
            */
            /*not popped
            this
            */
            /*not popped
            this
            */
        }
        public function get playStatus():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._playStatus);
        }
        protected function setPlayStatus(_arg1:uint):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local4:String;
            var _local2:uint = this._playStatus;
            var _local3 = !((_local2 == _arg1));
            this._playStatus = _arg1;
            if (_local3){
                if (false){
                    5;
                    this._playStatus;
                    MediaEvent.PlayStatus;
                    this;
                } else {
                    this.dispatch(MediaEvent.PlayStatus, this._playStatus);
                };
                if (this.finished){
                    _local4 = MediaEvent.PlayFinish;
                } else {
                    if (this.paused){
                        _local4 = MediaEvent.PlayPause;
                    } else {
                        if (this.playing){
                            /*switch (){
                                    _local4 = MediaEvent.PlayResume;
                                    break;
                                    _local4 = MediaEvent.PlayStart;
                            }*/;
                        };
                    };
                };
                if (_local4){
                    if (false){
                        5;
                        {
                            position:this.position,
                            duration:this.duration
                        };
                        _local4;
                        this;
                    } else {
                        this.dispatch(_local4, {
                            position:this.position,
                            duration:this.duration
                        });
                    };
                };
            };
        }
        public function get stopped():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((((this.closed) || (this.finished))) || (this.interrupted)));
        }
        public function get closed():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._playStatus == Closed));
        }
        public function get playing():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._playStatus == Playing));
        }
        public function get paused():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._playStatus == Paused));
        }
        public function get finished():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._playStatus == Finished));
        }
        public function get interrupted():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._playStatus == Interrupted));
        }
        protected function setClosed():void{
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
                this.notReady();
            };
            if (false){
                5;
                Closed;
                this;
            } else {
                this.setPlayStatus(Closed);
            };
            return;
            /*not popped
            Closed
            */
            /*not popped
            this
            */
            /*not popped
            this
            */
        }
        protected function setPlaying():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                Playing;
                this;
            } else {
                this.setPlayStatus(Playing);
            };
            return;
            /*not popped
            Playing
            */
            /*not popped
            this
            */
        }
        protected function setPaused():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                Paused;
                this;
            } else {
                this.setPlayStatus(Paused);
            };
            return;
            /*not popped
            Paused
            */
            /*not popped
            this
            */
        }
        protected function setFinished():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                Finished;
                this;
            } else {
                this.setPlayStatus(Finished);
            };
            return;
            /*not popped
            Finished
            */
            /*not popped
            this
            */
        }
        protected function setInterrupted():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                Interrupted;
                this;
            } else {
                this.setPlayStatus(Interrupted);
            };
            return;
            /*not popped
            Interrupted
            */
            /*not popped
            this
            */
        }
        public function get waitingStatus():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._waitingStatus);
        }
        protected function setWaitingStatus(_arg1:uint):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:uint = this._waitingStatus;
            var _local3 = !((_local2 == _arg1));
            this._waitingStatus = _arg1;
            if (_local3){
                if (false){
                    5;
                    this._waitingStatus;
                    MediaEvent.WaitingStatus;
                    this;
                } else {
                    this.dispatch(MediaEvent.WaitingStatus, this._waitingStatus);
                };
                if (this.notwaiting){
                    if (false){
                        5;
                        _local2;
                        this;
                    } else {
                        this.onBufferFull(_local2);
                    };
                } else {
                    if (((this.buffering) && ((_local2 == NotWaiting)))){
                        if (false){
                            5;
                            _local2;
                            this;
                        } else {
                            this.onBufferEmpty(_local2);
                        };
                    };
                };
            };
        }
        protected function onBufferEmpty(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Object = {
                position:this.position,
                duration:this.duration,
                prevStatus:_arg1,
                status:this.waitingStatus
            };
            if (false){
                5;
                _local2;
                MediaEvent.BufferEmpty;
                this;
            } else {
                this.dispatch(MediaEvent.BufferEmpty, _local2);
            };
            return;
            /*not popped
            _local2
            */
            /*not popped
            MediaEvent.BufferEmpty
            */
            /*not popped
            this
            */
        }
        protected function onBufferFull(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:String;
            /*switch (){
                    _local2 = MediaEvent.BufferLoadFull;
                    break;
                    _local2 = MediaEvent.BufferSeekFull;
                    break;
                    _local2 = MediaEvent.BufferFull;
                    break;
                    return;
            }*/;
            var _local3:Object = {
                position:this.position,
                duration:this.duration,
                prevStatus:_arg1,
                status:this.waitingStatus
            };
            if (false){
                5;
                _local3;
                _local2;
                this;
            } else {
                this.dispatch(_local2, _local3);
            };
            return;
            /*not popped
            _local3
            */
            /*not popped
            _local2
            */
            /*not popped
            this
            */
        }
        public function get waiting():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this.loading) || (this.buffering)));
        }
        public function get notwaiting():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._waitingStatus == NotWaiting));
        }
        public function get loading():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._waitingStatus == Loading));
        }
        public function get buffering():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._waitingStatus == Buffering));
        }
        public function get seeking():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._waitingStatus == Seeking));
        }
        protected function initWaitingStatus():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._waitingStatus = NotWaiting;
        }
        protected function setNotWaiting():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                NotWaiting;
                this;
            } else {
                this.setWaitingStatus(NotWaiting);
            };
            return;
            /*not popped
            NotWaiting
            */
            /*not popped
            this
            */
        }
        protected function setLoading():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                Loading;
                this;
            } else {
                this.setWaitingStatus(Loading);
            };
            return;
            /*not popped
            Loading
            */
            /*not popped
            this
            */
        }
        protected function setBuffering():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                Buffering;
                this;
            } else {
                this.setWaitingStatus(Buffering);
            };
            return;
            /*not popped
            Buffering
            */
            /*not popped
            this
            */
        }
        protected function setSeeking():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                Seeking;
                this;
            } else {
                this.setWaitingStatus(Seeking);
            };
            return;
            /*not popped
            Seeking
            */
            /*not popped
            this
            */
        }
        public function start():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        public function pause(_arg1=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        public function seek(_arg1:Number, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        public function stop():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        public function get oscale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (0);
        }
        public function get volume():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (0);
        }
        public function get bufferTime():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
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
            return (0);
        }
        public function get viewPosition():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (0);
        }
        public function get position():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (0);
        }
        public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (0);
        }
        public function get bufferStart():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (0);
        }
        public function get bufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (0);
        }
        public function set volume(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        public function set bufferTime(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        public function get displayData(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        public function get primaryData(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
        }
        public function get info(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
        }
        public function dispatch(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new MediaEvent(_arg1, _arg2);
                ;
            } else {
                dispatchEvent(new MediaEvent(_arg1, _arg2));
            };
            return;
            /*not popped
            new MediaEvent(_arg1, _arg2)
            */
        }
        public function clear():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.visualization;
            } else {
                this.visualization.clear();
            };
            return;
            /*not popped
            this.visualization
            */
        }
        public function display(_arg1):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.visualization;
            } else {
                this.visualization.display(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.visualization
            */
        }
        public function enabled(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.visualization;
            } else {
                this.visualization.enabled(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.visualization
            */
        }
        public function get displayObject():DisplayObject{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this);
        }
        override public function get width():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.bg.width);
        }
        override public function get height():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.bg.height);
        }
        override public function set width(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.height;
                _arg1;
                this;
            } else {
                this.setSize(_arg1, this.height);
            };
            return;
            /*not popped
            this.height
            */
            /*not popped
            _arg1
            */
            /*not popped
            this
            */
        }
        override public function set height(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.width;
                this;
            } else {
                this.setSize(this.width, _arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.width
            */
            /*not popped
            this
            */
        }
        public function get scale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.zoom.scale);
        }
        public function set scale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.zoom;
            } else {
                this.zoom.scale = _arg1;
            };
            if (false){
                5;
                this.height;
                this.width;
                this;
            } else {
                this.setSizeHandler(this.width, this.height);
            };
            if (false){
                5;
                this.scale;
                MediaEvent.ScaleChanged;
                this;
            } else {
                this.dispatch(MediaEvent.ScaleChanged, this.scale);
            };
            return;
            /*not popped
            this.scale
            */
            /*not popped
            MediaEvent.ScaleChanged
            */
            /*not popped
            this
            */
            /*not popped
            this.height
            */
            /*not popped
            this.width
            */
            /*not popped
            this
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.zoom
            */
        }
        public function get zscale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.zoom.zscale);
        }
        public function set zscale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.zoom;
            } else {
                this.zoom.zscale = _arg1;
            };
            if (false){
                5;
                this.height;
                this.width;
                this;
            } else {
                this.setSizeHandler(this.width, this.height);
            };
            if (false){
                5;
                this.scale;
                MediaEvent.ZScaleChanged;
                this;
            } else {
                this.dispatch(MediaEvent.ZScaleChanged, this.scale);
            };
            return;
            /*not popped
            this.scale
            */
            /*not popped
            MediaEvent.ZScaleChanged
            */
            /*not popped
            this
            */
            /*not popped
            this.height
            */
            /*not popped
            this.width
            */
            /*not popped
            this
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.zoom
            */
        }
        public function setSize(_arg1:Number, _arg2:Number):void{
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
                this;
            } else {
                this.setSizeHandler(_arg1, _arg2);
            };
            if (false){
                5;
                {
                    width:_arg1,
                    height:_arg2
                };
                MediaEvent.Resize;
                this;
            } else {
                this.dispatch(MediaEvent.Resize, {
                    width:_arg1,
                    height:_arg2
                });
            };
            return;
            /*not popped
            {
                width:_arg1,
                height:_arg2
            }
            */
            /*not popped
            MediaEvent.Resize
            */
            /*not popped
            this
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this
            */
        }
        private function setSizeHandler(_arg1:Number, _arg2:Number):void{
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
                this;
            } else {
                this.resize(_arg1, _arg2);
            };
            if (false){
                5;
                this.zoom.getXYWH(_arg1, _arg2);
                null;
                this.visualization.setXYWH;
            } else {
                this.visualization.setXYWH.apply(null, this.zoom.getXYWH(_arg1, _arg2));
            };
            return;
            /*not popped
            this.zoom.getXYWH(_arg1, _arg2)
            */
            /*not popped
            null
            */
            /*not popped
            this.visualization.setXYWH
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this
            */
        }
        protected function setBgStyle(_arg1:Boolean, _arg2:int=0, _arg3:Number=1):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.bgVisible = _arg1;
            this.bgColor = _arg2;
            this.bgAlpha = _arg3;
            if (false){
                5;
                this.height;
                this.width;
                this;
            } else {
                this.resize(this.width, this.height);
            };
            return;
            /*not popped
            this.height
            */
            /*not popped
            this.width
            */
            /*not popped
            this
            */
        }
        private function resize(_arg1:Number, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.bgVisible;
                this.bg;
            } else {
                this.bg.visible = this.bgVisible;
            };
            if (false){
                5;
                this.bg.graphics;
            } else {
                this.bg.graphics.clear();
            };
            if (false){
                5;
                this.bgAlpha;
                this.bgColor;
                this.bg.graphics;
            } else {
                this.bg.graphics.beginFill(this.bgColor, this.bgAlpha);
            };
            if (false){
                5;
                _arg2;
                _arg1;
                0;
                0;
                this.bg.graphics;
            } else {
                this.bg.graphics.drawRect(0, 0, _arg1, _arg2);
            };
            if (false){
                5;
                this.bg.graphics;
            } else {
                this.bg.graphics.endFill();
            };
            if (false){
                5;
                _arg2;
                _arg1;
                this.zoom;
            } else {
                this.zoom.setWH(_arg1, _arg2);
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.zoom
            */
            /*not popped
            this.bg.graphics
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            0
            */
            /*not popped
            0
            */
            /*not popped
            this.bg.graphics
            */
            /*not popped
            this.bgAlpha
            */
            /*not popped
            this.bgColor
            */
            /*not popped
            this.bg.graphics
            */
            /*not popped
            this.bg.graphics
            */
            /*not popped
            this.bgVisible
            */
            /*not popped
            this.bg
            */
        }
        public function get brightness():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.colorFilters.brightness);
        }
        public function get contrast():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.colorFilters.contrast);
        }
        public function set brightness(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.colorFilters;
            } else {
                this.colorFilters.brightness = _arg1;
            };
            filters = this.colorFilters.value;
            if (false){
                5;
                this.brightness;
                MediaEvent.BrightnessChanged;
                this;
            } else {
                this.dispatch(MediaEvent.BrightnessChanged, this.brightness);
            };
            return;
            /*not popped
            this.brightness
            */
            /*not popped
            MediaEvent.BrightnessChanged
            */
            /*not popped
            this
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.colorFilters
            */
        }
        public function set contrast(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.colorFilters;
            } else {
                this.colorFilters.contrast = _arg1;
            };
            filters = this.colorFilters.value;
            if (false){
                5;
                this.contrast;
                MediaEvent.ContrastChanged;
                this;
            } else {
                this.dispatch(MediaEvent.ContrastChanged, this.contrast);
            };
            return;
            /*not popped
            this.contrast
            */
            /*not popped
            MediaEvent.ContrastChanged
            */
            /*not popped
            this
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.colorFilters
            */
        }

        if (37 == 34){
            return;
            /*not popped
            MediaBase
            */
        };
        //unresolved jump
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.core 
