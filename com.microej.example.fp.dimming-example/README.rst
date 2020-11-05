Overview
========

This example turns off the display after 6s of inactivity (touch inactivity). On touch press event, the display is waked up.

Usage
=====

Build the Platform
------------------

1. Right-click on project ``com.microej.example.fp.dimming-configuration``.
2. Select ``Build Module``.
3. Wait for platform building. 
4. Right-click on project ``dimming-Platform-CM4hardfp_IAR83-1.0.0``.
5. Select ``Refresh``.

Launch the Application
----------------------

1. Right-click on the project ``com.microej.example.fp.dimming-application``.
2. Select ``Run as > MicroEJ Application``..

The application starts and shows some random rectangles.  

1. Click on display and drag: the display is never turned off.
2. Release touch and wait for 4s: the display backlight is reduced.
3. Press again the touch: the display backlight returns to its nominal value (100%)
4. Release touch and wait for 6s: the display backlight is turned off.
5. Press the touch again: the display is turned on, and its backlight returns to its nominal value (100%)

Requirements
============

* MicroEJ Distribution 20.10 or later.

Dependencies
============

*All dependencies are retrieved transitively by Ivy resolver.*

..
   Copyright 2019-2020 MicroEJ Corp. All rights reserved.
   Use of this source code is governed by a BSD-style license that can be found with this software.

