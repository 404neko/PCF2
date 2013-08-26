package com.bokecc.sparkview.proxy {
    import flash.events.*;
    import flash.display.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.platform.playkernel.api.*;
    import org.puremvc.as3.patterns.proxy.*;
    import com.bokecc.sparkview.command.*;

    public class KernelEventProxy extends Proxy implements IProxy {

        public static const Name:String = "KernelEventProxy.Name";

        private var _code:int = 0;
        private var _status:String;

        public function KernelEventProxy(_arg1:Sprite){
            super(Name, _arg1);
        }
        private function get playKernel():Sprite{
            return ((data as Sprite));
        }
        override public function onRegister():void{
            this.playKernel.addEventListener(PlayKernelEvent.PlayerError, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.ListInfoReady, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.PlayReady, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.WillStart, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.PlayStart, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.PlayRealStart, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.PlayFinish, this.onPlayKernelEvent);
            this.playKernel.addEventListener(PlayKernelEvent.SwitchQualityStart, this.onPlayKernelEvent);
        }
        private function onPlayKernelEvent(_arg1:Event):void{
            var _local2:* = _arg1["value"];
            switch (_arg1.type){
                case PlayKernelEvent.PlayerError:
                    this.setCode(int(_local2));
                    break;
            };
            sendNotification(KernelEventHandler.PlayKernelEventHandler, _local2, _arg1.type);
        }
        override public function onRemove():void{
            this._code = 0;
        }
        public function get code():int{
            return (this._code);
        }
        protected function setCode(_arg1:int):void{
            switch (_arg1){
                case PlayKernelCode.GetListInfoError:
                    this.status = "视频列表信息加载失败";
                    break;
                case PlayKernelCode.PlayListEmpty:
                    this.status = "播放列表中没有视频";
                    break;
                case PlayKernelCode.PlayListInvalid:
                    this.status = "播放列表不存在";
                    break;
                case PlayKernelCode.GetListPlayInfoError:
                case PlayKernelCode.GetSinglePlayInfoError:
                    this.status = "视频信息加载失败";
                    break;
                case PlayKernelCode.Auditing:
                    this.status = "视频审核中...请稍候观看";
                    break;
                case PlayKernelCode.NoTraffic:
                case PlayKernelCode.AccLocked:
                    this.status = "抱歉，已暂停提供播放服务，请联系网站管理员";
                    break;
                case PlayKernelCode.Processing:
                    this.status = "视频处理中...请稍候观看";
                    break;
                case PlayKernelCode.Deleted:
                    this.status = "抱歉，视频已被删除，请联系网站管理员";
                    break;
                case PlayKernelCode.InfoError:
                case PlayKernelCode.NoVideo:
                    this.status = "视频信息错误，请联系网站管理员";
                    break;
                case PlayKernelCode.LowVersionFlashPlayer:
                    this.status = "您需要<a href='http://get.adobe.com/cn/flashplayer/' target='_blank'><u>升级flash player</u></a>之后才能播放";
                    break;
                case PlayKernelCode.SecurityError:
                    this.status = "播放器不在player域名上";
                    break;
                case PlayKernelCode.DomainDisallow:
                    this.status = "当前域名未获得播放授权";
                    break;
                case PlayKernelCode.PlayProtected:
                    this.status = "当前为保护播放";
                    break;
                case PlayKernelCode.SpeedTestFailed:
                    this.status = "测速失败";
                    break;
                case PlayKernelCode.SwitchQualityFailed:
                    this.status = "切换清晰度失败";
                    break;
                case PlayKernelCode.PlayFailed:
                    this.status = "播放中失败";
                    break;
            };
            this._code = _arg1;
        }
        public function get status():String{
            return (this._status);
        }
        public function set status(_arg1:String):void{
            this._status = _arg1;
        }

    }
}//package com.bokecc.sparkview.proxy 
