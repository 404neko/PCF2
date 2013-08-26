package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import flash.utils.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.*;

    public class HorizontalScrollText extends Canvas {

        private var _textLabel:Label;
        private var mouseOver:Boolean = false;
        private var _selected:Boolean = false;
        private var _timer:Timer;
        private var _textColor:uint = 0xEFEFEF;
        private var _overTextColor:uint = 16090679;
        private var _textSelectColor:uint = 16090679;
        private var _bgColor:uint = 0xEFEFEF;
        private var _overBGColor:uint = 0xAAAAAA;
        private var _selectBGColor:uint = 0xAAAAAA;
        private var _showBackground:Boolean = false;
        private var _showOverBackground:Boolean = false;
        private var _showSelectBackground:Boolean = false;
        private var _startDelay:Number = 1000;
        private var _overScroll:Boolean = true;
        private var _showBorder:Boolean = false;
        private var _borderWidth:Number = 1;
        private var _borderColor:uint = 0;
        private var _backgroundAlpha:Number = 0.7;
        private var moveDirection:Boolean = true;

        public function HorizontalScrollText(){
            this.addEventListener(MouseEvent.ROLL_OVER, this.itemOnRollOver);
            this.addEventListener(MouseEvent.ROLL_OUT, this.itemOnRollOut);
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
        public function get borderColor():uint{
            return (this._borderColor);
        }
        public function set borderColor(_arg1:uint):void{
            if (this._borderColor != _arg1){
                this._borderColor = _arg1;
                this.updateDisplayList();
            };
        }
        public function get borderWidth():Number{
            return (this._borderWidth);
        }
        public function set borderWidth(_arg1:Number):void{
            if (this._borderWidth != _arg1){
                this._borderWidth = _arg1;
                this.updateDisplayList();
            };
        }
        public function get showBorder():Boolean{
            return (this._showBorder);
        }
        public function set showBorder(_arg1:Boolean):void{
            if (this._showBorder != _arg1){
                this._showBorder = _arg1;
                this.updateDisplayList();
            };
        }
        public function get overScroll():Boolean{
            return (this._overScroll);
        }
        public function set overScroll(_arg1:Boolean):void{
            if (this._overScroll != _arg1){
                this._overScroll = _arg1;
            };
        }
        public function get startDelay():Number{
            return (this._startDelay);
        }
        public function set startDelay(_arg1:Number):void{
            if (this._startDelay != _arg1){
                this._startDelay = _arg1;
            };
        }
        public function get showSelectBackground():Boolean{
            return (this._showSelectBackground);
        }
        public function set showSelectBackground(_arg1:Boolean):void{
            if (this._showSelectBackground != _arg1){
                this._showSelectBackground = _arg1;
                this.updateDisplayList();
            };
        }
        public function get showOverBackground():Boolean{
            return (this._showOverBackground);
        }
        public function set showOverBackground(_arg1:Boolean):void{
            if (this._showOverBackground != _arg1){
                this._showOverBackground = _arg1;
                this.updateDisplayList();
            };
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
        public function get selectBGColor():uint{
            return (this._selectBGColor);
        }
        public function set selectBGColor(_arg1:uint):void{
            if (this._selectBGColor != _arg1){
                this._selectBGColor = _arg1;
                this.updateDisplayList();
            };
        }
        public function get overBGColor():uint{
            return (this._overBGColor);
        }
        public function set overBGColor(_arg1:uint):void{
            if (this._overBGColor != _arg1){
                this._overBGColor = _arg1;
                this.updateDisplayList();
            };
        }
        public function get bgColor():uint{
            return (this._bgColor);
        }
        public function set bgColor(_arg1:uint):void{
            if (this._bgColor != _arg1){
                this._bgColor = _arg1;
                this.updateDisplayList();
            };
        }
        public function get textSelectColor():uint{
            return (this._textSelectColor);
        }
        public function set textSelectColor(_arg1:uint):void{
            if (this._textSelectColor != _arg1){
                this._textSelectColor = _arg1;
                this.updateDisplayList();
            };
        }
        public function get overTextColor():uint{
            return (this._overTextColor);
        }
        public function set overTextColor(_arg1:uint):void{
            if (this._overTextColor != _arg1){
                this._overTextColor = _arg1;
                this.updateDisplayList();
            };
        }
        public function get textColor():uint{
            return (this._textColor);
        }
        public function set textColor(_arg1:uint):void{
            if (this._textColor != _arg1){
                this._textColor = _arg1;
                this.updateDisplayList();
            };
        }
        public function get selected():Boolean{
            return (this._selected);
        }
        public function set selected(_arg1:Boolean):void{
            if (this._selected != _arg1){
                this._selected = _arg1;
            };
            this.updateDisplayList();
        }
        public function get text():String{
            return (this.textLabel.text);
        }
        public function set text(_arg1:String):void{
            this.textLabel.text = _arg1;
        }
        public function get textLabel():Label{
            if (!this._textLabel){
                this._textLabel = new Label();
                this._textLabel.verticalCenter = 0;
                this._textLabel.color = this._textColor;
            };
            return (this._textLabel);
        }
        protected function get timer():Timer{
            if (!this._timer){
                this._timer = new Timer(this._startDelay);
                this._timer.addEventListener(TimerEvent.TIMER, this.onTimer);
            };
            return (this._timer);
        }
        private function onTimer(_arg1:TimerEvent):void{
            this.timer.delay = 50;
            if (this.textLabel.width > this.width){
                if (this.moveDirection){
                    this.textLabel.x = (this.textLabel.x - 2);
                } else {
                    this.textLabel.x = (this.textLabel.x + 2);
                };
                if (this.textLabel.x >= 0){
                    this.moveDirection = true;
                };
                if ((this.textLabel.width + this.textLabel.x) <= this.width){
                    this.moveDirection = false;
                };
            };
        }
        private function itemOnRollOut(_arg1:MouseEvent):void{
            this.mouseOver = false;
            this.updateDisplayList();
            if (this._overScroll){
                this.stopScroll();
            };
        }
        private function itemOnRollOver(_arg1:MouseEvent):void{
            this.mouseOver = true;
            this.updateDisplayList();
            if (this._overScroll){
                this.startScroll();
            };
        }
        public function startScroll():void{
            this.timer.delay = this._startDelay;
            if (this.textLabel.width > this.width){
                this.timer.start();
            };
        }
        public function stopScroll():void{
            if (this.timer.running){
                this.timer.stop();
                this.textLabel.x = 0;
            };
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.textLabel);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            var _local1:Graphics = this.graphics;
            _local1.clear();
            if (this._showBorder){
                _local1.lineStyle(this._borderWidth, this._borderColor, this._backgroundAlpha);
            };
            if (this.mouseOver){
                if (this._showOverBackground){
                    _local1.beginFill(this._overBGColor, this._backgroundAlpha);
                };
                this.textLabel.color = this._overTextColor;
            } else {
                if (this._showBackground){
                    _local1.beginFill(this._bgColor, this._backgroundAlpha);
                };
                this.textLabel.color = this._textColor;
            };
            if (this._selected){
                this.textLabel.color = this._textSelectColor;
                if (this._showSelectBackground){
                    _local1.beginFill(this._selectBGColor, this._backgroundAlpha);
                };
            } else {
                if (this._showBackground){
                    _local1.beginFill(this._bgColor, this._backgroundAlpha);
                };
                this.textLabel.color = this._textColor;
            };
            _local1.drawRect(0, 0, this.width, this.height);
            _local1.endFill();
        }

    }
}//package com.bokecc.player.ui 
