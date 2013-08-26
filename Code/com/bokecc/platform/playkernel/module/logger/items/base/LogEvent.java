package com.bokecc.platform.playkernel.module.logger.items.base {
    import flash.events.*;

    public class LogEvent extends Event {

        public static const Flare:String = "Flare";
        public static const Traffic:String = "Traffic";
        public static const Click:String = "Click";
        public static const ALL:String = "LogEvent.TYPE";

        private var _logType:String;
        private var _url:String;

        public function LogEvent(_arg1:String, _arg2:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(ALL);
            this._logType = _arg1;
            this._url = _arg2;
        }
        public function get logType():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._logType);
        }
        public function get url():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._url);
        }
        override public function clone():Event{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (new LogEvent(this.logType, this.url));
        }
        override public function toString():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this.logType + " : ") + this.url));
        }

        if (37 == 34){
            return;
            /*not popped
            LogEvent
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.module.logger.items.base 
