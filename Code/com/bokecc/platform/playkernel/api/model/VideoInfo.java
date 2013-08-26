package com.bokecc.platform.playkernel.api.model {

    public class VideoInfo extends ObjectProxy {

        public function VideoInfo(_arg1:Object=null){
            super(_arg1);
        }
        public function getQualityValidity(_arg1:Number):Boolean{
            return (callFunction("getQualityValidity", [_arg1]));
        }
        public function get qualityValidity():Array{
            var _local1:Array = [];
            var _local2:int;
            while (_local2 < 3) {
                _local1.push(((this.getQualityValidity(_local2)) ? 1 : 0));
                _local2++;
            };
            return (_local1);
        }
        public function get highestPriority():int{
            return (numberProperty("highestPriority", 0));
        }
        public function get version():String{
            return (stringProperty("version"));
        }
        public function get upid():String{
            return (stringProperty("upid"));
        }
        public function get isLocked():Boolean{
            return (booleanProperty("isLocked"));
        }
        public function get forumName():String{
            return (stringProperty("forumName"));
        }
        public function get domainURL():String{
            return (stringProperty("domainURL"));
        }
        public function get traffic():Boolean{
            return (booleanProperty("traffic"));
        }
        public function get videoURL():String{
            return (stringProperty("videoURL"));
        }
        public function get status():int{
            return (numberProperty("status"));
        }
        public function get isValid():Boolean{
            return (booleanProperty("isValid"));
        }
        public function get title():String{
            return (stringProperty("title"));
        }
        public function get hasAddr():Boolean{
            return (booleanProperty("hasAddr"));
        }
        public function get pageAddr():String{
            return (stringProperty("pageAddr"));
        }
        public function get cid():String{
            return (stringProperty("cid"));
        }
        public function get tag():String{
            return (stringProperty("tag"));
        }
        public function get defaultquality():int{
            return (numberProperty("defaultquality"));
        }
        public function get imgPath():String{
            return (stringProperty("imgPath"));
        }
        public function get downloadPath():String{
            return (stringProperty("downloadPath"));
        }
        public function get descriptionUrl():String{
            return (stringProperty("descriptionUrl"));
        }
        public function get videomarks():XMLList{
            return ((objectProperty("videomarks", null) as XMLList));
        }
        public function get opreason():String{
            return (stringProperty("opreason"));
        }

    }
}//package com.bokecc.platform.playkernel.api.model 
