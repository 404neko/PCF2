package com.bokecc.player.events {
    import flash.events.*;
    import com.bokecc.player.vo.*;

    public class SetUpMenuEvent extends Event {

        public static const ITEM_CLICK:String = "setUpMenuItemClick";

        public var itemdata:SetUpMenuItemVO;

        public function SetUpMenuEvent(_arg1:String, _arg2:SetUpMenuItemVO, _arg3:Boolean=false, _arg4:Boolean=false){
            super(_arg1, _arg3, _arg4);
            this.itemdata = _arg2;
        }
        override public function clone():Event{
            return (new SetUpMenuEvent(this.type, this.itemdata, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
