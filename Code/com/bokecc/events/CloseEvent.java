package com.bokecc.events {
    import flash.events.*;

    public class CloseEvent extends Event {

        public static const CLOSE:String = "close";

        public var detail:Boolean;

        public function CloseEvent(_arg1:String, _arg2:Boolean, _arg3:Boolean=false, _arg4:Boolean=false){
            super(_arg1, _arg3, _arg4);
            this.detail = _arg2;
        }
        override public function clone():Event{
            return (new CloseEvent(this.type, this.detail, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.events 
