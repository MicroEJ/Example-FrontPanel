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
 * framework when user clicking on virtual right button.
 * <p>
 * The idea of this button is to change the buttons 3 and 4 skins according the
 * virtual button state.
 * <p>
 * The MicroUI command sent to the MicroEJ application is using the default
 * MicroUI event generator called
 * {@link EventCommand#COMMON_MICROUI_GENERATOR_TAG}. This name matches with the
 * name fixed in platform configuration project:
 * <code>com.microej.example.fp.doublepress-configuration/microui/microui.xml</code>
 */
public class VirtualRightButton implements ButtonListener {

	private final Button button3;
	private final Button button4;

	public VirtualRightButton() {
		// retrieve buttons 3 & 4
		this.button3 = Device.getDevice().getWidget(Button.class, "3");
		this.button4 = Device.getDevice().getWidget(Button.class, "4");
	}

	@Override
	public void press(Button widget) {
		// change buttons current skin to press them
		button3.setCurrentSkin(button3.getPushedSkin());
		button4.setCurrentSkin(button4.getPushedSkin());

		// send a 3rd event (different than buttons 3 & 4)
		EventCommand.sendEvent(EventCommand.SELECT);
	}

	@Override
	public void release(Button widget) {
		// change buttons current skin to release them
		button3.setCurrentSkin(button3.getSkin());
		button4.setCurrentSkin(button4.getSkin());

		EventCommand.sendEvent(EventCommand.CANCEL);
	}

}
