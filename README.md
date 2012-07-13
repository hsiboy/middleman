<a name="Top"></a>

# Middleman
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
Great for testing the SPOF in your front end.

There is a control panel and API to display the captured interactions. 
Middleman is useful in manual and exploratory and automated testing.

<a name="MiddleMan Quick Start"></a>

## MiddleMan Quick Start
1. We recommend you clone the latest master.
2. Read the documentation. We'll be adding more recommended steps here shortly.

[Top](#Top)

<a name="Building MiddleMan"></a>

## Building MiddleMan
MiddleMan requires that the you have a working java development environment 
set-up, everything else is included in the repository.

[Top](#Top)

<a name="Contributing to MiddleMan"></a>

## Contributing to MiddleMan

MiddleMan is open source, under BSD license, hosted on Github <a href="http://github.com/hsiboy/middleman">here</a>.
If you have a contribution to make, please fork the repo and submit a pull request.

[Top](#Top)