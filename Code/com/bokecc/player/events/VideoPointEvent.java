package com.bokecc.player.events {
    import flash.events.*;
    import com.bokecc.player.ui.*;

    public class VideoPointEvent extends Event {

        public static const POINT_ROLL_OVER:String = "pointRollOver";
        public static const POINT_ROLL_OUT:String = "pointRollOut";

        public var pointUI:PointUI;

        public function VideoPointEvent(_arg1:String, _arg2:PointUI, _arg3:Boolean=false, _arg4:Boolean=false){
            super(_arg1, _arg3, _arg4);
            this.pointUI = _arg2;
        }
        override public function clone():Event{
            return (new VideoPointEvent(this.type, this.pointUI, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
