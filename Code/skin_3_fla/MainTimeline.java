package skin_3_fla {
    import flash.display.*;
    import flash.system.*;

    public dynamic class MainTimeline extends MovieClip {

        public var skinXML:XML;

        public function MainTimeline(){
            addFrameScript(0, this.frame1);
        }
        function frame1(){
            Security.allowDomain("*");
            this.skinXML = <skinpackage>
	<assets>
		<asset id="0" type="symbol" src="BigPlayNormalSkin"/>
		<asset id="1" type="symbol" src="BigPlayUpSkin"/>
		
		<asset id="2" type="symbol" src="ControlBar"/>
		
		<asset id="3" type="symbol" src="AugmentBtnNormalSkin"/>
		
		<asset id="4" type="symbol" src="DecreaseNormalSkin"/>
		
		<asset id="5" type="symbol" src="FullScreenBtnNormalSkin"/>
		
		
		<asset id="6" type="symbol" src="PlayBtnNormalSkin"/>
		<asset id="7" type="symbol" src="PauseBtnNormalSkin"/>
		
		<asset id="8" type="symbol" src="BarBgSkin"/>
		<asset id="9" type="symbol" src="PlayBarBtn"/>
		<asset id="10" type="symbol" src="ProPlayBarSkin"/>
		<asset id="11" type="symbol" src="BarLoadeSkin"/>
	
		<asset id="12" type="symbol" src="VolBtnNormalSkin"/>
		
		<asset id="13" type="symbol" src="ControCirBtnSkin"/>
		<asset id="14" type="symbol" src="VolBigBgSkin"/>
		<asset id="15" type="symbol" src="VolSliderBgSkin"/>
		
		<!--<asset id="16" type="symbol" src="TimeTip" />-->
		
		<asset id="settingPanel_1" type="symbol" src="TextButtonUpSkin"/>
		<asset id="settingPanel_2" type="symbol" src="TextButtonOverSkin"/>
		
		<asset id="settingPanel_3" type="symbol" src="RadioButtonUpSkin"/>
		<asset id="settingPanel_4" type="symbol" src="RadioButtonSelectUpSkin"/>
		<asset id="settingPanel_5" type="symbol" src="RadioButtonSelectOverSkin"/>
		<asset id="settingPanel_6" type="symbol" src="RadioButtonOverSkin"/>
		
		<asset id="settingPanel_7" type="symbol" src="SliderTrackSkin"/>
		<asset id="settingPanel_8" type="symbol" src="SliderThumbUpSkin"/>
		<asset id="settingPanel_9" type="symbol" src="SliderHighlightSkin"/>
		
		<asset id="settingPanel_10" type="symbol" src="PanelBackground"/>
		
		<asset id="settingPanel_11" type="symbol" src="CloseButtonUpSkin"/>
		<asset id="settingPanel_12" type="symbol" src="CloseButtonOverSkin"/>
		
		<asset id="settingPanel_13" type="symbol" src="Tab_upSkin"/>
		<asset id="settingPanel_14" type="symbol" src="TabSelected_upSkin"/>
		
		<asset id="settingPanel_15" type="symbol" src="Head_Background"/>
		
		<asset id="settingPanel_16" type="symbol" src="sinaminiblog"/>
		<asset id="settingPanel_17" type="symbol" src="renren"/>
		<asset id="settingPanel_18" type="symbol" src="qzone"/>
		<asset id="settingPanel_19" type="symbol" src="qqmb"/>
		<asset id="settingPanel_20" type="symbol" src="kaixin001"/>
		
		<asset id="settingPanel_21" type="symbol" src="RunOutNavigatorBackground"/>
		
		<asset id="settingPanel_22" type="symbol" src="RunOutNavigator_backButtonUP"/>
		<asset id="settingPanel_23" type="symbol" src="RunOutNavigator_nextButtonUP"/>
		
		<asset id="settingPanel_24" type="symbol" src="RunOutNavigator_tabButtonUp"/>
		<asset id="settingPanel_25" type="symbol" src="RunOutNavigator_tabButtonSelectUp"/>
		
		
		
		<asset id="setUpMenu_Up1" type="symbol" src="setUpMenuIcon1UpSkin"/>
		<asset id="setUpMenu_Up2" type="symbol" src="setUpMenuIcon2UpSkin"/>
		<asset id="setUpMenu_Up3" type="symbol" src="setUpMenuIcon3UpSkin"/>
		<asset id="setUpMenu_Up4" type="symbol" src="setUpMenuIcon4UpSkin"/>
		<asset id="setUpMenu_Up5" type="symbol" src="setUpMenuIcon5UpSkin"/>
		<asset id="setUpMenu_Up6" type="symbol" src="setUpMenuIcon6UpSkin"/>
		<asset id="setUpMenu_Up7" type="symbol" src="setUpMenuIcon7UpSkin"/>
		<asset id="setUpMenu_Up8" type="symbol" src="setUpMenuIcon8UpSkin"/>
		<asset id="setUpMenu_Up9" type="symbol" src="setUpMenuIcon9UpSkin"/>
		<asset id="setUpMenu_Up10" type="symbol" src="setUpMenuIcon10UpSkin"/>
		<asset id="setUpMenu_Up11" type="symbol" src="setUpMenuIcon11UpSkin"/>
		
		<asset id="setUpMenu_SelectedUP1" type="symbol" src="setUpMenuIcon1OverSkin"/>
		<asset id="setUpMenu_SelectedUP2" type="symbol" src="setUpMenuIcon2OverSkin"/>
		<asset id="setUpMenu_SelectedUP3" type="symbol" src="setUpMenuIcon3OverSkin"/>
		<asset id="setUpMenu_SelectedUP4" type="symbol" src="setUpMenuIcon4OverSkin"/>
		<asset id="setUpMenu_SelectedUP5" type="symbol" src="setUpMenuIcon5OverSkin"/>
		<asset id="setUpMenu_SelectedUP6" type="symbol" src="setUpMenuIcon6OverSkin"/>
		<asset id="setUpMenu_SelectedUP7" type="symbol" src="setUpMenuIcon7OverSkin"/>
		<asset id="setUpMenu_SelectedUP8" type="symbol" src="setUpMenuIcon8OverSkin"/>
		<asset id="setUpMenu_SelectedUP9" type="symbol" src="setUpMenuIcon9OverSkin"/>
		<asset id="setUpMenu_SelectedUP10" type="symbol" src="setUpMenuIcon10OverSkin"/>
		<asset id="setUpMenu_SelectedUP11" type="symbol" src="setUpMenuIcon11OverSkin"/>
		
		<asset id="setUpMenu_Background" type="symbol" src="setUpMenuBackground"/>
		
		<asset id="playList_0" type="symbol" src="VPlayerListBackground"/>
		<asset id="playList_1" type="symbol" src="vPlayerListControlButtonBox"/>
		<asset id="playList_2" type="symbol" src="vPlayerListScrollBar"/>
		<asset id="playList_3" type="symbol" src="vScrollBarThumbButton"/>
		<asset id="playList_5" type="symbol" src="playerListNextButtonUpSkin"/>
		<asset id="playList_6" type="symbol" src="playerListPreviousButtonUpSkin"/>
		<asset id="playList_7" type="symbol" src="vPlayerListContractionButtonSelectUpSkin"/>
		<asset id="playList_8" type="symbol" src="vPlayerListContractionButtonUpSkin"/>
		
		<asset id="playList_9" type="symbol" src="HPlayerListBackground"/>
		<asset id="playList_10" type="symbol" src="hScrollBarThumbButton"/>
		<asset id="playList_11" type="symbol" src="hPlayerListScrollBar"/>
		
		<asset id="playList_12" type="symbol" src="hPlayerListContractionButtonSelectUpSkin"/>
		<asset id="playList_13" type="symbol" src="hPlayerListContractionButtonUpSkin"/>
		<asset id="playList_14" type="symbol" src="playerModeListItemIcon"/>
		
		
		<asset id="playList_15" type="symbol" src="singleModeUpSkin"/>
		<asset id="playList_16" type="symbol" src="singleModeOverSkin"/>
		
		<asset id="playList_17" type="symbol" src="sequenceModeUpSkin"/>
		<asset id="playList_18" type="symbol" src="sequenceModeOverSkin"/>
		
		<asset id="playList_23" type="symbol" src="randomModeUpSkin"/>
		<asset id="playList_24" type="symbol" src="randomModeOverSkin"/>
		
		<asset id="playList_25" type="symbol" src="loopModeUpSkin"/>
		<asset id="playList_26" type="symbol" src="loopModeOverSkin"/>
		
		<asset id="playList_20" type="symbol" src="playerListPreviousButtonOverSkin"/>
		
		<asset id="playList_22" type="symbol" src="playerListNextButtonOverSkin"/>
		
		<asset id="loaderSpinner0" type="symbol" src="loaderSpinner_spinner"/>
		<asset id="loaderSpinner1" type="symbol" src="loaderSpinner_background"/>
		
		<asset id="recoverMessageBox1" type="symbol" src="recoverMessageBoxIcon"/>
		<asset id="recoverMessageBox2" type="symbol" src="RecoverMessageBoxBackground"/>
		
		<asset id="Mini_ControlBar2" type="symbol" src="Mini_ControlBar"/>
		
		<asset id="Mini_ControlBar3" type="symbol" src="Mini_AugmentBtnNormalSkin"/>
		<asset id="Mini_ControlBar4" type="symbol" src="Mini_AugmentBtnOverSkin"/>
		
		<asset id="Mini_ControlBar5" type="symbol" src="Mini_DecreaseNormalSkin"/>
		<asset id="Mini_ControlBar6" type="symbol" src="Mini_DecreaseOverSkin"/>
		
		
		<asset id="Mini_ControlBar7" type="symbol" src="Mini_PlayBtnNormalSkin"/>
		<asset id="Mini_ControlBar8" type="symbol" src="Mini_PlayBtnOverSkin"/>
		<asset id="Mini_ControlBar9" type="symbol" src="Mini_PauseBtnNormalSkin"/>
		<asset id="Mini_ControlBar10" type="symbol" src="Mini_PauseBtnOverSkin"/>
		
		<asset id="Mini_ControlBar11" type="symbol" src="Mini_BarBgSkin"/>
		<asset id="Mini_ControlBar12" type="symbol" src="Mini_ControCirBtnSkin"/>
		<asset id="Mini_ControlBar13" type="symbol" src="Mini_ProPlayBarSkin"/>
		<asset id="Mini_ControlBar14" type="symbol" src="Mini_BarLoadeSkin"/>
	
		<asset id="Mini_ControlBar15" type="symbol" src="Mini_VolFullBtnNormalSkin"/>
		<asset id="Mini_ControlBar16" type="symbol" src="Mini_VolFullBtnOverSkin"/>		
		<asset id="Mini_ControlBar17" type="symbol" src="Mini_VolZeroBtnNormalSkin"/>
		<asset id="Mini_ControlBar18" type="symbol" src="Mini_VolZeroBtnOverSkin"/>
		
		<asset id="Mini_ControlBar19" type="symbol" src="Mini_VolSliderFrontSkin"/>
		<asset id="Mini_ControlBar20" type="symbol" src="Mini_VolSliderBgSkin"/>
		<asset id="Mini_ControlBar21" type="symbol" src="Mini_VolBigBgSkin"/>
		<asset id="Mini_ControlBar22" type="symbol" src="Mini_VolControBtnSkin"/>
	
	
	
		<asset id="SafeguardMode0" type="symbol" src="SafeguardModeButtonUpSKin"/>
		<asset id="SafeguardMode1" type="symbol" src="SafeguardModeButtonOverSKin"/>
		
		
		<asset id="markskin0" type="symbol" src="MarkTooltip_Background"/>
		<asset id="markskin1" type="symbol" src="MarkTooltip_Consort"/>
	</assets>

	<skins>
		<skin skinName="basePlayButtonSkin">
			<element name="upSkin" src="0"/>
			<element name="overSkin" src="1"/>
		</skin>
		
		<skin skinName="controlBarSkin">
			<element name="background" src="2"/>
		</skin>
		
		<skin skinName="augmentButtonSkin">
			<element name="upSkin" src="3"/>
		</skin>
		
		<skin skinName="decreaseButtonSkin">
			<element name="upSkin" src="4"/>
		</skin>
		
		<skin skinName="fullScreenButtonSkin">
			<element name="upSkin" src="5"/>
		</skin>
		
		<skin skinName="playButtonSkin">
			<element name="upSkin" src="6"/>
			<element name="selectedUPSkin" src="7"/>
		</skin>
		
		<skin skinName="progressControlBarSkin">
			<element name="trackSkin" src="8"/>
			<element name="thumbUpSkin" src="9"/>
			<element name="highlightSkin" src="10"/>
			<element name="loaderProgressSkin" src="11"/>
		</skin>
		
		<skin skinName="volumeButtonSkin">
			<element name="upSkin" src="12"/>
		</skin>
		
		<skin skinName="volumeSliderSkin">
			<element name="trackSkin" src="14"/>
			<element name="thumbUpSkin" src="13"/>
			<element name="highlightSkin" src="15"/>
		</skin>
		
		<skin className="UIToolTip">
			<element name="background" src="markskin0"/>
		</skin>
		
		<skin className="TextButton">
			<element name="upSkin" src="settingPanel_1"/>
			<element name="overSkin" src="settingPanel_2"/>
		</skin>
		
		<skin className="RadioButton">
			<element name="upSkin" src="settingPanel_3"/>
			<element name="overSkin" src="settingPanel_6"/>
			<element name="selectedUPSkin" src="settingPanel_4"/>
			<element name="selectedOverSkin" src="settingPanel_5"/>
		</skin>
		
		<skin skinName="lightSliderSkin">
			<element name="trackSkin" src="settingPanel_7"/>
			<element name="highlightSkin" src="settingPanel_9"/>
			<element name="thumbUpSkin" src="settingPanel_8"/>
		</skin>
		
		<skin skinName="contrastSliderSkin">
			<element name="trackSkin" src="settingPanel_7"/>
			<element name="highlightSkin" src="settingPanel_9"/>
			<element name="thumbUpSkin" src="settingPanel_8"/>
		</skin>
		
		<skin className="SettingPanel">
			<element name="background" src="settingPanel_10"/>
		</skin>
		
		<skin className="SharePanel">
			<element name="background" src="settingPanel_10"/>
		</skin>
		
		<skin className="DownloaderPanel">
			<element name="background" src="settingPanel_10"/>
		</skin>
		<skin className="Alert">
			<element name="background" src="settingPanel_10"/>
		</skin>
		
		<skin skinName="controlBarBasePlayButtonSkin">
			<element name="upSkin" src="0"/>
			<element name="overSkin" src="1"/>
		</skin>

		<skin className="ArticulationPanel">
			<element name="background" src="settingPanel_10"/>
		</skin>
		<skin className="LuminancePanel">
			<element name="background" src="settingPanel_10"/>
		</skin>
		<skin className="VideoScalePanel">
			<element name="background" src="settingPanel_10"/>
		</skin>
		
		<skin className="CustomPanel">
			<element name="background" src="settingPanel_10"/>
		</skin>
		
		<skin className="ReportPanel">
			<element name="background" src="settingPanel_10"/>
		</skin>
		
		<skin skinName="panelHead">
			<element name="background" src="settingPanel_15"/>
		</skin>
		
		<skin skinName="panelClosedButton">
			<element name="upSkin" src="settingPanel_11"/>
			<element name="overSkin" src="settingPanel_12"/>
		</skin>
		
		
		<skin skinName="recoverMessageBoxCloseButton">
			<element name="upSkin" src="settingPanel_11"/>
			<element name="overSkin" src="settingPanel_12"/>
		</skin>
		
		
		<skin skinName="tabButton" className="TextButton">
			<element name="upSkin" src="settingPanel_13"/>
			<element name="selectedUPSkin" src="settingPanel_14"/>
		</skin>
		
		
		<skin skinName="sinaminiblog">
			<element name="upSkin" src="settingPanel_16"/>
		</skin>
		
		<skin skinName="kaixin001">
			<element name="upSkin" src="settingPanel_20"/>
		</skin>
		
		<skin skinName="qzone">
			<element name="upSkin" src="settingPanel_18"/>
		</skin>
		
		<skin skinName="qqmb">
			<element name="upSkin" src="settingPanel_19"/>
		</skin>
		
		<skin skinName="renren">
			<element name="upSkin" src="settingPanel_17"/>
		</skin>
		
		<skin skinName="nominateListSkin">
			<element name="background" src="settingPanel_21"/>
		</skin>
		
		<skin skinName="shareCanvasSkin">
			<element name="background" src="settingPanel_21"/>
		</skin>
		
		<skin skinName="RunOutNavigator_nextButton">
			<element name="upSkin" src="settingPanel_23"/>
		</skin>
		
		<skin skinName="RunOutNavigator_backButton">
			<element name="upSkin" src="settingPanel_22"/>
		</skin>
		
		<skin skinName="RunOutNavigator_tabButton">
			<element name="upSkin" src="settingPanel_24"/>
			<element name="selectedUPSkin" src="settingPanel_25"/>
		</skin>
		
		<skin skinName="setUpMenuIcon1Skin">
			<element name="upSkin" src="setUpMenu_Up1"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP1"/>
		</skin>
		
		<skin skinName="setUpMenuIcon2Skin">
			<element name="upSkin" src="setUpMenu_Up2"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP2"/>
		</skin>
		
		<skin skinName="setUpMenuIcon3Skin">
			<element name="upSkin" src="setUpMenu_Up3"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP3"/>
		</skin>
		
		<skin skinName="setUpMenuIcon4Skin">
			<element name="upSkin" src="setUpMenu_Up4"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP4"/>
		</skin>
		
		<skin skinName="setUpMenuIcon5Skin">
			<element name="upSkin" src="setUpMenu_Up5"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP5"/>
		</skin>
		
		<skin skinName="setUpMenuIcon6Skin">
			<element name="upSkin" src="setUpMenu_Up6"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP6"/>
		</skin>
		
		<skin skinName="setUpMenuIcon7Skin">
			<element name="upSkin" src="setUpMenu_Up7"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP7"/>
		</skin>
		
		<skin skinName="setUpMenuIcon8Skin">
			<element name="upSkin" src="setUpMenu_Up8"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP8"/>
		</skin>
		
		<skin skinName="setUpMenuIcon9Skin">
			<element name="upSkin" src="setUpMenu_Up9"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP9"/>
		</skin>
		
		<skin skinName="setUpMenuIcon10Skin">
			<element name="upSkin" src="setUpMenu_Up10"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP10"/>
		</skin>
		
		<skin skinName="setUpMenuIcon11Skin">
			<element name="upSkin" src="setUpMenu_Up11"/>
			<element name="selectedUPSkin" src="setUpMenu_SelectedUP11"/>
		</skin>
		
		<skin skinName="setupMenuSkin">
			<element name="background" src="setUpMenu_Background"/>
		</skin>
		
		
		<skin skinName="single">
			<element name="upSkin" src="playList_15"/>
			<element name="overSkin" src="playList_16"/>
		</skin>
		
		<skin skinName="sequence">
			<element name="upSkin" src="playList_17"/>
			<element name="overSkin" src="playList_18"/>
		</skin>
		
		<skin skinName="random">
			<element name="upSkin" src="playList_23"/>
			<element name="overSkin" src="playList_24"/>
		</skin>
		
		<skin skinName="loop">
			<element name="upSkin" src="playList_25"/>
			<element name="overSkin" src="playList_26"/>
		</skin>
	
		<skin className="HScrollBar">
			<element name="background" src="playList_11"/>
		</skin>
		
		<skin skinName="hScrollBarThumbButton">
			<element name="upSkin" src="playList_10"/>
		</skin>
	
		<skin skinName="tPlayerListContractionButton">
			<element name="upSkin" src="playList_13"/>
			<element name="selectedUPSkin" src="playList_12"/>
		</skin>
		
		<skin skinName="bPlayerListContractionButton">
			<element name="upSkin" src="playList_12"/>
			<element name="selectedUPSkin" src="playList_13"/>
		</skin>
	
		<skin className="VScrollBar">
			<element name="background" src="playList_2"/>
		</skin>
		
		<skin skinName="vScrollBarThumbButton">
			<element name="upSkin" src="playList_3"/>
		</skin>
	
		
		<skin skinName="leftPlayerList">
			<element name="background" src="playList_0"/>
		</skin>
		
		<skin skinName="rightPlayerList">
			<element name="background" src="playList_0"/>
		</skin>
		
		<skin skinName="topPlayerList">
			<element name="background" src="playList_9"/>
		</skin>
		
		<skin skinName="bottomPlayerList">
			<element name="background" src="playList_9"/>
		</skin>
	
		<skin skinName="vPlayerListControlButtonBox">
			<element name="background" src="playList_1"/>
		</skin>
	
	
		
		<skin skinName="playerListNextButton">
			<element name="upSkin" src="playList_5"/>
			<element name="overSkin" src="playList_22"/>
		</skin>
		
		<skin skinName="playerListPreviousButton">
			<element name="upSkin" src="playList_6"/>
			<element name="overSkin" src="playList_20"/>
		</skin>
	
		<skin skinName="rPlayerListContractionButton">
			<element name="upSkin" src="playList_8"/>
			<element name="selectedUPSkin" src="playList_7"/>
		</skin>
		
		<skin skinName="lPlayerListContractionButton">
			<element name="upSkin" src="playList_7"/>
			<element name="selectedUPSkin" src="playList_8"/>
		</skin>
		
		<skin skinName="PlayerModeListItemIcon">
			<element name="upSkin" src="playList_14"/>
		</skin>
		
		
		<skin skinName="loaderSpinner_spinner">
			<element name="background" src="loaderSpinner0"/>
		</skin>
		
		<skin skinName="loaderSpinner_background">
			<element name="background" src="loaderSpinner1"/>
		</skin>
		
		<skin skinName="recoverMessageBoxIcon">
			<element name="upSkin" src="recoverMessageBox1"/>
		</skin>
		
		<skin className="RecoverMessageBox">
			<element name="background" src="recoverMessageBox2"/>
		</skin>
		
		<skin skinName="mini_controlBarSkin">
			<element name="background" src="Mini_ControlBar2"/>
		</skin>
		
		<skin skinName="mini_augmentButtonSkin">
			<element name="upSkin" src="Mini_ControlBar3"/>
			<element name="downSkin" src="Mini_ControlBar4"/>
			<element name="overSkin" src="Mini_ControlBar4"/>
		</skin>
		
		<skin skinName="mini_decreaseButtonSkin">
			<element name="upSkin" src="Mini_ControlBar5"/>
			<element name="downSkin" src="Mini_ControlBar6"/>
			<element name="overSkin" src="Mini_ControlBar6"/>
		</skin>
		
		<skin skinName="mini_playButtonSkin">
			<element name="upSkin" src="Mini_ControlBar7"/>
			<element name="overSkin" src="Mini_ControlBar8"/>
			<element name="downSkin" src="Mini_ControlBar8"/>
			<element name="selectedDownSkin" src="Mini_ControlBar10"/>
			<element name="selectedUPSkin" src="Mini_ControlBar9"/>
			<element name="selectedOverSkin" src="Mini_ControlBar10"/>
		</skin>
		
		<skin skinName="mini_progressControlBarSkin">
			<element name="trackSkin" src="Mini_ControlBar11"/>
			<element name="thumbUpSkin" src="Mini_ControlBar12"/>
			<element name="highlightSkin" src="Mini_ControlBar13"/>
			<element name="loaderProgressSkin" src="Mini_ControlBar14"/>
		</skin>
		
		<skin skinName="mini_volumeButtonSkin">
			<element name="upSkin" src="Mini_ControlBar15"/>
			<element name="overSkin" src="Mini_ControlBar16"/>
			<element name="downSkin" src="Mini_ControlBar16"/>
			<element name="selectedDownSkin" src="Mini_ControlBar18"/>
			<element name="selectedUPSkin" src="Mini_ControlBar17"/>
			<element name="selectedOverSkin" src="Mini_ControlBar18"/>
		</skin>
		
		<skin skinName="mini_volumeSliderSkin">
			<element name="trackSkin" src="Mini_ControlBar20"/>
			<element name="thumbUpSkin" src="Mini_ControlBar22"/>
			<element name="highlightSkin" src="Mini_ControlBar19"/>
		</skin>
		
		<skin skinName="mini_volumeSliderCanvasSkin">
			<element name="background" src="Mini_ControlBar21"/>
		</skin>
		
		
		<skin skinName="safeguardModeButton">
			<element name="upSkin" src="SafeguardMode0"/>
			<element name="downSkin" src="SafeguardMode1"/>
			<element name="overSkin" src="SafeguardMode1"/>
		</skin>
		
		
		<skin className="MarkTooltip">
			<element name="background" src="markskin0"/>
			<element name="consortSkin" src="markskin1"/>
		</skin>
	</skins>

	<components>
	
	<component id="player" left="0" right="0" bottom="0" top="0">
			<property name="autoHidenControlBar" value="true" type="Boolean"/>
			<property name="autoHidenSetupMenu" value="false" type="Boolean"/>
			<property name="showMiniWidth" value="310" type="Number"/>
			<property name="showMiniHeight" value="280" type="Number"/>
			<property name="hidenControlBarEffect" value="move"/>
			<property name="pointAlign" value="center"/>
		</component>
		<component id="controlBarBasePlayButton" left="10" bottom="43"></component>
		<component id="basePlayButton" horizontalCenter="0" verticalCenter="0"></component>
		<component id="controlBar" height="38" left="0" right="0" bottom="0">
			<property name="autoHidenVolumeSlider" value="false" type="Boolean"/>
		</component>
		
		<component id="decreaseButton" left="4" bottom="4"></component>
		<component id="augmentButton" left="60" bottom="4"></component>
		
		<component id="fullScreenButton" right="7" bottom="4"></component>
		<component id="volumeButton" right="115.5" bottom="4"></component>
		
		<component id="volumeSliderCanvas" right="35" height="14" width="80" bottom="8"></component>
		
		<component id="volumeSlider" height="4" width="70" horizontalCenter="0" verticalCenter="0">
		    <property name="vertical" value="false" type="Boolean"/>
		</component>
		
		 <component id="playButton" left="32.5" bottom="3.5"></component>
		<component id="progressControlBar" height="5" left="0" right="0" top="0"></component>
		<component id="timeLabel" verticalCenter="0" right="45"></component>
		
		<component id="playTimeLabel" right="192" width="50" bottom="5">
			<property name="color" value="0xFFFFFF" type="Number"/>
			<property name="align" value="right"/>
			<property name="fontSize" value="11" type="Number"/>
			<property name="wordWrap" value="true" type="Boolean"/>
		</component>
		<component id="playTotalGapLabel" right="187" bottom="5">
		
		<property name="color" value="0xFFFFFF" type="Number"/>
		<property name="fontSize" value="11" type="Number"/>
		<property name="text" value="/"/>
		</component>
		<component id="totalTimeLabel" right="138" width="50" bottom="5">
		<property name="fontSize" value="11" type="Number"/>
		<property name="color" value="0xFFFFFF" type="Number"/>
		</component>
		
		<component id="loaderSpinner_spinner" height="45.2" width="43.4"/>
		<component id="loaderSpinner_background" height="52" width="52"/>

	
		<component id="loaderSpinner" height="26" width="26" verticalCenter="13" horizontalCenter="13">
			<property name="textShadowColor" value="0xFFFFFF" type="Number"/>
		</component>
		
		<component id="loaderSpinner_label" verticalCenter="-13" horizontalCenter="-13">
			<property name="color" value="0xFFFFFF" type="Number"/>
		</component>
		
		
		<component id="miniBasePlayButton" horizontalCenter="0" verticalCenter="0"></component>
		<component id="miniControlBar" height="12" width="500" left="0" right="0" bottom="0">
			<property name="autoHidenVolumeSlider" value="true" type="Boolean"/>
		</component>
		
		<component id="miniDecreaseButton" left="15" verticalCenter="0"></component>
		<component id="miniAugmentButton" right="88" verticalCenter="0"></component>
		
		<component id="miniVolumeButton" right="5" verticalCenter="0"></component>
		
		<component id="miniVolumeSliderCanvas" bottom="12" right="6" height="40" width="10"></component>
		
		<component id="miniVolumeSlider" height="34" width="1.75" verticalCenter="0" horizontalCenter="0">
			 <property name="vertical" value="true" type="Boolean"/>
		</component>
		
		 <component id="miniPlayButton" left="0" verticalCenter="0"></component>
		<component id="miniProgressControlBar" left="30" right="102" verticalCenter="0" height="1.7" width="380"></component>
		<component id="miniPlayTimeLabel" right="52" width="50" verticalCenter="0">
		<property name="color" value="0xFFFFFF" type="Number"/>
		<property name="align" value="right"/>
		<property name="fontSize" value="10" type="Number"/>
		<property name="wordWrap" value="true" type="Boolean"/>
		</component>
		<component id="miniPlayTotalGapLabel" right="50" verticalCenter="0">
		<property name="color" value="0xFFFFFF" type="Number"/>
		<property name="fontSize" value="10" type="Number"/>
		<property name="text" value="/"/>
		</component>
		<component id="miniTotalTimeLabel" right="2" width="50" verticalCenter="0">
		<property name="fontSize" value="10" type="Number"/>
		<property name="color" value="0xFFFFFF" type="Number"/>
		</component>
		</components>

</skinpackage>
            ;
        }

    }
}//package skin_3_fla 
