/*
 * Java
 *
 * Copyright 2019-2021 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.fp;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Painter;
import ej.microui.event.Event;
import ej.microui.event.EventHandler;
import ej.microui.event.generator.Pointer;

/**
 * see /com.microej.example.fp.backlight-application/README.md.
 */
public class Backlight extends Displayable implements EventHandler {

	public static void main(String[] args) {
		MicroUI.start();
		Display display = Display.getDisplay();
		Backlight example = new Backlight(display);
		display.requestShow(example);
	}

	/**
	 * @param display
	 */
	public Backlight(Display display) {
		display.setBacklight(50);
	}

	@Override
	public void render(GraphicsContext g) {
		int w = g.getClipWidth();
		int h = g.getClipHeight();

		g.setColor(Colors.WHITE);
		Painter.fillRectangle(g, 0, 0, w, h);

		int barWidth = w - 20;
		int barHeight = h / 20;
		int barX = (w - barWidth) / 2;
		int barY = h / 2 - barHeight / 2;
		g.setColor(Colors.BLACK);
		Painter.fillRectangle(g, barX, barY, barWidth, barHeight);

		int cursorWidth = barHeight;
		int cursorHeight = barHeight * 3;
		int cursorX = (Display.getDisplay().getBacklight() * barWidth) / 100 + barX;
		int cursorY = h / 2 - cursorHeight / 2;
		g.setColor(Colors.RED);
		Painter.fillRectangle(g, cursorX, cursorY, cursorWidth, cursorHeight);
	}

	@Override
	public boolean handleEvent(int event) {

		if (Event.getType(event) != Pointer.EVENT_TYPE) {
			// manage only touch event
			return false;
		}

		if (Pointer.isPressed(event) || Pointer.isDragged(event)) {
			Pointer p = (Pointer) Event.getGenerator(event);
			int backlight = (p.getX() * 100) / Display.getDisplay().getWidth();
			Display.getDisplay().setBacklight(backlight);
			requestRender();
		}

		return true;

	}
}
