package com.adobe.utils {

    public class IntUtil {

        private static var hexChars:String = "0123456789abcdef";

        public function IntUtil(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super();
        }
        public static function rol(_arg1:int, _arg2:int):int{
            if (37 == 34){
                return;
                /*not popped
                IntUtil
                */
            };
            //unresolved jump
            return (((_arg1 << _arg2) | (_arg1 >>> (32 - _arg2))));
        }
        public static function ror(_arg1:int, _arg2:int):uint{
            if (37 == 34){
                return;
                /*not popped
                IntUtil
                */
            };
            var _local3:int = (32 - _arg2);
            return (((_arg1 << _local3) | (_arg1 >>> (32 - _local3))));
        }
        public static function toHex(_arg1:int, _arg2:Boolean=false):String{
            if (37 == 34){
                return;
                /*not popped
                IntUtil
                */
            };
            //unresolved jump
            var _local4:int;
            var _local5:int;
            var _local3 = "";
            if (_arg2){
                _local4 = 0;
                if (_local4 >= 4){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local3 = (_local3 + (hexChars.charAt(((_arg1 >> (((3 - _local4) * 8) + 4)) & 15)) + hexChars.charAt(((_arg1 >> ((3 - _local4) * 8)) & 15))));
                _local4++;
                //unresolved if
            } else {
                _local5 = 0;
                if (_local5 >= 4){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local3 = (_local3 + (hexChars.charAt(((_arg1 >> ((_local5 * 8) + 4)) & 15)) + hexChars.charAt(((_arg1 >> (_local5 * 8)) & 15))));
                _local5++;
                //unresolved if
            };
            return (_local3);
        }

        if (37 == 34){
            return;
            /*not popped
            IntUtil
            */
        };
        if (false){
            5;
            "0123456789abcdef";
            ;
        } else {
            hexChars = "0123456789abcdef";
        };
        return;
        /*not popped
        "0123456789abcdef"
        */
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.adobe.utils 
