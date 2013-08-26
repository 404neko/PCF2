package com.bokecc.sparkview.command {
    import org.puremvc.as3.interfaces.*;
    import flash.net.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.Module.*;
    import com.bokecc.utils.*;
    import com.bokecc.lib.data.*;

    public class PanelEventHandler extends BasicCommand implements ICommand {

        public static const PanelEvent:String = "SparkView.PanelEvent";
        public static const ToSetBrightness:String = "SparkView.ToSetBrightness";
        public static const ToSetContrast:String = "SparkView.ToSetContrast";
        public static const ToSetVideoScale:String = "SparkView.ToSetVideoScale";
        public static const ToSetQuality:String = "SparkView.ToSetQuality";
        public static const OnSubmitVideoFeedbackPanel:String = "SparkView.OnSubmitVideoFeedbackPanel";
        public static const GoToBShare:String = "SparkView.GoToBShare";
        public static const CopyCode:String = "SparkView.CopyCode";
        public static const TipSetQuality:String = "SparkView.TipSetQuality";
        public static const DownLoadVideo:String = "SparkView.DownLoadVideo";
        public static const ReplayCommand:String = "SparkView.ReplayCommand";
        public static const LinkEvent:String = "SparkView.LinkEvent";
        public static const Reconnect:String = "SparkView.Reconnect";

        override public function execute(_arg1:INotification):void{
            var _local2:Object;
            var _local3:String;
            var _local4:String;
            var _local5:int;
            var _local6:URLVariables;
            _local2 = _arg1.getBody();
            _local3 = _arg1.getType();
            switch (_local3){
                case ToSetBrightness:
                    playKernel.brightness = Number(_local2);
                    break;
                case ToSetContrast:
                    playKernel.contrast = Number(_local2);
                    break;
                case ToSetVideoScale:
                    playKernel.presetScale = _local2.toString();
                    break;
                case ToSetQuality:
                    kernelProxy.setQuality(Number(_local2));
                    break;
                case GoToBShare:
                    _local4 = (("http://api.bshare.cn/share/" + _local2) + ccModel.shareParam);
                    navigateToURL(new URLRequest(_local4), "_blank");
                    this.sendAnalyseLog(String(_local2), "difference");
                    break;
                case (TipSetQuality + 0):
                case (TipSetQuality + 1):
                case (TipSetQuality + 2):
                    _local5 = int(_local3.charAt((_local3.length - 1)));
                    kernelProxy.setQuality(_local5);
                    this.sendAnalyseLog(PlayAnalyse.Definition);
                    break;
                case ReplayCommand:
                    playKernel.seek(0);
                    this.sendAnalyseLog(PlayAnalyse.Replay);
                    break;
                case DownLoadVideo:
                    sendNotification(PanelViewMediator.ShowDownLoadPanel);
                    break;
                case CopyCode:
                    if (!isNull(_local2.toString())){
                        this.sendAnalyseLog(String(_local2), "difference");
                    };
                    break;
                case Reconnect:
                    playKernel.reconnect();
                    this.sendAnalyseLog(PlayAnalyse.Refresh);
                    break;
                case OnSubmitVideoFeedbackPanel:
                    _local6 = new URLVariables();
                    if (param.vid != null){
                        _local6["videoID"] = param.vid;
                        _local6["m"] = _local2;
                    };
                    send2Server("http://union.bokecc.com/servlet/AddReport", _local6);
                    break;
                case OperateEventHandler.TipToPause:
                    sendNotification(OperateEventHandler.OperateEvent, true, OperateEventHandler.TipToPause);
                    break;
            };
        }
        private function sendAnalyseLog(_arg1:String, _arg2:String=""):void{
            sendNotification(PlayAnalyse.SendClick, _arg1, _arg2);
        }

    }
}//package com.bokecc.sparkview.command 
