package com.bokecc.containers {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;

    public class Panel extends Box {

        public static const CLOSED_EVENT:String = "closed";

        private var _layoutName:String = "CanvasLayout";
        protected var _closedButton:BaseButton;
        protected var _head:Canvas;
        protected var _headHeight:Number = 20;
        protected var _titleLabel:Label;
        private var _title:String;
        private var _titlePadding:Number = 10;
        private var _showClose:Boolean = true;
        private var _titleAlign:String = "left";

        public function Panel(){
            this.layout = new CanvasLayout(Container(this.childList));
        }
        public function get titleAlign():String{
            return (this._titleAlign);
        }
        public function set titleAlign(_arg1:String):void{
            if (this._titleAlign != _arg1){
                this._titleAlign = _arg1;
                this.updateDisplayList();
            };
        }
        public function get showClose():Boolean{
            return (this._showClose);
        }
        public function set showClose(_arg1:Boolean):void{
            if (this._showClose != _arg1){
                this._showClose = _arg1;
                this.closedButton.visible = this._showClose;
            };
        }
        public function get titlePadding():Number{
            return (this._titlePadding);
        }
        public function set titlePadding(_arg1:Number):void{
            if (this._titlePadding != _arg1){
                this._titlePadding = _arg1;
                this.titleLabel.left = this._titlePadding;
            };
        }
        public function get title():String{
            return (this._title);
        }
        public function set title(_arg1:String):void{
            if (this._title != _arg1){
                this._title = _arg1;
                this.titleLabel.text = this._title;
                this.head.updateDisplayList();
            };
        }
        public function get titleLabel():Label{
            if (!this._titleLabel){
                this._titleLabel = new Label();
                this._titleLabel.left = this._titlePadding;
                this._titleLabel.verticalCenter = 0;
            };
            return (this._titleLabel);
        }
        public function get headHeight():Number{
            return (this._headHeight);
        }
        public function set headHeight(_arg1:Number):void{
            if (this._headHeight != _arg1){
                this._headHeight = _arg1;
                this.updateDisplayList();
            };
        }
        public function get head():Canvas{
            if (!this._head){
                this._head = new Canvas();
                this._head.skinName = "panelHead";
                this._head.height = this._headHeight;
            };
            return (this._head);
        }
        public function get closedButton():BaseButton{
            if (!this._closedButton){
                this._closedButton = new BaseButton();
                this._closedButton.addEventListener(SKIN_CHANGE, this.closedButtonOnSkinChangeEvent);
                this._closedButton.skinName = "panelClosedButton";
                this._closedButton.addEventListener(MouseEvent.CLICK, this.closeButtonOnClick);
                this._closedButton.top = 10;
                this._closedButton.right = 10;
            };
            return (this._closedButton);
        }
        private function closedButtonOnSkinChangeEvent(_arg1:Event):void{
            this.head.updateDisplayList();
        }
        private function closeButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new Event(CLOSED_EVENT));
        }
        public function get layoutName():String{
            return (this._layoutName);
        }
        public function set layoutName(_arg1:String):void{
            if (this._layoutName != _arg1){
                this._layoutName = _arg1;
                switch (this._layoutName){
                    case CanvasLayout.NAME:
                        this.layout = new CanvasLayout(Container(this.childList));
                        this.updateDisplayList();
                        break;
                    case VBoxLayout.NAME:
                        this.layout = new VBoxLayout(Container(this.childList));
                        this.updateDisplayList();
                        break;
                    case HBoxLayout.NAME:
                        this.layout = new HBoxLayout(Container(this.childList));
                        this.updateDisplayList();
                        break;
                    default:
                        this._layoutName = this.layout.name;
                };
            };
        }
        override protected function get childList():Component{
            if (!_childList){
                _childList = new Box();
            };
            return (_childList);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.rawChildren.x = 0;
            this.rawChildren.y = 0;
            this.head.addChild(this.closedButton);
            this.head.addChild(this.titleLabel);
            this.rawChildren.addChild(this.head);
        }
        override public function updateDisplayList():void{
            if (((isNaN(this._width)) || (isNaN(this._height)))){
                measure();
            };
            if (Align.LEFT == this._titleAlign){
                this.titleLabel.right = NaN;
                this.titleLabel.left = this._titlePadding;
            } else {
                if (Align.CENTER == this._titleAlign){
                    this.titleLabel.horizontalCenter = 0;
                } else {
                    if (Align.RIGHT == this._titleAlign){
                        this.titleLabel.left = NaN;
                        this.titleLabel.right = this._titlePadding;
                    };
                };
            };
            this.head.x = 0;
            this.head.y = 0;
            this.head.width = this.width;
            this.head.height = this._headHeight;
            this.childList.y = this.head.height;
            this.childList.setSize(this.width, (this.height - this.childList.y));
            if (_background){
                _background.width = this.width;
                _background.height = this.height;
            };
            var _local1:Graphics = maskSprite.graphics;
            _local1.clear();
            _local1.beginFill(0xFFFFFF);
            _local1.drawRect(0, 0, this.width, this.height);
            _local1.endFill();
            if (layout){
                layout.updateLayout();
            };
        }
        override public function get horizontalAlign():String{
            return (Box(this.childList).horizontalAlign);
        }
        override public function set horizontalAlign(_arg1:String):void{
            Box(this.childList).horizontalAlign = _arg1;
        }
        override public function get horizontalGap():Number{
            return (Box(this.childList).horizontalGap);
        }
        override public function set horizontalGap(_arg1:Number):void{
            Box(this.childList).horizontalGap = _arg1;
        }
        override public function get paddingBottom():Number{
            return (Box(this.childList).paddingBottom);
        }
        override public function set paddingBottom(_arg1:Number):void{
            Box(this.childList).paddingBottom = _arg1;
        }
        override public function get paddingLeft():Number{
            return (Box(this.childList).paddingLeft);
        }
        override public function set paddingLeft(_arg1:Number):void{
            Box(this.childList).paddingLeft = _arg1;
        }
        override public function get paddingRight():Number{
            return (Box(this.childList).paddingRight);
        }
        override public function set paddingRight(_arg1:Number):void{
            Box(this.childList).paddingRight = _arg1;
        }
        override public function get paddingTop():Number{
            return (Box(this.childList).paddingTop);
        }
        override public function set paddingTop(_arg1:Number):void{
            Box(this.childList).paddingTop = _arg1;
        }
        override public function get verticalAlign():String{
            return (Box(this.childList).verticalAlign);
        }
        override public function set verticalAlign(_arg1:String):void{
            Box(this.childList).verticalAlign = _arg1;
        }
        override public function get verticalGap():Number{
            return (Box(this.childList).verticalGap);
        }
        override public function set verticalGap(_arg1:Number):void{
            Box(this.childList).verticalGap = _arg1;
        }

    }
}//package com.bokecc.containers 
