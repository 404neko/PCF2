package com.bokecc.platform.playkernel.module.logger.items.flare {
    import com.bokecc.platform.playkernel.module.logger.items.base.*;

    public class FlareItem extends LogItem {

        public static const URL:String = "http://flare.bokecc.com/flash/playlog";

        public function FlareItem(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(_arg1, URL);
        }
        protected function addFlareParam(_arg1:int, _arg2:Boolean=false):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                String(_arg1);
                "stage";
                ;
            } else {
                addParam("stage", String(_arg1));
            };
            if (false){
                5;
                data.upid;
                "upid";
                ;
            } else {
                addParam("upid", data.upid);
            };
            if (false){
                5;
                data.userid;
                "userid";
                ;
            } else {
                addParam("userid", data.userid);
            };
            if (false){
                5;
                data.videoid;
                "videoid";
                ;
            } else {
                addParam("videoid", data.videoid);
            };
            if (_arg2){
                if (false){
                    5;
                    this;
                } else {
                    this.addPlayParam();
                };
            };
            return;
            /*not popped
            data.videoid
            */
            /*not popped
            "videoid"
            */
            /*not popped
            data.userid
            */
            /*not popped
            "userid"
            */
            /*not popped
            data.upid
            */
            /*not popped
            "upid"
            */
            /*not popped
            String(_arg1)
            */
            /*not popped
            "stage"
            */
        }
        protected function addPlayParam():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                data.play_url;
                "play_url";
                ;
            } else {
                addParam("play_url", data.play_url);
            };
            if (false){
                5;
                data.play_position;
                "play_position";
                ;
            } else {
                addParam("play_position", data.play_position);
            };
            if (false){
                5;
                data.load_start_point;
                "load_start_point";
                ;
            } else {
                addParam("load_start_point", data.load_start_point);
            };
            if (false){
                5;
                data.load_end_point;
                "load_end_point";
                ;
            } else {
                addParam("load_end_point", data.load_end_point);
            };
            return;
            /*not popped
            data.load_end_point
            */
            /*not popped
            "load_end_point"
            */
            /*not popped
            data.load_start_point
            */
            /*not popped
            "load_start_point"
            */
            /*not popped
            data.play_position
            */
            /*not popped
            "play_position"
            */
            /*not popped
            data.play_url
            */
            /*not popped
            "play_url"
            */
        }
        override protected function send(_arg1:String=""):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super.send(LogEvent.Flare);
        }

        if (37 == 34){
            return;
            /*not popped
            FlareItem
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
