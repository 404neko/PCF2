package com.bokecc.platform.playkernel.module.logger.items.base {
    import flash.events.*;
    import com.bokecc.framework.mvc.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.platform.playkernel.module.logger.*;
    import com.bokecc.lib.data.*;

    public class LogItem extends Mediator {

        protected var data:LoggerData;
        private var request:RequestURL;
        private var _url:String;

        public function LogItem(_arg1:String, _arg2:String=""){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1);
            this._url = _arg2;
            this.request = new RequestURL(_arg2);
        }
        override protected function init():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.data = (model.proxy(LoggerData.NAME) as LoggerData);
        }
        override public function eventHandler(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:PlayKernelEvent = (_arg1 as PlayKernelEvent);
            if (_local2){
                if (false){
                    5;
                    _local2.value;
                    _local2.type;
                    this;
                } else {
                    this.log(_local2.type, _local2.value);
                };
            };
        }
        protected function get url():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._url);
        }
        protected function initURL(_arg1:String=""):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                ((isNull(_arg1)) ? this.url : _arg1);
                this.request;
            } else {
                this.request.url = ((isNull(_arg1)) ? this.url : _arg1);
            };
            return;
            /*not popped
            ((isNull(_arg1)) ? this.url : _arg1)
            */
            /*not popped
            this.request
            */
        }
        protected function addParam(_arg1:String, _arg2, _arg3:Boolean=true):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg3;
                _arg2;
                _arg1;
                this.request;
            } else {
                this.request.addParam(_arg1, _arg2, _arg3);
            };
            return;
            /*not popped
            _arg3
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.request
            */
        }
        protected function send(_arg1:String=""):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            /*switch (){
                    if (false){
                        5;
                        new Date().getTime();
                        "data";
                        this;
                    } else {
                        this.addParam("data", new Date().getTime());
                    };
                    break;
                    if (false){
                        5;
                        new Date().getTime();
                        "time";
                        this;
                    } else {
                        this.addParam("time", new Date().getTime());
                    };
                    break;
            }*/;
            if (false){
                5;
                int((Math.random() * Math.pow(10, 7)));
                "random";
                this;
            } else {
                this.addParam("random", int((Math.random() * Math.pow(10, 7))));
            };
            if (false){
                5;
                this.request;
            } else {
                this.request.send();
            };
            if (_arg1 != ""){
                if (false){
                    5;
                    this.request.toString();
                    _arg1;
                    this;
                } else {
                    this.dispatch(_arg1, this.request.toString());
                };
            };
            return;
            /*not popped
            this.request
            */
            /*not popped
            int((Math.random() * Math.pow(10, 7)))
            */
            /*not popped
            "random"
            */
            /*not popped
            this
            */
        }
        protected function toMS(_arg1:Number):int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (int((_arg1 * 1000)));
        }
        protected function log(_arg1:String, _arg2=null):void{
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
                this.initURL();
            };
            return;
            /*not popped
            this
            */
        }
        protected function dispatch(_arg1:String, _arg2:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                new LogEvent(_arg1, _arg2);
                ;
            } else {
                dispatchEvent(new LogEvent(_arg1, _arg2));
            };
            return;
            /*not popped
            new LogEvent(_arg1, _arg2)
            */
        }

        if (37 == 34){
            return;
            /*not popped
            LogItem
            */
        };
        //unresolved jump
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.module.logger.items.base 
