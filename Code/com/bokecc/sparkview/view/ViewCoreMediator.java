package com.bokecc.sparkview.view {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.lib.utils.*;
    import com.bokecc.player.ui.*;
    import flash.net.*;
    import org.puremvc.as3.patterns.mediator.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.command.*;

    public class ViewCoreMediator extends Mediator implements IMediator {

        public static const Name:String = "PlayerViewMediator.Name";
        public static const OnResize:String = "SparkView.OnResize";
        public static const AddContextMenu:String = "SparkView.AddContextMenu";
        public static const LoadSkin:String = "SparkView.LoadSkin";
        public static const ApplySkinConfig:String = "SparkView.ApplySkinConfig";
        public static const CheckCustom:String = "SparkView.CheckCustom";
        public static const ShowVideoPoint:String = "SparkView.ShowVideoPoint";

        private var cxUI:Class;
        protected var _view:PlayerView;
        private var stageUtil:StageUtil;
        private var _cmUtil:ContextMenuUtil;
        private var isCaixin:Boolean;
        protected var autoHidenControlBar:Boolean;

        public function ViewCoreMediator(_arg1:Sprite, _arg2:DisplayObject, _arg3:Sprite){
            this.cxUI = ViewCoreMediator_cxUI;
            super(Name, _arg1);
            this.stageUtil = StageUtil.instance;
            this._view = new PlayerView();
            this.view.playerUI.displayer = _arg2;
            _arg1.addChild(this._view);
            this._cmUtil = new ContextMenuUtil(_arg3, true, true);
        }
        public function get app():Application{
            return ((viewComponent as Application));
        }
        public function get view():PlayerView{
            return (this._view);
        }
        public function get playerUI():PlayerUI{
            return (this.view.playerUI);
        }
        override public function onRemove():void{
            this.app.removeChild(this.view);
        }
        override public function onRegister():void{
            this.stageUtil.addEventListener(Event.RESIZE, this.onResize);
            this.stageUtil.addEventListener(Event.FULLSCREEN, this.onFullScreen);
            SkinManager.getInstance().addEventListener("skinChange", this.OnSkinChangeFinish);
            this._view.top = (this._view.left = (this._view.bottom = (this._view.right = 0)));
        }
        override public function listNotificationInterests():Array{
            return ([AddContextMenu, LoadSkin, ApplySkinConfig, CheckCustom, OnResize, ShowVideoPoint]);
        }
        override public function handleNotification(_arg1:INotification):void{
            var _local2:Object;
            var _local5:Array;
            _local2 = _arg1.getBody();
            var _local3:String = _arg1.getName();
            var _local4:String = _arg1.getType();
            switch (_local3){
                case AddContextMenu:
                    this.addItems(_local2["caption"], _local2["enabled"], _local2["callback"], _local2["separatorBefore"]);
                    break;
                case LoadSkin:
                    this.loadSkin(String(_local2));
                    break;
                case ApplySkinConfig:
                    this.playerUI.autoHidenControlBar = (this.autoHidenControlBar = _local2["autoHiden"]);
                    _local5 = _local2["skinColor"];
                    if (_local5[0] >= 0){
                        this.playerUI.backgroundColor = _local5[0];
                    };
                    if (_local5[1] >= 0){
                        this.playerUI.foregroundColor = _local5[1];
                    };
                    break;
                case CheckCustom:
                    this.isCaixin = Boolean(_local2["isCaixin"]);
                    this.onCheckCustom();
                    break;
                case OnResize:
                    this.onResize();
                    break;
                case ShowVideoPoint:
                    this.showVideoPoint((_local2 as Array));
                    break;
            };
        }
        private function addItems(_arg1:String, _arg2:Boolean=true, _arg3:Function=null, _arg4:Boolean=false, _arg5:Boolean=true):void{
            this._cmUtil.addItem(_arg1, _arg2, _arg3, _arg4, _arg5, false);
        }
        public function onResize(_arg1:Event=null):void{
            this.app.setSize(this.stageUtil.width, this.stageUtil.height);
        }
        private function loadSkin(_arg1:String):void{
            var _local2:Loader = new Loader();
            _local2.contentLoaderInfo.addEventListener(Event.COMPLETE, this.onComplete);
            _local2.contentLoaderInfo.addEventListener(IOErrorEvent.IO_ERROR, this.onError);
            _local2.load(new URLRequest(_arg1));
        }
        private function onComplete(_arg1:Event):void{
            var _local2:Loader = (_arg1.target as LoaderInfo).loader;
            SkinManager.getInstance().loaderSkin(_local2);
            this.onResize();
            sendNotification(PreloadStep.Step_PreLoad);
        }
        private function onError(_arg1:IOErrorEvent):void{
        }
        private function onFullScreen(_arg1:Event):void{
            this.onResize();
            if (this.stageUtil.isFullScreen){
                this.playerUI.autoHidenControlBar = true;
            } else {
                this.playerUI.autoHidenControlBar = this.autoHidenControlBar;
            };
            sendNotification(MediaEventHandler.MediaEvent, this.stageUtil.isFullScreen, Event.FULLSCREEN);
        }
        private function OnSkinChangeFinish(_arg1:Event):void{
            this.onCheckCustom();
        }
        private function onCheckCustom():void{
            var _local1:BaseButton;
            var _local2:BaseButton;
            var _local3:Sprite;
            var _local4:Sprite;
            var _local5:Sprite;
            if (this.isCaixin){
                _local1 = this.playerUI.baseControlBar.basePlayButton;
                _local2 = this.playerUI.miniControlBar.basePlayButton;
                _local1.cleanSkins();
                _local2.cleanSkins();
                _local3 = new this.cxUI();
                _local4 = (_local3.getChildByName("smallview") as Sprite);
                _local5 = (_local3.getChildByName("generalview") as Sprite);
                _local1.upSkin = _local5.getChildByName("normalView");
                _local1.overSkin = _local5.getChildByName("normalViewOver");
                _local1.bottom = NaN;
                _local1.top = -(_local5.height);
                _local2.upSkin = _local4.getChildByName("normalView");
                _local2.overSkin = _local4.getChildByName("normalViewOver");
                _local2.top = NaN;
                _local2.top = -90;
            };
        }
        private function showVideoPoint(_arg1:Array=null):void{
            this.playerUI.pointDatas = _arg1;
        }

    }
}//package com.bokecc.sparkview.view 
