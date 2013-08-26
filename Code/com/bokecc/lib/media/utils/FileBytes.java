package com.bokecc.lib.media.utils {
    import flash.utils.*;

    public class FileBytes {

        public static const MAX:Number = 0xA00000;

        protected var _bytes:Array;
        private var _length:Number = 0;

        public function FileBytes(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super();
            this._bytes = [];
        }
        public function clear():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:ByteArray;
            if (this._bytes.length <= 0){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local1 = this._bytes.pop();
            //unresolved if
            if (false){
                5;
                _local1;
            } else {
                _local1.clear();
            };
            //unresolved if
            this._length = 0;
            return;
            /*not popped
            _local1
            */
        }
        public function getBytes(_arg1:Number, _arg2:Number):ByteArray{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local4:ByteArray;
            var _local5:Number;
            var _local6:Number;
            var _local3:ByteArray = new ByteArray();
            if (_arg1 >= _arg2){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local4 = this.getByteArrayByPosition(_arg1);
            if (_local4 == null){
            } else {
                _local5 = (_arg1 % MAX);
                _local6 = Math.min((_local4.length - _local5), (_arg2 - _arg1));
                if (_local6 <= 0){
                } else {
                    if (false){
                        5;
                        _local5;
                        _local4;
                    } else {
                        _local4.position = _local5;
                    };
                    if (false){
                        5;
                        _local6;
                        _local3.length;
                        _local3;
                        _local4;
                    } else {
                        _local4.readBytes(_local3, _local3.length, _local6);
                    };
                    var _temp1 = _local4;
                    var _temp2 = _local5;
                    var _temp3 = _local4;
                    var _temp4 = _local6;
                    _arg1 = (_arg1 + _local6);
                    //unresolved if
                };
            };
            return (_local3);
        }
        public function get length():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._length);
        }
        public function push(_arg1:ByteArray):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:ByteArray;
            var _local4:Number;
            if (false){
                5;
                0;
                _arg1;
            } else {
                _arg1.position = 0;
            };
            var _local2:Number = _arg1.bytesAvailable;
            if (_local2 <= 0){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local3 = this.getByteArrayByPosition(this._length, true);
            _local4 = Math.min(_local2, (MAX - _local3.length));
            if (false){
                5;
                _local4;
                _local3.length;
                _local3;
                _arg1;
            } else {
                _arg1.readBytes(_local3, _local3.length, _local4);
            };
            this._length = (this._length + _local4);
            var _temp1 = _local4;
            _local2 = _arg1.bytesAvailable;
            //unresolved if
            return;
            /*not popped
            _temp1
            */
            /*not popped
            _local3.length
            */
            /*not popped
            _local3
            */
            /*not popped
            _arg1
            */
            /*not popped
            0
            */
            /*not popped
            _arg1
            */
        }
        protected function getByteArrayByIndex(_arg1:int, _arg2:Boolean=false):ByteArray{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local3:Number;
            if (_arg1 >= 0){
                _local3 = this._bytes.length;
                if (_arg1 < _local3){
                    return (this._bytes[_arg1]);
                };
                if (_arg2){
                    if (_arg1 < _local3){
                    } else {
                        //unresolved jump
                    };
                    //unresolved jump
                    if (false){
                        5;
                        new ByteArray();
                        _local3;
                        this._bytes;
                    } else {
                        this._bytes[_local3] = new ByteArray();
                    };
                    var _temp1 = _local3;
                    _local3 = (_local3 + 1);
                    //unresolved if
                    return (this._bytes[_arg1]);
                    /*not popped
                    new ByteArray()
                    */
                    /*not popped
                    _temp1
                    */
                    /*not popped
                    this._bytes
                    */
                };
            };
            return (null);
        }
        protected function getByteArrayByPosition(_arg1:Number, _arg2:Boolean=false):ByteArray{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:int = Math.floor((_arg1 / MAX));
            return (this.getByteArrayByIndex(_local3, _arg2));
        }

        if (37 == 34){
            return;
            /*not popped
            FileBytes
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.utils 
