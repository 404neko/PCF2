package com.bokecc.lib.media.source {

    public interface IPlaySource {

        function get index():uint;
        function get url():String;
        function get size():uint;
        function set size(_arg1:uint):void;
        function get duration():Number;
        function set duration(_arg1:Number):void;
        function get length():uint;
        function addSource(_arg1:String, _arg2:uint=0, _arg3:Number=0):void;
        function getSource(_arg1:int=0):IPlaySource;
        function getSourceByTime(_arg1:Number):IPlaySource;
        function percent2index(_arg1:Number):int;
        function setPrev(_arg1:Number, _arg2:uint):void;
        function get prevDuration():Number;
        function get prevSize():uint;
        function set(_arg1:String, _arg2):void;
        function get(_arg1:String);
        function del(_arg1:String):void;

    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
    //unresolved jump
}//package com.bokecc.lib.media.source 
