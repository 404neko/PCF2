package com.bokecc.sparkview.Module {
    import flash.events.*;
    import flash.utils.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.platform.playkernel.api.model.*;
    import flash.net.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.lib.data.*;

    public class PlayAnalyse extends BasicModule {

        public static const PlayAnalyse:String = "SparkView.PlayAnalyse";
        public static const AnalyseURL:String = "http://click.bokecc.com/flash/userClickAction";
        public static const SendReady:String = "SparkView.SendReady";
        public static const SendReveal:String = "SparkView.SendReveal";
        public static const SendClick:String = "SparkView.SendClick";
        public static const Forward:String = "forward";
        public static const Rewind:String = "rewind";
        public static const Logo:String = "logo";
        public static const Rightmenu_share:String = "rightmenu_share";
        public static const Rightmenu_link:String = "rightmenu_link";
        public static const Rightmenu_popup:String = "rightmenu_popup";
        public static const Popup_link:String = "popup_link";
        public static const Rightmenu_script:String = "rightmenu_script";
        public static const Trail_recommend:String = "trail_recommend";
        public static const Trail_share:String = "trail_share";
        public static const Sinaminiblog:String = "sinaminiblog";
        public static const Qqmb:String = "qqmb";
        public static const Qzone:String = "qzone";
        public static const Renren:String = "renren";
        public static const Kaixin001:String = "kaixin001";
        public static const Refresh:String = "refresh";
        public static const Definition:String = "definition";
        public static const Replay:String = "replay";
        public static const Pause:String = "pause";
        public static const Share_copy:String = "share_copy";
        public static const Fullscreen:String = "fullscreen";
        public static const Volume:String = "volume";
        public static const R_video_copy:String = "r_video_copy";
        public static const R_flash_copy:String = "r_flash_copy";
        public static const R_html_copy:String = "r_html_copy";

        private var timer:Timer;
        private var isPlayFinish:Boolean;

        public function PlayAnalyse(){
            super(PlayAnalyse);
        }
        override public function onRegister():void{
            this.timer = new Timer(1000);
            this.timer.addEventListener(TimerEvent.TIMER, this.onTImer);
            this.isPlayFinish = false;
        }
        override public function listNotificationInterests():Array{
            return ([SendReady, SendClick, SendReveal, PlayFinish.PlayFish, ControlViewMediator.SetPlayStatus]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:Object;
            var _local4:String;
            _local2 = _arg1.getBody();
            var _local3:String = _arg1.getType();
            switch (_arg1.getName()){
                case SendReady:
                    this.onSendReady();
                    break;
                case SendReveal:
                    this.sendReveal(_local2);
                    break;
                case SendClick:
                    _local4 = _local2.toString();
                    if (!isNull(_local3)){
                        _local4 = ((this.isPlayFinish) ? ("e_" + _local4) : ("r_" + _local4));
                    };
                    this.sendClick(_local4);
                    break;
                case PlayFinish.PlayFish:
                    this.isPlayFinish = true;
                    break;
                case ControlViewMediator.SetPlayStatus:
                    this.isPlayFinish = false;
                    break;
            };
        }
        public function sendReveal(... _args):void{
            var _local2:String = _args.join(",");
            this.send2Server(this.getURL(38, _local2));
        }
        public function sendClick(_arg1:String):void{
            if (_arg1 == Volume){
                this.sendVolume();
            } else {
                this.send2Server(this.getURL(39, _arg1, "userclick"));
            };
        }
        public function sendVolume():void{
            this.timer.reset();
            this.timer.start();
        }
        private function onTImer(_arg1:TimerEvent):void{
            this.timer.stop();
            this.send2Server(this.getURL(39, Volume, "userclick"));
        }
        private function onSendReady():void{
            var _local4:MenuNodeVO;
            var _local1 = "";
            var _local2:Number = Number(user.skinStyle);
            if (((((!(isNaN(_local2))) && ((_local2 <= 10)))) && ((_local2 > 0)))){
                _local1 = this.addTo(_local1, Forward, Rewind);
            };
            if (!isNull(user.logoURL)){
                _local1 = this.addTo(_local1, Logo);
            };
            var _local3:int;
            while (_local3 < user.menusData.length) {
                _local4 = user.menusData[_local3];
                switch (_local4.type){
                    case 0:
                        if (_local4.name == "sharebutton"){
                            _local1 = this.addTo(_local1, Rightmenu_share);
                            if (!isNull(user.bshare)){
                                _local1 = this.addTo(_local1, user.bshare);
                            };
                        };
                        break;
                    case 1:
                        if (_local1.search(Rightmenu_popup) == -1){
                            _local1 = this.addTo(_local1, Rightmenu_popup);
                        };
                        break;
                    case 2:
                        if (_local1.search(Rightmenu_script) < 0){
                            _local1 = this.addTo(_local1, Rightmenu_script);
                        };
                        break;
                    case 3:
                        if (_local1.search(Rightmenu_link) < 0){
                            _local1 = this.addTo(_local1, Rightmenu_link);
                        };
                        break;
                };
                _local3++;
            };
            if (user.hasRecommend){
                _local1 = this.addTo(_local1, Trail_recommend);
            };
            if (user.hasEndShare){
                _local1 = this.addTo(_local1, Trail_share);
            };
            this.send2Server(this.getURL(31, _local1));
        }
        private function addTo(_arg1:String, ... _args):String{
            if (isNull(_arg1)){
                _arg1 = _args.join(",");
            } else {
                _arg1 = ((_arg1 + ",") + _args.join(","));
            };
            return (_arg1);
        }
        private function getURL(_arg1:int, _arg2:String, _arg3:String="player_elements"):String{
            var _local4:String = AnalyseURL;
            _local4 = (_local4 + ((((((((((((("?upid=" + videoInfo.upid) + "&userid=") + user.id) + "&videoid=") + param.vid) + "&stage=") + _arg1) + "&") + _arg3) + "=") + _arg2) + "&time=") + new Date().getTime()));
            return (_local4);
        }
        public function send2Server(_arg1:String, _arg2:URLVariables=null, _arg3:Boolean=true):void{
            var url:* = _arg1;
            var data = _arg2;
            var random:Boolean = _arg3;
            if (((!((data == null))) && (random))){
                data["random"] = Math.random();
            };
            var request:* = new URLRequest(url);
            request.data = data;
            try {
                sendToURL(request);
            } catch(e:Error) {
            };
        }

    }
}//package com.bokecc.sparkview.Module 
