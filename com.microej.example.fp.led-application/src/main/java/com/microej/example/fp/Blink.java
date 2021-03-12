/*
 * Java
 *
 * Copyright 2019-2021 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.fp;

import ej.fp.LEDsManager;

/**
 * see /com.microej.example.fp.blink-application/README.md.
 */
public class Blink {

	private static final int TIME_MS = 100;
	private static final int LEDS_NUMBER = 4;

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			on();
			off();
		}
	}

	private static void on() throws InterruptedException {
		for (int i = 0; i < LEDS_NUMBER; i++) {
			LEDsManager.on(i);
			Thread.sleep(TIME_MS);
		}
	}

	private static void off() throws InterruptedException {
		for (int i = 0; i <= LEDS_NUMBER; i++) {
			LEDsManager.off(i);
			Thread.sleep(TIME_MS);
		}
	}
}
