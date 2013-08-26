package com.bokecc.platform.playkernel.core.playerad {
    import flash.events.*;
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.core.display.*;
    import com.bokecc.lib.net.loader.*;
    import com.bokecc.platform.playkernel.utils.*;

    public class ADProxy extends EventDispatcher {

        private static const ADShowBegin:String = "ADShowBegin";
        private static const ADShowFinish:String = "ADFinish";
        public static const BeginAD:String = "BeginAD";
        public static const PauseAD:String = "PauseAD";
        public static const EndAD:String = "EndAD";
        public static const AdvertiserSpark:String = "spark";
        public static const AdvertiserCC:String = "baiduadmin";

        private var task:String = "";
        private var ad:SWFProxy;
        private var container:Container;
        private var info:InfoProxy;

        public function ADProxy(_arg1:Container, _arg2:InfoProxy){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this.ad = new SWFProxy();
            this.container = _arg1;
            this.info = _arg2;
        }
        private function get ready():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this.ad.valid) && (!(this.ad.loading))));
        }
        private function get adModuleLoadError():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.ad.error);
        }
        public function get adModuleLoadDuration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.ad.requestTime);
        }
        public function updateADInfo():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Object;
            if (this.ready){
                _local1 = {};
                if (false){
                    5;
                    "http://player.bokecc.com/spark3/";
                    "swfDirectory";
                    _local1;
                } else {
                    _local1["swfDirectory"] = "http://player.bokecc.com/spark3/";
                };
                if (false){
                    5;
                    this.info.param.vid;
                    "vid";
                    _local1;
                } else {
                    _local1["vid"] = this.info.param.vid;
                };
                if (false){
                    5;
                    this.info.param.uid;
                    "uid";
                    _local1;
                } else {
                    _local1["uid"] = this.info.param.uid;
                };
                if (false){
                    5;
                    this.info.video.cid;
                    "cid";
                    _local1;
                } else {
                    _local1["cid"] = this.info.video.cid;
                };
                if (false){
                    5;
                    this.info.video.descriptionUrl;
                    "descriptionUrl";
                    _local1;
                } else {
                    _local1["descriptionUrl"] = this.info.video.descriptionUrl;
                };
                if (false){
                    5;
                    this.info.param.referer;
                    "referer";
                    _local1;
                } else {
                    _local1["referer"] = this.info.param.referer;
                };
                if (false){
                    5;
                    this.info.video.tag;
                    "tag";
                    _local1;
                } else {
                    _local1["tag"] = this.info.video.tag;
                };
                if (false){
                    5;
                    this.info.user.province;
                    "province";
                    _local1;
                } else {
                    _local1["province"] = this.info.user.province;
                };
                if (false){
                    5;
                    ((this.info.user.isBusinessUsers) ? AdvertiserSpark : AdvertiserCC);
                    "advertiser";
                    _local1;
                } else {
                    _local1["advertiser"] = ((this.info.user.isBusinessUsers) ? AdvertiserSpark : AdvertiserCC);
                };
                if (this.info.user.getGroup() > 0){
                    if (false){
                        5;
                        this.info.param.acids;
                        "acids";
                        _local1;
                    } else {
                        _local1["acids"] = this.info.param.acids;
                    };
                };
                if (false){
                    5;
                    this.adsCallback;
                    _local1;
                    "init";
                    this.ad;
                } else {
                    this.ad.call("init", _local1, this.adsCallback);
                };
            };
        }
        public function hideAD():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.task = "";
            if (this.ready){
                if (false){
                    5;
                    "hideAD";
                    this.ad;
                } else {
                    this.ad.call("hideAD");
                };
            };
        }
        public function showBeginAD():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                ((this.info.beginADDisable) ? 0 : 1);
                BeginAD;
                ADEvent.LoadADBegin;
                this;
            } else {
                this.dispatch(ADEvent.LoadADBegin, BeginAD, ((this.info.beginADDisable) ? 0 : 1));
            };
            if (this.info.beginADDisable){
                if (false){
                    5;
                    -200;
                    BeginAD;
                    ADShowFinish;
                    this;
                } else {
                    this.adsCallback(ADShowFinish, BeginAD, -200);
                };
            } else {
                if (false){
                    5;
                    BeginAD;
                    this;
                } else {
                    this.showAD(BeginAD);
                };
            };
            return;
            /*not popped
            ((this.info.beginADDisable) ? 0 : 1)
            */
            /*not popped
            BeginAD
            */
            /*not popped
            ADEvent.LoadADBegin
            */
            /*not popped
            this
            */
        }
        public function showPauseAD():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                ((this.info.pauseADDisable) ? 0 : 1);
                PauseAD;
                ADEvent.LoadADBegin;
                this;
            } else {
                this.dispatch(ADEvent.LoadADBegin, PauseAD, ((this.info.pauseADDisable) ? 0 : 1));
            };
            if (!this.info.pauseADDisable){
                if (false){
                    5;
                    PauseAD;
                    this;
                } else {
                    this.showAD(PauseAD);
                };
            };
            return;
            /*not popped
            ((this.info.pauseADDisable) ? 0 : 1)
            */
            /*not popped
            PauseAD
            */
            /*not popped
            ADEvent.LoadADBegin
            */
            /*not popped
            this
            */
        }
        public function showEndAD():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                ((this.info.endADDisable) ? 0 : 1);
                EndAD;
                ADEvent.LoadADBegin;
                this;
            } else {
                this.dispatch(ADEvent.LoadADBegin, EndAD, ((this.info.endADDisable) ? 0 : 1));
            };
            if (this.info.endADDisable){
                if (false){
                    5;
                    -200;
                    EndAD;
                    ADShowFinish;
                    this;
                } else {
                    this.adsCallback(ADShowFinish, EndAD, -200);
                };
            } else {
                if (false){
                    5;
                    EndAD;
                    this;
                } else {
                    this.showAD(EndAD);
                };
            };
            return;
            /*not popped
            ((this.info.endADDisable) ? 0 : 1)
            */
            /*not popped
            EndAD
            */
            /*not popped
            ADEvent.LoadADBegin
            */
            /*not popped
            this
            */
        }
        public function showAD(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Boolean = ((((this.adModuleLoadError) || ((((_arg1 == BeginAD)) && (this.info.beginADFinish))))) || ((((_arg1 == EndAD)) && (this.info.endADFinish))));
            if (_local2){
                if (false){
                    5;
                    -100;
                    _arg1;
                    ADEvent.ShowADFinish;
                    this;
                } else {
                    this.dispatch(ADEvent.ShowADFinish, _arg1, -100);
                };
                return;
                /*not popped
                -100
                */
                /*not popped
                _arg1
                */
                /*not popped
                ADEvent.ShowADFinish
                */
                /*not popped
                this
                */
            };
            if (this.ready){
                this.task = "";
                if (false){
                    5;
                    _arg1;
                    "showAD";
                    this.ad;
                } else {
                    this.ad.call("showAD", _arg1);
                };
            } else {
                this.task = _arg1;
                if (false){
                    5;
                    this;
                } else {
                    this.loadModule();
                };
            };
        }
        private function loadModule():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Boolean = ((!(this.ad.valid)) && (!(this.ad.loading)));
            if (_local1){
                if (false){
                    5;
                    CCURL.getADS(this.info.version.adsVersion);
                    this.ad;
                } else {
                    this.ad.url = CCURL.getADS(this.info.version.adsVersion);
                };
                if (false){
                    5;
                    this.onLoadSuccess;
                    Event.COMPLETE;
                    this.ad;
                } else {
                    this.ad.addEventListener(Event.COMPLETE, this.onLoadSuccess);
                };
                if (false){
                    5;
                    this.onLoadError;
                    IOErrorEvent.IO_ERROR;
                    this.ad;
                } else {
                    this.ad.addEventListener(IOErrorEvent.IO_ERROR, this.onLoadError);
                };
                if (false){
                    5;
                    this.onLoadError;
                    SecurityErrorEvent.SECURITY_ERROR;
                    this.ad;
                } else {
                    this.ad.addEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onLoadError);
                };
                if (false){
                    5;
                    this.ad;
                } else {
                    this.ad.load();
                };
            };
        }
        private function onLoadSuccess(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                1;
                this.ad.loader;
                this.container;
            } else {
                this.container.addChildAt(this.ad.loader, 1);
            };
            if (false){
                5;
                this.resize;
                Event.RESIZE;
                this.container;
            } else {
                this.container.addEventListener(Event.RESIZE, this.resize);
            };
            if (false){
                5;
                this;
            } else {
                this.resize();
            };
            if (false){
                5;
                this;
            } else {
                this.updateADInfo();
            };
            if (this.task != ""){
                if (false){
                    5;
                    this.task;
                    this;
                } else {
                    this.showAD(this.task);
                };
            };
            return;
            /*not popped
            this
            */
            /*not popped
            this
            */
            /*not popped
            this.resize
            */
            /*not popped
            Event.RESIZE
            */
            /*not popped
            this.container
            */
            /*not popped
            1
            */
            /*not popped
            this.ad.loader
            */
            /*not popped
            this.container
            */
        }
        private function resize(_arg1:Event=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.container.height;
                this.container.width;
                "resize";
                this.ad;
            } else {
                this.ad.call("resize", this.container.width, this.container.height);
            };
            return;
            /*not popped
            this.container.height
            */
            /*not popped
            this.container.width
            */
            /*not popped
            "resize"
            */
            /*not popped
            this.ad
            */
        }
        private function onLoadError(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.task != ""){
                if (false){
                    5;
                    this.task;
                    this;
                } else {
                    this.showAD(this.task);
                };
            };
        }
        private function adsCallback(_arg1:String, _arg2:String, _arg3:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            /*switch (){
                    if (false){
                        5;
                        _arg2;
                        ADEvent.ShowADBegin;
                        this;
                    } else {
                        this.dispatch(ADEvent.ShowADBegin, _arg2);
                    };
                    break;
                    if (false){
                        5;
                        (((_arg3 > 0)) ? (_arg3 * 1000) : _arg3);
                        _arg2;
                        ADEvent.ShowADFinish;
                        this;
                    } else {
                        this.dispatch(ADEvent.ShowADFinish, _arg2, (((_arg3 > 0)) ? (_arg3 * 1000) : _arg3));
                    };
                    break;
            }*/;
        }
        private function dispatch(_arg1:String, _arg2:String, _arg3:Number=-1):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new ADEvent(_arg1, _arg2, _arg3);
                ;
            } else {
                dispatchEvent(new ADEvent(_arg1, _arg2, _arg3));
            };
            return;
            /*not popped
            new ADEvent(_arg1, _arg2, _arg3)
            */
        }

        if (37 == 34){
            return;
            /*not popped
            ADProxy
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.core.playerad 
