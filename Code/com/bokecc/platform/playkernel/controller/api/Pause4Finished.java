package com.bokecc.platform.playkernel.controller.api {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.controller.*;
    import com.bokecc.platform.playkernel.model.state.playing.*;

    public class Pause4Finished extends BasicCommand {

        public function Pause4Finished(){
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
            var _local2:Boolean = _arg1.value("flag");
            if (!_local2){
                if (false){
                    5;
                    0;
                    play;
                } else {
                    play.position = 0;
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
            Pause4Finished
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
