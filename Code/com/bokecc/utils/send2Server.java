package com.bokecc.utils {
    import flash.net.*;

    public function send2Server(_arg1:String, _arg2:URLVariables=null, _arg3:Boolean=true):void{
        var url:* = _arg1;
        var data = _arg2;
        var random:Boolean = _arg3;
        if (((!((data == null))) && (random))){
            data["random"] = Math.random();
        };
        var request:* = new URLRequest(url);
        request.data = data;
        try {
            sendToURL(request);
        } catch(e:Error) {
        };
    }
}//package com.bokecc.utils 
