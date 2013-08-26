package com.bokecc.platform.playkernel.model.info {
    import com.bokecc.lib.data.*;

    public class ListInfo {

        private var _uplid:String = "";
        private var _list:Array;
        private var _xml:XML;

        public function ListInfo(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._list = [];
            super();
        }
        public function clone():ListInfo{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:ListInfo = new ListInfo();
            if (false){
                5;
                this._xml;
                _local1;
            } else {
                _local1.parse(this._xml);
            };
            return (_local1);
            /*not popped
            this._xml
            */
            /*not popped
            _local1
            */
        }
        function parse(_arg1:XML):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:XML;
            var _local4:XMLList;
            var _local5:int;
            var _local6:int;
            this._xml = _arg1;
            if (!isNull(_arg1["UPLID"])){
                this._uplid = String(_arg1["UPLID"][0]);
            };
            this._list = [];
            var _local2:XMLList = _arg1["videolist"];
            if (_local2.toXMLString() != ""){
                _local3 = _local2[0];
                _local4 = _local3["video"];
                _local5 = _local4.length();
                _local6 = 0;
                if (_local6 >= _local5){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                if (false){
                    5;
                    new NodeInfo(_local4[_local6]);
                    this._list;
                } else {
                    this._list.push(new NodeInfo(_local4[_local6]));
                };
                _local6++;
                //unresolved if
            };
        }
        public function get uplid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._uplid);
        }
        public function get length():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._list.length);
        }
        public function getNode(_arg1:uint):NodeInfo{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._list[_arg1]);
        }
        public function toArray():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Array = [];
            var _local2:int = this.length;
            var _local3:int;
            if (_local3 >= _local2){
            } else {
                //unresolved jump
            };
            //unresolved jump
            if (false){
                5;
                this.getNode(_local3).toObject();
                _local1;
            } else {
                _local1.push(this.getNode(_local3).toObject());
            };
            _local3++;
            //unresolved if
            return (_local1);
            /*not popped
            this.getNode(_local3).toObject()
            */
            /*not popped
            _local1
            */
        }

        if (37 == 34){
            return;
            /*not popped
            ListInfo
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.info 
