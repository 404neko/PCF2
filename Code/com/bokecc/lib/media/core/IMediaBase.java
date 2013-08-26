package com.bokecc.lib.media.core {
    import flash.events.*;
    import flash.display.*;

    public interface IMediaBase extends IEventDispatcher {

        function clear():void;
        function enabled(_arg1:Boolean):void;
        function start():void;
        function pause(_arg1=null):void;
        function seek(_arg1:Number, _arg2=null):void;
        function stop():void;
        function setSize(_arg1:Number, _arg2:Number):void;
        function dispatch(_arg1:String, _arg2=null):void;
        function get brightness():Number;
        function get contrast():Number;
        function set brightness(_arg1:Number):void;
        function set contrast(_arg1:Number):void;
        function set scale(_arg1:Number):void;
        function get scale():Number;
        function set zscale(_arg1:Number):void;
        function get zscale():Number;
        function get oscale():Number;
        function get displayObject():DisplayObject;
        function set width(_arg1:Number):void;
        function set height(_arg1:Number):void;
        function get width():Number;
        function get height():Number;
        function set volume(_arg1:Number):void;
        function get volume():Number;
        function set bufferTime(_arg1:Number):void;
        function get bufferTime():Number;
        function get bufferLength():Number;
        function get displayData();
        function get primaryData();
        function get info();
        function get viewPosition():Number;
        function get position():Number;
        function get duration():Number;
        function get bufferStart():Number;
        function get bufferEnd():Number;
        function get playStatus():uint;
        function get waitingStatus():uint;
        function get stopped():Boolean;
        function get playing():Boolean;
        function get paused():Boolean;
        function get waiting():Boolean;
        function get loading():Boolean;
        function get buffering():Boolean;
        function get ready():Boolean;

    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.core 
