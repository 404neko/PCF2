package com.bokecc.sparkview.proxy {
    import flash.events.*;
    import flash.display.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.platform.playkernel.api.*;
    import org.puremvc.as3.patterns.proxy.*;
    import com.bokecc.sparkview.command.*;

    public class MediaEventProxy extends Proxy implements IProxy {

        public static const Name:String = "MediaEventProxy.Name";

        public function MediaEventProxy(_arg1:Sprite){
            super(Name, _arg1);
        }
        private function get playKernel():Sprite{
            return ((data as Sprite));
        }
        override public function onRegister():void{
            this.playKernel.addEventListener(PlayKernelEvent.PlayRealFinish, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.PlayFinish, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.Resize, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.Click, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.BrightnessChanged, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.ContrastChanged, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.ScaleChanged, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.VolumeChanged, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.PlayPause, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.PlayResume, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.SeekComplete, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.SeekBufferFull, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.LoadPositionRevised, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.BufferEmpty, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.BufferFull, this.onPlayKernelEvent);
        }
        private function onPlayKernelEvent(_arg1:Event):void{
            var _local2:* = _arg1["value"];
            sendNotification(MediaEventHandler.MediaEvent, _local2, _arg1.type);
        }

    }
}//package com.bokecc.sparkview.proxy 
