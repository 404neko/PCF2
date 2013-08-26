package com.bokecc.vo {
    import flash.utils.*;

    public class ComponentVO {

        public static const ID_FIELD:String = "id";
        public static const PARENT_FIELD:String = "parent";
        public static const HEIGHT_FIELD:String = "height";
        public static const WIDTH_FIELD:String = "width";
        public static const LEFT_FIELD:String = "left";
        public static const RIGHT_FIELD:String = "right";
        public static const TOP_FIELD:String = "top";
        public static const BOTTOM_FIELD:String = "bottom";
        public static const HORIZONTAL_CENTER_FIELD:String = "horizontalCenter";
        public static const VERTICAL_CENTER_FIELD:String = "verticalCenter";
        public static const PERCENT_WIDTH_FIELD:String = "percentWidth";
        public static const PERCENT_HEIGHT_FIELD:String = "percentHeight";
        public static const NAME_FIELD:String = "name";
        public static const TYPE_FIELD:String = "type";
        public static const VALUE_FIELD:String = "value";

        public var id:String;
        public var parent:String;
        public var height:Number = NaN;
        public var width:Number = NaN;
        public var left:Number = NaN;
        public var right:Number = NaN;
        public var top:Number = NaN;
        public var bottom:Number = NaN;
        public var horizontalCenter:Number = NaN;
        public var verticalCenter:Number = NaN;
        public var percentWidth:Number = NaN;
        public var percentHeight:Number = NaN;
        public var property:Dictionary;
        public var decorates:Dictionary;

        public function ComponentVO(){
            this.property = new Dictionary();
            this.decorates = new Dictionary();
        }
    }
}//package com.bokecc.vo 
