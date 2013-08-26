package com.bokecc.player.ui {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.events.*;
    import com.bokecc.containers.*;

    public class RecoverMessageBox extends Canvas {

        private var _icon:BaseButton;
        private var _messageLabel:Label;
        private var _closeButton:BaseButton;
        private var _componentBox:HBox;

        public function RecoverMessageBox(){
            this.height = 28;
            this.left = 0;
            this.right = 0;
        }
        public function get messageText():String{
            return (this.messageLabel.htmlText);
        }
        public function set messageText(_arg1:String):void{
            this.messageLabel.htmlText = _arg1;
            this.componentBox.updateDisplayList();
        }
        public function get componentBox():HBox{
            if (!this._componentBox){
                this._componentBox = new HBox();
                this._componentBox.horizontalGap = 10;
                this._componentBox.left = 10;
                this._componentBox.verticalAlign = Align.CENTER;
                this._componentBox.addChild(this.icon);
                this._componentBox.addChild(this.messageLabel);
                this._componentBox.addChild(this.closeButton);
            };
            return (this._componentBox);
        }
        public function get closeButton():BaseButton{
            if (!this._closeButton){
                this._closeButton = new BaseButton();
                this._closeButton.skinName = "recoverMessageBoxCloseButton";
                this._closeButton.addEventListener(MouseEvent.CLICK, this.closeButtonOnClick);
            };
            return (this._closeButton);
        }
        private function closeButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new Event("close"));
        }
        public function get messageLabel():Label{
            if (!this._messageLabel){
                this._messageLabel = new Label();
                this._messageLabel.mouseChildren = true;
                this._messageLabel.addEventListener(CCTextEvent.LINK, this.messageLabelOnLink);
            };
            return (this._messageLabel);
        }
        private function messageLabelOnLink(_arg1:CCTextEvent):void{
            dispatchEvent(_arg1.clone());
        }
        public function get icon():BaseButton{
            if (!this._icon){
                this._icon = new BaseButton();
                this._icon.skinName = "recoverMessageBoxIcon";
            };
            return (this._icon);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.componentBox);
        }

    }
}//package com.bokecc.player.ui 
