package com.bokecc.platform.playkernel.api.model {
    import com.bokecc.lib.data.*;

    public class MenuNodeVO {

        private var _name:String;
        private var _type:int;
        private var _index:int;
        private var _style:int;
        private var _content:String;
        private var _contentStyle:int;
        private var _frame:int;
        private var _linkURL:String;
        private var _imgURL:String;
        private var _describe:String;

        public function MenuNodeVO(_arg1:XML){
            var _local2:Array;
            var _local3:String;
            super();
            this._name = _arg1.@name;
            this._type = toNumber(_arg1.@type);
            this._index = toNumber(_arg1.@index);
            this._style = toNumber(_arg1.@style, 1);
            this._content = _arg1.@content;
            this._contentStyle = (toNumber(_arg1.@contentstyle) / 10);
            this._frame = (toNumber(_arg1.@contentstyle) % 10);
            if (this.content == null){
                return;
            };
            _local2 = this.content.split(",");
            switch (this.contentStyle){
                case 1:
                    _local3 = _local2.shift();
                    if (_local3.indexOf("http://") == -1){
                        this._describe = this.content;
                    } else {
                        this._linkURL = _local3;
                        this._describe = _local2.join(",");
                    };
                    break;
                default:
                    this._imgURL = _local2.shift();
                    this._linkURL = _local2.shift();
                    this._describe = _local2.join(",");
            };
        }
        public function get name():String{
            return (this._name);
        }
        public function get type():int{
            return (this._type);
        }
        public function get index():int{
            return (this._index);
        }
        public function get content():String{
            return (this._content);
        }
        public function get contentStyle():int{
            return (this._contentStyle);
        }
        public function get frame():int{
            return (this._frame);
        }
        public function get style():int{
            return (this._style);
        }
        public function get linkURL():String{
            return (this._linkURL);
        }
        public function get imgURL():String{
            return (this._imgURL);
        }
        public function get describe():String{
            return (this._describe);
        }

    }
}//package com.bokecc.platform.playkernel.api.model 
