package com.bokecc.platform.playkernel.model.info {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.model.state.closed.*;
    import com.bokecc.platform.playkernel.model.state.ready.*;

    public class StarterProxy extends BasicProxy {

        public static const NAME:String = "PlayKernel.Proxy.Starter";

        private var _listMode:Boolean;
        private var _listIndex:int;
        private var _config:Object;
        private var _hasLog:Boolean = true;
        private var _hasAD:Boolean = true;
        private var play:PlayProxy;

        public function StarterProxy(_arg1:Object){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._config = {};
            super(NAME, _arg1);
        }
        public function set config(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:String;
            if (_arg1){
                var _local3:int;
                var _local4:* = _arg1;
                //unexpected hasnext2
                if (!!NULL!){
                } else {
                    //unresolved jump
                };
                //unresolved jump
                _local2 = //unresolved nextvalue or nextname;
                if (false){
                    5;
                    _arg1[_local2];
                    _local2;
                    this._config;
                } else {
                    this._config[_local2] = _arg1[_local2];
                };
                //unresolved if
                if (this.logDisable){
                    if (false){
                        5;
                        kernel;
                    } else {
                        kernel.removeLogger();
                    };
                };
            };
        }
        private function get adDisable():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._config["adDisable"]);
        }
        public function get beginADDisable():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this.adDisable) || (this._config["beginadDisable"])));
        }
        public function get pauseADDisable():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this.adDisable) || (this._config["pauseadDisable"])));
        }
        public function get endADDisable():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (((this.adDisable) || (this._config["endadDisable"])));
        }
        public function get logDisable():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._config["logDisable"]);
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super.onRemove();
            if (false){
                5;
                new AllClosed();
                kernel;
            } else {
                kernel.changeState(new AllClosed());
            };
            if (false){
                5;
                {
                    listMode:this.listMode,
                    upid:info.video.upid,
                    uplid:info.list.uplid
                };
                PlayKernelEvent.PlayClosed;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayClosed, {
                    listMode:this.listMode,
                    upid:info.video.upid,
                    uplid:info.list.uplid
                });
            };
            return;
            /*not popped
            {
                listMode:this.listMode,
                upid:info.video.upid,
                uplid:info.list.uplid
            }
            */
            /*not popped
            PlayKernelEvent.PlayClosed
            */
            /*not popped
            kernel
            */
            /*not popped
            new AllClosed()
            */
            /*not popped
            kernel
            */
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super.init();
            if (false){
                5;
                data;
                this;
            } else {
                this.setPlayParam(data);
            };
            if (false){
                5;
                kernel;
            } else {
                kernel.initLogger();
            };
            if (false){
                5;
                {
                    listMode:this.listMode,
                    upid:info.video.upid,
                    uplid:info.list.uplid
                };
                PlayKernelEvent.PlayStartup;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayStartup, {
                    listMode:this.listMode,
                    upid:info.video.upid,
                    uplid:info.list.uplid
                });
            };
            if (this.listMode){
                if (false){
                    5;
                    new LoadListInfo();
                    kernel;
                } else {
                    kernel.changeState(new LoadListInfo());
                };
            } else {
                if (false){
                    5;
                    this;
                } else {
                    this.newPlay();
                };
                if (false){
                    5;
                    new LoadPlayInfo();
                    kernel;
                } else {
                    kernel.changeState(new LoadPlayInfo());
                };
            };
            return;
            /*not popped
            {
                listMode:this.listMode,
                upid:info.video.upid,
                uplid:info.list.uplid
            }
            */
            /*not popped
            PlayKernelEvent.PlayStartup
            */
            /*not popped
            kernel
            */
            /*not popped
            kernel
            */
            /*not popped
            data
            */
            /*not popped
            this
            */
        }
        public function setPlayParam(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            data = _arg1;
            if (false){
                5;
                data;
                info.param;
            } else {
                info.param.init(data);
            };
            return;
            /*not popped
            data
            */
            /*not popped
            info.param
            */
        }
        public function getPlayInfoFormLoader():XML{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local1 = "playinfo";
            var _local2:XML = info.param.getParam(_local1);
            if (false){
                5;
                _local1;
                info.param;
            } else {
                info.param.setParam(_local1);
            };
            return (_local2);
            /*not popped
            _local1
            */
            /*not popped
            info.param
            */
        }
        public function parseVersion(_arg1:XML):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                info.version;
            } else {
                info.version.parse(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            info.version
            */
        }
        public function parseList(_arg1:XML):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                info.list;
            } else {
                info.list.parse(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            info.list
            */
        }
        public function parseUser(_arg1:XML):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                info.user;
            } else {
                info.user.parse(_arg1);
            };
            if (false){
                5;
                info.user.uid;
                "uid";
                info.param;
            } else {
                info.param.setParam("uid", info.user.uid);
            };
            return;
            /*not popped
            info.user.uid
            */
            /*not popped
            "uid"
            */
            /*not popped
            info.param
            */
            /*not popped
            _arg1
            */
            /*not popped
            info.user
            */
        }
        public function parseVideo(_arg1:XML):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                info.user.uid;
                info.user.isp;
                _arg1;
                info.video;
            } else {
                info.video.parse(_arg1, info.user.isp, info.user.uid);
            };
            return;
            /*not popped
            info.user.uid
            */
            /*not popped
            info.user.isp
            */
            /*not popped
            _arg1
            */
            /*not popped
            info.video
            */
        }
        public function listPlay(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Boolean = ((((info.param.listMode) && ((_arg1 >= 0)))) && ((_arg1 < info.list.length)));
            if (_local2){
                this._listIndex = _arg1;
                if (false){
                    5;
                    info.list.getNode(_arg1).videoid;
                    "vid";
                    info.param;
                } else {
                    info.param.setParam("vid", info.list.getNode(_arg1).videoid);
                };
                if (false){
                    5;
                    this;
                } else {
                    this.newPlay();
                };
                if (false){
                    5;
                    new LoadListVideoInfo();
                    kernel;
                } else {
                    kernel.changeState(new LoadListVideoInfo());
                };
            };
        }
        public function get listMode():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (info.param.listMode);
        }
        public function get listIndex():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._listIndex);
        }
        protected function newPlay():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.play = (model.registerProxy(new PlayProxy()) as PlayProxy);
        }

        if (37 == 34){
            return;
            /*not popped
            StarterProxy
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
