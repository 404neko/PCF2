package com.bokecc.sparkview.step {
    import flash.system.*;
    import org.puremvc.as3.interfaces.*;
    import flash.net.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.utils.*;

    public class InitStep extends BasicCommand {

        public static const Step_Init:String = "SparkView.Init";

        override public function execute(_arg1:INotification):void{
            switch (user.id){
                case "171326":
                case "6AD08D198E57849A":
                case "192627":
                case "041388858AC9F003":
                case "195992":
                case "2EEB1E0C1BB017BC":
                case "197056":
                case "4F21A251DAE61656":
                case "196419":
                case "7BC662D9CA8EA71A":
                case "194778":
                case "FFD078EF186415D2":
                case "195226":
                case "A7A537A8A57CBB10":
                case "193843":
                case "94DC9EF1EA363016":
                case "199854":
                case "76A6B883B61A292D":
                case "198498":
                case "73B488DFC0A9F1C1":
                case "204175":
                case "91D33EBD7123E89B":
                case "205593":
                case "FCB5DB85C142BC02":
                case "207732":
                case "A4D3FC3708EB0DB9":
                case "208919":
                case "B735E8D6D698EAF5":
                case "210984":
                case "43EFE9832E17A49C":
                case "202800":
                case "3FBB3E1BEB75AA8F":
                    break;
                default:
                    sendNotification(ViewCoreMediator.AddContextMenu, {
                        caption:"powered by bokecc.com",
                        callback:this.gotoBokecc,
                        enabled:true
                    });
            };
            sendNotification(ViewCoreMediator.AddContextMenu, {
                caption:("Kernel Build:" + playKernel.version.playKernelVersion),
                callback:this.clickKernelVersion,
                enabled:true
            });
            sendNotification(ViewCoreMediator.AddContextMenu, {
                caption:("View Build:" + playKernel.version.playerViewVersion),
                callback:this.clickViewVersion,
                enabled:true
            });
            sendNotification(ViewCoreMediator.LoadSkin, (((CCURL.SKIN + "/skin_") + user.skinStyle) + ".swf"));
        }
        protected function gotoBokecc():void{
            navigateToURL(new URLRequest("http://www.bokecc.com/ccvideo.shtml"), "_blank");
        }
        protected function clickViewVersion():void{
            System.setClipboard(videoInfo.upid);
        }
        protected function clickKernelVersion():void{
        }

    }
}//package com.bokecc.sparkview.step 
