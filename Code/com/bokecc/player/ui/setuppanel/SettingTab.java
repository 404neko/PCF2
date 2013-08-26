package com.bokecc.player.ui.setuppanel {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class SettingTab extends TabNavigator {

        protected var _videoScaleCanvas:VideoScaleCanvas;
        protected var _luminanceCanvas:LuminanceCanvas;
        protected var _articulationCanvas:ArticulationCanvas;
        private var _setUpPanelData:SetUpPanelVO;

        public function SettingTab(){
            this.tabGap = 5;
            this._tabHeight = 25;
            this._setUpPanelData = new SetUpPanelVO();
            this._setUpPanelData.addEventListener(SetUpPanelDataEvent.ARTICULATION_CHANGE, this.onArticulationChange);
            this._setUpPanelData.addEventListener(SetUpPanelDataEvent.ARTICULATION_ENABLED_CHANGE, this.onArticulationEnabledChange);
            this._setUpPanelData.addEventListener(SetUpPanelDataEvent.VIDEO_SCALE_CHANGE, this.onVideoScaleChange);
            this._setUpPanelData.addEventListener(SetUpPanelDataEvent.LIGHTVALUE_CHANGE, this.onLightValueChange);
            this._setUpPanelData.addEventListener(SetUpPanelDataEvent.CONTRASTVALUE_CHANGE, this.onContrastValueChange);
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        private function onContrastValueChange(_arg1:SetUpPanelDataEvent):void{
            this.luminanceCanvas.contrastValue = this._setUpPanelData.contrastValue;
        }
        private function onLightValueChange(_arg1:SetUpPanelDataEvent):void{
            this.luminanceCanvas.lightValue = this._setUpPanelData.lightValue;
        }
        private function onVideoScaleChange(_arg1:SetUpPanelDataEvent):void{
            this.videoScaleCanvas.videoScale = this._setUpPanelData.videoScale;
        }
        private function onArticulationEnabledChange(_arg1:SetUpPanelDataEvent):void{
            this.articulationCanvas.articulationEnabled = this._setUpPanelData.articulationEnabled;
        }
        private function onArticulationChange(_arg1:SetUpPanelDataEvent):void{
            this.articulationCanvas.articulation = this._setUpPanelData.articulation;
        }
        public function get setUpPanelData():SetUpPanelVO{
            return (this._setUpPanelData);
        }
        public function get articulationCanvas():ArticulationCanvas{
            if (!this._articulationCanvas){
                this._articulationCanvas = new ArticulationCanvas();
                this._articulationCanvas.addEventListener("closed", this.onClosed);
                this._articulationCanvas.addEventListener(ArticulationEvent.OK, this.articulationCanvasOnOk);
                this._articulationCanvas.left = 1;
                this._articulationCanvas.right = 1;
                this._articulationCanvas.top = 0;
                this._articulationCanvas.bottom = 2;
                this._articulationCanvas.label = "清晰度";
            };
            return (this._articulationCanvas);
        }
        protected function articulationCanvasOnOk(_arg1:ArticulationEvent):void{
            this.setUpPanelData.articulation = this.articulationCanvas.articulation;
            dispatchEvent(new Event("closed"));
        }
        public function get luminanceCanvas():LuminanceCanvas{
            if (!this._luminanceCanvas){
                this._luminanceCanvas = new LuminanceCanvas();
                this._luminanceCanvas.addEventListener(LuminanceEvent.LIGHT_CHANGE, this.luminanceCanvasOnChange);
                this._luminanceCanvas.addEventListener(LuminanceEvent.CONTRAST_CHANGE, this.luminanceCanvasOnChange);
                this._luminanceCanvas.addEventListener(LuminanceEvent.REST, this.luminanceCanvasOnRest);
                this._luminanceCanvas.addEventListener("closed", this.onClosed);
                this._luminanceCanvas.left = 1;
                this._luminanceCanvas.right = 1;
                this._luminanceCanvas.top = 0;
                this._luminanceCanvas.bottom = 2;
                this._luminanceCanvas.label = "亮度";
            };
            return (this._luminanceCanvas);
        }
        protected function luminanceCanvasOnRest(_arg1:LuminanceEvent):void{
            dispatchEvent(new SetUpPanelDataEvent(SetUpPanelDataEvent.LIGHTVALUE_CONTRASTVALUE_REST));
        }
        protected function luminanceCanvasOnChange(_arg1:LuminanceEvent):void{
            this.setUpPanelData.lightValue = _arg1.lightValue;
            this.setUpPanelData.contrastValue = _arg1.contrastValue;
        }
        public function get videoScaleCanvas():VideoScaleCanvas{
            if (!this._videoScaleCanvas){
                this._videoScaleCanvas = new VideoScaleCanvas();
                this._videoScaleCanvas.addEventListener("closed", this.onClosed);
                this._videoScaleCanvas.addEventListener(VideoScaleEvent.FULL, this.videoScaleOnChange);
                this._videoScaleCanvas.addEventListener(VideoScaleEvent.ORIGINAL, this.videoScaleOnChange);
                this._videoScaleCanvas.addEventListener(VideoScaleEvent.SCALE_16_9, this.videoScaleOnChange);
                this._videoScaleCanvas.addEventListener(VideoScaleEvent.SCALE_4_3, this.videoScaleOnChange);
                this._videoScaleCanvas.left = 1;
                this._videoScaleCanvas.right = 1;
                this._videoScaleCanvas.top = 0;
                this._videoScaleCanvas.bottom = 2;
                this._videoScaleCanvas.label = "画面比例";
            };
            return (this._videoScaleCanvas);
        }
        protected function videoScaleOnChange(_arg1:VideoScaleEvent):void{
            this.setUpPanelData.videoScale = _arg1.type;
        }
        protected function onClosed(_arg1:Event):void{
            this.articulationCanvas.articulation = this._setUpPanelData.articulation;
            dispatchEvent(_arg1.clone());
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.videoScaleCanvas);
            this.addChild(this.articulationCanvas);
            this.addChild(this.luminanceCanvas);
        }
        override public function get tabBox():TabBox{
            if (!_tabBox){
                _tabBox = new TabBox();
                _tabBox.paddingTop = 0;
                _tabBox.paddingLeft = 42;
                _tabBox.paddingBottom = 0;
                _tabBox.horizontalGap = this.tabGap;
            };
            return (_tabBox);
        }
        override protected function createTab(_arg1:Container):TextButton{
            var _local2:TextButton = new TextButton();
            _local2.blendMode = BlendMode.LAYER;
            _local2.width = 64;
            _local2.height = 25;
            _local2.labelColor = 0xAAAAAA;
            _local2.selectTextColor = 0xFFFFFF;
            _local2.skinName = "tabButton";
            _local2.label = _arg1.label;
            _local2.addEventListener(MouseEvent.CLICK, tabOnClick);
            return (_local2);
        }
        override public function set selectedIndex(_arg1:int):void{
            super.selectedIndex = _arg1;
            this.tabBox.updateDisplayList();
        }

    }
}//package com.bokecc.player.ui.setuppanel 
