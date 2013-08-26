package com.bokecc.platform.playkernel.model.info {
    import com.bokecc.lib.data.*;

    public class UserInfo {

        private var _uid:String;
        private var _isp:Number;
        private var _jscontrol:Boolean;
        private var _protection:Boolean;
        private var _group:Number;
        private var _province:String;
        private var _listVerification:Boolean;
        private var _user:XML;
        private var _playerstyle:XML;
        private var _liststyle:XML;
        private var _xml:XML;

        public function UserInfo(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
        }
        public function clone():UserInfo{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:UserInfo = new UserInfo();
            if (false){
                5;
                this._xml;
                _local1;
            } else {
                _local1.parse(this._xml);
            };
            return (_local1);
            /*not popped
            this._xml
            */
            /*not popped
            _local1
            */
        }
        function parse(_arg1:XML):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:XMLList = _arg1["user"];
            if (_local2.toXMLString() != ""){
                this._user = _local2[0];
                this._uid = this.user["id"][0];
                this._isp = toNumber(this.user["isp"][0], 3);
                this._protection = toBoolean(this.user["protection"][0]);
                this._jscontrol = toBoolean(this.user["jscontrol"][0]);
                this._province = this.user["province"][0];
                this._group = toNumber(this.user["group"][0], 0);
            };
            var _local3:XMLList = _arg1["playerstyle"];
            if (_local3.toXMLString() != ""){
                this._playerstyle = _local3[0];
            };
            var _local4:XMLList = _arg1["liststyle"];
            if (_local4.toXMLString() != ""){
                this._liststyle = _local4[0];
                this._listVerification = toBoolean(this.liststyle["verification"][0]);
            };
        }
        public function get liststyle():XML{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._liststyle);
        }
        public function get playerstyle():XML{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._playerstyle);
        }
        public function get user():XML{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._user);
        }
        public function get uid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._uid);
        }
        public function get isp():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._isp);
        }
        public function get jscontrol():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._jscontrol);
        }
        public function get protection():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._protection);
        }
        public function get group():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._group);
        }
        public function get province():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._province);
        }
        public function get listVerification():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._listVerification);
        }
        public function get hasFlare():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this.isBusinessUsers) || ((this.getGroup() > 0))));
        }
        public function get hasTraffic():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.isBusinessUsers);
        }
        public function get isBusinessUsers():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return ((this.group >= 300));
        }
        public function get isHTWX():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            /*switch (){
                    return (true);
            }*/;
            return (false);
        }
        public function get isPinshan():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this.getGroup() == 1));
        }
        public function get isTangDou():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this.getGroup() == 31));
        }
        public function getGroup():Number{
            switch (this.uid){
                case "192655":
                case "F5B5CDED713D57FF":
                case "192663":
                case "C196FF1B630F1D8F":
                case "205318":
                case "E0B63A54D48BA5B6":
                case "205382":
                case "84AA4578AFC3FAB3":
                case "191358":
                case "4C01CCCC877D90C5":
                    return (1);
                case "188983":
                case "F00FE2E98FE1AC8D":
                case "191599":
                case "AFE0CD5D97832B8E":
                    return (21);
                case "192523":
                case "CD0C5D3C8614B28B":
                case "204849":
                case "21F4A787A918F3CE":
                    return (31);
                default:
                    return (0);
            };
        }

        if (37 == 34){
            return;
            /*not popped
            UserInfo
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
