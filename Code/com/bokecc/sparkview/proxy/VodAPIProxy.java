package com.bokecc.sparkview.proxy {
    import flash.events.*;
    import org.puremvc.as3.interfaces.*;
    import flash.net.*;
    import org.puremvc.as3.patterns.proxy.*;
    import com.bokecc.sparkview.command.*;
    import com.lia.crypto.*;
    import com.bokecc.lib.data.*;

    public class VodAPIProxy extends Proxy implements IProxy {

        public static const Name:String = "VodAPIProxy.Name";

        private var _url:URLRequest;
        private var _enable:Boolean;
        private var _freetime:int;
        private var _message:String;

        public function VodAPIProxy(_arg1:URLRequest){
            super(Name);
            this._url = _arg1;
        }
        override public function onRegister():void{
            var _local1:URLLoader = new URLLoader();
            _local1.addEventListener(Event.COMPLETE, this.onComplete);
            _local1.addEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onError);
            _local1.addEventListener(IOErrorEvent.IO_ERROR, this.onError);
            _local1.load(this._url);
        }
        private function onComplete(_arg1:Event):void{
            var _local2:String = (_arg1.target as URLLoader).data;
            _local2 = AES.decrypt(_local2, "powered by ccvms", AES.BIT_KEY_256);
            var _local3:XML = XML(_local2);
            this._enable = toBoolean(_local3["enable"][0]);
            this._freetime = parseInt(_local3["freetime"][0]);
            this._message = String(_local3["message"][0]);
            sendNotification(VodPlayCommand.VODPlayHandler, true);
        }
        private function onError(_arg1:IOErrorEvent):void{
            sendNotification(VodPlayCommand.VODPlayHandler, false);
        }
        public function get enable():Boolean{
            return (this._enable);
        }
        public function get freetime():int{
            return (this._freetime);
        }
        public function get message():String{
            return (this._message);
        }

    }
}//package com.bokecc.sparkview.proxy 
