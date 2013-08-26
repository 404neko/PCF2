package com.bokecc.player.events {
    import flash.events.*;

    public class VideoScaleEvent extends Event {

        public static const ORIGINAL:String = "original";
        public static const FULL:String = "full";
        public static const SCALE_4_3:String = "scale43";
        public static const SCALE_16_9:String = "scale169";
        public static const OK:String = "ok";

        public function VideoScaleEvent(_arg1:String, _arg2:Boolean=false, _arg3:Boolean=false){
            super(_arg1, _arg2, _arg3);
        }
        override public function clone():Event{
            return (new VideoScaleEvent(this.type, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
