package org.puremvc.as3.patterns.facade {
    import org.puremvc.as3.interfaces.*;
    import org.puremvc.as3.core.*;
    import org.puremvc.as3.patterns.observer.*;

    public class Facade implements IFacade {

        protected static var instance:IFacade;

        protected const SINGLETON_MSG:String = "Facade Singleton already constructed!";

        protected var controller:IController;
        protected var model:IModel;
        protected var view:IView;

        public function Facade(){
            if (instance != null){
                throw (Error(this.SINGLETON_MSG));
            };
            instance = this;
            this.initializeFacade();
        }
        public static function getInstance():IFacade{
            if (instance == null){
                instance = new (Facade)();
            };
            return (instance);
        }

        protected function initializeFacade():void{
            this.initializeModel();
            this.initializeController();
            this.initializeView();
        }
        protected function initializeController():void{
            if (this.controller != null){
                return;
            };
            this.controller = Controller.getInstance();
        }
        protected function initializeModel():void{
            if (this.model != null){
                return;
            };
            this.model = Model.getInstance();
        }
        protected function initializeView():void{
            if (this.view != null){
                return;
            };
            this.view = View.getInstance();
        }
        public function registerCommand(_arg1:String, _arg2:Class):void{
            this.controller.registerCommand(_arg1, _arg2);
        }
        public function removeCommand(_arg1:String):void{
            this.controller.removeCommand(_arg1);
        }
        public function hasCommand(_arg1:String):Boolean{
            return (this.controller.hasCommand(_arg1));
        }
        public function registerProxy(_arg1:IProxy):void{
            this.model.registerProxy(_arg1);
        }
        public function retrieveProxy(_arg1:String):IProxy{
            return (this.model.retrieveProxy(_arg1));
        }
        public function removeProxy(_arg1:String):IProxy{
            var _local2:IProxy;
            if (this.model != null){
                _local2 = this.model.removeProxy(_arg1);
            };
            return (_local2);
        }
        public function hasProxy(_arg1:String):Boolean{
            return (this.model.hasProxy(_arg1));
        }
        public function registerMediator(_arg1:IMediator):void{
            if (this.view != null){
                this.view.registerMediator(_arg1);
            };
        }
        public function retrieveMediator(_arg1:String):IMediator{
            return ((this.view.retrieveMediator(_arg1) as IMediator));
        }
        public function removeMediator(_arg1:String):IMediator{
            var _local2:IMediator;
            if (this.view != null){
                _local2 = this.view.removeMediator(_arg1);
            };
            return (_local2);
        }
        public function hasMediator(_arg1:String):Boolean{
            return (this.view.hasMediator(_arg1));
        }
        public function sendNotification(_arg1:String, _arg2:Object=null, _arg3:String=null):void{
            this.notifyObservers(new Notification(_arg1, _arg2, _arg3));
        }
        public function notifyObservers(_arg1:INotification):void{
            if (this.view != null){
                this.view.notifyObservers(_arg1);
            };
        }

    }
}//package org.puremvc.as3.patterns.facade 
