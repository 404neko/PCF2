package com.bokecc.player.vo {
    import flash.events.*;

    public class PlayerListItemVO extends EventDispatcher {

        public var imageUrl:String;
        public var videoName:String;
        public var time:String;
        public var videoUrl:String;
        private var _select:Boolean = false;

        public function PlayerListItemVO(){
            super(null);
        }
        public function get select():Boolean{
            return (this._select);
        }
        public function set select(_arg1:Boolean):void{
            if (this._select != _arg1){
                this._select = _arg1;
                dispatchEvent(new Event(Event.CHANGE));
            };
        }

    }
}//package com.bokecc.player.vo 
