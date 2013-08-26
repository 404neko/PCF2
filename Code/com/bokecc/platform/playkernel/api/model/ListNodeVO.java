package com.bokecc.platform.playkernel.api.model {

    public class ListNodeVO {

        private var _obj:Object;
        private var _title:String;
        private var _playtime:String;
        private var _imgurl:String;

        public function ListNodeVO(_arg1:Object){
            this._obj = _arg1;
        }
        public function get videoid():String{
            return (this._obj["videoid"]);
        }
        public function get title():String{
            return (this._obj["title"]);
        }
        public function get playtime():String{
            return (this._obj["playtime"]);
        }
        public function get imgurl():String{
            return (this._obj["imgurl"]);
        }
        public function toObject():Object{
            return (this._obj);
        }

    }
}//package com.bokecc.platform.playkernel.api.model 
