package com.bokecc.containers.layout {
    import com.bokecc.core.*;

    public class Layout {

        public static const NAME:String = "Layout";

        protected var target:Container;

        public function Layout(_arg1:Container){
            this.target = _arg1;
        }
        public function get name():String{
            return (NAME);
        }
        public function updateLayout():void{
        }

    }
}//package com.bokecc.containers.layout 
