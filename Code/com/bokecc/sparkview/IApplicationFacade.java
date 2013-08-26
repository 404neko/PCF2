package com.bokecc.sparkview {
    import flash.display.*;
    import org.puremvc.as3.interfaces.*;

    public interface IApplicationFacade extends IFacade {

        function startUp(_arg1:Sprite, _arg2:Sprite):void;
        function destroy():void;

    }
}//package com.bokecc.sparkview 
