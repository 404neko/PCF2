package com.bokecc.utils {
    import com.bokecc.lib.crypto.*;
    import com.bokecc.lib.data.*;

    public class CCDecoder {

        public static function init():void{
            Base64Decoder.d = [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, 50, -1, 28, 23, 27, 55, 32, 16, 31, 4, 60, 8, -1, -1, -1, -1, -1, -1, -1, 12, 1, 24, 3, 36, 5, 6, 7, 61, 9, 10, 11, 0, 38, 51, 15, 57, 17, 18, 43, 62, 21, 22, 53, 2, 25, -1, -1, -1, -1, -1, -1, 26, 54, 52, 29, 30, 58, 56, 33, 34, 42, 59, 37, 13, 39, 40, 41, 35, 19, 44, 45, 46, 47, 48, 49, 63, 14, -1, -1, -1, -1, -1];
        }
        public static function decodeBase64(_arg1:String):String{
            if (isNull(_arg1)){
                return ("");
            };
            _arg1 = Base64Decoder.decode(_arg1);
            _arg1 = _arg1.split("+").join("%20");
            _arg1 = decodeURIComponent(_arg1);
            return (_arg1);
        }

    }
}//package com.bokecc.utils 
