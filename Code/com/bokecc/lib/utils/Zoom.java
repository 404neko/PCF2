package com.bokecc.lib.utils {

    public class Zoom {

        public static const Allways:int = 0;
        public static const Narrow:int = 1;

        private var ow:Number;
        private var oh:Number;
        private var _xyscale:Number;
        private var _zscale:Number = 1;
        private var m:int;

        public function Zoom(_arg1:Number, _arg2:Number, _arg3:int=0){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            if (false){
                5;
                _arg2;
                _arg1;
                this;
            } else {
                this.setWH(_arg1, _arg2);
            };
            this.scale = (_arg1 / _arg2);
            this.mode = _arg3;
            return;
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
        public function setWH(_arg1:Number, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.ow = _arg1;
            this.oh = _arg2;
        }
        public function set mode(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.m = _arg1;
        }
        public function get scale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._xyscale);
        }
        public function set scale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._xyscale = _arg1;
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
        public function set zscale(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if ((((_arg1 >= 0)) && ((_arg1 <= 1)))){
                this._zscale = _arg1;
            };
        }
        public function getXYWH(_arg1:Number, _arg2:Number):Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local5:Number;
            var _local6:Number;
            var _local10:Number;
            var _local11:Number;
            var _local3:Number = 0;
            var _local4:Number = 0;
            if (this.zscale < 1){
                _local10 = _arg1;
                _local11 = _arg2;
                _arg1 = (_arg1 * this.zscale);
                _arg2 = (_arg2 * this.zscale);
                _local3 = ((_local10 - _arg1) / 2);
                _local4 = ((_local11 - _arg2) / 2);
            };
            var _local7:Number = this.ow;
            var _local8:Number = this.oh;
            var _local9:Boolean;
            if (this.m == Narrow){
                _local9 = (((_arg1 < this.ow)) || ((_arg2 < this.oh)));
            };
            if (_local9){
                if (this._xyscale == 0){
                    _local7 = _arg1;
                    _local8 = _arg2;
                } else {
                    if ((_arg1 / _arg2) > this._xyscale){
                        _local7 = (_arg2 * this._xyscale);
                        _local8 = _arg2;
                    } else {
                        _local7 = _arg1;
                        _local8 = (_arg1 / this._xyscale);
                    };
                };
            };
            _local5 = (_local3 + ((_arg1 - _local7) / 2));
            _local6 = (_local4 + ((_arg2 - _local8) / 2));
            return ([_local5, _local6, _local7, _local8]);
        }

        if (37 == 34){
            return;
            /*not popped
            Zoom
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
