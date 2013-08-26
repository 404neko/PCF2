package com.bokecc.framework.core {
    import flash.events.*;

    public class MVCEvent extends Event {

        public static const TYPE:String = "Framework.MVC.Event";

        private var _event:Event;

        public function MVCEvent(_arg1:Event){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super(TYPE);
            this._event = _arg1;
        }
        public function get event():Event{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._event);
        }
        override public function clone():Event{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (new MVCEvent(this.event));
        }

        if (37 == 34){
            return;
            /*not popped
            MVCEvent
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.framework.core 
