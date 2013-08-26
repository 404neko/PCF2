package com.bokecc.lib.net.loader {
    import flash.display.*;

    public class SWFReader {

        private var _loaderInfo:LoaderInfo;
        private var classMap:Object;

        public function SWFReader(_arg1:LoaderInfo=null){
            this.loaderInfo = _arg1;
        }
        public function get loaderInfo():LoaderInfo{
            return (this._loaderInfo);
        }
        public function set loaderInfo(_arg1:LoaderInfo):void{
            this.classMap = [];
            this._loaderInfo = _arg1;
        }
        public function get content():DisplayObject{
            return (this._loaderInfo.content);
        }
        public function hasProperty(_arg1:String):Boolean{
            return (this.content.hasOwnProperty(_arg1));
        }
        public function getProperty(_arg1:String){
            var _local2:*;
            try {
                if (this.hasProperty(_arg1)){
                    _local2 = this.content[_arg1];
                };
            } catch(e:Error) {
            };
            return (_local2);
        }
        public function setProperty(_arg1:String, _arg2):void{
            if (this.hasProperty(_arg1)){
                this.content[_arg1] = _arg2;
            };
        }
        public function call(_arg1:String, ... _args){
            var _local3:Function;
            if (this.hasProperty(_arg1)){
                _local3 = (this.content[_arg1] as Function);
                if (_local3 != null){
                    return (_local3.apply(null, _args));
                };
            };
        }
        public function addEventListener(_arg1:String, _arg2:Function):void{
            this.call("addEventListener", _arg1, _arg2);
        }
        public function removeEventListener(_arg1:String, _arg2:Function):void{
            this.call("removeEventListener", _arg1, _arg2);
        }
        public function getClass(_arg1:String):Class{
            var _local2:Class;
            if (this._loaderInfo != null){
                _local2 = this.classMap[_arg1];
                if (_local2 == null){
                    try {
                        _local2 = (this._loaderInfo.applicationDomain.getDefinition(_arg1) as Class);
                        this.classMap[_arg1] = _local2;
                    } catch(e:ReferenceError) {
                    };
                };
            };
            return (_local2);
        }
        public function getDisplayObject(_arg1:String):DisplayObject{
            var _local2:Class = this.getClass(_arg1);
            if (_local2 != null){
                return (new (_local2)());
            };
            return (null);
        }
        public function getBitmap(_arg1:String, _arg2:int=0, _arg3:int=0):Bitmap{
            var _local5:BitmapData;
            var _local4:Class = this.getClass(_arg1);
            if (_local4 != null){
                _local5 = new _local4(_arg2, _arg3);
                return (new Bitmap(_local5));
            };
            return (null);
        }

    }
}//package com.bokecc.lib.net.loader 
