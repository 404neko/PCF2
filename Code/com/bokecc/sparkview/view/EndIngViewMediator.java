package com.bokecc.sparkview.view {
    import flash.events.*;
    import flash.display.*;
    import flash.system.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.player.ui.*;
    import com.bokecc.sparkview.proxy.*;
    import flash.net.*;
    import org.puremvc.as3.patterns.mediator.*;
    import com.bokecc.sparkview.command.*;
    import com.bokecc.sparkview.Module.*;

    public class EndIngViewMediator extends Mediator implements IMediator {

        public static const Name:String = "EndIngViewMediator.Name";
        public static const REPLAY:String = "replay";
        public static const SHARE:String = "share";
        public static const COPY:String = "copy";
        public static const ITEM_CLICK:String = "recommendItemClick";
        public static const NEXTBUTTON_CLICK:String = "nextButtonClick";
        public static const PREVIOUSBUTTON_CLICK:String = "previousButtonClick";
        public static const ShowEnding:String = "SparkView.ShowEnding";
        public static const ShowRecommendedVideo:String = "SparkView.ShowRecommendedVideo";

        public function EndIngViewMediator(_arg1:Object){
            super(Name, _arg1);
        }
        private function get playerUI():PlayerUI{
            return ((viewComponent as PlayerView).playerUI);
        }
        override public function listNotificationInterests():Array{
            return ([ShowEnding, ShowRecommendedVideo]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:Object = _arg1.getBody();
            switch (_arg1.getName()){
                case ShowEnding:
                    if (((!(this.playerUI.recommend)) && (_local2["endSkin"]))){
                        this.playerUI.recommend = _local2["endSkin"];
                        this.addEvent(this.playerUI.recommend);
                    };
                    if (this.playerUI.recommend){
                        this.playerUI.recommend.visible = _local2["isShow"];
                    };
                    break;
            };
        }
        protected function addEvent(_arg1:DisplayObject):void{
            _arg1.addEventListener(REPLAY, this.onEndingEvent);
            _arg1.addEventListener(SHARE, this.onEndingEvent);
            _arg1.addEventListener(COPY, this.onEndingEvent);
            _arg1.addEventListener(ITEM_CLICK, this.onEndingEvent);
        }
        private function onEndingEvent(_arg1:Event):void{
            var _local3:String;
            var _local4:Object;
            var _local2:String = _arg1.type;
            switch (_local2){
                case REPLAY:
                    sendNotification(OperateEventHandler.OperateEvent, false, OperateEventHandler.Pause);
                    break;
                case SHARE:
                    this.playerUI.showSharePanel = true;
                    break;
                case COPY:
                    _local3 = (facade.retrieveProxy(CCModuleProxy.Name) as CCModuleProxy).getVideoPageURL(false);
                    if (_local3){
                        System.setClipboard(_local3);
                    };
                    break;
                case ITEM_CLICK:
                    _local4 = _arg1["itemData"];
                    navigateToURL(new URLRequest(_local4["videoUrl"]), "_blank");
                    sendNotification(PlayAnalyse.SendClick, PlayAnalyse.Trail_recommend);
                    sendNotification(PlayFinish.RecommendedVideoClick, _local4["videoId"]);
                    break;
            };
        }

    }
}//package com.bokecc.sparkview.view 
