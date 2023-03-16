package com.swett.intro3;

import java.io.*;

public class FileManipulator {
    // instance variable for filename
    private String inputFile;

    /**
     * Constructor that accepts a fi
     * 
     * @param fileName
     */
    FileManipulator(String fileName) {
        inputFile = fileName;
    }

    public String readFile() {
        // the string to read to
        String fileData = "";

        try {

            FileReader reader = new FileReader(inputFile);
            int c;

            while ((c = reader.read()) != -1) {
                fileData += (char) c; // this must be casted to a char from its ascii value
            }
            reader.close();

        } catch (Exception e) {
            System.out.println("The file doesnt exist!");
            e.printStackTrace();
        }
        return fileData;
    }
}

class Object2 {

    public void run() {
        FileManipulator o1 = new FileManipulator("lib/src/main/java/com/swett/intro3/file1.txt"); //
        String testResult = o1.readFile();
        System.out.println(testResult);
    }

    public static void main(String[] args) {
        Object2 o2 = new Object2();
        o2.run();
    }
}
