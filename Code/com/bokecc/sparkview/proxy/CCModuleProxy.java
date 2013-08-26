package com.bokecc.sparkview.proxy {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.platform.playkernel.api.model.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.player.vo.*;
    import org.puremvc.as3.patterns.proxy.*;
    import com.bokecc.utils.*;
    import com.bokecc.lib.data.*;

    public class CCModuleProxy extends Proxy implements IProxy {

        public static const Name:String = "CCModuleProxy.Name";

        private var w:String = "500";
        private var h:String = "400";

        public function CCModuleProxy(_arg1:Object){
            super(Name, _arg1);
        }
        public static function timeToString(_arg1:Number):String{
            if (_arg1 < 0){
                _arg1 = 0;
            };
            var _local2:Number = Math.floor((_arg1 / 60));
            var _local3:Number = Math.floor((_arg1 % 60));
            var _local4 = "";
            if (_local2 < 10){
                _local4 = (_local4 + ("0" + _local2));
            } else {
                _local4 = (_local4 + _local2);
            };
            _local4 = (_local4 + ":");
            if (_local3 < 10){
                _local4 = (_local4 + ("0" + _local3));
            } else {
                _local4 = (_local4 + _local3);
            };
            return (_local4);
        }

        private function get kernelProxy():PlayKernelProxy{
            return ((data as PlayKernelProxy));
        }
        private function get kernel():PlayKernel{
            return (this.kernelProxy.playKernel);
        }
        private function get user():UserInfo{
            return (this.kernel.user);
        }
        private function get video():VideoInfo{
            return (this.kernel.video);
        }
        public function protectPlayURL():String{
            var _local1:String = CCURL.PROTECTPLAY;
            if (this.kernel.param.listMode){
                _local1 = (_local1 + (("?lid=" + this.kernel.param.lid) + "&mode=list"));
            } else {
                _local1 = (_local1 + ("?vid=" + this.kernel.param.vid));
            };
            _local1 = (_local1 + ((("&playerid=" + this.kernel.param.playerid) + "&playertype=") + this.kernel.param.playertype));
            _local1 = (_local1 + ((("&uid=" + this.kernel.param.uid) + "&pageurl=") + this.kernel.param.referer));
            return (_local1);
        }
        public function get shareParam():String{
            return (((((((((("?url=" + as2_escape(this.getVideoPageURL(true))) + "&publisherUuid=") + as2_escape("753e6d4f-83eb-4dad-bf9c-dd136ea773c3")) + "&pic=") + as2_escape(this.video.imgPath)) + "&video=") + as2_escape(this.playerURL)) + "&title=") + as2_escape(this.video.title)));
        }
        public function getVideoPageURL(_arg1:Boolean=false):String{
            var _local2:String;
            if (isNull(this.video.pageAddr)){
                _local2 = ((_arg1) ? this.playerURL : this.swfCode);
            } else {
                _local2 = this.video.pageAddr;
            };
            if (_arg1){
                return (("http://spark.bokecc.com/redirect.bo?videoid=" + this.kernel.param.vid));
            };
            return (_local2);
        }
        public function get htmlCode():String{
            var _local1:String = this.swfCode;
            var _local2 = "";
            _local2 = (_local2 + (((((("<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0\" width=\"" + this.w) + "\" height=\"") + this.h) + "\" id=\"cc_") + this.kernel.param.vid) + "\">\n"));
            _local2 = (_local2 + (("<param name=\"movie\" value=\"" + _local1) + "\" />\n"));
            _local2 = (_local2 + "<param name=\"allowFullScreen\" value=\"true\" />\n");
            _local2 = (_local2 + "<param name=\"allowScriptAccess\" value=\"always\" />\n");
            _local2 = (_local2 + (((((((("<embed src=\"" + _local1) + "\" width=\"") + this.w) + "\" height=\"") + this.h) + "\" name=\"cc_") + this.kernel.param.vid) + "\" allowFullScreen=\"true\" allowScriptAccess=\"always\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\"/>\n"));
            _local2 = (_local2 + "</object>");
            return (_local2);
        }
        public function get swfCode():String{
            return ((this.swfurl + this.getParams(this.kernel.param.listMode)));
        }
        private function get playerURL():String{
            return ((this.swfurl + this.getParams(false)));
        }
        private function getParams(_arg1:Boolean):String{
            var _local2:String;
            if (_arg1){
                _local2 = (((("?listid=" + this.kernel.param.lid) + "&userid=") + this.user.id) + "&mode=list");
            } else {
                _local2 = ((("?vid=" + this.kernel.param.vid) + "&siteid=") + this.user.id);
            };
            _local2 = (_local2 + ((("&playerid=" + this.kernel.param.playerid) + "&playertype=") + this.kernel.param.playertype));
            return (_local2);
        }
        private function get swfurl():String{
            return ((((this.kernel.param.getParam("loaderType") == 1)) ? CCURL.CCVMSPlayer : CCURL.CCPlayer));
        }
        public function checkDomain():Boolean{
            var _local5:Boolean;
            var _local6:Boolean;
            var _local7:Number;
            var _local8:Number;
            var _local1:String = this.kernel.param.referer;
            if (_local1.indexOf("http://admin.bokecc.com") == 0){
                return (true);
            };
            var _local2:Array = ((isNull(this.user.whiteList)) ? [] : this.user.whiteList.split(";"));
            var _local3:Array = ((isNull(this.user.blackList)) ? [] : this.user.blackList.split(";"));
            var _local4:Boolean = (((_local2.length > 0)) || ((_local3.length > 0)));
            if (_local4){
                _local5 = false;
                _local6 = false;
                if (!isNull(_local1)){
                    _local7 = 0;
                    while (_local7 < _local3.length) {
                        if (_local1.indexOf(_local3[_local7]) != -1){
                            _local5 = true;
                            _local6 = false;
                        };
                        _local7++;
                    };
                    if (!_local5){
                        _local8 = 0;
                        while (_local8 < _local2.length) {
                            if (_local1.indexOf(_local2[_local8]) != -1){
                                _local5 = true;
                                _local6 = true;
                            };
                            _local8++;
                        };
                    };
                    if (!_local5){
                        _local6 = (_local2.length == 0);
                    };
                };
                return (_local6);
            };
            return (true);
        }
        public function get videoPoint():Array{
            var _local2:Array;
            var _local3:XML;
            var _local4:Number;
            var _local5:VideoPointVO;
            var _local6:String;
            var _local1:XMLList = this.kernel.video.videomarks;
            if (_local1){
                _local2 = [];
                for each (_local3 in _local1) {
                    _local4 = _local3.marktime[0];
                    if (!isNaN(_local4)){
                        _local5 = new VideoPointVO();
                        _local5.time = _local4;
                        _local5.progress = (_local5.time / this.kernel.duration);
                        _local6 = ((timeToString(_local5.time) + " ") + _local3.markdesc[0]);
                        _local5.remark = _local6;
                        _local2.push(_local5);
                    };
                };
            };
            return (_local2);
        }

    }
}//package com.bokecc.sparkview.proxy 
