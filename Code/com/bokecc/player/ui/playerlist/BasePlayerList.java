package com.bokecc.player.ui.playerlist {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class BasePlayerList extends Canvas {

        public static const IMAGE_STYLE:String = "imageStyle";
        public static const TEXT_STYLE:String = "textStyle";
        public static const TEXT_IMAGE_STYLE:String = "textImageStyle";

        protected var _isExpand:Boolean = true;
        protected var _playerModeList:PlayerModeList;

        public function BasePlayerList(){
            this.addEventListener(MouseEvent.MOUSE_WHEEL, this.onMouseWheel);
        }
        protected function onMouseWheel(_arg1:MouseEvent):void{
        }
        public function get playerModeList():PlayerModeList{
            if (!this._playerModeList){
                this._playerModeList = new PlayerModeList();
                this._playerModeList.addEventListener(PlayerModeListEvent.ITEM_CLICK, this.playerModeListOnItemClick);
                this._playerModeList.addEventListener(MouseEvent.ROLL_OVER, this.playerModeListOnRollOver);
                this._playerModeList.addEventListener(MouseEvent.ROLL_OUT, this.playerModeListOnRollOut);
                this._playerModeList.visible = false;
            };
            return (this._playerModeList);
        }
        public function playerModeListOnItemClick(_arg1:PlayerModeListEvent):void{
        }
        public function playerModeListOnRollOut(_arg1:MouseEvent):void{
        }
        public function playerModeListOnRollOver(_arg1:MouseEvent):void{
        }
        public function get isExpand():Boolean{
            return (this._isExpand);
        }
        public function get selectItemIndex():int{
            return (0);
        }
        public function set selectItemIndex(_arg1:int):void{
        }
        public function get selectItemRenderer():DisplayObject{
            return (null);
        }
        public function set selectItemRenderer(_arg1:DisplayObject):void{
        }
        public function set datas(_arg1:Array):void{
        }
        public function get datas():Array{
            return (null);
        }
        public function get viewStyle():String{
            return (null);
        }
        public function set viewStyle(_arg1:String):void{
        }
        public function expand():void{
        }
        public function contraction():void{
        }
        public function set playerModeListMode(_arg1:String):void{
        }
        public function get playerModeListMode():String{
            return (this.playerModeList.mode);
        }

    }
}//package com.bokecc.player.ui.playerlist 
