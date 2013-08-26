package com.hurlant.crypto.symmetric {
    import flash.utils.*;

    public class PKCS5 implements IPad {

        private var blockSize:uint;

        public function PKCS5(_arg1:uint=0){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super();
            this.blockSize = _arg1;
        }
        public function pad(_arg1:ByteArray):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:uint = (this.blockSize - (_arg1.length % this.blockSize));
            var _local3:uint;
            if (_local3 >= _local2){
            } else {
                //unresolved jump
            };
            //unresolved jump
            if (false){
                5;
                _local2;
                _arg1.length;
                _arg1;
            } else {
                _arg1[_arg1.length] = _local2;
            };
            _local3++;
            //unresolved if
            return;
            /*not popped
            _local2
            */
            /*not popped
            _arg1.length
            */
            /*not popped
            _arg1
            */
        }
        public function unpad(_arg1:ByteArray):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local4:uint;
            var _local2:uint = (_arg1.length % this.blockSize);
            if (_local2 != 0){
                throw (new Error("PKCS#5::unpad: ByteArray.length isn't a multiple of the blockSize"));
            };
            _local2 = _arg1[(_arg1.length - 1)];
            var _local3:uint = _local2;
            if (_local3 <= 0){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local4 = _arg1[(_arg1.length - 1)];
            var _local5 = _arg1;
            var _local6 = (_local5.length - 1);
            if (false){
                5;
                _local6;
                _local5;
            } else {
                _local5.length = _local6;
            };
            if (_local2 != _local4){
                throw (new Error((((("PKCS#5:unpad: Invalid padding value. expected [" + _local2) + "], found [") + _local4) + "]")));
            };
            _local3--;
            //unresolved if
            return;
            /*not popped
            _local6
            */
            /*not popped
            _local5
            */
        }
        public function setBlockSize(_arg1:uint):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this.blockSize = _arg1;
        }

        if (37 == 34){
            return;
            /*not popped
            PKCS5
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
