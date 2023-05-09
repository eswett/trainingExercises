package com.swett.intro3;

import java.io.*;

/****************************************************************************
 * <b>Title:</b> FileManipulator.java
 * <b>Project:</b> Homework from Intro to Prog3 (Which came after 4)
 * <b>Description:</b> Working with FileStreams in Java
 * 
 * The homework instructions were to make two classes/objects. The first one has
 * methods
 * for reading in, and writing to, two separate files.
 * 
 * 
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Evan Swett
 * @version 3.0
 * @since 03/16/2023
 *        <b>updates:</b>
 * 
 ****************************************************************************/

public class FileManipulator {

    // instance variable for filename
    private String inputFile;

    /**
     * Constructor that accepts the name of the file to be read
     * I could open the filereader here but didn't in case the file to be read is
     * not charater type
     * 
     * @param fileName
     */
    FileManipulator(String fileName) {
        inputFile = fileName;
    }

    /**
     * This method instantiates a FileReader
     * 
     * @return
     */
    public String readFile() {
        // the string to read to
        String fileData = "";

        try (FileReader reader = new FileReader(inputFile);) { //a "try-with-resources" block closes the stream automatically, compare to the writeFile method that manually closes
            
            int c;

            while ((c = reader.read()) != -1) {
                fileData += (char) c; // this must be casted to a char from its ascii value
            }
        } catch (Exception e) {
            System.out.println("The file doesnt exist!");
            e.printStackTrace();
        }
        return fileData;
    }

    /**
     * This method makes a new file called "output.txt," opens it as a stream, and
     * then writeFiles to it
     * 
     * @param data
     */
    public void writeFile(String data) {
        try {
            FileWriter out = new FileWriter("lib/src/main/java/com/swett/intro3/output.txt");
            out.write(data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The output file couldn't be created");
        }
    }
}

class Object2 {
    /**
     * This is the control method. It instantiates Object 1 with the filename of the
     * input file.
     * It calls object 1's read method which reads the saved character stream, then
     * the piped uppercase method handles the conversion
     * It saves that data in a String and passes it to the writefile method
     * @return nothing
     */
    public void run() {
        FileManipulator o1 = new FileManipulator("lib/src/main/java/com/swett/intro3/file1.txt"); // must provide
                                                                                                  // complete relative
                                                                                                  // path to root folder
        String inFileData = o1.readFile().toUpperCase();
        o1.writeFile(inFileData);
    }

    /**
     * Entry point into the program. Still not even really a control function
     * @param args
     */
    public static void main(String[] args) {
        Object2 o2 = new Object2();
        o2.run();
    }
}
