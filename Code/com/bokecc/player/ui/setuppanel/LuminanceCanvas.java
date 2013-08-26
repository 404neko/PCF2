package com.bokecc.player.ui.setuppanel {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.events.*;
    import com.bokecc.containers.*;

    public class LuminanceCanvas extends Canvas {

        private var _lightLabel:Label;
        private var _lightSlider:Slider;
        private var _contrastLabel:Label;
        private var _contrastSlider:Slider;
        private var _okButton:TextButton;
        private var _restButton:Label;
        private var _lightBox:HBox;
        private var _contrastBox:HBox;

        public function get lightValue():Number{
            return (this.lightSlider.sliderValue);
        }
        public function set lightValue(_arg1:Number):void{
            this.lightSlider.sliderValue = _arg1;
        }
        public function get contrastValue():Number{
            return (this.contrastSlider.sliderValue);
        }
        public function set contrastValue(_arg1:Number):void{
            this.contrastSlider.sliderValue = _arg1;
        }
        public function get contrastBox():HBox{
            if (!this._contrastBox){
                this._contrastBox = new HBox();
                this._contrastBox.paddingLeft = 10;
                this._contrastBox.paddingRight = 10;
                this._contrastBox.verticalAlign = Align.CENTER;
                this._contrastBox.horizontalCenter = 0;
                this._contrastBox.addChild(this.contrastLabel);
                this._contrastBox.addChild(this.contrastSlider);
            };
            return (this._contrastBox);
        }
        public function get lightBox():HBox{
            if (!this._lightBox){
                this._lightBox = new HBox();
                this._lightBox.paddingLeft = 10;
                this._lightBox.paddingRight = 10;
                this._lightBox.verticalAlign = Align.CENTER;
                this._lightBox.horizontalCenter = 0;
                this._lightBox.addChild(this.lightLabel);
                this._lightBox.addChild(this.lightSlider);
            };
            return (this._lightBox);
        }
        public function get restButton():Label{
            if (!this._restButton){
                this._restButton = new Label();
                this._restButton.buttonMode = true;
                this._restButton.color = 0xFFFFFF;
                this._restButton.bottom = 50;
                this._restButton.right = 14;
                this._restButton.underline = true;
                this._restButton.addEventListener(MouseEvent.CLICK, this.restButtonOnClick);
                this._restButton.text = "恢复默认";
            };
            return (this._restButton);
        }
        private function restButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new LuminanceEvent(LuminanceEvent.REST, this.lightSlider.sliderValue, this.contrastSlider.sliderValue));
        }
        public function get okButton():TextButton{
            if (!this._okButton){
                this._okButton = new TextButton();
                this._okButton.horizontalCenter = 0;
                this._okButton.bottom = 15;
                this._okButton.hPadding = 10;
                this._okButton.vPadding = 0;
                this._okButton.addEventListener(MouseEvent.CLICK, this.okButtonOnClick);
                this._okButton.label = "关闭";
            };
            return (this._okButton);
        }
        private function okButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new Event("closed"));
        }
        public function get lightLabel():Label{
            if (!this._lightLabel){
                this._lightLabel = new Label();
                this._lightLabel.color = 0xFFFFFF;
                this._lightLabel.text = "亮  度:";
                this._lightLabel.setSize(43, 19);
            };
            return (this._lightLabel);
        }
        public function get contrastLabel():Label{
            if (!this._contrastLabel){
                this._contrastLabel = new Label();
                this._contrastLabel.color = 0xFFFFFF;
                this._contrastLabel.text = "对比度:";
                this._contrastLabel.setSize(43, 19);
            };
            return (this._contrastLabel);
        }
        public function get lightSlider():Slider{
            if (!this._lightSlider){
                this._lightSlider = new Slider();
                this._lightSlider.skinName = "lightSliderSkin";
                this._lightSlider.addEventListener(SliderEvent.CHANGE, this.lightSliderOnChange);
                this._lightSlider.width = 200;
                this._lightSlider.height = 5;
            };
            return (this._lightSlider);
        }
        private function lightSliderOnChange(_arg1:SliderEvent):void{
            dispatchEvent(new LuminanceEvent(LuminanceEvent.LIGHT_CHANGE, this.lightSlider.sliderValue, this.contrastSlider.sliderValue));
        }
        public function get contrastSlider():Slider{
            if (!this._contrastSlider){
                this._contrastSlider = new Slider();
                this._contrastSlider.skinName = "contrastSliderSkin";
                this._contrastSlider.addEventListener(SliderEvent.CHANGE, this.contrastSliderOnChange);
                this._contrastSlider.width = 200;
                this._contrastSlider.height = 5;
            };
            return (this._contrastSlider);
        }
        private function contrastSliderOnChange(_arg1:SliderEvent):void{
            dispatchEvent(new LuminanceEvent(LuminanceEvent.CONTRAST_CHANGE, this.lightSlider.sliderValue, this.contrastSlider.sliderValue));
        }
        override protected function createChildren():void{
            super.createChildren();
            var _local1:VBox = new VBox();
            _local1.verticalGap = 10;
            _local1.horizontalAlign = Align.CENTER;
            _local1.horizontalCenter = 0;
            _local1.verticalCenter = -30;
            _local1.addChild(this.lightBox);
            _local1.addChild(this.contrastBox);
            this.addChild(_local1);
            this.addChild(this.restButton);
            this.addChild(this.okButton);
        }

    }
}//package com.bokecc.player.ui.setuppanel 
