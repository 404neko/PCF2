package com.bokecc.platform.playkernel.model.player.monitor {
    import flash.events.*;
    import com.bokecc.lib.media.core.videocore.*;
    import com.bokecc.lib.media.utils.*;

    public class VideoMonitor extends MediaMonitor {

        public function VideoMonitor(_arg1:IEventDispatcher=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
        }
        public function get core():IVideoCore{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (media.primaryData);
        }
        public function get currentByteLoaded():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (media){
                if (this.core){
                    return (this.core.bytesLoaded);
                };
            };
            return (NaN);
        }
        public function get byteTotal():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Meta;
            if (media){
                _local1 = media.info;
                if (_local1){
                    return (_local1.filesize);
                };
            };
            return (NaN);
        }
        public function get loadFinish():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (media){
                if (this.core){
                    return (this.core.loadFinish);
                };
            };
            return (false);
        }

        if (37 == 34){
            return;
            /*not popped
            VideoMonitor
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
}//package com.bokecc.platform.playkernel.model.player.monitor 
