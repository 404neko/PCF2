package com.bokecc.player.events {
    import flash.events.*;

    public class SetUpPanelDataEvent extends Event {

        public static const VIDEO_SCALE_CHANGE:String = "videoScaleChange";
        public static const ARTICULATION_CHANGE:String = "articulationChange";
        public static const ARTICULATION_ENABLED_CHANGE:String = "articulationEnabledChange";
        public static const LIGHTVALUE_CHANGE:String = "lightValueChange";
        public static const CONTRASTVALUE_CHANGE:String = "contrastValueChange";
        public static const LIGHTVALUE_CONTRASTVALUE_REST:String = "lightvalueContrastvalueRest";

        public function SetUpPanelDataEvent(_arg1:String, _arg2:Boolean=false, _arg3:Boolean=false){
            super(_arg1, _arg2, _arg3);
        }
        override public function clone():Event{
            return (new SetUpPanelDataEvent(this.type, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
