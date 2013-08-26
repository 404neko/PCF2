package com.bokecc.controls {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.text.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.events.*;
    import com.bokecc.containers.*;

    public class Alert extends Panel {

        private static var alertList:Array = [];

        private var _okButton:TextButton;
        private var _cancelButton:TextButton;
        private var _messageText:String;
        private var _messageLabel:Label;
        private var _detail:Boolean;
        private var _buttonBox:HBox;

        public function Alert(){
            this.headHeight = 50;
            this.width = 288;
            this.height = 215;
            this.titleAlign = Align.CENTER;
            this.showClose = false;
        }
        public static function show(_arg1:Application, _arg2:String="", _arg3:String="", _arg4:Function=null, _arg5:Function=null):Alert{
            var alert:* = null;
            var app:* = _arg1;
            var text:String = _arg2;
            var title:String = _arg3;
            var closeHandler = _arg4;
            var textEventHandler = _arg5;
            alert = new (Alert)();
            alert.verticalCenter = 0;
            alert.horizontalCenter = 0;
            alert.messageText = text;
            alert.title = title;
            alert.addEventListener("closed", function (_arg1:Event):void{
                app.hidenMessagePanel(alert);
                var _local2:int = alertList.indexOf(alert);
                if (_local2 > -1){
                    alertList.splice(_local2, 1);
                };
            });
            if (null != closeHandler){
                alert.addEventListener("closed", closeHandler);
            };
            if (null != textEventHandler){
                alert.addEventListener(CCTextEvent.LINK, textEventHandler);
            };
            app.showMessagePanel(alert);
            alertList.push(alert);
            return (alert);
        }
        public static function hidenAllAlert(_arg1:Application):void{
            var _local2:Alert;
            for each (_local2 in alertList) {
                _arg1.hidenMessagePanel(_local2);
            };
            alertList = [];
        }

        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get buttonBox():HBox{
            if (!this._buttonBox){
                this._buttonBox = new HBox();
                this._buttonBox.horizontalGap = 20;
                this._buttonBox.horizontalCenter = 0;
                this._buttonBox.bottom = 20;
            };
            return (this._buttonBox);
        }
        public function get detail():Boolean{
            return (this._detail);
        }
        public function get messageText():String{
            return (this._messageText);
        }
        public function set messageText(_arg1:String):void{
            if (this._messageText != _arg1){
                this._messageText = _arg1;
                this.messageLabel.htmlText = this._messageText;
                if (this.messageLabel.width > 260){
                    this.messageLabel.wordWrap = true;
                    this.messageLabel.width = 260;
                };
            };
        }
        public function get messageLabel():Label{
            if (!this._messageLabel){
                this._messageLabel = new Label();
                this._messageLabel.align = TextFormatAlign.CENTER;
                this._messageLabel.mouseChildren = true;
                this._messageLabel.color = 0xFFFFFF;
                this._messageLabel.addEventListener(CCTextEvent.LINK, this.messageLabelOnLink);
                this._messageLabel.verticalCenter = 0;
                this._messageLabel.horizontalCenter = 0;
            };
            return (this._messageLabel);
        }
        private function messageLabelOnLink(_arg1:CCTextEvent):void{
            dispatchEvent(_arg1.clone());
        }
        public function get cancelButton():TextButton{
            if (!this._cancelButton){
                this._cancelButton = new TextButton();
                this._cancelButton.addEventListener(LAYOUT_CHANGE, this.buttonOnResize);
                this._cancelButton.addEventListener(MouseEvent.CLICK, this.cancelButtonOnClick);
                this._cancelButton.label = "取消";
            };
            return (this._cancelButton);
        }
        private function cancelButtonOnClick(_arg1:MouseEvent):void{
            this._detail = false;
            dispatchEvent(new CloseEvent(CloseEvent.CLOSE, this._detail));
        }
        public function get okButton():TextButton{
            if (!this._okButton){
                this._okButton = new TextButton();
                this._okButton.addEventListener(LAYOUT_CHANGE, this.buttonOnResize);
                this._okButton.addEventListener(MouseEvent.CLICK, this.okButtonOnClick);
                this._okButton.label = "确定";
            };
            return (this._okButton);
        }
        private function buttonOnResize(_arg1:Event):void{
            this.buttonBox.updateDisplayList();
        }
        private function okButtonOnClick(_arg1:MouseEvent):void{
            this._detail = true;
            dispatchEvent(new CloseEvent(CloseEvent.CLOSE, this._detail));
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.messageLabel);
            this.buttonBox.addChild(this.okButton);
            this.buttonBox.addChild(this.cancelButton);
            this.addChild(this.buttonBox);
        }
        public function showOkButton(_arg1:Boolean):void{
            if (_arg1){
                if (!this.okButton.parent){
                    this.buttonBox.addChild(this.okButton);
                };
            } else {
                if (this.okButton.parent){
                    this.buttonBox.removeChild(this.okButton);
                };
            };
        }
        public function showCancelButton(_arg1:Boolean):void{
            if (_arg1){
                if (!this.cancelButton.parent){
                    this.buttonBox.addChild(this.cancelButton);
                };
            } else {
                if (this.cancelButton.parent){
                    this.buttonBox.removeChild(this.cancelButton);
                };
            };
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

    }
}//package com.bokecc.controls 
