package org.puremvc.as3.interfaces {

    public interface IView {

        function registerObserver(_arg1:String, _arg2:IObserver):void;
        function removeObserver(_arg1:String, _arg2:Object):void;
        function notifyObservers(_arg1:INotification):void;
        function registerMediator(_arg1:IMediator):void;
        function retrieveMediator(_arg1:String):IMediator;
        function removeMediator(_arg1:String):IMediator;
        function hasMediator(_arg1:String):Boolean;

    }
}//package org.puremvc.as3.interfaces 
