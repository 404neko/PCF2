package com.bokecc.player.ui {
    import flash.display.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class DisplayArea extends Canvas {

        private var _fullScreenTop:Number = 0;
        private var _fullScreenLeft:Number = 0;
        private var _fullScreenRight:Number = 0;
        private var _fullScreenBottom:Number = 0;
        private var _normalTop:Number = 0;
        private var _normalLeft:Number = 0;
        private var _normalRight:Number = 0;
        private var _normalBottom:Number = 0;
        private var _videoDisplayArea:VideoDisplayArea;
        private var _subjoinLayer:Canvas;
        private var _recommendLayer:RecommendLayer;
        private var _panelLayer:PanelLayer;

        public function get recommendLayer():RecommendLayer{
            if (!this._recommendLayer){
                this._recommendLayer = new RecommendLayer();
                this._recommendLayer.left = 0;
                this._recommendLayer.right = 0;
                this._recommendLayer.top = 0;
                this._recommendLayer.bottom = 0;
            };
            return (this._recommendLayer);
        }
        public function get subjoinLayer():Canvas{
            if (!this._subjoinLayer){
                this._subjoinLayer = new Canvas();
                this._subjoinLayer.left = 0;
                this._subjoinLayer.right = 0;
                this._subjoinLayer.top = 0;
                this._subjoinLayer.bottom = 0;
            };
            return (this._subjoinLayer);
        }
        public function get panelLayer():PanelLayer{
            if (!this._panelLayer){
                this._panelLayer = new PanelLayer();
                this._panelLayer.left = 0;
                this._panelLayer.right = 0;
                this._panelLayer.top = 0;
                this._panelLayer.bottom = 0;
            };
            return (this._panelLayer);
        }
        public function get videoDisplayArea():VideoDisplayArea{
            if (!this._videoDisplayArea){
                this._videoDisplayArea = new VideoDisplayArea();
                this._videoDisplayArea.left = 0;
                this._videoDisplayArea.right = 0;
                this._videoDisplayArea.top = 0;
                this._videoDisplayArea.bottom = 0;
                this._videoDisplayArea.controlID = ControlList.VIDEO_DISPLAY_AREA;
            };
            return (this._videoDisplayArea);
        }
        public function get displayer():DisplayObject{
            return (this.videoDisplayArea.displayer);
        }
        public function set displayer(_arg1:DisplayObject):void{
            this.videoDisplayArea.displayer = _arg1;
        }
        public function get normalTop():Number{
            return (this._normalTop);
        }
        public function set normalTop(_arg1:Number):void{
            this._normalTop = _arg1;
        }
        public function get normalLeft():Number{
            return (this._normalLeft);
        }
        public function set normalLeft(_arg1:Number):void{
            this._normalLeft = _arg1;
        }
        public function get normalRight():Number{
            return (this._normalRight);
        }
        public function set normalRight(_arg1:Number):void{
            this._normalRight = _arg1;
        }
        public function get normalBottom():Number{
            return (this._normalBottom);
        }
        public function set normalBottom(_arg1:Number):void{
            this._normalBottom = _arg1;
        }
        public function get fullScreenTop():Number{
            return (this._fullScreenTop);
        }
        public function set fullScreenTop(_arg1:Number):void{
            this._fullScreenTop = _arg1;
        }
        public function get fullScreenLeft():Number{
            return (this._fullScreenLeft);
        }
        public function set fullScreenLeft(_arg1:Number):void{
            this._fullScreenLeft = _arg1;
        }
        public function get fullScreenRight():Number{
            return (this._fullScreenRight);
        }
        public function set fullScreenRight(_arg1:Number):void{
            this._fullScreenRight = _arg1;
        }
        public function get fullScreenBottom():Number{
            return (this._fullScreenBottom);
        }
        public function set fullScreenBottom(_arg1:Number):void{
            this._fullScreenBottom = _arg1;
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.videoDisplayArea);
            this.addChild(this.subjoinLayer);
            this.addChild(this.recommendLayer);
            this.addChild(this.panelLayer);
        }

    }
}//package com.bokecc.player.ui 
