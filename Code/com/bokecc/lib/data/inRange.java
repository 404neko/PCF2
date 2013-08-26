package com.bokecc.lib.data {

    public function inRange(_arg1:Number, _arg2:Number=NaN, _arg3:Number=0):Number{
        if (!isNaN(_arg2)){
            _arg1 = Math.min(_arg2, _arg1);
        };
        if (!isNaN(_arg3)){
            _arg1 = Math.max(_arg3, _arg1);
        };
        return (_arg1);
    }
}//package com.bokecc.lib.data 
