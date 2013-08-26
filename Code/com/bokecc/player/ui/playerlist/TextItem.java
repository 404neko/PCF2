package com.bokecc.player.ui.playerlist {
    import flash.display.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.containers.*;

    public class TextItem extends Canvas {

        private var _textLabel:Label;
        private var _backgroundColor:uint = 0;
        private var _backgroundAlpha:Number = 0.7;
        private var _borderColor:uint = 0;
        private var _borderWidth:Number = 1;
        private var _showBorder:Boolean = false;

        public function get showBorder():Boolean{
            return (this._showBorder);
        }
        public function set showBorder(_arg1:Boolean):void{
            this._showBorder = _arg1;
            this.updateDisplayList();
        }
        public function get borderWidth():Number{
            return (this._borderWidth);
        }
        public function set borderWidth(_arg1:Number):void{
            this._borderWidth = _arg1;
            this.updateDisplayList();
        }
        public function get borderColor():uint{
            return (this._borderColor);
        }
        public function set borderColor(_arg1:uint):void{
            this._borderColor = _arg1;
            this.updateDisplayList();
        }
        public function get backgroundAlpha():Number{
            return (this._backgroundAlpha);
        }
        public function set backgroundAlpha(_arg1:Number):void{
            this._backgroundAlpha = _arg1;
            this.updateDisplayList();
        }
        public function set textAlign(_arg1:String):void{
            switch (_arg1){
                case Align.LEFT:
                    this.textLabel.left = 5;
                    break;
                case Align.CENTER:
                    this.textLabel.horizontalCenter = 0;
                    break;
                case Align.RIGHT:
                    this.textLabel.right = 5;
                    break;
            };
        }
        public function get backgroundColor():uint{
            return (this._backgroundColor);
        }
        public function set backgroundColor(_arg1:uint):void{
            this._backgroundColor = _arg1;
            this.updateDisplayList();
        }
        public function get textColor():uint{
            return (this.textLabel.color);
        }
        public function set textColor(_arg1:uint):void{
            this.textLabel.color = _arg1;
        }
        public function get text():String{
            return (this.textLabel.text);
        }
        public function set text(_arg1:String):void{
            this.textLabel.text = _arg1;
        }
        public function get textLabel():Label{
            if (!this._textLabel){
                this._textLabel = new Label();
                this._textLabel.verticalCenter = 0;
                this._textLabel.right = 10;
                this._textLabel.color = 0xFFFFFF;
            };
            return (this._textLabel);
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.textLabel);
        }
        override public function updateDisplayList():void{
            super.updateDisplayList();
            var _local1:Graphics = this.graphics;
            _local1.clear();
            _local1.beginFill(this._backgroundColor, this._backgroundAlpha);
            if (this._showBorder){
                _local1.lineStyle(this._borderWidth, this._borderColor, 0.8);
            };
            _local1.drawRect(0, 0, this.width, this.height);
            _local1.endFill();
        }

    }
}//package com.bokecc.player.ui.playerlist 
