package com.lia.crypto {

    public class AES {

        public static const BIT_KEY_128:int = 128;
        public static const BIT_KEY_192:int = 192;
        public static const BIT_KEY_256:int = 0x0100;
        private static const SBOX:Array = [99, 124, 119, 123, 242, 107, 111, 197, 48, 1, 103, 43, 254, 215, 171, 118, 202, 130, 201, 125, 250, 89, 71, 240, 173, 212, 162, 175, 156, 164, 114, 192, 183, 253, 147, 38, 54, 63, 247, 204, 52, 165, 229, 241, 113, 216, 49, 21, 4, 199, 35, 195, 24, 150, 5, 154, 7, 18, 128, 226, 235, 39, 178, 117, 9, 131, 44, 26, 27, 110, 90, 160, 82, 59, 214, 179, 41, 227, 47, 132, 83, 209, 0, 237, 32, 252, 177, 91, 106, 203, 190, 57, 74, 76, 88, 207, 208, 239, 170, 251, 67, 77, 51, 133, 69, 249, 2, 127, 80, 60, 159, 168, 81, 163, 64, 143, 146, 157, 56, 245, 188, 182, 218, 33, 16, 0xFF, 243, 210, 205, 12, 19, 236, 95, 151, 68, 23, 196, 167, 126, 61, 100, 93, 25, 115, 96, 129, 79, 220, 34, 42, 144, 136, 70, 238, 184, 20, 222, 94, 11, 219, 224, 50, 58, 10, 73, 6, 36, 92, 194, 211, 172, 98, 145, 149, 228, 121, 231, 200, 55, 109, 141, 213, 78, 169, 108, 86, 244, 234, 101, 122, 174, 8, 186, 120, 37, 46, 28, 166, 180, 198, 232, 221, 116, 31, 75, 189, 139, 138, 112, 62, 181, 102, 72, 3, 246, 14, 97, 53, 87, 185, 134, 193, 29, 158, 225, 248, 152, 17, 105, 217, 142, 148, 155, 30, 135, 233, 206, 85, 40, 223, 140, 161, 137, 13, 191, 230, 66, 104, 65, 153, 45, 15, 176, 84, 187, 22];
        private static const RCON:Array = [[0, 0, 0, 0], [1, 0, 0, 0], [2, 0, 0, 0], [4, 0, 0, 0], [8, 0, 0, 0], [16, 0, 0, 0], [32, 0, 0, 0], [64, 0, 0, 0], [128, 0, 0, 0], [27, 0, 0, 0], [54, 0, 0, 0]];

        public static function decrypt(_arg1:String, _arg2:String, _arg3:int):String{
            var _local16:int;
            var _local18:int;
            var _local19:Array;
            var _local20:Array;
            var _local4 = 16;
            if (!(((((_arg3 == BIT_KEY_128)) || ((_arg3 == BIT_KEY_192)))) || ((_arg3 == BIT_KEY_256)))){
                throw (new Error("Must be a key mode of either 128, 192, 256 bits"));
            };
            _arg1 = Base64.decode(_arg1);
            _arg2 = Utf8.encode(_arg2);
            var _local5:int = (_arg3 / 8);
            var _local6:Array = new Array(_local5);
            var _local7:int;
            while (_local7 < _local5) {
                _local6[_local7] = ((isNaN(_arg2.charCodeAt(_local7))) ? 0 : _arg2.charCodeAt(_local7));
                _local7++;
            };
            var _local8:Array = cipher(_local6, keyExpansion(_local6));
            _local8 = cipher(_local6, keyExpansion(_local6)).concat(_local8.slice(0, (_local5 - 16)));
            var _local9:Array = new Array(8);
            var _local10:String = _arg1.slice(0, 8);
            _local7 = 0;
            while (_local7 < 8) {
                _local9[_local7] = _local10.charCodeAt(_local7);
                _local7++;
            };
            var _local11:Array = keyExpansion(_local8);
            var _local12:int = Math.ceil(((_arg1.length - 8) / _local4));
            var _local13:Array = new Array(_local12);
            _local16 = 0;
            while (_local16 < _local12) {
                _local13[_local16] = _arg1.slice((8 + (_local16 * _local4)), ((8 + (_local16 * _local4)) + _local4));
                _local16++;
            };
            var _local14:Array = _local13;
            var _local15:Array = new Array(_local14.length);
            _local16 = 0;
            while (_local16 < _local12) {
                _local18 = 0;
                while (_local18 < 4) {
                    _local9[(15 - _local18)] = ((_local16 >>> (_local18 * 8)) & 0xFF);
                    _local18++;
                };
                _local18 = 0;
                while (_local18 < 4) {
                    _local9[((15 - _local18) - 4)] = (((((_local16 + 1) / 4294967296) - 1) >>> (_local18 * 8)) & 0xFF);
                    _local18++;
                };
                _local19 = cipher(_local9, _local11);
                _local20 = new Array(String(_local14[_local16]).length);
                _local7 = 0;
                while (_local7 < String(_local14[_local16]).length) {
                    _local20[_local7] = (_local19[_local7] ^ String(_local14[_local16]).charCodeAt(_local7));
                    _local20[_local7] = String.fromCharCode(_local20[_local7]);
                    _local7++;
                };
                _local15[_local16] = _local20.join("");
                _local16++;
            };
            var _local17:String = _local15.join("");
            _local17 = Utf8.decode(_local17);
            return (_local17);
        }
        private static function cipher(_arg1:Array, _arg2:Array):Array{
            var _local3 = 4;
            var _local4:int = ((_arg2.length / _local3) - 1);
            var _local5:Array = [[], [], [], []];
            var _local6:int;
            while (_local6 < (4 * _local3)) {
                _local5[(_local6 % 4)][Math.floor((_local6 / 4))] = _arg1[_local6];
                _local6++;
            };
            _local5 = addRoundKey(_local5, _arg2, 0, _local3);
            var _local7 = 1;
            while (_local7 < _local4) {
                _local5 = subBytes(_local5, _local3);
                _local5 = shiftRows(_local5, _local3);
                _local5 = mixColumns(_local5);
                _local5 = addRoundKey(_local5, _arg2, _local7, _local3);
                _local7++;
            };
            _local5 = subBytes(_local5, _local3);
            _local5 = shiftRows(_local5, _local3);
            _local5 = addRoundKey(_local5, _arg2, _local4, _local3);
            var _local8:Array = new Array((4 * _local3));
            var _local9:int;
            while (_local9 < (4 * _local3)) {
                _local8[_local9] = _local5[(_local9 % 4)][Math.floor((_local9 / 4))];
                _local9++;
            };
            return (_local8);
        }
        private static function keyExpansion(_arg1:Array):Array{
            var _local8:Array;
            var _local9:int;
            var _local2 = 4;
            var _local3:int = (_arg1.length / 4);
            var _local4:int = (_local3 + 6);
            var _local5:Array = new Array((_local2 * (_local4 + 1)));
            var _local6:Array = new Array(4);
            var _local7:int;
            while (_local7 < _local3) {
                _local8 = [_arg1[(4 * _local7)], _arg1[((4 * _local7) + 1)], _arg1[((4 * _local7) + 2)], _arg1[((4 * _local7) + 3)]];
                _local5[_local7] = _local8;
                _local7++;
            };
            _local7 = _local3;
            while (_local7 < (_local2 * (_local4 + 1))) {
                _local5[_local7] = new Array(4);
                _local9 = 0;
                while (_local9 < 4) {
                    _local6[_local9] = _local5[(_local7 - 1)][_local9];
                    _local9++;
                };
                if ((_local7 % _local3) == 0){
                    _local6 = subWord(rotWord(_local6));
                    _local9 = 0;
                    while (_local9 < 4) {
                        _local6[_local9] = (_local6[_local9] ^ RCON[(_local7 / _local3)][_local9]);
                        _local9++;
                    };
                } else {
                    if ((((_local3 > 6)) && (((_local7 % _local3) == 4)))){
                        _local6 = subWord(_local6);
                    };
                };
                _local9 = 0;
                while (_local9 < 4) {
                    _local5[_local7][_local9] = (_local5[(_local7 - _local3)][_local9] ^ _local6[_local9]);
                    _local9++;
                };
                _local7++;
            };
            return (_local5);
        }
        private static function subBytes(_arg1:Array, _arg2:int):Array{
            var _local4:int;
            var _local3:int;
            while (_local3 < 4) {
                _local4 = 0;
                while (_local4 < _arg2) {
                    _arg1[_local3][_local4] = SBOX[_arg1[_local3][_local4]];
                    _local4++;
                };
                _local3++;
            };
            return (_arg1);
        }
        private static function shiftRows(_arg1:Array, _arg2:int):Array{
            var _local5:int;
            var _local3:Array = new Array(4);
            var _local4 = 1;
            while (_local4 < 4) {
                _local5 = 0;
                while (_local5 < 4) {
                    _local3[_local5] = _arg1[_local4][((_local5 + _local4) % _arg2)];
                    _local5++;
                };
                _local5 = 0;
                while (_local5 < 4) {
                    _arg1[_local4][_local5] = _local3[_local5];
                    _local5++;
                };
                _local4++;
            };
            return (_arg1);
        }
        private static function mixColumns(_arg1:Array):Array{
            var _local3:Array;
            var _local4:Array;
            var _local5:int;
            var _local2:int;
            while (_local2 < 4) {
                _local3 = new Array(4);
                _local4 = new Array(4);
                _local5 = 0;
                while (_local5 < 4) {
                    _local3[_local5] = _arg1[_local5][_local2];
                    _local4[_local5] = (((_arg1[_local5][_local2] & 128)) ? ((_arg1[_local5][_local2] << 1) ^ 283) : (_arg1[_local5][_local2] << 1));
                    _local5++;
                };
                _arg1[0][_local2] = ((((_local4[0] ^ _local3[1]) ^ _local4[1]) ^ _local3[2]) ^ _local3[3]);
                _arg1[1][_local2] = ((((_local3[0] ^ _local4[1]) ^ _local3[2]) ^ _local4[2]) ^ _local3[3]);
                _arg1[2][_local2] = ((((_local3[0] ^ _local3[1]) ^ _local4[2]) ^ _local3[3]) ^ _local4[3]);
                _arg1[3][_local2] = ((((_local3[0] ^ _local4[0]) ^ _local3[1]) ^ _local3[2]) ^ _local4[3]);
                _local2++;
            };
            return (_arg1);
        }
        private static function addRoundKey(_arg1:Array, _arg2:Array, _arg3:int, _arg4:int):Array{
            var _local6:int;
            var _local5:int;
            while (_local5 < 4) {
                _local6 = 0;
                while (_local6 < _arg4) {
                    _arg1[_local5][_local6] = (_arg1[_local5][_local6] ^ _arg2[((_arg3 * 4) + _local6)][_local5]);
                    _local6++;
                };
                _local5++;
            };
            return (_arg1);
        }
        private static function subWord(_arg1:Array):Array{
            var _local2:int;
            while (_local2 < 4) {
                _arg1[_local2] = SBOX[_arg1[_local2]];
                _local2++;
            };
            return (_arg1);
        }
        private static function rotWord(_arg1:Array):Array{
            var _local2:int = _arg1[0];
            var _local3:int;
            while (_local3 < 3) {
                _arg1[_local3] = _arg1[(_local3 + 1)];
                _local3++;
            };
            _arg1[3] = _local2;
            return (_arg1);
        }

    }
}//package com.lia.crypto 

class Base64 {

    private static const code:String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    public function Base64(){
    }
    public static function encode

    // Error while decompiling!

    public static function decode(_arg1:String, _arg2:Boolean=false):String{
        var _local3:int;
        var _local4:int;
        var _local5:int;
        var _local6:int;
        var _local7:int;
        var _local8:int;
        var _local9:int;
        var _local10:int;
        var _local12:String;
        var _local13:String;
        var _local11:Array = [];
        var _local14:String = Base64.code;
        _local13 = ((_arg2) ? Utf8.decode(_arg1) : _arg1);
        var _local15:int;
        while (_local15 < _local13.length) {
            _local6 = _local14.indexOf(_local13.charAt(_local15));
            _local7 = _local14.indexOf(_local13.charAt((_local15 + 1)));
            _local8 = _local14.indexOf(_local13.charAt((_local15 + 2)));
            _local9 = _local14.indexOf(_local13.charAt((_local15 + 3)));
            _local10 = ((((_local6 << 18) | (_local7 << 12)) | (_local8 << 6)) | _local9);
            _local3 = ((_local10 >>> 16) & 0xFF);
            _local4 = ((_local10 >>> 8) & 0xFF);
            _local5 = (_local10 & 0xFF);
            _local11[(_local15 / 4)] = (String.fromCharCode(_local3, _local4, _local5) + "");
            if (_local9 == 64){
                _local11[(_local15 / 4)] = String.fromCharCode(_local3, _local4);
            };
            if (_local8 == 64){
                _local11[(_local15 / 4)] = String.fromCharCode(_local3);
            };
            _local15 = (_local15 + 4);
        };
        _local12 = _local11.join("");
        return (((_arg2) ? Utf8.decode(_local12) : _local12));
    }

}
class Utf8 {

    public function Utf8(){
    }
    public static function encode(_arg1:String):String{
        var _local4:int;
        var _local2 = "";
        var _local3:int;
        while (_local3 < _arg1.length) {
            _local4 = _arg1.charCodeAt(_local3);
            if (_local4 < 128){
                _local2 = (_local2 + String.fromCharCode(_local4));
            } else {
                if ((((_local4 > 127)) && ((_local4 < 0x0800)))){
                    _local2 = (_local2 + String.fromCharCode(((_local4 >> 6) | 192)));
                    _local2 = (_local2 + String.fromCharCode(((_local4 & 63) | 128)));
                } else {
                    _local2 = (_local2 + String.fromCharCode(((_local4 >> 12) | 224)));
                    _local2 = (_local2 + String.fromCharCode((((_local4 >> 6) & 63) | 128)));
                    _local2 = (_local2 + String.fromCharCode(((_local4 & 63) | 128)));
                };
            };
            _local3++;
        };
        return (_local2);
    }
    public static function decode(_arg1:String):String{
        var _local2 = "";
        var _local3:int;
        var _local4:int;
        var _local5:int;
        var _local6:int;
        while (_local3 < _arg1.length) {
            _local4 = _arg1.charCodeAt(_local3);
            if (_local4 < 128){
                _local2 = (_local2 + String.fromCharCode(_local4));
                _local3++;
            } else {
                if ((((_local4 > 191)) && ((_local4 < 224)))){
                    _local5 = _arg1.charCodeAt((_local3 + 1));
                    _local2 = (_local2 + String.fromCharCode((((_local4 & 31) << 6) | (_local5 & 63))));
                    _local3 = (_local3 + 2);
                } else {
                    _local5 = _arg1.charCodeAt((_local3 + 1));
                    _local6 = _arg1.charCodeAt((_local3 + 2));
                    _local2 = (_local2 + String.fromCharCode(((((_local4 & 15) << 12) | ((_local5 & 63) << 6)) | (_local6 & 63))));
                    _local3 = (_local3 + 3);
                };
            };
        };
        return (_local2);
    }

}
