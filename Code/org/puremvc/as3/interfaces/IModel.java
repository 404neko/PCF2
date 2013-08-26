package org.puremvc.as3.interfaces {

    public interface IModel {

        function registerProxy(_arg1:IProxy):void;
        function retrieveProxy(_arg1:String):IProxy;
        function removeProxy(_arg1:String):IProxy;
        function hasProxy(_arg1:String):Boolean;

    }
}//package org.puremvc.as3.interfaces 
