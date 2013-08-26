package com.bokecc.lib.media.core.video {
    import com.bokecc.lib.media.core.videocore.*;
    import com.bokecc.lib.media.source.*;
    import com.bokecc.lib.data.*;

    public class MP4 extends Video {

        public function MP4(_arg1:IPlaySource, _arg2:IVideoCore=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
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
            var _local3:String;
            var _local4:Number;
            var _local1 = !((meta == null));
            if (_local1){
                if (meta.hasKeyframes){
                    _local4 = meta.getKeyframeIndex(seekEnd);
                    seekEnd = meta.getTime(_local4);
                    _local2 = meta.getFileposition(_local4);
                } else {
                    seekEnd = Math.floor(Math.max(0, Math.min((duration - 2), seekEnd)));
                    _local2 = Math.floor(((seekEnd / duration) * _local2));
                };
                _local3 = (((file.indexOf("?") > 0)) ? "&" : "?");
                _local3 = (_local3 + ("start=" + seekEnd));
                if (false){
                    5;
                    _local3;
                    ;
                } else {
                    nsPlay(_local3);
                };
                if (false){
                    5;
                    _local2;
                    seekEnd;
                    ;
                } else {
                    setBufferStart(seekEnd, _local2);
                };
            };
            return (_local1);
        }
        override public function get position():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (loading){
                return (seekEnd);
            };
            return (exact((bufferStart + core.position), 3));
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
                setSeeking();
            };
            if (false){
                5;
                (seekEnd - bufferStart);
                core;
            } else {
                core.seek((seekEnd - bufferStart));
            };
            return;
            /*not popped
            (seekEnd - bufferStart)
            */
            /*not popped
            core
            */
        }
        override protected function onMetaData(_arg1:Meta):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                (filesize - core.bytesTotal);
                (duration - core.duration);
                ;
            } else {
                setBufferStart((duration - core.duration), (filesize - core.bytesTotal));
            };
            return;
            /*not popped
            (filesize - core.bytesTotal)
            */
            /*not popped
            (duration - core.duration)
            */
        }

        if (37 == 34){
            return;
            /*not popped
            MP4
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
