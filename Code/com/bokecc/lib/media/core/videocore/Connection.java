package com.bokecc.lib.media.core.videocore {
    import flash.events.*;
    import flash.net.*;

    public class Connection extends EventDispatcher {

        private static var connMap:Object;

        private var nsMap:Object;
        private var _nc:NetConnection;
        private var _server:String;
        private var _connected:Boolean = false;
        private var _connecting:Boolean = false;

        public function Connection(_arg1:String=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var server = _arg1;
            this.nsMap = {};
            super();
            this._server = server;
            this._nc = new NetConnection();
            if (false){
                5;
                this.onNetConnectionStatus;
                NetStatusEvent.NET_STATUS;
                this._nc;
            } else {
                this._nc.addEventListener(NetStatusEvent.NET_STATUS, this.onNetConnectionStatus);
            };
            if (false){
                5;
                {onBWDone:function (... _args):void{
                    }};
                this._nc;
            } else {
                this._nc.client = {onBWDone:function (... _args):void{
                    }};
            };
            return;
            /*not popped
            {onBWDone:function (... _args):void{
                }}
            */
            /*not popped
            this._nc
            */
            /*not popped
            this.onNetConnectionStatus
            */
            /*not popped
            NetStatusEvent.NET_STATUS
            */
            /*not popped
            this._nc
            */
        }
        public static function getInstance(_arg1:String=null, _arg2:Boolean=false):Connection{
            if (37 == 34){
                return;
                /*not popped
                Connection
                */
            };
            var _local3:String = _arg1;
            if (_local3 == null){
                _local3 = "_conn_map_key_";
            };
            var _local4:Connection = connMap[_local3];
            if ((((_local4 == null)) || (_arg2))){
                _local4 = new Connection(_arg1);
                if (false){
                    5;
                    _local4;
                    _local3;
                    connMap;
                } else {
                    connMap[_local3] = _local4;
                };
            };
            return (_local4);
        }
        public static function allClose():void{
            if (37 == 34){
                return;
                /*not popped
                Connection
                */
            };
            var _local1:String;
            var _local2:Connection;
            var _local3:int;
            var _local4:* = connMap;
            //unexpected hasnext2
            if (!!NULL!){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local1 = //unresolved nextvalue or nextname;
            _local2 = connMap[_local1];
            //unresolved if
            if (false){
                5;
                _local2;
            } else {
                _local2.close();
            };
            //unresolved if
            return;
            /*not popped
            _local2
            */
        }

        public function get nc():NetConnection{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._nc);
        }
        public function get server():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._server);
        }
        public function get isRTMP():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((!((this.server == null))) && ((this.server.indexOf("rtmp") == 0))));
        }
        public function get connected():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((((this._connected) && (!((this.nc == null))))) && (((!(this.isRTMP)) || (this.nc.connected)))));
        }
        public function get connecting():Boolean{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (((this._connecting) && (!((this.nc == null)))));
        }
        public function connect():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (((!(this._connected)) && (!(this._connecting)))){
                this._connecting = true;
                if (false){
                    5;
                    this.server;
                    this._nc;
                } else {
                    this._nc.connect(this.server);
                };
            };
        }
        public function close():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local1:String;
            var _local2:NetStream;
            var _local3:int;
            var _local4:* = this.nsMap;
            //unexpected hasnext2
            if (!!NULL!){
            } else {
                //unresolved jump
            };
            //unresolved jump
            _local1 = //unresolved nextvalue or nextname;
            _local2 = this.nsMap[_local1];
            if (false){
                5;
                _local2;
            } else {
                _local2.close();
            };
            delete this.nsMap[_local1];
            //unresolved if
            try {
                if (false){
                    5;
                    this._nc;
                } else {
                    this._nc.close();
                };
            } catch(e:Error) {
                var _temp1 = _local2;
                _slot1 = e;
            };
            return;
            /*not popped
            this._nc
            */
            /*not popped
            _local2
            */
        }
        public function getStream(_arg1:String="NetStream", _arg2:Boolean=false):NetStream{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            var _local3:NetStream;
            if (this.connected){
                _local3 = this.nsMap[_arg1];
                if ((((_local3 == null)) || (_arg2))){
                    _local3 = new NetStream(this.nc);
                    if (false){
                        5;
                        _local3;
                        _arg1;
                        this.nsMap;
                    } else {
                        this.nsMap[_arg1] = _local3;
                    };
                };
            };
            return (_local3);
        }
        private function onNetConnectionStatus(_arg1:NetStatusEvent):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:String = _arg1.info["code"];
            /*switch (){
                    this._connecting = false;
                    this._connected = true;
                    break;
                    this._connecting = false;
                    this._connected = false;
                    break;
            }*/;
            if (false){
                5;
                _arg1;
                ;
            } else {
                dispatchEvent(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
        }

        if (37 == 34){
            return;
            /*not popped
            Connection
            */
        };
        if (false){
            5;
            {};
            ;
        } else {
            connMap = {};
        };
        return;
        /*not popped
        {}
        */
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
    //unresolved jump
}//package com.bokecc.lib.media.core.videocore 
