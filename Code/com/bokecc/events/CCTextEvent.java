package com.bokecc.events {
    import flash.events.*;

    public class CCTextEvent extends Event {

        public static const LINK:String = "textLink";

        public var text:String;

        public function CCTextEvent(_arg1:String, _arg2:String, _arg3:Boolean=false, _arg4:Boolean=false){
            super(_arg1, _arg3, _arg4);
            this.text = _arg2;
        }
        override public function clone():Event{
            return (new CCTextEvent(this.type, this.text, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.events 
