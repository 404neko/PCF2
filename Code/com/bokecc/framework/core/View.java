package com.bokecc.framework.core {
    import com.bokecc.framework.mvc.*;

    public class View {

        private var facade:Facade;
        private var mediatorMap:Object;

        public function View(_arg1:Facade){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.mediatorMap = {};
            super();
            this.facade = _arg1;
        }
        public function registerMediator(_arg1:Mediator):Mediator{
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
                this.removeMediator(_arg1.name);
            };
            if (false){
                5;
                _arg1;
                _arg1.name;
                this.mediatorMap;
            } else {
                this.mediatorMap[_arg1.name] = _arg1;
            };
            if (false){
                5;
                true;
                _arg1;
                this;
            } else {
                this.enabledEvent(_arg1, true);
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
                this.facade.model;
                _arg1;
            } else {
                _arg1.onRegister(this.facade.model, this);
            };
            return (_arg1);
            /*not popped
            this
            */
            /*not popped
            this.facade.model
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
            true
            */
            /*not popped
            _arg1
            */
            /*not popped
            this
            */
            /*not popped
            _arg1
            */
            /*not popped
            _arg1.name
            */
            /*not popped
            this.mediatorMap
            */
            /*not popped
            _arg1.name
            */
            /*not popped
            this
            */
        }
        public function hasMediator(_arg1:String):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (!((this.mediator(_arg1) == null)));
        }
        public function mediator(_arg1:String):Mediator{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.mediatorMap[_arg1]);
        }
        public function removeMediator(_arg1:String):Mediator{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Mediator = this.mediator(_arg1);
            if (_local2){
                if (false){
                    5;
                    _local2;
                } else {
                    _local2.onRemove();
                };
                delete this.mediatorMap[_local2.name];
                if (false){
                    5;
                    false;
                    _local2;
                    this;
                } else {
                    this.enabledEvent(_local2, false);
                };
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
        protected function enabledEvent(_arg1:Mediator, _arg2:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:Function;
            var _local7:String;
            if (_arg2){
                _local3 = this.facade.addEventListener;
            } else {
                _local3 = this.facade.removeEventListener;
            };
            var _local4:Array = _arg1.events;
            var _local5:int = _local4.length;
            var _local6:int;
            if (_local6 >= _local5){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local7 = _local4[_local6];
            if (false){
                5;
                [_local7, _arg1.eventHandler];
                null;
                _local3;
            } else {
                _local3.apply(null, [_local7, _arg1.eventHandler]);
            };
            _local6++;
            //unresolved if
            return;
            /*not popped
            [_local7, _arg1.eventHandler]
            */
            /*not popped
            null
            */
            /*not popped
            _local3
            */
        }

        if (37 == 34){
            return;
            /*not popped
            View
            */
        };
        //unresolved jump
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.framework.core 
