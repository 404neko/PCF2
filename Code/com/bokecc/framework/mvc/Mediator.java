package com.bokecc.framework.mvc {
    import flash.events.*;
    import com.bokecc.framework.core.*;

    public class Mediator extends EventDispatcher {

        private var _name:String;
        private var _displayObject;
        private var _model:Model;
        private var _view:View;

        public function Mediator(_arg1:String, _arg2=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this._name = _arg1;
            this.displayObject = _arg2;
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
        public function get displayObject(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._displayObject);
        }
        public function set displayObject(_arg1):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._displayObject = _arg1;
        }
        protected function get model():Model{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._model);
        }
        protected function get view():View{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._view);
        }
        public function get events():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ([]);
        }
        public function eventHandler(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }
        final public function onRegister(_arg1:Model, _arg2:View):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this._model = _arg1;
            this._view = _arg2;
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
            //unresolved jump
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
            Mediator
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
