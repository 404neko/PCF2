package com.bokecc.core {
    import flash.events.*;
    import flash.display.*;
    import flash.utils.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;

    public class Application extends Container {

        private var _tooltipLayer:Component;
        private var _messageLayer:MessageLayer;
        private var _uiTooltip:UIToolTip;
        private var _controls:Dictionary;

        public function Application(){
            this.application = this;
            this.createDisplayList();
            this.layout = new CanvasLayout(this);
            if (stage){
                stage.align = StageAlign.TOP_LEFT;
                stage.scaleMode = StageScaleMode.NO_SCALE;
                stage.addEventListener(Event.RESIZE, this.stageOnResize);
                this.setSize(stage.stageWidth, stage.stageHeight);
            };
            this.addEventListener(Event.ADDED_TO_STAGE, this.childOnAddedToStage, true);
        }
        protected function get messageLayer():MessageLayer{
            if (!this._messageLayer){
                this._messageLayer = new MessageLayer();
            };
            return (this._messageLayer);
        }
        private function childOnAddedToStage(_arg1:Event):void{
            var _local2:Component;
            if ((_arg1.target is Component)){
                _local2 = Component(_arg1.target);
                if (((!((null == _local2.controlID))) && (!(("" == _local2.controlID))))){
                    this.controls[_local2.controlID] = _local2;
                };
                if (_local2.loaderInfo == this.loaderInfo){
                    _local2.application = this;
                };
            };
        }
        public function get controls():Dictionary{
            if (!this._controls){
                this._controls = new Dictionary();
            };
            return (this._controls);
        }
        protected function get uiTooltip():UIToolTip{
            if (!this._uiTooltip){
                this._uiTooltip = new UIToolTip();
            };
            return (this._uiTooltip);
        }
        private function stageOnResize(_arg1:Event):void{
            this.setSize(this.stage.stageWidth, this.stage.stageHeight);
        }
        private function get tooltipLayer():Component{
            if (!this._tooltipLayer){
                this._tooltipLayer = new Component();
            };
            return (this._tooltipLayer);
        }
        protected function createDisplayList():void{
            $$addChild(rawChildren);
            $$addChild(childList);
            $$addChild(this.messageLayer);
            $$addChild(this.tooltipLayer);
        }
        public function showTooltip(_arg1:String, _arg2:Number, _arg3:Number):void{
            if (!this.uiTooltip.parent){
                this.tooltipLayer.addChild(this.uiTooltip);
            };
            this.uiTooltip.text = _arg1;
            this.setTooltipPosition(_arg2, _arg3);
        }
        public function moveTooltip(_arg1:String, _arg2:Number, _arg3:Number):void{
            if (!this.uiTooltip.parent){
                this.tooltipLayer.addChild(this.uiTooltip);
            };
            this.uiTooltip.text = _arg1;
            this.setTooltipPosition(_arg2, _arg3);
        }
        public function hidenTooltip():void{
            if (this.uiTooltip.parent){
                this.tooltipLayer.removeChild(this.uiTooltip);
            };
        }
        private function setTooltipPosition(_arg1:Number, _arg2:Number):void{
            if (this.stage){
                if ((this.uiTooltip.width + _arg1) > this.stage.stageWidth){
                    this.uiTooltip.x = ((_arg1 - this.uiTooltip.width) - 15);
                } else {
                    this.uiTooltip.x = _arg1;
                };
                if ((this.uiTooltip.height + _arg2) > this.stage.stageHeight){
                    this.uiTooltip.y = ((_arg2 - this.uiTooltip.height) - 15);
                } else {
                    this.uiTooltip.y = _arg2;
                };
            };
        }
        public function showMessagePanel(_arg1:DisplayObject):void{
            if (!_arg1.parent){
                this.messageLayer.addChild(_arg1);
            };
        }
        public function hidenMessagePanel(_arg1:DisplayObject):void{
            if (_arg1.parent){
                this.messageLayer.removeChild(_arg1);
            };
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            this.messageLayer.setSize(this.width, this.height);
        }

    }
}//package com.bokecc.core 
