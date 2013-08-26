package com.bokecc.controls {
    import com.bokecc.core.*;
    import flash.display.*;
    import flash.utils.*;
    import flash.text.*;
    import flash.filters.*;

    public class UIToolTip extends Component {

        public static const BACKGROUND_SKIN:String = "background";
        public static const TEXT_PADDING_TOP:Number = 3;
        public static const TEXT_PADDING_LEFT:Number = 5;

        private var _text:String;
        private var _textLabel:TextField;
        protected var _background:DisplayObject;
        private var dropShadowFilter:DropShadowFilter;
        private var maxWidth:Number = 160;

        public function UIToolTip(){
            this.dropShadowFilter = new DropShadowFilter(1, 45, 0);
            super();
            this.filters = [this.dropShadowFilter];
        }
        public function get text():String{
            return (this._text);
        }
        public function set text(_arg1:String):void{
            if (this._text != _arg1){
                this._text = _arg1;
                this.textLabel.text = this._text;
                this.updateDisplayList();
            };
        }
        protected function get textLabel():TextField{
            var _local1:TextFormat;
            if (!this._textLabel){
                this._textLabel = new TextField();
                _local1 = new TextFormat();
                _local1.color = 0xFFFFFF;
                this._textLabel.defaultTextFormat = _local1;
                this._textLabel.autoSize = TextFieldAutoSize.LEFT;
                this._textLabel.selectable = false;
            };
            return (this._textLabel);
        }
        override public function get skins():Dictionary{
            if (!_skins){
                _skins = new Dictionary();
                _skins[BACKGROUND_SKIN] = null;
            };
            return (_skins);
        }
        public function get background():DisplayObject{
            return (this._background);
        }
        public function set background(_arg1:DisplayObject):void{
            if (this._background){
                if (this._background.parent == this){
                    this.removeChild(this._background);
                };
            };
            if (_arg1){
                this._background = _arg1;
                this.addChildAt(this._background, 0);
                this.skins[BACKGROUND_SKIN] = this._background;
                this.updateDisplayList();
            };
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.textLabel);
        }
        override protected function measure():void{
            var _local3:Number;
            super.measure();
            var _local1:Number = 0;
            var _local2:Number = 0;
            if (this.textLabel.length > 0){
                this.textLabel.width = NaN;
                this.textLabel.height = NaN;
                this.textLabel.wordWrap = false;
                _local3 = ((2 * TEXT_PADDING_LEFT) + this.textLabel.width);
                if (_local3 > this.maxWidth){
                    _local3 = this.maxWidth;
                    this.textLabel.wordWrap = true;
                    this.textLabel.width = (_local3 - (2 * TEXT_PADDING_LEFT));
                    this.textLabel.height = NaN;
                };
                _local1 = _local3;
                _local2 = ((2 * TEXT_PADDING_TOP) + this.textLabel.height);
            } else {
                _local1 = Math.max(this.background.width, this.textLabel.width);
                _local2 = Math.max(this.background.height, this.textLabel.height);
            };
            this._measuredWidth = _local1;
            this._measuredHeight = _local2;
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            this.textLabel.x = (0.5 * (this.width - this.textLabel.width));
            this.textLabel.y = (0.5 * (this.height - this.textLabel.height));
            if (this._background){
                this._background.width = this.width;
                this._background.height = this.height;
            };
        }

    }
}//package com.bokecc.controls 
