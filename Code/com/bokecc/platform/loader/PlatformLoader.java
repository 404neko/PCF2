package com.bokecc.platform.loader {
    import flash.events.*;
    import flash.display.*;
    import flash.system.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.lib.net.loader.*;
    import flash.utils.*;
    import com.bokecc.platform.playkernel.utils.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.lib.data.*;
    import flash.external.*;

    public dynamic class PlatformLoader extends Sprite {

        private var playInfoLoader:APILoader;
        private var kernel:SWFProxy;
        private var swfInfo:SWFInfo;
        private var errorCode:int;
        private var initialized:Boolean;
        private var referer:String;
        private var pageurl:String;
        private var loadertype:int;
        private var protectplay:Boolean;
        private var loadingText:LoadingText;

        public function PlatformLoader(){
            this.playInfoLoader = new APILoader();
            this.kernel = new SWFProxy();
            this.loadingText = new LoadingText();
            super();
            Security.allowDomain("*");
            addEventListener(Event.ADDED_TO_STAGE, this.onAdd2Stage);
            loaderInfo.addEventListener(Event.COMPLETE, this.onLoaderComplete);
        }
        private function onAdd2Stage(_arg1:Event):void{
            stage.align = StageAlign.TOP_LEFT;
            stage.scaleMode = StageScaleMode.NO_SCALE;
            stage.showDefaultContextMenu = false;
            var _local2:ContextMenuUtil = new ContextMenuUtil(this);
            _local2.addItem("Loader Build:20130722", false);
        }
        private function onLoaderComplete(_arg1:Event):void{
            loaderInfo.removeEventListener(Event.COMPLETE, this.onLoaderComplete);
            setTimeout(this.init, 500);
        }
        private function init():void{
            var jshandler:* = null;
            if (SystemUtil.isBelowVersion(10.1)){
                this.sendReadyError(PlayKernelCode.LowVersionFlashPlayer);
                this.loadingText.showLowVersion();
                return;
            };
            this.swfInfo = new SWFInfo(this);
            this.checkReferer();
            this.initialized = true;
            if (ExternalInterface.available){
                try {
                    ExternalInterface.addCallback("startup", this.startup);
                    jshandler = this.swfInfo.flashvars["jshandler"];
                    if (jshandler){
                        ExternalInterface.call((jshandler + ".onPlayerInitialized"), ExternalInterface.objectID);
                    };
                } catch(e:Error) {
                };
            };
            dispatchEvent(new Event(PlayKernelEvent.LoaderInitialized));
            this.checkPlayParam();
        }
        private function checkReferer():void{
            var _local2:String;
            var _local1:String = loaderInfo.url.split("?")[0];
            switch (_local1){
                case CCURL.VunionPlayer:
                    this.loadertype = 100;
                    this.swfInfo.flashvars["mode"] = PlayKernelMode.Vunion;
                    break;
                case CCURL.KernelPlayer:
                    this.loadertype = 3;
                    this.swfInfo.flashvars["mode"] = PlayKernelMode.PureAPI;
                    break;
                case CCURL.CCPlayer:
                    this.loadertype = 2;
                    break;
                case CCURL.CCVMSPlayer:
                    this.loadertype = 1;
                    _local2 = this.swfInfo.stringVar("referer");
                    if (isNull(_local2)){
                        this.pageurl = _local2;
                    };
                    break;
                default:
                    this.loadertype = (((_local1.indexOf("bokecc.com") == -1)) ? -1 : 0);
            };
            this.referer = (this.pageurl = this.swfInfo.referer.toString());
            this.protectplay = (this.referer.indexOf(CCURL.PROTECTPLAY) == 0);
            if (this.protectplay){
                this.swfInfo.flashvars["mode"] = PlayKernelMode.ProtectPlay;
                this.pageurl = this.swfInfo.stringVar("pageurl");
            };
        }
        private function checkPlayParam():void{
            var _local1:String;
            var _local2:String;
            var _local3:String;
            var _local4:Boolean;
            var _local6:String;
            var _local7:String;
            var _local8:Array;
            var _local9:Boolean;
            var _local10:String;
            var _local11:String;
            var _local5:String = this.swfInfo.stringVar("mode");
            _local5 = _local5.split("-").shift();
            switch (_local5){
                case PlayKernelMode.ProtectPlay:
                case PlayKernelMode.Admin:
                    _local3 = this.swfInfo.stringVar("listid");
                    _local4 = !(isNull(_local3));
                    _local1 = ((_local4) ? _local3 : this.swfInfo.stringVar("vid"));
                    _local2 = this.swfInfo.stringVar("uid");
                    break;
                case PlayKernelMode.API:
                    _local4 = false;
                    _local1 = this.swfInfo.stringVar("videoid");
                    _local2 = this.swfInfo.stringVar("userid");
                    break;
                case PlayKernelMode.List:
                    _local4 = true;
                    _local1 = this.swfInfo.stringVar("listid");
                    _local2 = this.swfInfo.stringVar("userid");
                    break;
                case PlayKernelMode.PureAPI:
                    _local3 = this.swfInfo.stringVar("listid");
                    _local4 = !(isNull(_local3));
                case PlayKernelMode.Spark:
                default:
                    if (_local4){
                        _local1 = this.swfInfo.stringVar("listid");
                        _local2 = this.swfInfo.stringVar("siteid");
                    } else {
                        _local6 = this.swfInfo.stringVar("siteid");
                        _local7 = this.swfInfo.stringVar("vid");
                        if (((!(isNull(_local6))) && (!(isNull(_local7))))){
                            _local1 = _local7;
                            _local2 = _local6;
                        } else {
                            _local7 = this.swfInfo.stringVar("videoid");
                            if (((!(isNull(_local7))) && (!((_local7.indexOf("_") == -1))))){
                                _local8 = _local7.split("_");
                                _local1 = _local8[1];
                                _local2 = _local8[0];
                            };
                        };
                    };
            };
            if (!isNull(_local1)){
                _local9 = this.swfInfo.booleanVar("autostart", true);
                if ((((this.loadertype == 1)) || ((this.loadertype == 2)))){
                    _local10 = ((((((("?uid=" + _local2) + "&playerid=") + this.swfInfo.stringVar("playerid")) + "&playertype=") + this.swfInfo.stringVar("playertype")) + "&autoStart=") + _local9);
                    if (_local4){
                        _local10 = (_local10 + ((("&lid=" + _local1) + "&mode=") + _local5));
                    } else {
                        _local10 = (_local10 + ("&vid=" + _local1));
                    };
                    _local11 = ((("window.location.href='" + CCURL.DELEGATEPLAY) + _local10) + "';");
                    SWFInfo.RefererJSCode = ["eval", (((("(function(){var h=window.location.href;if(h.indexOf('" + CCURL.FLASH) + "')==0){") + _local11) + "}return h;}).call();")];
                    this.swfInfo.getReferer();
                };
                this.startupHandler(_local1, _local2, _local9, _local4, this.swfInfo.flashvars);
            };
        }
        private function get guid():String{
            var _local1:String = this.getSharedValue("uuid");
            if (isNull(_local1)){
                _local1 = Guid.create();
                this.setSharedValue("uuid", _local1);
            };
            return (_local1);
        }
        public function getSharedValue(_arg1:String){
            return (SharedObjectUtil.getData(_arg1, "bokecc.com"));
        }
        public function setSharedValue(_arg1:String, _arg2):void{
            SharedObjectUtil.setData(_arg1, _arg2, "bokecc.com");
        }
        public function reset():void{
            var _local1:String;
            this.removePlayInfoLoaderEvent();
            this.playInfoLoader.unload();
            if (((this.kernel) && (this.kernel.valid))){
                _local1 = "reset";
                if (this.kernel.hasProperty(_local1)){
                    this.kernel.call(_local1);
                } else {
                    this.kernel.call("call", _local1);
                };
            };
        }
        public function startup(_arg1:String, _arg2:String, _arg3:Boolean=true, _arg4:Boolean=false, ... _args):Boolean{
            var _local9:String;
            var _local10:Array;
            var _local11:String;
            var _local12:String;
            var _local6:Object = {};
            var _local7:int = _args.length;
            var _local8:int;
            while (_local8 < _local7) {
                _local9 = _args[_local8];
                if (_local9.indexOf(":") != -1){
                    _local10 = _local9.split(":");
                    _local11 = _local10.shift();
                    _local12 = _local10.join(":");
                    if (!isNull(_local11)){
                        _local6[_local11] = _local12;
                    };
                };
                _local8++;
            };
            return (this.startupHandler(_arg1, _arg2, _arg3, _arg4, _local6));
        }
        private function startupHandler(_arg1:String, _arg2:String, _arg3:Boolean, _arg4:Boolean, _arg5:Object):Boolean{
            if (((!(this.initialized)) || (isNull(_arg1)))){
                return (false);
            };
            this.reset();
            _arg5[((_arg4) ? "lid" : "vid")] = _arg1.toLocaleUpperCase();
            _arg5["uid"] = _arg2.toLocaleUpperCase();
            _arg5["listmode"] = _arg4;
            _arg5["autostart"] = _arg3;
            _arg5["jsable"] = this.swfInfo.jsable;
            _arg5["loadertype"] = this.loadertype;
            _arg5["referer"] = this.referer;
            _arg5["pageurl"] = this.pageurl;
            _arg5["protectplay"] = this.protectplay;
            _arg5["guid"] = this.guid;
            this.swfInfo.readParam(_arg5, true);
            if (!this.kernel.loading){
                if (this.kernel.valid){
                    this.startupPlayKernel();
                } else {
                    this.loadingText.addorRemove(this, false);
                    this.loadInfo();
                };
            };
            return (true);
        }
        private function loadInfo():void{
            var _local1:RequestURL = new RequestURL(CCURL.PLAYINFO);
            _local1.addParam("uid", this.swfInfo.stringVar("uid"));
            _local1.addParam("vid", this.swfInfo.stringVar("vid"));
            _local1.addParam("lid", this.swfInfo.stringVar("lid"));
            _local1.addParam("pid", this.swfInfo.stringVar("playerid"));
            _local1.addParam("pt", this.swfInfo.stringVar("playertype"));
            _local1.addParam("pm", this.swfInfo.stringVar("mode", "spark"));
            _local1.addParam("m", ((this.swfInfo.booleanVar("listmode")) ? 2 : 1));
            _local1.addParam("pp", this.protectplay);
            _local1.addParam("d", this.swfInfo.referer.domain);
            _local1.addParam("fv", SystemUtil.version);
            _local1.addParam("uu", this.swfInfo.stringVar("guid"));
            _local1.addParam("rnd", int((Math.random() * 10000)).toString());
            this.playInfoLoader.url = _local1.toString();
            this.playInfoLoader.addEventListener(Event.COMPLETE, this.onInfoComplete);
            this.playInfoLoader.addEventListener(IOErrorEvent.IO_ERROR, this.onInfoError);
            this.playInfoLoader.addEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onInfoError);
            this.playInfoLoader.load();
        }
        private function removePlayInfoLoaderEvent():void{
            this.playInfoLoader.removeEventListener(Event.COMPLETE, this.onInfoComplete);
            this.playInfoLoader.removeEventListener(IOErrorEvent.IO_ERROR, this.onInfoError);
            this.playInfoLoader.removeEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onInfoError);
        }
        private function onInfoError(_arg1:Event):void{
            this.removePlayInfoLoaderEvent();
            this.sendReadyError(((this.swfInfo.booleanVar("listmode")) ? PlayKernelCode.GetListInfoError : PlayKernelCode.GetSinglePlayInfoError));
        }
        private function onInfoComplete(_arg1:Event):void{
            this.removePlayInfoLoaderEvent();
            this.swfInfo.flashvars["playinfo"] = XML(this.playInfoLoader.content);
            this.swfInfo.flashvars["playinfoloadtime"] = this.playInfoLoader.requestTime;
            this.loadPlayKernel();
        }
        private function startupPlayKernel():void{
            var _local1 = "startup";
            if (this.kernel.hasProperty(_local1)){
                this.kernel.call(_local1, this.swfInfo.flashvars);
            } else {
                this.kernel.call("call", _local1, this.swfInfo.flashvars);
            };
        }
        private function loadPlayKernel():void{
            var _local2:String;
            var _local4:int;
            var _local5:int;
            var _local6:XML;
            var _local7:String;
            var _local8:int;
            var _local9:String;
            var _local1:XML = XML(this.playInfoLoader.content);
            var _local3:XMLList = _local1["playerversion"][0]["module"];
            if (_local3.toXMLString() != ""){
                _local4 = _local3.length();
                _local5 = 0;
                while (_local5 < _local4) {
                    _local6 = _local3[_local5];
                    _local7 = _local6.@name;
                    _local8 = int(_local6.@type);
                    _local9 = String(_local6.@version).split("-").join("");
                    if ((((_local7 == "PlayKernel")) || ((_local8 == 0)))){
                        _local2 = _local9;
                        break;
                    };
                    _local5++;
                };
            };
            this.kernel.addEventListener(Event.COMPLETE, this.onPlayerComplete);
            this.kernel.addEventListener(IOErrorEvent.IO_ERROR, this.onPlayerError);
            this.kernel.addEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onPlayerError);
            this.kernel.url = CCURL.getPlayKernel(_local2);
            this.kernel.load();
        }
        private function removePlayKernelEvent():void{
            this.kernel.removeEventListener(Event.COMPLETE, this.onPlayerComplete);
            this.kernel.removeEventListener(IOErrorEvent.IO_ERROR, this.onPlayerError);
            this.kernel.removeEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onPlayerError);
        }
        private function onPlayerError(_arg1:Event):void{
            this.removePlayKernelEvent();
            this.loadingText.stop();
            this.sendReadyError(PlayKernelCode.LoadPlayerFailed);
        }
        private function onPlayerComplete(_arg1:Event):void{
            this.removePlayKernelEvent();
            this.loadingText.addorRemove(this, true);
            this.swfInfo.flashvars["playerloadtime"] = this.kernel.requestTime;
            addChild(this.kernel.loader);
            this.startupPlayKernel();
        }
        private function sendReadyError(_arg1:int):void{
            var _local2:XML;
            var _local3:String;
            this.errorCode = _arg1;
            switch (_arg1){
                case PlayKernelCode.GetListInfoError:
                case PlayKernelCode.GetSinglePlayInfoError:
                    this.sendErrorLog("10000", _arg1, {pi_time:this.playInfoLoader.requestTime});
                    break;
                case PlayKernelCode.LoadPlayerFailed:
                    _local2 = XML(this.playInfoLoader.content);
                    _local3 = _local2["upid"][0];
                    if (isNull(_local3)){
                        _local3 = "10001";
                    };
                    this.sendErrorLog(_local3, _arg1, {
                        pi_time:this.playInfoLoader.requestTime,
                        pl_time:this.kernel.requestTime
                    });
                    break;
            };
            dispatchEvent(new PlayKernelEvent(PlayKernelEvent.PlayerError, this.errorCode));
        }
        private function sendErrorLog(_arg1:String, _arg2:int, _arg3:Object):void{
            var _local5:String;
            var _local4:RequestURL = new RequestURL("http://flare.bokecc.com/flash/playlog");
            _local4.addParam("stage", 10);
            _local4.addParam("upid", _arg1);
            _local4.addParam("userid", this.swfInfo.stringVar("uid"));
            _local4.addParam("videoid", this.swfInfo.stringVar("vid"));
            _local4.addParam("status", 0);
            _local4.addParam("reason", _arg2);
            for (_local5 in _arg3) {
                _local4.addParam(_local5, _arg3[_local5]);
            };
            _local4.addParam("uvid", this.guid);
            _local4.addParam("time", new Date().getTime());
            _local4.addParam("random", int((Math.random() * Math.pow(10, 7))));
            _local4.send();
        }

    }
}//package com.bokecc.platform.loader 

import flash.events.*;
import flash.display.*;
import flash.text.*;
import flash.utils.*;

class LoadingText extends TextField {

    private static const LOADING:String = "加载中";

    private var timer:Timer;

    public function LoadingText(){
        this.timer = new Timer(1000);
        super();
        defaultTextFormat = new TextFormat(null, 14, 0xCCCCCC);
        selectable = false;
        width = 300;
        height = 30;
        text = LOADING;
    }
    public function stop():void{
        this.timerStop();
        text = "加载失败，请尝试刷新";
    }
    public function showLowVersion():void{
        this.timerStop();
        multiline = true;
        htmlText = "您需要<a href='http://get.adobe.com/cn/flashplayer/' target='_blank'><u>升级flash player</u></a>之后才能播放";
    }
    public function addorRemove(_arg1:Sprite, _arg2:Boolean=false):void{
        if (_arg2){
            this.timerStop();
            _arg1.removeChild(this);
        } else {
            this.timer.addEventListener(TimerEvent.TIMER, this.onTimer);
            this.timer.start();
            _arg1.addChild(this);
        };
    }
    private function timerStop():void{
        this.timer.removeEventListener(TimerEvent.TIMER, this.onTimer);
        this.timer.stop();
    }
    private function onTimer(_arg1:TimerEvent):void{
        var _local2:String = LOADING;
        var _local3:int = (this.timer.currentCount % 7);
        while (_local3 > 0) {
            _local2 = (_local2 + "·");
            _local3--;
        };
        text = _local2;
    }

}
