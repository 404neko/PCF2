package com.bokecc.player.ui {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class DownloaderPanel extends Panel {

        private var _inputBox:HBox;
        private var _textLabel:Label;
        private var _urlInput:TextInput;
        private var _buttonBox:HBox;
        private var _copyButton:TextButton;
        private var _openButton:TextButton;

        public function DownloaderPanel(){
            this.headHeight = 30;
            this.width = 422;
            this.height = 160;
            this.title = "下载";
            this.titleAlign = Align.CENTER;
            this.horizontalAlign = Align.LEFT;
        }
        public function get url():String{
            return (this.urlInput.text);
        }
        public function set url(_arg1:String):void{
            this.urlInput.text = _arg1;
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get openButton():TextButton{
            if (!this._openButton){
                this._openButton = new TextButton();
                this._openButton.setSize(54, 21);
                this._openButton.addEventListener(MouseEvent.CLICK, this.openButtonOnClick);
                this._openButton.label = "打开";
            };
            return (this._openButton);
        }
        private function openButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new DownloadePanelEvent(DownloadePanelEvent.DOWNLOADE, this.urlInput.text));
        }
        public function get copyButton():TextButton{
            if (!this._copyButton){
                this._copyButton = new TextButton();
                this._copyButton.setSize(54, 21);
                this._copyButton.addEventListener(MouseEvent.CLICK, this.copyButtonOnClick);
                this._copyButton.label = "复制";
            };
            return (this._copyButton);
        }
        private function copyButtonOnClick(_arg1:MouseEvent):void{
            this.copyButton.label = "已复制";
            dispatchEvent(new DownloadePanelEvent(DownloadePanelEvent.COPY, this.urlInput.text));
        }
        public function get buttonBox():HBox{
            if (!this._buttonBox){
                this._buttonBox = new HBox();
                this._buttonBox.right = 10;
                this._buttonBox.bottom = 15;
                this._buttonBox.addChild(this.copyButton);
                this._buttonBox.addChild(this.openButton);
            };
            return (this._buttonBox);
        }
        public function get urlInput():TextInput{
            if (!this._urlInput){
                this._urlInput = new TextInput();
                this._urlInput.color = 0xFFFFFF;
                this._urlInput.backgroundAlpha = 0;
                this._urlInput.editEnabled = false;
                this._urlInput.percentWidth = 1;
            };
            return (this._urlInput);
        }
        public function get textLabel():Label{
            if (!this._textLabel){
                this._textLabel = new Label();
                this._textLabel.color = 0xFFFFFF;
                this._textLabel.text = "视频地址:";
            };
            return (this._textLabel);
        }
        public function get inputBox():HBox{
            if (!this._inputBox){
                this._inputBox = new HBox();
                this._inputBox.left = 10;
                this._inputBox.right = 10;
                this._inputBox.paddingLeft = 10;
                this._inputBox.verticalCenter = -10;
                this._inputBox.verticalAlign = Align.CENTER;
                this._inputBox.addChild(this.textLabel);
                this._inputBox.addChild(this.urlInput);
            };
            return (this._inputBox);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.inputBox);
            this.addChild(this.buttonBox);
        }
        override public function get titleLabel():Label{
            if (!_titleLabel){
                _titleLabel = new Label();
                _titleLabel.fontSize = 15;
                _titleLabel.color = 0xFFFFFF;
                _titleLabel.bold = true;
                _titleLabel.left = titlePadding;
                _titleLabel.verticalCenter = 0;
            };
            return (_titleLabel);
        }
        public function reset():void{
            this.copyButton.label = "复制";
        }

    }
}//package com.bokecc.player.ui 
