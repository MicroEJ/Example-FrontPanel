/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package ej.fp.widget;

import ej.fp.Image;
import ej.fp.LEDsManager;
import ej.fp.Widget;
import ej.fp.Widget.WidgetAttribute;
import ej.fp.Widget.WidgetDescription;

/**
 * Widget LED declaration.
 * <p>
 * Use the widget <code>label</code> as unique identifier. This label must be an
 * integer (easier to control the LED in MicroEJ application).
 */
@WidgetDescription(attributes = { @WidgetAttribute(name = "label"), @WidgetAttribute(name = "x"),
		@WidgetAttribute(name = "y"), @WidgetAttribute(name = "skin") })
public class LED extends Widget {

	private int id;
	private boolean on; // false init

	@Override
	public void finalizeConfiguration() {
		super.finalizeConfiguration();

		// throws an exception if label is not an integer
		this.id = Integer.parseInt(getLabel());
	}

	/**
	 * Called by the plugin when clicking on <code>Outputs</code> button from Front
	 * Panel Preview and by the {@link LEDsManager}
	 */
	@Override
	public void showYourself(boolean appearSwitchedOn) {

		// update its state
		this.on = appearSwitchedOn;

		// ask to repaint it
		this.repaint();
	}

	/**
	 * Called by framework to render the LED.
	 */
	@Override
	public Image getCurrentSkin() {
		// when LED is off, hide its skin returning null
		return on ? getSkin() : null;
	}

	/**
	 * Gets the LED identifier (equals to its label).
	 *
	 * @return the LED identifier.
	 */
	public int getID() {
		return this.id;
	}
}
