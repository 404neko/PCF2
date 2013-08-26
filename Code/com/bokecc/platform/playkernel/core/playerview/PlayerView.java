package com.bokecc.platform.playkernel.core.playerview {
    import flash.events.*;
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.controller.*;
    import com.bokecc.framework.mvc.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.model.state.ready.*;

    public class PlayerView extends Mediator {

        public static const PureAPIMode:String = "http://player.bokecc.com/platform/pureapi";
        public static const NAME:String = "PlayKernel.Mediator.View";

        private var _url:String;
        protected var kernel:KernelProxy;
        protected var viewProxy:ViewProxy;

        public function PlayerView(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME);
            this._url = _arg1;
        }
        public static function getView(_arg1:String):PlayerView{
            if (37 == 34){
                return;
                /*not popped
                PlayerView
                */
            };
            if (_arg1 == PureAPIMode){
                return (new PureAPIView());
            };
            return (new SwfView(_arg1));
        }

        public function get url():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._url);
        }
        override public function get events():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return ([CommandEvent.SendKernelEvent]);
        }
        override public function eventHandler(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:String;
            var _local4:*;
            var _local2:CommandEvent = (_arg1 as CommandEvent);
            if (_local2){
                _local3 = _local2.value("code");
                _local4 = _local2.value("value");
                if (false){
                    5;
                    new PlayKernelEvent(_local3, _local4);
                    this.kernel.document;
                } else {
                    this.kernel.document.dispatchEvent(new PlayKernelEvent(_local3, _local4));
                };
            };
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                0;
                0;
                this.kernel.displayObject;
            } else {
                this.kernel.displayObject.move(0, 0);
            };
            return;
            /*not popped
            0
            */
            /*not popped
            0
            */
            /*not popped
            this.kernel.displayObject
            */
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.kernel = (model.proxy(KernelProxy.NAME) as KernelProxy);
            this.viewProxy = new ViewProxy();
            if (false){
                5;
                new CommandEvent(CommandEvent.StateChange, this.viewProxy);
                ;
            } else {
                dispatchEvent(new CommandEvent(CommandEvent.StateChange, this.viewProxy));
            };
            if (false){
                5;
                this;
            } else {
                this.setLoadBegin();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            new CommandEvent(CommandEvent.StateChange, this.viewProxy)
            */
        }
        public function initView():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this;
            } else {
                this.setInitializeBegin();
            };
            return;
            /*not popped
            this
            */
        }
        protected function setLoadBegin():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.viewProxy;
            } else {
                this.viewProxy.setLoadBegin();
            };
            return;
            /*not popped
            this.viewProxy
            */
        }
        protected function setLoadSuccess():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.viewProxy;
            } else {
                this.viewProxy.setLoadSuccess();
            };
            if (false){
                5;
                this;
            } else {
                this.initView();
            };
            return;
            /*not popped
            this
            */
            /*not popped
            this.viewProxy
            */
        }
        protected function setLoadError():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                this.viewProxy;
            } else {
                this.viewProxy.setLoadError();
            };
            return;
            /*not popped
            this.viewProxy
            */
        }
        protected function setInitializeBegin():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.viewProxy;
            } else {
                this.viewProxy.setInitializeBegin();
            };
            return;
            /*not popped
            this.viewProxy
            */
        }
        protected function setInitializeSuccess(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this.viewProxy;
            } else {
                this.viewProxy.setInitializeSuccess(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.viewProxy
            */
        }
        protected function setInitializeError():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.viewProxy;
            } else {
                this.viewProxy.setInitializeError();
            };
            return;
            /*not popped
            this.viewProxy
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayerView
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.core.playerview 
