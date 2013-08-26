package org.puremvc.as3.interfaces {

    public interface IController {

        function registerCommand(_arg1:String, _arg2:Class):void;
        function executeCommand(_arg1:INotification):void;
        function removeCommand(_arg1:String):void;
        function hasCommand(_arg1:String):Boolean;

    }
}//package org.puremvc.as3.interfaces 
