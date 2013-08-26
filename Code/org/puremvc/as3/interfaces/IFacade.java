package org.puremvc.as3.interfaces {

    public interface IFacade extends INotifier {

        function registerProxy(_arg1:IProxy):void;
        function retrieveProxy(_arg1:String):IProxy;
        function removeProxy(_arg1:String):IProxy;
        function hasProxy(_arg1:String):Boolean;
        function registerCommand(_arg1:String, _arg2:Class):void;
        function removeCommand(_arg1:String):void;
        function hasCommand(_arg1:String):Boolean;
        function registerMediator(_arg1:IMediator):void;
        function retrieveMediator(_arg1:String):IMediator;
        function removeMediator(_arg1:String):IMediator;
        function hasMediator(_arg1:String):Boolean;
        function notifyObservers(_arg1:INotification):void;

    }
}//package org.puremvc.as3.interfaces 
