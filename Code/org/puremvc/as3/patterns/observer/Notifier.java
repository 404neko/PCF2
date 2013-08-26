package org.puremvc.as3.patterns.observer {
    import org.puremvc.as3.interfaces.*;
    import org.puremvc.as3.patterns.facade.*;

    public class Notifier implements INotifier {

        protected var facade:IFacade;

        public function Notifier(){
            this.facade = Facade.getInstance();
            super();
        }
        public function sendNotification(_arg1:String, _arg2:Object=null, _arg3:String=null):void{
            this.facade.sendNotification(_arg1, _arg2, _arg3);
        }

    }
}//package org.puremvc.as3.patterns.observer 
