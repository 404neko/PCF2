package com.bokecc.framework.mvc {
    import flash.events.*;
    import com.bokecc.framework.core.*;

    public class Proxy extends EventDispatcher {

        private var _name:String;
        private var _data;
        private var _model:Model;

        public function Proxy(_arg1:String, _arg2=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this._name = _arg1;
            this.data = _arg2;
        }
        public function get data(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._data);
        }
        public function set data(_arg1):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._data = _arg1;
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
        public function get model():Model{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._model);
        }
        final public function onRegister(_arg1:Model):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._model = _arg1;
            if (false){
                5;
                this;
            } else {
                this.init();
            };
            return;
            /*not popped
            this
            */
        }
        protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        override public function dispatchEvent(_arg1:Event):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (super.dispatchEvent(new MVCEvent(_arg1)));
        }

        if (37 == 34){
            return;
            /*not popped
            Proxy
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.framework.mvc 
