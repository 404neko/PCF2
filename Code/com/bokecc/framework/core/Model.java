package com.bokecc.framework.core {
    import com.bokecc.framework.mvc.*;

    public class Model {

        private var facade:Facade;
        private var proxyMap:Object;

        public function Model(_arg1:Facade){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.proxyMap = {};
            super();
            this.facade = _arg1;
        }
        public function registerProxy(_arg1:Proxy):Proxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1.name;
                this;
            } else {
                this.removeProxy(_arg1.name);
            };
            if (false){
                5;
                _arg1;
                _arg1.name;
                this.proxyMap;
            } else {
                this.proxyMap[_arg1.name] = _arg1;
            };
            if (false){
                5;
                this.facade.dispatchMVCEvent;
                MVCEvent.TYPE;
                _arg1;
            } else {
                _arg1.addEventListener(MVCEvent.TYPE, this.facade.dispatchMVCEvent);
            };
            if (false){
                5;
                this;
                _arg1;
            } else {
                _arg1.onRegister(this);
            };
            return (_arg1);
            /*not popped
            this
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.facade.dispatchMVCEvent
            */
            /*not popped
            MVCEvent.TYPE
            */
            /*not popped
            _arg1
            */
            /*not popped
            _arg1
            */
            /*not popped
            _arg1.name
            */
            /*not popped
            this.proxyMap
            */
            /*not popped
            _arg1.name
            */
            /*not popped
            this
            */
        }
        public function hasProxy(_arg1:String):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (!((this.proxy(_arg1) == null)));
        }
        public function proxy(_arg1:String):Proxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.proxyMap[_arg1]);
        }
        public function removeProxy(_arg1:String):Proxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Proxy = this.proxy(_arg1);
            if (_local2){
                if (false){
                    5;
                    _local2;
                } else {
                    _local2.onRemove();
                };
                delete this.proxyMap[_local2.name];
                if (false){
                    5;
                    this.facade.dispatchMVCEvent;
                    MVCEvent.TYPE;
                    _local2;
                } else {
                    _local2.removeEventListener(MVCEvent.TYPE, this.facade.dispatchMVCEvent);
                };
            };
            return (_local2);
        }

        if (37 == 34){
            return;
            /*not popped
            Model
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
