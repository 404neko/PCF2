package com.bokecc.player.events {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.player.vo.*;

    public class PlayerListEvent extends Event {

        public static const ITEM_CLICK:String = "playerListItemClick";
        public static const CONTRACTIONBUTTON_CLICK:String = "contractionButtonClick";
        public static const NEXT_BUTTON_CLICK:String = "nextButtonClick";
        public static const PREVIOUS_BUTTON_CLICK:String = "previousButtonClick";

        public var itemdata:PlayerListItemVO;
        public var itemdataRenderer:DisplayObject;
        public var index:int;

        public function PlayerListEvent(_arg1:String, _arg2:PlayerListItemVO, _arg3:DisplayObject, _arg4:int, _arg5:Boolean=false, _arg6:Boolean=false){
            super(_arg1, _arg5, _arg6);
            this.itemdata = _arg2;
            this.itemdataRenderer = _arg3;
            this.index = _arg4;
        }
        override public function clone():Event{
            return (new PlayerListEvent(this.type, this.itemdata, this.itemdataRenderer, this.index, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
