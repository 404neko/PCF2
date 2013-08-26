package com.bokecc.player.ui {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class ReportPanel extends Panel {

        private var radioGroup:RadioGroup;
        private var _radioButton1:RadioButton;
        private var _label1:Label;
        private var _radioButton2:RadioButton;
        private var _label2:Label;
        private var _radioButton3:RadioButton;
        private var _label3:Label;
        private var _radioButton4:RadioButton;
        private var _label4:Label;
        private var _radioButton5:RadioButton;
        private var _label5:Label;
        private var _input:TextInput;
        private var _okButton:TextButton;
        private var selectOption:int = -1;

        public function ReportPanel(){
            this.radioGroup = new RadioGroup();
            super();
            this.headHeight = 50;
            this.width = 288;
            this.height = 215;
            this.paddingLeft = 10;
            this.paddingRight = 10;
            this.horizontalAlign = Align.CENTER;
            this.title = "举报视频";
            this.titleAlign = Align.CENTER;
            this.layoutName = VBoxLayout.NAME;
            this.paddingTop = 20;
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get radioButton1():RadioButton{
            if (!this._radioButton1){
                this._radioButton1 = new RadioButton();
                this._radioButton1.addEventListener("selected", this.radioButton1OnSelected);
                this._radioButton1.radioGroup = this.radioGroup;
            };
            return (this._radioButton1);
        }
        private function radioButton1OnSelected(_arg1:Event):void{
            this.selectOption = 0;
        }
        public function get radioButton2():RadioButton{
            if (!this._radioButton2){
                this._radioButton2 = new RadioButton();
                this._radioButton2.addEventListener("selected", this.radioButton2OnSelected);
                this._radioButton2.radioGroup = this.radioGroup;
            };
            return (this._radioButton2);
        }
        private function radioButton2OnSelected(_arg1:Event):void{
            this.selectOption = 1;
        }
        public function get radioButton3():RadioButton{
            if (!this._radioButton3){
                this._radioButton3 = new RadioButton();
                this._radioButton3.addEventListener("selected", this.radioButton3OnSelected);
                this._radioButton3.radioGroup = this.radioGroup;
            };
            return (this._radioButton3);
        }
        private function radioButton3OnSelected(_arg1:Event):void{
            this.selectOption = 2;
        }
        public function get radioButton4():RadioButton{
            if (!this._radioButton4){
                this._radioButton4 = new RadioButton();
                this._radioButton4.addEventListener("selected", this.radioButton4OnSelected);
                this._radioButton4.radioGroup = this.radioGroup;
            };
            return (this._radioButton4);
        }
        private function radioButton4OnSelected(_arg1:Event):void{
            this.selectOption = 3;
        }
        public function get radioButton5():RadioButton{
            if (!this._radioButton5){
                this._radioButton5 = new RadioButton();
                this._radioButton5.addEventListener("selected", this.radioButton5OnSelected);
                this._radioButton5.radioGroup = this.radioGroup;
            };
            return (this._radioButton5);
        }
        private function radioButton5OnSelected(_arg1:Event):void{
            this.selectOption = 4;
        }
        public function get label1():Label{
            if (!this._label1){
                this._label1 = this.getLabel("违法视频");
            };
            return (this._label1);
        }
        public function get label2():Label{
            if (!this._label2){
                this._label2 = this.getLabel("低俗内容");
            };
            return (this._label2);
        }
        public function get label3():Label{
            if (!this._label3){
                this._label3 = this.getLabel("版权内容");
            };
            return (this._label3);
        }
        public function get label4():Label{
            if (!this._label4){
                this._label4 = this.getLabel("无法播放");
            };
            return (this._label4);
        }
        public function get label5():Label{
            if (!this._label5){
                this._label5 = this.getLabel("其它原因");
            };
            return (this._label5);
        }
        private function getLabel(_arg1:String):Label{
            var _local2:Label = new Label();
            _local2.text = _arg1;
            _local2.color = 0xFFFFFF;
            return (_local2);
        }
        public function get input():TextInput{
            if (!this._input){
                this._input = new TextInput();
                this._input.percentWidth = 1;
            };
            return (this._input);
        }
        public function get okButton():TextButton{
            if (!this._okButton){
                this._okButton = new TextButton();
                this._okButton.label = "提交";
                this._okButton.addEventListener(MouseEvent.CLICK, this.onClick);
            };
            return (this._okButton);
        }
        private function onClick(_arg1:MouseEvent):void{
            switch (this.selectOption){
                case 0:
                    dispatchEvent(new ReportPanelEvent(ReportPanelEvent.COMMIT, "违法视频"));
                    break;
                case 1:
                    dispatchEvent(new ReportPanelEvent(ReportPanelEvent.COMMIT, "低俗内容"));
                    break;
                case 2:
                    dispatchEvent(new ReportPanelEvent(ReportPanelEvent.COMMIT, "版权内容"));
                    break;
                case 3:
                    dispatchEvent(new ReportPanelEvent(ReportPanelEvent.COMMIT, "无法播放"));
                    break;
                case 4:
                    dispatchEvent(new ReportPanelEvent(ReportPanelEvent.COMMIT, this.input.text));
                    break;
            };
            dispatchEvent(new Event(CLOSED_EVENT));
        }
        override protected function createChildren():void{
            super.createChildren();
            var _local1:HBox = new HBox();
            _local1.paddingTop = 0;
            _local1.paddingBottom = 0;
            _local1.horizontalGap = 25;
            _local1.percentWidth = 1;
            var _local2:HBox = new HBox();
            _local2.horizontalGap = 0;
            _local2.verticalAlign = Align.CENTER;
            _local2.addChild(this.radioButton1);
            _local2.addChild(this.label1);
            var _local3:HBox = new HBox();
            _local3.horizontalGap = 0;
            _local3.verticalAlign = Align.CENTER;
            _local3.addChild(this.radioButton2);
            _local3.addChild(this.label2);
            _local1.addChild(_local2);
            _local1.addChild(_local3);
            var _local4:HBox = new HBox();
            _local4.paddingTop = 0;
            _local4.paddingBottom = 0;
            _local4.horizontalGap = 25;
            _local4.percentWidth = 1;
            var _local5:HBox = new HBox();
            _local5.horizontalGap = 0;
            _local5.verticalAlign = Align.CENTER;
            _local5.addChild(this.radioButton3);
            _local5.addChild(this.label3);
            var _local6:HBox = new HBox();
            _local6.horizontalGap = 0;
            _local6.verticalAlign = Align.CENTER;
            _local6.addChild(this.radioButton4);
            _local6.addChild(this.label4);
            _local4.addChild(_local5);
            _local4.addChild(_local6);
            var _local7:HBox = new HBox();
            _local7.paddingTop = 0;
            _local7.paddingBottom = 0;
            _local7.horizontalGap = 0;
            _local7.percentWidth = 1;
            _local7.paddingRight = 10;
            _local7.verticalAlign = Align.CENTER;
            var _local8:HBox = new HBox();
            _local8.horizontalGap = 0;
            _local8.verticalAlign = Align.CENTER;
            _local8.addChild(this.radioButton5);
            _local8.addChild(this.label5);
            _local7.addChild(_local8);
            _local7.addChild(this.input);
            this.addChild(_local1);
            this.addChild(_local4);
            this.addChild(_local7);
            this.addChild(this.okButton);
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
        public function rest():void{
            this.radioButton1.selected = false;
            this.radioButton2.selected = false;
            this.radioButton3.selected = false;
            this.radioButton4.selected = false;
            this.radioButton5.selected = false;
            this.input.text = " ";
            this.selectOption = -1;
        }

    }
}//package com.bokecc.player.ui 
