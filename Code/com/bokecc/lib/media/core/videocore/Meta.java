package com.bokecc.lib.media.core.videocore {

    public class Meta {

        private var _data:Object;
        private var _keyframes:Object;
        private var _keyframeLength:uint;
        private var _filepositions:Array;
        private var _times:Array;

        public function Meta(_arg1:Object){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:Array;
            var _local3:int;
            super();
            this._data = _arg1;
            this._keyframes = _arg1["keyframes"];
            if (this._keyframes){
                this._filepositions = this._keyframes["filepositions"];
                this._times = this._keyframes["times"];
                this._keyframeLength = this._filepositions.length;
            } else {
                this._filepositions = [];
                this._times = [];
                this._keyframes = {
                    filepositions:this._filepositions,
                    times:this._times
                };
                _local2 = _arg1["seekpoints"];
                if (_local2){
                    this._keyframeLength = _local2.length;
                    _local3 = 0;
                    if (_local3 >= this._keyframeLength){
                    } else {
                        //unresolved jump
                    };
                    //unresolved jump
                    if (false){
                        5;
                        _local2[_local3]["offset"];
                        this._filepositions;
                    } else {
                        this._filepositions.push(_local2[_local3]["offset"]);
                    };
                    if (false){
                        5;
                        _local2[_local3]["time"];
                        this._times;
                    } else {
                        this._times.push(_local2[_local3]["time"]);
                    };
                    _local3++;
                    //unresolved if
                };
            };
        }
        public function getValue(_arg1:String){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._data[_arg1]);
        }
        public function get duration():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Number = this.getValue("duration");
            if (isNaN(_local1)){
                _local1 = 0;
            };
            return (_local1);
        }
        public function get filesize():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:Number = this.getValue("filesize");
            if (isNaN(_local1)){
                _local1 = 0;
            };
            return (_local1);
        }
        public function get w():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getValue("width"));
        }
        public function get h():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this.getValue("height"));
        }
        public function get scale():Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local1:Number = this.w;
            var _local2:Number = this.h;
            if (((!(isNaN(_local1))) && (!(isNaN(_local2))))){
                return ((_local1 / _local2));
            };
            return (0);
        }
        public function get canSeekToEnd():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this.getValue("canSeekToEnd")) || ((this.getTime((this._keyframeLength - 1)) == this.duration))));
        }
        public function get keyframes():Object{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._keyframes);
        }
        public function get hasKeyframes():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return ((this._keyframeLength > 0));
        }
        public function get keyframeLength():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._keyframeLength);
        }
        public function getFileposition(_arg1:int):int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if ((((_arg1 < 0)) || ((_arg1 >= this._keyframeLength)))){
                return (-1);
            };
            return (this._filepositions[_arg1]);
        }
        public function getTime(_arg1:int):Number{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if ((((_arg1 < 0)) || ((_arg1 >= this._keyframeLength)))){
                return (-1);
            };
            return (this._times[_arg1]);
        }
        public function setKeyframe(_arg1:int, _arg2:int, _arg3:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (((this.hasKeyframes) && ((_arg1 < this._filepositions.length)))){
                if (false){
                    5;
                    _arg3;
                    _arg1;
                    this._times;
                } else {
                    this._times[_arg1] = _arg3;
                };
                if (false){
                    5;
                    _arg2;
                    _arg1;
                    this._filepositions;
                } else {
                    this._filepositions[_arg1] = _arg2;
                };
            };
        }
        public function removeKeyframes(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (this.hasKeyframes){
                if (false){
                    5;
                    1;
                    _arg1;
                    this._times;
                } else {
                    this._times.splice(_arg1, 1);
                };
                if (false){
                    5;
                    1;
                    _arg1;
                    this._filepositions;
                } else {
                    this._filepositions.splice(_arg1, 1);
                };
                this._keyframeLength = this._filepositions.length;
            };
        }
        public function getKeyframeIndex(_arg1:Number, _arg2:Boolean=true):int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local6:int;
            if (!this.hasKeyframes){
                return (-1);
            };
            var _local3:Array = ((_arg2) ? this._times : this._filepositions);
            var _local4:int;
            var _local5:int = (this._keyframeLength - ((this.canSeekToEnd) ? 2 : 1));
            if ((_local5 - _local4) <= 1){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local6 = (_local4 + Math.floor(((_local5 - _local4) / 2)));
            if (_arg1 >= _local3[_local6]){
                _local4 = _local6;
                //unresolved jump
            };
            _local5 = _local6;
            //unresolved if
            return (_local4);
        }
        public function clone():Meta{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (new Meta(this._data));
        }

        if (37 == 34){
            return;
            /*not popped
            Meta
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.core.videocore 
