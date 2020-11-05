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
	
	<device name="bounds" skin="board.png">
		<ej.fp.widget.Display x="187" y="65" width="240" height="240" filter="mask.png" initialColor="0x717d83"/>
		<ej.fp.widget.Pointer x="187" y="65" width="240" height="240" touch="true" filter="mask.png"/>
		<ej.fp.widget.Bounds debug="bounds.png"/>
	</device>
</frontpanel>