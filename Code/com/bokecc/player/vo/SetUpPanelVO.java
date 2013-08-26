package com.bokecc.player.vo {
    import flash.events.*;
    import com.bokecc.player.events.*;

    public class SetUpPanelVO extends EventDispatcher {

        private var _videoScale:String;
        private var _articulation:String;
        private var _articulationEnabled:int;
        private var _lightValue:Number;
        private var _contrastValue:Number;

        public function get videoScale():String{
            return (this._videoScale);
        }
        public function set videoScale(_arg1:String):void{
            if (this._videoScale != _arg1){
                this._videoScale = _arg1;
                dispatchEvent(new SetUpPanelDataEvent(SetUpPanelDataEvent.VIDEO_SCALE_CHANGE));
            };
        }
        public function get articulation():String{
            return (this._articulation);
        }
        public function set articulation(_arg1:String):void{
            if (this._articulation != _arg1){
                this._articulation = _arg1;
                dispatchEvent(new SetUpPanelDataEvent(SetUpPanelDataEvent.ARTICULATION_CHANGE));
            };
        }
        public function get articulationEnabled():int{
            return (this._articulationEnabled);
        }
        public function set articulationEnabled(_arg1:int):void{
            if (this._articulationEnabled != _arg1){
                this._articulationEnabled = _arg1;
                dispatchEvent(new SetUpPanelDataEvent(SetUpPanelDataEvent.ARTICULATION_ENABLED_CHANGE));
            };
        }
        public function get lightValue():Number{
            return (this._lightValue);
        }
        public function set lightValue(_arg1:Number):void{
            if (this._lightValue != _arg1){
                this._lightValue = _arg1;
                dispatchEvent(new SetUpPanelDataEvent(SetUpPanelDataEvent.LIGHTVALUE_CHANGE));
            };
        }
        public function get contrastValue():Number{
            return (this._contrastValue);
        }
        public function set contrastValue(_arg1:Number):void{
            if (this._contrastValue != _arg1){
                this._contrastValue = _arg1;
                dispatchEvent(new SetUpPanelDataEvent(SetUpPanelDataEvent.CONTRASTVALUE_CHANGE));
            };
        }

    }
}//package com.bokecc.player.vo 
