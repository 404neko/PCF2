package com.bokecc.lib.net.loader {
    import flash.net.*;

    public class APILoader extends BaseLoader implements ILoader {

        private var _loader:URLLoader;

        override protected function newLoader():void{
            _dispatcher = (this._loader = new URLLoader());
        }
        override protected function toLoad(_arg1:URLRequest):void{
            this._loader.load(_arg1);
        }
        override protected function toUnload():void{
            this._loader.close();
        }
        override public function get content(){
            return (this._loader.data);
        }

    }
}//package com.bokecc.lib.net.loader 
