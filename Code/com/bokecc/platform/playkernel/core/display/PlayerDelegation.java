package com.bokecc.platform.playkernel.core.display {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.lib.media.*;
    import flash.geom.*;

    public class PlayerDelegation extends Sprite {

        private var thisPoint:Point;
        private var globalPoint:Point;
        private var _width:Number = 500;
        private var _height:Number = 400;
        private var media:Media;
        private var overlayer:Overlayer;

        public function PlayerDelegation(_arg1:Media, _arg2:Overlayer){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.thisPoint = new Point();
            this.globalPoint = new Point();
            super();
            this.overlayer = _arg2;
            this.media = _arg1;
            if (false){
                5;
                dispatchEvent;
                MouseEvent.CLICK;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.CLICK, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                MouseEvent.MOUSE_DOWN;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.MOUSE_DOWN, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                MouseEvent.MOUSE_MOVE;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.MOUSE_MOVE, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                MouseEvent.MOUSE_OUT;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.MOUSE_OUT, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                MouseEvent.MOUSE_OVER;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.MOUSE_OVER, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                MouseEvent.MOUSE_UP;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.MOUSE_UP, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                MouseEvent.MOUSE_WHEEL;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.MOUSE_WHEEL, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                MouseEvent.ROLL_OUT;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.ROLL_OUT, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                MouseEvent.ROLL_OVER;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.ROLL_OVER, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                KeyboardEvent.KEY_DOWN;
                _arg1;
            } else {
                _arg1.addEventListener(KeyboardEvent.KEY_DOWN, dispatchEvent);
            };
            if (false){
                5;
                dispatchEvent;
                KeyboardEvent.KEY_UP;
                _arg1;
            } else {
                _arg1.addEventListener(KeyboardEvent.KEY_UP, dispatchEvent);
            };
            return;
            /*not popped
            dispatchEvent
            */
            /*not popped
            KeyboardEvent.KEY_UP
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            KeyboardEvent.KEY_DOWN
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            MouseEvent.ROLL_OVER
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            MouseEvent.ROLL_OUT
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            MouseEvent.MOUSE_WHEEL
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            MouseEvent.MOUSE_UP
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            MouseEvent.MOUSE_OVER
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            MouseEvent.MOUSE_OUT
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            MouseEvent.MOUSE_MOVE
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            MouseEvent.MOUSE_DOWN
            */
            /*not popped
            _arg1
            */
            /*not popped
            dispatchEvent
            */
            /*not popped
            MouseEvent.CLICK
            */
            /*not popped
            _arg1
            */
        }
        override public function get y():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.thisPoint.y);
        }
        override public function set y(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.x;
                this;
            } else {
                this.move(this.x, _arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.x
            */
            /*not popped
            this
            */
        }
        override public function get x():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.thisPoint.x);
        }
        override public function set x(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.y;
                _arg1;
                this;
            } else {
                this.move(_arg1, this.y);
            };
            return;
            /*not popped
            this.y
            */
            /*not popped
            _arg1
            */
            /*not popped
            this
            */
        }
        public function move(_arg1:Number, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.thisPoint;
            } else {
                this.thisPoint.x = _arg1;
            };
            if (false){
                5;
                _arg2;
                this.thisPoint;
            } else {
                this.thisPoint.y = _arg2;
            };
            this.globalPoint = localToGlobal(this.thisPoint);
            if (false){
                5;
                this.globalPoint.x;
                this.overlayer;
            } else {
                this.overlayer.x = this.globalPoint.x;
            };
            if (false){
                5;
                this.globalPoint.y;
                this.overlayer;
            } else {
                this.overlayer.y = this.globalPoint.y;
            };
            if (false){
                5;
                this.globalPoint.x;
                this.media;
            } else {
                this.media.x = this.globalPoint.x;
            };
            if (false){
                5;
                this.globalPoint.y;
                this.media;
            } else {
                this.media.y = this.globalPoint.y;
            };
            return;
            /*not popped
            this.globalPoint.y
            */
            /*not popped
            this.media
            */
            /*not popped
            this.globalPoint.x
            */
            /*not popped
            this.media
            */
            /*not popped
            this.globalPoint.y
            */
            /*not popped
            this.overlayer
            */
            /*not popped
            this.globalPoint.x
            */
            /*not popped
            this.overlayer
            */
            /*not popped
            _arg2
            */
            /*not popped
            this.thisPoint
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.thisPoint
            */
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
        override public function get width():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._width);
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
                _arg2;
                _arg1;
                this.media;
            } else {
                this.media.setSize(_arg1, _arg2);
            };
            if (false){
                5;
                _arg2;
                _arg1;
                this.overlayer;
            } else {
                this.overlayer.setSize(_arg1, _arg2);
            };
            if (false){
                5;
                this.y;
                this.x;
                this;
            } else {
                this.move(this.x, this.y);
            };
            return;
            /*not popped
            this.y
            */
            /*not popped
            this.x
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
            this.overlayer
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.media
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayerDelegation
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.core.display 
