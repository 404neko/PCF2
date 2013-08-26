package com.bokecc.sparkview {
    import flash.display.*;
    import org.puremvc.as3.interfaces.*;
    import com.bokecc.sparkview.proxy.*;
    import com.bokecc.platform.playkernel.api.*;
    import org.puremvc.as3.patterns.facade.*;
    import com.bokecc.sparkview.view.*;
    import com.bokecc.sparkview.step.*;
    import com.bokecc.sparkview.command.*;
    import com.bokecc.sparkview.Module.*;

    public class ApplicationFacade extends Facade implements IApplicationFacade {

        private var _app:SparkView;
        private var mediators:Array;
        private var commands:Array;
        private var proxys:Array;

        public function ApplicationFacade(){
            this.mediators = new Array();
            this.commands = new Array();
            this.proxys = new Array();
        }
        public static function getInstance():IApplicationFacade{
            if (instance == null){
                instance = new (ApplicationFacade)();
            };
            return ((instance as ApplicationFacade));
        }

        public function startUp(_arg1:Sprite, _arg2:Sprite):void{
            this.removeAll();
            this._app = (_arg1 as SparkView);
            var _local3:PlayKernel = PlayKernel.getInstance(_arg2);
            var _local4:PlayKernelProxy = new PlayKernelProxy(_local3);
            _local4.allowOperate = false;
            this.registerProxy(_local4);
            this.registerProxy(new KernelEventProxy(_arg2));
            this.registerProxy(new MediaEventProxy(_arg2));
            this.registerProxy(new SharedObjectProxy());
            this.registerProxy(new CCModuleProxy(_local4));
            this.registerProxy(new KeyBoardProxy());
            this.registerProxy(new JSControlProxy());
            this.registerSparkCommand();
            this.registerViewMediator(_local3.displayObject, _arg2);
            sendNotification(InitStep.Step_Init);
        }
        public function get app():SparkView{
            return (this._app);
        }
        public function destroy():void{
            this.removeAllMediator();
        }
        public function removeAll():void{
            this.removeAllCommands();
            this.removeAllMediator();
            this.removeAllProxy();
        }
        protected function registerSparkCommand():void{
            this.registerCommand(InitStep.Step_Init, InitStep);
            this.registerCommand(PreloadStep.Step_PreLoad, PreloadStep);
            this.registerCommand(VerifyStep.Step_Verify, VerifyStep);
            this.registerCommand(PlayReadyStep.Step_ReadyPlay, PlayReadyStep);
            PlayReadyStep.initStatus();
            this.registerCommand(StartPlayStep.Step_StartPlay, StartPlayStep);
            this.registerCommand(KernelEventHandler.PlayKernelEventHandler, KernelEventHandler);
            this.registerCommand(MediaEventHandler.MediaEvent, MediaEventHandler);
            this.registerCommand(VodPlayCommand.VODPlayHandler, VodPlayCommand);
            this.registerCommand(OperateEventHandler.OperateEvent, OperateEventHandler);
            this.registerCommand(PanelEventHandler.PanelEvent, PanelEventHandler);
        }
        protected function registerViewMediator(_arg1:DisplayObject, _arg2:Sprite):void{
            if (!hasMediator(ViewCoreMediator.Name)){
                this.registerMediator(new ViewCoreMediator(this.app, _arg1, _arg2));
            };
            var _local3:ViewCoreMediator = (retrieveMediator(ViewCoreMediator.Name) as ViewCoreMediator);
            this.registerMediator(new BigBtnViewMediator(_local3.view));
            this.registerMediator(new ListViewMediator(_local3.view));
            this.registerMediator(new LoadViewMediator(_local3.view));
            this.registerMediator(new PanelViewMediator(_local3.view));
            this.registerMediator(new RightiMenuMediator(_local3.view));
            this.registerMediator(new ControlViewMediator(_local3.view));
            this.registerMediator(new EndIngViewMediator(_local3.view));
            this.registerMediator(new ProgressTimer());
            this.registerMediator(new BufferStatus());
            this.registerMediator(new RecordTime());
            this.registerMediator(new PlayAnalyse());
            this.registerMediator(new PlayFinish());
        }
        override public function registerMediator(_arg1:IMediator):void{
            super.registerMediator(_arg1);
            this.mediators.push(_arg1);
        }
        override public function registerCommand(_arg1:String, _arg2:Class):void{
            super.registerCommand(_arg1, _arg2);
            this.commands.push(_arg1);
        }
        override public function registerProxy(_arg1:IProxy):void{
            super.registerProxy(_arg1);
            this.proxys.push(_arg1);
        }
        protected function removeAllMediator():void{
            var _local2:IMediator;
            var _local1:int;
            while (_local1 < this.mediators.length) {
                _local2 = this.mediators[_local1];
                if (hasMediator(_local2.getMediatorName())){
                    removeMediator(_local2.getMediatorName());
                };
                _local1++;
            };
            this.mediators = new Array();
        }
        protected function removeAllCommands():void{
            var _local2:String;
            var _local1:int;
            while (_local1 < this.commands.length) {
                _local2 = this.commands[_local1];
                if (hasCommand(_local2)){
                    removeCommand(_local2);
                };
                _local1++;
            };
            this.commands = new Array();
        }
        protected function removeAllProxy():void{
            var _local2:IProxy;
            var _local1:int;
            while (_local1 < this.proxys.length) {
                _local2 = this.proxys[_local1];
                if (hasProxy(_local2.getProxyName())){
                    removeProxy(_local2.getProxyName());
                };
                _local1++;
            };
            this.proxys = new Array();
        }

    }
}//package com.bokecc.sparkview 
