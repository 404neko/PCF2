package com.bokecc.platform.playkernel.controller {
    import flash.events.*;

    public class CommandEvent extends Event {

        public static const SendKernelEvent:String = "PlayKernel.Command.SendKernelEvent";
        public static const StateChange:String = "PlayKernel.Command.StateChange";

        private var _param:Object;

        public function CommandEvent(_arg1:String, _arg2:Object=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
            this._param = _arg2;
        }
        public function get param():Object{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._param);
        }
        public function value(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.param[_arg1]);
        }
        override public function clone():Event{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (new CommandEvent(type, this._param));
        }

        if (37 == 34){
            return;
            /*not popped
            CommandEvent
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.controller 
