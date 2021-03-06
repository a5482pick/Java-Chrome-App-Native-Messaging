
package nmeh;   //native-messaging-example-host.

import java.io.*;

//A java class to communicate with a Chrome App.  This is a simple demonstration of how 
//the communication can be achieved for both sending and receiving messages.
public class Nmeh {
    
    public static void main(String[] args) 
        throws java.io.IOException
    {
      //Prepare a file to save the message that was sent from the Chrome App. 
      BufferedWriter bw = new BufferedWriter(
             new FileWriter("/YOUR_CHOSEN_PATH/output.txt"));
       
      //An infinite loop to keep the connection alive.
      int i =0;
      while (i < 0.5) {
        
        //Create a byte array to store the first 4 bytes sent from the Chrome App.
        //These four bytes tell us how long the message is.
        byte[] lengthByte = new byte[4];
        
        //Read these first four bytes into the byte array.
        int bytesRead = System.in.read(lengthByte,0,4);
    
        //For simplicity, I assume the message length is entirely in the 1st byte.
        //This is OK for short messages.
        int text_length = lengthByte[0];
        
        //Now create a byte array to store a message from the Chrome App, and add the message.
        byte[] c = new byte[text_length];
        int lengthAppMessage = System.in.read(c,0,text_length);
    
        //Now store the app's message to file, by looping over the bytes.
        for (int j = 0 ; j < text_length; j++) {
     
           bw.write(c[j]);
           bw.flush();
        }
        bw.newLine();
    
        //Prepare to return a message to the Chrome App.  Our message will be 19 'chars' 
        //long (see further down).  For this simple example I manually enter that length. 
        int returnedMessageLength = 19;
          
        //The app assumes that the first 32 bits returned give the message's length.
        //I break the returned message into 4 lots of 8-bits, to demonstrate.
        //(Endianness may require this line of code to be written after the 3 lines that follow it.)
        System.out.write((byte) (returnedMessageLength));
        
        //3 byte 'padding'.  The length of the returned message is limited in this simple demonstration,
        //so different returned message lengths may require different amounts of padding.
        //Additionally, endianness may demand these code lines be inserted before the above line of code.  
        System.out.write((byte)0);
        System.out.write((byte)0);
        System.out.write((byte)0);
    
        //Add the 19-'char' message to the output stream.  For clarity, 
        //one char at a time is added.  The braces, colon and quotations are required.
        System.out.append('{');
        System.out.append('"');
        System.out.append('m');
        System.out.append('e');
        System.out.append('s');
        System.out.append('s');
        System.out.append('a');
        System.out.append('g');
        System.out.append('e');
        System.out.append('"');
        System.out.append(':');
        System.out.append('"');
        System.out.append('h');
        System.out.append('e');
        System.out.append('l');
        System.out.append('l');
        System.out.append('o');
        System.out.append('"');
        System.out.append('}');  
      }
    }  
}
    
