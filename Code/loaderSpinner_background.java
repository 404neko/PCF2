package {
    import flash.display.*;
    import flash.system.*;

    public dynamic class loaderSpinner_background extends MovieClip {

        public var skinXML:XML;

        public function loaderSpinner_background(){
            addFrameScript(0, this.frame1);
        }
        function frame1(){
            Security.allowDomain("*");
            this.skinXML = <skinpackage>
	<assets>
		<asset id="loaderSpinner0" type="symbol" src="loaderSpinner_spinner"/>
		<asset id="loaderSpinner1" type="symbol" src="loaderSpinner_background"/>
	</assets>

	<skins>
		
		<skin skinName="loaderSpinner_spinner">
			<element name="background" src="loaderSpinner0"/>
		</skin>
		
		<skin skinName="loaderSpinner_background">
			<element name="background" src="loaderSpinner0"/>
		</skin>
		
	</skins>

	<components>
	
		<component id="loaderSpinner_spinner" left="0" right="0" bottom="0" top="0">
			<property name="autoHidenControlBar" value="true" type="Boolean"/>
			<property name="autoHidenSetupMenu" value="false" type="Boolean"/>
		</component>
		
		<component id="loaderSpinner_label" left="0" right="0" bottom="0" top="0"/>
		
		<component id="loaderSpinner_background" left="0" right="0" bottom="0" top="0"/>
		
	</components>

</skinpackage>
            ;
        }

    }
}//package 
