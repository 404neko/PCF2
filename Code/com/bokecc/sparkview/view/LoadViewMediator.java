package com.bokecc.sparkview.view {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.player.ui.*;
    import flash.net.*;
    import org.puremvc.as3.patterns.mediator.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.Module.*;
    import com.bokecc.lib.data.*;

    public class LoadViewMediator extends Mediator implements IMediator {

        public static const Name:String = "LoadViewMediator.Name";
        public static const ShowLogo:String = "SprakView.ShowLogo";
        public static const ShowLoadingImg:String = "SparkView.ShowLoadingImg";
        public static const ShowVideoImg:String = "SparkView.ShowVideoImg";

        private var videoImg:Loader;
        private var logo:Image;
        private var loading:Loader;

        public function LoadViewMediator(_arg1:Object){
            super(Name, _arg1);
        }
        private function get playerUI():PlayerUI{
            return ((viewComponent as PlayerView).playerUI);
        }
        override public function listNotificationInterests():Array{
            return ([ShowLoadingImg, ShowLogo, ShowVideoImg]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:String = _arg1.getName();
            var _local3:Object = _arg1.getBody();
            var _local4:String = _arg1.getType();
            switch (_local2){
                case ShowLoadingImg:
                    if (_local4 != null){
                        this.loadLoadingImg(_local3["url"]);
                    } else {
                        if (_local3["isShow"]){
                            this.playerUI.bufferVideo(this.loading);
                        } else {
                            this.playerUI.bufferVideo(null);
                        };
                    };
                    break;
                case ShowLogo:
                    this.onShlowLogo(_local3["url"], _local3["link"], _local3["alpha"], _local3["position"]);
                    break;
                case ShowVideoImg:
                    if (_local3["isShow"]){
                        this.onShowVideoImg(_local3["url"]);
                    } else {
                        this.videoImgUnLoad();
                        this.playerUI.bufferVideo(null);
                    };
                    break;
            };
        }
        private function onShowVideoImg(_arg1:String):void{
            this.videoImg = this.getLoader(_arg1, this.videoImgComplete);
        }
        private function videoImgComplete(_arg1:Event):void{
            this.videoImgUnLoad(false);
            this.playerUI.bufferVideo(this.videoImg, true);
        }
        private function videoImgUnLoad(_arg1:Boolean=true):void{
            var unload:Boolean = _arg1;
            try {
                this.videoImg.contentLoaderInfo.removeEventListener(Event.COMPLETE, this.videoImgComplete);
                this.videoImg.contentLoaderInfo.removeEventListener(IOErrorEvent.IO_ERROR, this.onError);
                if (unload){
                    this.videoImg.unload();
                };
            } catch(e:Error) {
            };
        }
        private function loadLoadingImg(_arg1:String):void{
            if (!isNull(_arg1)){
                this.loading = this.getLoader(_arg1, this.onLoadLoadingImgComplete, this.onLoadLoadingImgError);
            } else {
                this.onLoadLoadingImgError();
            };
        }
        private function onLoadLoadingImgError(_arg1:Event=null):void{
            if (this.loading){
                this.loading.contentLoaderInfo.removeEventListener(Event.COMPLETE, this.onLoadLoadingImgComplete);
                this.loading.contentLoaderInfo.removeEventListener(IOErrorEvent.IO_ERROR, this.onLoadLoadingImgError);
            };
            sendNotification(PlayReadyStep.Step_ReadyPlay, false, PlayReadyStep.LoadingImgComplete);
        }
        private function onLoadLoadingImgComplete(_arg1:Event=null):void{
            this.loading.contentLoaderInfo.removeEventListener(Event.COMPLETE, this.onLoadLoadingImgComplete);
            this.loading.contentLoaderInfo.removeEventListener(IOErrorEvent.IO_ERROR, this.onLoadLoadingImgError);
            sendNotification(PlayReadyStep.Step_ReadyPlay, true, PlayReadyStep.LoadingImgComplete);
        }
        private function onShlowLogo(_arg1:String, _arg2:String, _arg3:Number, _arg4:int):void{
            var url:* = _arg1;
            var link:* = _arg2;
            var alpha:* = _arg3;
            var position:* = _arg4;
            if (isNull(url)){
                return;
            };
            this.logo = this.playerUI.logo;
            this.logo.addEventListener(MouseEvent.CLICK, function (_arg1:MouseEvent):void{
                navigateToURL(new URLRequest(link));
                sendNotification(PlayAnalyse.SendClick, PlayAnalyse.Logo);
            });
            this.logo.addEventListener(MouseEvent.MOUSE_OVER, function (_arg1:MouseEvent):void{
                logo.alpha = 1;
            });
            this.logo.addEventListener(MouseEvent.MOUSE_OUT, function (_arg1:MouseEvent):void{
                logo.alpha = alpha;
            });
            this.logo.alpha = alpha;
            this.logo.buttonMode = true;
            this.playerUI.logoUrl = url;
            this.playerUI.showLogo = true;
            var space:* = 5;
            this.logo.left = (this.logo.right = (this.logo.top = (this.logo.bottom = NaN)));
            switch (position){
                case 1:
                    this.logo.left = (this.logo.top = space);
                    break;
                case 3:
                    this.logo.left = (this.logo.bottom = space);
                    break;
                case 4:
                    this.logo.right = (this.logo.bottom = space);
                    break;
                default:
                    this.logo.right = (this.logo.top = space);
            };
        }
        private function getLoader(_arg1:String, _arg2:Function, _arg3:Function=null):Loader{
            var _local4:Loader = new Loader();
            _local4.contentLoaderInfo.addEventListener(Event.COMPLETE, _arg2);
            _local4.contentLoaderInfo.addEventListener(IOErrorEvent.IO_ERROR, (((_arg3 == null)) ? this.onError : _arg3));
            if (!isNull(_arg1)){
                _local4.load(new URLRequest(_arg1));
            };
            return (_local4);
        }
        private function onError(_arg1:Event):void{
        }

    }
}//package com.bokecc.sparkview.view 
