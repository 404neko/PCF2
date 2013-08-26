package com.bokecc.sparkview.step {
    import flash.events.*;
    import com.bokecc.sparkview.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.lib.data.*;

    public class PreloadStep extends BasicCommand {

        public static const Step_PreLoad:String = "SparkView.LoadSkinFinish";

        override public function execute(_arg1:INotification):void{
            var _local2:ViewCoreMediator;
            showLoading(true);
            sendNotification(ViewCoreMediator.ApplySkinConfig, {
                skinColor:[user.backgroundColor, user.foreColor],
                autoHiden:user.autoHidden
            });
            sendNotification(BigBtnViewMediator.AlwaysHidePlayButton, user.isCaixin);
            sendNotification(ViewCoreMediator.CheckCustom, {
                isCaixin:user.isCaixin,
                isShow:kernelProxy.autostart
            });
            sendNotification(LoadViewMediator.ShowLoadingImg, {
                isShow:false,
                url:user.loadingpic
            }, "preload");
            if (!isNull(user.logoURL)){
                sendNotification(LoadViewMediator.ShowLogo, {
                    url:user.logoURL,
                    link:user.logoLink,
                    alpha:user.logoTransparency,
                    position:user.logoPosition
                });
            };
            if (param.listMode){
                _local2 = (facade.retrieveMediator(ViewCoreMediator.Name) as ViewCoreMediator);
                facade.registerMediator(new ListViewMediator(_local2.view));
            };
            (facade as ApplicationFacade).app.dispatchEvent(new Event(SparkView.Initialized));
        }

    }
}//package com.bokecc.sparkview.step 
