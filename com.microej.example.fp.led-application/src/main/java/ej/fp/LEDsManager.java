/*
 * Java
 *
 * Copyright 2019-2021 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package ej.fp;

/**
 * This manager holds the native methods the MicroEJ application can call to
 * turn on/off a LED.
 * <p>
 * This class must be in the same package than the front panel class
 * <code>LEDsManager</code>. This is required by the simulator to retrieve the
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
	public static native void on(int id);

	/**
	 * MicroEJ application native
	 */
	public static native void off(int id);
}
