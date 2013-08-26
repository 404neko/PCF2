package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class NominateList extends VBox {

        public static const DATA_CHANGE:String = "dataChange";

        private var _datas:Array;
        private var _pageSize:int = 4;
        private var _currentPage:int = 0;
        private var _pageCount:int = 0;
        private var count:int = 0;

        public function NominateList(){
            this.horizontalAlign = Align.CENTER;
        }
        public function get pageSize():int{
            return (this._pageSize);
        }
        public function set pageSize(_arg1:int):void{
            if (this._pageSize != _arg1){
                this._pageSize = _arg1;
                this.setPageCount(this.count, this._pageSize);
            };
        }
        public function get currentPage():int{
            return (this._currentPage);
        }
        public function set currentPage(_arg1:int):void{
            var _local2:Array;
            if (_arg1 > (this.pageCount - 1)){
                _arg1 = (this.pageCount - 1);
            };
            if (_arg1 < 0){
                _arg1 = 0;
            };
            if (this._currentPage != _arg1){
                this._currentPage = _arg1;
                _local2 = this.getPageDatas(this._currentPage, this._datas, this.pageSize);
                this.setupDatas(_local2);
            };
        }
        public function get pageCount():int{
            return (this._pageCount);
        }
        public function get datas():Array{
            return (this._datas);
        }
        public function set datas(_arg1:Array):void{
            var _local2:Array;
            if (_arg1){
                this._datas = _arg1;
                this.count = this._datas.length;
                this.setPageCount(this.count, this.pageSize);
                _local2 = this.getPageDatas(this._currentPage, this._datas, this.pageSize);
                this.setupDatas(_local2);
            };
        }
        private function getPageDatas(_arg1:int, _arg2:Array, _arg3:int):Array{
            var _local4:int = (_arg1 * _arg3);
            var _local5:int = ((_arg1 * _arg3) + _arg3);
            return (_arg2.slice(_local4, _local5));
        }
        private function setPageCount(_arg1:int, _arg2:int):void{
            this._currentPage = 0;
            this._pageCount = ((_arg1 / _arg2) + Math.ceil(((_arg1 % _arg2) / _arg2)));
        }
        protected function setupDatas(_arg1:Array):void{
            var _local3:ShareVideoItemVO;
            var _local4:DisplayObject;
            var _local5:ShareVideoItem;
            var _local2:int = (this.numChildren - 1);
            while (_local2 >= 0) {
                _local4 = this.getChildAt(_local2);
                _local4.removeEventListener(MouseEvent.CLICK, this.itemOnClick);
                this.removeChildAt(_local2);
                _local2--;
            };
            for each (_local3 in _arg1) {
                _local5 = new ShareVideoItem();
                _local5.addEventListener(MouseEvent.CLICK, this.itemOnClick);
                this.addChild(_local5);
                _local5.data = _local3;
            };
            dispatchEvent(new Event(DATA_CHANGE));
        }
        protected function itemOnClick(_arg1:MouseEvent):void{
            var _local2:ShareVideoItem = ShareVideoItem(_arg1.target);
            dispatchEvent(new NominateListEvent(NominateListEvent.ITEM_CLICK, _local2.data));
        }

    }
}//package com.bokecc.player.ui 
