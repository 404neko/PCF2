package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import flash.utils.*;
    import com.bokecc.controls.*;
    import com.bokecc.vo.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class ControlBar extends Canvas {

        protected var _playButton:BaseButton;
        protected var _basePlayButton:BaseButton;
        protected var _fullScreenButton:BaseButton;
        protected var _progressControlBar:ProgressControlBar;
        protected var _playTimeLabel:Label;
        protected var _totalTimeLabel:Label;
        protected var _playTotalGapLabel:Label;
        protected var _volumeButton:BaseButton;
        protected var _volumeSlider:Slider;
        protected var _volumeSliderCanvas:Canvas;
        protected var _augmentButton:BaseButton;
        protected var _decreaseButton:BaseButton;
        private var _bufferStart:Number = 0;
        private var _bufferEnd:Number = 0;
        private var _position:Number = 0;
        private var _duration:Number = 0;
        private var _volume:Number = 1;
        private var oldVolume:Number = 1;
        private var _autoHidenVolumeSlider:Boolean = false;
        private var _timer:Timer;
        private var decorates:Dictionary;
        private var _stepTimer:Timer;
        private var stepState:String;

        public function ControlBar(){
            this.decorates = new Dictionary();
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get stepTimer():Timer{
            if (!this._stepTimer){
                this._stepTimer = new Timer(100);
                this._stepTimer.addEventListener(TimerEvent.TIMER, this.stepTimerOnTimer);
            };
            return (this._stepTimer);
        }
        private function stepTimerOnTimer(_arg1:TimerEvent):void{
            dispatchEvent(new ControlEvent(this.stepState, this.position, ControlEvent.DRAG_PRESS));
        }
        public function get playTotalGapLabel():Label{
            if (!this._playTotalGapLabel){
                this._playTotalGapLabel = new Label();
                this._playTotalGapLabel.text = "/";
                this._playTotalGapLabel.font = "Arial";
                this._playTotalGapLabel.controlID = ControlList.PLAY_TOTAL_GAP_LABEL;
            };
            return (this._playTotalGapLabel);
        }
        public function get totalTimeLabel():Label{
            if (!this._totalTimeLabel){
                this._totalTimeLabel = new Label();
                this._totalTimeLabel.text = "00:00";
                this._totalTimeLabel.font = "Arial";
                this._totalTimeLabel.controlID = ControlList.TOTALTIME_LABEL;
            };
            return (this._totalTimeLabel);
        }
        public function get playTimeLabel():Label{
            if (!this._playTimeLabel){
                this._playTimeLabel = new Label();
                this._playTimeLabel.text = "00:00";
                this._playTimeLabel.font = "Arial";
                this._playTimeLabel.controlID = ControlList.PLAYTIME_LABEL;
            };
            return (this._playTimeLabel);
        }
        public function get volumeSliderCanvas():Canvas{
            if (!this._volumeSliderCanvas){
                this._volumeSliderCanvas = new Canvas();
                this._volumeSliderCanvas.addEventListener(MouseEvent.ROLL_OVER, this.volumeSliderOnRollOver);
                this._volumeSliderCanvas.addEventListener(MouseEvent.ROLL_OUT, this.volumeSliderOnRollOut);
                this._volumeSliderCanvas.addChild(this.volumeSlider);
                this._volumeSliderCanvas.skinName = "volumeSliderCanvasSkin";
                this._volumeSliderCanvas.controlID = ControlList.VOLUME_SLIDER_CANVAS;
            };
            return (this._volumeSliderCanvas);
        }
        public function get decreaseButton():BaseButton{
            if (!this._decreaseButton){
                this._decreaseButton = new BaseButton();
                this._decreaseButton.skinName = "decreaseButtonSkin";
                this._decreaseButton.controlID = ControlList.DECREASE_BUTTON;
                this._decreaseButton.addEventListener(MouseEvent.MOUSE_DOWN, this.decreaseButtonOnMouseDown);
                this._decreaseButton.addEventListener(MouseEvent.ROLL_OUT, this.decreaseButtonOnRollOut);
                this._decreaseButton.addEventListener(MouseEvent.MOUSE_UP, this.decreaseButtonOnMouseUp);
            };
            return (this._decreaseButton);
        }
        protected function decreaseButtonOnRollOut(_arg1:MouseEvent):void{
            if (this.stepTimer.running){
                this.stepTimer.stop();
                this.stepTimer.reset();
                this.stepState = ControlEvent.REWIND_STEP;
                dispatchEvent(new ControlEvent(this.stepState, this.position, ControlEvent.DRAG_END));
            };
        }
        protected function decreaseButtonOnMouseUp(_arg1:MouseEvent):void{
            _arg1.stopPropagation();
            this.stepTimer.stop();
            this.stepTimer.reset();
            this.stepState = ControlEvent.REWIND_STEP;
            dispatchEvent(new ControlEvent(this.stepState, this.position, ControlEvent.DRAG_END));
        }
        protected function decreaseButtonOnMouseDown(_arg1:MouseEvent):void{
            _arg1.stopPropagation();
            this.stepState = ControlEvent.REWIND_STEP;
            dispatchEvent(new ControlEvent(this.stepState, this.position, ControlEvent.DRAG_PRESS));
            this.stepTimer.reset();
            this.stepTimer.start();
        }
        public function get augmentButton():BaseButton{
            if (!this._augmentButton){
                this._augmentButton = new BaseButton();
                this._augmentButton.skinName = "augmentButtonSkin";
                this._augmentButton.controlID = ControlList.AUGMENT_BUTTON;
                this._augmentButton.addEventListener(MouseEvent.MOUSE_DOWN, this.augmentButtonOnMouseDown);
                this._augmentButton.addEventListener(MouseEvent.ROLL_OUT, this.augmentButtonOnRollOut);
                this._augmentButton.addEventListener(MouseEvent.MOUSE_UP, this.augmentButtonOnMouseUp);
            };
            return (this._augmentButton);
        }
        protected function augmentButtonOnRollOut(_arg1:MouseEvent):void{
            if (this.stepTimer.running){
                this.stepTimer.stop();
                this.stepTimer.reset();
                this.stepState = ControlEvent.FORWARD_STEP;
                dispatchEvent(new ControlEvent(this.stepState, this.position, ControlEvent.DRAG_END));
            };
        }
        protected function augmentButtonOnMouseUp(_arg1:MouseEvent):void{
            _arg1.stopPropagation();
            this.stepTimer.stop();
            this.stepTimer.reset();
            this.stepState = ControlEvent.FORWARD_STEP;
            dispatchEvent(new ControlEvent(this.stepState, this.position, ControlEvent.DRAG_END));
        }
        protected function augmentButtonOnMouseDown(_arg1:MouseEvent):void{
            _arg1.stopPropagation();
            this.stepState = ControlEvent.FORWARD_STEP;
            dispatchEvent(new ControlEvent(this.stepState, this.position, ControlEvent.DRAG_PRESS));
            this.stepTimer.reset();
            this.stepTimer.start();
        }
        public function get bufferStart():Number{
            return (this._bufferStart);
        }
        public function set bufferStart(_arg1:Number):void{
            if (this._bufferStart != _arg1){
                this._bufferStart = _arg1;
                if (0 == this.duration){
                    this.progressControlBar.startPosition = 0;
                } else {
                    this.progressControlBar.startPosition = (this._bufferStart / this.duration);
                };
            };
        }
        public function get autoHidenVolumeSlider():Boolean{
            return (this._autoHidenVolumeSlider);
        }
        public function set autoHidenVolumeSlider(_arg1:Boolean):void{
            if (this._autoHidenVolumeSlider != _arg1){
                this._autoHidenVolumeSlider = _arg1;
                if (this._autoHidenVolumeSlider){
                    this.volumeSliderCanvas.visible = false;
                } else {
                    this.volumeSliderCanvas.visible = true;
                };
            };
        }
        public function get volume():Number{
            return (this._volume);
        }
        public function set volume(_arg1:Number):void{
            if (this._volume != _arg1){
                this._volume = _arg1;
                this.volumeSlider.sliderValue = this._volume;
            };
        }
        public function get volumeSlider():Slider{
            if (!this._volumeSlider){
                this._volumeSlider = new Slider();
                this._volumeSlider.skinName = "volumeSliderSkin";
                this._volumeSlider.controlID = ControlList.VOLUME_SLIDER;
                this._volumeSlider.sliderValue = this._volume;
                this._volumeSlider.addEventListener(SliderEvent.CHANGE, this.volumeSliderOnChange);
            };
            return (this._volumeSlider);
        }
        protected function volumeSliderOnRollOut(_arg1:MouseEvent):void{
            if (this.autoHidenVolumeSlider){
                this.timer.reset();
                this.timer.start();
            };
        }
        protected function volumeSliderOnRollOver(_arg1:MouseEvent):void{
            if (this.autoHidenVolumeSlider){
                this.timer.stop();
            };
        }
        protected function volumeSliderOnChange(_arg1:SliderEvent):void{
            this._volume = _arg1.value;
            if (0.001 < this._volume){
                this.volumeButton.selected = false;
            } else {
                this.volumeButton.selected = true;
            };
            var _local2:ControlEvent = new ControlEvent(ControlEvent.VOLUME_CHANGE, this._volume);
            dispatchEvent(_local2);
        }
        public function get basePlayButton():BaseButton{
            if (!this._basePlayButton){
                this._basePlayButton = new BaseButton();
                this._basePlayButton.left = 10;
                this._basePlayButton.top = -10;
                this._basePlayButton.addEventListener(MouseEvent.CLICK, this.playButtonOnClick);
                this._basePlayButton.skinName = "controlBarBasePlayButtonSkin";
                this._basePlayButton.controlID = ControlList.CONTROL_BAR_BASE_PLAYBUTTON;
            };
            return (this._basePlayButton);
        }
        public function get volumeButton():BaseButton{
            if (!this._volumeButton){
                this._volumeButton = new BaseButton();
                this._volumeButton.addEventListener(MouseEvent.ROLL_OVER, this.volumeButtonOnRollOver);
                this._volumeButton.addEventListener(MouseEvent.ROLL_OUT, this.volumeButtonOnRollOut);
                this._volumeButton.skinName = "volumeButtonSkin";
                this._volumeButton.controlID = ControlList.VOLUME_BUTTON;
                this._volumeButton.addEventListener(MouseEvent.CLICK, this.volumeButtonOnClick);
            };
            return (this._volumeButton);
        }
        protected function volumeButtonOnRollOut(_arg1:MouseEvent):void{
            if (this.autoHidenVolumeSlider){
                this.timer.reset();
                this.timer.start();
            };
        }
        protected function volumeButtonOnRollOver(_arg1:MouseEvent):void{
            if (this.autoHidenVolumeSlider){
                this.timer.stop();
                this.volumeSliderCanvas.visible = true;
            };
        }
        protected function get timer():Timer{
            if (!this._timer){
                this._timer = new Timer(500, 1);
                this._timer.addEventListener(TimerEvent.TIMER, this.onTimer);
            };
            return (this._timer);
        }
        private function onTimer(_arg1:TimerEvent):void{
            this.volumeSliderCanvas.visible = false;
        }
        protected function volumeButtonOnClick(_arg1:MouseEvent):void{
            _arg1.stopPropagation();
            if (this.volumeSlider.sliderValue == 0){
                this.volumeSlider.sliderValue = this.oldVolume;
            } else {
                if (!this.volumeButton.selected){
                    this.oldVolume = this.volumeSlider.sliderValue;
                    this.volumeSlider.sliderValue = 0;
                } else {
                    this.volumeSlider.sliderValue = this.oldVolume;
                };
            };
        }
        public function get duration():Number{
            return (this._duration);
        }
        public function set duration(_arg1:Number):void{
            if (this._duration != _arg1){
                this._duration = _arg1;
                this.setTimeLabel(this.position, this._duration);
            };
        }
        public function get position():Number{
            return (this._position);
        }
        public function set position(_arg1:Number):void{
            if (this.progressControlBar.sliderValue != (_arg1 / this.duration)){
                this._position = _arg1;
                this.setTimeLabel(this._position, this.duration);
            };
        }
        public function get bufferEnd():Number{
            return (this._bufferEnd);
        }
        public function set bufferEnd(_arg1:Number):void{
            if (this._bufferEnd != _arg1){
                this._bufferEnd = _arg1;
                if (0 == this.duration){
                    this.progressControlBar.loaderProgress = 0;
                } else {
                    this.progressControlBar.loaderProgress = (this._bufferEnd / this.duration);
                };
            };
        }
        public function get playButton():BaseButton{
            if (!this._playButton){
                this._playButton = new BaseButton();
                this._playButton.skinName = "playButtonSkin";
                this._playButton.controlID = ControlList.PLAY_BUTTON;
                this._playButton.addEventListener(MouseEvent.CLICK, this.playButtonOnClick);
            };
            return (this._playButton);
        }
        public function get fullScreenButton():BaseButton{
            if (!this._fullScreenButton){
                this._fullScreenButton = new BaseButton();
                this._fullScreenButton.skinName = "fullScreenButtonSkin";
                this._fullScreenButton.controlID = ControlList.FULLSCREEN_BUTTON;
                this._fullScreenButton.addEventListener(MouseEvent.CLICK, this.fullScreenButtonOnClick);
            };
            return (this._fullScreenButton);
        }
        public function get progressControlBar():ProgressControlBar{
            if (!this._progressControlBar){
                this._progressControlBar = new ProgressControlBar();
                this._progressControlBar.skinName = "progressControlBarSkin";
                this._progressControlBar.controlID = ControlList.PROGRESS_CONTROLBAR;
                this._progressControlBar.addEventListener(MouseEvent.ROLL_OVER, this.progressControlOnPointRollOver);
                this._progressControlBar.addEventListener(MouseEvent.ROLL_OUT, this.progressControlOnPointRollOut);
                this._progressControlBar.addEventListener(MouseEvent.MOUSE_MOVE, this.progressControlOnMouseMove);
                this._progressControlBar.addEventListener(SliderEvent.THUMB_DRAG, this.progressControlOnThumbDrag);
                this._progressControlBar.addEventListener(SliderEvent.THUMB_PRESS, this.progressControlOnThumbPress);
                this._progressControlBar.addEventListener(SliderEvent.THUMB_RELEASE, this.progressControlOnThumbRelease);
            };
            return (this._progressControlBar);
        }
        protected function progressControlOnPointRollOut(_arg1:MouseEvent):void{
            dispatchEvent(new ControlEvent(ControlEvent.PROGRESSCONTROLBAR_ROLL_OUT, this.gettime()));
        }
        protected function progressControlOnPointRollOver(_arg1:MouseEvent):void{
            dispatchEvent(new ControlEvent(ControlEvent.PROGRESSCONTROLBAR_ROLL_OVER, this.gettime()));
        }
        protected function progressControlOnMouseMove(_arg1:MouseEvent):void{
            dispatchEvent(new ControlEvent(ControlEvent.PROGRESSCONTROLBAR_MOUSE_MOVE, this.gettime()));
        }
        private function gettime():Number{
            var _local1:Number = ((this.progressControlBar.mouseX / this.progressControlBar.width) * this.duration);
            if (_local1 > this.duration){
                _local1 = this.duration;
            };
            if (_local1 < 0){
                _local1 = 0;
            };
            return (_local1);
        }
        protected function progressControlOnThumbRelease(_arg1:SliderEvent):void{
            var _local2:ControlEvent = new ControlEvent(ControlEvent.DRAG, (this.duration * _arg1.value), ControlEvent.DRAG_END);
            dispatchEvent(_local2);
        }
        protected function progressControlOnThumbPress(_arg1:SliderEvent):void{
            var _local2:ControlEvent = new ControlEvent(ControlEvent.DRAG, (this.duration * _arg1.value), ControlEvent.DRAG_PRESS);
            dispatchEvent(_local2);
        }
        protected function progressControlOnThumbDrag(_arg1:SliderEvent):void{
            var _local2:ControlEvent = new ControlEvent(ControlEvent.DRAG, (this.duration * _arg1.value), ControlEvent.DRAG_START);
            dispatchEvent(_local2);
        }
        protected function fullScreenButtonOnClick(_arg1:MouseEvent):void{
            var _local2:ControlEvent;
            _arg1.stopPropagation();
            if (!this.fullScreenButton.selected){
                _local2 = new ControlEvent(ControlEvent.FULL_SCREEN);
            } else {
                _local2 = new ControlEvent(ControlEvent.NORMAL_SCREEN);
            };
            dispatchEvent(_local2);
        }
        protected function playButtonOnClick(_arg1:MouseEvent):void{
            _arg1.stopPropagation();
            dispatchEvent(new ControlEvent(ControlEvent.PLAY_BUTTON_CLICK));
        }
        override protected function restLayout():void{
            var _local1:ComponentVO;
            var _local2:DisplayObject;
            var _local3:ILayoutClient;
            if (((!((null == controlID))) && (!(("" == controlID))))){
                _local1 = skinManager.controlIdByComponentVO(controlID);
                if (_local1){
                    if ((this is ILayoutClient)){
                        _local3 = ILayoutClient(this);
                        _local3.left = NaN;
                        _local3.right = NaN;
                        _local3.top = NaN;
                        _local3.bottom = NaN;
                        _local3.horizontalCenter = NaN;
                        _local3.verticalCenter = NaN;
                        _local3.percentWidth = NaN;
                        _local3.percentHeight = NaN;
                        this.height = NaN;
                        this.width = NaN;
                    };
                };
                for each (_local2 in this.decorates) {
                    if (_local2.parent){
                        this.removeChild(_local2);
                    };
                };
                this.decorates = new Dictionary();
            };
        }
        override protected function initLayout():void{
            var _local1:ComponentVO;
            var _local2:String;
            var _local3:Object;
            var _local4:FlashAssets;
            var _local5:Sprite;
            var _local6:SkinComponent;
            var _local7:String;
            if (((!((null == controlID))) && (!(("" == controlID))))){
                _local1 = skinManager.controlIdByComponentVO(controlID);
                if (_local1){
                    for (_local2 in _local1.property) {
                        if (this.hasOwnProperty(_local2)){
                            this[_local2] = _local1.property[_local2];
                        };
                    };
                    for each (_local3 in _local1.decorates) {
                        if (_local3.hasOwnProperty(AssetsVO.SRC)){
                            _local4 = FlashAssets(skinManager.assetsByID(_local3[AssetsVO.SRC]));
                            _local5 = _local4.getSkinInstance();
                            _local6 = new SkinComponent();
                            _local6.currentSkin = _local5;
                            for (_local7 in _local3) {
                                if (_local6.hasOwnProperty(_local7)){
                                    _local6[_local7] = _local3[_local7];
                                };
                            };
                            this.addChildAt(_local6, 0);
                            this.decorates[_local3] = _local6;
                        };
                    };
                    if (!isNaN(_local1.height)){
                        this.height = _local1.height;
                    };
                    if (!isNaN(_local1.width)){
                        this.width = _local1.width;
                    };
                    if ((this is ILayoutClient)){
                        if (!isNaN(_local1.left)){
                            this[ComponentVO.LEFT_FIELD] = _local1.left;
                        };
                        if (!isNaN(_local1.right)){
                            this[ComponentVO.RIGHT_FIELD] = _local1.right;
                        };
                        if (!isNaN(_local1.top)){
                            this[ComponentVO.TOP_FIELD] = _local1.top;
                        };
                        if (!isNaN(_local1.bottom)){
                            this[ComponentVO.BOTTOM_FIELD] = _local1.bottom;
                        };
                        if (!isNaN(_local1.horizontalCenter)){
                            this[ComponentVO.HORIZONTAL_CENTER_FIELD] = _local1.horizontalCenter;
                        };
                        if (!isNaN(_local1.verticalCenter)){
                            this[ComponentVO.VERTICAL_CENTER_FIELD] = _local1.verticalCenter;
                        };
                        if (!isNaN(_local1.percentWidth)){
                            this[ComponentVO.PERCENT_WIDTH_FIELD] = _local1.percentWidth;
                        };
                        if (!isNaN(_local1.percentHeight)){
                            this[ComponentVO.PERCENT_HEIGHT_FIELD] = _local1.percentHeight;
                        };
                    };
                    dispatchEvent(new Event(INIT_LAYOUT_COMPLETE));
                };
            };
        }
        override protected function createChildren():void{
            super.createChildren();
            childList.mask = null;
            if (maskSprite.parent){
                rawChildren.removeChild(maskSprite);
            };
            this.addChild(this.playTimeLabel);
            this.addChild(this.playTotalGapLabel);
            this.addChild(this.totalTimeLabel);
            this.addChild(this.fullScreenButton);
            this.addChild(this.progressControlBar);
            this.addChild(this.augmentButton);
            this.addChild(this.decreaseButton);
            this.addChild(this.playButton);
            this.addChild(this.volumeSliderCanvas);
            this.addChild(this.volumeButton);
            this.addChild(this.basePlayButton);
        }
        public function play():void{
            this.playButton.selected = true;
            this.basePlayButton.selected = true;
        }
        public function pause():void{
            this.playButton.selected = false;
            this.basePlayButton.selected = false;
        }
        public function fullScreen(_arg1:Boolean):void{
            this.fullScreenButton.selected = _arg1;
        }
        private function setTimeLabel(_arg1:Number, _arg2:Number):void{
            if (0 == _arg2){
                this.progressControlBar.sliderValue = 0;
                this.playTimeLabel.text = this.timeToString(0);
                this.totalTimeLabel.text = this.timeToString(0);
            } else {
                this.progressControlBar.sliderValue = (_arg1 / _arg2);
                this.playTimeLabel.text = this.timeToString(_arg1);
                this.totalTimeLabel.text = this.timeToString(_arg2);
            };
        }
        private function timeToString(_arg1:Number):String{
            if (_arg1 < 0){
                _arg1 = 0;
            };
            var _local2:Number = Math.floor((_arg1 / 60));
            var _local3:Number = Math.floor((_arg1 % 60));
            var _local4 = "";
            if (_local2 < 10){
                _local4 = (_local4 + ("0" + _local2));
            } else {
                _local4 = (_local4 + _local2);
            };
            _local4 = (_local4 + ":");
            if (_local3 < 10){
                _local4 = (_local4 + ("0" + _local3));
            } else {
                _local4 = (_local4 + _local3);
            };
            return (_local4);
        }

    }
}//package com.bokecc.player.ui 
