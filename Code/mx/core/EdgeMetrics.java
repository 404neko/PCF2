package mx.core {

    public class EdgeMetrics {

        mx_internal static const VERSION:String = "4.1.0.21490";
        public static const EMPTY:EdgeMetrics = new EdgeMetrics(0, 0, 0, 0);
;

        public var bottom:Number;
        public var left:Number;
        public var right:Number;
        public var top:Number;

        public function EdgeMetrics(_arg1:Number=0, _arg2:Number=0, _arg3:Number=0, _arg4:Number=0){
            this.left = _arg1;
            this.top = _arg2;
            this.right = _arg3;
            this.bottom = _arg4;
        }
        public function clone():EdgeMetrics{
            return (new EdgeMetrics(this.left, this.top, this.right, this.bottom));
        }

    }
}//package mx.core 
