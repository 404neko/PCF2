package com.bokecc.platform.playkernel.core {
    import com.bokecc.platform.playkernel.model.info.*;
    import com.bokecc.framework.mvc.*;
    import com.bokecc.platform.playkernel.core.playerview.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.utils.*;

    public class InfoProxy extends Proxy {

        public static const NAME:String = "PlayKernel.Proxy.PlayerInfo";

        private var _param:PlayerParam;
        private var _version:VersionInfo;
        private var _list:ListInfo;
        private var _user:UserInfo;
        private var _video:VideoInfo;

        public function InfoProxy(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._param = new PlayerParam({});
            this._version = new VersionInfo();
            this._list = new ListInfo();
            this._user = new UserInfo();
            this._video = new VideoInfo();
            super(NAME);
        }
        public function get version():VersionInfo{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._version);
        }
        public function get param():PlayerParam{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._param);
        }
        public function get list():ListInfo{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._list);
        }
        public function get user():UserInfo{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._user);
        }
        public function get video():VideoInfo{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._video);
        }
        private function get kernel():KernelProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((model.proxy(KernelProxy.NAME) as KernelProxy));
        }
        private function get player():PlayerProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((model.proxy(PlayerProxy.NAME) as PlayerProxy));
        }
        private function get starter():StarterProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((model.proxy(StarterProxy.NAME) as StarterProxy));
        }
        private function get play():PlayProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return ((model.proxy(PlayProxy.NAME) as PlayProxy));
        }
        public function get beginADFinish():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.play){
            } else {
                //unresolved jump
            };
            return (this.play.beginADFinish);
            return (false);
        }
        public function get endADFinish():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.play){
            } else {
                //unresolved jump
            };
            return (this.play.endADFinish);
            return (false);
        }
        public function get beginADDisable():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.starter){
            } else {
                //unresolved jump
            };
            return (this.starter.beginADDisable);
            return (false);
        }
        public function get pauseADDisable():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.starter){
            } else {
                //unresolved jump
            };
            return (this.starter.pauseADDisable);
            return (false);
        }
        public function get endADDisable():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.starter){
            } else {
                //unresolved jump
            };
            return (this.starter.endADDisable);
            return (false);
        }
        public function getViewURL():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:String = this.param.getParam("testView");
            if (_local1 != null){
            } else {
                //unresolved jump
            };
            return (_local1);
            var _local2:String = this.param.playermode.split("-").shift();
            if (_local2 == PlayKernelMode.PureAPI){
            } else {
                //unresolved jump
            };
            return (PlayerView.PureAPIMode);
            return (CCURL.getView(this.version.playerViewName, this.version.playerViewVersion));
        }
        public function get isSelfSite():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:String = this.video.domainURL.split("http://www.").join("").split("http://").join("");
            return ((this.param.referer.indexOf(_local1) >= 0));
        }
        public function get isValidatedUser():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((!(this.video.isLocked)) && (!(this.video.traffic))));
        }
        public function getPlayID():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.play){
            } else {
                //unresolved jump
            };
            return (this.play.id);
            return ("");
        }
        public function getUPID():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.video.upid);
        }
        public function getUUID():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.param.guid);
        }

        if (37 == 34){
            return;
            /*not popped
            InfoProxy
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
    //unresolved jump
}//package com.bokecc.platform.playkernel.core 
