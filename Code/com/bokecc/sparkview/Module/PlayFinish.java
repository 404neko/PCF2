package com.bokecc.sparkview.Module {
    import flash.events.*;
    import flash.display.*;
    import flash.system.*;
    import org.puremvc.as3.interfaces.*;
    import flash.net.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.utils.*;
    import com.bokecc.lib.data.*;

    public class PlayFinish extends BasicModule {

        public static const Name:String = "PlayFinish.Name";
        public static const PlayFish:String = "SparkView.PlayFinish";
        public static const RecommendedVideoClick:String = "SparkView.RecommendedVideoClick";

        private var endSkin:DisplayObject;
        private var showplaycount:Boolean;
        protected var recommendDatas:Array;

        public function PlayFinish(){
            super(Name);
        }
        override public function onRegister():void{
            this.recommendDatas = [];
        }
        override public function listNotificationInterests():Array{
            return ([PlayFish, ControlViewMediator.SetPlayStatus, RecommendedVideoClick]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:String;
            var _local3:String;
            switch (_arg1.getName()){
                case PlayFish:
                    this.onPlayFinish();
                    break;
                case ControlViewMediator.SetPlayStatus:
                    if (playKernel.playing){
                        this.sendShowEnding(false);
                    };
                    break;
                case RecommendedVideoClick:
                    _local2 = (_arg1.getBody() as String);
                    _local3 = ((((((CCURL.RECOMMENDEDVIDEOCLICK + "?fromvideoid=") + param.vid) + "&tovideoid=") + _local2) + "&random=") + Math.random());
                    send2Server(_local3);
                    break;
            };
        }
        protected function onPlayFinish():void{
            if (param.listMode){
                sendNotification(ViewCoreMediator.ShowVideoPoint, null);
                sendNotification(ListViewMediator.ToListPlay);
            } else {
                this.showEnding();
            };
        }
        protected function showEnding():void{
            if (user.hasRecommend){
                if (this.endSkin){
                    this.sendShowEnding(true);
                } else {
                    this.loadRecommend();
                };
            } else {
                sendNotification(BigBtnViewMediator.ShowBigPlayButton, true);
            };
        }
        protected function loadRecommend():void{
            var _local1:String = ((((((((CCURL.RECOMMENDED + "?vid=") + param.vid) + "&uid=") + user.id) + "&pid=") + param.playerid) + "&wd=") + encodeURI(videoInfo.title));
            var _local2:URLLoader = new URLLoader();
            _local2.addEventListener(Event.COMPLETE, this.onLoadRecommend);
            _local2.addEventListener(SecurityErrorEvent.SECURITY_ERROR, this.onError);
            _local2.addEventListener(IOErrorEvent.IO_ERROR, this.onError);
            _local2.load(new URLRequest(_local1));
        }
        protected function loadEndingSkin(_arg1:String):void{
            var _local2:Loader = new Loader();
            var _local3:LoaderContext = new LoaderContext();
            _local3.applicationDomain = new ApplicationDomain();
            _local2.contentLoaderInfo.addEventListener(Event.COMPLETE, this.onLoadEndingSkin);
            _local2.contentLoaderInfo.addEventListener(Event.INIT, this.onEndingSkinInit);
            _local2.contentLoaderInfo.addEventListener(IOErrorEvent.IO_ERROR, this.onError);
            _local2.load(new URLRequest(((CCURL.RECOMMENDEDSKIN + "/") + _arg1)), _local3);
        }
        private function onEndingSkinInit(_arg1:Event):void{
            var _local2:LoaderInfo = (_arg1.target as LoaderInfo);
            _local2.content.addEventListener("creationComplete", this.onCreationComplete);
        }
        private function onCreationComplete(_arg1:Event):void{
            (_arg1.target as DisplayObject)["dataProvider"] = this.recommendDatas;
        }
        protected function onLoadRecommend(_arg1:Event):void{
            var _local9:XML;
            var _local10:Object;
            var _local2:XML = XML((_arg1.target as URLLoader).data);
            var _local3:XMLList = _local2["videos"]["video"];
            var _local4:XMLList = _local2["module"];
            var _local5:XMLList = _local2["setting"];
            var _local6:String = _local4.@name;
            var _local7:String = _local4.@version;
            this.showplaycount = !(toBoolean(_local5.@showplaycount));
            CCDecoder.init();
            var _local8:int;
            while (_local8 < _local3.length()) {
                _local9 = _local3[_local8];
                _local10 = {};
                _local10["imageUrl"] = _local9.@fullImgURL;
                _local10["videoName"] = CCDecoder.decodeBase64(_local9.@title);
                _local10["playCount"] = ("播放量:" + _local9.@playCount);
                _local10["videoUrl"] = _local9.@pageAddr;
                _local10["videoId"] = _local9.@id;
                this.recommendDatas.push(_local10);
                _local8++;
            };
            sendNotification(EndIngViewMediator.ShowRecommendedVideo, this.recommendDatas);
            this.loadEndingSkin((_local6 + ".swf"));
        }
        protected function onLoadEndingSkin(_arg1:Event):void{
            var _local2:LoaderInfo = (_arg1.target as LoaderInfo);
            this.endSkin = _local2.content;
            this.endSkin["showRate"] = this.showplaycount;
            this.endSkin["showShareButton"] = user.hasEndShare;
            this.sendShowEnding(true);
        }
        protected function sendShowEnding(_arg1:Boolean):void{
            sendNotification(EndIngViewMediator.ShowEnding, {
                isShow:_arg1,
                endSkin:this.endSkin
            });
        }
        protected function onError(_arg1:Event):void{
            sendNotification(BigBtnViewMediator.ShowBigPlayButton, true);
        }

    }
}//package com.bokecc.sparkview.Module 
