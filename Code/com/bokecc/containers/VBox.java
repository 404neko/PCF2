package com.bokecc.containers {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.containers.layout.*;

    public class VBox extends Box {

        public function VBox(){
            this.layout = new VBoxLayout(this);
        }
        override protected function measure():void{
            var _local4:DisplayObject;
            super.measure();
            var _local1:Number = 0;
            var _local2:Number = paddingTop;
            var _local3:int;
            while (_local3 < this.numChildren) {
                _local4 = getChildAt(_local3);
                _local1 = Math.max(_local1, _local4.width);
                _local2 = (_local2 + _local4.height);
                _local2 = (_local2 + verticalGap);
                _local3++;
            };
            _local2 = (_local2 - verticalGap);
            _local2 = (_local2 + paddingBottom);
            _local1 = (_local1 + (paddingLeft + paddingRight));
            if ((((_local2 >= (paddingTop + paddingBottom))) && ((_local1 >= (paddingLeft + paddingRight))))){
                if (((!((this._measuredWidth == _local1))) || (!((this._measuredHeight == _local2))))){
                    this._measuredWidth = _local1;
                    this._measuredHeight = _local2;
                    dispatchEvent(new Event(Event.RESIZE));
                    dispatchEvent(new Event(LAYOUT_CHANGE));
                };
            };
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
        }

    }
}//package com.bokecc.containers 
