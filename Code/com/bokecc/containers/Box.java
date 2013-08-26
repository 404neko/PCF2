package com.bokecc.containers {
    import com.bokecc.core.*;

    public class Box extends Container {

        private var _verticalAlign:String = "top";
        private var _horizontalAlign:String = "left";
        private var _horizontalGap:Number = 5;
        private var _verticalGap:Number = 5;
        private var _paddingLeft:Number = 5;
        private var _paddingRight:Number = 5;
        private var _paddingTop:Number = 5;
        private var _paddingBottom:Number = 5;

        public function get verticalAlign():String{
            return (this._verticalAlign);
        }
        public function set verticalAlign(_arg1:String):void{
            if (this._verticalAlign != _arg1){
                this._verticalAlign = _arg1;
                updateDisplayList();
            };
        }
        public function get horizontalGap():Number{
            return (this._horizontalGap);
        }
        public function set horizontalGap(_arg1:Number):void{
            if (this._horizontalGap != _arg1){
                this._horizontalGap = _arg1;
                updateDisplayList();
            };
        }
        public function get horizontalAlign():String{
            return (this._horizontalAlign);
        }
        public function set horizontalAlign(_arg1:String):void{
            if (this._horizontalAlign != _arg1){
                this._horizontalAlign = _arg1;
                updateDisplayList();
            };
        }
        public function get verticalGap():Number{
            return (this._verticalGap);
        }
        public function set verticalGap(_arg1:Number):void{
            if (this._verticalGap != _arg1){
                this._verticalGap = _arg1;
                updateDisplayList();
            };
        }
        public function get paddingLeft():Number{
            return (this._paddingLeft);
        }
        public function set paddingLeft(_arg1:Number):void{
            if (this._paddingLeft != _arg1){
                this._paddingLeft = _arg1;
                updateDisplayList();
            };
        }
        public function get paddingRight():Number{
            return (this._paddingRight);
        }
        public function set paddingRight(_arg1:Number):void{
            if (this._paddingRight != _arg1){
                this._paddingRight = _arg1;
                updateDisplayList();
            };
        }
        public function get paddingTop():Number{
            return (this._paddingTop);
        }
        public function set paddingTop(_arg1:Number):void{
            if (this._paddingTop != _arg1){
                this._paddingTop = _arg1;
                updateDisplayList();
            };
        }
        public function get paddingBottom():Number{
            return (this._paddingBottom);
        }
        public function set paddingBottom(_arg1:Number):void{
            if (this._paddingBottom != _arg1){
                this._paddingBottom = _arg1;
                updateDisplayList();
            };
        }

    }
}//package com.bokecc.containers 
