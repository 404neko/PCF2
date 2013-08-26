package com.bokecc.platform.playkernel.core.playerad {
    import flash.events.*;

    public class ADEvent extends Event {

        public static const ShowADFinish:String = "AD.ShowFinish";
        public static const ShowADBegin:String = "AD.ShowBegin";
        public static const LoadADBegin:String = "AD.LoadBegin";
        public static const LoadModuleBegin:String = "AD.LoadModuleBegin";
        public static const LoadModuleSuccess:String = "AD.LoadModuleSuccess";
        public static const LoadModuleFailed:String = "AD.LoadModuleFailed";

        private var _adType:String;
        private var _duration:Number;

        public function ADEvent(_arg1:String, _arg2:String, _arg3:Number){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
            this._adType = _arg2;
            this._duration = _arg3;
        }
        public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._duration);
        }
        public function get adType():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._adType);
        }
        override public function clone():Event{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (new ADEvent(type, this.adType, this.duration));
        }

        if (37 == 34){
            return;
            /*not popped
            ADEvent
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.core.playerad 
