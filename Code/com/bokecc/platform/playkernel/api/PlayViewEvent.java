package com.bokecc.platform.playkernel.api {
    import flash.events.*;

    public class PlayViewEvent extends Event {

        public static const LoadStart:String = "PlayKernel.PlayerView.LoadStart";
        public static const LoadComplete:String = "PlayKernel.PlayerView.LoadComplete";
        public static const LoadError:String = "PlayKernel.PlayerView.LoadError";
        public static const InitStart:String = "PlayKernel.PlayerView.InitStart";
        public static const Initialized:String = "PlayKernel.PlayerView.Initialized";
        public static const InitError:String = "PlayKernel.PlayerView.InitError";

        private var _value;

        public function PlayViewEvent(_arg1:String, _arg2=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
            this._value = _arg2;
        }
        public function get value(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._value);
        }
        override public function clone():Event{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (new PlayViewEvent(type, this.value));
        }

        if (37 == 34){
            return;
            /*not popped
            PlayViewEvent
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.api 
