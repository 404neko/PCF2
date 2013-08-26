package com.bokecc.containers {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.containers.layout.*;

    public class HBox extends Box {

        public function HBox(){
            this.layout = new HBoxLayout(this);
        }
        override protected function measure():void{
            var _local4:DisplayObject;
            super.measure();
            var _local1:Number = paddingLeft;
            var _local2:Number = 0;
            var _local3:int;
            while (_local3 < this.numChildren) {
                _local4 = getChildAt(_local3);
                _local2 = Math.max(_local2, _local4.height);
                _local1 = (_local1 + _local4.width);
                _local1 = (_local1 + horizontalGap);
                _local3++;
            };
            _local1 = (_local1 - horizontalGap);
            _local1 = (_local1 + paddingRight);
            _local2 = (_local2 + (paddingTop + paddingBottom));
            if ((((_local2 > (paddingTop + paddingBottom))) && ((_local1 > (paddingLeft + paddingRight))))){
                if (((!((this._measuredWidth == _local1))) || (!((this._measuredHeight == _local2))))){
                    this._measuredWidth = _local1;
                    this._measuredHeight = _local2;
                    dispatchEvent(new Event(Event.RESIZE));
                    dispatchEvent(new Event(LAYOUT_CHANGE));
                };
            };
        }

    }
}//package com.bokecc.containers 
