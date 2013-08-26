package com.bokecc.sparkview.command {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.Module.*;
    import com.bokecc.lib.data.*;

    public class OperateEventHandler extends BasicCommand implements ICommand {

        public static const OperateEvent:String = "SparkView.OperateEventHandler";
        public static const Pause:String = "SparkView.Pause";
        public static const SeekPercent:String = "SparkView.SeekPercent";
        public static const ProgressOperate:String = "SprakView.ProgressOperate";
        public static const KeyBoardProgressOperate:String = "SprakView.KeyBoardProgressOperate";
        public static const SetVolume:String = "SparkView.SetVolume";
        public static const FullScreen:String = "SparkView.FullScreen";
        public static const Stop:String = "SparkView.Stop";
        public static const TipToPause:String = "SparkView.TipToPause";
        public static const PlayKernelListPlay:String = "SparkView.PlayKernelListPlay";

        override public function execute(_arg1:INotification):void{
            var _local3:Object;
            var _local4:int;
            var _local5:Boolean;
            var _local6:Number;
            var _local7:Number;
            var _local2:String = _arg1.getType();
            if (((!(kernelProxy.allowOperate)) && (!((_local2 == PlayKernelListPlay))))){
                return;
            };
            _local3 = _arg1.getBody();
            switch (_local2){
                case Pause:
                case TipToPause:
                    playKernel.pause(_local3);
                    if (_local2 == TipToPause){
                        this.sendAnalyseLog(PlayAnalyse.Pause);
                    };
                    break;
                case ProgressOperate:
                case KeyBoardProgressOperate:
                    _local4 = _local3["value"];
                    _local5 = _local3["finish"];
                    _local6 = playKernel.viewPosition;
                    if (!_local5){
                        _local6 = (playKernel.viewPosition + ((playKernel.duration * 0.01) * _local4));
                    };
                    playKernel.seek(_local6, _local3["finish"]);
                    if (((_local3["finish"]) && ((_local2 == ProgressOperate)))){
                        if (_local4 == -1){
                            this.sendAnalyseLog(PlayAnalyse.Rewind);
                        } else {
                            this.sendAnalyseLog(PlayAnalyse.Forward);
                        };
                    };
                    break;
                case SeekPercent:
                    playKernel.seek(_local3["position"], _local3["finish"]);
                    break;
                case SetVolume:
                    _local7 = Number(_local3);
                    if (_local7 == -2){
                        _local7 = (playKernel.volume - 0.1);
                    } else {
                        if (_local7 == -1){
                            _local7 = (playKernel.volume + 0.1);
                        };
                    };
                    _local7 = inRange(exact(_local7, 1));
                    playKernel.volume = _local7;
                    if (((!((_local7 == -1))) || (!((_local7 == -2))))){
                        this.sendAnalyseLog(PlayAnalyse.Volume);
                    };
                    break;
                case FullScreen:
                    if (user.fullscreen){
                        StageUtil.instance.fullScreen(_local3);
                    };
                    this.sendAnalyseLog(PlayAnalyse.Fullscreen);
                    break;
                case Stop:
                    break;
                case PlayKernelListPlay:
                    sendNotification(ControlViewMediator.InitControl, {duration:0});
                    playKernel.listPlay(int(_local3));
                    break;
            };
        }
        private function sendAnalyseLog(_arg1:String):void{
            sendNotification(PlayAnalyse.SendClick, _arg1);
        }

    }
}//package com.bokecc.sparkview.command 
