package com.bokecc.player.ui {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class MiniControlBar extends ControlBar {

        override public function get augmentButton():BaseButton{
            if (!_augmentButton){
                _augmentButton = new BaseButton();
                _augmentButton.skinName = "mini_augmentButtonSkin";
                _augmentButton.controlID = ControlList.MINI_AUGMENT_BUTTON;
                _augmentButton.addEventListener(MouseEvent.MOUSE_DOWN, augmentButtonOnMouseDown);
                _augmentButton.addEventListener(MouseEvent.ROLL_OUT, augmentButtonOnRollOut);
                _augmentButton.addEventListener(MouseEvent.MOUSE_UP, augmentButtonOnMouseUp);
            };
            return (_augmentButton);
        }
        override public function get decreaseButton():BaseButton{
            if (!_decreaseButton){
                _decreaseButton = new BaseButton();
                _decreaseButton.skinName = "mini_decreaseButtonSkin";
                _decreaseButton.controlID = ControlList.MINI_DECREASE_BUTTON;
                _decreaseButton.addEventListener(MouseEvent.MOUSE_DOWN, decreaseButtonOnMouseDown);
                _decreaseButton.addEventListener(MouseEvent.ROLL_OUT, decreaseButtonOnRollOut);
                _decreaseButton.addEventListener(MouseEvent.MOUSE_UP, decreaseButtonOnMouseUp);
            };
            return (_decreaseButton);
        }
        override public function get fullScreenButton():BaseButton{
            if (!_fullScreenButton){
                _fullScreenButton = new BaseButton();
                _fullScreenButton.skinName = "mini_fullScreenButtonSkin";
                _fullScreenButton.controlID = ControlList.MINI_FULLSCREEN_BUTTON;
                _fullScreenButton.addEventListener(MouseEvent.CLICK, fullScreenButtonOnClick);
            };
            return (_fullScreenButton);
        }
        override public function get playButton():BaseButton{
            if (!_playButton){
                _playButton = new BaseButton();
                _playButton.skinName = "mini_playButtonSkin";
                _playButton.controlID = ControlList.MINI_PLAY_BUTTON;
                _playButton.addEventListener(MouseEvent.CLICK, playButtonOnClick);
            };
            return (_playButton);
        }
        override public function get playTimeLabel():Label{
            if (!_playTimeLabel){
                _playTimeLabel = new Label();
                _playTimeLabel.text = "00:00";
                _playTimeLabel.font = "Arial";
                _playTimeLabel.controlID = ControlList.MINI_PLAYTIME_LABEL;
            };
            return (_playTimeLabel);
        }
        override public function get playTotalGapLabel():Label{
            if (!_playTotalGapLabel){
                _playTotalGapLabel = new Label();
                _playTotalGapLabel.text = "/";
                _playTotalGapLabel.font = "Arial";
                _playTotalGapLabel.controlID = ControlList.MINI_PLAY_TOTAL_GAP_LABEL;
            };
            return (_playTotalGapLabel);
        }
        override public function get progressControlBar():ProgressControlBar{
            if (!_progressControlBar){
                _progressControlBar = new ProgressControlBar();
                _progressControlBar.skinName = "mini_progressControlBarSkin";
                _progressControlBar.controlID = ControlList.MINI_PROGRESS_CONTROLBAR;
                _progressControlBar.addEventListener(MouseEvent.ROLL_OVER, progressControlOnPointRollOver);
                _progressControlBar.addEventListener(MouseEvent.ROLL_OUT, progressControlOnPointRollOut);
                _progressControlBar.addEventListener(MouseEvent.MOUSE_MOVE, progressControlOnMouseMove);
                _progressControlBar.addEventListener(SliderEvent.THUMB_DRAG, progressControlOnThumbDrag);
                _progressControlBar.addEventListener(SliderEvent.THUMB_PRESS, progressControlOnThumbPress);
                _progressControlBar.addEventListener(SliderEvent.THUMB_RELEASE, progressControlOnThumbRelease);
            };
            return (_progressControlBar);
        }
        override public function get totalTimeLabel():Label{
            if (!_totalTimeLabel){
                _totalTimeLabel = new Label();
                _totalTimeLabel.text = "00:00";
                _totalTimeLabel.font = "Arial";
                _totalTimeLabel.controlID = ControlList.MINI_TOTALTIME_LABEL;
            };
            return (_totalTimeLabel);
        }
        override public function get volumeButton():BaseButton{
            if (!_volumeButton){
                _volumeButton = new BaseButton();
                _volumeButton.addEventListener(MouseEvent.ROLL_OVER, volumeButtonOnRollOver);
                _volumeButton.addEventListener(MouseEvent.ROLL_OUT, volumeButtonOnRollOut);
                _volumeButton.skinName = "mini_volumeButtonSkin";
                _volumeButton.controlID = ControlList.MINI_VOLUME_BUTTON;
                _volumeButton.addEventListener(MouseEvent.CLICK, volumeButtonOnClick);
            };
            return (_volumeButton);
        }
        override public function get volumeSlider():Slider{
            if (!_volumeSlider){
                _volumeSlider = new Slider();
                _volumeSlider.skinName = "mini_volumeSliderSkin";
                _volumeSlider.controlID = ControlList.MINI_VOLUME_SLIDER;
                _volumeSlider.addEventListener(SliderEvent.CHANGE, volumeSliderOnChange);
            };
            return (_volumeSlider);
        }
        override public function get volumeSliderCanvas():Canvas{
            if (!_volumeSliderCanvas){
                _volumeSliderCanvas = new Canvas();
                _volumeSliderCanvas.addEventListener(MouseEvent.ROLL_OVER, volumeSliderOnRollOver);
                _volumeSliderCanvas.addEventListener(MouseEvent.ROLL_OUT, volumeSliderOnRollOut);
                _volumeSliderCanvas.addChild(this.volumeSlider);
                _volumeSliderCanvas.skinName = "mini_volumeSliderCanvasSkin";
                _volumeSliderCanvas.controlID = ControlList.MINI_VOLUME_SLIDER_CANVAS;
            };
            return (_volumeSliderCanvas);
        }
        override public function get basePlayButton():BaseButton{
            if (!_basePlayButton){
                _basePlayButton = new BaseButton();
                _basePlayButton.left = 10;
                _basePlayButton.top = -10;
                _basePlayButton.addEventListener(MouseEvent.CLICK, playButtonOnClick);
                _basePlayButton.skinName = "mini_controlBarBasePlayButtonSkin";
                _basePlayButton.controlID = ControlList.MINI_CONTROL_BAR_BASE_PLAYBUTTON;
            };
            return (_basePlayButton);
        }

    }
}//package com.bokecc.player.ui 
