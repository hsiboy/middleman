<a name="Top"></a>

# Middleman - Great for testing the SPOF in your front end!
[![Build Status](https://travis-ci.org/hsiboy/middleman.svg?branch=master)](https://travis-ci.org/hsiboy/middleman)

## MiddleMan
A tool to help with the testing web applications by collecting data on the 
interactions, and providing stubs for those end points between the 
web client (browser) and the application under test.

At its core middleman is lightweight HTTP proxy that sits between the browser 
or web client and any web applications that the browser connects to. 
By intercepting this traffic, middleman is able to collect metrics as well as 
the exchanged data for analysis or verification. 
When running as a stub for the end point it can be configured to serve a given 
HTTP response header, status-code and or body combination. 

There is a control panel and API to configure and display the captured interactions. 

Middleman is useful in manual and exploratory and automated testing.

[How to Contribute](#ContributingToMiddleMan) | [Known Issues](#KnownIssues) | [Version History](#VersionHistory)

<a name="MiddleManQuickStart"></a>

## MiddleMan Quick Start
1. We recommend you clone the latest master.
2. Choose your OS and run the folllwing:

'Windows: '
```
run.bat
```

'Linux/Mac: '
```
chmod +x run.sh
chmod +x tools/apache-ant-1.8.3/bin/ant

./run.sh
```

3. Use compiled version in build/dist/middleman directory
4. Run 'middleman' batch/bash script (depending on OS) with options in middleman.config, default port 2000
5. Check out the console and the web interface [http://localhost:2000/](http://localhost:2000/)
6. Documentation: [http://localhost:2000/doc/index.html](http://localhost:2000/doc/index.html)

[Top](#Top)

<a name="BuildingMiddleMan"></a>

## Building MiddleMan
MiddleMan requires that the you have a working java development environment set-up, everything else is included in the repository.
Middleman has been sucessfully built against OpenJdk6, OpenJdk7 and Oracle JDK (64bit) on Windows, Linux and Mac OS X.

Dist available soon for those who dont do builds!


## Using MiddleMan
Example proxy setup: third-party - [http://localhost:2000/third-party](http://localhost:2000/third-party)

Page will show what responses will be stubbed out, along with http status code, you can also add more while the proxy server is running

View log of requests via:

* HTML - [http://localhost:2000/third-party/log](http://localhost:2000/third-party/log)
* XML - [http://localhost:2000/third-party/log/xml](http://localhost:2000/third-party/log/xml)
* CSV - [http://localhost:2000/third-party/log/csv](http://localhost:2000/third-party/log/csv)
* JSON - [http://localhost:2000/third-party/log/json](http://localhost:2000/third-party/log/json)

TODO: ~~JSON Object!~~ :)


[Top](#Top)

<a name="ContributingToMiddleMan"></a>

## Contributing to MiddleMan

MiddleMan is open source, under BSD license, <a href="http://github.com/hsiboy/middleman">hosted on Github here</a>.
If you have a contribution to make, please fork the repo and submit a pull request.

* [hsiboy](https://github.com/hsiboy) ([Twitter](https://twitter.com/hsiboy))
* [t0mtaylor](https://github.com/t0mtaylor) ([Twitter](https://twitter.com/tom_taylor))

Thanks to Graham Brooks for the intial groundwork back in 2009!

[Top](#Top)

<a name="KnownIssues"></a>

## Known Issues

* There is no dist package/release available yet, should do once integration with Travis is working (almost)!
* Mac: .classpath is not used, and so libs for ant will not load and cause an error:
```
Antlr3 library not found via CLASSPATH 
```

[Top](#Top)

<a name="VersionHistory"></a>

## Version History
* 2014-11-05   v0.1.5  Updated docs and templates, added JSON output of request log :)
* 2014-11-04   v0.1.4 Tests running via Eclipse and fixed
* 2014-11-03   v0.1.3  Should now look for git instead of svn, readme updates
* 2014-05-22   v0.1.2  Updated license, been a while!
* 2012-07-13   v0.1.1   Trying again with Travis, more fun
* 2012-07-10   v0.1.0   Initial commit into GitHub repo, cleanup and start setup with Travis


[Top](#Top)
