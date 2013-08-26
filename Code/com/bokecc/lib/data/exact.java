package com.bokecc.lib.data {

    public function exact(_arg1:Number, _arg2:int):Number{
        _arg2 = Math.pow(10, _arg2);
        return ((Math.round((_arg1 * _arg2)) / _arg2));
    }
}//package com.bokecc.lib.data 
