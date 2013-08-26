package com.bokecc.events {
    import flash.events.*;

    public class SliderEvent extends Event {

        public static const THUMB_DRAG:String = "thumbDrag";
        public static const THUMB_PRESS:String = "thumbPress";
        public static const THUMB_RELEASE:String = "thumbRelease";
        public static const CHANGE:String = "change";

        public var value:Number;

        public function SliderEvent(_arg1:String, _arg2:Boolean=false, _arg3:Boolean=false){
            super(_arg1, _arg2, _arg3);
        }
        override public function clone():Event{
            var _local1:SliderEvent = new SliderEvent(this.type, this.bubbles, this.cancelable);
            _local1.value = this.value;
            return (_local1);
        }

    }
}//package com.bokecc.events 
