package com.bokecc.controls {
    import flash.events.*;
    import flash.display.*;
    import flash.text.*;

    public class TextButton extends BaseButton {

        private var _label:String;
        private var _labelText:TextField;
        private var _vPadding:Number = 1;
        private var _hPadding:Number = 7;
        private var _textColor:uint = 0;
        private var _selectTextColor:uint = 0;
        private var _fontSize:int = 12;
        private var _font:String = "宋体";
        private var _bold:Boolean = false;

        public function get selectTextColor():uint{
            return (this._selectTextColor);
        }
        public function set selectTextColor(_arg1:uint):void{
            if (this._selectTextColor != _arg1){
                this._selectTextColor = _arg1;
            };
        }
        public function get bold():Boolean{
            return (this._bold);
        }
        public function set bold(_arg1:Boolean):void{
            if (this._bold != _arg1){
                this._bold = _arg1;
                this.refurbishTextStyle();
                this.updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get font():String{
            return (this._font);
        }
        public function set font(_arg1:String):void{
            if (this._font != _arg1){
                this._font = _arg1;
                this.refurbishTextStyle();
                this.updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get labelColor():uint{
            return (this._textColor);
        }
        public function set labelColor(_arg1:uint):void{
            if (this._textColor != _arg1){
                this._textColor = _arg1;
                this.refurbishTextStyle();
            };
        }
        public function get fontSize():int{
            return (this._fontSize);
        }
        public function set fontSize(_arg1:int):void{
            if (this._fontSize != _arg1){
                this._fontSize = _arg1;
                this.refurbishTextStyle();
                this.updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get hPadding():Number{
            return (this._hPadding);
        }
        public function set hPadding(_arg1:Number):void{
            if (this._hPadding != _arg1){
                this._hPadding = _arg1;
                this._measuredWidth = (this.labelText.width + (2 * this.hPadding));
                this._measuredHeight = (this.labelText.height + (2 * this.vPadding));
                this.updateDisplayList();
            };
        }
        public function get vPadding():Number{
            return (this._vPadding);
        }
        public function set vPadding(_arg1:Number):void{
            if (this._vPadding != _arg1){
                this._vPadding = _arg1;
                this._measuredWidth = (this.labelText.width + (2 * this.hPadding));
                this._measuredHeight = (this.labelText.height + (2 * this.vPadding));
            };
        }
        public function get label():String{
            return (this._label);
        }
        public function set label(_arg1:String):void{
            if (this._label != _arg1){
                this._label = _arg1;
                this.labelText.text = this._label;
                this._measuredWidth = (this.labelText.width + (2 * this.hPadding));
                this._measuredHeight = (this.labelText.height + (2 * this.vPadding));
                this.updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        protected function get labelText():TextField{
            if (!this._labelText){
                this._labelText = new TextField();
                this._labelText.autoSize = TextFieldAutoSize.LEFT;
                this._labelText.defaultTextFormat = this.getTextFormat();
                this._labelText.selectable = false;
            };
            return (this._labelText);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.labelText);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            if (this.label){
                this.labelText.x = (0.5 * (this.width - this.labelText.width));
                this.labelText.y = (0.5 * (this.height - this.labelText.height));
            };
            var _local1:TextFormat = this.getTextFormat();
            if (this.selected){
                _local1.color = this._selectTextColor;
            } else {
                _local1.color = this._textColor;
            };
            this.labelText.defaultTextFormat = _local1;
            if (this._label){
                this.labelText.text = this._label;
            };
        }
        private function refurbishTextStyle():void{
            this.labelText.defaultTextFormat = this.getTextFormat();
            if (this._label){
                this.labelText.text = this._label;
            };
        }
        private function getTextFormat():TextFormat{
            var _local1:TextFormat = new TextFormat();
            _local1.bold = this._bold;
            _local1.size = this._fontSize;
            _local1.font = this._font;
            _local1.color = this._textColor;
            return (_local1);
        }
        override protected function setSkinSize(_arg1:DisplayObject):void{
            if (_arg1 != null){
                if (this.label){
                    _arg1.width = this.width;
                    _arg1.height = this.height;
                } else {
                    if (((!(isNaN(this._width))) && (!(isNaN(this._height))))){
                        _arg1.width = this.width;
                        _arg1.height = this.height;
                    };
                };
            };
        }

    }
}//package com.bokecc.controls 
