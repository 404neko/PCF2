package com.bokecc.lib.utils {
    import flash.filters.*;

    public class ColorFilters {

        private static const INIT:Array = [1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0];

        private var brightnessFilter:ColorMatrixFilter;
        private var contrastFilter:ColorMatrixFilter;
        private var _brightness:Number = 0;
        private var _contrast:Number = 0;
        private var _filters:Array;

        public function ColorFilters(_arg1:Number=0, _arg2:Number=0){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this._filters = [];
            super();
            if (_arg1 != 0){
                this.brightness = _arg1;
            };
            if (_arg2 != 0){
                this.contrast = _arg2;
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
            return (this._contrast);
        }
        public function set brightness(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._brightness = _arg1;
            this.brightnessFilter = new ColorMatrixFilter(this.concat([1, 0, 0, 0, _arg1, 0, 1, 0, 0, _arg1, 0, 0, 1, 0, _arg1, 0, 0, 0, 1, 0]));
            if (false){
                5;
                this;
            } else {
                this.update();
            };
            return;
            /*not popped
            this
            */
        }
        public function set contrast(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._contrast = _arg1;
            var _local2:Number = ((_arg1 / 75) + 1);
            this.contrastFilter = new ColorMatrixFilter(this.concat([_local2, 0, 0, 0, (128 * (1 - _local2)), 0, _local2, 0, 0, (128 * (1 - _local2)), 0, 0, _local2, 0, (128 * (1 - _local2)), 0, 0, 0, 1, 0]));
            if (false){
                5;
                this;
            } else {
                this.update();
            };
            return;
            /*not popped
            this
            */
        }
        public function get value():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._filters);
        }
        private function update():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._filters = [];
            if (this.brightnessFilter){
                if (false){
                    5;
                    this.brightnessFilter;
                    this._filters;
                } else {
                    this._filters.push(this.brightnessFilter);
                };
            };
            if (this.contrastFilter){
                if (false){
                    5;
                    this.contrastFilter;
                    this._filters;
                } else {
                    this._filters.push(this.contrastFilter);
                };
            };
        }
        private function concat(_arg1:Array):Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Number = 0;
            var _local3:Array = [];
            var _local4:Number = 0;
            var _local5:Number = 0;
            if (_local5 >= 4){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local2 = 0;
            if (_local2 >= 5){
            } else {
                //unresolved jump
            };
            //unresolved jump
            if (false){
                5;
                (((((_arg1[_local4] * INIT[_local2]) + (_arg1[(_local4 + 1)] * INIT[(_local2 + 5)])) + (_arg1[(_local4 + 2)] * INIT[(_local2 + 10)])) + (_arg1[(_local4 + 3)] * INIT[(_local2 + 15)])) + (((_local2 == 4)) ? _arg1[(_local4 + 4)] : 0));
                (_local4 + _local2);
                _local3;
            } else {
                _local3[(_local4 + _local2)] = (((((_arg1[_local4] * INIT[_local2]) + (_arg1[(_local4 + 1)] * INIT[(_local2 + 5)])) + (_arg1[(_local4 + 2)] * INIT[(_local2 + 10)])) + (_arg1[(_local4 + 3)] * INIT[(_local2 + 15)])) + (((_local2 == 4)) ? _arg1[(_local4 + 4)] : 0));
            };
            var _temp1 = (_local4 + _local2);
            var _temp2 = (((((_arg1[_local4] * INIT[_local2]) + (_arg1[(_local4 + 1)] * INIT[(_local2 + 5)])) + (_arg1[(_local4 + 2)] * INIT[(_local2 + 10)])) + (_arg1[(_local4 + 3)] * INIT[(_local2 + 15)])) + (((_local2 == 4)) ? _arg1[(_local4 + 4)] : 0));
            _local2 = (_local2 + 1);
            //unresolved if
            _local4 = (_local4 + 5);
            _local5++;
            //unresolved if
            return (_local3);
            /*not popped
            _temp2
            */
            /*not popped
            _temp1
            */
            /*not popped
            _local3
            */
        }

        if (37 == 34){
            return;
            /*not popped
            ColorFilters
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.utils 
