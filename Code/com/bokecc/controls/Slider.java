package com.bokecc.controls {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import flash.utils.*;
    import com.bokecc.events.*;

    public class Slider extends LayoutComponent {

        public static const TRACK:String = "trackSkin";
        public static const HIGHLIGHT:String = "highlightSkin";
        public static const THUMB_UP:String = "thumbUpSkin";
        public static const THUMB_OVER:String = "thumbOverSkin";
        public static const THUMB_DOWN:String = "thumbDownSkin";
        public static const THUMB_DISABLED:String = "thumbDisabledSkin";

        private var _vertical:Boolean = false;
        private var offset:Number;
        protected var _controlButton:BaseButton;
        private var _progressBar:SkinComponent;
        private var _backgroundBar:SkinComponent;
        private var _sliderValue:Number = 0;
        private var _progressBarMask:Shape;

        public function Slider(){
            this.buttonMode = true;
            this.addEventListener(MouseEvent.MOUSE_DOWN, this.onMouseDown);
        }
        public function get progressBarMask():Shape{
            if (!this._progressBarMask){
                this._progressBarMask = new Shape();
            };
            return (this._progressBarMask);
        }
        public function get sliderValue():Number{
            return (this._sliderValue);
        }
        public function set sliderValue(_arg1:Number):void{
            var _local2:SliderEvent;
            if (this._sliderValue != _arg1){
                this._sliderValue = _arg1;
                if (this._sliderValue < 0){
                    this._sliderValue = 0;
                };
                if (this._sliderValue > 1){
                    this._sliderValue = 1;
                };
                _local2 = new SliderEvent(SliderEvent.CHANGE);
                _local2.value = this._sliderValue;
                dispatchEvent(_local2);
                this.updateDisplayList();
            };
        }
        public function get backgroundBar():SkinComponent{
            if (!this._backgroundBar){
                this._backgroundBar = new SkinComponent();
            };
            return (this._backgroundBar);
        }
        public function get progressBar():SkinComponent{
            if (!this._progressBar){
                this._progressBar = new SkinComponent();
                this._progressBar.mask = this.progressBarMask;
                this._progressBar.addChild(this.progressBarMask);
            };
            return (this._progressBar);
        }
        public function get controlButton():BaseButton{
            if (!this._controlButton){
                this._controlButton = new BaseButton();
                this._controlButton.addEventListener(MouseEvent.CLICK, this.controlButtonOnClick);
                this._controlButton.addEventListener(SKIN_CHANGE, this.controlButtonOnSkinChangeEvent);
                this._controlButton.isSkin = false;
            };
            return (this._controlButton);
        }
        private function controlButtonOnClick(_arg1:MouseEvent):void{
            _arg1.stopPropagation();
        }
        private function controlButtonOnSkinChangeEvent(_arg1:Event):void{
            this.updateDisplayList();
        }
        public function get vertical():Boolean{
            return (this._vertical);
        }
        public function set vertical(_arg1:Boolean):void{
            this._vertical = _arg1;
            this.updateDisplayList();
        }
        private function onMouseDown(_arg1:MouseEvent):void{
            var _local2:SliderEvent;
            if (this.stage){
                if (this._vertical){
                    this.offset = (this.stage.mouseY - this.mouseY);
                    this.sliderValue = ((this.height - this.mouseY) / this.height);
                } else {
                    this.offset = (this.stage.mouseX - this.mouseX);
                    this.sliderValue = (this.mouseX / this.width);
                };
                _local2 = new SliderEvent(SliderEvent.THUMB_DRAG);
                _local2.value = this.sliderValue;
                dispatchEvent(_local2);
                this.stage.addEventListener(MouseEvent.MOUSE_MOVE, this.onStageMouseMove);
                this.stage.addEventListener(MouseEvent.MOUSE_UP, this.onMouseUp);
            };
        }
        private function onMouseUp(_arg1:MouseEvent):void{
            var _local2:SliderEvent;
            if (this.stage){
                this.stage.removeEventListener(MouseEvent.MOUSE_MOVE, this.onStageMouseMove);
                this.stage.removeEventListener(MouseEvent.MOUSE_UP, this.onMouseUp);
                _local2 = new SliderEvent(SliderEvent.THUMB_RELEASE);
                _local2.value = this.sliderValue;
                dispatchEvent(_local2);
            };
        }
        private function onStageMouseMove(_arg1:MouseEvent):void{
            var _local2:SliderEvent;
            var _local3:Number;
            var _local4:Number;
            var _local5:Number;
            var _local6:Number;
            if (this.stage){
                if (this._vertical){
                    _local3 = (0.5 * this.controlButton.height);
                    _local4 = ((this.stage.mouseY - this.offset) - _local3);
                    if (_local4 < -(_local3)){
                        _local4 = -(_local3);
                    };
                    if (_local4 > (this.height - _local3)){
                        _local4 = (this.height - _local3);
                    };
                    this.controlButton.y = _local4;
                    this.sliderValue = (((this.height - this.controlButton.y) - _local3) / this.height);
                } else {
                    _local5 = (0.5 * this.controlButton.width);
                    _local6 = ((this.stage.mouseX - this.offset) - _local5);
                    if (_local6 < -(_local5)){
                        _local6 = -(_local5);
                    };
                    if (_local6 > (this.width - _local5)){
                        _local6 = (this.width - _local5);
                    };
                    this.controlButton.x = _local6;
                    this.sliderValue = ((this.controlButton.x + _local5) / this.width);
                };
                _local2 = new SliderEvent(SliderEvent.THUMB_PRESS);
                _local2.value = this.sliderValue;
                dispatchEvent(_local2);
            };
        }
        override public function get skins():Dictionary{
            if (!_skins){
                _skins = new Dictionary();
                _skins[TRACK] = null;
                _skins[HIGHLIGHT] = null;
                _skins[THUMB_UP] = null;
                _skins[THUMB_OVER] = null;
                _skins[THUMB_DOWN] = null;
                _skins[THUMB_DISABLED] = null;
            };
            return (_skins);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.backgroundBar);
            this.addChild(this.progressBar);
            this.addChild(this.controlButton);
        }
        override public function updateDisplayList():void{
            var _local1:Number;
            var _local2:Number;
            super.updateDisplayList();
            this.controlButton.updateDisplayList();
            this.backgroundBar.width = this.width;
            this.backgroundBar.height = this.height;
            this.progressBar.width = this.width;
            this.progressBar.height = this.height;
            if (this._vertical){
                this.controlButton.x = ((this.width - this.controlButton.width) * 0.5);
                this.progressBarMask.width = this.width;
                _local1 = (this.height * this._sliderValue);
                this.controlButton.y = ((this.height - _local1) - (0.5 * this.controlButton.height));
                this.progressBarMask.height = _local1;
                this.progressBarMask.y = (this.height - this.progressBarMask.height);
            } else {
                this.controlButton.y = ((this.height - this.controlButton.height) * 0.5);
                this.progressBarMask.height = this.height;
                _local2 = (this.width * this._sliderValue);
                this.controlButton.x = (_local2 - (0.5 * this.controlButton.width));
                this.progressBarMask.width = _local2;
                this.progressBarMask.x = 0;
                this.progressBarMask.y = 0;
            };
        }
        override public function cleanSkins():void{
            super.cleanSkins();
            if (isSkin){
                this.controlButton.skins[BaseButton.UP] = null;
                this.controlButton.skins[BaseButton.OVER] = null;
                this.controlButton.skins[BaseButton.DOWN] = null;
                this.controlButton.skins[BaseButton.DISABLED] = null;
            };
        }
        public function set trackSkin(_arg1:DisplayObject):void{
            this.backgroundBar.currentSkin = _arg1;
            this.skins[TRACK] = _arg1;
            if (((isNaN(this._width)) || (isNaN(this._height)))){
                this.setSize(this.backgroundBar.width, this.backgroundBar.height);
            };
            var _local2:Graphics = this.progressBarMask.graphics;
            _local2.clear();
            _local2.beginFill(0xFFFFFF);
            _local2.drawRect(0, 0, 10, 10);
            _local2.endFill();
        }
        public function set highlightSkin(_arg1:DisplayObject):void{
            this.skins[HIGHLIGHT] = _arg1;
            this.progressBar.currentSkin = _arg1;
        }
        public function set thumbUpSkin(_arg1:DisplayObject):void{
            this.skins[THUMB_UP] = _arg1;
            this.controlButton.upSkin = _arg1;
        }
        public function set thumbOverSkin(_arg1:DisplayObject):void{
            this.skins[THUMB_OVER] = _arg1;
            this.controlButton.overSkin = _arg1;
        }
        public function set thumbDownSkin(_arg1:DisplayObject):void{
            this.skins[THUMB_DOWN] = _arg1;
            this.controlButton.downSkin = _arg1;
        }
        public function set thumbDisabledSkin(_arg1:DisplayObject):void{
            this.skins[THUMB_DISABLED] = _arg1;
            this.controlButton.disabledSkin = _arg1;
        }

    }
}//package com.bokecc.controls 
