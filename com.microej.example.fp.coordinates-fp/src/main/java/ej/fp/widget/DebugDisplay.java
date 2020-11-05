/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package ej.fp.widget;

import ej.fp.Device;
import ej.fp.Image;
import ej.fp.MouseListener;
import ej.fp.Widget.WidgetAttribute;
import ej.fp.Widget.WidgetDescription;

/**
 * Same widget than {@link Display} but draw a tool tip on display pixel
 * coordinates when user clicking on mouse third button (often right click).
 * <p>
 * Contrary to {@link Display} this display implements {@link MouseListener} to
 * be able to catch mouse events and position.
 */
@WidgetDescription(attributes = { @WidgetAttribute(name = "label", isOptional = true), @WidgetAttribute(name = "x"),
		@WidgetAttribute(name = "y"), @WidgetAttribute(name = "width"), @WidgetAttribute(name = "height"),
		@WidgetAttribute(name = "displayWidth", isOptional = true),
		@WidgetAttribute(name = "displayHeight", isOptional = true),
		@WidgetAttribute(name = "initialColor", isOptional = true), @WidgetAttribute(name = "alpha", isOptional = true),
		@WidgetAttribute(name = "filter", isOptional = true),
		@WidgetAttribute(name = "extensionClass", isOptional = true) })
public class DebugDisplay extends Display implements MouseListener {

	private boolean showCoordinates;
	private int x, y;

	public DebugDisplay() {
		this.showCoordinates = true;
	}

	@Override
	public synchronized Image getCurrentSkin() {
		Image skin = super.getCurrentSkin();
		if (showCoordinates) {
			int stringX = x + 10;
			int stringY = y;
			if (x > getWidth() / 2) {
				stringX = stringX - 60;
			}
			if (y > getHeight() / 2) {
				stringY = stringY - 15;
			}
			skin.drawString(x + "," + y, stringX, stringY, 0xff000000, 0xffe9ed7b);
		}
		return skin;
	}

	@Override
	public void mouseDragged(int x, int y) {
		mouseMoved(x, y);
	}

	@Override
	public void mouseMoved(int x, int y) {
		this.x = x;
		this.y = y;
		if (showCoordinates) {
			Device.getDevice().repaint();
		}
	}

	@Override
	public void mousePressed(int x, int y, MouseButton button) {
		if (button == MouseButton.THIRD_BUTTON) {
			this.showCoordinates = !showCoordinates;

			// repaint all device to erase potential pointer tool tip which can be outside
			// the display
			Device.getDevice().repaint();
		}
	}
}
