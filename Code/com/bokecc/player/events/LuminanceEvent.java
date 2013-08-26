package com.bokecc.player.events {
    import flash.events.*;

    public class LuminanceEvent extends Event {

        public static const LIGHT_CHANGE:String = "lightChange";
        public static const CONTRAST_CHANGE:String = "contrastChange";
        public static const OK:String = "ok";
        public static const REST:String = "rest";

        public var lightValue:Number;
        public var contrastValue:Number;

        public function LuminanceEvent(_arg1:String, _arg2:Number, _arg3:Number, _arg4:Boolean=false, _arg5:Boolean=false){
            super(_arg1, _arg4, _arg5);
            this.lightValue = _arg2;
            this.contrastValue = _arg3;
        }
        override public function clone():Event{
            return (new LuminanceEvent(this.type, this.lightValue, this.contrastValue, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
