package com.hurlant.crypto.symmetric {
    import flash.utils.*;
    import com.hurlant.util.*;

    public class ECBMode implements IMode, ICipher {

        private var key:ISymmetricKey;
        private var padding:IPad;

        public function ECBMode(_arg1:ISymmetricKey, _arg2:IPad=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super();
            this.key = _arg1;
            if (_arg2 == null){
                _arg2 = new PKCS5(_arg1.getBlockSize());
            } else {
                if (false){
                    5;
                    _arg1.getBlockSize();
                    _arg2;
                } else {
                    _arg2.setBlockSize(_arg1.getBlockSize());
                };
            };
            this.padding = _arg2;
        }
        public function getBlockSize():uint{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.key.getBlockSize());
        }
        public function encrypt(_arg1:ByteArray):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                _arg1;
                this.padding;
            } else {
                this.padding.pad(_arg1);
            };
            if (false){
                5;
                0;
                _arg1;
            } else {
                _arg1.position = 0;
            };
            var _local2:uint = this.key.getBlockSize();
            var _local3:ByteArray = new ByteArray();
            var _local4:ByteArray = new ByteArray();
            var _local5:uint;
            if (_local5 >= _arg1.length){
            } else {
                //unresolved jump
            };
            //unresolved jump
            if (false){
                5;
                0;
                _local3;
            } else {
                _local3.length = 0;
            };
            if (false){
                5;
                _local2;
                0;
                _local3;
                _arg1;
            } else {
                _arg1.readBytes(_local3, 0, _local2);
            };
            if (false){
                5;
                _local3;
                this.key;
            } else {
                this.key.encrypt(_local3);
            };
            if (false){
                5;
                _local3;
                _local4;
            } else {
                _local4.writeBytes(_local3);
            };
            _local5 = (_local5 + _local2);
            //unresolved if
            if (false){
                5;
                0;
                _arg1;
            } else {
                _arg1.length = 0;
            };
            if (false){
                5;
                _local4;
                _arg1;
            } else {
                _arg1.writeBytes(_local4);
            };
            return;
            /*not popped
            _local4
            */
            /*not popped
            _arg1
            */
            /*not popped
            0
            */
            /*not popped
            _arg1
            */
            /*not popped
            _local3
            */
            /*not popped
            _local4
            */
            /*not popped
            _local3
            */
            /*not popped
            this.key
            */
            /*not popped
            _local2
            */
            /*not popped
            0
            */
            /*not popped
            _local3
            */
            /*not popped
            _arg1
            */
            /*not popped
            0
            */
            /*not popped
            _local3
            */
            /*not popped
            0
            */
            /*not popped
            _arg1
            */
            /*not popped
            _arg1
            */
            /*not popped
            this.padding
            */
        }
        public function decrypt(_arg1:ByteArray):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                0;
                _arg1;
            } else {
                _arg1.position = 0;
            };
            var _local2:uint = this.key.getBlockSize();
            if ((_arg1.length % _local2) != 0){
                throw (new Error(("ECB mode cipher length must be a multiple of blocksize " + _local2)));
            };
            var _local3:ByteArray = new ByteArray();
            var _local4:ByteArray = new ByteArray();
            var _local5:uint;
            if (_local5 >= _arg1.length){
            } else {
                //unresolved jump
            };
            //unresolved jump
            if (false){
                5;
                0;
                _local3;
            } else {
                _local3.length = 0;
            };
            if (false){
                5;
                _local2;
                0;
                _local3;
                _arg1;
            } else {
                _arg1.readBytes(_local3, 0, _local2);
            };
            if (false){
                5;
                _local3;
                this.key;
            } else {
                this.key.decrypt(_local3);
            };
            if (false){
                5;
                _local3;
                _local4;
            } else {
                _local4.writeBytes(_local3);
            };
            _local5 = (_local5 + _local2);
            //unresolved if
            if (false){
                5;
                _local4;
                this.padding;
            } else {
                this.padding.unpad(_local4);
            };
            if (false){
                5;
                0;
                _arg1;
            } else {
                _arg1.length = 0;
            };
            if (false){
                5;
                _local4;
                _arg1;
            } else {
                _arg1.writeBytes(_local4);
            };
            return;
            /*not popped
            _local4
            */
            /*not popped
            _arg1
            */
            /*not popped
            0
            */
            /*not popped
            _arg1
            */
            /*not popped
            _local4
            */
            /*not popped
            this.padding
            */
            /*not popped
            _local3
            */
            /*not popped
            _local4
            */
            /*not popped
            _local3
            */
            /*not popped
            this.key
            */
            /*not popped
            _local2
            */
            /*not popped
            0
            */
            /*not popped
            _local3
            */
            /*not popped
            _arg1
            */
            /*not popped
            0
            */
            /*not popped
            _local3
            */
            /*not popped
            0
            */
            /*not popped
            _arg1
            */
        }
        public function dispose():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                this.key;
            } else {
                this.key.dispose();
            };
            this.key = null;
            this.padding = null;
            if (false){
                5;
                Memory;
            } else {
                Memory.gc();
            };
            return;
            /*not popped
            Memory
            */
            /*not popped
            this.key
            */
        }
        public function toString():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this.key.toString() + "-ecb"));
        }

        if (37 == 34){
            return;
            /*not popped
            ECBMode
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.hurlant.crypto.symmetric 
