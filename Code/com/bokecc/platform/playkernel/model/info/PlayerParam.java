package com.bokecc.platform.playkernel.model.info {

    public class PlayerParam {

        private var oparam:Object;

        public function PlayerParam(_arg1:Object){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            if (false){
                5;
                _arg1;
                this;
            } else {
                this.init(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this
            */
        }
        public static function getDomain(_arg1:String):String{
            if (37 == 34){
                return;
                /*not popped
                PlayerParam
                */
            };
            var _local2:String = String(_arg1.split("://")[1]).split("/")[0];
            var _local3:Array = _local2.split(".");
            if (_local3[0] == "www"){
                if (false){
                    5;
                    _local3;
                } else {
                    _local3.shift();
                };
            };
            return (_local3.join("."));
        }

        function init(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.oparam = _arg1;
        }
        function setParam(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg2;
                _arg1;
                this.oparam;
            } else {
                this.oparam[_arg1] = _arg2;
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.oparam
            */
        }
        public function getParam(_arg1:String, _arg2=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:* = this.oparam[_arg1];
            if (_local3 == null){
                _local3 = _arg2;
            };
            return (_local3);
        }
        public function get playerloadtime():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("playerloadtime", -1));
        }
        public function get playinfoloadtime():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("playinfoloadtime", -1));
        }
        public function get guid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("guid", ""));
        }
        public function get jsable():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("jsable", false));
        }
        public function get protectplay():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("protectplay", false));
        }
        public function get referer():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("referer", ""));
        }
        public function get pageurl():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("pageurl", ""));
        }
        public function get loadertype():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("loadertype", -1));
        }
        public function get domain():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (getDomain(this.referer));
        }
        public function get uid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("uid", ""));
        }
        public function get vid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("vid", ""));
        }
        public function get lid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("lid", ""));
        }
        public function get playerid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("playerid", ""));
        }
        public function get playertype():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("playertype", ""));
        }
        public function get autostart():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("autostart", true));
        }
        public function get acids():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.getParam("acids", ""));
        }
        public function get playermode():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("mode", "spark"));
        }
        public function get listMode():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getParam("listmode", false));
        }

        if (37 == 34){
            return;
            /*not popped
            PlayerParam
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
