package com.bokecc.lib.media.core.video {
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.videocore.*;
    import com.bokecc.lib.media.source.*;

    public class FLV extends Video {

        public function FLV(_arg1:IPlaySource, _arg2:IVideoCore=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super(_arg1, _arg2);
        }
        override protected function serverSeek():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Number;
            var _local3:Number;
            var _local4:String;
            var _local1:Boolean = ((meta) && (meta.hasKeyframes));
            if (_local1){
                _local2 = meta.getKeyframeIndex(seekEnd);
                seekEnd = meta.getTime(_local2);
                _local3 = meta.getFileposition(_local2);
                _local4 = (((file.indexOf("?") > 0)) ? "&" : "?");
                _local4 = (_local4 + ("start=" + _local3));
                if (false){
                    5;
                    _local4;
                    ;
                } else {
                    nsPlay(_local4);
                };
                if (false){
                    5;
                    _local3;
                    seekEnd;
                    ;
                } else {
                    setBufferStart(seekEnd, _local3);
                };
            };
            return (_local1);
        }
        override protected function initNetStatusHandler():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.initNetStatusHandler();
            if (false){
                5;
                this.onNetStatus_GetFileType;
                MediaEvent.GetFileType;
                ;
            } else {
                addNetStatusHandler(MediaEvent.GetFileType, this.onNetStatus_GetFileType);
            };
            return;
            /*not popped
            this.onNetStatus_GetFileType
            */
            /*not popped
            MediaEvent.GetFileType
            */
        }
        protected function onNetStatus_GetFileType(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1["fileType"];
                MediaEvent.GetFileType;
                ;
            } else {
                dispatch(MediaEvent.GetFileType, _arg1["fileType"]);
            };
            return;
            /*not popped
            _arg1["fileType"]
            */
            /*not popped
            MediaEvent.GetFileType
            */
        }

        if (37 == 34){
            return;
            /*not popped
            FLV
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
}//package com.bokecc.lib.media.core.video 
