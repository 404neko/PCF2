package com.bokecc.lib.media.core.video {
    import com.bokecc.lib.media.core.videocore.*;
    import com.bokecc.lib.media.source.*;

    public class RTMP extends Video {

        public function RTMP(_arg1:IPlaySource){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
        }
        public static function getSrc(_arg1:String):String{
            var _local2:String = _arg1.substr(-4);
            switch (_local2){
                case ".mp4":
                case ".mov":
                case ".aac":
                case ".m4a":
                case ".f4v":
                    return (("mp4:" + _arg1));
                case ".flv":
                    return (_arg1.substr(0, (_arg1.length - 4)));
                default:
                    return (_arg1);
            };
        }

        override protected function parseSrc(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Array = _arg1.split("|", 2);
            if (_local2.length == 2){
                server = _local2[0];
                file = getSrc(_local2[1]);
            };
        }
        override public function get bufferEnd():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (duration);
        }
        override protected function toLocalSeek(_arg1:Boolean, _arg2:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (((_arg2) || (_arg1))){
                if (false){
                    5;
                    this;
                } else {
                    this.localSeek();
                };
            };
        }
        override protected function localSeek():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                ;
            } else {
                setLoading();
            };
            if (false){
                5;
                seekEnd;
                core;
            } else {
                core.seek(seekEnd);
            };
            return;
            /*not popped
            seekEnd
            */
            /*not popped
            core
            */
        }
        override protected function initNetStatusHandler():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super.initNetStatusHandler();
            if (false){
                5;
                this.onNetStatus_PlayComplete;
                NetStatus.PlayComplete;
                ;
            } else {
                addNetStatusHandler(NetStatus.PlayComplete, this.onNetStatus_PlayComplete);
            };
            return;
            /*not popped
            this.onNetStatus_PlayComplete
            */
            /*not popped
            NetStatus.PlayComplete
            */
        }
        protected function onNetStatus_PlayComplete(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                ;
            } else {
                setFinished();
            };
            return;
        }
        override protected function onNetStatus_PlayStop(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }

        if (37 == 34){
            return;
            /*not popped
            RTMP
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.core.video 
