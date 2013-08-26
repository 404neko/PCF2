package com.bokecc.controls {
    import flash.events.*;
    import flash.utils.*;

    public class RadioGroup extends EventDispatcher {

        private var radioButtons:Dictionary;

        public function RadioGroup(){
            super(null);
            this.radioButtons = new Dictionary();
        }
        public function addRadioButton(_arg1:RadioButton):void{
            if (_arg1){
                this.radioButtons[_arg1] = _arg1;
                _arg1.addEventListener(RadioButton.SELECTED_EVENT, this.onSelected);
            };
        }
        private function onSelected(_arg1:Event):void{
            var _local2:RadioButton;
            for each (_local2 in this.radioButtons) {
                if (_local2 != _arg1.target){
                    _local2.selected = false;
                };
            };
        }
        public function removeRadioButton(_arg1:RadioButton):void{
            if (_arg1){
                _arg1.removeEventListener(RadioButton.SELECTED_EVENT, this.onSelected);
                delete this.radioButtons[_arg1];
            };
        }

    }
}//package com.bokecc.controls 
