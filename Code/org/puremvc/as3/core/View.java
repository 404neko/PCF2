package org.puremvc.as3.core {
    import org.puremvc.as3.interfaces.*;
    import org.puremvc.as3.patterns.observer.*;

    public class View implements IView {

        protected static var instance:IView;

        protected const SINGLETON_MSG:String = "View Singleton already constructed!";

        protected var mediatorMap:Array;
        protected var observerMap:Array;

        public function View(){
            if (instance != null){
                throw (Error(this.SINGLETON_MSG));
            };
            instance = this;
            this.mediatorMap = new Array();
            this.observerMap = new Array();
            this.initializeView();
        }
        public static function getInstance():IView{
            if (instance == null){
                instance = new (View)();
            };
            return (instance);
        }

        protected function initializeView():void{
        }
        public function registerObserver(_arg1:String, _arg2:IObserver):void{
            var _local3:Array = this.observerMap[_arg1];
            if (_local3){
                _local3.push(_arg2);
            } else {
                this.observerMap[_arg1] = [_arg2];
            };
        }
        public function notifyObservers(_arg1:INotification):void{
            var _local2:Array;
            var _local3:Array;
            var _local4:IObserver;
            var _local5:Number;
            if (this.observerMap[_arg1.getName()] != null){
                _local2 = (this.observerMap[_arg1.getName()] as Array);
                _local3 = new Array();
                _local5 = 0;
                while (_local5 < _local2.length) {
                    _local4 = (_local2[_local5] as IObserver);
                    _local3.push(_local4);
                    _local5++;
                };
                _local5 = 0;
                while (_local5 < _local3.length) {
                    _local4 = (_local3[_local5] as IObserver);
                    _local4.notifyObserver(_arg1);
                    _local5++;
                };
            };
        }
        public function removeObserver(_arg1:String, _arg2:Object):void{
            var _local3:Array = (this.observerMap[_arg1] as Array);
            var _local4:int;
            while (_local4 < _local3.length) {
                if (Observer(_local3[_local4]).compareNotifyContext(_arg2) == true){
                    _local3.splice(_local4, 1);
                    break;
                };
                _local4++;
            };
            if (_local3.length == 0){
                delete this.observerMap[_arg1];
            };
        }
        public function registerMediator(_arg1:IMediator):void{
            var _local3:Observer;
            var _local4:Number;
            if (this.mediatorMap[_arg1.getMediatorName()] != null){
                return;
            };
            this.mediatorMap[_arg1.getMediatorName()] = _arg1;
            var _local2:Array = _arg1.listNotificationInterests();
            if (_local2.length > 0){
                _local3 = new Observer(_arg1.handleNotification, _arg1);
                _local4 = 0;
                while (_local4 < _local2.length) {
                    this.registerObserver(_local2[_local4], _local3);
                    _local4++;
                };
            };
            _arg1.onRegister();
        }
        public function retrieveMediator(_arg1:String):IMediator{
            return (this.mediatorMap[_arg1]);
        }
        public function removeMediator(_arg1:String):IMediator{
            var _local3:Array;
            var _local4:Number;
            var _local2:IMediator = (this.mediatorMap[_arg1] as IMediator);
            if (_local2){
                _local3 = _local2.listNotificationInterests();
                _local4 = 0;
                while (_local4 < _local3.length) {
                    this.removeObserver(_local3[_local4], _local2);
                    _local4++;
                };
                delete this.mediatorMap[_arg1];
                _local2.onRemove();
            };
            return (_local2);
        }
        public function hasMediator(_arg1:String):Boolean{
            return (!((this.mediatorMap[_arg1] == null)));
        }

    }
}//package org.puremvc.as3.core 
