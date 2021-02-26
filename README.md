*This repository provides a file to replace one of the files in the Python-Chrome-App-Native-Messaging repository.  It's therefore beneficial to get Python-Chrome-App-Native-Messaging working correctly first.*

A Java program that can communicate both ways with a Chrome App is provided.  It's been tested with Chromium Browser.  The amount of byte padding of the 32-bits for the returned message length will here depend on the length of the message that you're returning, so adjust padding amount if required.  The order of the padding will also depend on endianness, so some machines will require the padding to come before the returned message-length's value. 

(This Java transformation is motivated by: https://chromium.googlesource.com/chromium/src/+/master/chrome/common/extensions/docs/examples/api/nativeMessaging/host/).

To use the source code, give the 'output.txt' file a path of your choice in the .java code, create Nmeh.jar using e.g. NetBeans, and point to this jar file from com.google.chrome.example.echo.json (i.e. rename the Python-Chrome-App-Native-Messaging repository file native-messaging-example-host to Nmeh.jar).  The com.google.chrome.example.echo.json file needs to be in your NativeMessagingHosts directory.  Mine is in ~/.config/google-chrome/NativeMessagingHosts for Google Chrome and ~/.config/chromium/NativeMessagingHosts for Chromium.  Ensure all files have suitable permissions.

NOTE:  The jar file will not work on other machines because your file output paths will be different to mine.  You should create your own jar file with your own chosen output file's directory.


