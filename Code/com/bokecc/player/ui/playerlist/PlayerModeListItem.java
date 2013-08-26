package com.bokecc.player.ui.playerlist {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class PlayerModeListItem extends HBox {

        private var _itemIcon:BaseButton;
        private var _labelView:Label;
        private var _selected:Boolean = false;
        private var bgColor:uint = 0;
        private var overBGColor:uint = 0x2C2C2C;
        private var textColor:uint = 0xAAAAAA;
        private var selectedTextColor:uint = 16744234;
        private var mouseOver:Boolean = false;
        private var _text:String;
        private var _type:String;

        public function PlayerModeListItem(){
            this.width = 75;
            this.height = 25;
            this.mouseChildren = false;
            this.verticalAlign = Align.CENTER;
            this.horizontalGap = 0;
            this.paddingLeft = 5;
            this.addEventListener(MouseEvent.ROLL_OVER, this.onRollOver);
            this.addEventListener(MouseEvent.ROLL_OUT, this.onRollOut);
            this.addEventListener(MouseEvent.CLICK, this.itemOnClick);
        }
        public function get type():String{
            return (this._type);
        }
        public function set type(_arg1:String):void{
            this._type = _arg1;
        }
        private function itemOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new PlayerModeListEvent(PlayerModeListEvent.ITEM_CLICK, this.type));
        }
        public function get text():String{
            return (this.labelView.text);
        }
        public function set text(_arg1:String):void{
            this.labelView.text = _arg1;
        }
        private function onRollOut(_arg1:MouseEvent):void{
            this.mouseOver = false;
            this.updateDisplayList();
        }
        private function onRollOver(_arg1:MouseEvent):void{
            this.mouseOver = true;
            this.updateDisplayList();
        }
        public function get labelView():Label{
            if (!this._labelView){
                this._labelView = new Label();
                this._labelView.color = this.textColor;
            };
            return (this._labelView);
        }
        public function get itemIcon():BaseButton{
            if (!this._itemIcon){
                this._itemIcon = new BaseButton();
                this._itemIcon.width = 10;
                this._itemIcon.height = 10;
                this._itemIcon.skinName = "PlayerModeListItemIcon";
                this._itemIcon.selected;
            };
            return (this._itemIcon);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.itemIcon);
            this.addChild(this.labelView);
        }
        public function get selected():Boolean{
            return (this._selected);
        }
        public function set selected(_arg1:Boolean):void{
            if (this._selected != _arg1){
                this._selected = _arg1;
                this.updateDisplayList();
            };
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            var _local1:Graphics = this.graphics;
            _local1.clear();
            if (this.mouseOver){
                _local1.beginFill(this.overBGColor);
            } else {
                _local1.beginFill(this.bgColor);
            };
            if (this._selected){
                this.labelView.color = this.selectedTextColor;
                this.itemIcon.visible = true;
            } else {
                this.labelView.color = this.textColor;
                this.itemIcon.visible = false;
            };
            _local1.drawRect(0, 0, this.width, this.height);
            _local1.endFill();
        }

    }
}//package com.bokecc.player.ui.playerlist 
