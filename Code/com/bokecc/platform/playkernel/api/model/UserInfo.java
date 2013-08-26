package com.bokecc.platform.playkernel.api.model {
    import com.bokecc.lib.data.*;

    public class UserInfo extends ObjectProxy {

        private var _allowDownload:Boolean = false;
        private var _menusData:Array;
        private var _isVod:Boolean;
        private var _vodApi:String;
        private var _download:int;
        private var _skinStyle:String;
        private var _backgroundColor:int;
        private var _foreColor:int;
        private var _logoURL:String;
        private var _logoLink:String;
        private var _whiteList:String;
        private var _blackList:String;
        private var _listPosition:Number;
        private var _listStyle:Number;
        private var _bshare:String;
        private var _rightMenus:XMLList;
        private var _hasEndShare:Boolean;
        private var _hasRecommend:Boolean;
        private var _showrightmenu:Boolean;
        private var _autoHidden:Boolean;
        private var _fullscreen:Boolean;
        private var _loadingpic:String;
        private var _logoPosition:int;
        private var _logoTransparency:Number;

        public function UserInfo(_arg1:Object=null){
            super(_arg1);
        }
        override public function init(_arg1:Object):void{
            if (_arg1 != null){
                super.init(_arg1);
                this.parse();
            };
        }
        private function parse():void{
            var _local1:XMLList;
            var _local2:XMLList;
            var _local3:XMLList;
            var _local4:XMLList;
            var _local5:XMLList;
            var _local6:XMLList;
            if (this.user){
                _local1 = this.user["vod"];
                this._isVod = toBoolean(_local1.@isvod);
                this._vodApi = _local1.@vodapi;
                this._download = toNumber(this.user["download"][0], -1);
            };
            if (this.playerstyle){
                _local2 = this.playerstyle["skin"];
                this._skinStyle = _local2.@style;
                this._backgroundColor = toColorValue(_local2.@faceplate);
                this._foreColor = toColorValue(_local2.@font);
                _local3 = this.playerstyle["logo"];
                this._logoURL = _local3.@logourl;
                this._logoLink = _local3.@linkurl;
                this._logoTransparency = (toNumber(_local3.@transparency, 100) / 100);
                this._logoPosition = toNumber(_local3.@position, 1);
                _local4 = this.playerstyle["domain"];
                this._blackList = this.getDomainList(_local4["blacklist"]);
                this._whiteList = this.getDomainList(_local4["whitelist"]);
                _local5 = this.playerstyle["setting"];
                this._autoHidden = (_local5.@autohidden == "1");
                this._fullscreen = (_local5.@fullscreen == "1");
                this._showrightmenu = (_local5.@showrightmenu == "1");
                this._rightMenus = _local5["rightmenu"];
                _local6 = this.playerstyle["setting"]["end"];
                this._hasRecommend = (_local6.@recommend == "1");
                this._hasEndShare = (_local6.@share == "1");
                this._loadingpic = this.playerstyle["loadingpic"][0];
                this._bshare = this.playerstyle["bshare"][0];
            };
            if (this.liststyle){
                this._listStyle = toNumber(this.liststyle["style"][0], 1);
                this._listPosition = toNumber(this.liststyle["position"][0], 1);
            };
            this._menusData = this.parseMenus(this.rightMenus);
        }
        private function getDomainList(_arg1:XMLList):String{
            var _local4:Number;
            var _local5:Number;
            var _local2:Array = [];
            var _local3:XMLList = _arg1["url"];
            if (_local3 != null){
                _local4 = _local3.length();
                _local5 = 0;
                while (_local5 < _local4) {
                    _local2.push(_local3[_local5]);
                    _local5++;
                };
            };
            return (_local2.join(";"));
        }
        private function parseMenus(_arg1:XMLList):Array{
            var _local4:MenuNodeVO;
            var _local2:Array = [];
            var _local3:int;
            while (_local3 < _arg1.length()) {
                _local4 = new MenuNodeVO(_arg1[_local3]);
                _local2.push(_local4);
                if ((((_local4.name == "videodownload")) && ((this.download > -1)))){
                    this._allowDownload = true;
                };
                _local3++;
            };
            return (_local2);
        }
        private function get liststyle():XML{
            return ((objectProperty("liststyle") as XML));
        }
        private function get playerstyle():XML{
            return ((objectProperty("playerstyle") as XML));
        }
        private function get user():XML{
            return ((objectProperty("user") as XML));
        }
        public function get id():String{
            return (stringProperty("uid"));
        }
        public function get province():String{
            return (stringProperty("province"));
        }
        public function get isp():Number{
            return (numberProperty("isp"));
        }
        public function get group():Number{
            return (numberProperty("group"));
        }
        public function get jscontrol():Boolean{
            return (booleanProperty("jscontrol"));
        }
        public function get protection():Boolean{
            return (booleanProperty("protection"));
        }
        public function get listVerification():Boolean{
            return (booleanProperty("listVerification"));
        }
        public function get hasFlare():Boolean{
            return (booleanProperty("hasFlare"));
        }
        public function get hasTraffic():Boolean{
            return (booleanProperty("hasTraffic"));
        }
        public function get isBusinessUsers():Boolean{
            return (booleanProperty("isBusinessUsers"));
        }
        public function get isVod():Boolean{
            return (this._isVod);
        }
        public function get vodApi():String{
            return (this._vodApi);
        }
        public function get download():int{
            return (this._download);
        }
        public function get skinStyle():String{
            var _local1:String = this._skinStyle;
            switch (this.id){
                case "204826":
                case "3BADB1A22693D98E":
                    _local1 = "nbsy";
                    break;
                case "218241":
                case "6AA6C3864D0F93FE":
                    _local1 = "biquu";
                    break;
            };
            return (_local1);
        }
        public function get backgroundColor():int{
            return (this._backgroundColor);
        }
        public function get foreColor():int{
            return (this._foreColor);
        }
        public function get logoURL():String{
            return (this._logoURL);
        }
        public function get logoLink():String{
            return (this._logoLink);
        }
        public function get logoTransparency():Number{
            return (this._logoTransparency);
        }
        public function get logoPosition():int{
            return (this._logoPosition);
        }
        public function get loadingpic():String{
            return (this._loadingpic);
        }
        public function get fullscreen():Boolean{
            return (this._fullscreen);
        }
        public function get autoHidden():Boolean{
            return (this._autoHidden);
        }
        public function get showrightmenu():Boolean{
            return (this._showrightmenu);
        }
        public function get hasRecommend():Boolean{
            return (this._hasRecommend);
        }
        public function get hasEndShare():Boolean{
            return (this._hasEndShare);
        }
        public function get rightMenus():XMLList{
            return (this._rightMenus);
        }
        public function get bshare():String{
            return (this._bshare);
        }
        public function get listStyle():Number{
            return (this._listStyle);
        }
        public function get listPosition():Number{
            return (this._listPosition);
        }
        public function get blackList():String{
            return (this._blackList);
        }
        public function get whiteList():String{
            return (this._whiteList);
        }
        public function get allowDownload():Boolean{
            return (this._allowDownload);
        }
        public function get menusData():Array{
            return (this._menusData);
        }
        public function get isHideControl():Boolean{
            return ((((this.id == "36F4F68D5866EF4D")) || ((this.id == "215892"))));
        }
        public function get isCaixin():Boolean{
            return ((((this.id == "201631")) || ((this.id == "276DD96A8F53A6BA"))));
        }

    }
}//package com.bokecc.platform.playkernel.api.model 
