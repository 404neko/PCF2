package com.bokecc.lib.media {
    import flash.events.*;

    public class MediaEvent extends Event {

        public static const Ready:String = "Media.Play.Ready";
        public static const PlayStart:String = "Media.Play.Start";
        public static const PlayPause:String = "Media.Play.Pause";
        public static const PlayResume:String = "Media.Play.Resume";
        public static const PlayFinish:String = "Media.Play.Finish";
        public static const PlayError:String = "Media.Play.Error";
        public static const PlayStatus:String = "Media.Play.Status";
        public static const SeekComplete:String = "Media.Seek.OperationComplete";
        public static const SeekBufferFull:String = "Media.Seek.BufferFull";
        public static const BufferLoadFull:String = "Media.Buffer.LoadFull";
        public static const BufferSeekFull:String = "Media.Buffer.SeekFull";
        public static const BufferFull:String = "Media.Buffer.Full";
        public static const BufferEmpty:String = "Media.Buffer.Empty";
        public static const WaitingStatus:String = "Media.Waiting.Status";
        public static const LoadStartSoon:String = "Media.Load.StartSoon";
        public static const LoadStart:String = "Media.Load.Start";
        public static const LoadPositionRevised:String = "Media.Load.PositionRevised";
        public static const LoadFinish:String = "Media.Load.Finish";
        public static const BrightnessChanged:String = "Media.Setting.Brightness";
        public static const ContrastChanged:String = "Media.Setting.Contrast";
        public static const ScaleChanged:String = "Media.Setting.Scale";
        public static const ZScaleChanged:String = "Media.Setting.ZScale";
        public static const VolumeChanged:String = "Media.Setting.Volume";
        public static const Resize:String = "Media.Displayer.Resize";
        public static const Click:String = "Media.Displayer.Click";
        public static const InfoUpdated:String = "Media.Info.Updated";
        public static const GetFileType:String = "Media.Info.GetFileType";
        public static const ALL:String = "AllMediaEvent";

        private var _code:String;
        private var _value;

        public function MediaEvent(_arg1:String, _arg2=null){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            super(this.eventType);
            this._code = _arg1;
            this._value = _arg2;
        }
        protected function get eventType():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (MediaEvent.ALL);
        }
        override public function clone():Event{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (new MediaEvent(this.code, this.value));
        }
        public function get code():String{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._code);
        }
        public function get value(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            return (this._value);
        }

        if (37 == 34){
            return;
            /*not popped
            MediaEvent
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
    //unresolved jump
}//package com.bokecc.lib.media 
