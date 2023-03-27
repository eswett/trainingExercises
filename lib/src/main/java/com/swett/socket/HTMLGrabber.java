package com.swett.socket;

import java.io.*;
import java.net.Socket;


/****************************************************************************
 * <b>Title:</b> HTMLGrabber.java
 * <b>Project:</b> Pre-Spider socket setup
 * <b>Description:</b> Set up a Client application to connect to the apache web server hosted
 * on my local host and through port 81 on my computer
 * 
 * 
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Evan Swett
 * @version 3.0
 * @since 03/23/2023
 *        <b>updates:</b>
 * 
 ****************************************************************************/
public class HTMLGrabber {

    //I use a stringbuilder rather than adding to a string to save space
    private StringBuilder html = new StringBuilder();

    //127.0.0.1 is the same as "localhost"
    //I chose port 81 and set up my apache server to listen to that port
    private final String HOST = "127.0.0.1";
    private final int PORT_NUMBER = 81;

    /**
     * This method creates a socket at an address and port to make a get request to
     * grab the html on a webpage hosted on an apache server
     * @param host
     * @param portNumber
     * @return HTML in string form
     */
    public String getHTML(String host, int portNumber) {

        //make the socket inside of an auto-closeable try-catch method  
        try (Socket echoSocket = new Socket(host, portNumber)) {
            System.out.println("Socket made");

            //Instantiate streams for data in and out.
            DataOutputStream out = new DataOutputStream(echoSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

            //I could use a better understanding of operations between lines 48-53
            out.writeBytes("GET / HTTP/1.1\r\n"); //adding these carriage returns made the call work
            out.writeBytes("Host:" + HOST + "\r\n\r\n");

            String inData = null;
            
            while((inData = in.readLine()) != null) {
                html.append(inData).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return html.toString();
    }

    /**
     * Driver function
     */
    public void be() {
        String webpageHTML = getHTML(HOST, PORT_NUMBER);
        System.out.println(webpageHTML);
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        HTMLGrabber c = new HTMLGrabber();
        c.be();
    }
}
