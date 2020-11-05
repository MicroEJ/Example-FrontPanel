Overview
========

This example shows the display bounds: the display rendering area. The display rendering area is reduced at the bottom of the display, so the MicroEJ application drawings are never performed outside the display bounds. However, it may sometimes be difficult to distinguish between the available display rendering area and the board cover. This example allows seeing these bounds.

Usage
=====

Build the Platform
------------------

1. Right-click on project ``com.microej.example.fp.bounds-configuration``.
2. Select ``Build Module``.
3. Wait for platform building. 
4. Right-click on project ``bounds-Platform-CM4hardfp_IAR83-1.0.0``.
5. Select ``Refresh``.

Launch the Application
----------------------

1. Right-click on the project ``com.microej.example.fp.bounds-application``.
2. Select ``Run as > MicroEJ Application``.

The application starts and shows random rectangles. 

1. Press mouse third button (often right-click) to show the rendering area. The rendering area is _inside_ the white area.
2. Press again mouse third button to back to a normal board rendering.
3. Press mouse first button (often left click) to erase display content.

Requirements
============

* MicroEJ Distribution 20.10 or later.

Dependencies
============

*All dependencies are retrieved transitively by Ivy resolver.*

..
   Copyright 2019-2020 MicroEJ Corp. All rights reserved.
   Use of this source code is governed by a BSD-style license that can be found with this software.

