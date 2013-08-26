package com.bokecc.player.events {
    import flash.events.*;

    public class DownloadePanelEvent extends Event {

        public static const DOWNLOADE:String = "downloade";
        public static const COPY:String = "copyDownloadeUrl";

        public var downloadeUrl:String;

        public function DownloadePanelEvent(_arg1:String, _arg2:String, _arg3:Boolean=false, _arg4:Boolean=false){
            super(_arg1, _arg3, _arg4);
            this.downloadeUrl = _arg2;
        }
        override public function clone():Event{
            return (new DownloadePanelEvent(this.type, this.downloadeUrl, this.bubbles, this.cancelable));
        }

    }
}//package com.bokecc.player.events 
