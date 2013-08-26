package com.bokecc.controls {
    import flash.events.*;
    import flash.display.*;
    import com.bokecc.containers.*;

    public class VScrollBar extends Canvas {

        private var _thumbButton:BaseButton;
        private var _viewPort:DisplayObject;
        private var _content:DisplayObject;
        private var offset:Number;
        private var viewportOldHeight:Number;

        public function VScrollBar(){
            this.addEventListener(MouseEvent.MOUSE_DOWN, this.onMouseDown);
        }
        private function onMouseDown(_arg1:MouseEvent):void{
            var _local2:Number = ((this.mouseY - this.thumbButton.y) - (0.5 * this.thumbButton.height));
            var _local3:Number = (this.height - this.thumbButton.height);
            var _local4:Number = (this.thumbButton.y + _local2);
            if (_local4 < 0){
                _local4 = 0;
            };
            if (_local4 > _local3){
                _local4 = _local3;
            };
            this.thumbMove(_local4);
        }
        private function thumbButtonOnMouseDown(_arg1:MouseEvent):void{
            _arg1.stopImmediatePropagation();
            if (this.stage){
                this.offset = this.thumbButton.mouseY;
                this.stage.addEventListener(MouseEvent.MOUSE_MOVE, this.onStageMouseMove);
                this.stage.addEventListener(MouseEvent.MOUSE_UP, this.onMouseUp);
            };
        }
        private function onMouseUp(_arg1:MouseEvent):void{
            this.stage.removeEventListener(MouseEvent.MOUSE_MOVE, this.onStageMouseMove);
            this.stage.removeEventListener(MouseEvent.MOUSE_UP, this.onMouseUp);
        }
        private function onStageMouseMove(_arg1:MouseEvent):void{
            var _local2:Number;
            var _local3:Number;
            if (this.stage){
                _local2 = (this.height - this.thumbButton.height);
                _local3 = (this.mouseY - this.offset);
                if (_local3 < 0){
                    _local3 = 0;
                };
                if (_local3 > _local2){
                    _local3 = _local2;
                };
                this.thumbMove(_local3);
            };
        }
        public function get content():DisplayObject{
            return (this._content);
        }
        public function set content(_arg1:DisplayObject):void{
            if (this._content != _arg1){
                if (this._content){
                    this._content.removeEventListener(Event.RESIZE, this.contentOnResize);
                };
                this._content = _arg1;
                this._content.addEventListener(Event.RESIZE, this.contentOnResize);
                this.initThumb();
            };
        }
        private function contentOnResize(_arg1:Event):void{
            var _local2:Number;
            var _local3:Number;
            if (this.content){
                if (this.content.y < 0){
                    _local2 = (this.viewportOldHeight - this.viewPort.height);
                    if (_local2 < 0){
                        _local3 = (this.content.y + Math.abs(_local2));
                        if (_local3 > 0){
                            _local3 = 0;
                        };
                        this.content.y = _local3;
                    };
                };
            };
            this.initThumb();
            if (this.viewPort){
                this.viewportOldHeight = this.viewPort.height;
            };
        }
        public function get viewPort():DisplayObject{
            return (this._viewPort);
        }
        public function set viewPort(_arg1:DisplayObject):void{
            if (this._viewPort != _arg1){
                if (this._viewPort){
                    this._viewPort.removeEventListener(Event.RESIZE, this.contentOnResize);
                };
                this._viewPort = _arg1;
                this._viewPort.addEventListener(Event.RESIZE, this.contentOnResize);
                this.initThumb();
            };
        }
        public function get thumbButton():BaseButton{
            if (!this._thumbButton){
                this._thumbButton = new BaseButton();
                this._thumbButton.addEventListener("skinChange", this.thumbButtonOnSkinChange);
                this._thumbButton.addEventListener(MouseEvent.MOUSE_DOWN, this.thumbButtonOnMouseDown);
                this._thumbButton.skinName = "vScrollBarThumbButton";
            };
            return (this._thumbButton);
        }
        private function thumbButtonOnSkinChange(_arg1:Event):void{
            this.updateDisplayList();
        }
        override protected function createChildren():void{
            super.createChildren();
            addChild(this.thumbButton);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            this.thumbButton.x = (0.5 * (this.width - this.thumbButton.width));
        }
        private function initThumb():void{
            if (((this._content) && (this._viewPort))){
                if (this._content.height > this._viewPort.height){
                    this.thumbButton.y = ((-(this.viewPort.height) * this.content.y) / this.content.height);
                    this.thumbButton.height = ((this.height * this.viewPort.height) / this.content.height);
                } else {
                    this.thumbButton.height = 0;
                };
                this.thumbButton.width = this.width;
            };
        }
        public function thumbMove(_arg1:Number):void{
            var _local2:Number;
            if (((this.content) && (this.viewPort))){
                if (this.content.height > this.viewPort.height){
                    if ((_arg1 + this.thumbButton.height) > this.height){
                        _arg1 = (this.height - this.thumbButton.height);
                    };
                    if (_arg1 < 0){
                        _arg1 = 0;
                    };
                    this.thumbButton.y = _arg1;
                    _local2 = ((_arg1 * this.content.height) / this.height);
                    if ((-(_local2) + this.content.height) < this.viewPort.height){
                        this.content.y = (this.viewPort.height - this.content.height);
                    } else {
                        this.content.y = -(_local2);
                    };
                };
            };
        }

    }
}//package com.bokecc.controls 
