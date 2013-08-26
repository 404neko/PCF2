package com.bokecc.core {
    import flash.events.*;
    import flash.display.*;
    import flash.utils.*;
    import flash.geom.*;
    import com.bokecc.containers.layout.*;

    public class Container extends LayoutComponent {

        public static const BACKGROUND_SKIN:String = "background";

        protected var _rawChildren:Component;
        protected var _childList:Component;
        protected var layout:Layout;
        protected var _background:DisplayObject;
        protected var _maskSprite:Sprite;
        private var _label:String;
        private var _clip:Boolean = true;

        public function Container(){
            this.layout = new Layout(this);
        }
        public function get clip():Boolean{
            return (this._clip);
        }
        public function set clip(_arg1:Boolean):void{
            if (this._clip != _arg1){
                this._clip = _arg1;
                if (this._clip){
                    this.rawChildren.addChild(this.maskSprite);
                    this.childList.mask = this.maskSprite;
                    this.updateDisplayList();
                } else {
                    if (this.maskSprite.parent){
                        this.rawChildren.removeChild(this.maskSprite);
                        this.childList.mask = null;
                    };
                };
            };
        }
        public function get label():String{
            return (this._label);
        }
        public function set label(_arg1:String):void{
            this._label = _arg1;
        }
        override public function get skins():Dictionary{
            if (!_skins){
                _skins = new Dictionary();
                _skins[BACKGROUND_SKIN] = null;
            };
            return (_skins);
        }
        protected function get maskSprite():Sprite{
            if (!this._maskSprite){
                this._maskSprite = new Sprite();
            };
            return (this._maskSprite);
        }
        protected function get childList():Component{
            if (!this._childList){
                this._childList = new Component();
            };
            return (this._childList);
        }
        final bokecc_internal function $$childList():Component{
            return (this.childList);
        }
        public function get background():DisplayObject{
            return (this._background);
        }
        public function set background(_arg1:DisplayObject):void{
            if (this._background){
                if (this._background.parent == this.rawChildren){
                    this.rawChildren.removeChild(this._background);
                };
            };
            if (_arg1){
                this._background = _arg1;
                this.rawChildren.addChildAt(this._background, 0);
                this.skins[BACKGROUND_SKIN] = this._background;
                this.updateDisplayList();
            };
        }
        public function get rawChildren():Component{
            if (!this._rawChildren){
                this._rawChildren = new Component();
            };
            return (this._rawChildren);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            this.childList.setSize(this.width, this.height);
            if (this._background){
                this._background.width = this.width;
                this._background.height = this.height;
            };
            var _local1:Graphics = this.maskSprite.graphics;
            _local1.clear();
            if (this._clip){
                _local1.beginFill(0xFFFFFF);
                _local1.drawRect(0, 0, this.width, this.height);
                _local1.endFill();
            };
            if (this.layout){
                this.layout.updateLayout();
            };
        }
        override protected function createChildren():void{
            super.createChildren();
            this.$$addChild(this.rawChildren);
            if (this._clip){
                this.rawChildren.addChild(this.maskSprite);
                this.childList.mask = this.maskSprite;
            };
            this.$$addChild(this.childList);
        }
        final bokecc_internal function $$addChild(_arg1:DisplayObject):DisplayObject{
            return (super.addChild(_arg1));
        }
        override public function get numChildren():int{
            return (this.childList.numChildren);
        }
        override public function addChild(_arg1:DisplayObject):DisplayObject{
            var _local2:DisplayObject = this.childList.addChild(_arg1);
            if ((_local2 is Component)){
                _local2.removeEventListener("skinChange", this.childOnSkinChange);
                _local2.addEventListener("skinChange", this.childOnSkinChange);
            };
            this.updateDisplayList();
            return (_local2);
        }
        private function childOnSkinChange(_arg1:Event):void{
            this.updateDisplayList();
        }
        override public function addChildAt(_arg1:DisplayObject, _arg2:int):DisplayObject{
            var _local3:DisplayObject = this.childList.addChildAt(_arg1, _arg2);
            if ((_local3 is Component)){
                _local3.removeEventListener("skinChange", this.childOnSkinChange);
                _local3.addEventListener("skinChange", this.childOnSkinChange);
            };
            this.updateDisplayList();
            return (_local3);
        }
        override public function removeChild(_arg1:DisplayObject):DisplayObject{
            var _local2:DisplayObject = this.childList.removeChild(_arg1);
            if ((_local2 is Component)){
                _local2.removeEventListener("skinChange", this.childOnSkinChange);
            };
            this.updateDisplayList();
            return (_local2);
        }
        override public function removeChildAt(_arg1:int):DisplayObject{
            var _local2:DisplayObject = this.childList.removeChildAt(_arg1);
            if ((_local2 is Component)){
                _local2.removeEventListener("skinChange", this.childOnSkinChange);
            };
            this.updateDisplayList();
            return (_local2);
        }
        override public function getChildAt(_arg1:int):DisplayObject{
            return (this.childList.getChildAt(_arg1));
        }
        override public function getChildByName(_arg1:String):DisplayObject{
            return (this.childList.getChildByName(_arg1));
        }
        override public function getChildIndex(_arg1:DisplayObject):int{
            return (this.childList.getChildIndex(_arg1));
        }
        override public function setChildIndex(_arg1:DisplayObject, _arg2:int):void{
            this.childList.setChildIndex(_arg1, _arg2);
        }
        override public function getObjectsUnderPoint(_arg1:Point):Array{
            return (this.childList.getObjectsUnderPoint(_arg1));
        }
        override public function contains(_arg1:DisplayObject):Boolean{
            return (this.childList.contains(_arg1));
        }

    }
}//package com.bokecc.core 
