# Overview
This example allows changing at runtime the display backlight rendering. By default the 0% backlight turns off the display: it becomes black. On some devices, the display content may be visible even if backlight is at 0%. This example allows to change the default rendering of display backlight. 

# Usage

## Build the platform
1. Right-click on project `com.microej.example.fp.backlight-configuration`.
2. Select `Build Module`.
3. Wait for platform building. 
4. Right-click on project `backlight-Platform-CM4hardfp_IAR83-1.0.0`.
5. Select `Refresh`.

## Launch the application
1. Right-click on the project `com.microej.example.fp.backlight-application`.
2. Select `Run as > MicroEJ Application`.

The application starts and shows a slider.  

1. Move the slider: the display backlight "follows" the slider value; at 0%, the display is black.
2. Press mouse third button (often right-click) to change the backlight rendering.
3. Move the slider again: at 0%, the display content is visible.

# Requirements
* MicroEJ Distribution 20.10 or later.

# Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.

---
_Copyright 2019-2021 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._  
