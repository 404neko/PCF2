package com.bokecc.lib.data {

    public function toBoolean(_arg1:String, _arg2:Boolean=false):Boolean{
        if (isNull(_arg1)){
            return (_arg2);
        };
        _arg1 = _arg1.toLowerCase();
        var _local3:Boolean = (((_arg1 == "true")) || ((_arg1 == "1")));
        var _local4:Boolean = (((_arg1 == "false")) || ((_arg1 == "0")));
        return (((((_local3) || (_local4))) ? _local3 : _arg2));
    }
}//package com.bokecc.lib.data 
