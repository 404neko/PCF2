package com.bokecc.controls {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import flash.text.*;

    public class TextInput extends LayoutComponent {

        private var _textField:TextField;
        private var _borderColor:uint = 12040892;
        private var _backgroundColor:uint = 0xFFFFFF;
        private var _backgroundAlpha:Number = 1;
        private var _borderThickness:Number = 1;
        private var _edit:Boolean = true;
        private var _color:uint = 0;
        private var _fontSize:int = 12;
        private var _font:String = "宋体";
        private var _bold:Boolean = false;
        private var _text:String = "";
        private var _displayAsPassword:Boolean;

        public function TextInput(){
            this._width = 160;
            this._height = 21;
        }
        public function get displayAsPassword():Boolean{
            return (this.textField.displayAsPassword);
        }
        public function set displayAsPassword(_arg1:Boolean):void{
            this.textField.displayAsPassword = _arg1;
        }
        public function get bold():Boolean{
            return (this._bold);
        }
        public function set bold(_arg1:Boolean):void{
            if (this._bold != _arg1){
                this._bold = _arg1;
                this.refurbishTextStyle();
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
            };
        }
        public function get color():uint{
            return (this._color);
        }
        public function set color(_arg1:uint):void{
            if (this._color != _arg1){
                this._color = _arg1;
                this.refurbishTextStyle();
            };
        }
        private function refurbishTextStyle():void{
            this.textField.defaultTextFormat = this.getTextFormat();
            if (this._text){
                this.textField.text = this._text;
            };
        }
        public function get backgroundAlpha():Number{
            return (this._backgroundAlpha);
        }
        public function set backgroundAlpha(_arg1:Number):void{
            if (this._backgroundAlpha != _arg1){
                this._backgroundAlpha = _arg1;
                this.updateDisplayList();
            };
        }
        public function get editEnabled():Boolean{
            return (this._edit);
        }
        public function set editEnabled(_arg1:Boolean):void{
            if (this._edit != _arg1){
                this._edit = _arg1;
                if (this._edit){
                    this.textField.type = TextFieldType.INPUT;
                } else {
                    this.textField.type = TextFieldType.DYNAMIC;
                };
            };
        }
        public function get borderThickness():Number{
            return (this._borderThickness);
        }
        public function set borderThickness(_arg1:Number):void{
            if (this._borderThickness != _arg1){
                this._borderThickness = _arg1;
                this.updateDisplayList();
            };
        }
        public function get text():String{
            return (this.textField.text);
        }
        public function set text(_arg1:String):void{
            if (((!((this.textField.text == _arg1))) && (_arg1))){
                this._text = _arg1;
                this.textField.text = this._text;
            };
        }
        public function get backgroundColor():uint{
            return (this._backgroundColor);
        }
        public function set backgroundColor(_arg1:uint):void{
            if (this._backgroundColor != _arg1){
                this._backgroundColor = _arg1;
                this.updateDisplayList();
            };
        }
        public function get borderColor():uint{
            return (this._borderColor);
        }
        public function set borderColor(_arg1:uint):void{
            if (this._borderColor != _arg1){
                this._borderColor = _arg1;
                this.updateDisplayList();
            };
        }
        protected function get textField():TextField{
            if (!this._textField){
                this._textField = new TextField();
                this._textField.addEventListener(Event.CHANGE, this.textOnChange);
                this._textField.autoSize = TextFieldAutoSize.NONE;
                this._textField.multiline = false;
                this._textField.wordWrap = false;
                this._textField.selectable = true;
                this._textField.type = TextFieldType.INPUT;
                this._textField.defaultTextFormat = this.getTextFormat();
            };
            return (this._textField);
        }
        private function textOnChange(_arg1:Event):void{
            _arg1.stopImmediatePropagation();
            dispatchEvent(new Event(Event.CHANGE));
        }
        private function getTextFormat():TextFormat{
            var _local1:TextFormat = new TextFormat();
            _local1.bold = this._bold;
            _local1.size = this._fontSize;
            _local1.font = this._font;
            _local1.color = this._color;
            return (_local1);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.textField);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            this.textField.width = this.width;
            this.textField.height = this.height;
            var _local1:Graphics = this.graphics;
            _local1.clear();
            _local1.lineStyle(this._borderThickness, this._borderColor);
            _local1.beginFill(this._backgroundColor, this._backgroundAlpha);
            _local1.drawRect(0, 0, this.width, this.height);
            _local1.endFill();
        }

    }
}//package com.bokecc.controls 
