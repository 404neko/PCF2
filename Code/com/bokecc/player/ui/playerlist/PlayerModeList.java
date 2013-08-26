package com.bokecc.player.ui.playerlist {
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class PlayerModeList extends VBox {

        public static const SEQUENCE:String = "sequence";
        public static const RANDOM:String = "random";
        public static const LOOP:String = "loop";
        public static const SINGLE:String = "single";

        private var _sequenceItem:PlayerModeListItem;
        private var _randomItem:PlayerModeListItem;
        private var _loopItem:PlayerModeListItem;
        private var _singleItem:PlayerModeListItem;
        private var _mode:String = "sequence";
        private var selectItem:PlayerModeListItem;

        public function PlayerModeList(){
            this.paddingLeft = 0;
            this.paddingRight = 0;
            this.paddingTop = 0;
            this.paddingBottom = 0;
            this.verticalGap = 0;
            this.width = 75;
            this.height = 100;
        }
        public function get mode():String{
            return (this._mode);
        }
        public function set mode(_arg1:String):void{
            if (this._mode != _arg1){
                this.selectItem.selected = false;
                this._mode = _arg1;
                switch (_arg1){
                    case SEQUENCE:
                        this.selectItem = this.sequenceItem;
                        break;
                    case RANDOM:
                        this.selectItem = this.randomItem;
                        break;
                    case LOOP:
                        this.selectItem = this.loopItem;
                        break;
                    case SINGLE:
                        this.selectItem = this.singleItem;
                        break;
                };
                this.selectItem.selected = true;
            };
        }
        public function get sequenceItem():PlayerModeListItem{
            if (!this._sequenceItem){
                this._sequenceItem = new PlayerModeListItem();
                this._sequenceItem.type = SEQUENCE;
                this._sequenceItem.addEventListener(PlayerModeListEvent.ITEM_CLICK, this.onItemClick);
                this._sequenceItem.selected = true;
                this._sequenceItem.text = "顺序播放";
                this.selectItem = this._sequenceItem;
            };
            return (this._sequenceItem);
        }
        private function onItemClick(_arg1:PlayerModeListEvent):void{
            dispatchEvent(_arg1.clone());
        }
        public function get randomItem():PlayerModeListItem{
            if (!this._randomItem){
                this._randomItem = new PlayerModeListItem();
                this._randomItem.type = RANDOM;
                this._randomItem.addEventListener(PlayerModeListEvent.ITEM_CLICK, this.onItemClick);
                this._randomItem.text = "随机播放";
            };
            return (this._randomItem);
        }
        public function get loopItem():PlayerModeListItem{
            if (!this._loopItem){
                this._loopItem = new PlayerModeListItem();
                this._loopItem.type = LOOP;
                this._loopItem.addEventListener(PlayerModeListEvent.ITEM_CLICK, this.onItemClick);
                this._loopItem.text = "列表循环";
            };
            return (this._loopItem);
        }
        public function get singleItem():PlayerModeListItem{
            if (!this._singleItem){
                this._singleItem = new PlayerModeListItem();
                this._singleItem.type = SINGLE;
                this._singleItem.addEventListener(PlayerModeListEvent.ITEM_CLICK, this.onItemClick);
                this._singleItem.text = "单个循环";
            };
            return (this._singleItem);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.sequenceItem);
            this.addChild(this.randomItem);
            this.addChild(this.loopItem);
            this.addChild(this.singleItem);
        }

    }
}//package com.bokecc.player.ui.playerlist 
