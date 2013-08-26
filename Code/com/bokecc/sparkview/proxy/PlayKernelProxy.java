package com.bokecc.sparkview.proxy {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.platform.playkernel.api.*;
    import org.puremvc.as3.patterns.proxy.*;

    public class PlayKernelProxy extends Proxy implements IProxy {

        public static const Name:String = "PlayKernelProxy.Name";

        private var _kernel:PlayKernel;
        private var _allowOperate:Boolean;
        private var _autoStart:Boolean;

        public function PlayKernelProxy(_arg1:PlayKernel){
            super(Name, _arg1);
            this._autoStart = this.playKernel.param.autostart;
        }
        public function get playKernel():PlayKernel{
            return ((data as PlayKernel));
        }
        public function getParam(_arg1:String){
            return (this.playKernel.param.getParam(_arg1));
        }
        public function get autostart():Boolean{
            return (this._autoStart);
        }
        public function set autostart(_arg1:Boolean):void{
            this._autoStart = _arg1;
        }
        public function get highestQuality():Number{
            var _local1 = -1;
            do  {
                _local1++;
            } while (this.playKernel.video.getQualityValidity(_local1));
            return ((_local1 - 1));
        }
        public function setQuality(_arg1:int):void{
            if (this.playKernel.quality != _arg1){
                this.playKernel.quality = _arg1;
            };
        }
        public function set allowOperate(_arg1:Boolean):void{
            this._allowOperate = _arg1;
        }
        public function get allowOperate():Boolean{
            return (this._allowOperate);
        }

    }
}//package com.bokecc.sparkview.proxy 
