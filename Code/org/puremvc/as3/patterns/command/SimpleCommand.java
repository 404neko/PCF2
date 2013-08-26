package org.puremvc.as3.patterns.command {
    import org.puremvc.as3.interfaces.*;
    import org.puremvc.as3.patterns.observer.*;

    public class SimpleCommand extends Notifier implements ICommand, INotifier {

        public function execute(_arg1:INotification):void{
        }

    }
}//package org.puremvc.as3.patterns.command 
