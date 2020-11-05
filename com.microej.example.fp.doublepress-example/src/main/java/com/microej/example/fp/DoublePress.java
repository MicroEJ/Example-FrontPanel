/*
 * Java
 *
 * Copyright 2019-2020 MicroEJ Corp. All rights reserved.
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
import ej.microui.event.generator.Command;

/**
 * see /com.microej.example.fp.doublepress-application/README.md.
 */
public class DoublePress extends Displayable implements EventHandler {

	public static void main(String[] args) throws InterruptedException {
		MicroUI.start();
		Display display = Display.getDisplay();
		DoublePress example = new DoublePress();
		display.requestShow(example);
	}

	// false init
	private boolean showButton1;
	private boolean showButton2;
	private boolean showButton3;
	private boolean showButton4;

	@Override
	public void render(GraphicsContext g) {
		int w = g.getClipWidth();
		int h = g.getClipHeight();

		g.setColor(Colors.BLACK);
		Painter.fillRectangle(g, 0, 0, w, h);

		drawCommand(g, showButton1);
		g.translate(w / 4, 0);
		drawCommand(g, showButton2);
		g.translate(w / 4, 0);
		drawCommand(g, showButton3);
		g.translate(w / 4, 0);
		drawCommand(g, showButton4);
	}

	private void drawCommand(GraphicsContext g, boolean command) {
		g.setColor(command ? Colors.GREEN : Colors.GRAY);
		int w = g.getClipWidth();
		int h = g.getClipHeight();
		w /= 4;
		int bound = w / 20;
		Painter.fillRectangle(g, bound, bound, w - 2 * bound, h - 2 * bound);
	}

	@Override
	public boolean handleEvent(int event) {
		if (Event.getType(event) != Command.EVENT_TYPE) {
			// waiting only MicroUI Command
			return false;
		}

		switch (Event.getData(event)) {
		case Command.LEFT:
			showButton1 = true;
			showButton2 = false;
			showButton3 = false;
			showButton4 = false;
			break;
		case Command.ANTICLOCKWISE:
			showButton1 = false;
			showButton2 = true;
			showButton3 = false;
			showButton4 = false;
			break;
		case Command.CLOCKWISE:
			showButton1 = false;
			showButton2 = false;
			showButton3 = true;
			showButton4 = false;
			break;
		case Command.RIGHT:
			showButton1 = false;
			showButton2 = false;
			showButton3 = false;
			showButton4 = true;
			break;
		case Command.ESC:
			showButton1 = true;
			showButton2 = true;
			showButton3 = false;
			showButton4 = false;
			break;
		case Command.SELECT:
			showButton1 = false;
			showButton2 = false;
			showButton3 = true;
			showButton4 = true;
			break;
		case Command.CANCEL:
			showButton1 = false;
			showButton2 = false;
			showButton3 = false;
			showButton4 = false;
			break;

		default:
			// unexpected command
			return false;
		}

		// ask to render displayable to show current button state.
		requestRender();
		return true;
	}
}
