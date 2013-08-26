package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import flash.filters.*;

    public class PointUI extends Sprite {

        private var _data:VideoPointVO;
        private var _glowFilter:GlowFilter;

        public function PointUI(){
            this.addEventListener(MouseEvent.MOUSE_OVER, this.onRollOver);
            this.addEventListener(MouseEvent.MOUSE_OUT, this.onRollOut);
            this.addEventListener(MouseEvent.MOUSE_MOVE, this.onMouseMove);
            this.drawCircle();
        }
        private function onMouseMove(_arg1:MouseEvent):void{
            _arg1.stopImmediatePropagation();
        }
        public function get data():VideoPointVO{
            return (this._data);
        }
        public function set data(_arg1:VideoPointVO):void{
            this._data = _arg1;
        }
        public function get glowFilter():GlowFilter{
            if (!this._glowFilter){
                this._glowFilter = new GlowFilter(0xFFFFFF);
            };
            return (this._glowFilter);
        }
        private function onRollOut(_arg1:MouseEvent):void{
            _arg1.stopImmediatePropagation();
            this.filters = [];
            dispatchEvent(new VideoPointEvent(VideoPointEvent.POINT_ROLL_OUT, this));
        }
        private function onRollOver(_arg1:MouseEvent):void{
            _arg1.stopImmediatePropagation();
            this.filters = [this.glowFilter];
            dispatchEvent(new VideoPointEvent(VideoPointEvent.POINT_ROLL_OVER, this));
        }
        private function drawCircle():void{
            var _local1:Graphics = this.graphics;
            _local1.clear();
            _local1.beginFill(0x333333);
            _local1.drawCircle(0, 0, 3.5);
            _local1.beginFill(0xFFFFFF);
            _local1.drawCircle(0, 0, 3);
            _local1.endFill();
        }

    }
}//package com.bokecc.player.ui 
