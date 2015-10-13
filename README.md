A Java program that can communicate both ways with a Chrome App is provided.  (It has been tested with Chromium Browser on a little-endian machine.  You may have to reverse the byte padding, as explained in the code).  The purpose is to demonstrate the basics of the process, and the code has therefore been kept as short and simple as possible.

It operates as a straight-forward substitute for the file native-messaging-example-host in the Google Chrome [native messaging host example] (https://chromium.googlesource.com/chromium/src/+/master/chrome/common/extensions/docs/examples/api/nativeMessaging/host/).

To use the source code, give the 'output.txt' file a path of your choice in the .java code, create Nmeh.jar using e.g. NetBeans, and point to this jar file from com.google.chrome.example.echo.json.  (This JSON file needs to be in your NativeMessagingHosts directory.  For example, mine is in ~/.config/google-chrome/NativeMessagingHosts.)  Ensure all files have suitable permissions.


