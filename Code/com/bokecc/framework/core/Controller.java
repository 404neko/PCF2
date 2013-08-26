package com.bokecc.framework.core {
    import flash.events.*;
    import com.bokecc.framework.mvc.*;

    public class Controller {

        protected var facade:Facade;
        private var commandMap:Object;

        public function Controller(_arg1:Facade){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.commandMap = {};
            super();
            this.facade = _arg1;
        }
        public function hasCommand(_arg1:String):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (!((this.commandMap[_arg1] == null)));
        }
        public function registerCommand(_arg1:String, _arg2:Class):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg2;
                _arg1;
                this.commandMap;
            } else {
                this.commandMap[_arg1] = _arg2;
            };
            if (false){
                5;
                this.executeCommand;
                _arg1;
                this.facade;
            } else {
                this.facade.addEventListener(_arg1, this.executeCommand);
            };
            return;
            /*not popped
            this.executeCommand
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.facade
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.commandMap
            */
        }
        public function removeCommand(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            delete this.commandMap[_arg1];
            if (false){
                5;
                this.executeCommand;
                _arg1;
                this.facade;
            } else {
                this.facade.removeEventListener(_arg1, this.executeCommand);
            };
            return;
            /*not popped
            this.executeCommand
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.facade
            */
        }
        protected function executeCommand(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:String = _arg1.type;
            var _local3:Class = this.commandMap[_local2];
            var _local4:Command = new (_local3)();
            if (false){
                5;
                this.facade;
                _local4;
            } else {
                _local4.onCreate(this.facade);
            };
            if (false){
                5;
                _arg1;
                _local4;
            } else {
                _local4.execute(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            _local4
            */
            /*not popped
            this.facade
            */
            /*not popped
            _local4
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Controller
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
