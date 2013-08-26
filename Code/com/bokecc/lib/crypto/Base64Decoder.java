package com.bokecc.lib.crypto {

    public class Base64Decoder {

        public static var d:Array = [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, 39, 18, 27, 61, 53, 26, 32, 30, 38, 2, 42, 58, 1, -1, -1, -1, -1, -1, -1, -1, 13, 49, 4, 16, 6, 14, 20, 41, 56, -1, 17, 33, 34, 57, 8, 37, 62, 63, 11, 60, 28, 36, 43, 0, -1, 7, -1, -1, -1, -1, -1, -1, 21, 48, 24, 45, 51, 29, 19, 25, 54, 59, 50, 3, 15, 52, -1, 35, 47, 10, 12, 9, 44, 5, 40, 55, 22, 23, -1, 46, -1, -1, -1];

        public static function decode(_arg1:String):String{
            var _local2:Number;
            var _local3:Number;
            var _local4:Number;
            var _local5:Number;
            var _local6:Number = _arg1.length;
            var _local7:Number = 0;
            var _local8 = "";
            while (_local7 < _local6) {
                do  {
                    var _temp1 = _local7;
                    _local7 = (_local7 + 1);
                    _local2 = d[(_arg1.charCodeAt(_temp1) & 0xFF)];
                } while ((((_local7 < _local6)) && ((_local2 == -1))));
                if (_local2 == -1){
                    break;
                };
                do  {
                    var _temp2 = _local7;
                    _local7 = (_local7 + 1);
                    _local3 = d[(_arg1.charCodeAt(_temp2) & 0xFF)];
                } while ((((_local7 < _local6)) && ((_local3 == -1))));
                if (_local3 == -1){
                    break;
                };
                _local8 = (_local8 + String.fromCharCode(((_local2 << 2) | ((_local3 & 48) >>> 4))));
                do  {
                    var _temp3 = _local7;
                    _local7 = (_local7 + 1);
                    _local4 = (_arg1.charCodeAt(_temp3) & 0xFF);
                    if (_local4 == 61){
                        return (_local8);
                    };
                    _local4 = d[_local4];
                } while ((((_local7 < _local6)) && ((_local4 == -1))));
                if (_local4 == -1){
                    break;
                };
                _local8 = (_local8 + String.fromCharCode((((_local3 & 15) << 4) | ((_local4 & 60) >>> 2))));
                do  {
                    var _temp4 = _local7;
                    _local7 = (_local7 + 1);
                    _local5 = (_arg1.charCodeAt(_temp4) & 0xFF);
                    if (_local5 == 61){
                        return (_local8);
                    };
                    _local5 = d[_local5];
                } while ((((_local7 < _local6)) && ((_local5 == -1))));
                if (_local5 == -1){
                    break;
                };
                _local8 = (_local8 + String.fromCharCode((((_local4 & 3) << 6) | _local5)));
            };
            return (_local8);
        }

    }
}//package com.bokecc.lib.crypto 
