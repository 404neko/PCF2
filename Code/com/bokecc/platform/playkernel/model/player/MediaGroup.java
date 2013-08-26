package com.bokecc.platform.playkernel.model.player {
    import flash.utils.*;

    public class MediaGroup {

        private var _type:String;
        private var sources:Array;
        private var medias:Array;
        private var param:String;
        private var _flag;
        private var _beginTime:Number;
        private var _duration:Number;
        private var _media:MediaProxy;

        public function MediaGroup(_arg1:String, _arg2:Array, _arg3:String=""){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super();
            this._type = _arg1;
            this.sources = _arg2;
            this.param = _arg3;
            this.medias = [];
        }
        public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._duration);
        }
        public function get beginTime():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._beginTime);
        }
        public function get type():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._type);
        }
        public function get length():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.sources.length);
        }
        public function getMediaProxy(_arg1:int):MediaProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:PlayServer;
            var _local2:MediaProxy = this.medias[_arg1];
            if (_local2 == null){
                _local3 = this.sources[_arg1];
                if (false){
                    5;
                    this.param;
                    _local3;
                } else {
                    _local3.param = this.param;
                };
                var _local4 = new MediaProxy(_local3);
                if (false){
                    5;
                    _local4;
                    _arg1;
                    this.medias;
                } else {
                    this.medias[_arg1] = _local4;
                };
                _local2 = _local4;
            };
            return (_local2);
        }
        public function get isAllDisabled():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local3:MediaProxy;
            var _local1:int = this.length;
            var _local2:int;
            if (_local2 >= _local1){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local3 = this.getMediaProxy(_local2);
            if (_local3.status >= MediaProxy.Status_None){
                return (false);
            };
            _local2++;
            //unresolved if
            return (true);
        }
        public function get media():MediaProxy{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._media);
        }
        public function preloadBegin():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._beginTime = getTimer();
        }
        public function preloadFinish(_arg1:Boolean, _arg2:MediaProxy):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._flag = _arg1;
            this._media = _arg2;
            this._duration = (getTimer() - this.beginTime);
        }

        if (37 == 34){
            return;
            /*not popped
            MediaGroup
            */
        };
        //unresolved jump
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.player 
