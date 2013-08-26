package com.bokecc.sparkview.view {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.player.ui.*;
    import com.bokecc.player.events.*;
    import org.puremvc.as3.patterns.mediator.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.command.*;

    public class ControlViewMediator extends Mediator implements IMediator {

        public static const Name:String = "ControlViewMediator.Name";
        public static const InitControl:String = "SparkView.InitControl";
        public static const SetVolume:String = "SparkView.SetVolume";
        public static const SetProgress:String = "SparkView.SetProgress";
        public static const SetPlayStatus:String = "SparkView.SetPlayStatus";
        public static const SetFullBtnStatus:String = "SparkView.SetFullBtnStatus";
        public static const SetBufferStart:String = "SparkView.SetBufferStart";
        public static const ShowControlBar:String = "SparkView.ShowControlBar";
        public static const ControlBarEnabled:String = "SparkView.ControlBarEnabled";

        private var isCaixin:Boolean;
        private var played:Boolean;

        public function ControlViewMediator(_arg1:Object){
            super(Name, _arg1);
        }
        private function get playerUI():PlayerUI{
            return ((viewComponent as PlayerView).playerUI);
        }
        protected function get control():ControlBar{
            return (this.playerUI.controlBar);
        }
        override public function onRegister():void{
            this.playerUI.duration = (this.playerUI.bufferEnd = (this.playerUI.bufferEnd = (this.playerUI.position = 0)));
            this.playerUI.pause();
            this.playerUI.showControlBarBasePlayerButton = (this.isCaixin = (this.played = false));
            this.playerUI.addEventListener(ControlEvent.DRAG, this.onOperate);
            this.playerUI.addEventListener(ControlEvent.FORWARD_STEP, this.onOperate);
            this.playerUI.addEventListener(ControlEvent.FULL_SCREEN, this.onOperate);
            this.playerUI.addEventListener(ControlEvent.NORMAL_SCREEN, this.onOperate);
            this.playerUI.addEventListener(ControlEvent.PLAY_BUTTON_CLICK, this.onOperate);
            this.playerUI.addEventListener(ControlEvent.REWIND_STEP, this.onOperate);
            this.playerUI.addEventListener(ControlEvent.VOLUME_CHANGE, this.onOperate);
        }
        override public function listNotificationInterests():Array{
            return ([InitControl, SetVolume, SetPlayStatus, SetProgress, SetBufferStart, SetFullBtnStatus, ShowControlBar, ViewCoreMediator.CheckCustom, ControlBarEnabled]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:Object;
            var _local4:Boolean;
            var _local5:Boolean;
            _local2 = _arg1.getBody();
            var _local3:String = _arg1.getName();
            switch (_local3){
                case InitControl:
                    this.playerUI.duration = Number(_local2["duration"]);
                    this.playerUI.bufferEnd = (this.playerUI.bufferStart = (this.playerUI.position = 0));
                    break;
                case SetVolume:
                    this.playerUI.volume = Number(_local2);
                    break;
                case SetProgress:
                    this.playerUI.position = _local2["position"];
                    this.playerUI.bufferEnd = _local2["bufferEnd"];
                    break;
                case SetBufferStart:
                    this.playerUI.bufferStart = Number(_local2);
                    break;
                case SetPlayStatus:
                    this.played = true;
                    _local4 = Boolean(_local2["playing"]);
                    _local5 = Boolean(_local2["stoped"]);
                    if (_local4){
                        this.control.play();
                        this.playerUI.showControlBarBasePlayerButton = false;
                    } else {
                        this.control.pause();
                        this.playerUI.showControlBarBasePlayerButton = ((this.isCaixin) || (!(_local5)));
                    };
                    break;
                case SetFullBtnStatus:
                    this.playerUI.fullScreen(Boolean(_local2));
                    break;
                case ShowControlBar:
                    this.playerUI.showControlBar = Boolean(_local2);
                    break;
                case ViewCoreMediator.CheckCustom:
                    this.isCaixin = Boolean(_local2["isCaixin"]);
                    this.playerUI.showControlBarBasePlayerButton = ((this.isCaixin) && (!(Boolean(_local2["isShow"]))));
                    break;
                case ControlBarEnabled:
                    this.playerUI.baseControlBar.enabled = _local2;
                    this.playerUI.miniControlBar.enabled = _local2;
                    break;
            };
        }
        private function onOperate(_arg1:ControlEvent):void{
            var _local4:String;
            var _local5:Boolean;
            var _local6:Boolean;
            var _local2:String = _arg1.type;
            var _local3:* = _arg1.value;
            _local4 = _arg1.state;
            switch (_local2){
                case ControlEvent.DRAG:
                    _local5 = (_local4 == ControlEvent.DRAG_END);
                    this.operate(OperateEventHandler.SeekPercent, {
                        position:_local3,
                        finish:_local5
                    });
                    break;
                case ControlEvent.FORWARD_STEP:
                case ControlEvent.REWIND_STEP:
                    _local3 = (((_local2 == ControlEvent.FORWARD_STEP)) ? 1 : -1);
                    _local6 = (_local4 == ControlEvent.DRAG_END);
                    this.operate(OperateEventHandler.ProgressOperate, {
                        value:_local3,
                        finish:_local6
                    });
                    break;
                case ControlEvent.FULL_SCREEN:
                case ControlEvent.NORMAL_SCREEN:
                    this.operate(OperateEventHandler.FullScreen);
                    break;
                case ControlEvent.PLAY_BUTTON_CLICK:
                    if (this.played){
                        this.operate(OperateEventHandler.Pause);
                    } else {
                        sendNotification(PlayReadyStep.Step_ReadyPlay, null, PlayReadyStep.VerifySuccess);
                        this.playerUI.showControlBarBasePlayerButton = false;
                        this.playerUI.baseControlBar.enabled = false;
                        this.playerUI.miniControlBar.enabled = false;
                    };
                    break;
                case ControlEvent.VOLUME_CHANGE:
                    this.operate(OperateEventHandler.SetVolume, _local3);
                    break;
            };
        }
        private function operate(_arg1:String, _arg2=null):void{
            sendNotification(OperateEventHandler.OperateEvent, _arg2, _arg1);
        }

    }
}//package com.bokecc.sparkview.view 
