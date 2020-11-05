<?xml version="1.0"?>
<!--
	FP
	
	Copyright 2019-2020 MicroEJ Corp. All rights reserved.
	Use of this source code is governed by a BSD-style license that can be found with this software.
-->
<frontpanel 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="https://developer.microej.com" 
	xsi:schemaLocation="https://developer.microej.com .widget.xsd">
	
	<device name="doublepress" skin="board.png">		
		<ej.fp.widget.Display x="67" y="79" width="480" height="272" initialColor="0x717d83"/>
		<ej.fp.widget.Button label="1" x="66" y="372" skin="button_off.png" pushedSkin="button_on.png" listenerClass="ej.fp.widget.Button1" filter="button_activ-zone_button.png"/>
		<ej.fp.widget.Button label="2" x="166" y="372" skin="button_off.png" pushedSkin="button_on.png" listenerClass="ej.fp.widget.Button2" filter="button_activ-zone_button.png"/>
		<ej.fp.widget.Button label="3" x="366" y="372" skin="button_off.png" pushedSkin="button_on.png" listenerClass="ej.fp.widget.Button3" filter="button_activ-zone_button.png"/>
		<ej.fp.widget.Button label="4" x="466" y="372" skin="button_off.png" pushedSkin="button_on.png" listenerClass="ej.fp.widget.Button4" filter="button_activ-zone_button.png"/>
		<ej.fp.widget.Button label="5" x="91" y="420" skin="double-button_off.png" pushedSkin="double-button_on.png" listenerClass="ej.fp.widget.VirtualLeftButton" filter="double-button_activ-zone_button.png"/>
		<ej.fp.widget.Button label="6" x="391" y="420" skin="double-button_off.png" pushedSkin="double-button_on.png" listenerClass="ej.fp.widget.VirtualRightButton" filter="double-button_activ-zone_button.png"/>
	</device>
</frontpanel>