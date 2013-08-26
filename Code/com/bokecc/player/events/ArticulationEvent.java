package com.bokecc.player.events {
    import flash.events.*;

    public class ArticulationEvent extends Event {

        public static const HIGH_DEFINITION:String = "highDefinition";
        public static const DEFINITION:String = "definition";
        public static const NORMAL_DEFINITION:String = "normalDefinition";
        public static const OK:String = "ok";

        public function ArticulationEvent(_arg1:String, _arg2:Boolean=false, _arg3:Boolean=false){
            super(_arg1, _arg2, _arg3);
        }
        override public function clone():Event{
            return (new ArticulationEvent(this.type, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
