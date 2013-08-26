package com.bokecc.containers {
    import flash.display.*;
    import com.bokecc.controls.*;

    public class TabBox extends HBox {

        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function measureSize():void{
            var _local4:DisplayObject;
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
                };
            };
        }
        override public function updateDisplayList():void{
            var _local2:TextButton;
            var _local5:TextButton;
            var _local6:Number;
            var _local7:Number;
            super.updateDisplayList();
            var _local1:Graphics = this.graphics;
            _local1.clear();
            var _local3:int;
            while (_local3 < this.numChildren) {
                _local5 = TextButton(this.getChildAt(_local3));
                if (_local5.selected){
                    _local2 = _local5;
                };
                _local3++;
            };
            var _local4:uint = 0xA8A8A8;
            if (_local2){
                _local6 = (this.height - 1);
                _local7 = 1;
                _local1.beginFill(_local4);
                _local1.drawRect(0, _local6, _local2.x, _local7);
                _local1.endFill();
                _local1.beginFill(_local4);
                _local1.drawRect((_local2.x + _local2.width), _local6, (this.width - (_local2.x + _local2.width)), _local7);
                _local1.endFill();
            };
        }

    }
}//package com.bokecc.containers 
