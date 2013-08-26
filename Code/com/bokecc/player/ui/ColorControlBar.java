package com.bokecc.player.ui {
    import flash.events.*;
    import com.bokecc.core.*;
    import flash.display.*;
    import flash.utils.*;
    import flash.geom.*;
    import com.bokecc.controls.*;
    import com.bokecc.vo.*;
    import com.bokecc.player.events.*;
    import com.bokecc.events.*;
    import com.bokecc.player.vo.*;

    public class ColorControlBar extends ControlBar {

        private var _backgroundColor:uint;
        private var _foregroundColor:uint;

        public function get pointUIs():Dictionary{
            return (PotinProgressControlBar(this.progressControlBar).pointUIs);
        }
        public function get pointDatas():Array{
            return (PotinProgressControlBar(this.progressControlBar).pointDatas);
        }
        public function set pointDatas(_arg1:Array):void{
            PotinProgressControlBar(this.progressControlBar).pointDatas = _arg1;
        }
        protected function basePlayButtonOnClick(_arg1:MouseEvent):void{
            _arg1.stopPropagation();
            dispatchEvent(new ControlEvent(ControlEvent.PLAY_BUTTON_CLICK));
        }
        public function get foregroundColor():uint{
            return (this._foregroundColor);
        }
        public function set foregroundColor(_arg1:uint):void{
            this._foregroundColor = _arg1;
            this.changeComponentColor(this, "foreground", this._foregroundColor);
            this.changeComponentColor(playButton, "foreground", this._foregroundColor);
            this.changeComponentColor(fullScreenButton, "foreground", this._foregroundColor);
            this.changeComponentColor(augmentButton, "foreground", this._foregroundColor);
            this.changeComponentColor(decreaseButton, "foreground", this._foregroundColor);
            this.changeComponentColor(volumeButton, "foreground", this._foregroundColor);
            this.changeComponentColor(volumeSlider, "foreground", this._foregroundColor);
            this.changeComponentColor(this.progressControlBar, "foreground", this._foregroundColor);
            this.changeComponentColor(volumeSliderCanvas, "foreground", this._foregroundColor);
            playTimeLabel.color = this._foregroundColor;
            playTotalGapLabel.color = this._foregroundColor;
            totalTimeLabel.color = this._foregroundColor;
        }
        public function get backgroundColor():uint{
            return (this._backgroundColor);
        }
        public function set backgroundColor(_arg1:uint):void{
            this._backgroundColor = _arg1;
            this.changeComponentColor(this, "background", this._backgroundColor);
            this.changeComponentColor(playButton, "background", this._backgroundColor);
            this.changeComponentColor(fullScreenButton, "background", this._backgroundColor);
            this.changeComponentColor(augmentButton, "background", this._backgroundColor);
            this.changeComponentColor(decreaseButton, "background", this._backgroundColor);
            this.changeComponentColor(volumeButton, "background", this._backgroundColor);
            this.changeComponentColor(volumeSlider, "background", this._backgroundColor);
            this.changeComponentColor(this.progressControlBar, "background", this._backgroundColor);
            this.changeComponentColor(volumeSliderCanvas, "background", this._backgroundColor);
        }
        public function resetColor():void{
            this.changeComponentColor(this, "background", this._backgroundColor, true);
            this.changeComponentColor(playButton, "background", this._backgroundColor, true);
            this.changeComponentColor(fullScreenButton, "background", this._backgroundColor, true);
            this.changeComponentColor(augmentButton, "background", this._backgroundColor, true);
            this.changeComponentColor(decreaseButton, "background", this._backgroundColor, true);
            this.changeComponentColor(volumeButton, "background", this._backgroundColor, true);
            this.changeComponentColor(volumeSlider, "background", this._backgroundColor, true);
            this.changeComponentColor(this.progressControlBar, "background", this._backgroundColor, true);
            this.changeComponentColor(volumeSliderCanvas, "background", this._backgroundColor, true);
            this.changeComponentColor(this, "foreground", this._foregroundColor, true);
            this.changeComponentColor(playButton, "foreground", this._foregroundColor, true);
            this.changeComponentColor(fullScreenButton, "foreground", this._foregroundColor, true);
            this.changeComponentColor(augmentButton, "foreground", this._foregroundColor, true);
            this.changeComponentColor(decreaseButton, "foreground", this._foregroundColor, true);
            this.changeComponentColor(volumeButton, "foreground", this._foregroundColor, true);
            this.changeComponentColor(volumeSlider, "foreground", this._foregroundColor, true);
            this.changeComponentColor(this.progressControlBar, "foreground", this._foregroundColor, true);
            this.changeComponentColor(volumeSliderCanvas, "foreground", this._foregroundColor, true);
            this.restLabel(playTimeLabel);
            this.restLabel(playTotalGapLabel);
            this.restLabel(totalTimeLabel);
        }
        private function restLabel(_arg1:Label):void{
            var _local2:ComponentVO = skinManager.controlIdByComponentVO(_arg1.controlID);
            if (_local2){
                if (_local2.property["color"]){
                    _arg1.color = _local2.property["color"];
                };
            };
        }
        private function changeComponentColor(_arg1:Component, _arg2:String, _arg3:uint, _arg4:Boolean=false):void{
            var _local6:DisplayObject;
            var _local7:DisplayObject;
            var _local8:ColorTransform;
            var _local5:Dictionary = _arg1.skins;
            for each (_local6 in _local5) {
                if (_local6){
                    _local7 = _local6[_arg2];
                    if (_local7){
                        _local8 = new ColorTransform();
                        if (!_arg4){
                            _local8.color = _arg3;
                        };
                        _local7.transform.colorTransform = _local8;
                    };
                };
            };
        }
        override public function get progressControlBar():ProgressControlBar{
            if (!_progressControlBar){
                _progressControlBar = new PotinProgressControlBar();
                _progressControlBar.skinName = "progressControlBarSkin";
                _progressControlBar.controlID = ControlList.PROGRESS_CONTROLBAR;
                _progressControlBar.addEventListener(SliderEvent.THUMB_DRAG, progressControlOnThumbDrag);
                _progressControlBar.addEventListener(SliderEvent.THUMB_PRESS, progressControlOnThumbPress);
                _progressControlBar.addEventListener(SliderEvent.THUMB_RELEASE, progressControlOnThumbRelease);
                _progressControlBar.addEventListener(MouseEvent.ROLL_OVER, progressControlOnPointRollOver);
                _progressControlBar.addEventListener(MouseEvent.ROLL_OUT, progressControlOnPointRollOut);
                _progressControlBar.addEventListener(MouseEvent.MOUSE_MOVE, progressControlOnMouseMove);
                _progressControlBar.addEventListener(VideoPointEvent.POINT_ROLL_OVER, this.potionUIOnPointRollOver);
                _progressControlBar.addEventListener(VideoPointEvent.POINT_ROLL_OUT, this.potionUIOnPointRollOut);
            };
            return (_progressControlBar);
        }
        private function potionUIOnPointRollOut(_arg1:VideoPointEvent):void{
            dispatchEvent(_arg1.clone());
        }
        private function potionUIOnPointRollOver(_arg1:VideoPointEvent):void{
            dispatchEvent(_arg1.clone());
        }
        public function get pointAlign():String{
            return (PotinProgressControlBar(this.progressControlBar).pointAlign);
        }
        public function set pointAlign(_arg1:String):void{
            PotinProgressControlBar(this.progressControlBar).pointAlign = _arg1;
        }

    }
}//package com.bokecc.player.ui 
