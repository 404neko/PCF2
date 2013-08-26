package com.bokecc.player.ui {
    import com.bokecc.core.*;
    import flash.utils.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;

    public class PotinProgressControlBar extends ProgressControlBar {

        private var _pointLayer:Component;
        private var _pointDatas:Array;
        private var _pointAlign:String = "center";
        private var _pointUIs:Dictionary;

        public function get pointUIs():Dictionary{
            return (this._pointUIs);
        }
        public function get pointAlign():String{
            return (this._pointAlign);
        }
        public function set pointAlign(_arg1:String):void{
            this._pointAlign = _arg1;
            this.updateDisplayList();
        }
        public function get pointDatas():Array{
            return (this._pointDatas);
        }
        public function set pointDatas(_arg1:Array):void{
            var _local3:VideoPointVO;
            var _local4:PointUI;
            this._pointDatas = _arg1;
            var _local2:int = (this.pointLayer.numChildren - 1);
            while (_local2 >= 0) {
                this.pointLayer.removeChildAt(_local2);
                _local2--;
            };
            this._pointUIs = new Dictionary();
            for each (_local3 in this._pointDatas) {
                _local4 = new PointUI();
                _local4.addEventListener(VideoPointEvent.POINT_ROLL_OVER, this.onPointEventHandler);
                _local4.addEventListener(VideoPointEvent.POINT_ROLL_OUT, this.onPointEventHandler);
                _local4.data = _local3;
                this.pointLayer.addChild(_local4);
                this._pointUIs[_local3] = _local4;
            };
            this.updateDisplayList();
        }
        private function onPointEventHandler(_arg1:VideoPointEvent):void{
            dispatchEvent(_arg1.clone());
        }
        public function get pointLayer():Component{
            if (!this._pointLayer){
                this._pointLayer = new Component();
            };
            return (this._pointLayer);
        }
        override protected function createChildren():void{
            this.addChild(backgroundBar);
            this.addChild(loaderBar);
            this.addChild(progressBar);
            this.addChild(this.pointLayer);
            this.addChild(controlButton);
        }
        override public function updateDisplayList():void{
            var _local1:PointUI;
            var _local2:VideoPointVO;
            super.updateDisplayList();
            for each (_local1 in this._pointUIs) {
                _local2 = _local1.data;
                _local1.x = (this.width * _local2.progress);
                if (Align.CENTER == this._pointAlign){
                    _local1.y = (0.5 * this.height);
                };
                if (Align.TOP == this._pointAlign){
                    _local1.y = 4.5;
                };
                if (Align.BOTTOM == this._pointAlign){
                    _local1.y = ((this.height - 4.5) - _local1.height);
                };
            };
        }

    }
}//package com.bokecc.player.ui 
