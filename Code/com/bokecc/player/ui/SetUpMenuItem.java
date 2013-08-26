package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class SetUpMenuItem extends Canvas {

        public static const WIDTH:Number = 64;
        public static const HEIGHT:Number = 50;
        public static const UP:String = "up";
        public static const OVER:String = "over";

        private var _labelUpColor:uint = 0xA8A8A8;
        private var _labelOverColor:uint = 0xFFFFFF;
        private var _bgUpColor:uint;
        private var _bgOverColor:uint;
        private var _showBackground:Boolean = false;
        private var _itemData:SetUpMenuItemVO;
        private var _state:String = "up";
        private var _iconLabel:Label;
        private var _icon:BaseButton;

        public function SetUpMenuItem(){
            this.mouseChildren = false;
            this.buttonMode = true;
            this.width = WIDTH;
            this.height = HEIGHT;
            this.addEventListener(MouseEvent.ROLL_OVER, this.itemOnRollOver);
            this.addEventListener(MouseEvent.ROLL_OUT, this.itemOnRollOut);
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get showBackground():Boolean{
            return (this._showBackground);
        }
        public function set showBackground(_arg1:Boolean):void{
            if (this._showBackground != _arg1){
                this._showBackground = _arg1;
                this.updateDisplayList();
            };
        }
        public function get icon():BaseButton{
            if (!this._icon){
                this._icon = new BaseButton();
                this._icon.addEventListener("skinChange", this.iconOnSkinChange);
            };
            return (this._icon);
        }
        private function iconOnSkinChange(_arg1:Event):void{
            this.updateDisplayList();
        }
        private function itemOnRollOut(_arg1:MouseEvent):void{
            this.state = UP;
        }
        private function itemOnRollOver(_arg1:MouseEvent):void{
            this.state = OVER;
        }
        public function get state():String{
            return (this._state);
        }
        public function set state(_arg1:String):void{
            this._state = _arg1;
            this.updateDisplayList();
        }
        public function get itemData():SetUpMenuItemVO{
            return (this._itemData);
        }
        public function set itemData(_arg1:SetUpMenuItemVO):void{
            if (_arg1){
                this._itemData = _arg1;
                this.icon.skinName = this._itemData.iconName;
                this.iconLabel.text = this._itemData.labelText;
                this.updateDisplayList();
            };
        }
        public function get fontSize():uint{
            return (this.iconLabel.fontSize);
        }
        public function set fontSize(_arg1:uint):void{
            this.iconLabel.fontSize = _arg1;
        }
        public function get labelUpColor():uint{
            return (this._labelUpColor);
        }
        public function set labelUpColor(_arg1:uint):void{
            this._labelUpColor = _arg1;
        }
        public function get labelOverColor():uint{
            return (this._labelOverColor);
        }
        public function set labelOverColor(_arg1:uint):void{
            this._labelOverColor = _arg1;
        }
        public function get bgUpColor():uint{
            return (this._bgUpColor);
        }
        public function set bgUpColor(_arg1:uint):void{
            this._bgUpColor = _arg1;
        }
        public function get bgOverColor():uint{
            return (this._bgOverColor);
        }
        public function set bgOverColor(_arg1:uint):void{
            this._bgOverColor = _arg1;
        }
        public function get iconLabel():Label{
            if (!this._iconLabel){
                this._iconLabel = new Label();
                this._iconLabel.fontSize = 12;
            };
            return (this._iconLabel);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.icon);
            this.addChild(this.iconLabel);
        }
        override public function updateDisplayList():void{
            var _local3:uint;
            super.updateDisplayList();
            var _local1:Graphics = this.graphics;
            _local1.clear();
            var _local2:Number = 0.8;
            if (UP == this.state){
                this.iconLabel.color = this._labelUpColor;
                this.icon.selected = false;
                _local3 = this.bgUpColor;
            };
            if (OVER == this.state){
                this.iconLabel.color = this._labelOverColor;
                this.icon.selected = true;
                _local3 = this.bgOverColor;
            };
            if (this._showBackground){
                _local1.beginFill(this.bgOverColor, _local2);
                _local1.drawRect(0, 0, this.width, this.height);
                _local1.endFill();
            };
            this.icon.x = (0.5 * (this.width - this.icon.width));
            this.icon.y = 5;
            this.iconLabel.x = (0.5 * (this.width - this.iconLabel.width));
            this.iconLabel.y = (this.icon.y + this.icon.height);
        }

    }
}//package com.bokecc.player.ui 
