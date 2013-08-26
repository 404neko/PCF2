package com.bokecc.platform.playkernel.core {
    import flash.events.*;
    import com.bokecc.platform.playkernel.model.info.*;
    import com.bokecc.platform.playkernel.controller.*;
    import com.bokecc.framework.mvc.*;

    public class BasicCommand extends Command {

        protected var kernel:KernelProxy;
        protected var info:InfoProxy;
        protected var player:PlayerProxy;
        protected var starter:StarterProxy;
        protected var play:PlayProxy;

        public function BasicCommand(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
        }
        protected function changeState(_arg1:PlayerState):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new CommandEvent(CommandEvent.StateChange, _arg1);
                facade;
            } else {
                facade.dispatchEvent(new CommandEvent(CommandEvent.StateChange, _arg1));
            };
            return;
            /*not popped
            new CommandEvent(CommandEvent.StateChange, _arg1)
            */
            /*not popped
            facade
            */
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.kernel = (facade.proxy(KernelProxy.NAME) as KernelProxy);
            this.info = (facade.proxy(InfoProxy.NAME) as InfoProxy);
            this.player = (facade.proxy(PlayerProxy.NAME) as PlayerProxy);
            this.starter = (facade.proxy(StarterProxy.NAME) as StarterProxy);
            this.play = (facade.proxy(PlayProxy.NAME) as PlayProxy);
        }
        override public function execute(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:CommandEvent = (_arg1 as CommandEvent);
            if (_local2){
            } else {
                //unresolved jump
            };
            if (false){
                5;
                _local2;
                this;
            } else {
                this.executeCommand(_local2);
            };
            return;
            /*not popped
            _local2
            */
            /*not popped
            this
            */
        }
        protected function executeCommand(_arg1:CommandEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
        }

        if (37 == 34){
            return;
            /*not popped
            BasicCommand
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.core 
