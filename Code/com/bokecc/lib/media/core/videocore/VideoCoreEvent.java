package com.bokecc.lib.media.core.videocore {
    import flash.events.*;

    public class VideoCoreEvent extends Event {

        public static const NetConnectionStatus:String = "VideoCore.NetConnectionStatus";
        public static const NetStreamStatus:String = "VideoCore.NetStreamStatus";
        public static const MetaData:String = "VideoCore.MetaData";

        private var _info:Object;

        public function VideoCoreEvent(_arg1:String, _arg2:Object){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
            this._info = _arg2;
        }
        public function get info():Object{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._info);
        }
        override public function clone():Event{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (new VideoCoreEvent(type, this.info));
        }

        if (37 == 34){
            return;
            /*not popped
            VideoCoreEvent
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.core.videocore 
