package com.bokecc.platform.playkernel.core.playerview {
    import flash.events.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.lib.net.loader.*;

    public class SwfView extends PlayerView {

        private var swf:SWFProxy;

        public function SwfView(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.onRemove();
            if (this.swf){
                if (false){
                    5;
                    this.onSWFComplete;
                    Event.COMPLETE;
                    this.swf;
                } else {
                    this.swf.removeEventListener(Event.COMPLETE, this.onSWFComplete);
                };
                if (false){
                    5;
                    this.onLoadError;
                    IOErrorEvent.IO_ERROR;
                    this.swf;
                } else {
                    this.swf.removeEventListener(IOErrorEvent.IO_ERROR, this.onLoadError);
                };
                if (false){
                    5;
                    this.onLoadError;
                    SecurityErrorEvent.SECURITY_ERROR;
                    this.swf;
                } else {
                    this.swf.removeEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onLoadError);
                };
                if (this.swf.valid){
                    if (false){
                        5;
                        "destroy";
                        this.swf;
                    } else {
                        this.swf.call("destroy");
                    };
                    if (false){
                        5;
                        this.swf;
                    } else {
                        this.swf.unload();
                    };
                };
                this.swf = null;
            };
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
            this.swf = new SWFProxy(url);
            if (false){
                5;
                this.onSWFComplete;
                Event.COMPLETE;
                this.swf;
            } else {
                this.swf.addEventListener(Event.COMPLETE, this.onSWFComplete);
            };
            if (false){
                5;
                this.onLoadError;
                IOErrorEvent.IO_ERROR;
                this.swf;
            } else {
                this.swf.addEventListener(IOErrorEvent.IO_ERROR, this.onLoadError);
            };
            if (false){
                5;
                this.onLoadError;
                SecurityErrorEvent.SECURITY_ERROR;
                this.swf;
            } else {
                this.swf.addEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onLoadError);
            };
            if (false){
                5;
                10000;
                this.swf;
            } else {
                this.swf.load(10000);
            };
            return;
            /*not popped
            10000
            */
            /*not popped
            this.swf
            */
            /*not popped
            this.onLoadError
            */
            /*not popped
            SecurityErrorEvent.SECURITY_ERROR
            */
            /*not popped
            this.swf
            */
            /*not popped
            this.onLoadError
            */
            /*not popped
            IOErrorEvent.IO_ERROR
            */
            /*not popped
            this.swf
            */
            /*not popped
            this.onSWFComplete
            */
            /*not popped
            Event.COMPLETE
            */
            /*not popped
            this.swf
            */
        }
        private function onLoadError(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                ;
            } else {
                setLoadError();
            };
            return;
        }
        private function onSWFComplete(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                ;
            } else {
                setLoadSuccess();
            };
            return;
        }
        override public function initView():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.initView();
            if (false){
                5;
                this.onViewInitialized;
                PlayViewEvent.Initialized;
                this.swf;
            } else {
                this.swf.addSWFEventListener(PlayViewEvent.Initialized, this.onViewInitialized);
            };
            if (false){
                5;
                this.onViewInitError;
                PlayViewEvent.InitError;
                this.swf;
            } else {
                this.swf.addSWFEventListener(PlayViewEvent.InitError, this.onViewInitError);
            };
            if (false){
                5;
                kernel.document;
                "init";
                this.swf;
            } else {
                this.swf.call("init", kernel.document);
            };
            return;
            /*not popped
            kernel.document
            */
            /*not popped
            "init"
            */
            /*not popped
            this.swf
            */
            /*not popped
            this.onViewInitError
            */
            /*not popped
            PlayViewEvent.InitError
            */
            /*not popped
            this.swf
            */
            /*not popped
            this.onViewInitialized
            */
            /*not popped
            PlayViewEvent.Initialized
            */
            /*not popped
            this.swf
            */
        }
        private function onViewInitError(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                ;
            } else {
                setInitializeError();
            };
            return;
        }
        private function onViewInitialized(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                this.swf.getProperty("config");
                ;
            } else {
                setInitializeSuccess(this.swf.getProperty("config"));
            };
            return;
            /*not popped
            this.swf.getProperty("config")
            */
        }

        if (37 == 34){
            return;
            /*not popped
            SwfView
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
