package com.bokecc.sparkview {
    import com.bokecc.core.*;
    import flash.display.*;
    import flash.system.*;
    import com.bokecc.lib.utils.*;

    public class SparkView extends Application {

        public static const Initialized:String = "PlayKernel.PlayerView.Initialized";

        protected var _facade:IApplicationFacade;
        protected var st:StageUtil;

        public function SparkView(_arg1:IApplicationFacade=null){
            Security.allowDomain("*");
            this._facade = ((_arg1)!=null) ? _arg1 : ApplicationFacade.getInstance();
        }
        public function init(_arg1:Sprite):void{
            _arg1.addChild(this);
            this.st = StageUtil.instance;
            this.st.init(stage);
            this.facade.startUp(this, _arg1);
            setSize(this.st.width, this.st.height);
        }
        public function destroy():void{
            this.facade.destroy();
        }
        protected function get facade():IApplicationFacade{
            return (this._facade);
        }
        public function reset():void{
        }

    }
}//package com.bokecc.sparkview 
