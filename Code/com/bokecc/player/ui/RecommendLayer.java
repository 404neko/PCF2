package com.bokecc.player.ui {
    import flash.display.*;
    import com.bokecc.containers.*;

    public class RecommendLayer extends Canvas {

        private var _recommend:DisplayObject;

        public function get recommend():DisplayObject{
            return (this._recommend);
        }
        public function set recommend(_arg1:DisplayObject):void{
            if (this._recommend){
                this.removeChild(this._recommend);
            };
            this._recommend = _arg1;
            if (this._recommend){
                this._recommend.width = this.width;
                this._recommend.height = this.height;
                this.addChild(this._recommend);
            };
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            if (this._recommend){
                this._recommend.width = this.width;
                this._recommend.height = this.height;
            };
        }

    }
}//package com.bokecc.player.ui 
