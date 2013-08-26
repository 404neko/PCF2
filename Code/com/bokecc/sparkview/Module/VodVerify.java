package com.bokecc.sparkview.Module {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.proxy.*;
    import com.bokecc.sparkview.view.*;

    public class VodVerify extends BasicModule {

        public static const Name:String = "VodVerify.Name";

        public function VodVerify(){
            super(Name);
        }
        private function get vodAPI():VodAPIProxy{
            return ((facade.retrieveProxy(VodAPIProxy.Name) as VodAPIProxy));
        }
        override public function listNotificationInterests():Array{
            return ([ControlViewMediator.SetProgress]);
        }
        override public function handleNotification(_arg1:INotification):void{
            switch (_arg1.getName()){
                case ControlViewMediator.SetProgress:
                    this.onProgress();
                    break;
            };
        }
        private function onProgress():void{
            var _local1:KernelEventProxy;
            if (playKernel.position >= this.vodAPI.freetime){
                _local1 = (facade.retrieveProxy(KernelEventProxy.Name) as KernelEventProxy);
                _local1.status = this.vodAPI.message;
                alert(_local1.status);
                playKernel.reset();
                this.invalid();
                facade.removeMediator(Name);
            };
        }
        private function invalid():void{
            showLoading(false);
            kernelProxy.allowOperate = false;
            sendNotification(ControlViewMediator.ControlBarEnabled, false);
            sendNotification(RightiMenuMediator.RightMenuEnabled, false);
        }

    }
}//package com.bokecc.sparkview.Module 
