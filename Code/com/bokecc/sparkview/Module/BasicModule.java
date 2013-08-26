package com.bokecc.sparkview.Module {
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.platform.playkernel.api.model.*;
    import com.bokecc.sparkview.proxy.*;
    import com.bokecc.platform.playkernel.api.*;
    import org.puremvc.as3.patterns.mediator.*;
    import com.bokecc.sparkview.view.*;

    public class BasicModule extends Mediator implements IMediator {

        public function BasicModule(_arg1:String){
            super(_arg1);
        }
        public function get kernelProxy():PlayKernelProxy{
            return ((facade.retrieveProxy(PlayKernelProxy.Name) as PlayKernelProxy));
        }
        public function get playKernel():PlayKernel{
            return (this.kernelProxy.playKernel);
        }
        public function get user():UserInfo{
            return (this.playKernel.user);
        }
        public function get param():PlayerParam{
            return (this.playKernel.param);
        }
        public function get videoInfo():VideoInfo{
            return (this.playKernel.video);
        }
        protected function alert(_arg1:String, _arg2:Boolean=true, _arg3:String="提示", _arg4:Boolean=false, _arg5:String="", _arg6:Function=null):void{
            sendNotification(PanelViewMediator.ShowAlert, {
                msg:_arg1,
                isShow:_arg2,
                title:_arg3,
                canClose:_arg4,
                btnName:_arg5,
                btnCallback:_arg6
            });
        }
        protected function showLoading(_arg1:Boolean, _arg2:String=""):void{
            sendNotification(PanelViewMediator.ShowLoading, {
                isShow:_arg1,
                msg:_arg2
            });
        }

    }
}//package com.bokecc.sparkview.Module 
