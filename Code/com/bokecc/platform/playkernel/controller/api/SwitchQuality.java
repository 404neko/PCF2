package com.bokecc.platform.playkernel.controller.api {
    import com.bokecc.platform.playkernel.core.*;
    import com.bokecc.platform.playkernel.controller.*;
    import com.bokecc.platform.playkernel.model.state.preloading.*;

    public class SwitchQuality extends BasicCommand {

        public function SwitchQuality(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super();
        }
        override protected function executeCommand(_arg1:CommandEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Number = _arg1.value("quality");
            if (((((((!(isNaN(_local2))) && ((_local2 >= 0)))) && ((_local2 <= 2)))) && (!((_local2 == play.quality))))){
                if (false){
                    5;
                    player.position;
                    play;
                } else {
                    play.position = player.position;
                };
                if (false){
                    5;
                    player.paused;
                    play;
                } else {
                    play.paused = player.paused;
                };
                if (false){
                    5;
                    _local2;
                    play;
                } else {
                    play.quality = _local2;
                };
                if (false){
                    5;
                    new SwitchQualityPreloading();
                    ;
                } else {
                    changeState(new SwitchQualityPreloading());
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            SwitchQuality
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
