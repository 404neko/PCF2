package com.bokecc.containers {
    import com.bokecc.core.*;
    import com.bokecc.containers.layout.*;

    public class Canvas extends Container {

        public function Canvas(){
            this.layout = new CanvasLayout(this);
        }
    }
}//package com.bokecc.containers 
