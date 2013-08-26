package com.bokecc.platform.playkernel.api {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.platform.playkernel.api.model.*;
    import com.bokecc.lib.net.loader.*;

    public class PlayKernel extends EventDispatcher {

        private static var defaultName:String = "_default_playkernel_";
        private static var instances:Object = {};

        private var kernel:SWFReader;
        private var info:ObjectProxy;
        private var player:ObjectProxy;
        private var playerParam:PlayerParam;
        private var listInfo:ListInfo;
        private var userInfo:UserInfo;
        private var videoInfo:VideoInfo;
        private var versionInfo:VersionInfo;

        public function PlayKernel(_arg1:Sprite){
            this.info = new ObjectProxy();
            this.player = new ObjectProxy();
            this.playerParam = new PlayerParam();
            this.listInfo = new ListInfo();
            this.userInfo = new UserInfo();
            this.videoInfo = new VideoInfo();
            this.versionInfo = new VersionInfo();
            super();
            if (instances[defaultName] == null){
                instances[defaultName] = this;
            };
            this.kernel = new SWFReader(_arg1.loaderInfo);
            this.info.init(this.kernel.getProperty("info"));
            this.player.init(this.kernel.getProperty("player"));
            this.param.init(this.info.objectProperty("param"));
            this.user.init(this.info.objectProperty("user"));
            this.list.init(this.info.objectProperty("list"));
            this.video.init(this.info.objectProperty("video"));
            this.version.init(this.info.objectProperty("version"));
            this.kernel.addEventListener(PlayKernelEvent.PlayStartup, this.onPlayStartup);
            this.kernel.addEventListener(PlayKernelEvent.ListLoadSuccess, this.onListLoadSuccess);
            this.kernel.addEventListener(PlayKernelEvent.PlayInfoLoadSuccess, this.onPlayInfoLoadSuccess);
        }
        public static function getInstance(_arg1:Sprite, _arg2:String="_default_playkernel_"):PlayKernel{
            var _local3:PlayKernel = instances[_arg2];
            if (_local3 == null){
                _local3 = new PlayKernel(_arg1);
                instances[_arg2] = _local3;
            };
            return (_local3);
        }

        public function get document():Sprite{
            return ((this.kernel.content as Sprite));
        }
        public function get param():PlayerParam{
            return (this.playerParam);
        }
        public function get list():ListInfo{
            return (this.listInfo);
        }
        public function get user():UserInfo{
            return (this.userInfo);
        }
        public function get video():VideoInfo{
            return (this.videoInfo);
        }
        public function get version():VersionInfo{
            return (this.versionInfo);
        }
        public function reset():void{
            this.player.callFunction("reset");
        }
        public function startup(_arg1:Object):void{
            this.player.callFunction("startup", _arg1);
        }
        public function listPlay(_arg1:int):void{
            this.player.callFunction("listPlay", _arg1);
        }
        public function preload(_arg1:Number=0, _arg2:Number=-1):void{
            this.player.callFunction("preload", _arg1, _arg2);
        }
        public function start(_arg1:Number=0, _arg2:Number=-1):void{
            this.player.callFunction("start", _arg1, _arg2);
        }
        public function seek(_arg1:Number, _arg2=null):void{
            this.player.callFunction("seek", _arg1, _arg2);
        }
        public function pause(_arg1=null):void{
            this.player.callFunction("pause", _arg1);
        }
        public function reconnect():void{
            this.player.callFunction("reconnect");
        }
        public function setSharedValue(_arg1:String, _arg2):void{
            this.player.callFunction("setSharedValue", _arg1, _arg2);
        }
        public function getSharedValue(_arg1:String){
            return (this.player.callFunction("getSharedValue", _arg1));
        }
        public function addPlatformPlayerAPI(_arg1:String, _arg2:Function):void{
            this.player.callFunction("addPlatformPlayerAPI", _arg1, _arg2);
        }
        public function dispatchPlatformPlayerEvent(_arg1:String, _arg2=null):void{
            this.player.callFunction("dispatchPlatformPlayerEvent", _arg1, _arg2);
        }
        public function get displayObject():DisplayObject{
            return ((this.player.objectProperty("displayObject") as DisplayObject));
        }
        public function get parentURL():String{
            return (this.player.stringProperty("parentURL"));
        }
        public function get parentDomain():String{
            return (this.player.stringProperty("parentDomain"));
        }
        public function get isPlatformKernel():Boolean{
            return (this.player.booleanProperty("isPlatformKernel"));
        }
        public function get isCCLoader():Boolean{
            return (this.player.booleanProperty("isCCLoader"));
        }
        public function set volume(_arg1:Number):void{
            this.player.setProperty("volume", _arg1);
        }
        public function get volume():Number{
            return (this.player.numberProperty("volume"));
        }
        public function set videoZScale(_arg1:Number):void{
            this.player.setProperty("videoZScale", _arg1);
        }
        public function get videoZScale():Number{
            return (this.player.numberProperty("videoZScale"));
        }
        public function set videoScale(_arg1:Number):void{
            this.player.setProperty("videoScale", _arg1);
        }
        public function get videoScale():Number{
            return (this.player.numberProperty("videoScale"));
        }
        public function get originalScale():Number{
            return (this.player.numberProperty("originalScale"));
        }
        public function set presetScale(_arg1:String):void{
            this.player.setProperty("presetScale", _arg1);
        }
        public function get presetScale():String{
            return (this.player.stringProperty("presetScale"));
        }
        public function set brightness(_arg1:Number):void{
            this.player.setProperty("brightness", _arg1);
        }
        public function get brightness():Number{
            return (this.player.numberProperty("brightness"));
        }
        public function set contrast(_arg1:Number):void{
            this.player.setProperty("contrast", _arg1);
        }
        public function get contrast():Number{
            return (this.player.numberProperty("contrast"));
        }
        public function get mediaInfo(){
            return (this.player.objectProperty("mediaInfo"));
        }
        public function setSize(_arg1:Number, _arg2:Number):void{
            this.player.callFunction("setSize", _arg1, _arg2);
        }
        public function get width():Number{
            return (this.player.numberProperty("width"));
        }
        public function get height():Number{
            return (this.player.numberProperty("height"));
        }
        public function get stateName():String{
            return (this.player.stringProperty("stateName"));
        }
        public function get viewPosition():Number{
            return (this.player.numberProperty("viewPosition"));
        }
        public function get position():Number{
            return (this.player.numberProperty("position"));
        }
        public function get duration():Number{
            return (this.player.numberProperty("duration"));
        }
        public function get bufferStart():Number{
            return (this.player.numberProperty("bufferStart"));
        }
        public function get bufferEnd():Number{
            return (this.player.numberProperty("bufferEnd"));
        }
        public function get loading():Boolean{
            return (this.player.booleanProperty("loading"));
        }
        public function get playing():Boolean{
            return (this.player.booleanProperty("playing"));
        }
        public function get paused():Boolean{
            return (this.player.booleanProperty("paused"));
        }
        public function get stopped():Boolean{
            return (this.player.booleanProperty("stopped"));
        }
        public function get bufferTime():Number{
            return (this.player.numberProperty("bufferTime"));
        }
        public function get bufferLength():Number{
            return (this.player.numberProperty("bufferLength"));
        }
        public function get code():int{
            return (this.player.numberProperty("code"));
        }
        public function get isNormal():Boolean{
            return ((this.code == PlayKernelCode.Normal));
        }
        public function set quality(_arg1:int):void{
            this.player.setProperty("quality", _arg1);
        }
        public function get quality():int{
            return (this.player.numberProperty("quality"));
        }
        override public function removeEventListener(_arg1:String, _arg2:Function, _arg3:Boolean=false):void{
            super.removeEventListener(_arg1, _arg2);
            this.kernel.removeEventListener(_arg1, this.onKernelEvent);
        }
        override public function addEventListener(_arg1:String, _arg2:Function, _arg3:Boolean=false, _arg4:int=0, _arg5:Boolean=false):void{
            super.addEventListener(_arg1, _arg2);
            this.kernel.addEventListener(_arg1, this.onKernelEvent);
        }
        private function onKernelEvent(_arg1:Event):void{
            var _local2:Object;
            if (_arg1.hasOwnProperty("value")){
                _local2 = _arg1["value"];
            };
            dispatchEvent(new PlayKernelEvent(_arg1.type, _local2));
        }
        private function onPlayStartup(_arg1:Event):void{
            this.param.init(this.info.objectProperty("param"));
        }
        private function onListLoadSuccess(_arg1:Event):void{
            this.version.init(this.info.objectProperty("version"));
            this.user.init(this.info.objectProperty("user"));
            this.list.init(this.info.objectProperty("list"));
        }
        private function onPlayInfoLoadSuccess(_arg1:Event):void{
            if (!this.param.listMode){
                this.version.init(this.info.objectProperty("version"));
                this.user.init(this.info.objectProperty("user"));
            };
            this.video.init(this.info.objectProperty("video"));
        }

    }
}//package com.bokecc.platform.playkernel.api 
