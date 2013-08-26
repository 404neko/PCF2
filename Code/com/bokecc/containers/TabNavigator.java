package com.bokecc.containers {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.events.*;

    public class TabNavigator extends ViewStack {

        protected var _tabBox:TabBox;
        protected var _tabHeight:Number = 25;
        private var _tabGap:Number = 0;

        public function TabNavigator(){
            this.addEventListener(IndexChangedEvent.CHILD_INDEX_CHANGE, this.onChildIndexChange);
        }
        public function get tabGap():Number{
            return (this._tabGap);
        }
        public function set tabGap(_arg1:Number):void{
            if (this._tabGap != _arg1){
                this._tabGap = _arg1;
                this.tabBox.horizontalGap = this._tabGap;
            };
        }
        public function get tabHeight():Number{
            return (this._tabHeight);
        }
        private function onChildIndexChange(_arg1:IndexChangedEvent):void{
            this.selectTab(_arg1.newIndex);
        }
        public function get tabBox():TabBox{
            if (!this._tabBox){
                this._tabBox = new TabBox();
                this._tabBox.paddingTop = 0;
                this._tabBox.paddingLeft = 0;
                this._tabBox.paddingBottom = 0;
                this._tabBox.horizontalGap = this._tabGap;
            };
            return (this._tabBox);
        }
        override protected function childIndexOnChange(_arg1:IndexChangedEvent):void{
            var _local3:Container;
            var _local4:TextButton;
            if (this.tabBox.numChildren > 0){
                this.removeAllTab();
            };
            var _local2:int;
            while (_local2 < this.numChildren) {
                _local3 = Container(this.getChildAt(_local2));
                _local4 = this.createTab(_local3);
                this.tabBox.addChild(_local4);
                _local2++;
            };
            super.childIndexOnChange(_arg1);
            this.selectTab(this.selectedIndex);
        }
        override protected function createChildren():void{
            $$addChild(this.childList);
            rawChildren.addChild(maskSprite);
            this.mask = maskSprite;
            $$addChild(rawChildren);
            this.rawChildren.addChild(this.tabBox);
        }
        override public function updateDisplayList():void{
            if (((isNaN(this._width)) || (isNaN(this._height)))){
                measure();
            };
            this.tabBox.width = this.width;
            this.tabBox.height = this.tabHeight;
            this.tabBox.x = 0;
            this.tabBox.y = 0;
            var _local1:Number = (this.tabHeight - 1);
            this.childList.x = 0;
            this.childList.y = _local1;
            this.childList.setSize(this.width, (this.height - _local1));
            var _local2:Graphics = maskSprite.graphics;
            _local2.clear();
            _local2.beginFill(0xFFFFFF);
            _local2.drawRect(0, 0, this.width, this.height);
            _local2.endFill();
            if (layout){
                layout.updateLayout();
            };
        }
        private function removeAllTab():void{
            var _local1:int = this.tabBox.numChildren;
            var _local2:int = (_local1 - 1);
            while (_local2 >= 0) {
                this.tabBox.removeChildAt(_local2);
                _local2--;
            };
        }
        private function selectTab(_arg1:int):void{
            var _local3:TextButton;
            var _local2:int;
            while (_local2 < this.tabBox.numChildren) {
                _local3 = TextButton(this.tabBox.getChildAt(_local2));
                if (_local3){
                    if (_arg1 == _local2){
                        _local3.selected = true;
                    } else {
                        _local3.selected = false;
                    };
                };
                _local2++;
            };
        }
        protected function createTab(_arg1:Container):TextButton{
            var _local2:TextButton = new TextButton();
            _local2.skinName = "tabButton";
            _local2.label = _arg1.label;
            _local2.addEventListener(MouseEvent.CLICK, this.tabOnClick);
            return (_local2);
        }
        protected function tabOnClick(_arg1:MouseEvent):void{
            var _local2:TextButton = TextButton(_arg1.target);
            var _local3:int = this.tabBox.getChildIndex(_local2);
            selectedIndex = _local3;
        }
        override protected function get childList():Component{
            if (!_childList){
                _childList = new Container();
            };
            return (_childList);
        }
        override public function set background(_arg1:DisplayObject):void{
            Container(this.childList).background = _arg1;
        }

    }
}//package com.bokecc.containers 
