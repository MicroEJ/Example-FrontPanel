/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package ej.fp.widget;

import ej.fp.widget.Button.ButtonListener;
import ej.microui.event.EventCommand;

/**
 * This class is a listener of standard MicroUI widget {@link Button}. The
 * methods {@link #press(Button)} and {@link #release(Button)} are called by
 * framework when user clicking on button 4.
 * <p>
 * The MicroUI command sent to the MicroEJ application is using the default
 * MicroUI event generator called
 * {@link EventCommand#COMMON_MICROUI_GENERATOR_TAG}. This name matches with the
 * name fixed in platform configuration project:
 * <code>com.microej.example.fp.doublepress-configuration/microui/microui.xml</code>
 */
public class Button4 implements ButtonListener {

	@Override
	public void press(Button widget) {
		EventCommand.sendEvent(EventCommand.RIGHT);
	}

	@Override
	public void release(Button widget) {
		EventCommand.sendEvent(EventCommand.CANCEL);
	}

}
