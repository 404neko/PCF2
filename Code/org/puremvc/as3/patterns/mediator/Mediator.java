package org.puremvc.as3.patterns.mediator {
    import org.puremvc.as3.interfaces.*;
    import org.puremvc.as3.patterns.observer.*;

    public class Mediator extends Notifier implements IMediator, INotifier {

        public static const NAME:String = "Mediator";

        protected var mediatorName:String;
        protected var viewComponent:Object;

        public function Mediator(_arg1:String=null, _arg2:Object=null){
            this.mediatorName = ((_arg1)!=null) ? _arg1 : NAME;
            this.viewComponent = _arg2;
        }
        public function getMediatorName():String{
            return (this.mediatorName);
        }
        public function setViewComponent(_arg1:Object):void{
            this.viewComponent = _arg1;
        }
        public function getViewComponent():Object{
            return (this.viewComponent);
        }
        public function listNotificationInterests():Array{
            return ([]);
        }
        public function handleNotification(_arg1:INotification):void{
        }
        public function onRegister():void{
        }
        public function onRemove():void{
        }

    }
}//package org.puremvc.as3.patterns.mediator 
