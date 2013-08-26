package com.bokecc.platform.playkernel {
    import flash.events.*;
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.framework.core.*;
    import flash.display.*;
    import com.bokecc.platform.playkernel.module.console.*;
    import com.bokecc.platform.playkernel.controller.*;
    import flash.system.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.platform.playkernel.model.state.closed.*;

    public class PlayKernel extends Sprite {

        private var facade:Facade;
        private var infoProxy:InfoProxy;
        private var kernel:KernelProxy;
        private var playerProxy:PlayerProxy;

        public function PlayKernel(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            if (false){
                5;
                "*";
                Security;
            } else {
                Security.allowDomain("*");
            };
            var _local1:ContextMenuUtil = new ContextMenuUtil(this, true);
            if (false){
                5;
                false;
                "PlayKernel2.0 Build:20130821";
                _local1;
            } else {
                _local1.addItem("PlayKernel2.0 Build:20130821", false);
            };
            if (false){
                5;
                this.onAddedToStage;
                Event.ADDED_TO_STAGE;
                ;
            } else {
                addEventListener(Event.ADDED_TO_STAGE, this.onAddedToStage);
            };
            return;
            /*not popped
            this.onAddedToStage
            */
            /*not popped
            Event.ADDED_TO_STAGE
            */
            /*not popped
            false
            */
            /*not popped
            "PlayKernel2.0 Build:20130821"
            */
            /*not popped
            _local1
            */
            /*not popped
            "*"
            */
            /*not popped
            Security
            */
        }
        protected function onAddedToStage(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                this.onAddedToStage;
                Event.ADDED_TO_STAGE;
                ;
            } else {
                removeEventListener(Event.ADDED_TO_STAGE, this.onAddedToStage);
            };
            if (false){
                5;
                StageAlign.TOP_LEFT;
                stage;
            } else {
                stage.align = StageAlign.TOP_LEFT;
            };
            if (false){
                5;
                StageScaleMode.NO_SCALE;
                stage;
            } else {
                stage.scaleMode = StageScaleMode.NO_SCALE;
            };
            this.facade = new Facade();
            this.infoProxy = (this.facade.registerProxy(new InfoProxy()) as InfoProxy);
            this.kernel = (this.facade.registerProxy(new KernelProxy(this, this.facade)) as KernelProxy);
            this.playerProxy = (this.facade.registerProxy(new PlayerProxy()) as PlayerProxy);
            if (false){
                5;
                SetPlayerState;
                CommandEvent.StateChange;
                this.facade;
            } else {
                this.facade.registerCommand(CommandEvent.StateChange, SetPlayerState);
            };
            if (false){
                5;
                new Console();
                this.facade;
            } else {
                this.facade.registerMediator(new Console());
            };
            if (false){
                5;
                new AllClosed();
                this.kernel;
            } else {
                this.kernel.changeState(new AllClosed());
            };
            if (false){
                5;
                PlayKernelEvent.KernelInitialized;
                this.kernel;
            } else {
                this.kernel.dispatchKernelEvent(PlayKernelEvent.KernelInitialized);
            };
            return;
            /*not popped
            PlayKernelEvent.KernelInitialized
            */
            /*not popped
            this.kernel
            */
            /*not popped
            new AllClosed()
            */
            /*not popped
            this.kernel
            */
            /*not popped
            new Console()
            */
            /*not popped
            this.facade
            */
            /*not popped
            SetPlayerState
            */
            /*not popped
            CommandEvent.StateChange
            */
            /*not popped
            this.facade
            */
            /*not popped
            StageScaleMode.NO_SCALE
            */
            /*not popped
            stage
            */
            /*not popped
            StageAlign.TOP_LEFT
            */
            /*not popped
            stage
            */
            /*not popped
            this.onAddedToStage
            */
            /*not popped
            Event.ADDED_TO_STAGE
            */
        }
        public function get info():InfoProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.infoProxy);
        }
        public function get player():PlayerProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.playerProxy);
        }
        public function call(_arg1:String, _arg2:Object=null):void{
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
                this.kernel;
            } else {
                this.kernel.callAPI(_arg1, _arg2);
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.kernel
            */
        }
        public function startup(_arg1:Object):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                _arg1;
                this.player;
            } else {
                this.player.startup(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.player
            */
        }
        public function reset():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                this.player;
            } else {
                this.player.reset();
            };
            return;
            /*not popped
            this.player
            */
        }

        if (37 == 34){
            return;
            /*not popped
            PlayKernel
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel 
