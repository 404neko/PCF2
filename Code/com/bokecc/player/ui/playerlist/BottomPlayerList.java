package com.bokecc.player.ui.playerlist {
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.*;

    public class BottomPlayerList extends HPlayerList {

        private var _line:Shape;

        public function get line():Shape{
            if (!this._line){
                this._line = new Shape();
                this._line.y = 124;
            };
            return (this._line);
        }
        override public function get contractionButton():BaseButton{
            var _local1:BaseButton = super.contractionButton;
            _local1.skinName = "bPlayerListContractionButton";
            _local1.horizontalCenter = 0;
            _local1.top = 0;
            return (_local1);
        }
        override public function get hScrollBar():HScrollBar{
            var _local1:HScrollBar = super.hScrollBar;
            _local1.top = NaN;
            _local1.bottom = 13;
            return (_local1);
        }
        override public function get controlButtonBox():HBox{
            var _local1:HBox = super.controlButtonBox;
            _local1.top = NaN;
            _local1.bottom = 0;
            return (_local1);
        }
        override public function get viewPort():Canvas{
            var _local1:Canvas = super.viewPort;
            _local1.top = 13;
            return (_local1);
        }
        override public function get playerModeList():PlayerModeList{
            var _local1:PlayerModeList = super.playerModeList;
            _local1.bottom = 37;
            _local1.right = 2;
            return (_local1);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.line);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            var _local1:Graphics = this.line.graphics;
            _local1.clear();
            _local1.lineStyle(1, 0x676767, 0.8);
            _local1.moveTo(0, 0);
            _local1.lineTo(this.width, 0);
        }

    }
}//package com.bokecc.player.ui.playerlist 
