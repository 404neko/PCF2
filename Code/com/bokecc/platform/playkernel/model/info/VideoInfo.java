package com.bokecc.platform.playkernel.model.info {
    import com.bokecc.platform.playkernel.model.player.*;
    import com.bokecc.platform.playkernel.utils.*;
    import com.bokecc.lib.data.*;

    public class VideoInfo {

        private var _upid:String;
        private var _isLocked:Boolean;
        private var _forumName:String;
        private var _domainURL:String;
        private var _traffic:Boolean;
        private var _videoURL:String;
        private var _status:int;
        private var _opreason:String;
        private var _isValid:Boolean;
        private var _title:String;
        private var _hasAddr:Boolean;
        private var _pageAddr:String;
        private var _cid:String;
        private var _tag:String;
        private var _defaultquality:int;
        private var _imgPath:String;
        private var _downloadPath:String;
        private var _descriptionUrl:String;
        private var _highestPriority:int;
        private var _qualityValidity:Array;
        private var _map:Array;
        private var _videomarks:XMLList;

        public function VideoInfo(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._qualityValidity = [false, false, false];
            this._map = [];
            super();
        }
        public static function toCCRtmpPath(_arg1:String):String{
            if (37 == 34){
                return;
                /*not popped
                VideoInfo
                */
            };
            var _local2:int = _arg1.indexOf("/", 10);
            return (((_arg1.slice(0, _local2) + "/vod|") + _arg1.slice((_local2 + 1))));
        }

        public function getQualityValidity(_arg1:Number):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._qualityValidity[_arg1]);
        }
        public function get highestPriority():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._highestPriority);
        }
        function get map():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._map);
        }
        function parse(_arg1:XML, _arg2:int, _arg3:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local5:XML;
            var _local6:XMLList;
            this._map = [];
            this._qualityValidity = [false, false, false];
            if (!isNull(_arg1["UPID"])){
                this._upid = String(_arg1["UPID"][0]);
            };
            var _local4:XMLList = _arg1["video"];
            if (_local4.toXMLString() != ""){
                _local5 = _local4[0];
                this._videoURL = _local5.@videoURL;
                this._title = CCDecoder.decodeBase64(_local5.@title);
                this._forumName = CCDecoder.decodeBase64(_local5.@forumName);
                this._domainURL = _local5.@domainURL;
                this._cid = _local5.@cid;
                this._tag = CCDecoder.decodeBase64(_local5.@tag);
                this._isLocked = (_local5.@isLocked == "true");
                this._hasAddr = !((_local5.@hasAddr == "0"));
                this._pageAddr = _local5.@pageAddr;
                this._isValid = (_local5.@isValid == "1");
                this._traffic = (_local5.@traffic == "1");
                this._descriptionUrl = ((((((("http://stat.bokecc.com/vd.jsp?t=" + encodeURI(this.title)) + "&g=") + encodeURI(this.tag)) + "&c=") + this.cid) + "&f=") + encodeURI(this.forumName));
                this._status = toNumber(_local5.@status, -3);
                this._opreason = _local5.@opreason;
                this._defaultquality = toNumber(_local5.@defaultquality, 0);
                _local6 = _local5["videomarks"];
                if (_local6.toXMLString() != ""){
                    this._videomarks = _local6[0]["videomark"];
                };
                if (false){
                    5;
                    _arg3;
                    _arg2;
                    _local5["server"];
                    this;
                } else {
                    this.parseServer(_local5["server"], _arg2, _arg3);
                };
            };
        }
        private function parseServer(_arg1:XMLList, _arg2:int, _arg3:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local6:XML;
            var _local7:int;
            var _local8:int;
            var _local9:int;
            var _local10:String;
            var _local11:String;
            var _local12:PlayServer;
            var _local13:Boolean;
            var _local14:Array;
            var _local4:int = _arg1.length();
            var _local5:int;
            if (_local5 >= _local4){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local6 = _arg1[_local5];
            if ((((this._imgPath == null)) && (!((_local6.@imgPath == null))))){
                this._imgPath = _local6.@imgPath;
            };
            if ((((this._downloadPath == null)) && (!((_local6.@downloadPath == null))))){
                this._downloadPath = _local6.@downloadPath;
            };
            _local7 = toNumber(_local6.@quality, 0);
            _local8 = toNumber(_local6.@priority, 0);
            _local9 = toNumber(_local6.@isp, 0);
            _local10 = _local6.@flvPath;
            _local11 = "rtmp";
            if (_local10.indexOf(_local11) == 0){
                _local10 = toCCRtmpPath(_local10);
            } else {
                _local11 = extension(_local10).toLowerCase();
                _local13 = (((((((((((_arg3 == "216562")) || ((_arg3 == "217355")))) || ((_arg3 == "206100")))) || ((_arg3 == "B86E9AC935D39444")))) || ((_arg3 == "4CF84DEFB6CF4FA0")))) || ((_arg3 == "2ADA6249FCE66910")));
                if (((!((_local11 == "pcf"))) && (_local13))){
                    _local14 = _local10.split("/");
                    if (false){
                        5;
                        "t3.ccvms.com";
                        2;
                        _local14;
                    } else {
                        _local14[2] = "t3.ccvms.com";
                    };
                    var _temp1 = _local14;
                    _local10 = _local14.join("/");
                    if (_local11 == "flv"){
                        _local10 = _local10.split(".flv").join(".ppf");
                    };
                    if (_local11 == "mp4"){
                        _local10 = _local10.split(".mp4").join(".ppm");
                    };
                };
                if (!isNull(this._upid)){
                    _local10 = (_local10 + (((((_local10.indexOf("?") > 0)) ? "&" : "?") + "upid=") + this._upid));
                };
            };
            if (false){
                5;
                true;
                _local7;
                this._qualityValidity;
            } else {
                this._qualityValidity[_local7] = true;
            };
            _local12 = new PlayServer(_local10);
            if (false){
                5;
                _local11;
                PlayServer.Mode;
                _local12;
            } else {
                _local12.set(PlayServer.Mode, _local11);
            };
            if (false){
                5;
                (((_local9 == 0)) || ((_local9 == _arg2)));
                PlayServer.SameIsp;
                _local12;
            } else {
                _local12.set(PlayServer.SameIsp, (((_local9 == 0)) || ((_local9 == _arg2))));
            };
            if (false){
                5;
                _local9;
                PlayServer.Isp;
                _local12;
            } else {
                _local12.set(PlayServer.Isp, _local9);
            };
            if (false){
                5;
                _local7;
                PlayServer.Quality;
                _local12;
            } else {
                _local12.set(PlayServer.Quality, _local7);
            };
            if (false){
                5;
                _local8;
                PlayServer.Priority;
                _local12;
            } else {
                _local12.set(PlayServer.Priority, _local8);
            };
            if (false){
                5;
                _local6.@serverDomain;
                PlayServer.Domain;
                _local12;
            } else {
                _local12.set(PlayServer.Domain, _local6.@serverDomain);
            };
            if (false){
                5;
                _local12;
                this._map;
            } else {
                this._map.push(_local12);
            };
            if (this.highestPriority < _local8){
                this._highestPriority = _local8;
            };
            _local5++;
            //unresolved if
            return;
            /*not popped
            _local12
            */
            /*not popped
            this._map
            */
            /*not popped
            _local6.@serverDomain
            */
            /*not popped
            PlayServer.Domain
            */
            /*not popped
            _local12
            */
            /*not popped
            _local8
            */
            /*not popped
            PlayServer.Priority
            */
            /*not popped
            _local12
            */
            /*not popped
            _local7
            */
            /*not popped
            PlayServer.Quality
            */
            /*not popped
            _local12
            */
            /*not popped
            _local9
            */
            /*not popped
            PlayServer.Isp
            */
            /*not popped
            _local12
            */
            /*not popped
            (((_local9 == 0)) || ((_local9 == _arg2)))
            */
            /*not popped
            PlayServer.SameIsp
            */
            /*not popped
            _local12
            */
            /*not popped
            _local11
            */
            /*not popped
            PlayServer.Mode
            */
            /*not popped
            _local12
            */
            /*not popped
            true
            */
            /*not popped
            _local7
            */
            /*not popped
            this._qualityValidity
            */
        }
        public function get upid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._upid);
        }
        public function get isLocked():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._isLocked);
        }
        public function get forumName():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._forumName);
        }
        public function get domainURL():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._domainURL);
        }
        public function get traffic():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._traffic);
        }
        public function get videoURL():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._videoURL);
        }
        public function get status():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._status);
        }
        public function get opreason():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._opreason);
        }
        public function get isValid():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._isValid);
        }
        public function get title():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._title);
        }
        public function get hasAddr():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._hasAddr);
        }
        public function get pageAddr():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._pageAddr);
        }
        public function get cid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._cid);
        }
        public function get tag():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._tag);
        }
        public function get defaultquality():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._defaultquality);
        }
        public function get imgPath():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._imgPath);
        }
        public function get downloadPath():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._downloadPath);
        }
        public function get descriptionUrl():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._descriptionUrl);
        }
        public function get videomarks():XMLList{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._videomarks);
        }

        if (37 == 34){
            return;
            /*not popped
            VideoInfo
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
