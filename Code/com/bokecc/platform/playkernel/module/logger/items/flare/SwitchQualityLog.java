package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.platform.playkernel.model.player.*;
    import com.bokecc.platform.playkernel.api.*;

    public class SwitchQualityLog extends FlareItem {

        public static const NAME:String = "Flare.SwitchQualityLog";

        private var media:MediaProxy;

        public function SwitchQualityLog(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME);
        }
        override public function get events():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ([PlayKernelEvent.PreloadSuccess, PlayKernelEvent.SwitchQualitySuccess, PlayKernelEvent.ReconnectSuccess]);
        }
        override protected function log(_arg1:String, _arg2=null):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local3:MediaGroup = _arg2["group"];
            var _local4:MediaProxy = this.media;
            this.media = _arg2["result"];
            if ((((_local3.type == PlayKernelEvent.SwitchQualitySuccess)) && (!((_local4 == null))))){
                if (false){
                    5;
                    ;
                } else {
                    initURL();
                };
                if (false){
                    5;
                    37;
                    ;
                } else {
                    addFlareParam(37);
                };
                if (false){
                    5;
                    _local4.source.url.split("?")[0];
                    "source_url";
                    ;
                } else {
                    addParam("source_url", _local4.source.url.split("?")[0]);
                };
                if (false){
                    5;
                    this.media.source.url.split("?")[0];
                    "destination_url";
                    ;
                } else {
                    addParam("destination_url", this.media.source.url.split("?")[0]);
                };
                if (false){
                    5;
                    ;
                } else {
                    send();
                };
            };
        }

        if (37 == 34){
            return;
            /*not popped
            SwitchQualityLog
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.module.logger.items.flare 
