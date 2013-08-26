package com.bokecc.player.ui {
    import flash.events.*;
    import flash.utils.*;
    import com.bokecc.controls.*;
    import flash.text.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class ShareCanvas extends VBox {

        public static const SINAMINIBLOG:String = "sinaminiblog";
        public static const KAIXIN001:String = "kaixin001";
        public static const QZONE:String = "qzone";
        public static const QQMB:String = "qqmb";
        public static const RENREN:String = "renren";

        private var _shareLabel:Label;
        private var _videoLabel:Label;
        private var _videoInput:TextInput;
        private var _videoButton:TextButton;
        private var _flashLabel:Label;
        private var _flashInput:TextInput;
        private var _flashButton:TextButton;
        private var _htmlLabel:Label;
        private var _htmlInput:TextInput;
        private var _htmlButton:TextButton;
        private var _labelHBox:HBox;
        private var _videoUrl:String;
        private var _flashUrl:String;
        private var _htmlCode:String;
        private var _xinlangButton:BaseButton;
        private var _tengxunButton:BaseButton;
        private var _qqButton:BaseButton;
        private var _renrenButton:BaseButton;
        private var _kaixinButton:BaseButton;
        private var _shareOptionDatas:Array;
        private var shareOption:Dictionary;
        private var currenSelectButton:TextButton;
        private var _codePicture:Image;

        public function ShareCanvas(){
            this.horizontalAlign = Align.LEFT;
            this.paddingRight = 20;
            this.shareOption = new Dictionary();
            this.shareOption[SINAMINIBLOG] = this.xinlangButton;
            this.shareOption[QQMB] = this.tengxunButton;
            this.shareOption[QZONE] = this.qqButton;
            this.shareOption[RENREN] = this.renrenButton;
            this.shareOption[KAIXIN001] = this.kaixinButton;
            this._shareOptionDatas = [SINAMINIBLOG, QQMB, QZONE, RENREN, KAIXIN001];
            this.shareOptionDatas = this._shareOptionDatas;
        }
        public function get codePictureUrl():String{
            return (this.codePicture.url);
        }
        public function set codePictureUrl(_arg1:String):void{
        }
        public function get codePicture():Image{
            if (!this._codePicture){
                this._codePicture = new Image();
                this._codePicture.setSize(70, 70);
            };
            return (this._codePicture);
        }
        public function get shareOptionDatas():Array{
            return (this._shareOptionDatas);
        }
        public function set shareOptionDatas(_arg1:Array):void{
            var _local2:int;
            var _local3:String;
            var _local4:BaseButton;
            if (_arg1){
                this._shareOptionDatas = _arg1;
                _local2 = (this.labelHBox.numChildren - 1);
                while (_local2 >= 0) {
                    this.labelHBox.removeChildAt(_local2);
                    _local2--;
                };
                for each (_local3 in this._shareOptionDatas) {
                    _local4 = this.shareOption[_local3];
                    this.labelHBox.addChild(_local4);
                };
            };
        }
        public function get kaixinButton():BaseButton{
            if (!this._kaixinButton){
                this._kaixinButton = this.getIcon(KAIXIN001);
                this._kaixinButton.tooltip = "分享到开心网";
                this._kaixinButton.addEventListener(MouseEvent.CLICK, this.kaixinButtonOnClick);
            };
            return (this._kaixinButton);
        }
        public function get renrenButton():BaseButton{
            if (!this._renrenButton){
                this._renrenButton = this.getIcon(RENREN);
                this._renrenButton.tooltip = "分享到人人网";
                this._renrenButton.addEventListener(MouseEvent.CLICK, this.renrenButtonOnClick);
            };
            return (this._renrenButton);
        }
        public function get qqButton():BaseButton{
            if (!this._qqButton){
                this._qqButton = this.getIcon(QZONE);
                this._qqButton.tooltip = "分享到QQ空间";
                this._qqButton.addEventListener(MouseEvent.CLICK, this.qqButtonOnClick);
            };
            return (this._qqButton);
        }
        public function get tengxunButton():BaseButton{
            if (!this._tengxunButton){
                this._tengxunButton = this.getIcon(QQMB);
                this._tengxunButton.tooltip = "分享到腾讯微博";
                this._tengxunButton.addEventListener(MouseEvent.CLICK, this.tengxunButtonOnClick);
            };
            return (this._tengxunButton);
        }
        public function get xinlangButton():BaseButton{
            if (!this._xinlangButton){
                this._xinlangButton = this.getIcon(SINAMINIBLOG);
                this._xinlangButton.tooltip = "分享到新浪微博";
                this._xinlangButton.addEventListener(MouseEvent.CLICK, this.xinlangButtonOnClick);
            };
            return (this._xinlangButton);
        }
        public function get htmlCode():String{
            return (this._htmlCode);
        }
        public function set htmlCode(_arg1:String):void{
            if (this._htmlCode != _arg1){
                this._htmlCode = _arg1;
                this.htmlInput.text = this._htmlCode;
            };
        }
        public function get flashUrl():String{
            return (this._flashUrl);
        }
        public function set flashUrl(_arg1:String):void{
            if (this._flashUrl != _arg1){
                this._flashUrl = _arg1;
                this.flashInput.text = this._flashUrl;
            };
        }
        public function get videoUrl():String{
            return (this._videoUrl);
        }
        public function set videoUrl(_arg1:String):void{
            if (this._videoUrl != _arg1){
                this._videoUrl = _arg1;
                this.videoInput.text = this._videoUrl;
            };
        }
        public function get labelHBox():HBox{
            if (!this._labelHBox){
                this._labelHBox = new HBox();
                this._labelHBox.horizontalGap = 20;
                this._labelHBox.paddingRight = 15;
                this._labelHBox.paddingLeft = 0;
                this._labelHBox.verticalAlign = Align.CENTER;
            };
            return (this._labelHBox);
        }
        private function kaixinButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ShareEvent(ShareEvent.SHARE_KAIXIN));
        }
        private function renrenButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ShareEvent(ShareEvent.SHARE_RENREN));
        }
        private function qqButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ShareEvent(ShareEvent.SHARE_QQ));
        }
        private function tengxunButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ShareEvent(ShareEvent.SHARE_TENXUN));
        }
        private function xinlangButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ShareEvent(ShareEvent.SHARE_XINLANG));
        }
        private function getLabel(_arg1:String):Label{
            var _local2:Label = new Label();
            _local2.wordWrap = true;
            _local2.align = TextFormatAlign.RIGHT;
            _local2.text = _arg1;
            _local2.width = 70;
            _local2.color = 0xFFFFFF;
            return (_local2);
        }
        private function getIcon(_arg1:String):BaseButton{
            var _local2:BaseButton = new BaseButton();
            _local2.skinName = _arg1;
            return (_local2);
        }
        public function get shareLabel():Label{
            if (!this._shareLabel){
                this._shareLabel = this.getLabel("分享到:");
            };
            return (this._shareLabel);
        }
        public function get videoLabel():Label{
            if (!this._videoLabel){
                this._videoLabel = this.getLabel("视频地址:");
            };
            return (this._videoLabel);
        }
        public function get videoInput():TextInput{
            if (!this._videoInput){
                this._videoInput = new TextInput();
                this._videoInput.backgroundAlpha = 0;
                this._videoInput.color = 0xFFFFFF;
                this._videoInput.editEnabled = false;
                this._videoInput.width = 260;
            };
            return (this._videoInput);
        }
        public function get videoButton():TextButton{
            if (!this._videoButton){
                this._videoButton = new TextButton();
                this._videoButton.setSize(54, 21);
                this._videoButton.addEventListener(MouseEvent.CLICK, this.videoButtonOnClick);
                this._videoButton.label = "复制";
            };
            return (this._videoButton);
        }
        private function videoButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ShareEvent(ShareEvent.COPY_VIDEOURL));
            this.selectButton(this.videoButton);
        }
        public function get flashLabel():Label{
            if (!this._flashLabel){
                this._flashLabel = this.getLabel("Flash地址: ");
            };
            return (this._flashLabel);
        }
        public function get flashInput():TextInput{
            if (!this._flashInput){
                this._flashInput = new TextInput();
                this._flashInput.color = 0xFFFFFF;
                this._flashInput.backgroundAlpha = 0;
                this._flashInput.editEnabled = false;
                this._flashInput.width = 260;
            };
            return (this._flashInput);
        }
        public function get flashButton():TextButton{
            if (!this._flashButton){
                this._flashButton = new TextButton();
                this._flashButton.setSize(54, 21);
                this._flashButton.addEventListener(MouseEvent.CLICK, this.flashButtonOnClick);
                this._flashButton.label = "复制";
            };
            return (this._flashButton);
        }
        private function flashButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ShareEvent(ShareEvent.COPY_FLASHURL));
            this.selectButton(this.flashButton);
        }
        public function get htmlLabel():Label{
            if (!this._htmlLabel){
                this._htmlLabel = this.getLabel("HTML代码: ");
            };
            return (this._htmlLabel);
        }
        public function get htmlInput():TextInput{
            if (!this._htmlInput){
                this._htmlInput = new TextInput();
                this._htmlInput.color = 0xFFFFFF;
                this._htmlInput.backgroundAlpha = 0;
                this._htmlInput.editEnabled = false;
                this._htmlInput.width = 260;
            };
            return (this._htmlInput);
        }
        public function get htmlButton():TextButton{
            if (!this._htmlButton){
                this._htmlButton = new TextButton();
                this._htmlButton.setSize(54, 21);
                this._htmlButton.addEventListener(MouseEvent.CLICK, this.htmlButtonOnClick);
                this._htmlButton.label = "复制";
            };
            return (this._htmlButton);
        }
        private function htmlButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ShareEvent(ShareEvent.COPY_HTMLCODE));
            this.selectButton(this.htmlButton);
        }
        private function selectButton(_arg1:TextButton):void{
            if (this.currenSelectButton){
                this.currenSelectButton.selected = false;
                this.currenSelectButton.label = "复制";
            };
            _arg1.selected = true;
            _arg1.label = "已复制";
            this.currenSelectButton = _arg1;
        }
        public function reset():void{
            this.htmlButton.selected = false;
            this.htmlButton.label = "复制";
            this.flashButton.selected = false;
            this.flashButton.label = "复制";
            this.videoButton.selected = false;
            this.videoButton.label = "复制";
        }
        override protected function createChildren():void{
            super.createChildren();
            var _local1:HBox = new HBox();
            _local1.verticalAlign = Align.BOTTOM;
            _local1.paddingBottom = 0;
            _local1.addChild(this.labelHBox);
            var _local2:HBox = new HBox();
            _local2.verticalAlign = Align.BOTTOM;
            _local2.addChild(this.shareLabel);
            _local2.addChild(_local1);
            var _local3:HBox = new HBox();
            _local3.verticalAlign = Align.CENTER;
            _local3.addChild(this.videoLabel);
            _local3.addChild(this.videoInput);
            _local3.addChild(this.videoButton);
            var _local4:HBox = new HBox();
            _local4.verticalAlign = Align.CENTER;
            _local4.addChild(this.flashLabel);
            _local4.addChild(this.flashInput);
            _local4.addChild(this.flashButton);
            var _local5:HBox = new HBox();
            _local5.verticalAlign = Align.CENTER;
            _local5.addChild(this.htmlLabel);
            _local5.addChild(this.htmlInput);
            _local5.addChild(this.htmlButton);
            this.addChild(_local2);
            this.addChild(_local3);
            this.addChild(_local4);
            this.addChild(_local5);
        }

    }
}//package com.bokecc.player.ui 
