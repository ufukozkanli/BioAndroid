# Bio-OS for Android

A heartrate monitor (and other bits) using Android as a data capture device,
connected to an [IOIO][] board and a Sparkfun [HMRI][] breakout board.

## Dependencies

* Targeted against: Android Gingerbread (2.3.3).
* You will also need Android API-level 3 support (i.e.: Android 1.5) to
  support the IOIO board.
* Designed for an IOIOv1 board.

## Hardware

Pin   | Sensor           | Usage
----- | ---------------- | ------------------------------------------------------------------------
0     | Status LED       | Used for testing.
42    | GSR              | Glavanic Skin Response, use .getVoltage(); to read.
43    | Stretch Resistor | Breathing Rate, use .read(); to read.
45    | Temprature       | Local Skin Temprature, use .getVoltage(); to read, requires conversion.          

## License

The MIT License (MIT)
Copyright © 2013 Institute of Digital Art and Technology, Plymouth 
University, http://i-dat.org

Permission is hereby granted, free of charge, to any person obtaining a copy 
of this software and associated documentation files (the “Software”), to deal
in the Software without restriction, including without limitation the rights 
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
of the Software, and to permit persons to whom the Software is furnished to do 
so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all 
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION 
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

[IOIO]: https://github.com/ytai/ioio/
[HMRI]: https://www.sparkfun.com/products/8661
