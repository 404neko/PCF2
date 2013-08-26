package com.bokecc.lib.media {
    import flash.display.*;
    import com.bokecc.lib.media.core.*;

    public class Media extends Sprite implements IMedia {

        private var _media:IMediaBase;
        private var _width:Number = 500;
        private var _height:Number = 400;
        private var _scale:Number = 0;
        private var _zscale:Number = 1;
        private var _contrast:Number = 0;
        private var _brightness:Number = 0;
        private var _bufferTime:Number = 3;
        private var _volume:Number = 1;

        public function Media(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
        }
        public function get entity():IMediaBase{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._media);
        }
        public function set entity(_arg1:IMediaBase):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Boolean = ((!((_arg1 == this.entity))) && (!((_arg1 == null))));
            if (_local2){
                if (false){
                    5;
                    this;
                } else {
                    this.destroyEntity();
                };
                this._media = _arg1;
                if (false){
                    5;
                    this;
                } else {
                    this.onSetMedia();
                };
                if (false){
                    5;
                    0;
                    this.entity.displayObject;
                    ;
                } else {
                    addChildAt(this.entity.displayObject, 0);
                };
                if (false){
                    5;
                    this.mediaEventHandler;
                    MediaEvent.ALL;
                    this.entity;
                } else {
                    this.entity.addEventListener(MediaEvent.ALL, this.mediaEventHandler);
                };
            };
        }
        protected function onSetMedia():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.height;
                this.width;
                this;
            } else {
                this.setSize(this.width, this.height);
            };
            this.volume = this._volume;
            this.bufferTime = this._bufferTime;
            this.brightness = this._brightness;
            this.contrast = this._contrast;
            this.zscale = this._zscale;
            this.scale = this._scale;
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
        protected function mediaEventHandler(_arg1:MediaEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                ;
            } else {
                dispatchEvent(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
        }
        public function interrupt():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                if (false){
                    5;
                    this.mediaEventHandler;
                    MediaEvent.ALL;
                    this.entity;
                } else {
                    this.entity.removeEventListener(MediaEvent.ALL, this.mediaEventHandler);
                };
                if (false){
                    5;
                    this.entity;
                } else {
                    this.entity.stop();
                };
            };
        }
        public function removeEntity():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                if (false){
                    5;
                    this.entity.displayObject;
                    ;
                } else {
                    removeChild(this.entity.displayObject);
                };
                this._media = null;
            };
        }
        public function destroyEntity():void{
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
                this.interrupt();
            };
            if (false){
                5;
                this;
            } else {
                this.removeEntity();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            this
            */
        }
        public function get hasEntity():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (!((this.entity == null)));
        }
        public function clear():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                if (false){
                    5;
                    this.entity;
                } else {
                    this.entity.clear();
                };
            };
        }
        public function enabled(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                if (false){
                    5;
                    _arg1;
                    this.entity;
                } else {
                    this.entity.enabled(_arg1);
                };
            };
        }
        override public function get width():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._width);
        }
        override public function get height():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._height);
        }
        override public function set width(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
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
        public function setSize(_arg1:Number, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._width = _arg1;
            this._height = _arg2;
            if (false){
                5;
                graphics;
            } else {
                graphics.clear();
            };
            if (false){
                5;
                0;
                graphics;
            } else {
                graphics.beginFill(0);
            };
            if (false){
                5;
                _arg2;
                _arg1;
                0;
                0;
                graphics;
            } else {
                graphics.drawRect(0, 0, _arg1, _arg2);
            };
            if (false){
                5;
                graphics;
            } else {
                graphics.endFill();
            };
            if (this.entity){
                if (false){
                    5;
                    this.height;
                    this.width;
                    this.entity;
                } else {
                    this.entity.setSize(this.width, this.height);
                };
            } else {
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
            };
            return;
            /*not popped
            graphics
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
            graphics
            */
            /*not popped
            0
            */
            /*not popped
            graphics
            */
            /*not popped
            graphics
            */
        }
        public function start():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                if (false){
                    5;
                    this.entity;
                } else {
                    this.entity.start();
                };
            };
        }
        public function pause(_arg1=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                if (false){
                    5;
                    _arg1;
                    this.entity;
                } else {
                    this.entity.pause(_arg1);
                };
            };
        }
        public function seek(_arg1:Number, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                if (false){
                    5;
                    _arg2;
                    _arg1;
                    this.entity;
                } else {
                    this.entity.seek(_arg1, _arg2);
                };
            };
        }
        public function stop():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                if (false){
                    5;
                    this.entity;
                } else {
                    this.entity.stop();
                };
            };
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
        public function set bufferTime(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._bufferTime = _arg1;
            if (this.entity){
                if (false){
                    5;
                    this.bufferTime;
                    this.entity;
                } else {
                    this.entity.bufferTime = this.bufferTime;
                };
            };
        }
        public function set volume(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this._volume = _arg1;
            if (this.entity){
                if (false){
                    5;
                    this.volume;
                    this.entity;
                } else {
                    this.entity.volume = this.volume;
                };
            };
        }
        public function set brightness(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._brightness = _arg1;
            if (this.entity){
                if (false){
                    5;
                    this.brightness;
                    this.entity;
                } else {
                    this.entity.brightness = this.brightness;
                };
            };
        }
        public function set contrast(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._contrast = _arg1;
            if (this.entity){
                if (false){
                    5;
                    this.contrast;
                    this.entity;
                } else {
                    this.entity.contrast = this.contrast;
                };
            };
        }
        public function set scale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._scale = _arg1;
            if (this.entity){
                if (false){
                    5;
                    this.scale;
                    this.entity;
                } else {
                    this.entity.scale = this.scale;
                };
            };
        }
        public function set zscale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if ((((_arg1 >= 0)) && ((_arg1 <= 1)))){
                this._zscale = _arg1;
                if (this.entity){
                    if (false){
                        5;
                        this.zscale;
                        this.entity;
                    } else {
                        this.entity.zscale = this.zscale;
                    };
                };
            };
        }
        public function get brightness():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._brightness);
        }
        public function get contrast():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._contrast);
        }
        public function get scale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._scale);
        }
        public function get zscale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._zscale);
        }
        public function get oscale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.oscale);
            };
            return (NaN);
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
        public function get bufferTime():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._bufferTime);
        }
        public function get bufferLength():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.bufferLength);
            };
            return (0);
        }
        public function get displayData(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.displayData);
            };
            return (null);
        }
        public function get primaryData(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.primaryData);
            };
            return (null);
        }
        public function get info(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.info);
            };
            return (null);
        }
        public function get viewPosition():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.viewPosition);
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
            if (this.entity){
                return (this.entity.position);
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
            if (this.entity){
                return (this.entity.duration);
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
            //unresolved jump
            if (this.entity){
                return (this.entity.bufferStart);
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
            if (this.entity){
                return (this.entity.bufferEnd);
            };
            return (0);
        }
        public function get playStatus():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.playStatus);
            };
            return (MediaBase.Closed);
        }
        public function get waitingStatus():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.waitingStatus);
            };
            return (MediaBase.NotWaiting);
        }
        public function get stopped():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.stopped);
            };
            return (true);
        }
        public function get playing():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.playing);
            };
            return (false);
        }
        public function get paused():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.paused);
            };
            return (false);
        }
        public function get waiting():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (this.entity){
                return (this.entity.waiting);
            };
            return (false);
        }
        public function get loading():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.loading);
            };
            return (false);
        }
        public function get buffering():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (this.entity){
                return (this.entity.buffering);
            };
            return (false);
        }
        public function get ready():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.entity){
                return (this.entity.ready);
            };
            return (false);
        }

        if (37 == 34){
            return;
            /*not popped
            Media
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
}//package com.bokecc.lib.media 
