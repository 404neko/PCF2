package com.bokecc.platform.playkernel.module.console {
    import flash.events.*;
    import com.bokecc.platform.playkernel.core.display.*;
    import flash.ui.*;
    import com.bokecc.lib.utils.*;
    import flash.text.*;

    public class ConsoleUI extends Container {

        public static var Input:String = "ConsoleUI.Input";

        private var inputText:TextField;
        private var outputText:TextField;
        private var format:TextFormat;
        private var tempText:String;
        private var tempMX:Number;
        private var tempMY:Number;
        private var tempW:Number;
        private var tempH:Number;

        public function ConsoleUI(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.inputText = new TextField();
            this.outputText = new TextField();
            this.format = new TextFormat(null, 12, 0x999999, null, null, null, null, null, TextFormatAlign.LEFT);
            super();
            if (false){
                5;
                5;
                this.outputText;
            } else {
                this.outputText.x = 5;
            };
            if (false){
                5;
                20;
                this.outputText;
            } else {
                this.outputText.y = 20;
            };
            if (false){
                5;
                true;
                this.outputText;
            } else {
                this.outputText.wordWrap = true;
            };
            if (false){
                5;
                true;
                this.outputText;
            } else {
                this.outputText.multiline = true;
            };
            if (false){
                5;
                this.format;
                this.outputText;
            } else {
                this.outputText.defaultTextFormat = this.format;
            };
            if (false){
                5;
                this.outputText;
                ;
            } else {
                addChild(this.outputText);
            };
            if (false){
                5;
                this;
            } else {
                this.clear();
            };
            if (false){
                5;
                5;
                this.inputText;
            } else {
                this.inputText.x = 5;
            };
            if (false){
                5;
                22;
                this.inputText;
            } else {
                this.inputText.height = 22;
            };
            if (false){
                5;
                true;
                this.inputText;
            } else {
                this.inputText.background = true;
            };
            if (false){
                5;
                0;
                this.inputText;
            } else {
                this.inputText.backgroundColor = 0;
            };
            if (false){
                5;
                TextFieldType.INPUT;
                this.inputText;
            } else {
                this.inputText.type = TextFieldType.INPUT;
            };
            if (false){
                5;
                false;
                this.inputText;
            } else {
                this.inputText.multiline = false;
            };
            if (false){
                5;
                this.format;
                this.inputText;
            } else {
                this.inputText.defaultTextFormat = this.format;
            };
            if (false){
                5;
                this.onKeyUp;
                KeyboardEvent.KEY_UP;
                this.inputText;
            } else {
                this.inputText.addEventListener(KeyboardEvent.KEY_UP, this.onKeyUp);
            };
            if (false){
                5;
                this.inputText;
                ;
            } else {
                addChild(this.inputText);
            };
            if (false){
                5;
                this.onMouseDown;
                MouseEvent.MOUSE_DOWN;
                ;
            } else {
                addEventListener(MouseEvent.MOUSE_DOWN, this.onMouseDown);
            };
            return;
            /*not popped
            this.onMouseDown
            */
            /*not popped
            MouseEvent.MOUSE_DOWN
            */
            /*not popped
            this.inputText
            */
            /*not popped
            this.onKeyUp
            */
            /*not popped
            KeyboardEvent.KEY_UP
            */
            /*not popped
            this.inputText
            */
            /*not popped
            this.format
            */
            /*not popped
            this.inputText
            */
            /*not popped
            false
            */
            /*not popped
            this.inputText
            */
            /*not popped
            TextFieldType.INPUT
            */
            /*not popped
            this.inputText
            */
            /*not popped
            0
            */
            /*not popped
            this.inputText
            */
            /*not popped
            true
            */
            /*not popped
            this.inputText
            */
            /*not popped
            22
            */
            /*not popped
            this.inputText
            */
            /*not popped
            5
            */
            /*not popped
            this.inputText
            */
            /*not popped
            this
            */
            /*not popped
            this.outputText
            */
            /*not popped
            this.format
            */
            /*not popped
            this.outputText
            */
            /*not popped
            true
            */
            /*not popped
            this.outputText
            */
            /*not popped
            true
            */
            /*not popped
            this.outputText
            */
            /*not popped
            20
            */
            /*not popped
            this.outputText
            */
            /*not popped
            5
            */
            /*not popped
            this.outputText
            */
        }
        private function onMouseDown(_arg1:MouseEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.tempMX = mouseX;
            this.tempMY = mouseY;
            this.tempW = width;
            this.tempH = height;
            if (false){
                5;
                this.onMouseMove;
                MouseEvent.MOUSE_MOVE;
                stage;
            } else {
                stage.addEventListener(MouseEvent.MOUSE_MOVE, this.onMouseMove);
            };
            if (false){
                5;
                this.onMouseUp;
                MouseEvent.MOUSE_UP;
                stage;
            } else {
                stage.addEventListener(MouseEvent.MOUSE_UP, this.onMouseUp);
            };
            return;
            /*not popped
            this.onMouseUp
            */
            /*not popped
            MouseEvent.MOUSE_UP
            */
            /*not popped
            stage
            */
            /*not popped
            this.onMouseMove
            */
            /*not popped
            MouseEvent.MOUSE_MOVE
            */
            /*not popped
            stage
            */
        }
        private function onMouseUp(_arg1:MouseEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.onMouseMove;
                MouseEvent.MOUSE_MOVE;
                stage;
            } else {
                stage.removeEventListener(MouseEvent.MOUSE_MOVE, this.onMouseMove);
            };
            if (false){
                5;
                this.onMouseUp;
                MouseEvent.MOUSE_UP;
                stage;
            } else {
                stage.removeEventListener(MouseEvent.MOUSE_UP, this.onMouseUp);
            };
            return;
            /*not popped
            this.onMouseUp
            */
            /*not popped
            MouseEvent.MOUSE_UP
            */
            /*not popped
            stage
            */
            /*not popped
            this.onMouseMove
            */
            /*not popped
            MouseEvent.MOUSE_MOVE
            */
            /*not popped
            stage
            */
        }
        private function onMouseMove(_arg1:MouseEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if ((((this.tempMX <= 5)) || ((this.tempMY <= 20)))){
                if (false){
                    5;
                    (stage.mouseX - this.tempMX);
                    this;
                } else {
                    this.x = (stage.mouseX - this.tempMX);
                };
                if (false){
                    5;
                    (stage.mouseY - this.tempMY);
                    this;
                } else {
                    this.y = (stage.mouseY - this.tempMY);
                };
            } else {
                if (((((this.tempH - this.tempMY) <= 5)) && (((this.tempW - this.tempMX) <= 5)))){
                    if (false){
                        5;
                        mouseY;
                        mouseX;
                        this;
                    } else {
                        this.setSize(mouseX, mouseY);
                    };
                };
            };
        }
        private function onKeyUp(_arg1:KeyboardEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (_arg1.keyCode == Keyboard.ENTER){
                if (this.input != null){
                    if (false){
                        5;
                        new Event(Input);
                        ;
                    } else {
                        dispatchEvent(new Event(Input));
                    };
                };
            };
        }
        public function fullSize():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            x = (y = 0);
            if (stage){
                if (false){
                    5;
                    stage.stageHeight;
                    stage.stageWidth;
                    this;
                } else {
                    this.setSize(stage.stageWidth, stage.stageHeight);
                };
            };
        }
        public function set inputable(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (stage){
                if (_arg1){
                    if (false){
                        5;
                        TextFieldType.INPUT;
                        this.inputText;
                    } else {
                        this.inputText.type = TextFieldType.INPUT;
                    };
                    if (false){
                        5;
                        10000;
                        false;
                        this.onKeyboardOperate;
                        KeyboardEvent.KEY_DOWN;
                        stage;
                    } else {
                        stage.addEventListener(KeyboardEvent.KEY_DOWN, this.onKeyboardOperate, false, 10000);
                    };
                    if (false){
                        5;
                        10000;
                        false;
                        this.onKeyboardOperate;
                        KeyboardEvent.KEY_UP;
                        stage;
                    } else {
                        stage.addEventListener(KeyboardEvent.KEY_UP, this.onKeyboardOperate, false, 10000);
                    };
                } else {
                    if (false){
                        5;
                        TextFieldType.DYNAMIC;
                        this.inputText;
                    } else {
                        this.inputText.type = TextFieldType.DYNAMIC;
                    };
                    if (false){
                        5;
                        this.onKeyboardOperate;
                        KeyboardEvent.KEY_DOWN;
                        stage;
                    } else {
                        stage.removeEventListener(KeyboardEvent.KEY_DOWN, this.onKeyboardOperate);
                    };
                    if (false){
                        5;
                        this.onKeyboardOperate;
                        KeyboardEvent.KEY_UP;
                        stage;
                    } else {
                        stage.removeEventListener(KeyboardEvent.KEY_UP, this.onKeyboardOperate);
                    };
                };
            };
        }
        protected function onKeyboardOperate(_arg1:KeyboardEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
            } else {
                _arg1.stopImmediatePropagation();
            };
            return;
            /*not popped
            _arg1
            */
        }
        public function close():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (parent){
                this.inputable = false;
                if (false){
                    5;
                    this;
                    parent;
                } else {
                    parent.removeChild(this);
                };
            };
        }
        public function clear():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                (this.tempText = "");
                this.outputText;
            } else {
                this.outputText.text = (this.tempText = "");
            };
            return;
            /*not popped
            (this.tempText = "")
            */
            /*not popped
            this.outputText
            */
        }
        public function output(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.tempText = (this.tempText + (_arg1 + SystemUtil.newline));
            if (false){
                5;
                this.tempText;
                this.outputText;
            } else {
                this.outputText.text = this.tempText;
            };
            if (false){
                5;
                this.outputText.maxScrollV;
                this.outputText;
            } else {
                this.outputText.scrollV = this.outputText.maxScrollV;
            };
            return;
            /*not popped
            this.outputText.maxScrollV
            */
            /*not popped
            this.outputText
            */
            /*not popped
            this.tempText
            */
            /*not popped
            this.outputText
            */
        }
        public function get input():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.inputText.text);
        }
        override public function setSize(_arg1:Number, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                graphics;
            } else {
                graphics.clear();
            };
            if (false){
                5;
                0.7;
                0;
                graphics;
            } else {
                graphics.beginFill(0, 0.7);
            };
            if (false){
                5;
                10;
                10;
                _arg2;
                _arg1;
                0;
                0;
                graphics;
            } else {
                graphics.drawRoundRect(0, 0, _arg1, _arg2, 10, 10);
            };
            if (false){
                5;
                0.7;
                0x666666;
                graphics;
            } else {
                graphics.beginFill(0x666666, 0.7);
            };
            if (false){
                5;
                10;
                10;
                (_arg2 - 2);
                (_arg1 - 2);
                1;
                1;
                graphics;
            } else {
                graphics.drawRoundRect(1, 1, (_arg1 - 2), (_arg2 - 2), 10, 10);
            };
            if (false){
                5;
                0.7;
                0;
                graphics;
            } else {
                graphics.beginFill(0, 0.7);
            };
            if (false){
                5;
                (_arg2 - 25);
                (_arg1 - 10);
                20;
                5;
                graphics;
            } else {
                graphics.drawRect(5, 20, (_arg1 - 10), (_arg2 - 25));
            };
            if (false){
                5;
                graphics;
            } else {
                graphics.endFill();
            };
            super.setSize(_arg1, _arg2);
            if (false){
                5;
                (this.outputText.width = (_arg1 - 10));
                this.inputText;
            } else {
                this.inputText.width = (this.outputText.width = (_arg1 - 10));
            };
            var _local3:Number = ((_arg2 - this.inputText.height) - 5);
            if (false){
                5;
                _local3;
                this.inputText;
            } else {
                this.inputText.y = _local3;
            };
            if (false){
                5;
                (_local3 - 20);
                this.outputText;
            } else {
                this.outputText.height = (_local3 - 20);
            };
            return;
            /*not popped
            (_local3 - 20)
            */
            /*not popped
            this.outputText
            */
            /*not popped
            _local3
            */
            /*not popped
            this.inputText
            */
            /*not popped
            (this.outputText.width = (_arg1 - 10))
            */
            /*not popped
            this.inputText
            */
            /*not popped
            graphics
            */
            /*not popped
            (_arg2 - 25)
            */
            /*not popped
            (_arg1 - 10)
            */
            /*not popped
            20
            */
            /*not popped
            5
            */
            /*not popped
            graphics
            */
            /*not popped
            0.7
            */
            /*not popped
            0
            */
            /*not popped
            graphics
            */
            /*not popped
            10
            */
            /*not popped
            10
            */
            /*not popped
            (_arg2 - 2)
            */
            /*not popped
            (_arg1 - 2)
            */
            /*not popped
            1
            */
            /*not popped
            1
            */
            /*not popped
            graphics
            */
            /*not popped
            0.7
            */
            /*not popped
            0x666666
            */
            /*not popped
            graphics
            */
            /*not popped
            10
            */
            /*not popped
            10
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            0
            */
            /*not popped
            0
            */
            /*not popped
            graphics
            */
            /*not popped
            0.7
            */
            /*not popped
            0
            */
            /*not popped
            graphics
            */
            /*not popped
            graphics
            */
        }

        if (37 == 34){
            return;
            /*not popped
            ConsoleUI
            */
        };
        if (false){
            5;
            "ConsoleUI.Input";
            ;
        } else {
            Input = "ConsoleUI.Input";
        };
        return;
        /*not popped
        "ConsoleUI.Input"
        */
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
    //unresolved jump
}//package com.bokecc.platform.playkernel.module.console 
