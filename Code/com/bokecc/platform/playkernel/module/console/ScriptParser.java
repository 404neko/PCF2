package com.bokecc.platform.playkernel.module.console {

    public class ScriptParser {

        private var main:Console;
        private var i:int = 0;
        private var value:String;
        private var target;
        private var error:Boolean;

        public function ScriptParser(_arg1:Console){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this.main = _arg1;
        }
        public function parse(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var value:* = _arg1;
            if (false){
                5;
                value;
                this;
            } else {
                this.value = value;
            };
            this.i = 0;
            this.target = this.main;
            this.error = false;
            try {
                if (false){
                    5;
                    this;
                } else {
                    this.readTarget();
                };
            } catch(e:Error) {
                return ("parse error");
                /*not popped
                this
                */
                /*not popped
                value
                */
                /*not popped
                this
                */
            };
            if (this.error){
                return ("target not found");
                /*not popped
                this
                */
                /*not popped
                value
                */
                /*not popped
                this
                */
            };
            return (this.target);
            /*not popped
            this
            */
            /*not popped
            value
            */
            /*not popped
            this
            */
        }
        private function readTarget():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:String;
            var _local2:Boolean;
            var _local3:String;
            if (this.i < this.value.length){
                _local1 = "";
                _local2 = true;
                while (((_local2) && ((this.i < this.value.length)))) {
                    _local3 = this.read();
                    /*switch (){
                            if (false){
                                5;
                                false;
                                _local1;
                                this;
                            } else {
                                this.getTarget(_local1, false);
                            };
                            _local2 = false;
                            break;
                            if (false){
                                5;
                                false;
                                _local1;
                                this;
                            } else {
                                this.readParam(_local1, false);
                            };
                            _local2 = false;
                            break;
                            if (false){
                                5;
                                true;
                                _local1;
                                this;
                            } else {
                                this.readParam(_local1, true);
                            };
                            _local2 = false;
                            break;
                            break;
                            if (_local1 != ""){
                                if (false){
                                    5;
                                    false;
                                    _local1;
                                    this;
                                } else {
                                    this.getTarget(_local1, false);
                                };
                            };
                            _local1 = "";
                            _local2 = false;
                            break;
                            _local1 = (_local1 + _local3);
                            if (this.i >= this.value.length){
                                if (false){
                                    5;
                                    false;
                                    _local1;
                                    this;
                                } else {
                                    this.getTarget(_local1, false);
                                };
                            };
                    }*/;
                };
            };
        }
        private function readParam(_arg1:String, _arg2:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var v:* = null;
            var paramValue:* = undefined;
            var targetName:* = _arg1;
            var setter:* = _arg2;
            var params:* = [];
            var param:* = "";
            var loop:* = true;
            while (((loop) && ((this.i < this.value.length)))) {
                v = this.read();
                /*switch (){
                        if (false){
                            5;
                            this.getParam(param);
                            params;
                        } else {
                            params.push(this.getParam(param));
                        };
                        param = "";
                        break;
                        if (param != ""){
                            if (false){
                                5;
                                this.getParam(param);
                                params;
                            } else {
                                params.push(this.getParam(param));
                            };
                            param = "";
                        };
                        if (false){
                            5;
                            params;
                            true;
                            targetName;
                            this;
                        } else {
                            this.getTarget(targetName, true, params);
                        };
                        loop = false;
                        break;
                        break;
                        param = (param + v);
                        if (this.i < this.value.length){
                            break;
                        };
                        if (setter){
                            try {
                                paramValue = this.getParam(param);
                                if (false){
                                    5;
                                    paramValue;
                                    targetName;
                                    this.target;
                                } else {
                                    this.target[targetName] = paramValue;
                                };
                                this.target = this.target[targetName];
                            } catch(e:Error) {
                                error = true;
                            };
                        };
                        loop = false;
                }*/;
            };
        }
        private function getParam(_arg1:String){
            var _local2:Number;
            switch (_arg1){
                case "null":
                    return (null);
                case "NaN":
                    return (NaN);
                case "true":
                    return (true);
                case "false":
                    return (false);
                default:
                    _local2 = Number(_arg1);
                    return (((isNaN(_local2)) ? _arg1 : _local2));
            };
        }
        private function getTarget(_arg1:String, _arg2:Boolean, _arg3:Array=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local4:Function;
            if (this.target.hasOwnProperty(_arg1)){
                if (_arg2){
                    _local4 = this.target[_arg1];
                    if (_local4 != null){
                        this.target = _local4.apply(null, _arg3);
                        if (false){
                            5;
                            this;
                        } else {
                            this.readTarget();
                        };
                    } else {
                        this.error = true;
                    };
                } else {
                    this.target = this.target[_arg1];
                    if (false){
                        5;
                        this;
                    } else {
                        this.readTarget();
                    };
                };
            } else {
                this.error = true;
            };
        }
        private function read():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.value.charAt(this.i++));
        }

        if (37 == 34){
            return;
            /*not popped
            ScriptParser
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
    //unresolved jump
}//package com.bokecc.platform.playkernel.module.console 
