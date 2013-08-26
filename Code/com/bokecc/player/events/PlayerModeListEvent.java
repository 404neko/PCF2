package com.bokecc.player.events {
    import flash.events.*;

    public class PlayerModeListEvent extends Event {

        public static const ITEM_CLICK:String = "playerModeListItemClick";
        public static const MODE_CHANGE:String = "modeChange";

        public var modeType:String = "";

        public function PlayerModeListEvent(_arg1:String, _arg2:String, _arg3:Boolean=false, _arg4:Boolean=false){
            super(_arg1, _arg3, _arg4);
            this.modeType = _arg2;
        }
        override public function clone():Event{
            return (new PlayerModeListEvent(this.type, this.modeType, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
