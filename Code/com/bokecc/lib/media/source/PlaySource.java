package com.bokecc.lib.media.source {
    import com.bokecc.lib.data.*;

    public class PlaySource extends ValueObject implements IPlaySource {

        protected var _size:uint = 0;
        protected var _duration:Number = 0;
        protected var _url:String = "";
        protected var _index:uint;
        private var _prevDuration:Number = 0;
        private var _prevSize:uint = 0;

        public function PlaySource(_arg1:String, _arg2:uint=0, _arg3:Number=0, _arg4:uint=0){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this._index = _arg4;
            if (!isNull(_arg1)){
                if (false){
                    5;
                    _arg3;
                    _arg2;
                    _arg1;
                    this;
                } else {
                    this.addSource(_arg1, _arg2, _arg3);
                };
            };
        }
        public function get url():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._url);
        }
        public function get size():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._size);
        }
        public function set size(_arg1:uint):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._size = _arg1;
        }
        public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._duration);
        }
        public function set duration(_arg1:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._duration = _arg1;
        }
        public function get length():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((isNull(this._url)) ? 0 : 1));
        }
        public function addSource(_arg1:String, _arg2:uint=0, _arg3:Number=0):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._url = _arg1;
            if (_arg2 > 0){
                this._size = _arg2;
            };
            if (_arg3 > 0){
                this._duration = _arg3;
            };
        }
        public function getSource(_arg1:int=0):IPlaySource{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this);
        }
        public function getSourceByTime(_arg1:Number):IPlaySource{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this);
        }
        public function percent2index(_arg1:Number):int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (0);
        }
        public function setPrev(_arg1:Number, _arg2:uint):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this._prevDuration = _arg1;
            this._prevSize = _arg2;
        }
        public function get prevDuration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._prevDuration);
        }
        public function get prevSize():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._prevSize);
        }
        public function get index():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._index);
        }

        if (37 == 34){
            return;
            /*not popped
            PlaySource
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.source 
