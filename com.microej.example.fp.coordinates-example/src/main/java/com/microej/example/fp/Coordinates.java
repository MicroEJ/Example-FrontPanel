/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.fp;

import java.util.Random;

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
 * see /com.microej.example.fp.coordinates-application/README.md.
 */
public class Coordinates extends Displayable implements EventHandler {

	public static void main(String[] args) throws InterruptedException {
		MicroUI.start();
		Display display = Display.getDisplay();
		Coordinates example = new Coordinates();
		display.requestShow(example);

		while (true) {
			Thread.sleep(10);
			example.requestRender();
		}
	}

	private final Random random;
	private boolean clear;

	/**
	 * @param display
	 */
	public Coordinates() {
		random = new Random(System.currentTimeMillis());
		clear = true;
	}

	@Override
	public void render(GraphicsContext g) {
		int w = g.getClipWidth();
		int h = g.getClipHeight();

		if (clear) {
			g.setColor(Colors.BLACK);
			Painter.fillRectangle(g, 0, 0, w, h);
			clear = false;
		}

		g.setColor(random.nextInt(0xffffff));
		Painter.fillRectangle(g, random.nextInt(w), random.nextInt(h), random.nextInt(w / 4), random.nextInt(h / 4));
	}

	@Override
	public boolean handleEvent(int event) {

		if (Event.getType(event) != Pointer.EVENT_TYPE) {
			// manage only touch event
			return false;
		}

		if (Pointer.isPressed(event)) {
			this.clear = true;
		}

		return true;

	}
}
