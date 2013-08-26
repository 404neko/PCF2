package com.bokecc.player.ui.setuppanel {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class ArticulationPanel extends Panel {

        private var _articulationCanvas:ArticulationCanvas;

        public function ArticulationPanel(){
            this.headHeight = 50;
            this.width = 288;
            this.height = 215;
            this.title = "清晰度";
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
        public function get articulation():String{
            return (this.articulationCanvas.articulation);
        }
        public function set articulation(_arg1:String):void{
            this.articulationCanvas.articulation = _arg1;
        }
        public function get articulationCanvas():ArticulationCanvas{
            if (!this._articulationCanvas){
                this._articulationCanvas = new ArticulationCanvas();
                this._articulationCanvas.addEventListener(ArticulationEvent.OK, this.articulationCanvasOnOk);
                this._articulationCanvas.addEventListener("closed", this.onClosed);
                this._articulationCanvas.left = 0;
                this._articulationCanvas.right = 0;
                this._articulationCanvas.top = 0;
                this._articulationCanvas.bottom = 0;
            };
            return (this._articulationCanvas);
        }
        private function onClosed(_arg1:Event):void{
            dispatchEvent(_arg1.clone());
        }
        private function articulationCanvasOnOk(_arg1:Event):void{
            dispatchEvent(_arg1.clone());
            dispatchEvent(new Event(CLOSED_EVENT));
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.articulationCanvas);
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
