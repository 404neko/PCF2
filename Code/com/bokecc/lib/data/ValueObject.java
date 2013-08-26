package com.bokecc.lib.data {

    public class ValueObject {

        private var _value:Object;

        public function ValueObject(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._value = {};
            super();
        }
        public function set(_arg1:String, _arg2):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg2;
                _arg1;
                this._value;
            } else {
                this._value[_arg1] = _arg2;
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this._value
            */
        }
        public function get(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._value[_arg1]);
        }
        public function getValue(_arg1:String, _arg2=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.has(_arg1)){
                return (this.get(_arg1));
            };
            return (_arg2);
        }
        public function copyFromObj(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:String;
            var _local3:int;
            var _local4:* = _arg1;
            //unexpected hasnext2
            if (!!NULL!){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local2 = //unresolved nextvalue or nextname;
            if (false){
                5;
                _arg1[_local2];
                _local2;
                this;
            } else {
                this.set(_local2, _arg1[_local2]);
            };
            //unresolved if
            return;
            /*not popped
            _arg1[_local2]
            */
            /*not popped
            _local2
            */
            /*not popped
            this
            */
        }
        public function has(_arg1:String):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (!((this._value[_arg1] == null)));
        }
        public function del(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            delete this._value[_arg1];
        }

        if (37 == 34){
            return;
            /*not popped
            ValueObject
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.data 
