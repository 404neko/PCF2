package com.bokecc.platform.playkernel.model.player {
    import com.bokecc.lib.media.source.*;
    import com.bokecc.lib.data.*;

    public class PlayServer extends PlaySource {

        public static const SameIsp:String = "server.sameisp";
        public static const Isp:String = "server.isp";
        public static const Mode:String = "server.mode";
        public static const Quality:String = "server.quality";
        public static const Priority:String = "server.priority";
        public static const Domain:String = "server.domain";
        private static const Param:String = "server.param";

        public function PlayServer(_arg1:String, _arg2:uint=0, _arg3:uint=0, _arg4:uint=0){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1, _arg2, _arg3, _arg4);
        }
        override public function get url():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (!isNull(this.param)){
                return (((_url + (((_url.indexOf("?") == -1)) ? "?" : "&")) + this.param));
            };
            return (_url);
        }
        public function get param():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (get(Param));
        }
        public function set param(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                Param;
                ;
            } else {
                set(Param, _arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            Param
            */
        }
        public function get sameIsp():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (get(SameIsp));
        }
        public function get isp():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (get(Isp));
        }
        public function get quality():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (get(Quality));
        }
        public function get priority():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (get(Priority));
        }
        public function get domain():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (get(Domain));
        }
        public function get mode():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (get(Mode));
        }

        if (37 == 34){
            return;
            /*not popped
            PlayServer
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.player 
