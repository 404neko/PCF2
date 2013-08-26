package com.bokecc.lib.utils {

    public class URL extends RequestURL {

        private var _simpleUrl:String;
        private var _protocol:String;
        private var _domain:String;
        private var _fullDomain:String;
        private var _simpleDomain:String;
        private var _directory:String;
        private var _file:String;
        private var _extension:String;
        private var _folder:Array;

        public function URL(_arg1:String){
            super(_arg1);
        }
        override public function set url(_arg1:String):void{
            super.url = _arg1;
            this._protocol = "file:///";
            var _local2 = (_pureUrl.indexOf(this._protocol) == -1);
            var _local3:Number = ((_local2) ? (_pureUrl.indexOf("://") + 3) : 8);
            this._protocol = _pureUrl.slice(0, _local3);
            this._simpleUrl = _pureUrl.slice(_local3);
            this._folder = this._simpleUrl.split("/");
            this._domain = (this._simpleDomain = this._folder[0]);
            var _local4:Array = this._domain.split(".");
            if (_local4[0] == "www"){
                _local4.shift();
                this._simpleDomain = _local4.join(".");
            };
            this._fullDomain = (this._protocol + this._domain);
            this._file = this._folder[(this._folder.length - 1)];
            _local3 = this._file.lastIndexOf(".");
            this._extension = this._file.slice((_local3 + 1));
            _local3 = _pureUrl.lastIndexOf("/");
            this._directory = _pureUrl.slice(0, _local3);
        }
        public function get simpleUrl():String{
            return (this._simpleUrl);
        }
        public function get protocol():String{
            return (this._protocol);
        }
        public function get domain():String{
            return (this._domain);
        }
        public function get fullDomain():String{
            return (this._fullDomain);
        }
        public function get simpleDomain():String{
            return (this._simpleDomain);
        }
        public function get directory():String{
            return (this._directory);
        }
        public function get file():String{
            return (this._file);
        }
        public function get extension():String{
            return (this._extension);
        }
        public function get folder():Array{
            return (this._folder);
        }

    }
}//package com.bokecc.lib.utils 
