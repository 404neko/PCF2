package com.bokecc.player.ui.setuppanel {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class LuminancePanel extends Panel {

        private var _luminanceCanvas:LuminanceCanvas;

        public function LuminancePanel(){
            this.headHeight = 50;
            this.width = 288;
            this.height = 215;
            this.title = "亮度调节";
            this.titleAlign = Align.CENTER;
            this.horizontalAlign = Align.CENTER;
            this.layoutName = CanvasLayout.NAME;
            this.verticalGap = 10;
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get lightValue():Number{
            return (this.luminanceCanvas.lightValue);
        }
        public function set lightValue(_arg1:Number):void{
            this.luminanceCanvas.lightValue = _arg1;
        }
        public function get contrastValue():Number{
            return (this.luminanceCanvas.contrastValue);
        }
        public function set contrastValue(_arg1:Number):void{
            this.luminanceCanvas.contrastValue = _arg1;
        }
        public function get luminanceCanvas():LuminanceCanvas{
            if (!this._luminanceCanvas){
                this._luminanceCanvas = new LuminanceCanvas();
                this._luminanceCanvas.addEventListener("closed", this.onClosed);
                this._luminanceCanvas.addEventListener(LuminanceEvent.REST, this.onValueChange);
                this._luminanceCanvas.addEventListener(LuminanceEvent.LIGHT_CHANGE, this.onValueChange);
                this._luminanceCanvas.addEventListener(LuminanceEvent.CONTRAST_CHANGE, this.onValueChange);
                this._luminanceCanvas.left = 0;
                this._luminanceCanvas.right = 0;
                this._luminanceCanvas.top = 0;
                this._luminanceCanvas.bottom = 0;
            };
            return (this._luminanceCanvas);
        }
        private function onClosed(_arg1:Event):void{
            dispatchEvent(_arg1.clone());
        }
        private function onValueChange(_arg1:LuminanceEvent):void{
            dispatchEvent(_arg1.clone());
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.luminanceCanvas);
        }
        override public function get titleLabel():Label{
            if (!_titleLabel){
                _titleLabel = new Label();
                _titleLabel.fontSize = 15;
                _titleLabel.color = 0xFFFFFF;
                _titleLabel.bold = true;
                _titleLabel.left = titlePadding;
                _titleLabel.verticalCenter = 0;
            };
            return (_titleLabel);
        }

    }
}//package com.bokecc.player.ui.setuppanel 
