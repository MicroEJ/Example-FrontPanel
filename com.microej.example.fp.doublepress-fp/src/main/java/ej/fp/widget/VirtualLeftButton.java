/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package ej.fp.widget;

import ej.fp.Device;
import ej.fp.widget.Button.ButtonListener;
import ej.microui.event.EventCommand;

/**
 * This class is a listener of standard MicroUI widget {@link Button}. The
 * methods {@link #press(Button)} and {@link #release(Button)} are called by
 * framework when user clicking on virtual left button.
 * <p>
 * The idea of this button is to change the buttons 1 and 2 skins according the
 * virtual button state.
 * <p>
 * The MicroUI command sent to the MicroEJ application is using the default
 * MicroUI event generator called
 * {@link EventCommand#COMMON_MICROUI_GENERATOR_TAG}. This name matches with the
 * name fixed in platform configuration project:
 * <code>com.microej.example.fp.doublepress-configuration/microui/microui.xml</code>
 */
public class VirtualLeftButton implements ButtonListener {

	private final Button button1;
	private final Button button2;

	public VirtualLeftButton() {
		// retrieve buttons 1 & 2
		this.button1 = Device.getDevice().getWidget(Button.class, "1");
		this.button2 = Device.getDevice().getWidget(Button.class, "2");
	}

	@Override
	public void press(Button widget) {
		// change buttons current skin to press them
		button1.setCurrentSkin(button1.getPushedSkin());
		button2.setCurrentSkin(button2.getPushedSkin());

		// send a 3rd event (different than buttons 1 & 2)
		EventCommand.sendEvent(EventCommand.ESC);
	}

	@Override
	public void release(Button widget) {
		// change buttons current skin to release them
		button1.setCurrentSkin(button1.getSkin());
		button2.setCurrentSkin(button2.getSkin());

		EventCommand.sendEvent(EventCommand.CANCEL);
	}

}
