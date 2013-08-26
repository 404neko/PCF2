package com.bokecc.lib.data {

    public function toNumber(_arg1:String, _arg2:Number=NaN, _arg3:Boolean=false):Number{
        if (((_arg3) && (isNull(_arg1)))){
            return (_arg2);
        };
        var _local4:Number = Number(_arg1);
        if (((isNaN(_local4)) || ((_arg1 == "")))){
            return (_arg2);
        };
        return (_local4);
    }
}//package com.bokecc.lib.data 
