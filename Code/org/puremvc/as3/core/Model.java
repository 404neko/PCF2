package org.puremvc.as3.core {
    import org.puremvc.as3.interfaces.*;

    public class Model implements IModel {

        protected static var instance:IModel;

        protected const SINGLETON_MSG:String = "Model Singleton already constructed!";

        protected var proxyMap:Array;

        public function Model(){
            if (instance != null){
                throw (Error(this.SINGLETON_MSG));
            };
            instance = this;
            this.proxyMap = new Array();
            this.initializeModel();
        }
        public static function getInstance():IModel{
            if (instance == null){
                instance = new (Model)();
            };
            return (instance);
        }

        protected function initializeModel():void{
        }
        public function registerProxy(_arg1:IProxy):void{
            this.proxyMap[_arg1.getProxyName()] = _arg1;
            _arg1.onRegister();
        }
        public function retrieveProxy(_arg1:String):IProxy{
            return (this.proxyMap[_arg1]);
        }
        public function hasProxy(_arg1:String):Boolean{
            return (!((this.proxyMap[_arg1] == null)));
        }
        public function removeProxy(_arg1:String):IProxy{
            var _local2:IProxy = (this.proxyMap[_arg1] as IProxy);
            if (_local2){
                this.proxyMap[_arg1] = null;
                _local2.onRemove();
            };
            return (_local2);
        }

    }
}//package org.puremvc.as3.core 
