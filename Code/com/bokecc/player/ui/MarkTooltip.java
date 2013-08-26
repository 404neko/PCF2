package com.bokecc.player.ui {
    import flash.display.*;
    import flash.utils.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.containers.*;

    public class MarkTooltip extends Canvas {

        public static const TEXT_PADDING_TOP:Number = 3;
        public static const TEXT_PADDING_LEFT:Number = 5;
        public static const CONSORT:String = "consortSkin";
        public static const CUSTOM:String = "custom";

        private var _maxWidth:Number = 160;
        private var _maxHeight:Number = 160;
        private var _consort:SkinComponent;
        private var _consortAlign:String = "center";
        private var _textLabel:Label;

        public function get maxHeight():Number{
            return (this._maxHeight);
        }
        public function set maxHeight(_arg1:Number):void{
            if (this._maxHeight != _arg1){
                this._maxHeight = _arg1;
            };
        }
        public function get maxWidth():Number{
            return (this._maxWidth);
        }
        public function set maxWidth(_arg1:Number):void{
            if (this._maxWidth != _arg1){
                this._maxWidth = _arg1;
            };
        }
        public function get textLabel():Label{
            if (!this._textLabel){
                this._textLabel = new Label();
                this._textLabel.x = TEXT_PADDING_LEFT;
                this._textLabel.y = TEXT_PADDING_TOP;
            };
            return (this._textLabel);
        }
        override public function set y(_arg1:Number):void{
            super.y = ((_arg1 - this.consort.height) - this.height);
        }
        public function get consortAlign():String{
            return (this._consortAlign);
        }
        public function set consortAlign(_arg1:String):void{
            this._consortAlign = _arg1;
            this.updateDisplayList();
        }
        public function get consortPosition():Number{
            return (this.consort.x);
        }
        public function set consortPosition(_arg1:Number):void{
            if (CUSTOM == this._consortAlign){
                _arg1 = (_arg1 - (0.5 * this.consort.width));
                if (_arg1 < 0){
                    _arg1 = 1;
                };
                if ((_arg1 + this.consort.width) > this.width){
                    _arg1 = ((this.width - this.consort.width) - 1);
                };
                this.consort.x = _arg1;
            };
        }
        public function get text():String{
            return (this.textLabel.text);
        }
        public function set text(_arg1:String):void{
            this.textLabel.text = _arg1;
            this.updateDisplayList();
        }
        public function get textColor():uint{
            return (this.textLabel.color);
        }
        public function set textColor(_arg1:uint):void{
            this.textLabel.color = _arg1;
        }
        public function get consort():SkinComponent{
            if (!this._consort){
                this._consort = new SkinComponent();
            };
            return (this._consort);
        }
        override public function get skins():Dictionary{
            if (!_skins){
                _skins = new Dictionary();
                _skins[BACKGROUND_SKIN] = null;
                _skins[CONSORT] = null;
            };
            return (_skins);
        }
        public function set consortSkin(_arg1:DisplayObject):void{
            this.consort.currentSkin = _arg1;
            this.skins[CONSORT] = _arg1;
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.textLabel);
            this.rawChildren.addChild(this.consort);
        }
        override protected function measure():void{
            super.measure();
            this.textLabel.height = NaN;
            this.textLabel.width = NaN;
            this.textLabel.wordWrap = false;
            var _local1:Number = ((2 * TEXT_PADDING_LEFT) + this.textLabel.width);
            if (_local1 > this._maxWidth){
                _local1 = this._maxWidth;
                this.textLabel.wordWrap = true;
                this.textLabel.width = (this._maxWidth - (2 * TEXT_PADDING_LEFT));
                this.textLabel.height = NaN;
            };
            var _local2:Number = ((2 * TEXT_PADDING_TOP) + this.textLabel.height);
            if (_local2 > this._maxHeight){
                _local2 = this._maxHeight;
            };
            this._measuredWidth = _local1;
            this._measuredHeight = _local2;
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            this.consort.y = this.height;
            if (Align.CENTER == this._consortAlign){
                this.consort.x = (0.5 * (this.width - this.consort.width));
            };
        }

    }
}//package com.bokecc.player.ui 
