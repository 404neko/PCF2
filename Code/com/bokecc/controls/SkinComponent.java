package com.bokecc.controls {
    import com.bokecc.core.*;
    import flash.display.*;

    public class SkinComponent extends LayoutComponent {

        private var _currentSkin:DisplayObject;

        public function set currentSkin(_arg1:DisplayObject):void{
            if (_arg1){
                if (((this._currentSkin) && ((this._currentSkin.parent == this)))){
                    this.removeChild(this._currentSkin);
                };
                this._currentSkin = _arg1;
                this.addChildAt(this._currentSkin, 0);
                this.updateDisplayList();
            };
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            if (this._currentSkin){
                this._currentSkin.width = this.width;
                this._currentSkin.height = this.height;
            };
        }

    }
}//package com.bokecc.controls 
