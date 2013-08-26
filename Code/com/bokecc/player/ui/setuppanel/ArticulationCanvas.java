package com.bokecc.player.ui.setuppanel {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class ArticulationCanvas extends Canvas {

        public static const HIGH_DEFINITION:String = "highDefinition";
        public static const DEFINITION:String = "definition";
        public static const NORMAL_DEFINITION:String = "normalDefinition";

        private var _radioBox:HBox;
        private var radioGroup:RadioGroup;
        private var _commonButton:RadioButton;
        private var _commonButtonBox:HBox;
        private var _distinctButton:RadioButton;
        private var _distinctButtonBox:HBox;
        private var _hdButton:RadioButton;
        private var _hdButtonBox:HBox;
        private var _okButton:TextButton;
        private var _closedButton:TextButton;
        private var _articulation:String;
        private var _articulationEnabled:int = -1;
        private var _buttonBox:HBox;
        private var _messageLabel:Label;

        public function ArticulationCanvas(){
            this.radioGroup = new RadioGroup();
        }
        public function get articulationEnabled():int{
            return (this._articulationEnabled);
        }
        public function set articulationEnabled(_arg1:int):void{
            var _local2:int;
            var _local3:int;
            var _local4:int;
            if (this._articulationEnabled != _arg1){
                this._articulationEnabled = _arg1;
                _local2 = ((this._articulationEnabled & 4) >> 2);
                _local3 = ((this._articulationEnabled & 2) >> 1);
                _local4 = (this._articulationEnabled & 1);
                if (_local2 == 1){
                    this.radioBox.addChild(this.commonButtonBox);
                } else {
                    if (this.commonButtonBox.parent){
                        this.radioBox.removeChild(this.commonButtonBox);
                    };
                };
                if (_local3 == 1){
                    this.radioBox.addChild(this.distinctButtonBox);
                } else {
                    if (this.distinctButtonBox.parent){
                        this.radioBox.removeChild(this.distinctButtonBox);
                    };
                };
                if (_local4 == 1){
                    this.radioBox.addChild(this.hdButtonBox);
                    this.messageLabel.visible = true;
                } else {
                    if (this.hdButtonBox.parent){
                        this.radioBox.removeChild(this.hdButtonBox);
                    };
                    this.messageLabel.visible = false;
                };
            };
        }
        public function get articulation():String{
            return (this._articulation);
        }
        public function set articulation(_arg1:String):void{
            if (this._articulation != _arg1){
                this._articulation = _arg1;
                switch (this._articulation){
                    case HIGH_DEFINITION:
                        this.hdButton.selected = true;
                        break;
                    case DEFINITION:
                        this.distinctButton.selected = true;
                        break;
                    case NORMAL_DEFINITION:
                        this.commonButton.selected = true;
                        break;
                };
            };
        }
        public function get messageLabel():Label{
            if (!this._messageLabel){
                this._messageLabel = new Label();
                this._messageLabel.visible = false;
                this._messageLabel.left = 16;
                this._messageLabel.bottom = 60;
                this._messageLabel.color = 0xAAAAAA;
                this._messageLabel.text = "观看建议：2M带宽请选择高清，1M带宽选择清晰";
            };
            return (this._messageLabel);
        }
        public function get hdButtonBox():HBox{
            if (!this._hdButtonBox){
                this._hdButtonBox = this.getLabelRadioButton("高清", this.hdButton);
                this._hdButtonBox.addEventListener(MouseEvent.CLICK, this.hdButtonOnClick);
            };
            return (this._hdButtonBox);
        }
        private function hdButtonOnClick(_arg1:MouseEvent):void{
            this.hdButton.selected = true;
        }
        public function get distinctButtonBox():HBox{
            if (!this._distinctButtonBox){
                this._distinctButtonBox = this.getLabelRadioButton("清晰", this.distinctButton);
                this._distinctButtonBox.addEventListener(MouseEvent.CLICK, this.distinctButtonOnClick);
            };
            return (this._distinctButtonBox);
        }
        private function distinctButtonOnClick(_arg1:MouseEvent):void{
            this.distinctButton.selected = true;
        }
        public function get commonButtonBox():HBox{
            if (!this._commonButtonBox){
                this._commonButtonBox = this.getLabelRadioButton("普通", this.commonButton);
                this._commonButtonBox.addEventListener(MouseEvent.CLICK, this.commonButtonBoxOnClick);
            };
            return (this._commonButtonBox);
        }
        private function commonButtonBoxOnClick(_arg1:MouseEvent):void{
            this.commonButton.selected = true;
        }
        public function get closedButton():TextButton{
            if (!this._closedButton){
                this._closedButton = new TextButton();
                this._closedButton.hPadding = 10;
                this._closedButton.vPadding = 0;
                this._closedButton.label = "关闭";
                this._closedButton.addEventListener(MouseEvent.CLICK, this.closedButtonOnClick);
            };
            return (this._closedButton);
        }
        private function closedButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new Event("closed"));
        }
        public function get okButton():TextButton{
            if (!this._okButton){
                this._okButton = new TextButton();
                this._okButton.hPadding = 10;
                this._okButton.vPadding = 0;
                this._okButton.label = "确定";
                this._okButton.addEventListener(MouseEvent.CLICK, this.okButtonOnClick);
            };
            return (this._okButton);
        }
        private function okButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ArticulationEvent(ArticulationEvent.OK));
        }
        public function get buttonBox():HBox{
            if (!this._buttonBox){
                this._buttonBox = new HBox();
                this._buttonBox.horizontalCenter = 0;
                this._buttonBox.bottom = 15;
                this._buttonBox.addChild(this.okButton);
                this._buttonBox.addChild(this.closedButton);
            };
            return (this._buttonBox);
        }
        public function get hdButton():RadioButton{
            if (!this._hdButton){
                this._hdButton = this.getRadioButton(this.radioGroup);
            };
            return (this._hdButton);
        }
        public function get distinctButton():RadioButton{
            if (!this._distinctButton){
                this._distinctButton = this.getRadioButton(this.radioGroup);
            };
            return (this._distinctButton);
        }
        public function get commonButton():RadioButton{
            if (!this._commonButton){
                this._commonButton = this.getRadioButton(this.radioGroup);
            };
            return (this._commonButton);
        }
        public function get radioBox():HBox{
            if (!this._radioBox){
                this._radioBox = new HBox();
                this._radioBox.horizontalCenter = 0;
                this._radioBox.horizontalGap = 30;
                this._radioBox.verticalCenter = -35;
            };
            return (this._radioBox);
        }
        protected function getLabel(_arg1:String):Label{
            var _local2:Label = new Label();
            _local2.color = 0xFFFFFF;
            _local2.text = _arg1;
            return (_local2);
        }
        private function getRadioButton(_arg1:RadioGroup):RadioButton{
            var _local2:RadioButton = new RadioButton();
            _local2.radioGroup = _arg1;
            return (_local2);
        }
        private function getLabelRadioButton(_arg1:String, _arg2:RadioButton):HBox{
            var _local3:HBox = new HBox();
            _local3.buttonMode = true;
            _local3.verticalAlign = Align.CENTER;
            _local3.horizontalGap = 3;
            _local3.paddingLeft = 0;
            var _local4:Label = this.getLabel(_arg1);
            _arg2.addEventListener(RadioButton.SELECTED_EVENT, this.onSelected);
            _local3.addChild(_arg2);
            _local3.addChild(_local4);
            return (_local3);
        }
        private function onSelected(_arg1:Event):void{
            if (this.commonButton == _arg1.target){
                this._articulation = NORMAL_DEFINITION;
                dispatchEvent(new ArticulationEvent(ArticulationEvent.NORMAL_DEFINITION));
            };
            if (this.distinctButton == _arg1.target){
                this._articulation = DEFINITION;
                dispatchEvent(new ArticulationEvent(ArticulationEvent.DEFINITION));
            };
            if (this.hdButton == _arg1.target){
                this._articulation = HIGH_DEFINITION;
                dispatchEvent(new ArticulationEvent(ArticulationEvent.HIGH_DEFINITION));
            };
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.radioBox);
            this.addChild(this.messageLabel);
            this.addChild(this.buttonBox);
        }

    }
}//package com.bokecc.player.ui.setuppanel 
