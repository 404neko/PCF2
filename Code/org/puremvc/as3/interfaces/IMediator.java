package org.puremvc.as3.interfaces {

    public interface IMediator {

        function getMediatorName():String;
        function getViewComponent():Object;
        function setViewComponent(_arg1:Object):void;
        function listNotificationInterests():Array;
        function handleNotification(_arg1:INotification):void;
        function onRegister():void;
        function onRemove():void;

    }
}//package org.puremvc.as3.interfaces 
