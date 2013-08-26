package com.bokecc.platform.playkernel.model.state.ready {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.api.*;

    public class VideoInfoVerify extends PlayerState {

        public static const NAME:String = "PlayKernel.State.VideoInfoVerify";

        public function VideoInfoVerify(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super(NAME);
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:Boolean;
            super.init();
            var _local1:int = PlayKernelCode.Normal;
            var _local2:Boolean = ((this.isVunionLoader) && (this.isVunionPage));
            if (_local2){
                _local1 = this.videoStatusCode;
            } else {
                if (info.video.isLocked){
                    _local1 = PlayKernelCode.AccLocked;
                } else {
                    if (info.video.traffic){
                        _local1 = PlayKernelCode.NoTraffic;
                    } else {
                        if (info.video.status == 0){
                            _local3 = ((info.user.isBusinessUsers) && (info.isSelfSite));
                            if (((info.video.isValid) && (!(_local3)))){
                                _local1 = PlayKernelCode.Auditing;
                            };
                        } else {
                            _local1 = this.videoStatusCode;
                        };
                    };
                };
            };
            if ((((_local1 == PlayKernelCode.Normal)) && ((kernel.play.serverLength <= 0)))){
                _local1 = PlayKernelCode.NoVideo;
            };
            if (false){
                5;
                _local1;
                this;
            } else {
                this.setCode(_local1);
            };
            if ((((_code == PlayKernelCode.Normal)) || (info.isValidatedUser))){
                if (false){
                    5;
                    new WaitStart();
                    kernel;
                } else {
                    kernel.changeState(new WaitStart());
                };
            } else {
                if (false){
                    5;
                    PlayKernelEvent.PlayInfoVerifyError;
                    kernel;
                } else {
                    kernel.dispatchKernelEvent(PlayKernelEvent.PlayInfoVerifyError);
                };
                if (false){
                    5;
                    _local1;
                    PlayKernelEvent.PlayerError;
                    kernel;
                } else {
                    kernel.dispatchKernelEvent(PlayKernelEvent.PlayerError, _local1);
                };
            };
            return;
            /*not popped
            _local1
            */
            /*not popped
            this
            */
        }
        override protected function setCode(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.setCode(_arg1);
            if (false){
                5;
                _arg1;
                kernel.play;
            } else {
                kernel.play.videoStatus = _arg1;
            };
            if (false){
                5;
                info.video.defaultquality;
                kernel.play;
            } else {
                kernel.play.quality = info.video.defaultquality;
            };
            return;
            /*not popped
            info.video.defaultquality
            */
            /*not popped
            kernel.play
            */
            /*not popped
            _arg1
            */
            /*not popped
            kernel.play
            */
        }
        private function get videoStatusCode():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:int = PlayKernelCode.Normal;
            /*switch (){
                    break;
                    _local1 = PlayKernelCode.Processing;
                    break;
                    _local1 = PlayKernelCode.Deleted;
                    break;
                    _local1 = PlayKernelCode.InfoError;
            }*/;
            return (_local1);
        }
        private function get isVunionPage():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return ((info.param.referer.indexOf("http://vunion.bokecc.com") == 0));
        }
        private function get isVunionLoader():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((info.param.loadertype == 100));
        }

        if (37 == 34){
            return;
            /*not popped
            VideoInfoVerify
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
