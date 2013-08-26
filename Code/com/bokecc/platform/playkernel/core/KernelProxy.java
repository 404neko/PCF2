package com.bokecc.platform.playkernel.core {
    import com.bokecc.framework.core.*;
    import com.bokecc.platform.playkernel.*;
    import flash.display.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.platform.playkernel.core.display.*;
    import com.bokecc.platform.playkernel.core.playerad.*;
    import com.bokecc.platform.playkernel.model.info.*;
    import com.bokecc.platform.playkernel.controller.*;
    import com.bokecc.framework.mvc.*;
    import com.bokecc.platform.playkernel.core.playerview.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.controller.api.*;
    import com.bokecc.platform.playkernel.module.logger.*;

    public class KernelProxy extends Proxy {

        public static const API_Reset:String = "reset";
        public static const API_Startup:String = "startup";
        public static const API_ListPlay:String = "listPlay";
        public static const API_Preload:String = "preload";
        public static const API_Start:String = "start";
        public static const API_Seek:String = "seek";
        public static const API_Pause:String = "pause";
        public static const API_SetQuality:String = "setQuality";
        public static const API_Reconnect:String = "reconnect";
        public static const NAME:String = "PlayKernel.Proxy.Kernel";

        private var _facade:Facade;
        private var _loader:DisplayObject;
        private var _document:PlayKernel;
        private var _media:Media;
        private var _playerDelegation:PlayerDelegation;
        private var _overlayer:Overlayer;
        private var _ad:ADProxy;

        public function KernelProxy(_arg1:PlayKernel, _arg2:Facade){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._media = new Media();
            this._overlayer = new Overlayer();
            super(NAME, {});
            this._playerDelegation = new PlayerDelegation(this.media, this.overlayer);
            this._document = _arg1;
            this._loader = _arg1.parent.parent;
            this._facade = _arg2;
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.media;
                this.document;
            } else {
                this.document.addChild(this.media);
            };
            if (false){
                5;
                this.overlayer;
                this.document;
            } else {
                this.document.addChild(this.overlayer);
            };
            this._ad = new ADProxy(this.overlayer, (model.proxy(InfoProxy.NAME) as InfoProxy));
            if (false){
                5;
                Startup;
                API_Startup;
                this;
            } else {
                this.registerAPI(API_Startup, Startup);
            };
            if (false){
                5;
                Reset;
                API_Reset;
                this;
            } else {
                this.registerAPI(API_Reset, Reset);
            };
            return;
            /*not popped
            Reset
            */
            /*not popped
            API_Reset
            */
            /*not popped
            this
            */
            /*not popped
            Startup
            */
            /*not popped
            API_Startup
            */
            /*not popped
            this
            */
            /*not popped
            this.overlayer
            */
            /*not popped
            this.document
            */
            /*not popped
            this.media
            */
            /*not popped
            this.document
            */
        }
        public function get loader():DisplayObject{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._loader);
        }
        public function get document():PlayKernel{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._document);
        }
        public function get media():Media{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._media);
        }
        public function get displayObject():PlayerDelegation{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._playerDelegation);
        }
        public function get ad():ADProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._ad);
        }
        public function get overlayer():Overlayer{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._overlayer);
        }
        public function get lowlayer():Sprite{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.overlayer.lowlayer);
        }
        public function get highlayer():Sprite{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.overlayer.highlayer);
        }
        public function initPlayerView(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:PlayerView;
            var _local2:String = this.viewURL;
            if (_local2 != _arg1){
            } else {
                //unresolved jump
            };
            if (false){
                5;
                PlayerView.getView(_arg1);
                this._facade;
            } else {
                this._facade.registerMediator(PlayerView.getView(_arg1));
            };
            if (2 == 3){
                if (false){
                    5;
                    (this._facade.mediator(PlayerView.NAME) as PlayerView);
                } else {
                    _local3 = (this._facade.mediator(PlayerView.NAME) as PlayerView);
                };
                if (false){
                    5;
                    _local3;
                } else {
                    _local3.initView();
                };
            };
            return;
            /*not popped
            PlayerView.getView(_arg1)
            */
            /*not popped
            this._facade
            */
        }
        public function get viewURL():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:PlayerView = (this._facade.mediator(PlayerView.NAME) as PlayerView);
            if ((_local1 == null)){
            } else {
                //unresolved jump
            };
            //unresolved jump
            return (_local1.url);
            /*not popped
            ""
            */
        }
        public function initLogger():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (!this._facade.hasMediator(Logger.NAME)){
            } else {
                //unresolved jump
            };
            if (false){
                5;
                new Logger();
                this._facade;
            } else {
                this._facade.registerMediator(new Logger());
            };
            return;
            /*not popped
            new Logger()
            */
            /*not popped
            this._facade
            */
        }
        public function removeLogger():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this._facade.hasMediator(Logger.NAME)){
            } else {
                //unresolved jump
            };
            if (false){
                5;
                Logger.NAME;
                this._facade;
            } else {
                this._facade.removeMediator(Logger.NAME);
            };
            return;
            /*not popped
            Logger.NAME
            */
            /*not popped
            this._facade
            */
        }
        public function get starter():StarterProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((model.proxy(StarterProxy.NAME) as StarterProxy));
        }
        public function get play():PlayProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((model.proxy(PlayProxy.NAME) as PlayProxy));
        }
        public function changeState(_arg1:PlayerState):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new CommandEvent(CommandEvent.StateChange, _arg1);
                ;
            } else {
                dispatchEvent(new CommandEvent(CommandEvent.StateChange, _arg1));
            };
            return;
            /*not popped
            new CommandEvent(CommandEvent.StateChange, _arg1)
            */
        }
        public function dispatchKernelEvent(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new PlayKernelEvent(_arg1, _arg2);
                ;
            } else {
                dispatchEvent(new PlayKernelEvent(_arg1, _arg2));
            };
            if (false){
                5;
                new CommandEvent(CommandEvent.SendKernelEvent, {
                    code:_arg1,
                    value:_arg2
                });
                ;
            } else {
                dispatchEvent(new CommandEvent(CommandEvent.SendKernelEvent, {
                    code:_arg1,
                    value:_arg2
                }));
            };
            return;
            /*not popped
            new CommandEvent(CommandEvent.SendKernelEvent, {
                code:_arg1,
                value:_arg2
            })
            */
            /*not popped
            new PlayKernelEvent(_arg1, _arg2)
            */
        }
        public function hasAPI(_arg1:String):Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.map[_arg1]);
        }
        public function registerAPI(_arg1:String, _arg2:Class):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                true;
                _arg1;
                this.map;
            } else {
                this.map[_arg1] = true;
            };
            if (false){
                5;
                _arg2;
                _arg1;
                this._facade;
            } else {
                this._facade.registerCommand(_arg1, _arg2);
            };
            return;
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this._facade
            */
            /*not popped
            true
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.map
            */
        }
        public function removeAPI(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            delete this.map[_arg1];
            if (false){
                5;
                _arg1;
                this._facade;
            } else {
                this._facade.removeCommand(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this._facade
            */
        }
        public function callAPI(_arg1:String, _arg2:Object=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasAPI(_arg1)){
            } else {
                //unresolved jump
            };
            if (false){
                5;
                new CommandEvent(_arg1, _arg2);
                ;
            } else {
                dispatchEvent(new CommandEvent(_arg1, _arg2));
            };
            return;
            /*not popped
            new CommandEvent(_arg1, _arg2)
            */
        }
        private function get map():Object{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (data);
        }

        if (37 == 34){
            return;
            /*not popped
            KernelProxy
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
