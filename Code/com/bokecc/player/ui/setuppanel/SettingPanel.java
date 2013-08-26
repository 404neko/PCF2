package com.bokecc.player.ui.setuppanel {
    import flash.events.*;
    import com.bokecc.controls.*;
    import com.bokecc.containers.layout.*;
    import com.bokecc.player.events.*;
    import com.bokecc.player.vo.*;
    import com.bokecc.containers.*;

    public class SettingPanel extends Panel {

        protected var _settingtab:SettingTab;

        public function SettingPanel(){
            this.title = "设置";
            this.titleAlign = Align.CENTER;
            this.width = 288;
            this.height = 215;
            this.headHeight = 38;
            this.addEventListener(Panel.CLOSED_EVENT, this.settingPanelOnClosed);
        }
        private function settingPanelOnClosed(_arg1:Event):void{
            this.settingtab.articulationCanvas.articulation = this.setUpPanelData.articulation;
        }
        override public function set x(_arg1:Number):void{
            super.x = Math.round(_arg1);
        }
        override public function set y(_arg1:Number):void{
            super.y = Math.round(_arg1);
        }
        override public function get head():Canvas{
            if (!_head){
                _head = new Canvas();
                _head.height = _headHeight;
            };
            return (_head);
        }
        public function get settingtab():SettingTab{
            if (!this._settingtab){
                this._settingtab = new SettingTab();
                this._settingtab.addEventListener("closed", this.settingtabOnClosed);
                this._settingtab.addEventListener(SetUpPanelDataEvent.LIGHTVALUE_CONTRASTVALUE_REST, this.settingtabOnLightvalueContrastvalueRest);
                this._settingtab.top = 0;
                this._settingtab.bottom = 0;
                this._settingtab.left = 0;
                this._settingtab.right = 0;
            };
            return (this._settingtab);
        }
        protected function settingtabOnLightvalueContrastvalueRest(_arg1:SetUpPanelDataEvent):void{
            dispatchEvent(_arg1.clone());
        }
        protected function settingtabOnClosed(_arg1:Event):void{
            dispatchEvent(_arg1.clone());
        }
        override protected function createChildren():void{
            super.createChildren();
            this.addChild(this.settingtab);
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
        public function get setUpPanelData():SetUpPanelVO{
            return (this.settingtab.setUpPanelData);
        }

    }
}//package com.bokecc.player.ui.setuppanel 
