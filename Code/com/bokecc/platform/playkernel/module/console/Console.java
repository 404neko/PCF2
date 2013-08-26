package com.bokecc.platform.playkernel.module.console {
    import flash.events.*;
    import com.bokecc.platform.playkernel.core.*;
    import flash.ui.*;
    import com.bokecc.framework.mvc.*;
    import com.bokecc.platform.playkernel.module.logger.items.base.*;
    import flash.utils.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.platform.playkernel.module.logger.*;

    public class Console extends Mediator {

        public static const NAME:String = "PlayKernel.Mediator.Console";

        private var kernel:KernelProxy;
        private var parser:ScriptParser;
        private var pw:String = "";

        public function Console(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME, new ConsoleUI());
            this.parser = new ScriptParser(this);
        }
        public function get player():PlayerProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((model.proxy(PlayerProxy.NAME) as PlayerProxy));
        }
        public function get info():InfoProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((model.proxy(InfoProxy.NAME) as InfoProxy));
        }
        public function get ui():ConsoleUI{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (displayObject);
        }
        public function get log():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local4:int;
            var _local5:LogData;
            if (false){
                5;
                this.ui;
            } else {
                this.ui.clear();
            };
            var _local1 = "";
            var _local2:LoggerData = (model.proxy(LoggerData.NAME) as LoggerData);
            var _local3:int = _local2.length;
            if (_local3 > 0){
            } else {
                //unresolved jump
            };
            if (false){
                5;
                0;
            } else {
                _local4 = 0;
            };
            if (_local4 >= _local3){
            } else {
                //unresolved jump
            };
            //unresolved jump
            if (false){
                5;
                _local2.getLogData(_local4);
            } else {
                _local5 = _local2.getLogData(_local4);
            };
            if (false){
                5;
                (_local1 + (SystemUtil.newline + _local5.toString()));
            } else {
                _local1 = (_local1 + (SystemUtil.newline + _local5.toString()));
            };
            _local4++;
            //unresolved if
            return (_local1);
            /*not popped
            (_local1 + (SystemUtil.newline + _local5.toString()))
            */
            /*not popped
            _local2.getLogData(_local4)
            */
            /*not popped
            0
            */
            /*not popped
            this.ui
            */
        }
        public function dump(_arg1:String):String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:XML;
            var _local2:* = this.parser.parse(_arg1);
            if (_local2){
            } else {
                //unresolved jump
            };
            if (false){
                5;
                describeType(_local2);
            } else {
                _local3 = describeType(_local2);
            };
            return (_local3.toXMLString());
            /*not popped
            describeType(_local2)
            */
            return ("");
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.init();
            this.kernel = (model.proxy(KernelProxy.NAME) as KernelProxy);
            if (false){
                5;
                this.onKeyUp;
                KeyboardEvent.KEY_UP;
                this.kernel.document.stage;
            } else {
                this.kernel.document.stage.addEventListener(KeyboardEvent.KEY_UP, this.onKeyUp);
            };
            if (false){
                5;
                this.onInput;
                ConsoleUI.Input;
                this.ui;
            } else {
                this.ui.addEventListener(ConsoleUI.Input, this.onInput);
            };
            return;
            /*not popped
            this.onInput
            */
            /*not popped
            ConsoleUI.Input
            */
            /*not popped
            this.ui
            */
            /*not popped
            this.onKeyUp
            */
            /*not popped
            KeyboardEvent.KEY_UP
            */
            /*not popped
            this.kernel.document.stage
            */
        }
        private function onKeyUp(_arg1:KeyboardEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:int = _arg1.charCode;
            if (_local2 == Keyboard.ENTER){
            } else {
                //unresolved jump
            };
            if (this.pw == "hellocc"){
            } else {
                //unresolved jump
            };
            if (false){
                5;
                this.ui;
                this.kernel.document.stage;
            } else {
                this.kernel.document.stage.addChild(this.ui);
            };
            if (false){
                5;
                true;
                this.ui;
            } else {
                this.ui.inputable = true;
            };
            if (false){
                5;
                this.ui;
            } else {
                this.ui.fullSize();
            };
            this.pw = "";
            if (2 == 3){
                this.pw = (this.pw + String.fromCharCode(_local2));
            };
            return;
            /*not popped
            this.ui
            */
            /*not popped
            true
            */
            /*not popped
            this.ui
            */
            /*not popped
            this.ui
            */
            /*not popped
            this.kernel.document.stage
            */
        }
        private function onInput(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.ui.input;
                this.ui;
            } else {
                this.ui.output(this.ui.input);
            };
            var _local2:* = this.parser.parse(this.ui.input);
            if (_local2 != undefined){
            } else {
                //unresolved jump
            };
            if (false){
                5;
                (" >>> " + _local2);
                this.ui;
            } else {
                this.ui.output((" >>> " + _local2));
            };
            return;
            /*not popped
            (" >>> " + _local2)
            */
            /*not popped
            this.ui
            */
            /*not popped
            this.ui.input
            */
            /*not popped
            this.ui
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Console
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.module.console 
