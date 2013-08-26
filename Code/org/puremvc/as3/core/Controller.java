package org.puremvc.as3.core {
    import org.puremvc.as3.interfaces.*;
    import org.puremvc.as3.patterns.observer.*;

    public class Controller implements IController {

        protected static var instance:IController;

        protected const SINGLETON_MSG:String = "Controller Singleton already constructed!";

        protected var view:IView;
        protected var commandMap:Array;

        public function Controller(){
            if (instance != null){
                throw (Error(this.SINGLETON_MSG));
            };
            instance = this;
            this.commandMap = new Array();
            this.initializeController();
        }
        public static function getInstance():IController{
            if (instance == null){
                instance = new (Controller)();
            };
            return (instance);
        }

        protected function initializeController():void{
            this.view = View.getInstance();
        }
        public function executeCommand(_arg1:INotification):void{
            var _local2:Class = this.commandMap[_arg1.getName()];
            if (_local2 == null){
                return;
            };
            var _local3:ICommand = new (_local2)();
            _local3.execute(_arg1);
        }
        public function registerCommand(_arg1:String, _arg2:Class):void{
            if (this.commandMap[_arg1] == null){
                this.view.registerObserver(_arg1, new Observer(this.executeCommand, this));
            };
            this.commandMap[_arg1] = _arg2;
        }
        public function hasCommand(_arg1:String):Boolean{
            return (!((this.commandMap[_arg1] == null)));
        }
        public function removeCommand(_arg1:String):void{
            if (this.hasCommand(_arg1)){
                this.view.removeObserver(_arg1, this);
                this.commandMap[_arg1] = null;
            };
        }

    }
}//package org.puremvc.as3.core 
