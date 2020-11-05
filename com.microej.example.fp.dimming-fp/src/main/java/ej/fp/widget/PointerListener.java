/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package ej.fp.widget;

import ej.fp.Device;
import ej.fp.MouseListener.MouseButton;
import ej.fp.widget.Pointer.PointerListenerToPointerEvents;

/**
 * Same pointer listener than {@link PointerListenerToPointerEvents} but able to
 * wake up the display when using the touch.
 * <p>
 * If the display is on, the events are sent as usual. If the display is off,
 * the events are not sent and a display wake-up is asked.
 */
public class PointerListener extends PointerListenerToPointerEvents {

	private final DimmingDisplay display;
	private boolean pressed = false;

	public PointerListener() {
		display = Device.getDevice().getWidget(DimmingDisplay.class);
	}

	@Override
	public void press(Pointer widget, int x, int y, MouseButton button) {

		// ask to wake up display if sleeping
		if (!display.wakeup()) {

			// display was already up: send event as usual
			super.press(widget, x, y, button);

			// store pointer state
			pressed = true;
		}
	}

	@Override
	public void move(Pointer widget, int x, int y) {

		if (pressed && !display.isOff()) {

			// ask to reset dimming
			display.wakeup();

			// send event as usual
			super.move(widget, x, y);
		}
		// else:
		// move after wakeup: press event has been never sent.
		// or
		// move during display off: release event has been never sent.
		// -> no have to send move event!
	}

	@Override
	public void release(Pointer widget, MouseButton button) {
		if (pressed) {
			super.release(widget, button);
			pressed = false;
		}
		// else: release after wakeup: press event has been never sent: no have to send
		// release event!
	}
}
