package com.bokecc.lib.utils {
    import flash.events.*;
    import flash.display.*;

    public class StageUtil extends EventDispatcher {

        private static var _instance:StageUtil;

        private var _stage:Stage;
        private var _stagew:Number;
        private var _stageh:Number;

        public static function get instance():StageUtil{
            if (_instance == null){
                _instance = new (StageUtil)();
            };
            return (_instance);
        }

        public function init(_arg1:Stage):void{
            this._stage = _arg1;
            this._stage.align = StageAlign.TOP_LEFT;
            this._stage.scaleMode = StageScaleMode.NO_SCALE;
            this._stage.addEventListener(Event.FULLSCREEN, dispatchEvent);
            this._stage.addEventListener(Event.RESIZE, this.checkStageSize);
            this.checkStageSize(new Event(Event.RESIZE));
        }
        private function checkStageSize(_arg1:Event):void{
            var _local2 = !((this._stagew == this._stage.stageWidth));
            var _local3 = !((this._stageh == this._stage.stageHeight));
            if (((_local2) || (_local3))){
                this._stagew = this._stage.stageWidth;
                this._stageh = this._stage.stageHeight;
                dispatchEvent(_arg1);
            };
        }
        public function get stage():Stage{
            return (this._stage);
        }
        public function get width():Number{
            return (this._stagew);
        }
        public function get height():Number{
            return (this._stageh);
        }
        public function get isFullScreen():Boolean{
            return ((((this._stage.displayState == StageDisplayState.FULL_SCREEN)) || ((this._stage.displayState == StageDisplayState.FULL_SCREEN_INTERACTIVE))));
        }
        public function fullScreen(_arg1:Object=null, _arg2:Boolean=false):Boolean{
            if (_arg1 == null){
                return (this.fullScreen(!(this.isFullScreen), _arg2));
            };
            if (_arg1){
                this._stage.displayState = ((_arg2) ? StageDisplayState.FULL_SCREEN_INTERACTIVE : StageDisplayState.FULL_SCREEN);
                return (this.isFullScreen);
            };
            this._stage.displayState = StageDisplayState.NORMAL;
            return (false);
        }

    }
}//package com.bokecc.lib.utils 
