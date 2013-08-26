package com.bokecc.player.ui.setuppanel {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class VideoScaleCanvas extends Canvas {

        public static const ORIGINAL:String = "original";
        public static const FULL:String = "full";
        public static const SCALE_4_3:String = "scale43";
        public static const SCALE_16_9:String = "scale169";

        private var _radioBox:HBox;
        private var radioGroup:RadioGroup;
        private var label1:Label;
        private var _radioButton1:RadioButton;
        private var label2:Label;
        private var _radioButton2:RadioButton;
        private var label3:Label;
        private var _radioButton3:RadioButton;
        private var label4:Label;
        private var _radioButton4:RadioButton;
        private var _okButton:TextButton;
        private var _videoScale:String;

        public function VideoScaleCanvas(){
            this.radioGroup = new RadioGroup();
        }
        public function get radioButton4():RadioButton{
            if (!this._radioButton4){
                this._radioButton4 = this.getRadioButton(this.radioGroup);
            };
            return (this._radioButton4);
        }
        public function get radioButton3():RadioButton{
            if (!this._radioButton3){
                this._radioButton3 = this.getRadioButton(this.radioGroup);
            };
            return (this._radioButton3);
        }
        public function get radioButton2():RadioButton{
            if (!this._radioButton2){
                this._radioButton2 = this.getRadioButton(this.radioGroup);
            };
            return (this._radioButton2);
        }
        public function get radioButton1():RadioButton{
            if (!this._radioButton1){
                this._radioButton1 = this.getRadioButton(this.radioGroup);
            };
            return (this._radioButton1);
        }
        public function get videoScale():String{
            return (this._videoScale);
        }
        public function set videoScale(_arg1:String):void{
            if (this._videoScale != _arg1){
                this._videoScale = _arg1;
                switch (this._videoScale){
                    case ORIGINAL:
                        this.radioButton1.selected = true;
                        break;
                    case FULL:
                        this.radioButton2.selected = true;
                        break;
                    case SCALE_4_3:
                        this.radioButton3.selected = true;
                        break;
                    case SCALE_16_9:
                        this.radioButton4.selected = true;
                        break;
                    default:
                        this.radioButton1.selected = true;
                        this._videoScale = ORIGINAL;
                };
            };
        }
        public function get okButton():TextButton{
            if (!this._okButton){
                this._okButton = new TextButton();
                this._okButton.hPadding = 10;
                this._okButton.vPadding = 0;
                this._okButton.horizontalCenter = 0;
                this._okButton.bottom = 15;
                this._okButton.label = "关闭";
                this._okButton.addEventListener(MouseEvent.CLICK, this.okButtonOnClick);
            };
            return (this._okButton);
        }
        private function okButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new Event("closed"));
        }
        public function get radioBox():HBox{
            var vbox1:* = null;
            var vbox2:* = null;
            var vbox3:* = null;
            var vbox4:* = null;
            if (!this._radioBox){
                this._radioBox = new HBox();
                this._radioBox.left = 23;
                this._radioBox.horizontalGap = 17;
                this._radioBox.verticalCenter = -25;
                vbox1 = new HBox();
                vbox1.buttonMode = true;
                vbox1.horizontalGap = 2;
                vbox1.paddingLeft = 0;
                vbox1.paddingRight = 0;
                vbox1.verticalAlign = Align.CENTER;
                vbox1.addEventListener(MouseEvent.CLICK, function (_arg1:MouseEvent):void{
                    radioButton1.selected = true;
                });
                vbox1.addEventListener("resize", this.boxOnResize);
                this.label1 = this.getLabel("原尺寸");
                this.radioButton1.addEventListener(RadioButton.SELECTED_EVENT, this.onSelected);
                vbox1.addChild(this.radioButton1);
                vbox1.addChild(this.label1);
                vbox2 = new HBox();
                vbox2.buttonMode = true;
                vbox2.horizontalGap = 2;
                vbox2.paddingLeft = 0;
                vbox2.paddingRight = 0;
                vbox2.verticalAlign = Align.CENTER;
                vbox2.addEventListener(MouseEvent.CLICK, function (_arg1:MouseEvent):void{
                    radioButton2.selected = true;
                });
                vbox2.addEventListener("resize", this.boxOnResize);
                this.label2 = this.getLabel("填满");
                this.radioButton2.addEventListener(RadioButton.SELECTED_EVENT, this.onSelected);
                vbox2.addChild(this.radioButton2);
                vbox2.addChild(this.label2);
                vbox3 = new HBox();
                vbox3.buttonMode = true;
                vbox3.horizontalGap = 2;
                vbox3.paddingLeft = 0;
                vbox3.paddingRight = 0;
                vbox3.verticalAlign = Align.CENTER;
                vbox3.addEventListener(MouseEvent.CLICK, function (_arg1:MouseEvent):void{
                    radioButton3.selected = true;
                });
                vbox3.addEventListener("resize", this.boxOnResize);
                this.label3 = this.getLabel("4:3");
                this.radioButton3.addEventListener(RadioButton.SELECTED_EVENT, this.onSelected);
                vbox3.addChild(this.radioButton3);
                vbox3.addChild(this.label3);
                vbox4 = new HBox();
                vbox4.buttonMode = true;
                vbox4.horizontalGap = 2;
                vbox4.paddingLeft = 0;
                vbox4.paddingRight = 0;
                vbox4.verticalAlign = Align.CENTER;
                vbox4.addEventListener(MouseEvent.CLICK, function (_arg1:MouseEvent):void{
                    radioButton4.selected = true;
                });
                vbox4.addEventListener("resize", this.boxOnResize);
                this.label4 = this.getLabel("16:9");
                this.radioButton4.addEventListener(RadioButton.SELECTED_EVENT, this.onSelected);
                vbox4.addChild(this.radioButton4);
                vbox4.addChild(this.label4);
                this._radioBox.addChild(vbox1);
                this._radioBox.addChild(vbox3);
                this._radioBox.addChild(vbox4);
                this._radioBox.addChild(vbox2);
            };
            return (this._radioBox);
        }
        private function boxOnResize(_arg1:Event):void{
            this.radioBox.updateDisplayList();
        }
        private function onSelected(_arg1:Event):void{
            if (this.radioButton1 == _arg1.target){
                dispatchEvent(new VideoScaleEvent(VideoScaleEvent.ORIGINAL));
            };
            if (this.radioButton2 == _arg1.target){
                dispatchEvent(new VideoScaleEvent(VideoScaleEvent.FULL));
            };
            if (this.radioButton3 == _arg1.target){
                dispatchEvent(new VideoScaleEvent(VideoScaleEvent.SCALE_4_3));
            };
            if (this.radioButton4 == _arg1.target){
                dispatchEvent(new VideoScaleEvent(VideoScaleEvent.SCALE_16_9));
            };
        }
        private function getIcon(_arg1:Class):SkinComponent{
            var _local2:SkinComponent = new SkinComponent();
            _local2.currentSkin = new (_arg1)();
            return (_local2);
        }
        protected function getLabel(_arg1:String):Label{
            var _local2:Label = new Label();
            _local2.mouseChildren = false;
            _local2.buttonMode = true;
            _local2.color = 0xFFFFFF;
            _local2.text = _arg1;
            return (_local2);
        }
        private function getRadioButton(_arg1:RadioGroup):RadioButton{
            var _local2:RadioButton = new RadioButton();
            _local2.radioGroup = _arg1;
            return (_local2);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.radioBox);
            this.addChild(this.okButton);
        }

    }
}//package com.bokecc.player.ui.setuppanel 
