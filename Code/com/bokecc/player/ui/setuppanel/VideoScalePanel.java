package com.bokecc.player.ui.setuppanel {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class VideoScalePanel extends Panel {

        private var _videoScaleCanvas:VideoScaleCanvas;

        public function VideoScalePanel(){
            this.headHeight = 50;
            this.width = 288;
            this.height = 215;
            this.title = "画面比例";
            this.titleAlign = Align.CENTER;
            this.paddingTop = 30;
            this.horizontalAlign = Align.CENTER;
            this.layoutName = CanvasLayout.NAME;
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get videoScale():String{
            return (this.videoScaleCanvas.videoScale);
        }
        public function set videoScale(_arg1:String):void{
            this.videoScaleCanvas.videoScale = _arg1;
        }
        public function get videoScaleCanvas():VideoScaleCanvas{
            if (!this._videoScaleCanvas){
                this._videoScaleCanvas = new VideoScaleCanvas();
                this._videoScaleCanvas.addEventListener(VideoScaleEvent.ORIGINAL, this.videoScaleCanvasOnEvent);
                this._videoScaleCanvas.addEventListener(VideoScaleEvent.FULL, this.videoScaleCanvasOnEvent);
                this._videoScaleCanvas.addEventListener(VideoScaleEvent.SCALE_4_3, this.videoScaleCanvasOnEvent);
                this._videoScaleCanvas.addEventListener(VideoScaleEvent.SCALE_16_9, this.videoScaleCanvasOnEvent);
                this._videoScaleCanvas.addEventListener("closed", this.onClosed);
                this._videoScaleCanvas.left = 0;
                this._videoScaleCanvas.right = 0;
                this._videoScaleCanvas.top = 0;
                this._videoScaleCanvas.bottom = 0;
            };
            return (this._videoScaleCanvas);
        }
        private function onClosed(_arg1:Event):void{
            dispatchEvent(_arg1.clone());
        }
        private function videoScaleCanvasOnEvent(_arg1:VideoScaleEvent):void{
            dispatchEvent(_arg1.clone());
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.videoScaleCanvas);
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
