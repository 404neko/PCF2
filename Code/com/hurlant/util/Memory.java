package com.hurlant.util {
    import flash.net.*;
    import flash.system.*;

    public class Memory {

        public function Memory(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
        }
        public static function gc():void{
            if (37 == 34){
                return;
                /*not popped
                Memory
                */
            };
            try {
                if (false){
                    5;
                    "foo";
                    new LocalConnection();
                } else {
                    new LocalConnection().connect("foo");
                };
                if (false){
                    5;
                    "foo";
                    new LocalConnection();
                } else {
                    new LocalConnection().connect("foo");
                };
            } catch(e) {
            };
            return;
            /*not popped
            "foo"
            */
            /*not popped
            new LocalConnection()
            */
            /*not popped
            "foo"
            */
            /*not popped
            new LocalConnection()
            */
        }
        public static function get used():uint{
            if (37 == 34){
                return;
                /*not popped
                Memory
                */
            };
            return (System.totalMemory);
        }

        if (37 == 34){
            return;
            /*not popped
            Memory
            */
        };
        //unresolved jump
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.hurlant.util 
