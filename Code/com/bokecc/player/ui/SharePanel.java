package com.bokecc.player.ui {
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.containers.*;

    public class SharePanel extends Panel {

        private var _canvas:ShareCanvas;

        public function SharePanel(){
            this.headHeight = 50;
            this.width = 455;
            this.height = 0xFF;
            this.title = "分享";
            this.titleAlign = Align.CENTER;
            this.horizontalAlign = Align.CENTER;
            this.layoutName = VBoxLayout.NAME;
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        public function get htmlCode():String{
            return (this.canvas.htmlCode);
        }
        public function set htmlCode(_arg1:String):void{
            this.canvas.htmlCode = _arg1;
        }
        public function get flashUrl():String{
            return (this.canvas.flashUrl);
        }
        public function set flashUrl(_arg1:String):void{
            this.canvas.flashUrl = _arg1;
        }
        public function get videoUrl():String{
            return (this.canvas.videoUrl);
        }
        public function set videoUrl(_arg1:String):void{
            this.canvas.videoUrl = _arg1;
        }
        public function get codePictureUrl():String{
            return (this.canvas.codePictureUrl);
        }
        public function set codePictureUrl(_arg1:String):void{
            this.canvas.codePictureUrl = _arg1;
        }
        public function get canvas():ShareCanvas{
            if (!this._canvas){
                this._canvas = new ShareCanvas();
                this._canvas.addEventListener(ShareEvent.SHARE_KAIXIN, this.shareCanvasOnEvent);
                this._canvas.addEventListener(ShareEvent.SHARE_QQ, this.shareCanvasOnEvent);
                this._canvas.addEventListener(ShareEvent.SHARE_RENREN, this.shareCanvasOnEvent);
                this._canvas.addEventListener(ShareEvent.SHARE_TENXUN, this.shareCanvasOnEvent);
                this._canvas.addEventListener(ShareEvent.SHARE_XINLANG, this.shareCanvasOnEvent);
                this._canvas.addEventListener(ShareEvent.COPY_FLASHURL, this.shareCanvasOnEvent);
                this._canvas.addEventListener(ShareEvent.COPY_HTMLCODE, this.shareCanvasOnEvent);
                this._canvas.addEventListener(ShareEvent.COPY_VIDEOURL, this.shareCanvasOnEvent);
            };
            return (this._canvas);
        }
        private function shareCanvasOnEvent(_arg1:ShareEvent):void{
            dispatchEvent(_arg1.clone());
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.canvas);
        }
        override public function get titleLabel():Label{
            if (!_titleLabel){
                _titleLabel = new Label();
                _titleLabel.fontSize = 15;
                _titleLabel.color = 0xFFFFFF;
                _titleLabel.bold = true;
                _titleLabel.left = titlePadding;
                _titleLabel.verticalCenter = 0;
            };
            return (_titleLabel);
        }

    }
}//package com.bokecc.player.ui 
