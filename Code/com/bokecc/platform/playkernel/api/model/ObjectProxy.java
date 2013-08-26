package com.bokecc.platform.playkernel.api.model {

    public class ObjectProxy {

        private var content:Object;

        public function ObjectProxy(_arg1:Object=null){
            this.init(_arg1);
        }
        public function init(_arg1:Object):void{
            this.content = _arg1;
        }
        public function stringProperty(_arg1:String, _arg2:String=""):String{
            if (((this.content) && (this.content.hasOwnProperty(_arg1)))){
                return (this.content[_arg1]);
            };
            return (_arg2);
        }
        public function numberProperty(_arg1:String, _arg2:Number=NaN):Number{
            if (((this.content) && (this.content.hasOwnProperty(_arg1)))){
                return (this.content[_arg1]);
            };
            return (_arg2);
        }
        public function booleanProperty(_arg1:String, _arg2:Boolean=false):Boolean{
            if (((this.content) && (this.content.hasOwnProperty(_arg1)))){
                return (this.content[_arg1]);
            };
            return (_arg2);
        }
        public function objectProperty(_arg1:String, _arg2:Object=null):Object{
            if (((this.content) && (this.content.hasOwnProperty(_arg1)))){
                return (this.content[_arg1]);
            };
            return (_arg2);
        }
        public function setProperty(_arg1:String, _arg2):void{
            if (((this.content) && (this.content.hasOwnProperty(_arg1)))){
                this.content[_arg1] = _arg2;
            };
        }
        public function callFunction(_arg1:String, ... _args){
            var _local3:Function;
            if (((this.content) && (this.content.hasOwnProperty(_arg1)))){
                _local3 = this.content[_arg1];
                if (_local3 != null){
                    return (_local3.apply(null, _args));
                };
            };
            return (null);
        }

    }
}//package com.bokecc.platform.playkernel.api.model 
