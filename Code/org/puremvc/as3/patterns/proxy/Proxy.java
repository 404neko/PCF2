package org.puremvc.as3.patterns.proxy {
    import org.puremvc.as3.interfaces.*;
    import org.puremvc.as3.patterns.observer.*;

    public class Proxy extends Notifier implements IProxy, INotifier {

        public static var NAME:String = "Proxy";

        protected var proxyName:String;
        protected var data:Object;

        public function Proxy(_arg1:String=null, _arg2:Object=null){
            this.proxyName = ((_arg1)!=null) ? _arg1 : NAME;
            if (_arg2 != null){
                this.setData(_arg2);
            };
        }
        public function getProxyName():String{
            return (this.proxyName);
        }
        public function setData(_arg1:Object):void{
            this.data = _arg1;
        }
        public function getData():Object{
            return (this.data);
        }
        public function onRegister():void{
        }
        public function onRemove():void{
        }

    }
}//package org.puremvc.as3.patterns.proxy 
