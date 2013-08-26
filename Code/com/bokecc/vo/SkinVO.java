package com.bokecc.vo {
    import flash.utils.*;

    public class SkinVO {

        public static const SKINNAME_FIELD:String = "skinName";
        public static const CLASSNAME_FIELD:String = "className";
        public static const NAME_FIELD:String = "name";
        public static const SRC_FIELD:String = "src";

        public var skinName:String;
        public var className:String;
        public var skins:Dictionary;

        public function SkinVO(){
            this.skins = new Dictionary();
        }
    }
}//package com.bokecc.vo 
