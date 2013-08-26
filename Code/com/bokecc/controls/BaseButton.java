package com.bokecc.controls {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import flash.utils.*;

    public class BaseButton extends LayoutComponent implements IDataRenderer {

        public static const UP:String = "upSkin";
        public static const SELECTED_UP:String = "selectedUPSkin";
        public static const OVER:String = "overSkin";
        public static const SELECTED_OVER:String = "selectedOverSkin";
        public static const DOWN:String = "downSkin";
        public static const SELECTED_DOWN:String = "selectedDownSkin";
        public static const DISABLED:String = "disabledSkin";
        public static const SELECTED_DISABLED:String = "selectedDisabledSkin";

        protected var _currentState:String;
        protected var _currentSkin:DisplayObject;
        private var _selected:Boolean = false;
        private var _data:Object;

        public function BaseButton(){
            this.buttonMode = true;
            this.mouseChildren = false;
            addEventListener(MouseEvent.ROLL_OVER, this.onMouseOver);
            addEventListener(MouseEvent.ROLL_OUT, this.onMouseOut);
            addEventListener(MouseEvent.MOUSE_UP, this.onMouseUp);
            addEventListener(MouseEvent.MOUSE_DOWN, this.onMouseDown);
            this.currentState = UP;
        }
        override public function get skins():Dictionary{
            if (!_skins){
                _skins = new Dictionary();
                this.skins[UP] = null;
                this.skins[OVER] = null;
                this.skins[DOWN] = null;
                this.skins[SELECTED_UP] = null;
                this.skins[SELECTED_OVER] = null;
                this.skins[SELECTED_DOWN] = null;
                this.skins[DISABLED] = null;
                this.skins[SELECTED_DISABLED] = null;
            };
            return (_skins);
        }
        protected function onMouseDown(_arg1:MouseEvent):void{
            if (this._selected){
                this.currentState = SELECTED_DOWN;
            } else {
                this.currentState = DOWN;
            };
        }
        protected function onMouseUp(_arg1:MouseEvent):void{
            if ((((((this.mouseX >= 0)) && ((this.mouseX <= this.width)))) && ((((this.mouseY >= 0)) && ((this.mouseY <= this.height)))))){
                if (this._selected){
                    this.currentState = SELECTED_OVER;
                } else {
                    this.currentState = OVER;
                };
            } else {
                if (this._selected){
                    this.currentState = SELECTED_UP;
                } else {
                    this.currentState = UP;
                };
            };
        }
        protected function onMouseOut(_arg1:MouseEvent):void{
            if (this._selected){
                this.currentState = SELECTED_UP;
            } else {
                this.currentState = UP;
            };
        }
        protected function onMouseOver(_arg1:MouseEvent):void{
            if (this._selected){
                this.currentState = SELECTED_OVER;
            } else {
                this.currentState = OVER;
            };
        }
        public function set currentState(_arg1:String):void{
            if (this._currentState != _arg1){
                this._currentState = _arg1;
                this.updateDisplayList();
            };
        }
        public function get selected():Boolean{
            return (this._selected);
        }
        public function set selected(_arg1:Boolean):void{
            if (this._selected != _arg1){
                this._selected = _arg1;
                if ((((((this.mouseX >= 0)) && ((this.mouseX <= this.width)))) && ((((this.mouseY >= 0)) && ((this.mouseY <= this.height)))))){
                    if (this._selected){
                        this.currentState = SELECTED_OVER;
                    } else {
                        this.currentState = OVER;
                    };
                } else {
                    if (this._selected){
                        this.currentState = SELECTED_UP;
                    } else {
                        this.currentState = UP;
                    };
                };
                dispatchEvent(new Event(Event.CHANGE));
            };
        }
        override public function set enabled(_arg1:Boolean):void{
            super.enabled = _arg1;
            this.mouseChildren = false;
            this.updateDisplayList();
        }
        private function set currentSkin(_arg1:DisplayObject):void{
            if (_arg1){
                if (((((this._currentSkin) && ((this._currentSkin.parent == this)))) && (!((_arg1 == this._currentSkin))))){
                    this.removeChild(this._currentSkin);
                };
                this._currentSkin = _arg1;
                this.addChildAt(this._currentSkin, 0);
            };
        }
        override public function updateDisplayList():void{
            var _local1:DisplayObject;
            super.updateDisplayList();
            for each (_local1 in this.skins) {
                this.setSkinSize(_local1);
            };
            if (enabled){
                this.currentSkin = this.skins[this._currentState];
            } else {
                if (this._selected){
                    this.currentSkin = this.skins[SELECTED_DISABLED];
                } else {
                    this.currentSkin = this.skins[DISABLED];
                };
            };
        }
        protected function setSkinSize(_arg1:DisplayObject):void{
            if (_arg1 != null){
                if (((!(isNaN(this._width))) && (!(isNaN(this._height))))){
                    _arg1.width = this.width;
                    _arg1.height = this.height;
                };
            };
        }
        public function set upSkin(_arg1:DisplayObject):void{
            this.skins[UP] = _arg1;
            if (!this.skins[SELECTED_UP]){
                this.skins[SELECTED_UP] = _arg1;
            };
            if (!this.skins[OVER]){
                this.skins[OVER] = _arg1;
            };
            if (!this.skins[SELECTED_OVER]){
                this.skins[SELECTED_OVER] = _arg1;
            };
            if (!this.skins[DOWN]){
                this.skins[DOWN] = _arg1;
            };
            if (!this.skins[SELECTED_DOWN]){
                this.skins[SELECTED_DOWN] = _arg1;
            };
            if (!this.skins[DISABLED]){
                this.skins[DISABLED] = _arg1;
            };
            if (!this.skins[SELECTED_DISABLED]){
                this.skins[SELECTED_DISABLED] = _arg1;
            };
            this.updateDisplayList();
        }
        public function set selectedUPSkin(_arg1:DisplayObject):void{
            this.skins[SELECTED_UP] = _arg1;
            if (((!(this.skins[SELECTED_OVER])) || ((this.skins[SELECTED_OVER] == this.skins[OVER])))){
                this.skins[SELECTED_OVER] = _arg1;
            };
            if (((!(this.skins[SELECTED_DOWN])) || ((this.skins[SELECTED_DOWN] == this.skins[DOWN])))){
                this.skins[SELECTED_DOWN] = _arg1;
            };
            if (!this.skins[SELECTED_DISABLED]){
                this.skins[SELECTED_DISABLED] = _arg1;
            };
            this.updateDisplayList();
        }
        public function set overSkin(_arg1:DisplayObject):void{
            this.skins[OVER] = _arg1;
            this.updateDisplayList();
        }
        public function set selectedOverSkin(_arg1:DisplayObject):void{
            this.skins[SELECTED_OVER] = _arg1;
            this.updateDisplayList();
        }
        public function set downSkin(_arg1:DisplayObject):void{
            this.skins[DOWN] = _arg1;
            this.updateDisplayList();
        }
        public function set selectedDownSkin(_arg1:DisplayObject):void{
            this.skins[SELECTED_DOWN] = _arg1;
            this.updateDisplayList();
        }
        public function set disabledSkin(_arg1:DisplayObject):void{
            this.skins[DISABLED] = _arg1;
            this.updateDisplayList();
        }
        public function set selectedDisabledSkin(_arg1:DisplayObject):void{
            this.skins[SELECTED_DISABLED] = _arg1;
            this.updateDisplayList();
        }
        public function get data():Object{
            return (this._data);
        }
        public function set data(_arg1:Object):void{
            this._data = _arg1;
        }

    }
}//package com.bokecc.controls 
