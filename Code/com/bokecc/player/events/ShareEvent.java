package com.bokecc.player.events {
    import flash.events.*;

    public class ShareEvent extends Event {

        public static const SHARE_XINLANG:String = "shareXinlang";
        public static const SHARE_TENXUN:String = "shareTenxun";
        public static const SHARE_QQ:String = "shareQQ";
        public static const SHARE_RENREN:String = "shareRenren";
        public static const SHARE_KAIXIN:String = "shareKaixin";
        public static const COPY_HTMLCODE:String = "copyHtmlCode";
        public static const COPY_FLASHURL:String = "copyFlashUrl";
        public static const COPY_VIDEOURL:String = "copyVideoUrl";

        public function ShareEvent(_arg1:String, _arg2:Boolean=false, _arg3:Boolean=false){
            super(_arg1, _arg2, _arg3);
        }
        override public function clone():Event{
            return (new ShareEvent(this.type, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
