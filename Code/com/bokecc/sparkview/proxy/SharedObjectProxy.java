package com.bokecc.sparkview.proxy {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.lib.utils.*;
    import org.puremvc.as3.patterns.proxy.*;

    public class SharedObjectProxy extends Proxy implements IProxy {

        public static const Name:String = "SharedObjectProxy.Name";
        public static const DataName:String = "bokecc.com";

        private var recordTime:Object;

        public function SharedObjectProxy(){
            super(Name);
        }
        private function get vid():String{
            return (String(data));
        }
        override public function onRegister():void{
            this.recordTime = SharedObjectUtil.getData(DataName, "playingRecord");
            this.recordTime = (((this.recordTime == null)) ? new Object() : this.recordTime);
        }
        public function getPlayTime(_arg1:String):Number{
            var _local2:Number = 0;
            if (this.recordTime.hasOwnProperty(_arg1)){
                _local2 = this.recordTime[_arg1];
            };
            return (_local2);
        }
        public function recordPlayTime(_arg1:String, _arg2:Number):void{
            this.recordTime[_arg1] = _arg2;
            SharedObjectUtil.setData(DataName, this.recordTime, "playingRecord");
        }
        public function getVolume():Number{
            var _local1:* = SharedObjectUtil.getData(DataName, "volume");
            if (_local1 == null){
                _local1 = 0.8;
            };
            return (_local1);
        }
        public function recordVolume(_arg1:Number):void{
            SharedObjectUtil.setData(DataName, _arg1, "volume");
        }
        public function getQuality():Object{
            return (SharedObjectUtil.getData(DataName, "quality"));
        }
        public function setQuality(_arg1:int):void{
            SharedObjectUtil.setData(DataName, _arg1, "quality");
        }

    }
}//package com.bokecc.sparkview.proxy 
