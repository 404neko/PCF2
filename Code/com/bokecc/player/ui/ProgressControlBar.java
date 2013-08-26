package com.bokecc.player.ui {
    import flash.events.*;
    import flash.display.*;
    import flash.utils.*;
    import com.bokecc.controls.*;

    public class ProgressControlBar extends Slider {

        public static const LOADER_PROGRESS_SKIN:String = "loaderProgressSkin";

        private var _loaderBar:SkinComponent;
        private var _loaderProgress:Number = 0;
        private var _startPosition:Number = 0;

        public function ProgressControlBar(){
            this.removeEventListener(MouseEvent.ROLL_OVER, this.showTooltipHandler);
            this.removeEventListener(MouseEvent.MOUSE_MOVE, this.tooltipMoveHandler);
            this.removeEventListener(MouseEvent.MOUSE_OUT, hidenTooltipHandler);
            this.addEventListener(MouseEvent.ROLL_OVER, this.showTooltipHandler, true);
            this.addEventListener(MouseEvent.MOUSE_MOVE, this.tooltipMoveHandler, true);
            this.addEventListener(MouseEvent.MOUSE_OUT, hidenTooltipHandler, true);
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        override public function get skins():Dictionary{
            if (!_skins){
                _skins = new Dictionary();
                _skins[TRACK] = null;
                _skins[HIGHLIGHT] = null;
                _skins[THUMB_UP] = null;
                _skins[THUMB_OVER] = null;
                _skins[THUMB_DOWN] = null;
                _skins[THUMB_DISABLED] = null;
                _skins[LOADER_PROGRESS_SKIN] = null;
            };
            return (_skins);
        }
        public function get startPosition():Number{
            return (this._startPosition);
        }
        public function set startPosition(_arg1:Number):void{
            if (this._startPosition != _arg1){
                this._startPosition = _arg1;
                this.updateDisplayList();
            };
        }
        override protected function showTooltipHandler(_arg1:MouseEvent):void{
            var _local2:UIToolTip;
            if (((!((null == tooltip))) && (!(("" == tooltip))))){
                if (((application) && (this.stage))){
                    _local2 = new UIToolTip();
                    application.showTooltip(tooltip, (stage.mouseX - (0.5 * _local2.width)), (stage.mouseY - 30));
                };
            };
        }
        override protected function tooltipMoveHandler(_arg1:MouseEvent):void{
            var _local2:UIToolTip;
            if (((!((null == tooltip))) && (!(("" == tooltip))))){
                if (((application) && (this.stage))){
                    _local2 = new UIToolTip();
                    application.moveTooltip(tooltip, (stage.mouseX - (0.5 * _local2.width)), (stage.mouseY - 30));
                };
            };
        }
        public function get loaderProgress():Number{
            return (this._loaderProgress);
        }
        public function set loaderProgress(_arg1:Number):void{
            if (this._loaderProgress != _arg1){
                this._loaderProgress = _arg1;
                if (this._loaderProgress > 1){
                    this._loaderProgress = 1;
                };
                this.updateDisplayList();
            };
        }
        public function get loaderBar():SkinComponent{
            if (!this._loaderBar){
                this._loaderBar = new SkinComponent();
                this._loaderBar.width = 0;
            };
            return (this._loaderBar);
        }
        override protected function createChildren():void{
            this.addChild(backgroundBar);
            this.addChild(this.loaderBar);
            this.addChild(progressBar);
            this.addChild(controlButton);
        }
        public function set loaderProgressSkin(_arg1:DisplayObject):void{
            if (_arg1){
                this.skins[LOADER_PROGRESS_SKIN] = _arg1;
                this.loaderBar.currentSkin = _arg1;
            };
        }
        override public function updateDisplayList():void{
            if (((isNaN(this._width)) || (isNaN(this._height)))){
                measure();
            };
            backgroundBar.width = this.width;
            backgroundBar.height = this.height;
            this.loaderBar.height = this.height;
            progressBar.width = this.width;
            progressBar.height = this.height;
            controlButton.y = ((this.height - controlButton.height) * 0.5);
            progressBarMask.height = this.height;
            controlButton.updateDisplayList();
            var _local1:Number = (this.width * this.startPosition);
            var _local2:Number = (this.width * this.loaderProgress);
            this.loaderBar.width = (_local2 - _local1);
            this.loaderBar.x = _local1;
            var _local3:Number = (this.width * sliderValue);
            var _local4:Number = (_local3 - _local1);
            if (_local4 >= 0){
                progressBarMask.width = _local4;
                progressBarMask.x = _local1;
            } else {
                progressBarMask.width = -(_local4);
                progressBarMask.x = (_local1 + _local4);
            };
            controlButton.x = (_local3 - (0.5 * controlButton.width));
        }

    }
}//package com.bokecc.player.ui 
