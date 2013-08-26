package com.bokecc.platform.playkernel.model.state.playing {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.platform.playkernel.controller.api.*;
    import com.bokecc.platform.playkernel.model.state.preloading.*;
    import com.bokecc.platform.playkernel.model.state.stopped.*;

    public class PlayingState extends PlayerState {

        public function PlayingState(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
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
                KernelProxy.API_Pause;
                kernel;
            } else {
                kernel.removeAPI(KernelProxy.API_Pause);
            };
            if (false){
                5;
                KernelProxy.API_Seek;
                kernel;
            } else {
                kernel.removeAPI(KernelProxy.API_Seek);
            };
            if (false){
                5;
                KernelProxy.API_SetQuality;
                kernel;
            } else {
                kernel.removeAPI(KernelProxy.API_SetQuality);
            };
            if (false){
                5;
                this.onMediaEvent;
                MediaEvent.ALL;
                kernel.media;
            } else {
                kernel.media.removeEventListener(MediaEvent.ALL, this.onMediaEvent);
            };
            return;
            /*not popped
            this.onMediaEvent
            */
            /*not popped
            MediaEvent.ALL
            */
            /*not popped
            kernel.media
            */
            /*not popped
            KernelProxy.API_SetQuality
            */
            /*not popped
            kernel
            */
            /*not popped
            KernelProxy.API_Seek
            */
            /*not popped
            kernel
            */
            /*not popped
            KernelProxy.API_Pause
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
            super.init();
            if (false){
                5;
                Pause4Playing;
                KernelProxy.API_Pause;
                kernel;
            } else {
                kernel.registerAPI(KernelProxy.API_Pause, Pause4Playing);
            };
            if (false){
                5;
                Seek4Playing;
                KernelProxy.API_Seek;
                kernel;
            } else {
                kernel.registerAPI(KernelProxy.API_Seek, Seek4Playing);
            };
            if (false){
                5;
                SwitchQuality;
                KernelProxy.API_SetQuality;
                kernel;
            } else {
                kernel.registerAPI(KernelProxy.API_SetQuality, SwitchQuality);
            };
            if (false){
                5;
                this.onMediaEvent;
                MediaEvent.ALL;
                kernel.media;
            } else {
                kernel.media.addEventListener(MediaEvent.ALL, this.onMediaEvent);
            };
            if (false){
                5;
                this;
            } else {
                this.playingBegin();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            this.onMediaEvent
            */
            /*not popped
            MediaEvent.ALL
            */
            /*not popped
            kernel.media
            */
            /*not popped
            SwitchQuality
            */
            /*not popped
            KernelProxy.API_SetQuality
            */
            /*not popped
            kernel
            */
            /*not popped
            Seek4Playing
            */
            /*not popped
            KernelProxy.API_Seek
            */
            /*not popped
            kernel
            */
            /*not popped
            Pause4Playing
            */
            /*not popped
            KernelProxy.API_Pause
            */
            /*not popped
            kernel
            */
        }
        protected function playingBegin():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        private function onMediaEvent(_arg1:MediaEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            /*switch (){
                    if (false){
                        5;
                        new EndADTime();
                        kernel;
                    } else {
                        kernel.changeState(new EndADTime());
                    };
                    break;
                    if (false){
                        5;
                        _arg1.value;
                        _arg1.code;
                        kernel;
                    } else {
                        kernel.dispatchKernelEvent(_arg1.code, _arg1.value);
                    };
                    break;
                    if (false){
                        5;
                        kernel.ad;
                    } else {
                        kernel.ad.showPauseAD();
                    };
                    if (false){
                        5;
                        _arg1.value;
                        _arg1.code;
                        kernel;
                    } else {
                        kernel.dispatchKernelEvent(_arg1.code, _arg1.value);
                    };
                    break;
                    kernel.dispatchKernelEvent(_arg1.code, _arg1.value);
                    if (false){
                        5;
                        kernel.ad;
                    } else {
                        kernel.ad.hideAD();
                    };
                    break;
                    if (false){
                        5;
                        _arg1.value;
                        _arg1.code;
                        kernel;
                    } else {
                        kernel.dispatchKernelEvent(_arg1.code, _arg1.value);
                    };
                    if (false){
                        5;
                        player.position;
                        kernel.play;
                    } else {
                        kernel.play.position = player.position;
                    };
                    if (false){
                        5;
                        new PlayReconnectPreloading(_arg1.value["fromFinish"]);
                        kernel;
                    } else {
                        kernel.changeState(new PlayReconnectPreloading(_arg1.value["fromFinish"]));
                    };
                    break;
            }*/;
        }
        override public function get viewPosition():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.viewPosition);
        }
        override public function get position():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.position);
        }
        override public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.duration);
        }
        override public function get bufferStart():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.bufferStart);
        }
        override public function get bufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.bufferEnd);
        }
        override public function get loading():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.loading);
        }
        override public function get playing():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.playing);
        }
        override public function get paused():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.paused);
        }
        override public function get stopped():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.stopped);
        }
        override public function get code():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (_code);
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
        override public function get bufferLength():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (kernel.media.bufferLength);
        }

        if (37 == 34){
            return;
            /*not popped
            PlayingState
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.state.playing 
