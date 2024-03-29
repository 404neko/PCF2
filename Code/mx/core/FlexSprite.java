﻿package mx.core {
    import flash.display.*;
    import mx.utils.*;

    public class FlexSprite extends Sprite {

        mx_internal static const VERSION:String = "4.1.0.21490";

        public function FlexSprite(){
            super();
            try {
                name = NameUtil.createUniqueName(this);
            } catch(e:Error) {
            };
        }
        override public function toString():String{
            return (NameUtil.displayObjectToString(this));
        }

    }
}//package mx.core 
