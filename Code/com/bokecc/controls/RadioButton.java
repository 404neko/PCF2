package com.bokecc.controls {
    import flash.events.*;

    public class RadioButton extends BaseButton {

        public static const SELECTED_EVENT:String = "selected";

        private var _radioGroup:RadioGroup;

        public function get radioGroup():RadioGroup{
            return (this._radioGroup);
        }
        public function set radioGroup(_arg1:RadioGroup):void{
            if (this._radioGroup != _arg1){
                if (this._radioGroup){
                    this._radioGroup.removeRadioButton(this);
                };
                this._radioGroup = _arg1;
                if (this._radioGroup){
                    this._radioGroup.addRadioButton(this);
                };
            };
        }
        override protected function onMouseDown(_arg1:MouseEvent):void{
            this.selected = true;
            super.onMouseDown(_arg1);
        }
        override public function set selected(_arg1:Boolean):void{
            if (this.selected != _arg1){
                if (_arg1){
                    dispatchEvent(new Event(SELECTED_EVENT));
                };
            };
            super.selected = _arg1;
        }

    }
}//package com.bokecc.controls 
