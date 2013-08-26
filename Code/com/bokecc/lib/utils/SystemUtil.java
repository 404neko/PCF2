package com.bokecc.lib.utils {
    import flash.system.*;

    public class SystemUtil {

        public static function get versionNum():Number{
            var _local1:Array = versionArray;
            var _local2:String = _local1.shift();
            var _local3:Number = Number(((_local2 + ".") + _local1.join("")));
            return (_local3);
        }
        public static function get versionArray():Array{
            return (String(version.split(" ")[1]).split(","));
        }
        public static function get newline():String{
            var _local1:String = version.split(" ")[0];
            switch (_local1){
                case "MAC":
                    return ("\r");
                case "LINUX":
                    return ("\n");
                case "WINDOWS":
                default:
                    return ("\r\n");
            };
        }
        public static function isBelowVersion(_arg1:Number):Boolean{
            return ((versionNum < _arg1));
        }
        public static function get version():String{
            return (Capabilities.version);
        }
        public static function get memory():Number{
            return (System.totalMemory);
        }
        public static function gc():void{
            System.gc();
        }

    }
}//package com.bokecc.lib.utils 
