package com.bokecc.containers.layout {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;

    public class CanvasLayout extends Layout {

        public static const NAME:String = "CanvasLayout";

        public function CanvasLayout(_arg1:Container){
            super(_arg1);
            _arg1.addEventListener(LayoutComponent.LAYOUT_CHANGE, this.onLayoutChange, true);
        }
        override public function get name():String{
            return (NAME);
        }
        private function onLayoutChange(_arg1:Event):void{
            var _local2:ILayoutClient;
            if ((_arg1.target is ILayoutClient)){
                _local2 = ILayoutClient(_arg1.target);
                if ((((DisplayObject(_local2).parent == target)) || ((DisplayObject(_local2).parent == target.$$childList())))){
                    this.computeComponentLayout(_local2);
                };
            };
        }
        override public function updateLayout():void{
            var _local3:ILayoutClient;
            super.updateLayout();
            var _local1:Container = Container(this.target);
            var _local2:int;
            while (_local2 < _local1.numChildren) {
                if ((_local1.getChildAt(_local2) is ILayoutClient)){
                    _local3 = ILayoutClient(_local1.getChildAt(_local2));
                    this.computeComponentLayout(_local3);
                };
                _local2++;
            };
        }
        protected function computeComponentLayout(_arg1:ILayoutClient):void{
            var _local2:Number;
            var _local3:Number;
            var _local4:Number;
            var _local5:Number;
            var _local6:Number;
            var _local7:Number;
            var _local8:Number;
            var _local9:Number;
            var _local10:Number;
            var _local11:Number;
            var _local12:Number;
            var _local13:Number;
            if (DisplayObject(_arg1).parent){
                _local2 = _arg1.top;
                _local3 = _arg1.bottom;
                _local4 = _arg1.left;
                _local5 = _arg1.right;
                _local6 = _arg1.horizontalCenter;
                _local7 = _arg1.verticalCenter;
                _local8 = _arg1.percentWidth;
                _local9 = _arg1.percentHeight;
                _local10 = DisplayObject(_arg1).width;
                _local11 = DisplayObject(_arg1).height;
                _local12 = _local10;
                _local13 = _local11;
                if (((!(isNaN(_local8))) && ((DisplayObject(_arg1).parent.width > 0)))){
                    _local12 = (_local8 * DisplayObject(_arg1).parent.width);
                };
                if (((!(isNaN(_local9))) && ((DisplayObject(_arg1).parent.height > 0)))){
                    _local13 = (_local9 * DisplayObject(_arg1).parent.height);
                };
                if (((!(isNaN(_local7))) && (!(isNaN(_local6))))){
                    DisplayObject(_arg1).x = (((DisplayObject(_arg1).parent.width - _local12) * 0.5) + _local6);
                    DisplayObject(_arg1).y = (((DisplayObject(_arg1).parent.height - _local13) * 0.5) + _local7);
                    if (((!((_local10 == _local12))) && (!((_local11 == _local13))))){
                        Component(_arg1).setSize(_local12, _local13);
                    };
                    if (_local10 != _local12){
                        Component(_arg1).setSize(_local12, _local11);
                    };
                    if (_local11 != _local13){
                        Component(_arg1).setSize(_local10, _local13);
                    };
                } else {
                    if (!isNaN(_local7)){
                        DisplayObject(_arg1).y = (((DisplayObject(_arg1).parent.height - _local13) * 0.5) + _local7);
                        if (((!((_local10 == _local12))) && (!((_local11 == _local13))))){
                            Component(_arg1).setSize(_local12, _local13);
                        };
                        if (_local10 != _local12){
                            Component(_arg1).setSize(_local12, _local11);
                        };
                        if (_local11 != _local13){
                            Component(_arg1).setSize(_local10, _local13);
                        };
                        this.computeHorizontalLayout(_arg1);
                    } else {
                        if (!isNaN(_local6)){
                            DisplayObject(_arg1).x = (((DisplayObject(_arg1).parent.width - _local12) * 0.5) + _local6);
                            if (((!((_local10 == _local12))) && (!((_local11 == _local13))))){
                                Component(_arg1).setSize(_local12, _local13);
                            };
                            if (_local10 != _local12){
                                Component(_arg1).setSize(_local12, _local11);
                            };
                            if (_local11 != _local13){
                                Component(_arg1).setSize(_local10, _local13);
                            };
                            this.computeVerticalLayout(_arg1);
                        } else {
                            if (((!(isNaN(_local8))) || (!(isNaN(_local9))))){
                                if (!isNaN(_local4)){
                                    DisplayObject(_arg1).x = _local4;
                                };
                                if (!isNaN(_local2)){
                                    DisplayObject(_arg1).y = _local2;
                                };
                                if (((((DisplayObject(_arg1).x + _local12) > DisplayObject(_arg1).parent.width)) && ((DisplayObject(_arg1).parent.width > 0)))){
                                    DisplayObject(_arg1).width = (DisplayObject(_arg1).parent.width - DisplayObject(_arg1).x);
                                } else {
                                    DisplayObject(_arg1).width = _local12;
                                };
                                if (((((DisplayObject(_arg1).y + _local13) > DisplayObject(_arg1).parent.height)) && ((DisplayObject(_arg1).parent.height > 0)))){
                                    DisplayObject(_arg1).height = (DisplayObject(_arg1).parent.height - DisplayObject(_arg1).y);
                                } else {
                                    DisplayObject(_arg1).height = _local13;
                                };
                            } else {
                                this.computeHorizontalLayout(_arg1);
                                this.computeVerticalLayout(_arg1);
                            };
                        };
                    };
                };
            };
        }
        private function computeVerticalLayout(_arg1:ILayoutClient):void{
            var _local2:Number;
            if (DisplayObject(_arg1).parent){
                if (((!(isNaN(_arg1.top))) && (!(isNaN(_arg1.bottom))))){
                    DisplayObject(_arg1).y = _arg1.top;
                    _local2 = ((DisplayObject(_arg1).parent.height - _arg1.top) - _arg1.bottom);
                    if (_local2 < 0){
                        DisplayObject(_arg1).height = 0;
                    } else {
                        DisplayObject(_arg1).height = _local2;
                    };
                } else {
                    if (!isNaN(_arg1.top)){
                        DisplayObject(_arg1).y = _arg1.top;
                    } else {
                        if (!isNaN(_arg1.bottom)){
                            DisplayObject(_arg1).y = ((DisplayObject(_arg1).parent.height - _arg1.bottom) - DisplayObject(_arg1).height);
                        };
                    };
                };
            };
        }
        private function computeHorizontalLayout(_arg1:ILayoutClient):void{
            var _local2:Number;
            if (DisplayObject(_arg1).parent){
                if (((!(isNaN(_arg1.left))) && (!(isNaN(_arg1.right))))){
                    DisplayObject(_arg1).x = _arg1.left;
                    _local2 = ((DisplayObject(_arg1).parent.width - _arg1.left) - _arg1.right);
                    if (_local2 < 0){
                        DisplayObject(_arg1).width = 0;
                    } else {
                        DisplayObject(_arg1).width = _local2;
                    };
                } else {
                    if (!isNaN(_arg1.left)){
                        DisplayObject(_arg1).x = _arg1.left;
                    } else {
                        if (!isNaN(_arg1.right)){
                            DisplayObject(_arg1).x = ((DisplayObject(_arg1).parent.width - _arg1.right) - DisplayObject(_arg1).width);
                        };
                    };
                };
            };
        }

    }
}//package com.bokecc.containers.layout 
