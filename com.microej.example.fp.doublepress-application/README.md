# Overview
This example shows how to press two buttons at the same time using a third virtual button.

# Usage

## Build the platform
1. Right-click on project `com.microej.example.fp.doublepress-configuration`.
2. Select `Build Module`.
3. Wait for platform building. 
4. Right-click on project `doublepress-Platform-CM4hardfp_IAR83-1.0.0`.
5. Select `Refresh`.

## Launch the application
1. Right-click on the project `com.microej.example.fp.doublepress-application`.
2. Select `Run as > MicroEJ Application`.

The application starts and shows four gray rectangles. The first rectangle on the left shows button 1 state, next rectangle button 2, etc. 

1. Press button 1 to change the rectangle color: the left rectangle is green. 
2. Release button 1 and press button 2: the second rectangle is green.
3. Press "left virtual button": both buttons are now pressed, both rectangles are green. 

# Requirements
* MicroEJ Distribution 20.10 or later.

# Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.

---
_Copyright 2019-2021 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._  
