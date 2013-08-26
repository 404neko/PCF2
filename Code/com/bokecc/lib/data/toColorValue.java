package com.bokecc.lib.data {

    public function toColorValue(_arg1:String):int{
        if (_arg1 != null){
            if (_arg1.indexOf("#") == 0){
                return (int(("0x" + _arg1.slice(1, 7))));
            };
            if (_arg1.indexOf("0x") == 0){
                return (int(_arg1.slice(0, 8)));
            };
        };
        return (-1);
    }
}//package com.bokecc.lib.data 
