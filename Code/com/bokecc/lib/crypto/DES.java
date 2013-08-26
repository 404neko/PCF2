package com.bokecc.lib.crypto {
    import flash.utils.*;
    import com.hurlant.crypto.symmetric.*;
    import com.hurlant.util.*;

    public class DES {

        private var _key:String = "12345678";

        public function DES(_arg1:String="12345678"){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this.key = _arg1;
        }
        public function get key():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._key);
        }
        public function set key(_arg1:String):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._key = _arg1;
        }
        public function encrypt(_arg1:ByteArray):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:ByteArray = Hex.toArray(Hex.fromString(this.key));
            var _local3:DESKey = new DESKey(_local2);
            var _local4:IPad = new PKCS5();
            var _local5:ECBMode = new ECBMode(_local3, _local4);
            if (false){
                5;
                _local5.getBlockSize();
                _local4;
            } else {
                _local4.setBlockSize(_local5.getBlockSize());
            };
            if (false){
                5;
                _arg1;
                _local5;
            } else {
                _local5.encrypt(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            _local5
            */
            /*not popped
            _local5.getBlockSize()
            */
            /*not popped
            _local4
            */
        }
        public function decrypt(_arg1:ByteArray):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:ByteArray = Hex.toArray(Hex.fromString(this.key));
            var _local3:DESKey = new DESKey(_local2);
            var _local4:IPad = new PKCS5();
            var _local5:ECBMode = new ECBMode(_local3, _local4);
            if (false){
                5;
                _local5.getBlockSize();
                _local4;
            } else {
                _local4.setBlockSize(_local5.getBlockSize());
            };
            if (false){
                5;
                _arg1;
                _local5;
            } else {
                _local5.decrypt(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            _local5
            */
            /*not popped
            _local5.getBlockSize()
            */
            /*not popped
            _local4
            */
        }
        public function encode(_arg1:String=""):String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:ByteArray = Hex.toArray(Hex.fromString(_arg1));
            if (false){
                5;
                _local2;
                this;
            } else {
                this.encrypt(_local2);
            };
            return (Hex.fromArray(_local2).toUpperCase());
            /*not popped
            _local2
            */
            /*not popped
            this
            */
        }
        public function decode(_arg1:String=""):String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:ByteArray = Hex.toArray(_arg1);
            if (false){
                5;
                _local2;
                this;
            } else {
                this.decrypt(_local2);
            };
            if (false){
                5;
                "UTF-8";
                _local2.bytesAvailable;
                _local2;
            } else {
                _local2.readMultiByte(_local2.bytesAvailable, "UTF-8");
            };
            return (Hex.toString(Hex.fromArray(_local2)));
            /*not popped
            "UTF-8"
            */
            /*not popped
            _local2.bytesAvailable
            */
            /*not popped
            _local2
            */
            /*not popped
            _local2
            */
            /*not popped
            this
            */
        }

        if (37 == 34){
            return;
            /*not popped
            DES
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.crypto 
