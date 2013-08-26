package com.bokecc.platform.playkernel.model.state.preloading {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.model.player.*;

    public class Preloading extends PlayerState {

        public static const NAME:String = "PlayKernel.State.Preloading";
        public static const Beginning:String = "Preloading.Type.Beginning";
        public static const SwitchQuality:String = "Preloading.Type.SwitchQuality";
        public static const PlayReconnect:String = "Preloading.Type.PlayReconnect";

        private var type:String;
        protected var preloader:Preloader;

        public function Preloading(_arg1:String, _arg2:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
            this.type = _arg2;
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.onRemove();
            if (false){
                5;
                this;
            } else {
                this.destroyPreloader();
            };
            return;
            /*not popped
            this
            */
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
        }
        protected function destroyPreloader():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.preloader){
                if (false){
                    5;
                    this.onPreloadSpeedTestSuccessHandler;
                    PreloadEvent.SpeedTestSuccess;
                    this.preloader;
                } else {
                    this.preloader.removeEventListener(PreloadEvent.SpeedTestSuccess, this.onPreloadSpeedTestSuccessHandler);
                };
                if (false){
                    5;
                    this.onPreloadFailedHandler;
                    PreloadEvent.Failed;
                    this.preloader;
                } else {
                    this.preloader.removeEventListener(PreloadEvent.Failed, this.onPreloadFailedHandler);
                };
                if (false){
                    5;
                    this.onPreloadSuccessHandler;
                    PreloadEvent.Success;
                    this.preloader;
                } else {
                    this.preloader.removeEventListener(PreloadEvent.Success, this.onPreloadSuccessHandler);
                };
                if (false){
                    5;
                    this.preloader;
                } else {
                    this.preloader.destroy();
                };
                this.preloader = null;
            };
        }
        protected function preload(_arg1:Boolean=false):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                kernel.media;
            } else {
                kernel.media.interrupt();
            };
            if (false){
                5;
                this;
            } else {
                this.destroyPreloader();
            };
            var _local2:Array = this.getServers(_arg1);
            var _local3 = (_local2.length > 0);
            if (_local3){
                this.preloader = new Preloader(kernel.play.createGroup(this.type, _local2), kernel.play.position);
                if (false){
                    5;
                    this.onPreloadSpeedTestSuccessHandler;
                    PreloadEvent.SpeedTestSuccess;
                    this.preloader;
                } else {
                    this.preloader.addEventListener(PreloadEvent.SpeedTestSuccess, this.onPreloadSpeedTestSuccessHandler);
                };
                if (false){
                    5;
                    this.onPreloadFailedHandler;
                    PreloadEvent.Failed;
                    this.preloader;
                } else {
                    this.preloader.addEventListener(PreloadEvent.Failed, this.onPreloadFailedHandler);
                };
                if (false){
                    5;
                    this.onPreloadSuccessHandler;
                    PreloadEvent.Success;
                    this.preloader;
                } else {
                    this.preloader.addEventListener(PreloadEvent.Success, this.onPreloadSuccessHandler);
                };
                if (false){
                    5;
                    this.preloader;
                } else {
                    this.preloader.preload();
                };
            } else {
                if (false){
                    5;
                    this;
                } else {
                    this.onPreloadFailed();
                };
            };
            return;
            /*not popped
            this
            */
            /*not popped
            kernel.media
            */
        }
        private function onPreloadSpeedTestSuccessHandler(_arg1:PreloadEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.preloader.result;
                kernel.play;
            } else {
                kernel.play.setMedia(this.preloader.result);
            };
            if (false){
                5;
                this;
            } else {
                this.onPreloadSpeedTestSuccess();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            this.preloader.result
            */
            /*not popped
            kernel.play
            */
        }
        private function onPreloadSuccessHandler(_arg1:PreloadEvent):void{
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
                this.onPreloadSuccess();
            };
            if (false){
                5;
                kernel.play;
            } else {
                kernel.play.setPreloadSuccess();
            };
            return;
            /*not popped
            kernel.play
            */
            /*not popped
            this
            */
        }
        private function onPreloadFailedHandler(_arg1:PreloadEvent):void{
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
                this.onOncePreloadFailed();
            };
            return;
            /*not popped
            this
            */
        }
        protected function get preloadValue():Object{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Object = {};
            if (this.preloader){
                if (false){
                    5;
                    this.preloader.group;
                    "group";
                    _local1;
                } else {
                    _local1["group"] = this.preloader.group;
                };
                if (false){
                    5;
                    this.preloader.result;
                    "result";
                    _local1;
                } else {
                    _local1["result"] = this.preloader.result;
                };
            };
            return (_local1);
        }
        protected function onPreloadSpeedTestSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        protected function onOncePreloadFailed():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                true;
                this;
            } else {
                this.preload(true);
            };
            return;
            /*not popped
            true
            */
            /*not popped
            this
            */
        }
        protected function onPreloadFailed():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        protected function onPreloadSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
        }
        private function getServers(_arg1:Boolean=false):Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local4:Boolean;
            var _local2:Array = ((_arg1) ? [] : kernel.play.currentServers);
            var _local3 = (_local2.length > 0);
            if (!!(_local3)){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local4 = kernel.play.lowerRequirement();
            if (_local4){
                _local2 = kernel.play.currentServers;
                _local3 = (_local2.length > 0);
                //unresolved jump
            };
            //unresolved jump
            return (_local2);
        }
        override public function get loading():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (true);
        }
        override public function get quality():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.quality);
        }
        override public function get viewPosition():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (kernel.play.position);
        }
        override public function get position():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.position);
        }
        override public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.duration);
        }
        override public function get bufferStart():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.play.position);
        }
        override public function get bufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (this.preloader){
                return (this.preloader.bufferEnd);
            };
            return (kernel.play.position);
        }
        override public function get bufferLength():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (this.preloader){
                return (this.preloader.bufferLength);
            };
            return (0);
        }

        if (37 == 34){
            return;
            /*not popped
            Preloading
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.state.preloading 
