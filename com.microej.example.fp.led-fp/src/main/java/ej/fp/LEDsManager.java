/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package ej.fp;

import java.util.List;

import ej.fp.widget.LED;

/**
 * This manager holds the implementation of the MicroEJ application native
 * methods.
 * <p>
 * This class must have the same package than <code>LEDsManager</code> in
 * MicroEJ application. This is required by the simulator to retrieve the
 * implementation of native methods.
 */
public final class LEDsManager {

	/**
	 * No instance of this manager is created.
	 */
	private LEDsManager() {
	}

	/**
	 * MicroEJ application native
	 */
	public static void on(int id) {
		updateLED(id, true);
	}

	/**
	 * MicroEJ application native
	 */
	public static void off(int id) {
		updateLED(id, false);
	}

	/**
	 * Retrieves the widget {@link LED} according its identifier and update its
	 * status.
	 * <p>
	 * If not LED matches with the given identifier, this method does nothing.
	 *
	 * @param id
	 *            the LED identifier
	 * @param on
	 *            the new LED state
	 */
	private static void updateLED(int id, boolean on) {
		List<LED> leds = Device.getDevice().getWidgets(LED.class);
		for (LED led : leds) {
			if (led.getID() == id) {
				led.showYourself(on);
				break;
			}
		}
	}
}
