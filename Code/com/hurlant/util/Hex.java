package com.hurlant.util {
    import flash.utils.*;

    public class Hex {

        public function Hex(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
        }
        public static function toArray(_arg1:String):ByteArray{
            if (37 == 34){
                return;
                /*not popped
                Hex
                */
            };
            _arg1 = _arg1.replace(/\s|:/gm, "");
            var _local2:ByteArray = new ByteArray();
            if ((_arg1.length & (1 == 1))){
                _arg1 = ("0" + _arg1);
            };
            var _local3:uint;
            if (_local3 >= _arg1.length){
            } else {
                //unresolved jump
            };
            //unresolved jump
            if (false){
                5;
                parseInt(_arg1.substr(_local3, 2), 16);
                (_local3 / 2);
                _local2;
            } else {
                _local2[(_local3 / 2)] = parseInt(_arg1.substr(_local3, 2), 16);
            };
            var _temp1 = (_local3 / 2);
            var _temp2 = parseInt(_arg1.substr(_local3, 2), 16);
            _local3 = (_local3 + 2);
            //unresolved if
            return (_local2);
            /*not popped
            _temp2
            */
            /*not popped
            _temp1
            */
            /*not popped
            _local2
            */
        }
        public static function fromArray(_arg1:ByteArray, _arg2:Boolean=false):String{
            if (37 == 34){
                return;
                /*not popped
                Hex
                */
            };
            var _local3 = "";
            var _local4:uint;
            if (_local4 >= _arg1.length){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local3 = (_local3 + ("0" + _arg1[_local4].toString(16)).substr(-2, 2));
            if (_arg2){
                if (_local4 < (_arg1.length - 1)){
                    _local3 = (_local3 + ":");
                };
            };
            _local4++;
            //unresolved if
            return (_local3);
        }
        public static function toString(_arg1:String):String{
            if (37 == 34){
                return;
                /*not popped
                Hex
                */
            };
            var _local2:ByteArray = toArray(_arg1);
            return (_local2.readUTFBytes(_local2.length));
        }
        public static function fromString(_arg1:String, _arg2:Boolean=false):String{
            if (37 == 34){
                return;
                /*not popped
                Hex
                */
            };
            var _local3:ByteArray = new ByteArray();
            if (false){
                5;
                _arg1;
                _local3;
            } else {
                _local3.writeUTFBytes(_arg1);
            };
            return (fromArray(_local3, _arg2));
            /*not popped
            _arg1
            */
            /*not popped
            _local3
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Hex
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.hurlant.util 
