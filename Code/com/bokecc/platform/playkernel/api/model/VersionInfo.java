package com.bokecc.platform.playkernel.api.model {

    public class VersionInfo extends ObjectProxy {

        private var _xml:XML;
        private var versions:Array;

        public function VersionInfo(_arg1:Object=null){
            this.versions = [];
            super(_arg1);
        }
        public function get playKernelVersion():String{
            return (stringProperty("playKernelVersion"));
        }
        public function get adsVersion():String{
            return (stringProperty("adsVersion"));
        }
        public function get playerViewVersion():String{
            return (stringProperty("playerViewVersion"));
        }
        public function get playerViewName():String{
            return (stringProperty("playerViewName"));
        }

    }
}//package com.bokecc.platform.playkernel.api.model 
