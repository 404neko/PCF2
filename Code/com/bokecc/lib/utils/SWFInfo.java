package com.bokecc.lib.utils {
    import flash.display.*;
    import com.bokecc.lib.data.*;
    import flash.external.*;

    public class SWFInfo {

        public static var RefererJSCode:Array = ["window.location.href.toString"];

        private var _flashvars:Object;
        private var _root:DisplayObjectContainer;
        private var _url:URL;
        private var _referer:URL;
        private var _jsable:Boolean;

        public function SWFInfo(_arg1:DisplayObjectContainer){
            var _local2:LoaderInfo;
            this._flashvars = {};
            super();
            this._root = _arg1;
            if (this._root){
                _local2 = this._root.loaderInfo;
                this._url = new URL(_local2.url);
                this.readParam(_local2.parameters);
            };
            this.getReferer();
        }
        public function get root():DisplayObjectContainer{
            return (this._root);
        }
        public function stringVar(_arg1:String, _arg2:String=""):String{
            var _local3:String = this._flashvars[_arg1];
            if (isNull(_local3)){
                _local3 = _arg2;
            };
            return (_local3);
        }
        public function booleanVar(_arg1:String, _arg2:Boolean=false):Boolean{
            return (toBoolean(this._flashvars[_arg1], _arg2));
        }
        public function numberVar(_arg1:String, _arg2:Number=NaN):Number{
            return (toNumber(this._flashvars[_arg1], _arg2));
        }
        public function get flashvars():Object{
            return (this._flashvars);
        }
        public function get url():URL{
            return (this._url);
        }
        public function get referer():URL{
            return (this._referer);
        }
        public function get jsable():Boolean{
            return (this._jsable);
        }
        public function getReferer():void{
            var href:* = null;
            try {
                href = ExternalInterface.call.apply(null, RefererJSCode);
            } catch(e:Error) {
                href = "";
            };
            this._jsable = !((href == ""));
            this._referer = new URL(href);
        }
        public function getFlashVars(_arg1:DisplayObjectContainer):void{
            if (_arg1){
                this.readParam(_arg1.loaderInfo.parameters);
            };
        }
        public function readParam(_arg1:Object, _arg2:Boolean=false):void{
            var _local3:String;
            if (_arg1 != null){
                if (_arg2){
                    this._flashvars = {};
                };
                for (_local3 in _arg1) {
                    this._flashvars[_local3.toLowerCase()] = _arg1[_local3];
                };
            };
        }

    }
}//package com.bokecc.lib.utils 
