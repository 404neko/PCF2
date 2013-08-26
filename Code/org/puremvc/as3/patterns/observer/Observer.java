package org.puremvc.as3.patterns.observer {
    import org.puremvc.as3.interfaces.*;

    public class Observer implements IObserver {

        private var notify:Function;
        private var context:Object;

        public function Observer(_arg1:Function, _arg2:Object){
            this.setNotifyMethod(_arg1);
            this.setNotifyContext(_arg2);
        }
        public function setNotifyMethod(_arg1:Function):void{
            this.notify = _arg1;
        }
        public function setNotifyContext(_arg1:Object):void{
            this.context = _arg1;
        }
        private function getNotifyMethod():Function{
            return (this.notify);
        }
        private function getNotifyContext():Object{
            return (this.context);
        }
        public function notifyObserver(_arg1:INotification):void{
            this.getNotifyMethod().apply(this.getNotifyContext(), [_arg1]);
        }
        public function compareNotifyContext(_arg1:Object):Boolean{
            return ((_arg1 === this.context));
        }

    }
}//package org.puremvc.as3.patterns.observer 
