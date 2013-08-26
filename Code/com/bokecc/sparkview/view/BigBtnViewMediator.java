package com.bokecc.sparkview.view {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.player.ui.*;
    import com.bokecc.player.events.*;
    import org.puremvc.as3.patterns.mediator.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.command.*;
    import com.bokecc.sparkview.Module.*;

    public class BigBtnViewMediator extends Mediator implements IMediator {

        public static const Name:String = "BigBtnViewMediator.Name";
        public static const ShowBigPlayButton:String = "SparkView.ShowBigPlayButton";
        public static const AlwaysHidePlayButton:String = "SparkView.AlwaysHidePlayButton";

        private var alwaysHide:Boolean;
        private var playFinished:Boolean;
        private var playing:Boolean;
        private var showed:Boolean;

        public function BigBtnViewMediator(_arg1:Object){
            super(Name, _arg1);
        }
        public function get playerUI():PlayerUI{
            return ((viewComponent as PlayerView).playerUI);
        }
        override public function onRegister():void{
            this.playerUI.showBasePlayButton = (this.playFinished = (this.showed = false));
        }
        override public function onRemove():void{
            this.playerUI.showBasePlayButton = false;
        }
        override public function listNotificationInterests():Array{
            return ([ShowBigPlayButton, AlwaysHidePlayButton, PlayFinish.PlayFish, ControlViewMediator.SetPlayStatus]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local3:Object;
            var _local4:Boolean;
            var _local2:String = _arg1.getName();
            _local3 = _arg1.getBody();
            switch (_local2){
                case ShowBigPlayButton:
                    this.showed = true;
                    _local4 = ((Boolean(_local3)) && (!(this.alwaysHide)));
                    this.playerUI.showBasePlayButton = _local4;
                    if (_local4){
                        this.playerUI.addEventListener(ControlEvent.BASE_PLAY_BUTTON_CLICK, this.onClick);
                    };
                    break;
                case AlwaysHidePlayButton:
                    this.alwaysHide = _local3;
                    this.onCheckCustom();
                    break;
                case PlayFinish.PlayFish:
                    this.playFinished = true;
                    this.playing = false;
                    break;
                case ControlViewMediator.SetPlayStatus:
                    this.playerUI.showBasePlayButton = false;
                    this.playing = true;
                    break;
            };
        }
        private function onClick(_arg1:ControlEvent):void{
            if (!this.playFinished){
                sendNotification(PlayReadyStep.Step_ReadyPlay, null, PlayReadyStep.VerifySuccess);
                this.playerUI.removeEventListener(ControlEvent.BASE_PLAY_BUTTON_CLICK, this.onClick);
            } else {
                sendNotification(OperateEventHandler.OperateEvent, false, OperateEventHandler.Pause);
            };
            this.playerUI.showBasePlayButton = false;
        }
        private function onCheckCustom():void{
            if (this.showed){
                this.playerUI.showBasePlayButton = ((!(this.alwaysHide)) && (!(this.playing)));
            };
        }

    }
}//package com.bokecc.sparkview.view 
