package com.bokecc.lib.net.loader {
    import flash.events.*;

    public interface ILoader extends IEventDispatcher {

        function set url(_arg1:String):void;
        function set method(_arg1:String):void;
        function set param(_arg1:Object):void;
        function load(_arg1:Number=60000):void;
        function unload():void;
        function get content();
        function get error():Boolean;
        function get valid():Boolean;
        function get loading():Boolean;
        function get requestTime():Number;

    }
}//package com.bokecc.lib.net.loader 
