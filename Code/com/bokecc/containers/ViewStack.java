package com.bokecc.containers {
    import com.bokecc.core.*;
    import flash.display.*;
    import com.bokecc.events.*;

    public class ViewStack extends Canvas {

        private var _selectedIndex:int = -1;
        private var _selectedChild:Container;

        public function ViewStack(){
            this.addEventListener(IndexChangedEvent.CHANGE, this.childIndexOnChange);
        }
        protected function childIndexOnChange(_arg1:IndexChangedEvent):void{
            if ((((-1 == this._selectedIndex)) && ((this.numChildren > 0)))){
                this.selectedIndex = 0;
            };
            if (this._selectedIndex >= (this.numChildren - 1)){
                this.selectedIndex = (this.numChildren - 1);
            };
        }
        public function get selectedChild():Container{
            return (this._selectedChild);
        }
        public function set selectedChild(_arg1:Container):void{
            var _local2:int;
            var _local3:DisplayObject;
            var _local4:IndexChangedEvent;
            if (_arg1){
                this._selectedChild = _arg1;
                _local2 = 0;
                while (_local2 < this.numChildren) {
                    _local3 = this.getChildAt(_local2);
                    if (this._selectedChild == _local3){
                        this._selectedChild.visible = true;
                        _local4 = new IndexChangedEvent(IndexChangedEvent.CHILD_INDEX_CHANGE);
                        _local4.newIndex = _local2;
                        dispatchEvent(_local4);
                    } else {
                        _local3.visible = false;
                    };
                    _local2++;
                };
            };
        }
        public function get selectedIndex():int{
            return (this._selectedIndex);
        }
        public function set selectedIndex(_arg1:int):void{
            var _local2:Container;
            if ((((-1 < _arg1)) && ((_arg1 < this.numChildren)))){
                this._selectedIndex = _arg1;
                _local2 = Container(this.getChildAt(this._selectedIndex));
                this.selectedChild = _local2;
            };
        }
        override public function addChild(_arg1:DisplayObject):DisplayObject{
            var _local2:DisplayObject = super.addChild(_arg1);
            _local2.visible = false;
            dispatchEvent(new IndexChangedEvent(IndexChangedEvent.CHANGE));
            return (_local2);
        }
        override public function addChildAt(_arg1:DisplayObject, _arg2:int):DisplayObject{
            var _local3:DisplayObject = super.addChildAt(_arg1, _arg2);
            _local3.visible = false;
            dispatchEvent(new IndexChangedEvent(IndexChangedEvent.CHANGE));
            return (_local3);
        }
        override public function removeChild(_arg1:DisplayObject):DisplayObject{
            var _local2:DisplayObject = super.removeChild(_arg1);
            dispatchEvent(new IndexChangedEvent(IndexChangedEvent.CHANGE));
            return (_local2);
        }
        override public function removeChildAt(_arg1:int):DisplayObject{
            var _local2:DisplayObject = super.removeChildAt(_arg1);
            dispatchEvent(new IndexChangedEvent(IndexChangedEvent.CHANGE));
            return (_local2);
        }

    }
}//package com.bokecc.containers 
