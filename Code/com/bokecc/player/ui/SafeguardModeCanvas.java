package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class SafeguardModeCanvas extends Canvas {

        private var _videoTitleLabel:Label;
        private var _videoTitleBox:HBox;
        private var _playerButton:BaseButton;
        private var _playerButtonBox:VBox;
        private var _videoUrlInput:TextInput;
        private var _footBox:Canvas;
        private var _videoUrlInputBox:VBox;
        private var copyLabel:Label;
        private var hbox:HBox;

        public function get videoUr():String{
            return (this.videoUrlInput.text);
        }
        public function set videoUr(_arg1:String):void{
            this.videoUrlInput.text = _arg1;
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get videoUrlInputBox():VBox{
            var _local1:Label;
            if (!this._videoUrlInputBox){
                this._videoUrlInputBox = new VBox();
                this._videoUrlInputBox.horizontalAlign = Align.CENTER;
                this._videoUrlInputBox.horizontalCenter = 0;
                this._videoUrlInputBox.verticalCenter = 60;
                _local1 = this.getLabel("如果无法弹出，请复制播放地址到浏览器地址栏观看", 0xAAAAAA);
                this._videoUrlInputBox.addChild(_local1);
                this.hbox = new HBox();
                this.hbox.addChild(this.videoUrlInput);
                this.copyLabel = this.getLabel("复制", 0xFFFFFF);
                this.copyLabel.addEventListener(MouseEvent.CLICK, this.copyLabelOnClick);
                this.copyLabel.buttonMode = true;
                this.hbox.addChild(this.copyLabel);
                this._videoUrlInputBox.addChild(this.hbox);
            };
            return (this._videoUrlInputBox);
        }
        private function copyLabelOnClick(_arg1:MouseEvent):void{
            this.copyLabel.text = "已复制";
            if (this.hbox){
                this.hbox.updateDisplayList();
            };
            dispatchEvent(new SafeguardModeCanvasEvent(SafeguardModeCanvasEvent.SAFEGUARDMODE_COPY, this.videoUrlInput.text));
        }
        public function get footBox():Canvas{
            var _local1:Label;
            if (!this._footBox){
                this._footBox = new Canvas();
                this._footBox.left = 0;
                this._footBox.right = 0;
                this._footBox.bottom = 0;
                this._footBox.height = 60;
                _local1 = this.getLabel("视频技术由CC视频提供", 0xAAAAAA);
                _local1.horizontalCenter = 0;
                _local1.top = 20;
                this._footBox.addChild(_local1);
            };
            return (this._footBox);
        }
        public function get playerButtonBox():VBox{
            var _local1:Label;
            if (!this._playerButtonBox){
                this._playerButtonBox = new VBox();
                this._playerButtonBox.horizontalAlign = Align.CENTER;
                this._playerButtonBox.horizontalCenter = 0;
                this._playerButtonBox.verticalCenter = -30;
                this._playerButtonBox.addChild(this.playerButton);
                _local1 = this.getLabel("点击播放按钮将弹出新窗口播放", 0xFFFFFF);
                this._playerButtonBox.addChild(_local1);
            };
            return (this._playerButtonBox);
        }
        public function get videoTitleBox():HBox{
            if (!this._videoTitleBox){
                this._videoTitleBox = new HBox();
                this._videoTitleBox.left = 0;
                this._videoTitleBox.right = 0;
                this._videoTitleBox.height = 30;
                this._videoTitleBox.addChild(this.videoTitleLabel);
            };
            return (this._videoTitleBox);
        }
        public function get playerButton():BaseButton{
            if (!this._playerButton){
                this._playerButton = new BaseButton();
                this._playerButton.addEventListener(MouseEvent.CLICK, this.playerButtonOnClick);
                this._playerButton.skinName = "safeguardModeButton";
            };
            return (this._playerButton);
        }
        private function playerButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new SafeguardModeCanvasEvent(SafeguardModeCanvasEvent.SAFEGUARDMODE_CLICK, this.videoUrlInput.text));
        }
        public function get videoUrlInput():TextInput{
            if (!this._videoUrlInput){
                this._videoUrlInput = new TextInput();
                this._videoUrlInput.editEnabled = false;
                this._videoUrlInput.width = 200;
                this._videoUrlInput.height = 20;
            };
            return (this._videoUrlInput);
        }
        public function get videoTitle():String{
            return (this.videoTitleLabel.text);
        }
        public function set videoTitle(_arg1:String):void{
            this.videoTitleLabel.text = _arg1;
        }
        public function get videoTitleLabel():Label{
            if (!this._videoTitleLabel){
                this._videoTitleLabel = new Label();
                this._videoTitleLabel.color = 268435455;
                this._videoTitleLabel.text = "视频标题";
                this._videoTitleLabel.fontSize = 15;
            };
            return (this._videoTitleLabel);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.videoTitleBox);
            this.addChild(this.playerButton);
            this.addChild(this.playerButtonBox);
            this.addChild(this.videoUrlInputBox);
            this.addChild(this.footBox);
        }
        private function getLabel(_arg1:String, _arg2:uint, _arg3:int=12):Label{
            var _local4:Label = new Label();
            _local4.color = _arg2;
            _local4.fontSize = _arg3;
            _local4.text = _arg1;
            return (_local4);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            var _local1:Graphics = this.graphics;
            _local1.clear();
            _local1.beginFill(0, 1);
            _local1.drawRect(0, 0, this.width, this.height);
            _local1.endFill();
        }
        public function reset():void{
            if (this.copyLabel){
                this.copyLabel.text = "复制";
            };
        }

    }
}//package com.bokecc.player.ui 
