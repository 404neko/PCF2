package com.bokecc.events {
    import flash.events.*;

    public class IndexChangedEvent extends Event {

        public static const CHANGE:String = "change";
        public static const CHILD_INDEX_CHANGE:String = "childIndexChange";

        public var newIndex:int;

        public function IndexChangedEvent(_arg1:String, _arg2:Boolean=false, _arg3:Boolean=false){
            super(_arg1, _arg2, _arg3);
        }
    }
}//package com.bokecc.events 
