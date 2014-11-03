<a name="Top"></a>

# Middleman - Great for testing the SPOF in your front end!
[![Build Status](https://secure.travis-ci.org/hsiboy/middleman.png)](http://secure.travis-ci.org/hsiboy/middleman)

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

[Top](#Top)

<a name="BuildingMiddleMan"></a>

## Building MiddleMan
MiddleMan requires that the you have a working java development environment 
set-up, everything else is included in the repository.
Middleman has been sucessfully built against OpenJdk6, OpenJdk7 and Oracle JDK (64bit) on windows and Linux.

[Top](#Top)

<a name="ContributingToMiddleMan"></a>

## Contributing to MiddleMan

MiddleMan is open source, under BSD license, <a href="http://github.com/hsiboy/middleman">hosted on Github here</a>.
If you have a contribution to make, please fork the repo and submit a pull request.

* [hsiboy](https://github.com/hsiboy) ([Twitter](https://twitter.com/hsiboy))
* [t0mtaylor](https://github.com/t0mtaylor) ([Twitter](https://twitter.com/tom_taylor))

[Top](#Top)

<a name="KnownIssues"></a>

## Known Issues

* There is no dist package/release available yet, should do once integration with Travis is working!
* Mac: .classpath is not used, and so libs for ant will not load and cause an error:
```
Antlr3 library not found via CLASSPATH 
```

[Top](#Top)

<a name="VersionHistory"></a>

## Version History
* 2014-11-03   v0.1.3  Should now look for git instead of svn, readme updates
* 2014-05-22   v0.1.2  Updated license, been a while!
* 2012-07-13   v0.1.1   Trying again with Travis, more fun
* 2012-07-10   v0.1.0   Initial commit into GitHub repo, cleanup and start setup with Travis


[Top](#Top)