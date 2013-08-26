package com.bokecc.player.ui {
    import flash.events.*;
    import flash.utils.*;
    import flash.geom.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import com.greensock.*;

    public class MultipleControlBarPlayerUI extends BasePlayerUI {

        private var _miniControlBar:MiniControlBar;
        private var _showMiniWidth:Number = 300;
        private var _showMiniHeight:Number = 150;
        private var _markTooltip:MarkTooltip;

        public function get pointUIs():Dictionary{
            return (ColorControlBar(this.baseControlBar).pointUIs);
        }
        public function get pointDatas():Array{
            return (ColorControlBar(this.baseControlBar).pointDatas);
        }
        public function set pointDatas(_arg1:Array):void{
            ColorControlBar(this.baseControlBar).pointDatas = _arg1;
        }
        public function get markTooltip():MarkTooltip{
            if (!this._markTooltip){
                this._markTooltip = new MarkTooltip();
                this._markTooltip.textColor = 0xFFFFFF;
                this._markTooltip.consortAlign = MarkTooltip.CUSTOM;
            };
            return (this._markTooltip);
        }
        public function get showControlBarBasePlayerButton():Boolean{
            if (controlBar){
                return (controlBar.basePlayButton.visible);
            };
            return (false);
        }
        public function set showControlBarBasePlayerButton(_arg1:Boolean):void{
            this.baseControlBar.basePlayButton.visible = _arg1;
            this.miniControlBar.basePlayButton.visible = _arg1;
        }
        public function get showMiniHeight():Number{
            return (this._showMiniHeight);
        }
        public function set showMiniHeight(_arg1:Number):void{
            if (this._showMiniHeight != _arg1){
                this._showMiniHeight = _arg1;
                this.updateDisplayList();
            };
        }
        public function get showMiniWidth():Number{
            return (this._showMiniWidth);
        }
        public function set showMiniWidth(_arg1:Number):void{
            if (this._showMiniWidth != _arg1){
                this._showMiniWidth = _arg1;
                this.updateDisplayList();
            };
        }
        public function get miniControlBar():MiniControlBar{
            if (!this._miniControlBar){
                this._miniControlBar = new MiniControlBar();
                this._miniControlBar.addEventListener(MouseEvent.ROLL_OVER, controlBarOnRollOver);
                this._miniControlBar.addEventListener(MouseEvent.ROLL_OUT, controlBarOnRollOut);
                this._miniControlBar.addEventListener(ControlEvent.REWIND_STEP, controlBarOnEven);
                this._miniControlBar.addEventListener(ControlEvent.FORWARD_STEP, controlBarOnEven);
                this._miniControlBar.addEventListener(ControlEvent.DRAG, controlBarOnEven);
                this._miniControlBar.addEventListener(ControlEvent.PLAY_BUTTON_CLICK, controlBarOnEven);
                this._miniControlBar.addEventListener(ControlEvent.FULL_SCREEN, controlBarOnEven);
                this._miniControlBar.addEventListener(ControlEvent.NORMAL_SCREEN, controlBarOnEven);
                this._miniControlBar.addEventListener(ControlEvent.VOLUME_CHANGE, controlBarOnEven);
                this._miniControlBar.addEventListener(ControlEvent.PROGRESSCONTROLBAR_MOUSE_MOVE, this.baseControlBarOnProgresscontrolbarMouseMove);
                this._miniControlBar.addEventListener(ControlEvent.PROGRESSCONTROLBAR_ROLL_OVER, this.baseControlBarOnProgresscontrolbarRollOver);
                this._miniControlBar.addEventListener(ControlEvent.PROGRESSCONTROLBAR_ROLL_OUT, this.baseControlBarOnProgresscontrolbarRollOut);
                this._miniControlBar.skinName = "mini_controlBarSkin";
                this._miniControlBar.controlID = ControlList.MINI_CONTROL_BAR;
            };
            return (this._miniControlBar);
        }
        public function get pointAlign():String{
            return (ColorControlBar(this.baseControlBar).pointAlign);
        }
        public function set pointAlign(_arg1:String):void{
            ColorControlBar(this.baseControlBar).pointAlign = _arg1;
        }
        override public function get baseControlBar():ControlBar{
            if (!_baseControlBar){
                _baseControlBar = new ColorControlBar();
                controlBar = _baseControlBar;
                _baseControlBar.addEventListener(MouseEvent.ROLL_OVER, controlBarOnRollOver);
                _baseControlBar.addEventListener(MouseEvent.ROLL_OUT, controlBarOnRollOut);
                _baseControlBar.addEventListener(ControlEvent.REWIND_STEP, controlBarOnEven);
                _baseControlBar.addEventListener(ControlEvent.FORWARD_STEP, controlBarOnEven);
                _baseControlBar.addEventListener(ControlEvent.DRAG, controlBarOnEven);
                _baseControlBar.addEventListener(ControlEvent.PLAY_BUTTON_CLICK, controlBarOnEven);
                _baseControlBar.addEventListener(ControlEvent.FULL_SCREEN, controlBarOnEven);
                _baseControlBar.addEventListener(ControlEvent.NORMAL_SCREEN, controlBarOnEven);
                _baseControlBar.addEventListener(ControlEvent.VOLUME_CHANGE, controlBarOnEven);
                _baseControlBar.addEventListener(VideoPointEvent.POINT_ROLL_OVER, this.baseControlBarOnPointRollOver);
                _baseControlBar.addEventListener(VideoPointEvent.POINT_ROLL_OUT, this.baseControlBarOnPointRollOut);
                _baseControlBar.addEventListener(ControlEvent.PROGRESSCONTROLBAR_MOUSE_MOVE, this.baseControlBarOnProgresscontrolbarMouseMove);
                _baseControlBar.addEventListener(ControlEvent.PROGRESSCONTROLBAR_ROLL_OVER, this.baseControlBarOnProgresscontrolbarRollOver);
                _baseControlBar.addEventListener(ControlEvent.PROGRESSCONTROLBAR_ROLL_OUT, this.baseControlBarOnProgresscontrolbarRollOut);
                _baseControlBar.skinName = "controlBarSkin";
                _baseControlBar.controlID = ControlList.CONTROL_BAR;
            };
            return (_baseControlBar);
        }
        protected function baseControlBarOnProgresscontrolbarRollOut(_arg1:ControlEvent):void{
            if (this.markTooltip.parent){
                controlBarLayer.removeChild(this.markTooltip);
            };
        }
        protected function baseControlBarOnProgresscontrolbarRollOver(_arg1:ControlEvent):void{
            if (!this.markTooltip.parent){
                controlBarLayer.addChild(this.markTooltip);
            };
            this.markTooltip.text = this.timeToString(_arg1.value);
            this.setTimeTooltipPosition();
        }
        public function showMarkTooltip(_arg1:VideoPointVO):void{
            var _local2:PointUI;
            var _local3:Point;
            var _local4:Point;
            var _local5:Number;
            var _local6:Number;
            if (this.pointUIs){
                _local2 = this.pointUIs[_arg1];
                if (_local2){
                    if (!this.markTooltip.parent){
                        controlBarLayer.addChild(this.markTooltip);
                    };
                    this.markTooltip.text = _arg1.remark;
                    _local3 = new Point(0, 0);
                    _local3 = controlBarLayer.localToGlobal(_local3);
                    _local4 = new Point(_local2.x, _local2.y);
                    _local4 = ColorControlBar(this.baseControlBar).progressControlBar.localToGlobal(_local4);
                    _local5 = (_local4.x - _local3.x);
                    _local6 = (_local5 - (0.5 * this.markTooltip.width));
                    if (_local6 < 0){
                        _local6 = 0;
                    };
                    if (_local6 > (controlBarLayer.width - this.markTooltip.width)){
                        _local6 = (controlBarLayer.width - this.markTooltip.width);
                    };
                    this.markTooltip.x = _local6;
                    this.markTooltip.consortPosition = (_local5 - _local6);
                    if (controlBar){
                        this.markTooltip.y = controlBar.y;
                    };
                };
            };
        }
        public function hidenMarkTooltip():void{
            if (this.markTooltip.parent){
                controlBarLayer.removeChild(this.markTooltip);
            };
        }
        protected function baseControlBarOnProgresscontrolbarMouseMove(_arg1:ControlEvent):void{
            if (!this.markTooltip.parent){
                controlBarLayer.addChild(this.markTooltip);
            };
            this.markTooltip.text = this.timeToString(_arg1.value);
            this.setTimeTooltipPosition();
        }
        private function setTimeTooltipPosition():void{
            var _local1:Number = (controlBarLayer.mouseX - (0.5 * this.markTooltip.width));
            if (_local1 < 0){
                _local1 = 0;
            };
            if (_local1 > (controlBarLayer.width - this.markTooltip.width)){
                _local1 = (controlBarLayer.width - this.markTooltip.width);
            };
            this.markTooltip.x = _local1;
            this.markTooltip.consortPosition = (controlBarLayer.mouseX - _local1);
            if (controlBar){
                this.markTooltip.y = controlBar.y;
            };
        }
        protected function baseControlBarOnPointRollOut(_arg1:VideoPointEvent):void{
            if (this.markTooltip.parent){
                controlBarLayer.removeChild(this.markTooltip);
            };
        }
        protected function baseControlBarOnPointRollOver(_arg1:VideoPointEvent):void{
            if (!this.markTooltip.parent){
                controlBarLayer.addChild(this.markTooltip);
            };
            var _local2:PointUI = _arg1.pointUI;
            this.markTooltip.text = _local2.data.remark;
            var _local3:Number = (controlBarLayer.mouseX - (0.5 * this.markTooltip.width));
            if (_local3 < 0){
                _local3 = 0;
            };
            if (_local3 > (controlBarLayer.width - this.markTooltip.width)){
                _local3 = (controlBarLayer.width - this.markTooltip.width);
            };
            this.markTooltip.x = _local3;
            this.markTooltip.consortPosition = ((controlBarLayer.mouseX - _local3) - _local2.mouseX);
            if (controlBar){
                this.markTooltip.y = controlBar.y;
            };
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            this.playerUIResize(this.width, this.height);
        }
        private function playerUIResize(_arg1:Number, _arg2:Number):void{
            if ((((_arg1 < this._showMiniWidth)) || ((_arg2 < this._showMiniHeight)))){
                if (!this.miniControlBar.parent){
                    if (this.baseControlBar.parent){
                        this.controlBarLayer.addChild(this.miniControlBar);
                        this.controlBarLayer.removeChild(this.baseControlBar);
                        controlBar = this.miniControlBar;
                    };
                };
            } else {
                if (!this.baseControlBar.parent){
                    if (this.miniControlBar.parent){
                        this.controlBarLayer.addChild(this.baseControlBar);
                        this.controlBarLayer.removeChild(this.miniControlBar);
                        controlBar = this.baseControlBar;
                    };
                };
            };
            if (autoHidenControlBar){
                displayArea.bottom = 0;
            } else {
                if (controlBar){
                    controlBar.visible = true;
                    controlBar.alpha = 1;
                    TweenNano.to(displayArea, 0.1, {bottom:controlBar.height});
                };
            };
        }
        public function get foregroundColor():uint{
            return (ColorControlBar(this.baseControlBar).foregroundColor);
        }
        public function set foregroundColor(_arg1:uint):void{
            ColorControlBar(this.baseControlBar).foregroundColor = _arg1;
        }
        public function get backgroundColor():uint{
            return (ColorControlBar(this.baseControlBar).backgroundColor);
        }
        public function set backgroundColor(_arg1:uint):void{
            ColorControlBar(this.baseControlBar).backgroundColor = _arg1;
        }
        public function resetColor():void{
            ColorControlBar(this.baseControlBar).resetColor();
        }
        override public function play():void{
            super.play();
            this.miniControlBar.play();
        }
        override public function pause():void{
            super.pause();
            this.miniControlBar.pause();
        }
        override public function fullScreen(_arg1:Boolean):void{
            super.fullScreen(_arg1);
            this.miniControlBar.fullScreen(_arg1);
        }
        override public function set duration(_arg1:Number):void{
            super.duration = _arg1;
            this.miniControlBar.duration = _arg1;
        }
        override public function set position(_arg1:Number):void{
            super.position = _arg1;
            this.miniControlBar.position = _arg1;
        }
        override public function set bufferStart(_arg1:Number):void{
            super.bufferStart = _arg1;
            this.miniControlBar.bufferStart = _arg1;
        }
        override public function set bufferEnd(_arg1:Number):void{
            super.bufferEnd = _arg1;
            this.miniControlBar.bufferEnd = _arg1;
        }
        override public function set volume(_arg1:Number):void{
            super.volume = _arg1;
            this.miniControlBar.volume = _arg1;
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
