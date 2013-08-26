package com.bokecc.player.ui.playerlist {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.player.ui.*;
    import com.bokecc.player.vo.*;

    public class PlayerListTextItem extends HorizontalScrollText implements IDataRenderer {

        private var _data:PlayerListItemVO;

        public function PlayerListTextItem(){
            this.mouseChildren = false;
            this.width = 110;
            this.height = 28;
            this.textColor = 0xEFEFEF;
            this.textSelectColor = 16090679;
            this.overBGColor = 0xAAAAAA;
            this.showOverBackground = true;
            this.buttonMode = true;
        }
        public function get data():Object{
            return (this._data);
        }
        public function set data(_arg1:Object):void{
            if (_arg1){
                this._data = PlayerListItemVO(_arg1);
                this._data.addEventListener(Event.CHANGE, this.dataOnChange);
                this.text = this._data.videoName;
            };
        }
        private function dataOnChange(_arg1:Event):void{
            if (((this._data) && (this._data.select))){
                this.selected = true;
            } else {
                this.selected = false;
            };
        }

    }
}//package com.bokecc.player.ui.playerlist 
