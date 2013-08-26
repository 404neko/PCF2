package com.bokecc.platform.playkernel.model.info {

    public class VersionInfo {

        private var _xml:XML;
        private var versions:Array;

        public function VersionInfo(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.versions = [];
            super();
        }
        function parse(_arg1:XML):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:XMLList;
            var _local4:int;
            var _local5:int;
            var _local6:ModuleVersion;
            this._xml = _arg1;
            var _local2:XMLList = _arg1["playerversion"];
            if (_local2.toXMLString() != ""){
                _local3 = _local2["module"];
                _local4 = _local3.length();
                _local5 = 0;
                if (_local5 >= _local4){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local6 = new ModuleVersion(_local3[_local5]);
                if (false){
                    5;
                    _local6;
                    _local6.type;
                    this.versions;
                } else {
                    this.versions[_local6.type] = _local6;
                };
                _local5++;
                //unresolved if
            };
        }
        public function getModuleVersion(_arg1:int):ModuleVersion{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.versions[_arg1]);
        }
        public function get playKernelVersion():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getModuleVersion(0).version);
        }
        public function get adsVersion():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getModuleVersion(1).version);
        }
        public function get playerViewVersion():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getModuleVersion(2).version);
        }
        public function get playerViewName():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getModuleVersion(2).name);
        }

        if (37 == 34){
            return;
            /*not popped
            VersionInfo
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.info 
