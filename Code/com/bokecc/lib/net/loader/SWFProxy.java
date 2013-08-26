package com.bokecc.lib.net.loader {
    import flash.display.*;
    import flash.system.*;

    public class SWFProxy extends SWFLoader {

        private var reader:SWFReader;

        public function SWFProxy(_arg1:String=null, _arg2:ApplicationDomain=null){
            super(_arg2);
            if (_arg1){
                this.url = _arg1;
            };
        }
        override protected function onInit():void{
            this.reader = new SWFReader(info);
        }
        public function getProperty(_arg1:String){
            return (this.reader.getProperty(_arg1));
        }
        public function setProperty(_arg1:String, _arg2):void{
            this.reader.setProperty(_arg1, _arg2);
        }
        public function hasProperty(_arg1:String):Boolean{
            return (this.reader.hasProperty(_arg1));
        }
        public function call(_arg1:String, ... _args){
            return (this.reader.call.apply(null, [_arg1].concat(_args)));
        }
        public function addSWFEventListener(_arg1:String, _arg2:Function):void{
            this.reader.addEventListener(_arg1, _arg2);
        }
        public function removeSWFEventListener(_arg1:String, _arg2:Function):void{
            this.reader.removeEventListener(_arg1, _arg2);
        }
        public function getClass(_arg1:String):Class{
            return (this.reader.getClass(_arg1));
        }
        public function getDisplayObject(_arg1:String):DisplayObject{
            return (this.reader.getDisplayObject(_arg1));
        }
        public function getBitmap(_arg1:String, _arg2:int=0, _arg3:int=0):Bitmap{
            return (this.reader.getBitmap(_arg1, _arg2, _arg3));
        }

    }
}//package com.bokecc.lib.net.loader 
