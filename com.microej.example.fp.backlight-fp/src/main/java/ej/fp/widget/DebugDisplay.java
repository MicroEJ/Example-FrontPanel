/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package ej.fp.widget;

import ej.fp.Image;
import ej.fp.MouseListener;
import ej.fp.Widget.WidgetAttribute;
import ej.fp.Widget.WidgetDescription;

/**
 * Same widget as {@link Display} but it can change the backlight
 * simulation when user clicks on mouse third button (often right
 * click).
 * <p>
 * Contrary to {@link Display}, this display implements {@link MouseListener} to
 * catch mouse events.
 */
@WidgetDescription(attributes = { @WidgetAttribute(name = "label", isOptional = true), @WidgetAttribute(name = "x"),
		@WidgetAttribute(name = "y"), @WidgetAttribute(name = "width"), @WidgetAttribute(name = "height"),
		@WidgetAttribute(name = "displayWidth", isOptional = true),
		@WidgetAttribute(name = "displayHeight", isOptional = true),
		@WidgetAttribute(name = "initialColor", isOptional = true), @WidgetAttribute(name = "alpha", isOptional = true),
		@WidgetAttribute(name = "filter", isOptional = true),
		@WidgetAttribute(name = "extensionClass", isOptional = true) })
public class DebugDisplay extends Display implements MouseListener {

	private boolean scaleBacklight; // false init

	@Override
	public void mousePressed(int x, int y, MouseButton button) {
		if (button == MouseButton.THIRD_BUTTON) {
			this.scaleBacklight = !scaleBacklight;

			// ask to repaint the display to show new backlight rendering
			repaint();
		}
	}

	@Override
	protected void drawBacklight(Image imageSkin) {
		if (scaleBacklight) {
			// get a transparency level according backlight
			int backlight = getBacklight() / 2 + BACKLIGHT_MAX / 2;
			int shadow = ((BACKLIGHT_MAX - backlight) * 0xff / BACKLIGHT_MAX);
			imageSkin.fillTransparentRectangle(0, 0, imageSkin.getWidth(), imageSkin.getHeight(), shadow << 24);
		} else {
			super.drawBacklight(imageSkin);
		}
	}
}
