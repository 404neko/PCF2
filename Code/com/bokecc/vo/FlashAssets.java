package com.bokecc.vo {
    import flash.display.*;
    import flash.system.*;

    public class FlashAssets extends AssetsVO {

        private var applicationDomain:ApplicationDomain;

        public function FlashAssets(_arg1:ApplicationDomain){
            this.applicationDomain = _arg1;
        }
        public function getSkinInstance():Sprite{
            var _local1:Class;
            var _local2:Sprite;
            if (((this.applicationDomain) && (src))){
                _local1 = (this.applicationDomain.getDefinition(src) as Class);
                _local2 = new (_local1)();
                return (_local2);
            };
            return (null);
        }

    }
}//package com.bokecc.vo 
