package com.bokecc.platform.playkernel.api.model {

    public class ListInfo extends ObjectProxy {

        private var list:Array;
        private var nodeList:Array;

        public function ListInfo(_arg1:Object=null){
            super(_arg1);
        }
        override public function init(_arg1:Object):void{
            var _local2:int;
            var _local3:int;
            var _local4:ListNodeVO;
            if (_arg1 != null){
                super.init(_arg1);
                this.nodeList = [];
                this.list = callFunction("toArray");
                _local2 = this.list.length;
                _local3 = 0;
                while (_local3 < _local2) {
                    _local4 = new ListNodeVO(this.list[_local3]);
                    this.nodeList.push(_local4);
                    _local3++;
                };
            };
        }
        public function get version():String{
            return (stringProperty("version"));
        }
        public function get uplid():String{
            return (stringProperty("uplid"));
        }
        public function get length():uint{
            return (numberProperty("length", 0));
        }
        public function getNode(_arg1:uint):ListNodeVO{
            return (this.nodeList[_arg1]);
        }
        public function toArray():Array{
            return (this.list);
        }

    }
}//package com.bokecc.platform.playkernel.api.model 
