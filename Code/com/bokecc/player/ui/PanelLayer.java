package com.bokecc.player.ui {
    import flash.display.*;
    import com.bokecc.containers.*;

    public class PanelLayer extends Canvas {

        private var _showBackground:Boolean = false;

        public function get showBackground():Boolean{
            return (this._showBackground);
        }
        public function set showBackground(_arg1:Boolean):void{
            if (this._showBackground != _arg1){
                this._showBackground = _arg1;
                this.updateDisplayList();
            };
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            var _local1:Graphics = this.graphics;
            _local1.clear();
            if (this._showBackground){
                _local1.beginFill(0);
                _local1.drawRect(0, 0, this.width, this.height);
                _local1.endFill();
            };
        }

    }
}//package com.bokecc.player.ui 
