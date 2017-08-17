# OnCallDetector [![Build Status](https://travis-ci.org/edomingues/oncalldetector.svg?branch=master)](https://travis-ci.org/edomingues/oncalldetector)

Java command line application that detects the user is on conf. call and call a Rest Web Service.
## Build
`mvn package`
## Usage
`java -jar target/oncalldetector-1.2.0-jar-with-dependencies.jar <user name> <capture device pattern>`

E.g.: `java -jar target/oncalldetector-1.2.0-jar-with-dependencies.jar user.name pcmC?D?c`

## Change Log

### [2.0.0] - 2017-08-17
#### Added
- Allow to detect if the user is on call in one of multiple microphones (or sound capture devices)

### [1.2.0] - 2017-03-31
#### Added
- Allow to receive the microphone device in CLI arguments
- Only send requests to the server when user is on-call. Does not send update requests when user is not on-call. Server will automatically reset the user state to off-call after some time without receiving on-call update requests.

### [1.0] - 2017-03-09
#### Added
- Java command line application that detects the user is on conf. call and call a Rest Web Service.
