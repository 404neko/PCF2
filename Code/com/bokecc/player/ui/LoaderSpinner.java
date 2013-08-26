package com.bokecc.player.ui {
    import flash.events.*;
    import flash.utils.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.*;
    import flash.filters.*;

    public class LoaderSpinner extends Canvas {

        private var _backgroundCanvas:Canvas;
        private var _progessLabel:Label;
        private var _spinnerCanvas:Canvas;
        private var _timer:Timer;
        private var _delay:Number = 250;
        private var _angle:Number = 30;
        private var _showTextShadow:Boolean = true;
        private var _textShadowColor:uint = 0;
        private var dropShadowFilter:DropShadowFilter;

        public function LoaderSpinner(){
            this.dropShadowFilter = new DropShadowFilter(1, 45, this._textShadowColor);
            super();
            this.clip = false;
        }
        public function get textShadowColor():uint{
            return (this._textShadowColor);
        }
        public function set textShadowColor(_arg1:uint):void{
            if (this._textShadowColor != _arg1){
                this._textShadowColor = _arg1;
                this.dropShadowFilter.color = this._textShadowColor;
                if (this._showTextShadow){
                    this.progessLabel.filters = [this.dropShadowFilter];
                };
            };
        }
        public function get showTextShadow():Boolean{
            return (this._showTextShadow);
        }
        public function set showTextShadow(_arg1:Boolean):void{
            if (this._showTextShadow != _arg1){
                this._showTextShadow = _arg1;
                if (this._showTextShadow){
                    this.progessLabel.filters = [this.dropShadowFilter];
                } else {
                    this.progessLabel.filters = [];
                };
            };
        }
        public function start():void{
            this.timer.start();
        }
        public function stop():void{
            this.timer.stop();
        }
        public function get angle():Number{
            return (this._angle);
        }
        public function set angle(_arg1:Number):void{
            if (this._angle != _arg1){
                this._angle = _arg1;
            };
        }
        public function get delay():Number{
            return (this.timer.delay);
        }
        public function set delay(_arg1:Number):void{
            this.timer.delay = _arg1;
        }
        private function get timer():Timer{
            if (!this._timer){
                this._timer = new Timer(this._delay);
                this._timer.addEventListener(TimerEvent.TIMER, this.onTimer);
            };
            return (this._timer);
        }
        private function onTimer(_arg1:TimerEvent):void{
            this.spinnerCanvas.rotation = (this.spinnerCanvas.rotation + this.angle);
        }
        public function get text():String{
            return (this.progessLabel.text);
        }
        public function set text(_arg1:String):void{
            this.progessLabel.text = _arg1;
        }
        public function get spinnerCanvas():Canvas{
            if (!this._spinnerCanvas){
                this._spinnerCanvas = new Canvas();
                this._spinnerCanvas.clip = false;
                this._spinnerCanvas.skinName = "loaderSpinner_spinner";
                this._spinnerCanvas.controlID = "loaderSpinner_spinner";
            };
            return (this._spinnerCanvas);
        }
        public function get progessLabel():Label{
            if (!this._progessLabel){
                this._progessLabel = new Label();
                this._progessLabel.filters = [this.dropShadowFilter];
                this._progessLabel.text = " ";
                this._progessLabel.controlID = "loaderSpinner_label";
            };
            return (this._progessLabel);
        }
        public function get backgroundCanvas():Canvas{
            if (!this._backgroundCanvas){
                this._backgroundCanvas = new Canvas();
                this._backgroundCanvas.clip = false;
                this._backgroundCanvas.skinName = "loaderSpinner_background";
                this._backgroundCanvas.controlID = "loaderSpinner_background";
            };
            return (this._backgroundCanvas);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.backgroundCanvas);
            this.addChild(this.spinnerCanvas);
            this.addChild(this.progessLabel);
        }

    }
}//package com.bokecc.player.ui 
