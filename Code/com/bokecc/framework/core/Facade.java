package com.bokecc.framework.core {
    import flash.events.*;
    import com.bokecc.framework.mvc.*;

    public class Facade extends EventDispatcher {

        private var _model:Model;
        private var _view:View;
        private var _controller:Controller;

        public function Facade(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this._model = this.newModel();
            this._view = this.newView();
            this._controller = this.newController();
        }
        protected function newModel():Model{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (new Model(this));
        }
        protected function newView():View{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (new View(this));
        }
        protected function newController():Controller{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (new Controller(this));
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
        public function get view():View{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._view);
        }
        public function get controller():Controller{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._controller);
        }
        public function proxy(_arg1:String):Proxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.model.proxy(_arg1));
        }
        public function mediator(_arg1:String):Mediator{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.view.mediator(_arg1));
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
        public function hasMediator(_arg1:String):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (!((this.mediator(_arg1) == null)));
        }
        public function hasCommand(_arg1:String):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.controller.hasCommand(_arg1));
        }
        public function registerProxy(_arg1:Proxy):Proxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this.model.registerProxy(_arg1));
        }
        public function registerMediator(_arg1:Mediator):Mediator{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.view.registerMediator(_arg1));
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
                this.controller;
            } else {
                this.controller.registerCommand(_arg1, _arg2);
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.controller
            */
        }
        public function removeProxy(_arg1:String):Proxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.model.removeProxy(_arg1));
        }
        public function removeMediator(_arg1:String):Mediator{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.view.removeMediator(_arg1));
        }
        public function removeCommand(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.controller;
            } else {
                this.controller.removeCommand(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.controller
            */
        }
        public function dispatchMVCEvent(_arg1:MVCEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1.event;
                ;
            } else {
                dispatchEvent(_arg1.event);
            };
            return;
            /*not popped
            _arg1.event
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Facade
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
