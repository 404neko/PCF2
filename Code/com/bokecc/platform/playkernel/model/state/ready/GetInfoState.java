package com.bokecc.platform.playkernel.model.state.ready {
    import flash.events.*;
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.model.info.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.lib.net.loader.*;
    import com.bokecc.platform.playkernel.utils.*;

    public class GetInfoState extends PlayerState {

        public static const ListMode:int = 2;
        public static const SinglePlayMode:int = 1;
        public static const ListPlayMode:int = 0;

        private var loader:APILoader;

        public function GetInfoState(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
            if (false){
                5;
                this;
            } else {
                this.dispatchLoadBegin();
            };
            return;
            /*not popped
            this
            */
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.onRemove();
            if (this.loader){
                if (false){
                    5;
                    this;
                } else {
                    this.removeLoader();
                };
            };
        }
        protected function hasPlayInfo():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:XML = kernel.starter.getPlayInfoFormLoader();
            var _local2 = !((_local1 == null));
            if (_local2){
                if (false){
                    5;
                    _local1;
                    this;
                } else {
                    this.setInfo(_local1);
                };
                if (false){
                    5;
                    this;
                } else {
                    this.dispatchLoadSuccess();
                };
            };
            return (_local2);
        }
        protected function loadPlayInfo(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:RequestURL = new RequestURL(CCURL.PLAYINFO);
            if (false){
                5;
                this.param.uid;
                "uid";
                _local2;
            } else {
                _local2.addParam("uid", this.param.uid);
            };
            if (false){
                5;
                this.param.vid;
                "vid";
                _local2;
            } else {
                _local2.addParam("vid", this.param.vid);
            };
            if (false){
                5;
                this.param.lid;
                "lid";
                _local2;
            } else {
                _local2.addParam("lid", this.param.lid);
            };
            if (false){
                5;
                this.param.playerid;
                "pid";
                _local2;
            } else {
                _local2.addParam("pid", this.param.playerid);
            };
            if (false){
                5;
                this.param.playertype;
                "pt";
                _local2;
            } else {
                _local2.addParam("pt", this.param.playertype);
            };
            if (false){
                5;
                this.param.playermode;
                "pm";
                _local2;
            } else {
                _local2.addParam("pm", this.param.playermode);
            };
            if (false){
                5;
                _arg1;
                "m";
                _local2;
            } else {
                _local2.addParam("m", _arg1);
            };
            if (false){
                5;
                this.param.protectplay;
                "pp";
                _local2;
            } else {
                _local2.addParam("pp", this.param.protectplay);
            };
            if (false){
                5;
                this.param.domain;
                "d";
                _local2;
            } else {
                _local2.addParam("d", this.param.domain);
            };
            if (false){
                5;
                SystemUtil.version;
                "fv";
                _local2;
            } else {
                _local2.addParam("fv", SystemUtil.version);
            };
            if (false){
                5;
                this.param.guid;
                "uu";
                _local2;
            } else {
                _local2.addParam("uu", this.param.guid);
            };
            if (false){
                5;
                int((Math.random() * 10000)).toString();
                "rnd";
                _local2;
            } else {
                _local2.addParam("rnd", int((Math.random() * 10000)).toString());
            };
            this.loader = new APILoader();
            if (false){
                5;
                this.onLoadComplete;
                Event.COMPLETE;
                this.loader;
            } else {
                this.loader.addEventListener(Event.COMPLETE, this.onLoadComplete);
            };
            if (false){
                5;
                this.onLoadError;
                IOErrorEvent.IO_ERROR;
                this.loader;
            } else {
                this.loader.addEventListener(IOErrorEvent.IO_ERROR, this.onLoadError);
            };
            if (false){
                5;
                this.onLoadError;
                SecurityErrorEvent.SECURITY_ERROR;
                this.loader;
            } else {
                this.loader.addEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onLoadError);
            };
            if (false){
                5;
                _local2.toString();
                this.loader;
            } else {
                this.loader.url = _local2.toString();
            };
            if (false){
                5;
                this.loader;
            } else {
                this.loader.load();
            };
            return;
            /*not popped
            this.loader
            */
            /*not popped
            _local2.toString()
            */
            /*not popped
            this.loader
            */
            /*not popped
            this.onLoadError
            */
            /*not popped
            SecurityErrorEvent.SECURITY_ERROR
            */
            /*not popped
            this.loader
            */
            /*not popped
            this.onLoadError
            */
            /*not popped
            IOErrorEvent.IO_ERROR
            */
            /*not popped
            this.loader
            */
            /*not popped
            this.onLoadComplete
            */
            /*not popped
            Event.COMPLETE
            */
            /*not popped
            this.loader
            */
            /*not popped
            int((Math.random() * 10000)).toString()
            */
            /*not popped
            "rnd"
            */
            /*not popped
            _local2
            */
            /*not popped
            this.param.guid
            */
            /*not popped
            "uu"
            */
            /*not popped
            _local2
            */
            /*not popped
            SystemUtil.version
            */
            /*not popped
            "fv"
            */
            /*not popped
            _local2
            */
            /*not popped
            this.param.domain
            */
            /*not popped
            "d"
            */
            /*not popped
            _local2
            */
            /*not popped
            this.param.protectplay
            */
            /*not popped
            "pp"
            */
            /*not popped
            _local2
            */
            /*not popped
            _arg1
            */
            /*not popped
            "m"
            */
            /*not popped
            _local2
            */
            /*not popped
            this.param.playermode
            */
            /*not popped
            "pm"
            */
            /*not popped
            _local2
            */
            /*not popped
            this.param.playertype
            */
            /*not popped
            "pt"
            */
            /*not popped
            _local2
            */
            /*not popped
            this.param.playerid
            */
            /*not popped
            "pid"
            */
            /*not popped
            _local2
            */
            /*not popped
            this.param.lid
            */
            /*not popped
            "lid"
            */
            /*not popped
            _local2
            */
            /*not popped
            this.param.vid
            */
            /*not popped
            "vid"
            */
            /*not popped
            _local2
            */
            /*not popped
            this.param.uid
            */
            /*not popped
            "uid"
            */
            /*not popped
            _local2
            */
        }
        protected function removeLoader():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                this.onLoadComplete;
                Event.COMPLETE;
                this.loader;
            } else {
                this.loader.removeEventListener(Event.COMPLETE, this.onLoadComplete);
            };
            if (false){
                5;
                this.onLoadError;
                IOErrorEvent.IO_ERROR;
                this.loader;
            } else {
                this.loader.removeEventListener(IOErrorEvent.IO_ERROR, this.onLoadError);
            };
            if (false){
                5;
                this.onLoadError;
                SecurityErrorEvent.SECURITY_ERROR;
                this.loader;
            } else {
                this.loader.removeEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onLoadError);
            };
            if (false){
                5;
                this.loader;
            } else {
                this.loader.unload();
            };
            this.loader = null;
            return;
            /*not popped
            this.loader
            */
            /*not popped
            this.onLoadError
            */
            /*not popped
            SecurityErrorEvent.SECURITY_ERROR
            */
            /*not popped
            this.loader
            */
            /*not popped
            this.onLoadError
            */
            /*not popped
            IOErrorEvent.IO_ERROR
            */
            /*not popped
            this.loader
            */
            /*not popped
            this.onLoadComplete
            */
            /*not popped
            Event.COMPLETE
            */
            /*not popped
            this.loader
            */
        }
        protected function get param():PlayerParam{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.param);
        }
        protected function dispatchLoadBegin():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
        }
        protected function dispatchLoadError():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        protected function dispatchLoadSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        protected function setInfo(_arg1:XML):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        private function onLoadError(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this;
            } else {
                this.dispatchLoadError();
            };
            return;
            /*not popped
            this
            */
        }
        private function onLoadComplete(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                XML(this.loader.content);
                this;
            } else {
                this.setInfo(XML(this.loader.content));
            };
            if (false){
                5;
                this;
            } else {
                this.dispatchLoadSuccess();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            XML(this.loader.content)
            */
            /*not popped
            this
            */
        }

        if (37 == 34){
            return;
            /*not popped
            GetInfoState
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.state.ready 
