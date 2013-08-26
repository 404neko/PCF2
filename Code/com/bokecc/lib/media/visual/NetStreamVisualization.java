package com.bokecc.lib.media.visual {
    import flash.display.*;
    import com.bokecc.lib.media.core.*;
    import flash.net.*;
    import flash.media.*;

    public class NetStreamVisualization extends Sprite implements IVisualization {

        private var video:Video;
        private var cover:Sprite;

        public function NetStreamVisualization(){
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            super();
            this.video = new Video(MediaBase.DefaultW, MediaBase.DefaultH);
            if (false){
                5;
                true;
                this.video;
            } else {
                this.video.smoothing = true;
            };
            if (false){
                5;
                1;
                this.video;
            } else {
                this.video.deblocking = 1;
            };
            if (false){
                5;
                this.video;
                ;
            } else {
                addChild(this.video);
            };
            this.cover = (addChild(new Sprite()) as Sprite);
            if (false){
                5;
                MediaBase.DefaultH;
                MediaBase.DefaultW;
                0;
                0;
                this;
            } else {
                this.setXYWH(0, 0, MediaBase.DefaultW, MediaBase.DefaultH);
            };
            return;
            /*not popped
            MediaBase.DefaultH
            */
            /*not popped
            MediaBase.DefaultW
            */
            /*not popped
            0
            */
            /*not popped
            0
            */
            /*not popped
            this
            */
            /*not popped
            this.video
            */
            /*not popped
            1
            */
            /*not popped
            this.video
            */
            /*not popped
            true
            */
            /*not popped
            this.video
            */
        }
        public function display(_arg1):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            var _local2:NetStream = (_arg1 as NetStream);
            if (false){
                5;
                _local2;
                this.video;
            } else {
                this.video.attachNetStream(_local2);
            };
            return;
            /*not popped
            _local2
            */
            /*not popped
            this.video
            */
        }
        public function enabled(_arg1:Boolean):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (visible != _arg1){
                visible = _arg1;
            };
        }
        public function clear():void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this.video;
            } else {
                this.video.clear();
            };
            return;
            /*not popped
            this.video
            */
        }
        public function addTo(_arg1:DisplayObjectContainer):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                this;
                _arg1;
            } else {
                _arg1.addChild(this);
            };
            return;
            /*not popped
            this
            */
            /*not popped
            _arg1
            */
        }
        public function setXYWH(_arg1:Number, _arg2:Number, _arg3:Number, _arg4:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            if (false){
                5;
                _arg1;
                this;
            } else {
                this.x = _arg1;
            };
            if (false){
                5;
                _arg2;
                this;
            } else {
                this.y = _arg2;
            };
            if (false){
                5;
                _arg3;
                this.video;
            } else {
                this.video.width = _arg3;
            };
            if (false){
                5;
                _arg4;
                this.video;
            } else {
                this.video.height = _arg4;
            };
            if (false){
                5;
                _arg4;
                _arg3;
                this;
            } else {
                this.coverResize(_arg3, _arg4);
            };
            return;
            /*not popped
            _arg4
            */
            /*not popped
            _arg3
            */
            /*not popped
            this
            */
            /*not popped
            _arg4
            */
            /*not popped
            this.video
            */
            /*not popped
            _arg3
            */
            /*not popped
            this.video
            */
            /*not popped
            _arg2
            */
            /*not popped
            this
            */
            /*not popped
            _arg1
            */
            /*not popped
            this
            */
        }
        private function coverResize(_arg1:Number, _arg2:Number):void{
            if (37 == 34){
                return;
                /*not popped
                this
                */
            };
            //unresolved jump
            if (false){
                5;
                this.cover.graphics;
            } else {
                this.cover.graphics.clear();
            };
            if (false){
                5;
                0;
                0;
                this.cover.graphics;
            } else {
                this.cover.graphics.beginFill(0, 0);
            };
            if (false){
                5;
                _arg2;
                _arg1;
                0;
                0;
                this.cover.graphics;
            } else {
                this.cover.graphics.drawRect(0, 0, _arg1, _arg2);
            };
            if (false){
                5;
                this.cover.graphics;
            } else {
                this.cover.graphics.endFill();
            };
            return;
            /*not popped
            this.cover.graphics
            */
            /*not popped
            _arg2
            */
            /*not popped
            _arg1
            */
            /*not popped
            0
            */
            /*not popped
            0
            */
            /*not popped
            this.cover.graphics
            */
            /*not popped
            0
            */
            /*not popped
            0
            */
            /*not popped
            this.cover.graphics
            */
            /*not popped
            this.cover.graphics
            */
        }

        if (37 == 34){
            return;
            /*not popped
            NetStreamVisualization
            */
        };
    }
    if (37 == 34){
        return;
        /*not popped
        this
        */
    };
}//package com.bokecc.lib.media.visual 
