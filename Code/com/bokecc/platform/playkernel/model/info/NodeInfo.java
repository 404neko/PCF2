package com.bokecc.platform.playkernel.model.info {

    public class NodeInfo {

        private var _videoid:String;
        private var _title:String;
        private var _playtime:String;
        private var _imgurl:String;

        public function NodeInfo(_arg1:XML){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this._videoid = _arg1["videoid"][0];
            this._title = _arg1["title"][0];
            this._playtime = _arg1["playtime"][0];
            this._imgurl = _arg1["imgurl"][0];
        }
        public function get videoid():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._videoid);
        }
        public function get title():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._title);
        }
        public function get playtime():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._playtime);
        }
        public function get imgurl():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._imgurl);
        }
        public function toObject():Object{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ({
                videoid:this.videoid,
                title:this.title,
                playtime:this.playtime,
                imgurl:this.imgurl
            });
        }

        if (37 == 34){
            return;
            /*not popped
            NodeInfo
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.info 
