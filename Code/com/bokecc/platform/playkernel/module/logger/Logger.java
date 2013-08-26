package com.bokecc.platform.playkernel.module.logger {
    import flash.events.*;
    import com.bokecc.framework.mvc.*;
    import com.bokecc.platform.playkernel.module.logger.items.base.*;
    import com.bokecc.platform.playkernel.api.*;
    import com.bokecc.platform.playkernel.module.logger.items.spark.*;
    import com.bokecc.platform.playkernel.module.logger.items.flare.*;
    import com.bokecc.platform.playkernel.module.logger.items.traffic.*;

    public class Logger extends Mediator {

        public static const NAME:String = "PlayKernel.Mediator.Logger";

        private var data:LoggerData;
        private var itemMap:Object;

        public function Logger(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(NAME);
        }
        override public function onRemove():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this;
            } else {
                this.clear();
            };
            return;
            /*not popped
            this
            */
        }
        override public function get events():Array{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return ([PlayKernelEvent.PlayInitialized, PlayKernelEvent.PlayInfoLoadSuccess, PlayKernelEvent.PlayStopped, LogEvent.ALL]);
        }
        override public function eventHandler(_arg1:Event):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:PlayKernelEvent = (_arg1 as PlayKernelEvent);
            if (_local2){
                /*switch (){
                        this.data = (model.registerProxy(new LoggerData()) as LoggerData);
                        break;
                        if (false){
                            5;
                            this;
                        } else {
                            this.initLog();
                        };
                        break;
                        if (false){
                            5;
                            this;
                        } else {
                            this.clear();
                        };
                        break;
                }*/;
            };
            var _local3:LogEvent = (_arg1 as LogEvent);
            if (_local3){
                if (false){
                    5;
                    _local3;
                    this;
                } else {
                    this.onLogEvent(_local3);
                };
            };
        }
        private function onLogEvent(_arg1:LogEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                _arg1.toString();
                this.data;
            } else {
                this.data.addLogData(_arg1.toString());
            };
            return;
            /*not popped
            _arg1.toString()
            */
            /*not popped
            this.data
            */
        }
        private function initLog():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            this.itemMap = {};
            if (false){
                5;
                new FirstBufferFullLog();
                this;
            } else {
                this.addItem(new FirstBufferFullLog());
            };
            if (false){
                5;
                new PlayActionLog();
                this;
            } else {
                this.addItem(new PlayActionLog());
            };
            if (false){
                5;
                new PlayLog();
                this;
            } else {
                this.addItem(new PlayLog());
            };
            if (false){
                5;
                new TimeLog();
                this;
            } else {
                this.addItem(new TimeLog());
            };
            if (false){
                5;
                new TrafficLog();
                this;
            } else {
                this.addItem(new TrafficLog());
            };
            if (this.data.hasFlareStatistics){
                if (false){
                    5;
                    new PlayReadyLog();
                    this;
                } else {
                    this.addItem(new PlayReadyLog());
                };
                if (false){
                    5;
                    new PreloadStatusLog();
                    this;
                } else {
                    this.addItem(new PreloadStatusLog());
                };
                if (false){
                    5;
                    new LoadStartLog();
                    this;
                } else {
                    this.addItem(new LoadStartLog());
                };
                if (false){
                    5;
                    new PlayStartLog();
                    this;
                } else {
                    this.addItem(new PlayStartLog());
                };
                if (false){
                    5;
                    new BufferEmptyLog();
                    this;
                } else {
                    this.addItem(new BufferEmptyLog());
                };
                if (false){
                    5;
                    new BufferFullLog();
                    this;
                } else {
                    this.addItem(new BufferFullLog());
                };
                if (false){
                    5;
                    new PlayFailedLog();
                    this;
                } else {
                    this.addItem(new PlayFailedLog());
                };
                if (false){
                    5;
                    new PlayPauseLog();
                    this;
                } else {
                    this.addItem(new PlayPauseLog());
                };
                if (false){
                    5;
                    new PlaySeekLog();
                    this;
                } else {
                    this.addItem(new PlaySeekLog());
                };
                if (false){
                    5;
                    new SwitchQualityLog();
                    this;
                } else {
                    this.addItem(new SwitchQualityLog());
                };
                if (false){
                    5;
                    new PlayFinishLog();
                    this;
                } else {
                    this.addItem(new PlayFinishLog());
                };
                if (false){
                    5;
                    new RetryLog();
                    this;
                } else {
                    this.addItem(new RetryLog());
                };
                if (false){
                    5;
                    new PlayProgressLog();
                    this;
                } else {
                    this.addItem(new PlayProgressLog());
                };
            };
            return;
            /*not popped
            new TrafficLog()
            */
            /*not popped
            this
            */
            /*not popped
            new TimeLog()
            */
            /*not popped
            this
            */
            /*not popped
            new PlayLog()
            */
            /*not popped
            this
            */
            /*not popped
            new PlayActionLog()
            */
            /*not popped
            this
            */
            /*not popped
            new FirstBufferFullLog()
            */
            /*not popped
            this
            */
        }
        private function clear():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:String;
            var _local2:int;
            var _local3:* = this.itemMap;
            //unexpected hasnext2
            if (!!NULL!){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local1 = //unresolved nextvalue or nextname;
            delete this.itemMap[_local1];
            if (false){
                5;
                _local1;
                view;
            } else {
                view.removeMediator(_local1);
            };
            //unresolved if
            return;
            /*not popped
            _local1
            */
            /*not popped
            view
            */
        }
        private function addItem(_arg1:LogItem):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                _arg1.name;
                this.itemMap;
            } else {
                this.itemMap[_arg1.name] = _arg1;
            };
            if (false){
                5;
                _arg1;
                view;
            } else {
                view.registerMediator(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            view
            */
            /*not popped
            _arg1
            */
            /*not popped
            _arg1.name
            */
            /*not popped
            this.itemMap
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Logger
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.module.logger 
