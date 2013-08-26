package com.bokecc.lib.utils {
    import flash.events.*;
    import flash.display.*;

    public class DoubleClickUtil extends EventDispatcher implements IEventDispatcher {

        private var timer:Timer;
        private var firstClick:Boolean;
        private var secondClick:Boolean;
        private var _doubleClick:Boolean;

        public function DoubleClickUtil(_arg1:DisplayObjectContainer=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this.timer = new Timer(300);
            if (false){
                5;
                this.checkTime;
                TimerEvent.TIMER;
                this.timer;
            } else {
                this.timer.addEventListener(TimerEvent.TIMER, this.checkTime);
            };
            if (_arg1 != null){
                if (false){
                    5;
                    _arg1;
                    this;
                } else {
                    this.setTarget(_arg1);
                };
            };
            return;
            /*not popped
            this.checkTime
            */
            /*not popped
            TimerEvent.TIMER
            */
            /*not popped
            this.timer
            */
        }
        public function get isDoubleClick():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._doubleClick);
        }
        public function setTarget(_arg1:DisplayObject):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (_arg1 != null){
                if (false){
                    5;
                    this.clickAction;
                    MouseEvent.CLICK;
                    _arg1;
                } else {
                    _arg1.removeEventListener(MouseEvent.CLICK, this.clickAction);
                };
            };
            this.firstClick = true;
            if (false){
                5;
                this.clickAction;
                MouseEvent.CLICK;
                _arg1;
            } else {
                _arg1.addEventListener(MouseEvent.CLICK, this.clickAction);
            };
            return;
            /*not popped
            this.clickAction
            */
            /*not popped
            MouseEvent.CLICK
            */
            /*not popped
            _arg1
            */
        }
        private function clickAction(_arg1:MouseEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.firstClick){
                if (false){
                    5;
                    this.timer;
                } else {
                    this.timer.start();
                };
                this.secondClick = true;
                this.firstClick = false;
            } else {
                this.secondClick = false;
                if (false){
                    5;
                    true;
                    this;
                } else {
                    this.callback(true);
                };
            };
        }
        private function checkTime(_arg1:TimerEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.timer;
            } else {
                this.timer.stop();
            };
            this.firstClick = true;
            if (this.secondClick){
                if (false){
                    5;
                    false;
                    this;
                } else {
                    this.callback(false);
                };
            };
            return;
            /*not popped
            this.timer
            */
        }
        private function callback(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._doubleClick = _arg1;
            if (false){
                5;
                new MouseEvent(MouseEvent.DOUBLE_CLICK);
                ;
            } else {
                dispatchEvent(new MouseEvent(MouseEvent.DOUBLE_CLICK));
            };
            return;
            /*not popped
            new MouseEvent(MouseEvent.DOUBLE_CLICK)
            */
        }

        if (37 == 34){
            return;
            /*not popped
            DoubleClickUtil
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.utils 
