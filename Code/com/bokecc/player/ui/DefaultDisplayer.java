package com.bokecc.player.ui {
    import com.bokecc.core.*;
    import flash.display.*;

    public class DefaultDisplayer extends Component {

        override public function updateDisplayList():void{
            super.updateDisplayList();
            var _local1:Graphics = this.graphics;
            _local1.clear();
            _local1.beginFill(0);
            _local1.drawRect(0, 0, this.width, this.height);
            _local1.endFill();
        }

    }
}//package com.bokecc.player.ui 
