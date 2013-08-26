package com.bokecc.platform.playkernel.model.state.preloading {
    import flash.events.*;
    import com.bokecc.platform.playkernel.core.playerad.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.controller.api.*;
    import com.bokecc.platform.playkernel.model.state.playing.*;

    public class BeginningPreloading extends Preloading {

        public static const NAME:String = "PlayKernel.State.BeginningPreloading";

        private var preloadFinish:Boolean;
        private var beginQuality:int;

        public function BeginningPreloading(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME, Preloading.Beginning);
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
                this.onShowADFinish;
                ADEvent.ShowADFinish;
                kernel.ad;
            } else {
                kernel.ad.removeEventListener(ADEvent.ShowADFinish, this.onShowADFinish);
            };
            return;
            /*not popped
            this.onShowADFinish
            */
            /*not popped
            ADEvent.ShowADFinish
            */
            /*not popped
            kernel.ad
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
            this.preloadFinish = false;
            if (!kernel.play.beginADFinish){
                if (false){
                    5;
                    this.onShowADFinish;
                    ADEvent.ShowADFinish;
                    kernel.ad;
                } else {
                    kernel.ad.addEventListener(ADEvent.ShowADFinish, this.onShowADFinish);
                };
            };
            if (false){
                5;
                PlayKernelEvent.PreloadStart;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PreloadStart);
            };
            if (kernel.play.isNormalVideoStatus){
                if (false){
                    5;
                    quality;
                    kernel.play;
                } else {
                    kernel.play.quality = quality;
                };
                this.beginQuality = quality;
                if (false){
                    5;
                    ;
                } else {
                    preload();
                };
            } else {
                if (info.isValidatedUser){
                    if (false){
                        5;
                        kernel.play.videoStatus;
                        ;
                    } else {
                        setCode(kernel.play.videoStatus);
                    };
                    this.preloadFinish = true;
                    if (false){
                        5;
                        this;
                    } else {
                        this.checkBeginningFinish();
                    };
                };
            };
            return;
            /*not popped
            PlayKernelEvent.PreloadStart
            */
            /*not popped
            kernel
            */
        }
        override protected function onPreloadSpeedTestSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (kernel.play.position >= preloader.result.media.duration){
                if (false){
                    5;
                    0;
                    kernel.play;
                } else {
                    kernel.play.position = 0;
                };
            };
            if (false){
                5;
                PlayKernelEvent.PlayStart;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PlayStart);
            };
            return;
            /*not popped
            PlayKernelEvent.PlayStart
            */
            /*not popped
            kernel
            */
        }
        protected function nextQuality():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Number = this.getNextQuality(kernel.play.quality);
            var _local2 = (_local1 >= 0);
            if (_local2){
                if (false){
                    5;
                    _local1;
                    kernel.play;
                } else {
                    kernel.play.quality = _local1;
                };
                return (!((this.beginQuality == _local1)));
                /*not popped
                _local1
                */
                /*not popped
                kernel.play
                */
            };
            return (_local2);
        }
        private function getNextQuality(_arg1:Number):Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Number = _arg1;
            do  {
                _local2 = ((_local2 + 2) % 3);
                if (_local2 == _arg1){
                    return (-1);
                };
            } while (!(info.video.getQualityValidity(_local2)));
            return (_local2);
        }
        override protected function onPreloadFailed():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Boolean = this.nextQuality();
            if (_local1){
                if (false){
                    5;
                    ;
                } else {
                    preload();
                };
            } else {
                this.preloadFinish = true;
                if (false){
                    5;
                    PlayKernelCode.SpeedTestFailed;
                    ;
                } else {
                    setCode(PlayKernelCode.SpeedTestFailed);
                };
                if (false){
                    5;
                    preloadValue;
                    PlayKernelEvent.PreloadError;
                    kernel;
                } else {
                    kernel.dispatchKernelEvent(PlayKernelEvent.PreloadError, preloadValue);
                };
                if (false){
                    5;
                    this;
                } else {
                    this.checkBeginningFinish();
                };
            };
        }
        override protected function onPreloadSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.preloadFinish = true;
            if (false){
                5;
                PlayKernelCode.Normal;
                ;
            } else {
                setCode(PlayKernelCode.Normal);
            };
            if (false){
                5;
                preloadValue;
                PlayKernelEvent.PreloadSuccess;
                kernel;
            } else {
                kernel.dispatchKernelEvent(PlayKernelEvent.PreloadSuccess, preloadValue);
            };
            if (false){
                5;
                this;
            } else {
                this.checkBeginningFinish();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            preloadValue
            */
            /*not popped
            PlayKernelEvent.PreloadSuccess
            */
            /*not popped
            kernel
            */
            /*not popped
            PlayKernelCode.Normal
            */
        }
        private function onShowADFinish(_arg1:Event):void{
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
                this.checkBeginningFinish();
            };
            return;
            /*not popped
            this
            */
        }
        private function checkBeginningFinish():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Class;
            if (((kernel.play.beginADFinish) && (this.preloadFinish))){
                if (player.isNormal){
                    if (false){
                        5;
                        PlayKernelEvent.BeginningFinished;
                        kernel;
                    } else {
                        kernel.dispatchKernelEvent(PlayKernelEvent.BeginningFinished);
                    };
                    if (false){
                        5;
                        new FirstPlaying();
                        kernel;
                    } else {
                        kernel.changeState(new FirstPlaying());
                    };
                } else {
                    if (code == PlayKernelCode.SpeedTestFailed){
                        _local1 = Reconnect4BeginningPreloadError;
                    };
                    if (false){
                        5;
                        new PreloadWaiting(player.code, _local1);
                        kernel;
                    } else {
                        kernel.changeState(new PreloadWaiting(player.code, _local1));
                    };
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            BeginningPreloading
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
