package com.bokecc.player.events {
    import flash.events.*;

    public class ControlEvent extends Event {

        public static const DRAG_START:String = "dragStart";
        public static const DRAG_PRESS:String = "dragPress";
        public static const DRAG_END:String = "dragEnd";
        public static const BASE_PLAY_BUTTON_CLICK:String = "basePlayButtonClick";
        public static const PLAY_BUTTON_CLICK:String = "playButtonClick";
        public static const DRAG:String = "drag";
        public static const VOLUME_CHANGE:String = "volumeChange";
        public static const FULL_SCREEN:String = "fullScreen";
        public static const NORMAL_SCREEN:String = "normalScreen";
        public static const REWIND_STEP:String = "rewindStep";
        public static const FORWARD_STEP:String = "forwardStep";
        public static const PROGRESSCONTROLBAR_MOUSE_MOVE:String = "progresscontrolbarMouseMove";
        public static const PROGRESSCONTROLBAR_ROLL_OVER:String = "progresscontrolbarRollOver";
        public static const PROGRESSCONTROLBAR_ROLL_OUT:String = "progresscontrolbarRollOut";

        public var value:Number = 0;
        public var state:String;

        public function ControlEvent(_arg1:String, _arg2:Number=0, _arg3:String="", _arg4:Boolean=false, _arg5:Boolean=false){
            super(_arg1, _arg4, _arg5);
            this.value = _arg2;
            this.state = _arg3;
        }
        override public function clone():Event{
            var _local1:ControlEvent = new ControlEvent(type, this.value, this.state, this.bubbles, this.cancelable);
            return (_local1);
        }

    }
}//package com.bokecc.player.events 
