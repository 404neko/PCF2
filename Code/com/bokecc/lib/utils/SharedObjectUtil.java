package com.bokecc.lib.utils {
    import flash.net.*;

    public class SharedObjectUtil {

        public static function setData(_arg1:String, _arg2, _arg3:String, _arg4:String="/"):void{
            var _local5:SharedObject;
            try {
                _local5 = SharedObject.getLocal(_arg3, _arg4);
                _local5.data[_arg1] = _arg2;
                _local5.flush();
            } catch(e:Error) {
            };
        }
        public static function getData(_arg1:String, _arg2:String, _arg3:String="/"){
            var so:* = null;
            var dataName:* = _arg1;
            var nameSpace:* = _arg2;
            var localPath:String = _arg3;
            try {
                so = SharedObject.getLocal(nameSpace, localPath);
                return (so.data[dataName]);
            } catch(e:Error) {
                return (null);
            };
        }

    }
}//package com.bokecc.lib.utils 
