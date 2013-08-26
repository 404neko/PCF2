﻿package com.bokecc.player.ui.playerlist {
    import com.bokecc.controls.*;
    import com.bokecc.containers.*;

    public class RightPlayerList extends VPlayerList {

        override public function get contractionButton():BaseButton{
            var _local1:BaseButton = super.contractionButton;
            _local1.skinName = "rPlayerListContractionButton";
            _local1.verticalCenter = 0;
            _local1.left = 0;
            return (_local1);
        }
        override public function get viewPort():Canvas{
            var _local1:Canvas = super.viewPort;
            _local1.right = 21;
            return (_local1);
        }
        override public function get playerModeList():PlayerModeList{
            var _local1:PlayerModeList = super.playerModeList;
            _local1.bottom = 37;
            _local1.right = 2;
            return (_local1);
        }

    }
}//package com.bokecc.player.ui.playerlist 
