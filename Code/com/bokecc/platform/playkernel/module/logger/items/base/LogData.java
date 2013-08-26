package com.bokecc.platform.playkernel.module.logger.items.base {
    import flash.utils.*;

    public class LogData {

        private var _time:Number;
        private var _name:String;
        private var _value:Object;

        public function LogData(_arg1:String, _arg2:Object=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this._time = getTimer();
            this._name = _arg1;
            this._value = _arg2;
        }
        public function toString():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((("[" + this.time) + "] ") + this.name));
        }
        public function get value():Object{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._value);
        }
        public function get name():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._name);
        }
        public function get time():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._time);
        }

        if (37 == 34){
            return;
            /*not popped
            LogData
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
}//package com.bokecc.platform.playkernel.module.logger.items.base 
