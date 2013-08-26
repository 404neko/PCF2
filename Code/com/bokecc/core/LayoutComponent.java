package com.bokecc.core {
    import flash.events.*;
    import com.bokecc.containers.layout.*;

    public class LayoutComponent extends Component implements ILayoutClient {

        public static const LAYOUT_CHANGE:String = "layoutChange";

        private var _top:Number = NaN;
        private var _bottom:Number = NaN;
        private var _left:Number = NaN;
        private var _right:Number = NaN;
        private var _horizontalCenter:Number = NaN;
        private var _verticalCenter:Number = NaN;
        private var _percentWidth:Number = NaN;
        private var _percentHeight:Number = NaN;

        public function get bottom():Number{
            return (this._bottom);
        }
        public function set bottom(_arg1:Number):void{
            if (this._bottom != _arg1){
                this._bottom = _arg1;
                this._verticalCenter = NaN;
                this._percentHeight = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get left():Number{
            return (this._left);
        }
        public function set left(_arg1:Number):void{
            if (this._left != _arg1){
                this._left = _arg1;
                this._horizontalCenter = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get right():Number{
            return (this._right);
        }
        public function set right(_arg1:Number):void{
            if (this._right != _arg1){
                this._right = _arg1;
                this._horizontalCenter = NaN;
                this._percentWidth = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get top():Number{
            return (this._top);
        }
        public function set top(_arg1:Number):void{
            if (this._top != _arg1){
                this._top = _arg1;
                this._verticalCenter = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get horizontalCenter():Number{
            return (this._horizontalCenter);
        }
        public function set horizontalCenter(_arg1:Number):void{
            if (this._horizontalCenter != _arg1){
                this._horizontalCenter = _arg1;
                this._left = NaN;
                this._right = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get verticalCenter():Number{
            return (this._verticalCenter);
        }
        public function set verticalCenter(_arg1:Number):void{
            if (this._verticalCenter != _arg1){
                this._verticalCenter = _arg1;
                this._top = NaN;
                this._bottom = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get percentWidth():Number{
            return (this._percentWidth);
        }
        public function set percentWidth(_arg1:Number):void{
            if (this._percentWidth != _arg1){
                this._percentWidth = _arg1;
                this._right = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get percentHeight():Number{
            return (this._percentHeight);
        }
        public function set percentHeight(_arg1:Number):void{
            if (this._percentHeight != _arg1){
                this._percentHeight = _arg1;
                this._bottom = NaN;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        override public function set scaleX(_arg1:Number):void{
            if (_scaleX != _arg1){
                super.scaleX = _arg1;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        override public function set scaleY(_arg1:Number):void{
            if (_scaleY != _arg1){
                super.scaleY = _arg1;
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        override public function setSize(_arg1:Number, _arg2:Number):void{
            super.setSize(_arg1, _arg2);
            dispatchEvent(new Event(LAYOUT_CHANGE));
        }

    }
}//package com.bokecc.core 
