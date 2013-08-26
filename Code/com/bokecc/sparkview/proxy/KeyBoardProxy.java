package com.bokecc.sparkview.proxy {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.lib.utils.*;
    import flash.ui.*;
    import org.puremvc.as3.patterns.proxy.*;
    import com.bokecc.sparkview.command.*;

    public class KeyBoardProxy extends Proxy {

        public static const Name:String = "KeyBoardProxy.Name";

        private var stage:Stage;
        private var forward:Boolean;
        private var pre:Boolean;

        public function KeyBoardProxy(){
            super(Name);
            this.stage = StageUtil.instance.stage;
        }
        override public function onRegister():void{
            this.stage.addEventListener(KeyboardEvent.KEY_DOWN, this.onKeyDown);
            this.stage.addEventListener(KeyboardEvent.KEY_UP, this.onKeyUp);
        }
        protected function onKeyUp(_arg1:KeyboardEvent):void{
            switch (_arg1.keyCode){
                case Keyboard.SPACE:
                    this.sendOperateEvent(OperateEventHandler.Pause);
                    break;
                case Keyboard.LEFT:
                    this.pre = false;
                    this.onProgressOperate();
                    break;
                case Keyboard.RIGHT:
                    this.forward = false;
                    this.onProgressOperate();
                    break;
            };
        }
        protected function onKeyDown(_arg1:KeyboardEvent):void{
            switch (_arg1.keyCode){
                case Keyboard.LEFT:
                    this.pre = true;
                    this.onProgressOperate();
                    break;
                case Keyboard.RIGHT:
                    this.forward = true;
                    this.onProgressOperate();
                    break;
                case Keyboard.UP:
                    this.sendOperateEvent(OperateEventHandler.SetVolume, -1);
                    break;
                case Keyboard.DOWN:
                    this.sendOperateEvent(OperateEventHandler.SetVolume, -2);
                    break;
            };
        }
        private function onProgressOperate():void{
            if (((this.pre) && (this.forward))){
                return;
            };
            var _local1:Boolean = ((!(this.pre)) && (!(this.forward)));
            this.sendOperateEvent(OperateEventHandler.KeyBoardProgressOperate, {
                value:((this.pre) ? -1 : 1),
                finish:_local1
            });
        }
        private function sendOperateEvent(_arg1:String, _arg2=null):void{
            sendNotification(OperateEventHandler.OperateEvent, _arg2, _arg1);
        }

    }
}//package com.bokecc.sparkview.proxy 
