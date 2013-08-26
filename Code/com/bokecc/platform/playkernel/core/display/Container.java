package com.bokecc.platform.playkernel.core.display {
    import flash.events.*;
    import flash.display.*;

    public class Container extends Sprite {

        private var _width:int;
        private var _height:int;

        public function Container(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
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
            //unresolved jump
            this._height = _arg1;
            if (false){
                5;
                this;
            } else {
                this.dispatchResizeEvent();
            };
            return;
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
            this._width = _arg1;
            if (false){
                5;
                this;
            } else {
                this.dispatchResizeEvent();
            };
            return;
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
                this;
            } else {
                this.dispatchResizeEvent();
            };
            return;
            /*not popped
            this
            */
        }
        private function dispatchResizeEvent():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new Event(Event.RESIZE);
                ;
            } else {
                dispatchEvent(new Event(Event.RESIZE));
            };
            return;
            /*not popped
            new Event(Event.RESIZE)
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Container
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
}//package com.bokecc.platform.playkernel.core.display 
