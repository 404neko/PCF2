package com.bokecc.platform.playkernel.model.info {

    public class ModuleVersion {

        private var _name:String;
        private var _type:int;
        private var _version:String;

        public function ModuleVersion(_arg1:XML){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this._name = _arg1.@name;
            this._type = int(_arg1.@type);
            this._version = String(_arg1.@version).split("-").join("");
        }
        public function get version():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._version);
        }
        public function get type():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._type);
        }
        public function get name():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._name);
        }

        if (37 == 34){
            return;
            /*not popped
            ModuleVersion
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
