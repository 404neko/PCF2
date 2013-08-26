package com.bokecc.core {
    import flash.events.*;
    import flash.display.*;
    import flash.utils.*;
    import flash.geom.*;
    import com.bokecc.vo.*;
    import com.bokecc.containers.layout.*;

    public class Component extends Sprite {

        public static const SKIN_CHANGE:String = "skinChange";
        public static const INIT_LAYOUT_COMPLETE:String = "initLayoutComplete";

        protected var _height:Number = NaN;
        protected var _width:Number = NaN;
        protected var _measuredWidth:Number = NaN;
        protected var _measuredHeight:Number = NaN;
        protected var oldScaleX:Number = 1;
        protected var _scaleX:Number = 1;
        protected var oldScaleY:Number = 1;
        protected var _scaleY:Number = 1;
        private var _application:Application;
        protected var skinManager:SkinManager;
        private var _controlID:String;
        private var _tooltip:String;
        protected var _skins:Dictionary;
        private var _skinName:String;
        protected var _enabled:Boolean = true;
        private var _initialized:Boolean = false;
        private var _isSkin:Boolean = true;

        public function Component(){
            this.skinManager = SkinManager.getInstance();
            this.skinManager.addEventListener(SkinManager.SKIN_CHANGE, this.skinManagerOnSkinChange);
            this.skinManager.addEventListener(SkinManager.LAYOUT_CHANGE, this.skinManagerOnLayoutChange);
            this.addEventListener(MouseEvent.ROLL_OVER, this.showTooltipHandler);
            this.addEventListener(MouseEvent.MOUSE_MOVE, this.tooltipMoveHandler);
            this.addEventListener(MouseEvent.MOUSE_OUT, this.hidenTooltipHandler);
            this.initSkins();
        }
        public function get isSkin():Boolean{
            return (this._isSkin);
        }
        public function set isSkin(_arg1:Boolean):void{
            this._isSkin = _arg1;
        }
        protected function hidenTooltipHandler(_arg1:MouseEvent):void{
            if (this.application){
                this.application.hidenTooltip();
            };
        }
        protected function tooltipMoveHandler(_arg1:MouseEvent):void{
            if (((!((null == this._tooltip))) && (!(("" == this._tooltip))))){
                if (((this.application) && (this.stage))){
                    this.application.moveTooltip(this._tooltip, (stage.mouseX + 10), (stage.mouseY + 10));
                };
            };
        }
        protected function showTooltipHandler(_arg1:MouseEvent):void{
            if (((!((null == this._tooltip))) && (!(("" == this._tooltip))))){
                if (((this.application) && (this.stage))){
                    this.application.showTooltip(this._tooltip, (stage.mouseX + 10), (stage.mouseY + 10));
                };
            };
        }
        public function get initialized():Boolean{
            return (this._initialized);
        }
        public function get enabled():Boolean{
            return (this._enabled);
        }
        public function set enabled(_arg1:Boolean):void{
            if (this._enabled != _arg1){
                this._enabled = _arg1;
                this.mouseEnabled = this._enabled;
                this.mouseChildren = this._enabled;
            };
        }
        public function get tooltip():String{
            return (this._tooltip);
        }
        public function set tooltip(_arg1:String):void{
            this._tooltip = _arg1;
        }
        override public function set x(_arg1:Number):void{
            if (super.x != _arg1){
                super.x = _arg1;
                dispatchEvent(new Event("move"));
            };
        }
        override public function set y(_arg1:Number):void{
            if (super.y != _arg1){
                super.y = _arg1;
                dispatchEvent(new Event("move"));
            };
        }
        override public function get height():Number{
            if (isNaN(this._height)){
                return (this.measuredHeight);
            };
            return (this._height);
        }
        override public function set height(_arg1:Number):void{
            if (this.height != _arg1){
                this.setSize(this.width, _arg1);
            };
        }
        override public function get width():Number{
            if (isNaN(this._width)){
                return (this.measuredWidth);
            };
            return (this._width);
        }
        override public function set width(_arg1:Number):void{
            if (this.width != _arg1){
                this.setSize(_arg1, this.height);
            };
        }
        public function get measuredWidth():Number{
            if (isNaN(this._measuredWidth)){
                return (super.width);
            };
            return (this._measuredWidth);
        }
        public function set measuredWidth(_arg1:Number):void{
            if (this._measuredWidth != _arg1){
                this._measuredWidth = _arg1;
            };
        }
        public function get measuredHeight():Number{
            if (isNaN(this._measuredHeight)){
                return (super.height);
            };
            return (this._measuredHeight);
        }
        public function set measuredHeight(_arg1:Number):void{
            if (this._measuredHeight != _arg1){
                this._measuredHeight = _arg1;
            };
        }
        override public function set scaleX(_arg1:Number):void{
            var _local2:Number;
            if (this._scaleX != _arg1){
                this._scaleX = _arg1;
                _local2 = Math.abs((this._scaleX / this.oldScaleX));
                this._width = (this._width * _local2);
                super.scaleX = (this.oldScaleX = this._scaleX);
            };
        }
        override public function set scaleY(_arg1:Number):void{
            var _local2:Number;
            if (this._scaleY != _arg1){
                this._scaleY = _arg1;
                _local2 = Math.abs((this._scaleY / this.oldScaleY));
                this._height = (this._height * _local2);
                super.scaleY = (this.oldScaleY = this._scaleY);
            };
        }
        public function get application():Application{
            return (this._application);
        }
        public function set application(_arg1:Application):void{
            this._application = _arg1;
        }
        public function get skinName():String{
            return (this._skinName);
        }
        final bokecc_internal function $addChild(_arg1:DisplayObject):DisplayObject{
            return (super.addChild(_arg1));
        }
        final bokecc_internal function $addChildAt(_arg1:DisplayObject, _arg2:int):DisplayObject{
            return (super.addChildAt(_arg1, _arg2));
        }
        override public function addChild(_arg1:DisplayObject):DisplayObject{
            if (_arg1){
                this.$addChild(_arg1);
                this.childAdded(_arg1);
            };
            return (_arg1);
        }
        override public function addChildAt(_arg1:DisplayObject, _arg2:int):DisplayObject{
            this.$addChildAt(_arg1, _arg2);
            this.childAdded(_arg1);
            return (_arg1);
        }
        private function childAdded(_arg1:DisplayObject):void{
            if ((_arg1 is Component)){
                if (!Component(_arg1).initialized){
                    Component(_arg1).initialize();
                };
            };
        }
        public function initialize():void{
            if (this.initialized){
                return;
            };
            this.createChildren();
            this.childrenCreated();
            this.initializationComplete();
        }
        protected function createChildren():void{
        }
        protected function childrenCreated():void{
            this.updateDisplayList();
        }
        private function initializationComplete():void{
            this._initialized = true;
        }
        public function set skinName(_arg1:String):void{
            var _local2:SkinVO;
            if (this._skinName != _arg1){
                this._skinName = _arg1;
                if (((!((null == this._skinName))) && (!(("" == this._skinName))))){
                    _local2 = this.skinManager.skinNameBySkin(this._skinName);
                    if (_local2){
                        this.cleanSkins();
                        this.initSkins();
                    };
                };
            };
        }
        protected function skinManagerOnLayoutChange(_arg1:Event):void{
            this.restLayout();
            this.initLayout();
        }
        protected function skinManagerOnSkinChange(_arg1:Event):void{
            this.cleanSkins();
            this.initSkins();
        }
        public function get skins():Dictionary{
            if (!this._skins){
                this._skins = new Dictionary();
            };
            return (this._skins);
        }
        public function get controlID():String{
            return (this._controlID);
        }
        public function set controlID(_arg1:String):void{
            if (this._controlID != _arg1){
                this._controlID = _arg1;
                this.initLayout();
            };
        }
        public function get className():String{
            return (this.getUnqualifiedClassName(this));
        }
        protected function restLayout():void{
            var _local1:ComponentVO;
            var _local2:ILayoutClient;
            if (((!((null == this.controlID))) && (!(("" == this.controlID))))){
                _local1 = this.skinManager.controlIdByComponentVO(this.controlID);
                if (_local1){
                    if ((this is ILayoutClient)){
                        _local2 = ILayoutClient(this);
                        _local2.left = NaN;
                        _local2.right = NaN;
                        _local2.top = NaN;
                        _local2.bottom = NaN;
                        _local2.horizontalCenter = NaN;
                        _local2.verticalCenter = NaN;
                        _local2.percentWidth = NaN;
                        _local2.percentHeight = NaN;
                        this.height = NaN;
                        this.width = NaN;
                    };
                };
            };
        }
        protected function initLayout():void{
            var _local1:ComponentVO;
            var _local2:String;
            if (((!((null == this.controlID))) && (!(("" == this.controlID))))){
                _local1 = this.skinManager.controlIdByComponentVO(this.controlID);
                if (_local1){
                    for (_local2 in _local1.property) {
                        if (this.hasOwnProperty(_local2)){
                            this[_local2] = _local1.property[_local2];
                        };
                    };
                    if (!isNaN(_local1.height)){
                        this.height = _local1.height;
                    };
                    if (!isNaN(_local1.width)){
                        this.width = _local1.width;
                    };
                    if ((this is ILayoutClient)){
                        if (!isNaN(_local1.left)){
                            this[ComponentVO.LEFT_FIELD] = _local1.left;
                        };
                        if (!isNaN(_local1.right)){
                            this[ComponentVO.RIGHT_FIELD] = _local1.right;
                        };
                        if (!isNaN(_local1.top)){
                            this[ComponentVO.TOP_FIELD] = _local1.top;
                        };
                        if (!isNaN(_local1.bottom)){
                            this[ComponentVO.BOTTOM_FIELD] = _local1.bottom;
                        };
                        if (!isNaN(_local1.horizontalCenter)){
                            this[ComponentVO.HORIZONTAL_CENTER_FIELD] = _local1.horizontalCenter;
                        };
                        if (!isNaN(_local1.verticalCenter)){
                            this[ComponentVO.VERTICAL_CENTER_FIELD] = _local1.verticalCenter;
                        };
                        if (!isNaN(_local1.percentWidth)){
                            this[ComponentVO.PERCENT_WIDTH_FIELD] = _local1.percentWidth;
                        };
                        if (!isNaN(_local1.percentHeight)){
                            this[ComponentVO.PERCENT_HEIGHT_FIELD] = _local1.percentHeight;
                        };
                    };
                    dispatchEvent(new Event(INIT_LAYOUT_COMPLETE));
                };
            };
        }
        protected function initSkins():void{
            var _local1:SkinVO;
            var _local2:String;
            if (this._isSkin){
                if (((!((null == this.skinName))) && (!(("" == this.skinName))))){
                    _local1 = this.skinManager.skinNameBySkin(this.skinName);
                } else {
                    _local1 = this.skinManager.classNameBySkin(this.className);
                };
                if (_local1){
                    for (_local2 in _local1.skins) {
                        if (_local1.skins[_local2]){
                            this[_local2] = FlashAssets(_local1.skins[_local2]).getSkinInstance();
                        };
                    };
                };
            };
            dispatchEvent(new Event(SKIN_CHANGE));
        }
        public function cleanSkins():void{
            var _local1:String;
            var _local2:DisplayObject;
            if (this._isSkin){
                for (_local1 in this.skins) {
                    if (this.skins[_local1]){
                        _local2 = this.skins[_local1];
                        if (_local2.parent){
                            _local2.parent.removeChild(_local2);
                        };
                        this.skins[_local1] = null;
                    };
                };
            };
        }
        public function setSize(_arg1:Number, _arg2:Number):void{
            this._width = _arg1;
            this._height = _arg2;
            this.updateDisplayList();
            dispatchEvent(new Event(Event.RESIZE));
        }
        public function updateDisplayList():void{
            if (((isNaN(this._width)) || (isNaN(this._height)))){
                this.measure();
            } else {
                this.positivUpdateDisplayList();
            };
        }
        protected function positivUpdateDisplayList():void{
        }
        protected function measure():void{
        }
        public function getCenter():Point{
            return (new Point((0.5 * this.width), (0.5 * this.height)));
        }
        public function getUnqualifiedClassName(_arg1:Object):String{
            var _local2:String;
            if ((_arg1 is String)){
                _local2 = (_arg1 as String);
            } else {
                _local2 = getQualifiedClassName(_arg1);
            };
            var _local3:int = _local2.indexOf("::");
            if (_local3 != -1){
                _local2 = _local2.substr((_local3 + 2));
            };
            return (_local2);
        }

    }
}//package com.bokecc.core 
