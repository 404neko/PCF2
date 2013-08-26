package com.bokecc.player.events {
    import flash.events.*;

    public class ReportPanelEvent extends Event {

        public static const COMMIT:String = "commit";

        public var message:String;

        public function ReportPanelEvent(_arg1:String, _arg2:String, _arg3:Boolean=false, _arg4:Boolean=false){
            super(_arg1, _arg3, _arg4);
            this.message = _arg2;
        }
        override public function clone():Event{
            return (new ReportPanelEvent(this.type, this.message, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
