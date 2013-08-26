package com.bokecc.sparkview.proxy {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.step.*;
    import org.puremvc.as3.patterns.proxy.*;
    import com.bokecc.sparkview.command.*;
    import com.bokecc.lib.data.*;
    import flash.external.*;

    public class JSControlProxy extends Proxy implements IProxy {

        public static const Name:String = "JSControlProxy.Name";
        private static const Scales:Object = {
            original:0,
            full:3,
            scale43:1,
            scale169:2
        };
        private static const ScaleNumber:Object = {
            0:"original",
            3:"full",
            1:"scale43",
            2:"scale169"
        };

        private var qualitys:Array;
        private var start:Boolean;
        private var _ShowControl:Boolean;

        public function JSControlProxy(){
            super(Name);
            this._ShowControl = true;
        }
        override public function onRegister():void{
            this.start = false;
            this.addCallback("spark_player_start", this.playerStart);
            this.addCallback("spark_player_pause", this.playerPause);
            this.addCallback("spark_player_resume", this.playerResume);
            this.addCallback("spark_player_seek", this.playerSeek);
            this.addCallback("spark_player_duration", this.getTotalTime);
            this.addCallback("spark_player_position", this.getPlayTime);
            this.addCallback("spark_player_progress", this.getPlayProgress);
            this.addCallback("spark_player_showcontrol", this.playerShowControl);
            this.addCallback("spark_player_setscale", this.playerSetScale);
            this.addCallback("spark_player_setquality", this.playerSetQuality);
            this.addCallback("spark_player_validquality", this.getValidQuality);
            this.addCallback("spark_player_setvolume", this.playerSetVolume);
        }
        private function playerSetVolume(_arg1:Number):void{
            this.operate(OperateEventHandler.SetVolume, _arg1);
        }
        private function getValidQuality():Array{
            var _local1:int;
            var _local2:int;
            if (this.qualitys == null){
                this.qualitys = new Array();
                _local1 = 0;
                while (_local1 < 3) {
                    _local2 = ((this.kernel.video.getQualityValidity(_local1)) ? 1 : 0);
                    this.qualitys.push(_local2);
                    _local1++;
                };
            };
            return (this.qualitys);
        }
        private function playerSetQuality(_arg1:int):void{
            if (((((((!(this.kernel.stopped)) && (this.kernel.video.getQualityValidity(_arg1)))) && (!((_arg1 == this.kernel.quality))))) && (this.kernelProxy.allowOperate))){
                return (this.panelEvent(PanelEventHandler.ToSetQuality, _arg1));
            };
        }
        private function playerSetScale(_arg1:String):void{
            if (ScaleNumber.hasOwnProperty(_arg1)){
                return (this.panelEvent(PanelEventHandler.ToSetVideoScale, ScaleNumber[_arg1]));
            };
        }
        private function playerShowControl(_arg1:String):void{
            if (!this.kernel.user.isHideControl){
                return;
            };
            this._ShowControl = toBoolean(_arg1);
            sendNotification(BigBtnViewMediator.AlwaysHidePlayButton, !(this._ShowControl));
            sendNotification(ControlViewMediator.ShowControlBar, this._ShowControl);
            this.callJS("on_spark_player_showcontrol", ((this._ShowControl) ? 1 : 0));
        }
        private function getPlayProgress():Number{
            return ((this.kernel.position / this.kernel.duration));
        }
        private function getPlayTime():Number{
            return (this.kernel.position);
        }
        private function getTotalTime():Number{
            return (this.kernel.duration);
        }
        private function playerSeek(_arg1:Number, _arg2=null):void{
            var _local3:Number = -1;
            if (_arg1 > 1){
                if (_arg1 < this.kernel.duration){
                    _local3 = _arg1;
                };
            } else {
                _local3 = _arg1;
            };
            if (_local3 >= 0){
                this.operate(OperateEventHandler.SeekPercent, {
                    position:_local3,
                    finish:_arg2
                });
            };
        }
        private function playerResume():void{
            this.operate(OperateEventHandler.Pause, false);
        }
        private function playerPause():void{
            this.operate(OperateEventHandler.Pause, true);
        }
        private function playerStart():void{
            sendNotification(PlayReadyStep.Step_ReadyPlay, false, PlayReadyStep.VerifySuccess);
        }
        public function onMetaData():void{
            this.callJS("eval", (((("JavaScript:try{videoPlay('" + this.kernel.param.vid) + "', '") + this.kernel.duration) + "');}catch(e){};void 0;"));
        }
        public function onPlayFinish():void{
            if (this.kernel.param.loadertype == 1){
                this.operate(OperateEventHandler.FullScreen, false);
                this.callJS("playnext");
            };
            if (((this.jscontrol) && (this.start))){
                this.callJS("on_spark_player_stop");
            };
        }
        public function onSeek():void{
            if (this.jscontrol){
                this.callJS("on_spark_player_seek");
            };
        }
        public function onPlayStatus():void{
            if (((this.jscontrol) && (this.start))){
                if (!this.kernel.stopped){
                    if (this.kernel.playing){
                        this.callJS("on_spark_player_resume");
                    } else {
                        this.callJS("on_spark_player_pause");
                    };
                };
            };
        }
        public function onPlayerReady():void{
            if (this.jscontrol){
                if (!this.kernelProxy.autostart){
                    this.callJS("on_spark_player_ready");
                };
            };
        }
        public function onPlayerStart():void{
            this.start = true;
            if (this.jscontrol){
                this.callJS("on_spark_player_start");
            };
        }
        public function onSwitchQuality():void{
            if (this.jscontrol){
                this.callJS("on_spark_player_setquality", this.kernel.quality);
            };
        }
        public function onSetVideoScale():void{
            var _local1:String = this.kernel.presetScale;
            if (((Scales.hasOwnProperty(_local1)) && (this.jscontrol))){
                this.callJS("on_spark_player_setscale", Scales[_local1]);
            };
        }
        public function onFullScreen():void{
            if (this.jscontrol){
                this.callJS("on_spark_player_fullscreen", ((StageUtil.instance.isFullScreen) ? 1 : 0));
            };
        }
        public function onBufferStatus(_arg1:Boolean):void{
            if (this.jscontrol){
                this.callJS("on_spark_player_buffering", ((_arg1) ? 1 : 0));
            };
        }
        public function onSetVolume():void{
            if (this.jscontrol){
                this.callJS("on_spark_player_volumechange", this.kernel.volume);
            };
        }
        private function callJS(_arg1:String, ... _args):void{
            var funcName:* = _arg1;
            var params:* = _args;
            try {
                ExternalInterface.call.apply(this, [funcName].concat(params));
            } catch(e:Error) {
            };
        }
        private function addCallback(_arg1:String, _arg2:Function):void{
            var funcName:* = _arg1;
            var func:* = _arg2;
            try {
                ExternalInterface.addCallback(funcName, func);
            } catch(e:Error) {
            };
        }
        private function operate(_arg1:String, _arg2=null):void{
            sendNotification(OperateEventHandler.OperateEvent, _arg2, _arg1);
        }
        private function panelEvent(_arg1:String, _arg2=null):void{
            sendNotification(PanelEventHandler.PanelEvent, _arg2, _arg1);
        }
        private function get jscontrol():Boolean{
            return (this.kernel.param.jsable);
        }
        private function get kernelProxy():PlayKernelProxy{
            return ((facade.retrieveProxy(PlayKernelProxy.Name) as PlayKernelProxy));
        }
        private function get kernel():PlayKernel{
            return (this.kernelProxy.playKernel);
        }
        public function get ShowControl():Boolean{
            return (this._ShowControl);
        }

    }
}//package com.bokecc.sparkview.proxy 
