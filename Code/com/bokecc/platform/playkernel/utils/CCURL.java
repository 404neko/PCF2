package com.bokecc.platform.playkernel.utils {

    public class CCURL {

        public static const UNION:String = "http://union.bokecc.com";
        public static const PLAYER:String = "http://player.bokecc.com";
        public static const SERVLET:String = (UNION + "/servlet");
        public static const FLASH:String = (UNION + "/flash");
        public static const PLAYINFO:String = (SERVLET + "/playinfo");
        public static const PLATFORM:String = (PLAYER + "/platform");
        public static const VIEW:String = (PLATFORM + "/view");
        public static const PROTECTPLAY:String = (UNION + "/ccplay.bo");
        public static const DELEGATEPLAY:String = (UNION + "/playvideo.bo");
        public static const RECOMMENDED:String = "http://recommended.bokecc.com/servlet/GetSelfVideos";
        public static const KernelPlayer:String = (PLATFORM + "/playkernel.swf");
        public static const VunionPlayer:String = "http://vunion.bokecc.com/flash/player.swf";
        public static const CCPlayer:String = (FLASH + "/player.swf");
        public static const CCVMSPlayer:String = (FLASH + "/pocle/player.swf");

        public static function getPlayKernel(_arg1:String=""):String{
            return ((((PLATFORM + "/PlayKernel") + _arg1) + ".swf"));
        }
        public static function getADS(_arg1:String=""):String{
            return ((((PLATFORM + "/CCBox") + _arg1) + ".swf"));
        }
        public static function getView(_arg1:String, _arg2:String):String{
            return (((((VIEW + "/") + _arg1) + _arg2) + ".swf"));
        }

    }
}//package com.bokecc.platform.playkernel.utils 
