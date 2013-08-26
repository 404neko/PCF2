package com.bokecc.lib.data {

    public function as2_escape(_arg1:String):String{
        var _local5:int;
        var _local6:String;
        var _local7:String;
        var _local2:Object = {
            -:"%2D",
            _:"%5F",
            .:"%2E",
            !:"%21",
            ~:"%7E",
            *:"%2A",
            ':"%27",
            (:"%28",
            ):"%29"
        };
        _arg1 = encodeURIComponent(_arg1);
        var _local3 = "";
        var _local4:int = _arg1.length;
        while (_local5 < _local4) {
            _local6 = _arg1.charAt(_local5);
            _local7 = _local2[_local6];
            _local3 = (_local3 + (((_local7 == null)) ? _local6 : _local7));
            _local5++;
        };
        return (_local3);
    }
}//package com.bokecc.lib.data 
