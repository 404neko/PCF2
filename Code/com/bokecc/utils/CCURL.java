package com.bokecc.utils {

    public class CCURL {

        public static const UNION:String = "http://union.bokecc.com";
        public static const PLAYER:String = "http://player.bokecc.com";
        public static const SERVLET:String = (UNION + "/servlet");
        public static const FLASH:String = (UNION + "/flash");
        public static const PLAYINFO:String = (SERVLET + "/playinfo");
        public static const PLATFORM:String = (PLAYER + "/platform");
        public static const SKIN:String = (PLATFORM + "/skin");
        public static const VIEW:String = (PLATFORM + "/view");
        public static const PROTECTPLAY:String = (UNION + "/ccplay.bo");
        public static const DELEGATEPLAY:String = (UNION + "/playvideo.bo");
        public static const UpdateAddress:String = "http://spark.bokecc.com/servlet/updateaddress";
        public static const RECOMMENDED:String = "http://recommended.bokecc.com/servlet/recommended/info";
        public static const RECOMMENDEDSKIN:String = (PLATFORM + "/recommend");
        public static const RECOMMENDEDVIDEOCLICK:String = "http://recommended.bokecc.com/statistic/videoclick";
        public static const KernelPlayer:String = (PLATFORM + "/playkernel.swf");
        public static const CCPlayer:String = (FLASH + "/player.swf");
        public static const CCVMSPlayer:String = (FLASH + "/pocle/player.swf");

        public static function getPlayKernel(_arg1:String=""):String{
            return ((((PLATFORM + "/PlayKernel") + _arg1) + ".swf"));
        }
        public static function getSparkView(_arg1:String=""):String{
            return ((((VIEW + "/SparkView") + _arg1) + ".swf"));
        }
        public static function getHTView(_arg1:String=""):String{
            return ((((VIEW + "/HTView") + _arg1) + ".swf"));
        }
        public static function getTDView(_arg1:String=""):String{
            return ((((VIEW + "/TDView") + _arg1) + ".swf"));
        }
        public static function getAdminView(_arg1:String=""):String{
            return ((((VIEW + "/AdminView") + _arg1) + ".swf"));
        }
        public static function getSkin(_arg1:String):String{
            return ((((SKIN + "/skin_") + _arg1) + ".swf"));
        }

    }
}//package com.bokecc.utils 
