package com.bokecc.platform.playkernel.api.model {

    public class PlayerParam extends ObjectProxy {

        public function PlayerParam(_arg1:Object=null){
            super(_arg1);
        }
        public function getParam(_arg1:String){
            return (callFunction("getParam", _arg1));
        }
        public function get playerloadtime():int{
            return (numberProperty("playerloadtime", 0));
        }
        public function get playinfoloadtime():int{
            return (numberProperty("playinfoloadtime", 0));
        }
        public function get guid():String{
            return (stringProperty("guid"));
        }
        public function get jsable():Boolean{
            return (booleanProperty("jsable"));
        }
        public function get protectplay():Boolean{
            return (booleanProperty("protectplay"));
        }
        public function get referer():String{
            return (stringProperty("referer"));
        }
        public function get pageurl():String{
            return (stringProperty("pageurl"));
        }
        public function get info_hash():String{
            return (this.getParam("info_hash"));
        }
        public function get loadertype():int{
            return (numberProperty("loadertype"));
        }
        public function get uid():String{
            return (stringProperty("uid"));
        }
        public function get vid():String{
            return (stringProperty("vid"));
        }
        public function get lid():String{
            return (stringProperty("lid"));
        }
        public function get playerid():String{
            return (stringProperty("playerid"));
        }
        public function get playertype():String{
            return (stringProperty("playertype"));
        }
        public function get autostart():Boolean{
            return (booleanProperty("autostart", true));
        }
        public function get acids():String{
            return (stringProperty("acids"));
        }
        public function get playermode():String{
            return (stringProperty("playermode"));
        }
        public function get listMode():Boolean{
            return (booleanProperty("listMode"));
        }

    }
}//package com.bokecc.platform.playkernel.api.model 
