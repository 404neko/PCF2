package org.puremvc.as3.interfaces {

    public interface IObserver {

        function setNotifyMethod(_arg1:Function):void;
        function setNotifyContext(_arg1:Object):void;
        function notifyObserver(_arg1:INotification):void;
        function compareNotifyContext(_arg1:Object):Boolean;

    }
}//package org.puremvc.as3.interfaces 
