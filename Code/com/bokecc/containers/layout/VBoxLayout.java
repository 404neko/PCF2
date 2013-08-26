package com.bokecc.containers.layout {
    import com.bokecc.core.*;
    import flash.display.*;
    import com.bokecc.containers.*;

    public class VBoxLayout extends Layout {

        public static const NAME:String = "VBoxLayout";

        public function VBoxLayout(_arg1:Container){
            super(_arg1);
        }
        override public function get name():String{
            return (NAME);
        }
        override public function updateLayout():void{
            var _local10:DisplayObject;
            var _local11:Number;
            var _local12:Number;
            var _local13:Number;
            var _local14:Number;
            var _local15:Number;
            super.updateLayout();
            var _local1:Box = Box(this.target);
            var _local2:String = _local1.horizontalAlign;
            var _local3:Number = _local1.paddingLeft;
            var _local4:Number = _local1.paddingRight;
            var _local5:Number = _local1.paddingTop;
            var _local6:Number = _local1.paddingBottom;
            var _local7:Number = _local1.verticalGap;
            var _local8:Number = _local5;
            var _local9:int;
            while (_local9 < _local1.numChildren) {
                _local10 = _local1.getChildAt(_local9);
                if (_local2 == Align.LEFT){
                    _local10.x = _local3;
                };
                if (_local2 == Align.RIGHT){
                    _local10.x = (_local1.width - (_local10.width + _local4));
                };
                if (_local2 == Align.CENTER){
                    _local11 = (0.5 * (_local1.width - _local10.width));
                    if (_local11 < _local3){
                        _local11 = _local3;
                    };
                    _local10.x = _local11;
                };
                _local10.y = _local8;
                if ((_local10 is ILayoutClient)){
                    _local12 = ILayoutClient(_local10).percentWidth;
                    _local13 = ILayoutClient(_local10).percentHeight;
                    if (!isNaN(_local12)){
                        _local14 = (_local12 * ((_local1.width - _local1.paddingLeft) - _local1.paddingRight));
                        if ((_local10.x + _local14) > ((_local1.width - _local10.x) - _local1.paddingRight)){
                            _local14 = ((_local1.width - _local10.x) - _local1.paddingRight);
                        };
                        _local10.width = _local14;
                    };
                    if (!isNaN(_local13)){
                        _local15 = (_local13 * ((_local1.height - _local1.paddingTop) - _local1.paddingBottom));
                        if ((_local10.y + _local15) > ((_local1.height - _local10.y) - _local1.paddingBottom)){
                            _local15 = ((_local1.height - _local10.y) - _local1.paddingBottom);
                        };
                        _local10.height = _local15;
                    };
                };
                _local8 = ((_local8 + _local10.height) + _local7);
                _local9++;
            };
        }

    }
}//package com.bokecc.containers.layout 
