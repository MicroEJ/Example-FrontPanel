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
import ej.fp.Widget;
import ej.fp.Widget.WidgetAttribute;
import ej.fp.Widget.WidgetDescription;

/**
 * This widget shows a mask around the display to show the display bounds, in
 * other words, the display rendering area. The display rendering area is
 * reduced at bottom of display and so the MicroEJ application drawings are
 * never performed outside the display bounds.
 * <p>
 * This widget implements {@link MouseListener} to be able to catch mouse
 * events.
 */
@WidgetDescription(attributes = { @WidgetAttribute(name = "debug") })
public class Bounds extends Widget implements MouseListener {

	private Image debug;
	private Image originalBack;
	private boolean showDebugBackground;

	public void setDebug(Image skin) {
		this.debug = skin;
		setWidth(skin.getWidth());
		setHeight(skin.getHeight());
	}

	@Override
	public void start() {
		super.start();
		this.showDebugBackground = false;
		originalBack = Device.getDevice().getCurrentSkin();
	}

	@Override
	public void mousePressed(int x, int y, MouseButton button) {
		if (button == MouseButton.THIRD_BUTTON) {
			this.showDebugBackground = !this.showDebugBackground;
			Device.getDevice().setCurrentSkin(showDebugBackground ? debug : originalBack);
			Device.getDevice().repaint();
		}
	}
}
