package com.bokecc.lib.utils {
    import flash.net.*;
    import com.bokecc.lib.data.*;

    public class RequestURL {

        protected var _url:String = "";
        protected var _pureUrl:String = "";
        protected var _paramStr:String = "";
        protected var _paramObj:Object;

        public function RequestURL(_arg1:String){
            this._paramObj = {};
            super();
            this.url = _arg1;
        }
        public static function parseParam(_arg1:String):Object{
            var _local3:Array;
            var _local4:int;
            var _local5:int;
            var _local6:Array;
            var _local2:Object = {};
            if (!isNull(_arg1)){
                _local3 = _arg1.split("&");
                _local4 = _local3.length;
                while (_local5 < _local4) {
                    _local6 = String(_local3[_local5]).split("=");
                    _local2[_local6[0]] = _local6[1];
                    _local5++;
                };
            };
            return (_local2);
        }

        public function set url(_arg1:String):void{
            if (isNull(_arg1)){
                return;
            };
            this._url = _arg1;
            var _local2:Array = this._url.split("?");
            this._pureUrl = _local2.shift();
            this._paramStr = _local2.join("&");
            this._paramObj = parseParam(this._paramStr);
        }
        public function addParam(_arg1:String, _arg2, _arg3:Boolean=true):void{
            if (isNull(_arg1)){
                return;
            };
            if (_arg3){
                _arg2 = as2_escape(_arg2);
            };
            this._paramObj[_arg1] = _arg2;
            if (this._paramStr != ""){
                this._paramStr = (this._paramStr + "&");
            };
            this._paramStr = (this._paramStr + ((_arg1 + "=") + _arg2));
            this._url = ((this._pureUrl + "?") + this._paramStr);
        }
        public function toString():String{
            return (this._url);
        }
        public function get pureUrl():String{
            return (this._pureUrl);
        }
        public function get paramStr():String{
            return (this._paramStr);
        }
        public function get paramObj():Object{
            return (this._paramObj);
        }
        public function send():void{
            sendToURL(new URLRequest(this._url));
        }

    }
}//package com.bokecc.lib.utils 
