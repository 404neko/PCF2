package com.bokecc.player.ui {
    import flash.display.*;
    import com.bokecc.containers.*;

    public class BufferHead extends Canvas {

        private var _displayer:DisplayObject;
        private var _full:Boolean = false;

        public function get full():Boolean{
            return (this._full);
        }
        public function set full(_arg1:Boolean):void{
            if (this._full != _arg1){
                this._full = _arg1;
                this.updateDisplayList();
            };
        }
        public function get displayer():DisplayObject{
            return (this._displayer);
        }
        public function set displayer(_arg1:DisplayObject):void{
            if (((this._displayer) && (this._displayer.parent))){
                this.removeChild(this._displayer);
            };
            this._displayer = _arg1;
            if (this._displayer){
                this.addChild(this._displayer);
                this.updateDisplayList();
            };
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            if (this._displayer){
                this.scaleComponent(this._displayer);
            };
        }
        private function scaleComponent(_arg1:DisplayObject):void{
            var _local2:Number;
            var _local3:Number;
            var _local4:Number;
            var _local5:Number;
            var _local6:Number;
            if (_arg1){
                _local2 = (_arg1.width / _arg1.height);
                if ((this.width / _local2) > this.height){
                    _local3 = (this.height * _local2);
                    _local4 = this.height;
                } else {
                    _local3 = this.width;
                    _local4 = (this.width / _local2);
                };
                _local5 = (_local3 / (_arg1.width / _arg1.scaleX));
                _local6 = (_local4 / (_arg1.height / _arg1.scaleY));
                if ((((_arg1.width > _local3)) || ((_arg1.width < (_arg1.width / _arg1.scaleX))))){
                    if ((((_local5 > 0)) && ((_local6 > 0)))){
                        _arg1.scaleX = _local5;
                        _arg1.scaleY = _local6;
                    };
                } else {
                    if ((((_arg1.height > _local4)) || ((_arg1.height < (_arg1.height / _arg1.scaleY))))){
                        if ((((_local5 > 0)) && ((_local6 > 0)))){
                            _arg1.scaleX = _local5;
                            _arg1.scaleY = _local6;
                        };
                    } else {
                        if (this._full){
                            _arg1.scaleX = _local5;
                            _arg1.scaleY = _local6;
                        } else {
                            _arg1.scaleX = 1;
                            _arg1.scaleY = 1;
                        };
                    };
                };
                _arg1.x = (0.5 * (this.width - _arg1.width));
                _arg1.y = (0.5 * (this.height - _arg1.height));
            };
        }

    }
}//package com.bokecc.player.ui 
