package com.bokecc.player.ui {
    import flash.display.*;
    import com.bokecc.containers.*;

    public class VideoDisplayArea extends Canvas {

        private var _displayer:DisplayObject;

        public function get displayer():DisplayObject{
            return (this._displayer);
        }
        public function set displayer(_arg1:DisplayObject):void{
            if (this._displayer){
                this.removeChild(this._displayer);
            };
            this._displayer = _arg1;
            if (this._displayer){
                this._displayer.width = this.width;
                this._displayer.height = this.height;
                this.addChild(this._displayer);
            };
        }
        override protected function createChildren():void{
            super.createChildren();
            if (!this._displayer){
                this._displayer = new DefaultDisplayer();
                this.addChild(this._displayer);
            };
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            if (this._displayer){
                this._displayer.width = this.width;
                this._displayer.height = this.height;
            };
        }

    }
}//package com.bokecc.player.ui 
