package com.bokecc.platform.playkernel.core.display {
    import flash.display.*;

    public class Overlayer extends Container {

        private var _highlayer:Container;
        private var _lowlayer:Container;
        private var _mask:Sprite;

        public function Overlayer(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._highlayer = new Container();
            this._lowlayer = new Container();
            this._mask = new Sprite();
            super();
            if (false){
                5;
                this._lowlayer;
                ;
            } else {
                addChild(this._lowlayer);
            };
            if (false){
                5;
                this._highlayer;
                ;
            } else {
                addChild(this._highlayer);
            };
            if (false){
                5;
                400;
                500;
                this;
            } else {
                this.setSize(500, 400);
            };
            mask = this._mask;
            return;
            /*not popped
            400
            */
            /*not popped
            500
            */
            /*not popped
            this
            */
            /*not popped
            this._highlayer
            */
            /*not popped
            this._lowlayer
            */
        }
        public function get lowlayer():Container{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._lowlayer);
        }
        public function get highlayer():Container{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._highlayer);
        }
        override public function setSize(_arg1:Number, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this._mask.graphics;
            } else {
                this._mask.graphics.clear();
            };
            if (false){
                5;
                0;
                this._mask.graphics;
            } else {
                this._mask.graphics.beginFill(0);
            };
            if (false){
                5;
                _arg2;
                _arg1;
                0;
                0;
                this._mask.graphics;
            } else {
                this._mask.graphics.drawRect(0, 0, _arg1, _arg2);
            };
            if (false){
                5;
                this._mask.graphics;
            } else {
                this._mask.graphics.endFill();
            };
            super.setSize(_arg1, _arg2);
            if (false){
                5;
                _arg2;
                _arg1;
                this.lowlayer;
            } else {
                this.lowlayer.setSize(_arg1, _arg2);
            };
            if (false){
                5;
                _arg2;
                _arg1;
                this.highlayer;
            } else {
                this.highlayer.setSize(_arg1, _arg2);
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.highlayer
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.lowlayer
            */
            /*not popped
            this._mask.graphics
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
            this._mask.graphics
            */
            /*not popped
            0
            */
            /*not popped
            this._mask.graphics
            */
            /*not popped
            this._mask.graphics
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Overlayer
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
