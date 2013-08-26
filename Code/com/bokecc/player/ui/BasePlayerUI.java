package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import flash.utils.*;
    import com.bokecc.controls.*;
    import com.bokecc.vo.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;
    import com.greensock.*;

    public class BasePlayerUI extends Canvas {

        public static const FADE:String = "fade";
        public static const MOVE:String = "move";

        protected var _baseControlBar:ControlBar;
        private var _controlBarHidenTimer:Timer;
        private var _autoHidenControlBar:Boolean = true;
        private var _basePlayButton:BaseButton;
        private var _displayArea:DisplayArea;
        private var _hidenControlBarEffect:String = "fade";
        private var _effectTime:Number = 0.3;
        private var _controlBarLayer:Canvas;
        public var controlBar:ControlBar;
        private var mouseOverControlBar:Boolean = false;

        public function BasePlayerUI(){
            this.addEventListener(MouseEvent.MOUSE_MOVE, this.basePlayeruiOnMouseMove);
        }
        public function get showControlBar():Boolean{
            return (this.controlBarLayer.visible);
        }
        public function set showControlBar(_arg1:Boolean):void{
            this.controlBarLayer.visible = _arg1;
        }
        public function get controlBarLayer():Canvas{
            if (!this._controlBarLayer){
                this._controlBarLayer = new Canvas();
                this._controlBarLayer.left = 0;
                this._controlBarLayer.right = 0;
                this._controlBarLayer.top = 0;
                this._controlBarLayer.bottom = 0;
            };
            return (this._controlBarLayer);
        }
        public function get effectTime():Number{
            return (this._effectTime);
        }
        public function set effectTime(_arg1:Number):void{
            this._effectTime = _arg1;
        }
        private function get controlBarHidenTimer():Timer{
            if (!this._controlBarHidenTimer){
                this._controlBarHidenTimer = new Timer(2000, 1);
                this._controlBarHidenTimer.addEventListener(TimerEvent.TIMER, this.controlBarOnTimer);
            };
            return (this._controlBarHidenTimer);
        }
        public function get basePlayButton():BaseButton{
            if (!this._basePlayButton){
                this._basePlayButton = new BaseButton();
                this._basePlayButton.addEventListener(MouseEvent.CLICK, this.basePlayButtonOnClick);
                this._basePlayButton.skinName = "basePlayButtonSkin";
                this._basePlayButton.controlID = ControlList.BASE_PLAYBUTTON;
            };
            return (this._basePlayButton);
        }
        public function get displayArea():DisplayArea{
            if (!this._displayArea){
                this._displayArea = new DisplayArea();
                this._displayArea.addEventListener("resize", this.displayAreaOnResize);
                this._displayArea.left = 0;
                this._displayArea.right = 0;
                this._displayArea.top = 0;
                this._displayArea.bottom = 0;
                this._displayArea.skinName = "displayAreaSkin";
                this._displayArea.controlID = ControlList.DISPLAY_AREA;
            };
            return (this._displayArea);
        }
        protected function displayAreaOnResize(_arg1:Event):void{
        }
        public function get baseControlBar():ControlBar{
            if (!this._baseControlBar){
                this._baseControlBar = new ControlBar();
                this.controlBar = this._baseControlBar;
                this._baseControlBar.addEventListener(MouseEvent.ROLL_OVER, this.controlBarOnRollOver);
                this._baseControlBar.addEventListener(MouseEvent.ROLL_OUT, this.controlBarOnRollOut);
                this._baseControlBar.addEventListener(ControlEvent.REWIND_STEP, this.controlBarOnEven);
                this._baseControlBar.addEventListener(ControlEvent.FORWARD_STEP, this.controlBarOnEven);
                this._baseControlBar.addEventListener(ControlEvent.DRAG, this.controlBarOnEven);
                this._baseControlBar.addEventListener(ControlEvent.PLAY_BUTTON_CLICK, this.controlBarOnEven);
                this._baseControlBar.addEventListener(ControlEvent.FULL_SCREEN, this.controlBarOnEven);
                this._baseControlBar.addEventListener(ControlEvent.NORMAL_SCREEN, this.controlBarOnEven);
                this._baseControlBar.addEventListener(ControlEvent.VOLUME_CHANGE, this.controlBarOnEven);
                this._baseControlBar.skinName = "controlBarSkin";
                this._baseControlBar.controlID = ControlList.CONTROL_BAR;
            };
            return (this._baseControlBar);
        }
        protected function controlBarOnRollOut(_arg1:MouseEvent):void{
            this.mouseOverControlBar = false;
        }
        protected function controlBarOnRollOver(_arg1:MouseEvent):void{
            this.mouseOverControlBar = true;
        }
        protected function controlBarOnTimer(_arg1:TimerEvent):void{
            this.controlBarHidenEffcet();
        }
        protected function controlBarOnEven(_arg1:ControlEvent):void{
            dispatchEvent(_arg1.clone());
        }
        protected function basePlayButtonOnClick(_arg1:MouseEvent):void{
            dispatchEvent(new ControlEvent(ControlEvent.BASE_PLAY_BUTTON_CLICK));
        }
        protected function basePlayeruiOnMouseMove(_arg1:MouseEvent):void{
            stage.removeEventListener(Event.MOUSE_LEAVE, this.baseStageOnMouseLeave);
            stage.addEventListener(Event.MOUSE_LEAVE, this.baseStageOnMouseLeave);
            this.controlBarShowEffcet();
            if (this._autoHidenControlBar){
                if (!this.mouseOverControlBar){
                    this.controlBarHidenTimer.reset();
                    this.controlBarHidenTimer.start();
                } else {
                    this.controlBarHidenTimer.stop();
                };
            };
        }
        protected function baseStageOnMouseLeave(_arg1:Event):void{
            this.controlBarHidenEffcet();
            stage.removeEventListener(Event.MOUSE_LEAVE, this.baseStageOnMouseLeave);
        }
        public function controlBarHidenEffcet():void{
            if (this._autoHidenControlBar){
                if (FADE == this._hidenControlBarEffect){
                    this.fadeOut();
                };
                if (MOVE == this._hidenControlBarEffect){
                    this.moveOut();
                };
            };
        }
        public function controlBarShowEffcet():void{
            if (this._autoHidenControlBar){
                if (FADE == this._hidenControlBarEffect){
                    this.fadeIn();
                };
                if (MOVE == this._hidenControlBarEffect){
                    this.moveIn();
                };
            };
        }
        private function moveIn():void{
            var _local1:Number;
            if (this.controlBar){
                this.controlBar.visible = true;
                this.controlBar.alpha = 1;
                _local1 = Number(this.getControlConfigValue(this.controlBar.controlID, "bottom"));
                TweenNano.to(this.controlBar, this._effectTime, {bottom:_local1});
            };
        }
        private function moveOut():void{
            var _local1:Number;
            if (this.controlBar){
                this.controlBar.visible = true;
                this.controlBar.alpha = 1;
                _local1 = -(this.controlBar.height);
                TweenNano.to(this.controlBar, this._effectTime, {bottom:_local1});
            };
        }
        private function fadeIn():void{
            if (this.controlBar){
                this.controlBar.bottom = Number(this.getControlConfigValue(this.controlBar.controlID, "bottom"));
                this.controlBar.visible = true;
                TweenNano.to(this.controlBar, this._effectTime, {
                    alpha:1,
                    onComplete:function ():void{
                    }
                });
            };
        }
        private function fadeOut():void{
            if (this.controlBar){
                this.controlBar.bottom = Number(this.getControlConfigValue(this.controlBar.controlID, "bottom"));
                TweenNano.to(this.controlBar, this._effectTime, {
                    alpha:0,
                    onComplete:function ():void{
                        controlBar.visible = false;
                    }
                });
            };
        }
        private function getControlConfigValue(_arg1:String, _arg2:String):Object{
            var _local3:ComponentVO = skinManager.controlIdByComponentVO(_arg1);
            if (_local3){
                return (_local3[_arg2]);
            };
            return (null);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.displayArea);
            this.addChild(this.controlBarLayer);
            this.controlBarLayer.addChild(this.baseControlBar);
            this.addChild(this.basePlayButton);
        }
        public function get autoHidenControlBar():Boolean{
            return (this._autoHidenControlBar);
        }
        public function set autoHidenControlBar(_arg1:Boolean):void{
            if (this._autoHidenControlBar != _arg1){
                this._autoHidenControlBar = _arg1;
                if (!this._autoHidenControlBar){
                    if (FADE == this._hidenControlBarEffect){
                        this.fadeIn();
                    };
                    if (MOVE == this._hidenControlBarEffect){
                        this.moveIn();
                    };
                    if (this.controlBar){
                        TweenNano.to(this.displayArea, this._effectTime, {bottom:this.controlBar.height});
                    };
                } else {
                    this.controlBarHidenTimer.start();
                    TweenNano.to(this.displayArea, this._effectTime, {bottom:0});
                };
            };
            if (this._autoHidenControlBar){
                this.controlBarHidenTimer.start();
                TweenNano.to(this.displayArea, this._effectTime, {bottom:0});
            };
        }
        public function get displayer():DisplayObject{
            return (this.displayArea.displayer);
        }
        public function set displayer(_arg1:DisplayObject):void{
            this.displayArea.displayer = _arg1;
        }
        public function get hidenControlBarEffect():String{
            return (this._hidenControlBarEffect);
        }
        public function set hidenControlBarEffect(_arg1:String):void{
            if (this._hidenControlBarEffect != _arg1){
                this._hidenControlBarEffect = _arg1;
                if (FADE == this._hidenControlBarEffect){
                    this.moveIn();
                };
                if (MOVE == this._hidenControlBarEffect){
                    this.fadeIn();
                };
                if (this._autoHidenControlBar){
                    this.controlBarHidenTimer.reset();
                    this.controlBarHidenTimer.start();
                };
            };
        }
        public function play():void{
            this.baseControlBar.play();
        }
        public function pause():void{
            this.baseControlBar.pause();
        }
        public function fullScreen(_arg1:Boolean):void{
            this.baseControlBar.fullScreen(_arg1);
        }
        public function set duration(_arg1:Number):void{
            this.baseControlBar.duration = _arg1;
        }
        public function set position(_arg1:Number):void{
            this.baseControlBar.position = _arg1;
        }
        public function set bufferStart(_arg1:Number):void{
            this.baseControlBar.bufferStart = _arg1;
        }
        public function set bufferEnd(_arg1:Number):void{
            this.baseControlBar.bufferEnd = _arg1;
        }
        public function get volume():Number{
            return (this.baseControlBar.volume);
        }
        public function set volume(_arg1:Number):void{
            this.baseControlBar.volume = _arg1;
        }
        public function set showBasePlayButton(_arg1:Boolean):void{
            this.basePlayButton.visible = _arg1;
        }

    }
}//package com.bokecc.player.ui 
