package com.bokecc.lib.media.core.videocore {
    import flash.events.*;
    import flash.net.*;

    public interface IVideoCore extends IEventDispatcher {

        function get connection():Connection;
        function get ns():NetStream;
        function get meta():Meta;
        function play(_arg1:String, _arg2:String="", _arg3:String=null):void;
        function pause():void;
        function resume():void;
        function seek(_arg1:Number):void;
        function stop():void;
        function get position():Number;
        function get duration():Number;
        function get loadFinish():Boolean;
        function get bytesLoaded():uint;
        function get bytesTotal():uint;
        function get bufferLength():Number;
        function set bufferTime(_arg1:Number):void;
        function get bufferTime():Number;
        function set volume(_arg1:Number):void;
        function get volume():Number;

    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.core.videocore 
