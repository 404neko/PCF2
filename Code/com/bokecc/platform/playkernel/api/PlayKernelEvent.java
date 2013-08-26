package com.bokecc.platform.playkernel.api {
    import flash.events.*;

    public class PlayKernelEvent extends Event {

        public static const LoaderInitialized:String = "Player.Initialized";
        public static const KernelInitialized:String = "Kernel.Initialized";
        public static const PlayStartup:String = "Player.Play.Startup";
        public static const PlayInitialized:String = "Player.Play.Initialized";
        public static const PlayStopped:String = "Player.Play.Stopped";
        public static const PlayClosed:String = "Player.Play.Closed";
        public static const PlayerError:String = "Player.Error";
        public static const ListLoadBegin:String = "Player.Info.ListLoadBegin";
        public static const ListLoadError:String = "Player.Info.ListLoadError";
        public static const ListLoadSuccess:String = "Player.Info.ListLoadSuccess";
        public static const ListVerifyError:String = "Player.Info.ListVerifyError";
        public static const ListInfoReady:String = "Player.Info.ListReady";
        public static const ListPlayStart:String = "Player.Play.ListPlayStart";
        public static const PlayInfoLoadBegin:String = "Player.Info.LoadBegin";
        public static const PlayInfoLoadError:String = "Player.Info.LoadError";
        public static const PlayInfoLoadSuccess:String = "Player.Info.LoadSuccess";
        public static const PlayInfoVerifyError:String = "Player.Info.VerifyError";
        public static const AllInfoReady:String = "Player.Info.AllReady";
        public static const ViewLoadBegin:String = "Player.View.LoadBegin";
        public static const ViewLoadSuccess:String = "Player.View.LoadSuccess";
        public static const ViewLoadError:String = "Player.View.LoadError";
        public static const ViewInitializeBegin:String = "Player.View.InitializeBegin";
        public static const ViewInitializeSuccess:String = "Player.View.InitializeSuccess";
        public static const ViewInitializeError:String = "Player.View.InitializeError";
        public static const BeginningStart:String = "Player.Beginning.Start";
        public static const BeginningFinished:String = "Player.Beginning.Finish";
        public static const PreloadStart:String = "Player.Preload.BeginningPreloadStart";
        public static const PreloadSuccess:String = "Player.Preload.BeginningPreloadSuccess";
        public static const PreloadError:String = "Player.Preload.BeginningPreloadError";
        public static const SwitchQualityStart:String = "Player.Preload.SwitchQualityStart";
        public static const SwitchQualitySuccess:String = "Player.Preload.SwitchQualitySuccess";
        public static const SwitchQualityError:String = "Player.Preload.SwitchQualityError";
        public static const ReconnectStart:String = "Player.Preload.ReconnectStart";
        public static const ReconnectSuccess:String = "Player.Preload.ReconnectSuccess";
        public static const ReconnectError:String = "Player.Preload.ReconnectError";
        public static const Resize:String = "Media.Displayer.Resize";
        public static const Click:String = "Media.Displayer.Click";
        public static const BrightnessChanged:String = "Media.Setting.Brightness";
        public static const ContrastChanged:String = "Media.Setting.Contrast";
        public static const ScaleChanged:String = "Media.Setting.Scale";
        public static const VolumeChanged:String = "Media.Setting.Volume";
        public static const QualityChanged:String = "Player.Quality.Changed";
        public static const PlayReady:String = "Player.Play.Ready";
        public static const WillStart:String = "Player.Play.WillStart";
        public static const PlayStart:String = "Player.Play.Start";
        public static const PlayRealStart:String = "Player.Play.RealStart";
        public static const PlayPause:String = "Media.Play.Pause";
        public static const PlayResume:String = "Media.Play.Resume";
        public static const SeekComplete:String = "Media.Seek.OperationComplete";
        public static const SeekBufferFull:String = "Media.Seek.BufferFull";
        public static const LoadPositionRevised:String = "Media.Load.PositionRevised";
        public static const BufferEmpty:String = "Media.Buffer.Empty";
        public static const BufferFull:String = "Media.Buffer.Full";
        public static const PlayRealFinish:String = "Player.Play.RealFinish";
        public static const PlayFinish:String = "Player.Play.Finish";
        public static const RecommendedLoaded:String = "Player.Recommended.Loaded";
        public static const RecommendedCancel:String = "Player.Recommended.Cancel";
        public static const RecommendedError:String = "Player.Recommended.Error";

        private var _value;

        public function PlayKernelEvent(_arg1:String, _arg2=null){
            super(_arg1);
            this._value = _arg2;
        }
        public function get value(){
            return (this._value);
        }
        override public function clone():Event{
            return (new PlayKernelEvent(type, this.value));
        }

    }
}//package com.bokecc.platform.playkernel.api 
