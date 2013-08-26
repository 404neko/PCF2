package com.bokecc.lib.utils {
    import flash.events.*;
    import flash.display.*;
    import flash.ui.*;

    public class ContextMenuUtil {

        private var _cm:ContextMenu;

        public function ContextMenuUtil(_arg1:DisplayObjectContainer, _arg2:Boolean=false, _arg3:Boolean=false){
            if (((_arg2) || ((_arg1.contextMenu == null)))){
                this._cm = new ContextMenu();
            } else {
                this._cm = (_arg1.contextMenu as ContextMenu);
            };
            if (_arg3){
                this.hideBuiltIn();
            };
            _arg1.contextMenu = this._cm;
        }
        public function hideBuiltIn():void{
            this._cm.hideBuiltInItems();
        }
        public function addItem(_arg1:String, _arg2:Boolean=true, _arg3:Function=null, _arg4:Boolean=false, _arg5:Boolean=true, _arg6:Boolean=false):ContextMenuItem{
            var caption:* = _arg1;
            var enabled:Boolean = _arg2;
            var callback = _arg3;
            var separatorBefore:Boolean = _arg4;
            var visible:Boolean = _arg5;
            var unshift:Boolean = _arg6;
            var item:* = new ContextMenuItem(caption, separatorBefore, enabled, visible);
            if (callback != null){
                item.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, function (_arg1:ContextMenuEvent):void{
                    callback();
                });
            };
            if (unshift){
                this._cm.customItems.unshift(item);
            } else {
                this._cm.customItems.push(item);
            };
            return (item);
        }
        public function getItem(_arg1:uint):ContextMenuItem{
            return (this._cm.customItems[_arg1]);
        }
        public function removeItem(_arg1:ContextMenuItem):void{
            var _local2:int = this._cm.customItems.indexOf(_arg1);
            if (_local2 >= 0){
                this._cm.customItems.splice(_local2, 1);
            };
        }

    }
}//package com.bokecc.lib.utils 
