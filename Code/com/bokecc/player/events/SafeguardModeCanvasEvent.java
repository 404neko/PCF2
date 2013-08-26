package com.bokecc.player.events {
    import flash.events.*;

    public class SafeguardModeCanvasEvent extends Event {

        public static const SAFEGUARDMODE_CLICK:String = "safeguardModeClick";
        public static const SAFEGUARDMODE_COPY:String = "safeguardModeCopy";

        public var videoUrl:String;

        public function SafeguardModeCanvasEvent(_arg1:String, _arg2:String, _arg3:Boolean=false, _arg4:Boolean=false){
            super(_arg1, _arg3, _arg4);
            this.videoUrl = _arg2;
        }
        override public function clone():Event{
            return (new SafeguardModeCanvasEvent(this.type, this.videoUrl, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
