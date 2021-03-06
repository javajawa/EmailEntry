EmailEntry
==========

Tiny lightweight portable email entry form for use a careers fairs, freshers
fairs, and other such activity.

Configuration
-------------

Configuration is designed to be done via direct editing of the source code.
The basic version shown here:
 - Uses a white font
 - Is designed to be at least 900x500 pixels
 - Maximises itself by default
 - Loads background.png as a background image

Two modules are supplied for handling the data.
 - TextFile writes out to emails.tsv in the format "&lt;email&gt;&lt;tab&gt;&lt;name&gt;"
 - MailmanLink directly accesses Imperial's mailman server to subscribe people

You can select the method you wish to use in the EmailEntry constructor, around
line 30 in EmailEntry.java (see the comments).

You can also define your own implementations of the IReg interface for use.

Building and running
--------------------

The class can be built using your favourite java compiler.
A Makefile is provided, which essentially wrap the command

``` javac -classpath src/ -d build/ src/emailentry/EmailEntry.java ```

Run with java

``` java -classpath /path/to/build/folder emailentry.EmailEntry ```

License
-------

Copyright (c) 2010-12, Benedict Harcourt
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
* Redistributions of source code must retain the above copyright
  notice, this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.
* Neither the name of Benedict Harcourt nor the
  names of its contributors may be used to endorse or promote products
  derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL BENEDICT HARCOURT BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
