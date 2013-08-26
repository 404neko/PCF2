package com.bokecc.controls {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.text.*;
    import com.bokecc.events.*;

    public class Label extends LayoutComponent {

        private var _align:String = "left";
        private var _bold:Boolean = false;
        private var _color:uint = 0;
        private var _font:String = "宋体";
        private var _indent:int = 0;
        private var _italic:Boolean = false;
        private var _kerning:Boolean = false;
        private var _leading:int = 0;
        private var _leftMargin:int = 0;
        private var _letterSpacing:int = 0;
        private var _rightMargin:int = 0;
        private var _fontSize:uint = 12;
        private var _underline:Boolean = false;
        private var _textLabel:TextField;
        private var _text:String;
        private var _htmlText:String;
        private var _wordWrap:Boolean = false;

        public function Label(){
            this.mouseChildren = false;
        }
        override public function set height(_arg1:Number):void{
            this.textLabel.height = _arg1;
            super.height = _arg1;
        }
        override public function set width(_arg1:Number):void{
            this.textLabel.width = _arg1;
            super.width = _arg1;
        }
        public function get align():String{
            return (this._align);
        }
        public function set align(_arg1:String):void{
            if (this._align != _arg1){
                this._align = _arg1;
                this.refurbishTextStyle();
            };
        }
        public function get bold():Boolean{
            return (this._bold);
        }
        public function set bold(_arg1:Boolean):void{
            if (this._bold != _arg1){
                this._bold = _arg1;
                this.refurbishTextStyle();
                updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
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
        public function get font():String{
            return (this._font);
        }
        public function set font(_arg1:String):void{
            if (this._font != _arg1){
                this._font = _arg1;
                this.refurbishTextStyle();
                updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get indent():int{
            return (this._indent);
        }
        public function set indent(_arg1:int):void{
            if (this._indent != _arg1){
                this._indent = _arg1;
                this.refurbishTextStyle();
            };
        }
        public function get italic():Boolean{
            return (this._italic);
        }
        public function set italic(_arg1:Boolean):void{
            if (this._italic != _arg1){
                this._italic = _arg1;
                this.refurbishTextStyle();
            };
        }
        public function get rightMargin():int{
            return (this._rightMargin);
        }
        public function set rightMargin(_arg1:int):void{
            if (this._rightMargin != _arg1){
                this._rightMargin = _arg1;
                this.refurbishTextStyle();
            };
        }
        public function get letterSpacing():int{
            return (this._letterSpacing);
        }
        public function set letterSpacing(_arg1:int):void{
            if (this._letterSpacing != _arg1){
                this._letterSpacing = _arg1;
                this.refurbishTextStyle();
                updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get leftMargin():int{
            return (this._leftMargin);
        }
        public function set leftMargin(_arg1:int):void{
            if (this._leftMargin != _arg1){
                this._leftMargin = _arg1;
                this.refurbishTextStyle();
            };
        }
        public function get leading():int{
            return (this._leading);
        }
        public function set leading(_arg1:int):void{
            if (this._leading != _arg1){
                this._leading = _arg1;
                this.refurbishTextStyle();
                updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get kerning():Boolean{
            return (this._kerning);
        }
        public function set kerning(_arg1:Boolean):void{
            if (this._kerning != _arg1){
                this._kerning = _arg1;
                this.refurbishTextStyle();
            };
        }
        public function get underline():Boolean{
            return (this._underline);
        }
        public function set underline(_arg1:Boolean):void{
            if (this._underline != _arg1){
                this._underline = _arg1;
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
                updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get text():String{
            return (this._text);
        }
        public function set text(_arg1:String):void{
            if (this._text != _arg1){
                this._text = _arg1;
                this.textLabel.text = this._text;
                updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get htmlText():String{
            return (this._htmlText);
        }
        public function set htmlText(_arg1:String):void{
            if (this._htmlText != _arg1){
                this._htmlText = _arg1;
                this.textLabel.htmlText = this._htmlText;
                updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get wordWrap():Boolean{
            return (this._wordWrap);
        }
        public function set wordWrap(_arg1:Boolean):void{
            if (this._wordWrap != _arg1){
                this._wordWrap = _arg1;
                this.textLabel.wordWrap = this._wordWrap;
                updateDisplayList();
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        public function get background():Boolean{
            return (this.textLabel.background);
        }
        public function set background(_arg1:Boolean):void{
            this.textLabel.background = _arg1;
        }
        public function get backgroundColor():uint{
            return (this.textLabel.backgroundColor);
        }
        public function set backgroundColor(_arg1:uint):void{
            this.textLabel.backgroundColor = _arg1;
        }
        protected function get textLabel():TextField{
            if (!this._textLabel){
                this._textLabel = new TextField();
                this._textLabel.addEventListener(TextEvent.LINK, this.textLabelOnLink);
                this._textLabel.defaultTextFormat = this.getTextFormat();
                this._textLabel.autoSize = TextFieldAutoSize.LEFT;
                this._textLabel.selectable = false;
            };
            return (this._textLabel);
        }
        private function textLabelOnLink(_arg1:TextEvent):void{
            _arg1.stopImmediatePropagation();
            dispatchEvent(new CCTextEvent(CCTextEvent.LINK, _arg1.text));
        }
        private function refurbishTextStyle():void{
            this.textLabel.defaultTextFormat = this.getTextFormat();
            if (this._text){
                this.textLabel.text = this._text;
            };
            if (this._htmlText){
                this.textLabel.htmlText = this._htmlText;
            };
        }
        private function getTextFormat():TextFormat{
            var _local1:TextFormat = new TextFormat();
            _local1.align = this._align;
            _local1.bold = this._bold;
            _local1.color = this._color;
            _local1.font = this._font;
            _local1.indent = this._indent;
            _local1.italic = this._italic;
            _local1.kerning = this._kerning;
            _local1.leading = this._leading;
            _local1.leftMargin = this._leftMargin;
            _local1.letterSpacing = this._letterSpacing;
            _local1.rightMargin = this._rightMargin;
            _local1.size = this._fontSize;
            _local1.underline = this._underline;
            return (_local1);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.textLabel);
        }
        override protected function measure():void{
            super.measure();
            this._measuredWidth = this.textLabel.width;
            this._measuredHeight = this.textLabel.height;
        }

    }
}//package com.bokecc.controls 
