package com.bokecc.player.ui {
    import flash.events.*;
    import flash.utils.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class SetUpMenu extends VBox {

        protected var _labelUpColor:uint = 0xA8A8A8;
        protected var _labelOverColor:uint = 0xFFFFFF;
        protected var _bgUpColor:uint;
        protected var _bgOverColor:uint;
        protected var _fontSize:uint = 12;
        protected var data:Dictionary;
        private var _dataProvider:Array;
        protected var _showBackground:Boolean = false;

        public function SetUpMenu(){
            this.verticalGap = 0;
            this.paddingLeft = 1;
            this.paddingRight = 1;
            this.paddingTop = 5;
            this.paddingBottom = 1;
            this.horizontalAlign = Align.CENTER;
            this.data = new Dictionary();
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
            this._showBackground = _arg1;
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
        public function get fontSize():uint{
            return (this._fontSize);
        }
        public function set fontSize(_arg1:uint):void{
            this._fontSize = _arg1;
        }
        public function get dataProvider():Array{
            return (this._dataProvider);
        }
        public function set dataProvider(_arg1:Array):void{
            var _local2:SetUpMenuItemVO;
            if (_arg1){
                this.removeAllItem();
                this._dataProvider = _arg1;
                for each (_local2 in this._dataProvider) {
                    this.addItem(_local2);
                };
            };
        }
        public function addItem(_arg1:SetUpMenuItemVO):void{
            var _local2:SetUpMenuItem;
            if (_arg1){
                _local2 = new SetUpMenuItem();
                _local2.fontSize = this._fontSize;
                _local2.labelUpColor = this._labelUpColor;
                _local2.labelOverColor = this._labelOverColor;
                _local2.bgUpColor = this._bgUpColor;
                _local2.bgOverColor = this._bgOverColor;
                _local2.showBackground = this._showBackground;
                _local2.itemData = _arg1;
                _local2.addEventListener(MouseEvent.CLICK, this.itemOnClick);
                this.addChild(_local2);
                this.data[_arg1] = _local2;
            };
        }
        public function removeItem(_arg1:SetUpMenuItemVO):void{
            var _local2:SetUpMenuItem = this.data[_arg1];
            if (((_local2) && (_local2.parent))){
                this.removeChild(_local2);
                delete this.data[_arg1];
                _local2.removeEventListener(MouseEvent.CLICK, this.itemOnClick);
            };
        }
        public function removeAllItem():void{
            var _local1:Object;
            for (_local1 in this.data) {
                this.removeItem(SetUpMenuItemVO(_local1));
            };
            this.data = new Dictionary();
        }
        protected function itemOnClick(_arg1:MouseEvent):void{
            var _local2:SetUpMenuItem = SetUpMenuItem(_arg1.target);
            dispatchEvent(new SetUpMenuEvent(SetUpMenuEvent.ITEM_CLICK, _local2.itemData));
        }

    }
}//package com.bokecc.player.ui 
