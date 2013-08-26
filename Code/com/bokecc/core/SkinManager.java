package com.bokecc.core {
    import flash.events.*;
    import flash.display.*;
    import flash.utils.*;
    import com.bokecc.vo.*;

    public class SkinManager extends EventDispatcher {

        public static const SKIN_CHANGE:String = "skinChange";
        public static const LAYOUT_CHANGE:String = "layoutChange";

        private static var instance:SkinManager;

        private var assets:Dictionary;
        private var classSkins:Dictionary;
        private var nameSkins:Dictionary;
        private var components:Dictionary;

        public function SkinManager(_arg1:Singleton){
            super(null);
            if (!this.assets){
                this.assets = new Dictionary();
            };
            if (!this.classSkins){
                this.classSkins = new Dictionary();
            };
            if (!this.nameSkins){
                this.nameSkins = new Dictionary();
            };
            if (!this.components){
                this.components = new Dictionary();
            };
        }
        public static function getInstance():SkinManager{
            if (instance == null){
                instance = new SkinManager(new Singleton());
            };
            return (instance);
        }

        public function loaderSkin(_arg1:Loader):void{
            var _local3:XMLList;
            var _local4:XMLList;
            var _local5:XMLList;
            var _local2:XML = _arg1.content["skinXML"];
            if (_local2){
                this.clean();
                _local3 = _local2.assets;
                this.analyzeAssets(_local3, _arg1);
                _local4 = _local2.skins;
                this.analyzeSkins(_local4);
                dispatchEvent(new Event(SKIN_CHANGE));
                _local5 = _local2.components;
                this.analyzeComponents(_local5);
                dispatchEvent(new Event(LAYOUT_CHANGE));
            };
        }
        private function analyzeAssets(_arg1:XMLList, _arg2:Loader):void{
            var _local3:XML;
            var _local4:XMLList;
            var _local5:XML;
            var _local6:Object;
            var _local7:AssetsVO;
            for each (_local3 in _arg1) {
                _local4 = _local3.asset;
                for each (_local5 in _local4) {
                    _local6 = this.xmlToObject(_local5);
                    if (_local6){
                        if (((_local6.hasOwnProperty(AssetsVO.ID)) && (_local6.hasOwnProperty(AssetsVO.SRC)))){
                            _local7 = new FlashAssets(_arg2.contentLoaderInfo.applicationDomain);
                            _local7.id = _local6[AssetsVO.ID];
                            _local7.src = _local6[AssetsVO.SRC];
                            if (_local6.hasOwnProperty(AssetsVO.TYPE)){
                                _local7.type = _local6[AssetsVO.TYPE];
                            };
                            if (_local6.hasOwnProperty(AssetsVO.SCALE9)){
                                _local7.scale9 = _local6[AssetsVO.SCALE9];
                            };
                            this.assets[_local7.id] = _local7;
                        };
                    };
                };
            };
        }
        private function analyzeSkins(_arg1:XMLList):void{
            var _local2:XML;
            var _local3:XMLList;
            var _local4:XML;
            var _local5:Object;
            var _local6:SkinVO;
            var _local7:Boolean;
            var _local8:XMLList;
            var _local9:XML;
            var _local10:Object;
            for each (_local2 in _arg1) {
                _local3 = _local2.skin;
                for each (_local4 in _local3) {
                    _local5 = this.xmlToObject(_local4);
                    if (_local5){
                        _local6 = new SkinVO();
                        _local7 = false;
                        if (_local5.hasOwnProperty(SkinVO.SKINNAME_FIELD)){
                            _local6.skinName = _local5[SkinVO.SKINNAME_FIELD];
                            _local6.className = _local5[SkinVO.CLASSNAME_FIELD];
                            this.nameSkins[_local6.skinName] = _local6;
                            _local7 = true;
                        } else {
                            if (_local5.hasOwnProperty(SkinVO.CLASSNAME_FIELD)){
                                _local6.className = _local5[SkinVO.CLASSNAME_FIELD];
                                this.classSkins[_local6.className] = _local6;
                                _local7 = true;
                            };
                        };
                        if (_local7){
                            _local8 = _local4.element;
                            for each (_local9 in _local8) {
                                _local10 = this.xmlToObject(_local9);
                                if (_local10){
                                    if (((_local10.hasOwnProperty(SkinVO.NAME_FIELD)) && (_local10.hasOwnProperty(SkinVO.SRC_FIELD)))){
                                        _local6.skins[_local10[SkinVO.NAME_FIELD]] = this.assets[_local10[SkinVO.SRC_FIELD]];
                                    };
                                };
                            };
                        };
                    };
                };
            };
        }
        private function analyzeComponents(_arg1:XMLList):void{
            var _local2:XML;
            var _local3:XMLList;
            var _local4:XML;
            var _local5:Object;
            var _local6:ComponentVO;
            var _local7:XMLList;
            var _local8:XML;
            var _local9:XMLList;
            var _local10:XML;
            var _local11:Object;
            var _local12:String;
            var _local13:String;
            var _local14:Object;
            for each (_local2 in _arg1) {
                _local3 = _local2.component;
                for each (_local4 in _local3) {
                    _local5 = this.xmlToObject(_local4);
                    if (_local5){
                        if (_local5.hasOwnProperty(ComponentVO.ID_FIELD)){
                            _local6 = new ComponentVO();
                            _local6[ComponentVO.ID_FIELD] = _local5[ComponentVO.ID_FIELD];
                            if (_local5.hasOwnProperty(ComponentVO.PARENT_FIELD)){
                                _local6.parent = _local5[ComponentVO.PARENT_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.HEIGHT_FIELD)){
                                _local6.height = _local5[ComponentVO.HEIGHT_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.WIDTH_FIELD)){
                                _local6.width = _local5[ComponentVO.WIDTH_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.LEFT_FIELD)){
                                _local6.left = _local5[ComponentVO.LEFT_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.RIGHT_FIELD)){
                                _local6.right = _local5[ComponentVO.RIGHT_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.TOP_FIELD)){
                                _local6.top = _local5[ComponentVO.TOP_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.BOTTOM_FIELD)){
                                _local6.bottom = _local5[ComponentVO.BOTTOM_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.HORIZONTAL_CENTER_FIELD)){
                                _local6.horizontalCenter = _local5[ComponentVO.HORIZONTAL_CENTER_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.VERTICAL_CENTER_FIELD)){
                                _local6.verticalCenter = _local5[ComponentVO.VERTICAL_CENTER_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.PERCENT_WIDTH_FIELD)){
                                _local6.percentWidth = _local5[ComponentVO.PERCENT_WIDTH_FIELD];
                            };
                            if (_local5.hasOwnProperty(ComponentVO.PERCENT_HEIGHT_FIELD)){
                                _local6.percentHeight = _local5[ComponentVO.PERCENT_HEIGHT_FIELD];
                            };
                            _local7 = _local4.property;
                            for each (_local8 in _local7) {
                                _local11 = this.xmlToObject(_local8);
                                if (_local11){
                                    if (((_local11.hasOwnProperty(ComponentVO.NAME_FIELD)) && (_local11.hasOwnProperty(ComponentVO.VALUE_FIELD)))){
                                        if (_local11.hasOwnProperty(ComponentVO.TYPE_FIELD)){
                                            _local12 = _local11[ComponentVO.TYPE_FIELD];
                                            _local13 = _local11[ComponentVO.VALUE_FIELD];
                                            switch (_local12){
                                                case "Boolean":
                                                    if ("false" == _local13){
                                                        _local6.property[_local11[ComponentVO.NAME_FIELD]] = false;
                                                    };
                                                    if ("true" == _local13){
                                                        _local6.property[_local11[ComponentVO.NAME_FIELD]] = true;
                                                    };
                                                    break;
                                                case "Number":
                                                    _local6.property[_local11[ComponentVO.NAME_FIELD]] = Number(_local13);
                                                    break;
                                                default:
                                                    _local6.property[_local11[ComponentVO.NAME_FIELD]] = _local13;
                                            };
                                        } else {
                                            _local6.property[_local11[ComponentVO.NAME_FIELD]] = _local11[ComponentVO.VALUE_FIELD];
                                        };
                                    };
                                };
                            };
                            _local9 = _local4.decorate;
                            for each (_local10 in _local9) {
                                _local14 = this.xmlToObject(_local10);
                                if (_local14){
                                    if (_local14.hasOwnProperty(AssetsVO.SRC)){
                                        _local6.decorates[_local14] = _local14;
                                    };
                                };
                            };
                            this.components[_local6.id] = _local6;
                        };
                    };
                };
            };
        }
        private function xmlToObject(_arg1:XML):Object{
            var _local3:Object;
            var _local4:int;
            var _local5:String;
            var _local6:String;
            var _local2:XMLList = _arg1.@*;
            if (_local2){
                _local3 = new Object();
                _local4 = 0;
                while (_local4 < _local2.length()) {
                    _local5 = _local2[_local4].name();
                    _local6 = _local2[_local4];
                    _local3[_local5] = _local6;
                    _local4++;
                };
                return (_local3);
            };
            return (null);
        }
        public function classNameBySkin(_arg1:String):SkinVO{
            return (this.classSkins[_arg1]);
        }
        public function skinNameBySkin(_arg1:String):SkinVO{
            return (this.nameSkins[_arg1]);
        }
        public function assetsByID(_arg1:String):AssetsVO{
            return (this.assets[_arg1]);
        }
        public function controlIdByComponentVO(_arg1:String):ComponentVO{
            return (this.components[_arg1]);
        }
        private function clean():void{
            this.assets = new Dictionary();
            this.classSkins = new Dictionary();
            this.nameSkins = new Dictionary();
            this.components = new Dictionary();
        }

    }
}//package com.bokecc.core 

class Singleton {

    public function Singleton(){
    }
}
