package com.bokecc.platform.playkernel.controller.api {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.controller.*;
    import com.bokecc.platform.playkernel.model.state.playing.*;

    public class Seek4Finished extends BasicCommand {

        public function Seek4Finished(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
        }
        override protected function executeCommand(_arg1:CommandEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:* = _arg1.value("finish");
            if ((((_local2 == null)) || (_local2))){
                if (false){
                    5;
                    _arg1.value("position");
                    play;
                } else {
                    play.position = _arg1.value("position");
                };
                if (false){
                    5;
                    new RePlaying();
                    ;
                } else {
                    changeState(new RePlaying());
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            Seek4Finished
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.controller.api 
