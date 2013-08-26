package com.bokecc.player.ui {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import flash.utils.*;
    import flash.geom.*;
    import com.bokecc.controls.*;
    import com.bokecc.player.events.*;
    import com.bokecc.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;
    import com.bokecc.player.ui.setuppanel.*;
    import com.greensock.*;

    public class PlayerUI extends MultipleControlBarPlayerUI {

        protected var _setupMenu:SetUpMenu;
        private var _setUpMenuHidenTimer:Timer;
        private var _autoHidenSetupMenu:Boolean = true;
        private var _safeguardModeCanvas:SafeguardModeCanvas;
        private var _loaderSpinner:LoaderSpinner;
        private var _bufferHead:BufferHead;
        protected var _settingPanel:SettingPanel;
        private var _sharePanel:SharePanel;
        private var _downloadPanel:DownloaderPanel;
        private var _customPanel:CustomPanel;
        private var _runoutNavigator:RunOutNavigator;
        private var _reportPanel:ReportPanel;
        private var _articulationPanel:ArticulationPanel;
        private var _luminancePanel:LuminancePanel;
        private var _videoScalePanel:VideoScalePanel;
        private var _alertPanel:Alert;
        private var _recoverMessageBox:RecoverMessageBox;
        protected var _currentShowPanel:Container;
        private var _hidenRecoverMessageBoxTimer:Timer;
        private var _recommendListData:Array;
        private var _setupMenuDataProvider:Array;
        private var _shareOptionDatas:Array;
        private var _videoUrl:String;
        private var _flashUrl:String;
        private var _htmlUrl:String;
        private var _downloaderUrl:String;
        private var _customPanelImageUrl:String;
        private var _customPanelTitle:String;
        private var _customPanelImageHref:String;
        private var _customPanelText:String = "";
        private var _customPanelTextLayout:String = "textLeft";
        private var _logo:Image;
        private var _logoUrl:String;

        public function get recommend():DisplayObject{
            return (displayArea.recommendLayer.recommend);
        }
        public function set recommend(_arg1:DisplayObject):void{
            displayArea.recommendLayer.recommend = _arg1;
        }
        public function get alertPanel():Alert{
            if (!this._alertPanel){
                this._alertPanel = new Alert();
                this._alertPanel.verticalCenter = 0;
                this._alertPanel.horizontalCenter = 0;
                this._alertPanel.addEventListener(CloseEvent.CLOSE, this.alertPanelOnClose);
                this._alertPanel.addEventListener(CCTextEvent.LINK, this.alertPanelOnLink);
            };
            return (this._alertPanel);
        }
        private function alertPanelOnLink(_arg1:CCTextEvent):void{
            dispatchEvent(_arg1.clone());
        }
        private function alertPanelOnClose(_arg1:CloseEvent):void{
            this.showAlertPanel = false;
        }
        public function get setUpPanelData():SetUpPanelVO{
            return (this.settingPanel.setUpPanelData);
        }
        public function get articulationPanel():ArticulationPanel{
            if (!this._articulationPanel){
                this._articulationPanel = new ArticulationPanel();
                this._articulationPanel.verticalCenter = 0;
                this._articulationPanel.horizontalCenter = 0;
                this._articulationPanel.addEventListener(Panel.CLOSED_EVENT, this.articulationPanelOnClosed);
                this._articulationPanel.addEventListener(ArticulationEvent.OK, this.articulationOnOk);
            };
            return (this._articulationPanel);
        }
        private function articulationOnOk(_arg1:ArticulationEvent):void{
            this.setUpPanelData.articulation = this.articulationPanel.articulation;
        }
        private function articulationPanelOnClosed(_arg1:Event):void{
            this.articulationPanel.articulationCanvas.articulation = this.setUpPanelData.articulation;
            this.showArticulationPanel = false;
        }
        public function get luminancePanel():LuminancePanel{
            if (!this._luminancePanel){
                this._luminancePanel = new LuminancePanel();
                this._luminancePanel.verticalCenter = 0;
                this._luminancePanel.horizontalCenter = 0;
                this._luminancePanel.addEventListener(LuminanceEvent.CONTRAST_CHANGE, this.luminancePanelOnContrastChange);
                this._luminancePanel.addEventListener(LuminanceEvent.LIGHT_CHANGE, this.luminancePanelOnLightChange);
                this._luminancePanel.addEventListener(LuminanceEvent.REST, this.luminancePanelOnRest);
                this._luminancePanel.addEventListener(Panel.CLOSED_EVENT, this.luminancePanelOnClosed);
            };
            return (this._luminancePanel);
        }
        private function luminancePanelOnLightChange(_arg1:LuminanceEvent):void{
            this.setUpPanelData.lightValue = _arg1.lightValue;
        }
        private function luminancePanelOnContrastChange(_arg1:LuminanceEvent):void{
            this.setUpPanelData.contrastValue = _arg1.contrastValue;
        }
        private function luminancePanelOnRest(_arg1:LuminanceEvent):void{
            dispatchEvent(new SetUpPanelDataEvent(SetUpPanelDataEvent.LIGHTVALUE_CONTRASTVALUE_REST));
        }
        private function luminancePanelOnClosed(_arg1:Event):void{
            this.showLuminancePanel = false;
        }
        public function get videoScalePanel():VideoScalePanel{
            if (!this._videoScalePanel){
                this._videoScalePanel = new VideoScalePanel();
                this._videoScalePanel.verticalCenter = 0;
                this._videoScalePanel.horizontalCenter = 0;
                this._videoScalePanel.addEventListener(VideoScaleEvent.FULL, this.videoScalePanelOnChange);
                this._videoScalePanel.addEventListener(VideoScaleEvent.ORIGINAL, this.videoScalePanelOnChange);
                this._videoScalePanel.addEventListener(VideoScaleEvent.SCALE_4_3, this.videoScalePanelOnChange);
                this._videoScalePanel.addEventListener(VideoScaleEvent.SCALE_16_9, this.videoScalePanelOnChange);
                this._videoScalePanel.addEventListener(Panel.CLOSED_EVENT, this.videoScalePanelOnClosed);
            };
            return (this._videoScalePanel);
        }
        private function videoScalePanelOnChange(_arg1:VideoScaleEvent):void{
            this.setUpPanelData.videoScale = _arg1.type;
        }
        private function videoScalePanelOnClosed(_arg1:Event):void{
            this.showVideoScalePanel = false;
        }
        public function get currentShowPanel():Container{
            return (this._currentShowPanel);
        }
        public function get logoUrl():String{
            return (this._logoUrl);
        }
        public function set logoUrl(_arg1:String):void{
            if (((!((null == _arg1))) && (!(("" == _arg1))))){
                this._logoUrl = _arg1;
                this.logo.url = this._logoUrl;
            };
        }
        public function get logo():Image{
            if (!this._logo){
                this._logo = new Image();
                this._logo.addEventListener("loadComplete", this.onLoadComplete);
            };
            return (this._logo);
        }
        private function onLoadComplete(_arg1:Event):void{
            dispatchEvent(new Event("logoLoadComplete"));
        }
        public function set showLogo(_arg1:Boolean):void{
            this.logo.visible = _arg1;
        }
        public function showSafeguardModeCanvas(_arg1:Boolean):void{
            if (_arg1){
                if (!this.safeguardModeCanvas.parent){
                    this.addChild(this.safeguardModeCanvas);
                };
            } else {
                if (this.safeguardModeCanvas.parent){
                    this.removeChild(this.safeguardModeCanvas);
                };
            };
        }
        public function get safeguardModeCanvas():SafeguardModeCanvas{
            if (!this._safeguardModeCanvas){
                this._safeguardModeCanvas = new SafeguardModeCanvas();
                this._safeguardModeCanvas.addEventListener(SafeguardModeCanvasEvent.SAFEGUARDMODE_CLICK, this.safeguardModeCanvasEventHandler);
                this._safeguardModeCanvas.addEventListener(SafeguardModeCanvasEvent.SAFEGUARDMODE_COPY, this.safeguardModeCanvasEventHandler);
                this._safeguardModeCanvas.left = 0;
                this._safeguardModeCanvas.right = 0;
                this._safeguardModeCanvas.top = 0;
                this._safeguardModeCanvas.bottom = 0;
            };
            return (this._safeguardModeCanvas);
        }
        private function safeguardModeCanvasEventHandler(_arg1:SafeguardModeCanvasEvent):void{
            dispatchEvent(_arg1.clone());
        }
        public function get safeguardModeTitle():String{
            return (this.safeguardModeCanvas.videoTitle);
        }
        public function set safeguardModeTitle(_arg1:String):void{
            this.safeguardModeCanvas.videoTitle = _arg1;
        }
        public function get safeguardModeVideoUrl():String{
            return (this.safeguardModeCanvas.videoUr);
        }
        public function set safeguardModeVideoUrl(_arg1:String):void{
            this.safeguardModeCanvas.videoUr = _arg1;
        }
        public function get customPanelToken():String{
            return (this.customPanel.token);
        }
        public function set customPanelToken(_arg1:String):void{
            this.customPanel.token = _arg1;
        }
        public function get customPanelTextLayout():String{
            return (this._customPanelTextLayout);
        }
        public function set customPanelTextLayout(_arg1:String):void{
            this._customPanelTextLayout = _arg1;
            if (this.customPanel.parent){
                this.customPanel.contentLyout = this._customPanelTextLayout;
            };
        }
        public function get customPanelText():String{
            return (this._customPanelText);
        }
        public function set customPanelText(_arg1:String):void{
            this._customPanelText = _arg1;
            if (this.customPanel.parent){
                this.customPanel.text = this._customPanelText;
            };
        }
        public function get customPanelImageHref():String{
            return (this._customPanelImageHref);
        }
        public function set customPanelImageHref(_arg1:String):void{
            this._customPanelImageHref = _arg1;
            if (this.customPanel.parent){
                this.customPanel.hrefUrl = this._customPanelImageHref;
            };
        }
        public function get customPanelTitle():String{
            return (this._customPanelTitle);
        }
        public function set customPanelTitle(_arg1:String):void{
            this._customPanelTitle = _arg1;
            if (this.customPanel.parent){
                this.customPanel.title = this._customPanelTitle;
            };
        }
        public function get customPanelImageUrl():String{
            return (this._customPanelImageUrl);
        }
        public function set customPanelImageUrl(_arg1:String):void{
            this._customPanelImageUrl = _arg1;
            if (this.customPanel.parent){
                this.customPanel.loaderImage(this._customPanelImageUrl);
            };
        }
        private function get bufferHead():BufferHead{
            if (!this._bufferHead){
                this._bufferHead = new BufferHead();
                this._bufferHead.left = 0;
                this._bufferHead.right = 0;
                this._bufferHead.top = 0;
                this._bufferHead.bottom = 0;
            };
            return (this._bufferHead);
        }
        public function bufferVideo(_arg1:DisplayObject, _arg2:Boolean=false):void{
            this.bufferHead.displayer = _arg1;
            this.bufferHead.full = _arg2;
        }
        public function get downloaderUrl():String{
            return (this._downloaderUrl);
        }
        public function set downloaderUrl(_arg1:String):void{
            this._downloaderUrl = _arg1;
            this.downloadPanel.url = this._downloaderUrl;
        }
        public function get htmlUrl():String{
            return (this._htmlUrl);
        }
        public function set htmlUrl(_arg1:String):void{
            this._htmlUrl = _arg1;
            this.sharePanel.canvas.htmlCode = this._htmlUrl;
            if (this.runoutNavigator.parent){
                this.runoutNavigator.shareCanvas.htmlCode = this._htmlUrl;
            };
        }
        public function get flashUrl():String{
            return (this._flashUrl);
        }
        public function set flashUrl(_arg1:String):void{
            this._flashUrl = _arg1;
            this.sharePanel.canvas.flashUrl = this._flashUrl;
            if (this.runoutNavigator.parent){
                this.runoutNavigator.shareCanvas.flashUrl = this._flashUrl;
            };
        }
        public function get videoUrl():String{
            return (this._videoUrl);
        }
        public function set videoUrl(_arg1:String):void{
            this._videoUrl = _arg1;
            this.sharePanel.canvas.videoUrl = this._videoUrl;
            if (this.runoutNavigator.parent){
                this.runoutNavigator.shareCanvas.videoUrl = this._videoUrl;
            };
        }
        public function get shareOptionDatas():Array{
            return (this._shareOptionDatas);
        }
        public function get codePictureUrl():String{
            return (this.sharePanel.codePictureUrl);
        }
        public function set codePictureUrl(_arg1:String):void{
            this.sharePanel.codePictureUrl = _arg1;
        }
        public function set shareOptionDatas(_arg1:Array):void{
            if (_arg1){
                this._shareOptionDatas = _arg1;
                if (this.sharePanel.parent){
                    this.sharePanel.canvas.shareOptionDatas = this._shareOptionDatas;
                };
                if (this.runoutNavigator.parent){
                    this.runoutNavigator.shareCanvas.shareOptionDatas = this._shareOptionDatas;
                };
            };
        }
        public function get setupMenuDataProvider():Array{
            return (this._setupMenuDataProvider);
        }
        public function set setupMenuDataProvider(_arg1:Array):void{
            this._setupMenuDataProvider = _arg1;
            this.measureSetupMenu();
        }
        private function measureSetupMenu():void{
            var _local3:SetUpMenuItemVO;
            var _local1:Number = 0;
            var _local2:Array = [];
            for each (_local3 in this._setupMenuDataProvider) {
                _local1 = (_local1 + SetUpMenuItem.HEIGHT);
                if (_local1 > displayArea.height){
                } else {
                    _local2.push(_local3);
                };
            };
            this.setupMenu.dataProvider = _local2;
        }
        public function get recommendListData():Array{
            return (this._recommendListData);
        }
        public function set recommendListData(_arg1:Array):void{
            if (_arg1){
                this._recommendListData = _arg1;
                this.runoutNavigator.playList.datas = this._recommendListData;
            };
        }
        public function get hidenRecoverMessageBoxTimer():Timer{
            if (!this._hidenRecoverMessageBoxTimer){
                this._hidenRecoverMessageBoxTimer = new Timer(3000);
                this._hidenRecoverMessageBoxTimer.addEventListener(TimerEvent.TIMER, this.hidenRecoverMessageBoxTimerOnTimer);
            };
            return (this._hidenRecoverMessageBoxTimer);
        }
        private function hidenRecoverMessageBoxTimerOnTimer(_arg1:TimerEvent):void{
            this.hidenRecoverMessageEffcet();
        }
        public function get recoverMessageBox():RecoverMessageBox{
            if (!this._recoverMessageBox){
                this._recoverMessageBox = new RecoverMessageBox();
                this._recoverMessageBox.addEventListener(CCTextEvent.LINK, this.recoverMessageBoxOnLink);
                this._recoverMessageBox.addEventListener("close", this.recoverMessageOnClose);
                this._recoverMessageBox.top = -(this._recoverMessageBox.height);
            };
            return (this._recoverMessageBox);
        }
        private function recoverMessageBoxOnLink(_arg1:CCTextEvent):void{
            dispatchEvent(_arg1.clone());
        }
        private function recoverMessageOnClose(_arg1:Event):void{
            this.hidenRecoverMessageBoxTimer.stop();
            this.hidenRecoverMessageEffcet();
        }
        public function showRecoverMessage(_arg1:String, _arg2:int=3000):void{
            this.showRecoverMessageEffcet();
            this.addChild(this.recoverMessageBox);
            this.recoverMessageBox.messageText = _arg1;
            if (-1 == _arg2){
                this.hidenRecoverMessageBoxTimer.stop();
            } else {
                this.hidenRecoverMessageBoxTimer.delay = _arg2;
                this.hidenRecoverMessageBoxTimer.repeatCount = 1;
                this.hidenRecoverMessageBoxTimer.reset();
                this.hidenRecoverMessageBoxTimer.start();
            };
        }
        public function hidenRecoverMessage():void{
            this.hidenRecoverMessageEffcet();
        }
        private function showRecoverMessageEffcet():void{
            TweenNano.to(this.recoverMessageBox, 0.2, {top:0});
        }
        private function hidenRecoverMessageEffcet():void{
            if (this.recoverMessageBox.parent){
                TweenNano.to(this.recoverMessageBox, 0.2, {
                    top:-(this._recoverMessageBox.height),
                    onComplete:function ():void{
                        if (recoverMessageBox.parent){
                            removeChild(recoverMessageBox);
                        };
                    }
                });
            };
        }
        public function get reportPanel():ReportPanel{
            if (!this._reportPanel){
                this._reportPanel = new ReportPanel();
                this._reportPanel.addEventListener(Panel.CLOSED_EVENT, this.reportPanelOnClosed);
                this._reportPanel.addEventListener(ReportPanelEvent.COMMIT, this.reportPanelOnCommit);
                this._reportPanel.verticalCenter = 0;
                this._reportPanel.horizontalCenter = 0;
            };
            return (this._reportPanel);
        }
        private function reportPanelOnCommit(_arg1:ReportPanelEvent):void{
            dispatchEvent(_arg1.clone());
        }
        private function reportPanelOnClosed(_arg1:Event):void{
            this.showReportPanel = false;
        }
        public function get runoutNavigator():RunOutNavigator{
            if (!this._runoutNavigator){
                this._runoutNavigator = new RunOutNavigator();
                this._runoutNavigator.verticalCenter = 0;
                this._runoutNavigator.horizontalCenter = 0;
                this._runoutNavigator.addEventListener(NominateListEvent.ITEM_CLICK, this.runoutNavigatorOnItemClick);
                this._runoutNavigator.addEventListener(ShareEvent.COPY_FLASHURL, this.shareCanvasEventHandler);
                this._runoutNavigator.addEventListener(ShareEvent.COPY_HTMLCODE, this.shareCanvasEventHandler);
                this._runoutNavigator.addEventListener(ShareEvent.COPY_VIDEOURL, this.shareCanvasEventHandler);
                this._runoutNavigator.addEventListener(ShareEvent.SHARE_XINLANG, this.shareCanvasEventHandler);
                this._runoutNavigator.addEventListener(ShareEvent.SHARE_TENXUN, this.shareCanvasEventHandler);
                this._runoutNavigator.addEventListener(ShareEvent.SHARE_QQ, this.shareCanvasEventHandler);
                this._runoutNavigator.addEventListener(ShareEvent.SHARE_RENREN, this.shareCanvasEventHandler);
                this._runoutNavigator.addEventListener(ShareEvent.SHARE_KAIXIN, this.shareCanvasEventHandler);
                this._runoutNavigator.addEventListener("selectNominateList", this.runoutNavigatorSelectEventHandler);
                this._runoutNavigator.addEventListener("selectShareCanvas", this.runoutNavigatorSelectEventHandler);
            };
            return (this._runoutNavigator);
        }
        private function runoutNavigatorSelectEventHandler(_arg1:Event):void{
            dispatchEvent(_arg1.clone());
        }
        public function get showRunoutNavigator():Boolean{
            if (this.runoutNavigator.parent){
                return (true);
            };
            return (false);
        }
        public function set showRunoutNavigator(_arg1:Boolean):void{
            this.runoutNavigator.playList.datas = this._recommendListData;
            this.runoutNavigator.shareCanvas.shareOptionDatas = this._shareOptionDatas;
            this.runoutNavigator.shareCanvas.htmlCode = this._htmlUrl;
            this.runoutNavigator.shareCanvas.flashUrl = this._flashUrl;
            this.runoutNavigator.shareCanvas.videoUrl = this._videoUrl;
            this.runoutNavigator.shareCanvas.reset();
            this.showOrHidenPanel(this.runoutNavigator, _arg1);
            displayArea.panelLayer.showBackground = _arg1;
        }
        public function set showReportPanel(_arg1:Boolean):void{
            if (_arg1){
                this.reportPanel.rest();
            };
            this.showOrHidenPanel(this.reportPanel, _arg1);
        }
        public function showOrHidenPanel(_arg1:Container, _arg2:Boolean):void{
            if (_arg1){
                if (_arg2){
                    if (this._currentShowPanel == _arg1){
                        if (!_arg1.parent){
                            this.showMessagePanel(_arg1);
                        };
                    } else {
                        if (((this._currentShowPanel) && (this._currentShowPanel.parent))){
                            this.hidenMessagePanel(this._currentShowPanel);
                        };
                        this.showMessagePanel(_arg1);
                        this._currentShowPanel = _arg1;
                    };
                } else {
                    if ((((this._currentShowPanel == _arg1)) && (this._currentShowPanel.parent))){
                        this.hidenMessagePanel(_arg1);
                    };
                };
            };
        }
        private function shareCanvasEventHandler(_arg1:ShareEvent):void{
            dispatchEvent(_arg1.clone());
        }
        private function runoutNavigatorOnItemClick(_arg1:NominateListEvent):void{
            dispatchEvent(_arg1.clone());
        }
        public function showPanel(_arg1:DisplayObject):void{
            if (!_arg1.parent){
                displayArea.panelLayer.addChild(_arg1);
            };
        }
        public function hidenPanel(_arg1:DisplayObject):void{
            if (_arg1.parent){
                displayArea.panelLayer.removeChild(_arg1);
            };
        }
        public function get customPanel():CustomPanel{
            if (!this._customPanel){
                this._customPanel = new CustomPanel();
                this._customPanel.verticalCenter = 0;
                this._customPanel.horizontalCenter = 0;
                this._customPanel.addEventListener("customPanelClick", this.customPanelOnCustomPanelClick);
                this._customPanel.addEventListener(Panel.CLOSED_EVENT, this.customPanelOnClosed);
            };
            return (this._customPanel);
        }
        private function customPanelOnCustomPanelClick(_arg1:Event):void{
            dispatchEvent(_arg1.clone());
        }
        private function customPanelOnClosed(_arg1:Event):void{
            this.showCustomPanel = false;
        }
        public function get downloadPanel():DownloaderPanel{
            if (!this._downloadPanel){
                this._downloadPanel = new DownloaderPanel();
                this._downloadPanel.verticalCenter = 0;
                this._downloadPanel.horizontalCenter = 0;
                this._downloadPanel.addEventListener(DownloadePanelEvent.DOWNLOADE, this.downloadPanelEventHandler);
                this._downloadPanel.addEventListener(DownloadePanelEvent.COPY, this.downloadPanelEventHandler);
                this._downloadPanel.addEventListener(Panel.CLOSED_EVENT, this.downloadPanelOnClosed);
            };
            return (this._downloadPanel);
        }
        private function downloadPanelEventHandler(_arg1:DownloadePanelEvent):void{
            dispatchEvent(_arg1.clone());
        }
        private function downloadPanelOnClosed(_arg1:Event):void{
            this.showDownloadPanel = false;
        }
        protected function scaleComponent(_arg1:DisplayObject):void{
            var _local2:Number;
            var _local3:Number;
            var _local4:Number;
            var _local5:Number;
            var _local6:Number;
            if (_arg1){
                _local2 = (_arg1.width / _arg1.height);
                if ((displayArea.width / _local2) > displayArea.height){
                    _local3 = (displayArea.height * _local2);
                    _local4 = displayArea.height;
                } else {
                    _local3 = displayArea.width;
                    _local4 = (displayArea.width / _local2);
                };
                _local5 = (_local3 / (_arg1.width / _arg1.scaleX));
                _local6 = (_local4 / (_arg1.height / _arg1.scaleY));
                if ((((_arg1.width > _local3)) || ((_arg1.width < (_arg1.width / _arg1.scaleX))))){
                    if ((((_local5 > 0)) && ((_local6 > 0)))){
                        _arg1.scaleX = _local5;
                        _arg1.scaleY = _local6;
                    };
                } else {
                    if ((((_arg1.height > _local4)) || ((_arg1.height < (_arg1.height / _arg1.scaleY))))){
                        if ((((_local5 > 0)) && ((_local6 > 0)))){
                            _arg1.scaleX = _local5;
                            _arg1.scaleY = _local6;
                        };
                    } else {
                        _arg1.scaleX = 1;
                        _arg1.scaleY = 1;
                    };
                };
            };
        }
        public function get sharePanel():SharePanel{
            if (!this._sharePanel){
                this._sharePanel = new SharePanel();
                this._sharePanel.verticalCenter = 0;
                this._sharePanel.horizontalCenter = 0;
                this._sharePanel.addEventListener(ShareEvent.SHARE_KAIXIN, this.shareCanvasEventHandler);
                this._sharePanel.addEventListener(ShareEvent.SHARE_QQ, this.shareCanvasEventHandler);
                this._sharePanel.addEventListener(ShareEvent.SHARE_RENREN, this.shareCanvasEventHandler);
                this._sharePanel.addEventListener(ShareEvent.SHARE_TENXUN, this.shareCanvasEventHandler);
                this._sharePanel.addEventListener(ShareEvent.SHARE_XINLANG, this.shareCanvasEventHandler);
                this._sharePanel.addEventListener(ShareEvent.COPY_FLASHURL, this.shareCanvasEventHandler);
                this._sharePanel.addEventListener(ShareEvent.COPY_HTMLCODE, this.shareCanvasEventHandler);
                this._sharePanel.addEventListener(ShareEvent.COPY_VIDEOURL, this.shareCanvasEventHandler);
                this._sharePanel.addEventListener(Panel.CLOSED_EVENT, this.sharePanelOnClosed);
            };
            return (this._sharePanel);
        }
        private function sharePanelOnClosed(_arg1:Event):void{
            this.showSharePanel = false;
        }
        public function get settingPanel():SettingPanel{
            if (!this._settingPanel){
                this._settingPanel = new SettingPanel();
                this._settingPanel.verticalCenter = 0;
                this._settingPanel.horizontalCenter = 0;
                this._settingPanel.addEventListener(Panel.CLOSED_EVENT, this.settingPanelOnClosed);
                this._settingPanel.setUpPanelData.addEventListener(SetUpPanelDataEvent.ARTICULATION_CHANGE, this.setUpPanelDataChange);
                this._settingPanel.setUpPanelData.addEventListener(SetUpPanelDataEvent.ARTICULATION_ENABLED_CHANGE, this.setUpPanelDataChange);
                this._settingPanel.setUpPanelData.addEventListener(SetUpPanelDataEvent.VIDEO_SCALE_CHANGE, this.setUpPanelDataChange);
                this._settingPanel.setUpPanelData.addEventListener(SetUpPanelDataEvent.LIGHTVALUE_CHANGE, this.setUpPanelDataChange);
                this._settingPanel.setUpPanelData.addEventListener(SetUpPanelDataEvent.CONTRASTVALUE_CHANGE, this.setUpPanelDataChange);
                this._settingPanel.addEventListener(SetUpPanelDataEvent.LIGHTVALUE_CONTRASTVALUE_REST, this.setUpPanelDataChange);
            };
            return (this._settingPanel);
        }
        protected function setUpPanelDataChange(_arg1:SetUpPanelDataEvent):void{
            switch (_arg1.type){
                case SetUpPanelDataEvent.ARTICULATION_CHANGE:
                    this.articulationPanel.articulation = this.setUpPanelData.articulation;
                    break;
                case SetUpPanelDataEvent.ARTICULATION_ENABLED_CHANGE:
                    this.articulationPanel.articulationCanvas.articulationEnabled = this.setUpPanelData.articulationEnabled;
                    break;
                case SetUpPanelDataEvent.VIDEO_SCALE_CHANGE:
                    this.videoScalePanel.videoScale = this.setUpPanelData.videoScale;
                    break;
                case SetUpPanelDataEvent.LIGHTVALUE_CHANGE:
                    this.luminancePanel.lightValue = this.setUpPanelData.lightValue;
                    break;
                case SetUpPanelDataEvent.CONTRASTVALUE_CHANGE:
                    this.luminancePanel.contrastValue = this.setUpPanelData.contrastValue;
                    break;
            };
            dispatchEvent(_arg1.clone());
        }
        protected function settingPanelOnClosed(_arg1:Event):void{
            this.showSettingPanel = false;
        }
        public function get loaderSpinner():LoaderSpinner{
            if (!this._loaderSpinner){
                this._loaderSpinner = new LoaderSpinner();
                this._loaderSpinner.visible = false;
                this._loaderSpinner.controlID = "loaderSpinner";
            };
            return (this._loaderSpinner);
        }
        public function get autoHidenSetupMenu():Boolean{
            return (this._autoHidenSetupMenu);
        }
        public function set autoHidenSetupMenu(_arg1:Boolean):void{
            if (this._autoHidenSetupMenu != _arg1){
                this._autoHidenSetupMenu = _arg1;
            };
            if (!this._autoHidenSetupMenu){
                this.setUpMenuMoveIn();
            } else {
                this.setUpMenuHidenTimer.reset();
                this.setUpMenuHidenTimer.start();
            };
        }
        private function get setUpMenuHidenTimer():Timer{
            if (!this._setUpMenuHidenTimer){
                this._setUpMenuHidenTimer = new Timer(2000, 1);
                this._setUpMenuHidenTimer.addEventListener(TimerEvent.TIMER, this.setupMenuOnTimer);
            };
            return (this._setUpMenuHidenTimer);
        }
        private function setupMenuOnTimer(_arg1:TimerEvent):void{
            this.setupMenuHidenEffcet();
        }
        public function setupMenuShowEffcet():void{
            if (this._autoHidenSetupMenu){
                this.setUpMenuMoveIn();
            };
        }
        public function setupMenuHidenEffcet():void{
            if (this._autoHidenSetupMenu){
                this.setUpMenuMoveOut();
            };
        }
        private function setUpMenuMoveIn():void{
            var _local1:Number = 0;
            TweenNano.to(this.setupMenu, 0.3, {right:_local1});
        }
        private function setUpMenuMoveOut():void{
            var _local1:Number = (0 - this.setupMenu.width);
            TweenNano.to(this.setupMenu, 0.3, {right:_local1});
        }
        public function get setupMenu():SetUpMenu{
            if (!this._setupMenu){
                this._setupMenu = new SetUpMenu();
                this._setupMenu.right = 0;
                this._setupMenu.verticalCenter = 0;
                this._setupMenu.addEventListener(SetUpMenuEvent.ITEM_CLICK, this.setupMenuOnItemClick);
                this._setupMenu.skinName = "setupMenuSkin";
                this._setupMenu.controlID = "setupMenu";
            };
            return (this._setupMenu);
        }
        public function set showSetUpMenu(_arg1:Boolean):void{
            this.setupMenu.visible = _arg1;
        }
        protected function setupMenuOnItemClick(_arg1:SetUpMenuEvent):void{
            switch (_arg1.itemdata.type){
                case SetUpMenuItemVO.SETUP:
                    this.showSettingPanel = !(this.showSettingPanel);
                    break;
                case SetUpMenuItemVO.ARTICULATION:
                    this.showArticulationPanel = !(this.showArticulationPanel);
                    break;
                case SetUpMenuItemVO.LUMINANCE:
                    this.showLuminancePanel = !(this.showLuminancePanel);
                    break;
                case SetUpMenuItemVO.VIDEOSCALE:
                    this.showVideoScalePanel = !(this.showVideoScalePanel);
                    break;
                case SetUpMenuItemVO.SHARE:
                    this.sharePanel.canvas.shareOptionDatas = this._shareOptionDatas;
                    this.sharePanel.canvas.htmlCode = this._htmlUrl;
                    this.sharePanel.canvas.flashUrl = this._flashUrl;
                    this.sharePanel.canvas.videoUrl = this._videoUrl;
                    this.sharePanel.canvas.reset();
                    this.showSharePanel = !(this.showSharePanel);
                    break;
                case SetUpMenuItemVO.DOWNLOAD:
                    this.downloadPanel.url = this._downloaderUrl;
                    this.showDownloadPanel = !(this.showDownloadPanel);
                    break;
            };
            dispatchEvent(_arg1.clone());
        }
        public function get showArticulationPanel():Boolean{
            return (this.panelVisible(this.articulationPanel));
        }
        public function set showArticulationPanel(_arg1:Boolean):void{
            this.showOrHidenPanel(this.articulationPanel, _arg1);
        }
        public function get showLuminancePanel():Boolean{
            return (this.panelVisible(this.luminancePanel));
        }
        public function set showLuminancePanel(_arg1:Boolean):void{
            this.showOrHidenPanel(this.luminancePanel, _arg1);
        }
        public function get showVideoScalePanel():Boolean{
            return (this.panelVisible(this.videoScalePanel));
        }
        public function set showVideoScalePanel(_arg1:Boolean):void{
            this.showOrHidenPanel(this.videoScalePanel, _arg1);
        }
        public function get showSettingPanel():Boolean{
            return (this.panelVisible(this.settingPanel));
        }
        public function set showSettingPanel(_arg1:Boolean):void{
            this.showOrHidenPanel(this.settingPanel, _arg1);
        }
        public function get showSharePanel():Boolean{
            return (this.panelVisible(this.sharePanel));
        }
        public function set showSharePanel(_arg1:Boolean):void{
            this.sharePanel.canvas.shareOptionDatas = this._shareOptionDatas;
            this.showOrHidenPanel(this.sharePanel, _arg1);
        }
        public function get showDownloadPanel():Boolean{
            return (this.panelVisible(this.downloadPanel));
        }
        public function set showDownloadPanel(_arg1:Boolean):void{
            this.downloadPanel.reset();
            this.showOrHidenPanel(this.downloadPanel, _arg1);
        }
        public function get showAlertPanel():Boolean{
            return (this.panelVisible(this.alertPanel));
        }
        public function set showAlertPanel(_arg1:Boolean):void{
            this.showOrHidenPanel(this.alertPanel, _arg1);
        }
        public function get showCustomPanel():Boolean{
            return (this.panelVisible(this.customPanel));
        }
        public function panelVisible(_arg1:DisplayObject):Boolean{
            if (_arg1.parent){
                return (true);
            };
            return (false);
        }
        public function set showCustomPanel(_arg1:Boolean):void{
            if (_arg1){
                if (this._currentShowPanel == this.customPanel){
                    if (!this.customPanel.parent){
                        this.showMessagePanel(this.customPanel);
                    } else {
                        this.hidenMessagePanel(this.customPanel);
                        this.showMessagePanel(this.customPanel);
                    };
                } else {
                    if (((this._currentShowPanel) && (this._currentShowPanel.parent))){
                        this.hidenMessagePanel(this._currentShowPanel);
                    };
                    this._currentShowPanel = this.customPanel;
                    this.showMessagePanel(this.customPanel);
                };
                this.customPanel.contentLyout = this._customPanelTextLayout;
                this.customPanel.text = this._customPanelText;
                this.customPanel.loaderImage(this._customPanelImageUrl);
                this.customPanel.hrefUrl = this._customPanelImageHref;
                this.customPanel.title = this._customPanelTitle;
            } else {
                if ((((this._currentShowPanel == this.customPanel)) && (this._currentShowPanel.parent))){
                    this.hidenMessagePanel(this.customPanel);
                };
            };
        }
        override protected function basePlayeruiOnMouseMove(_arg1:MouseEvent):void{
            super.basePlayeruiOnMouseMove(_arg1);
            this.setupMenuShowEffcet();
            if (this._autoHidenSetupMenu){
                this.setUpMenuHidenTimer.reset();
                this.setUpMenuHidenTimer.start();
            };
        }
        override protected function baseStageOnMouseLeave(_arg1:Event):void{
            super.baseStageOnMouseLeave(_arg1);
            this.setupMenuHidenEffcet();
        }
        override protected function createChildren():void{
            super.createChildren();
            displayArea.subjoinLayer.addChild(this.bufferHead);
            displayArea.subjoinLayer.addChild(this.logo);
            displayArea.subjoinLayer.addChild(this.setupMenu);
            displayArea.subjoinLayer.addChild(this.loaderSpinner);
            this.showPanel(this.settingPanel);
            this.hidenPanel(this.settingPanel);
            this.showPanel(this.sharePanel);
            this.hidenPanel(this.sharePanel);
            this.showPanel(this.downloadPanel);
            this.hidenPanel(this.downloadPanel);
            this.showPanel(this.customPanel);
            this.hidenPanel(this.customPanel);
            this.showPanel(this.runoutNavigator);
            this.hidenPanel(this.runoutNavigator);
            this.showPanel(this.reportPanel);
            this.hidenPanel(this.reportPanel);
            this.showPanel(this.videoScalePanel);
            this.hidenPanel(this.videoScalePanel);
            this.showPanel(this.luminancePanel);
            this.hidenPanel(this.luminancePanel);
            this.showPanel(this.articulationPanel);
            this.hidenPanel(this.articulationPanel);
            this.showPanel(this.alertPanel);
            this.hidenPanel(this.alertPanel);
        }
        public function showLoading():void{
            this.loaderSpinner.visible = true;
            this.loaderSpinner.start();
        }
        public function hidenLoading():void{
            this.loaderSpinner.visible = false;
            this.loaderSpinner.stop();
        }
        public function loadingDelay(_arg1:Number):void{
            this.loaderSpinner.delay = _arg1;
        }
        public function loadingAngle(_arg1:Number):void{
            this.loaderSpinner.angle = _arg1;
        }
        public function loadingText(_arg1:String):void{
            this.loaderSpinner.text = _arg1;
        }
        private function hidenMessagePanel(_arg1:Container):void{
            displayArea.panelLayer.showBackground = false;
            var _local2:Point = getCenter();
            this.hidenEffcet(_arg1, _arg1.x, _arg1.y, _local2.x, _local2.y);
        }
        private function unloadImage(_arg1:DisplayObject):void{
            if ((_arg1 is CustomPanel)){
                this.customPanel.loaderImage("");
            };
        }
        private function showMessagePanel(_arg1:Container):void{
            displayArea.panelLayer.showBackground = false;
            this.scaleComponent(_arg1);
            var _local2:Point = displayArea.getCenter();
            var _local3:Number = _local2.x;
            var _local4:Number = _local2.y;
            var _local5:Number = (_local3 - (0.5 * _arg1.width));
            var _local6:Number = (_local4 - (0.5 * _arg1.height));
            this.showEffcet(_arg1, _local3, _local4, _local5, _local6);
        }
        private function showEffcet(_arg1:DisplayObject, _arg2:Number, _arg3:Number, _arg4:Number, _arg5:Number):void{
            this.showPanel(_arg1);
            var _local6:Number = _arg1.scaleX;
            var _local7:Number = _arg1.scaleY;
            _arg1.scaleX = 0;
            _arg1.scaleY = 0;
            _arg1.alpha = 0;
            TweenNano.to(_arg1, 0.2, {
                scaleX:_local6,
                scaleY:_local7,
                x:_arg4,
                y:_arg5,
                alpha:1
            });
        }
        private function hidenEffcet(_arg1:DisplayObject, _arg2:Number, _arg3:Number, _arg4:Number, _arg5:Number):void{
            var target:* = _arg1;
            var xfrom:* = _arg2;
            var yfrom:* = _arg3;
            var xto:* = _arg4;
            var yto:* = _arg5;
            TweenNano.to(target, 0.2, {
                scaleX:0,
                scaleY:0,
                x:xto,
                y:yto,
                alpha:0,
                onComplete:function ():void{
                    hidenPanel(target);
                    target.scaleX = 1;
                    target.scaleY = 1;
                }
            });
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            this.scaleComponent(this._currentShowPanel);
        }
        override protected function displayAreaOnResize(_arg1:Event):void{
            super.displayAreaOnResize(_arg1);
            this.measureSetupMenu();
            this.scaleComponent(this._currentShowPanel);
        }

    }
}//package com.bokecc.player.ui 
