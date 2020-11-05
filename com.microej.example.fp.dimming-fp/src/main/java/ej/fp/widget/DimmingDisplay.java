/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package ej.fp.widget;

import java.util.Timer;
import java.util.TimerTask;

import ej.fp.Image;
import ej.fp.Widget.WidgetAttribute;
import ej.fp.Widget.WidgetDescription;

/**
 * Same widget than {@link Display} but backlight changes according inactivity.
 */
@WidgetDescription(attributes = { @WidgetAttribute(name = "label", isOptional = true), @WidgetAttribute(name = "x"),
		@WidgetAttribute(name = "y"), @WidgetAttribute(name = "width"), @WidgetAttribute(name = "height"),
		@WidgetAttribute(name = "displayWidth", isOptional = true),
		@WidgetAttribute(name = "displayHeight", isOptional = true),
		@WidgetAttribute(name = "initialColor", isOptional = true), @WidgetAttribute(name = "alpha", isOptional = true),
		@WidgetAttribute(name = "filter", isOptional = true),
		@WidgetAttribute(name = "extensionClass", isOptional = true) })
public class DimmingDisplay extends Display {

	private static final int LCD_OFF_TIMER_MS = 1000; // 1s
	private static final int BACKLIGHT_OFF_TIMER_TICKS = 4; // 4s
	private static final int LCD_OFF_TIMER_TICKS = 6; // 6s

	private enum Status {
		OFF, /* backlight is off */
		DIMMING, /* backlight is reduced */
		ON, /* backlight is on */
	};

	private final Timer timer;
	private TimerTask timerTask;
	private int timerCounter;
	private Status status;

	public DimmingDisplay() {
		this.timer = new Timer();
		this.status = Status.OFF;
	}

	@Override
	public void start() {
		super.start();
		wakeup();
	}

	@Override
	public synchronized Image getCurrentSkin() {

		Image image = super.getCurrentSkin();

		if (status == Status.OFF) {
			// show a black screen
			image.fillRectangle(0, 0, image.getWidth(), image.getHeight(), 0xff000000);
		} else if (status == Status.DIMMING) {
			// get a transparency level according backlight
			int shadow = ((BACKLIGHT_MAX - getBacklight() / 2) * 0xff / BACKLIGHT_MAX);
			image.fillTransparentRectangle(0, 0, image.getWidth(), image.getHeight(), shadow << 24);
		}
		// else: nothing to change

		return image;
	}

	/**
	 * User input activity: reset off timer
	 */
	public boolean wakeup() {

		boolean wakeupDone = status == Status.OFF;
		status = Status.ON;

		if (timerTask == null) {
			// start new timer task
			timerTask = new TimerTask() {
				@Override
				public void run() {
					++timerCounter;
					if (timerCounter == BACKLIGHT_OFF_TIMER_TICKS) {
						status = Status.DIMMING;
						repaint();
					} else if (timerCounter >= LCD_OFF_TIMER_TICKS) {
						status = Status.OFF;
						timerTask.cancel();
						timerTask = null;
						repaint();
					}
				}
			};
			timer.scheduleAtFixedRate(timerTask, LCD_OFF_TIMER_MS, LCD_OFF_TIMER_MS);
		}

		if (wakeupDone) {
			// repaint display content after wakeup
			repaint();
		}

		// reset timer counter
		timerCounter = 0;

		return wakeupDone;
	}

	public boolean isOff() {
		return status == Status.OFF;
	}
}
