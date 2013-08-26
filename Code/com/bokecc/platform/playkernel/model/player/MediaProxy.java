package com.bokecc.platform.playkernel.model.player {
    import flash.events.*;
    import com.bokecc.lib.media.*;
    import com.bokecc.lib.media.core.*;
    import com.bokecc.platform.playkernel.model.player.monitor.*;
    import com.bokecc.lib.media.core.video.*;

    public class MediaProxy extends EventDispatcher {

        public static const Status_Success:int = 1;
        public static const Status_None:int = 0;
        public static const Status_Error:int = -1;
        public static const Status_Break:int = -2;

        private var _status:int;
        private var _source:PlayServer;
        private var _media:IMediaBase;
        private var _flare:FlareMonitor;
        private var _traffic:TrafficMonitor;

        public function MediaProxy(_arg1:PlayServer){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super();
            this._source = _arg1;
            /*switch (){
                    this._media = new FLV(_arg1);
                    break;
                    this._media = new PCF(_arg1);
                    break;
                    this._media = new MP4(_arg1);
                    break;
                    this._media = new RTMP(_arg1);
                    break;
                    this._media = new Video(_arg1);
            }*/;
            this._traffic = new TrafficMonitor(this._media, _arg1.quality);
            this._flare = new FlareMonitor(this._media);
            if (false){
                5;
                dispatchEvent;
                MediaEvent.ALL;
                this._media;
            } else {
                this._media.addEventListener(MediaEvent.ALL, dispatchEvent);
            };
            return;
            /*not popped
            dispatchEvent
            */
            /*not popped
            MediaEvent.ALL
            */
            /*not popped
            this._media
            */
        }
        public function start():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this._media;
            } else {
                this._media.start();
            };
            if (false){
                5;
                true;
                this._media;
            } else {
                this._media.pause(true);
            };
            return;
            /*not popped
            true
            */
            /*not popped
            this._media
            */
            /*not popped
            this._media
            */
        }
        public function get source():PlayServer{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._source);
        }
        public function get flare():FlareMonitor{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._flare);
        }
        public function get traffic():TrafficMonitor{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._traffic);
        }
        public function get media():IMediaBase{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._media);
        }
        public function set status(_arg1:int):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            this._status = _arg1;
            if (false){
                5;
                _arg1;
                this.flare;
            } else {
                this.flare.setSpeedTestFinish(_arg1);
            };
            return;
            /*not popped
            _arg1
            */
            /*not popped
            this.flare
            */
        }
        public function get status():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            return (this._status);
        }
        public function get byteLoaded():int{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if ((this._media is RTMP)){
                if (this._media.ready){
                    return (1);
                };
            } else {
                return (this.flare.currentByteLoaded);
            };
            return (0);
        }

        if (37 == 34){
            return;
            /*not popped
            MediaProxy
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.platform.playkernel.model.player 
