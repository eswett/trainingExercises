package com.swett.intro4;

import java.util.ArrayList;
import java.util.List;


/****************************************************************************
 * <b>Title:</b> StringArrayToList.java
 * <b>Project:</b> Homework from Intro to Prog4
 * <b>Description:</b> Collections in java
 * 
 * 
 * 
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Evan Swett
 * @version 3.0
 * @since 03/02/2023
 *        <b>updates:</b>
 * 
 ****************************************************************************/



public class StringArrayToList {
    //initialize a string array
    private String[] stringArr = {"boy", "howdy", "did", "you", "see", "them", "yankees", "play"};
    private List<String> lst = new ArrayList<>();
    //initialize a list that accepts string type
    //add every element of the string array to the list

    /** 
    * This function takes a string array as an argument, adds every element
    * to a list
    */
    public List<String> converter(String[] arr) {
        for(String st: arr) {
            lst.add(st);
        }
        return lst;
    }

    /** This function should be treated as the driver function for this program
     *  It calls the converter function using my instance variables and prints result types
     */
    public void go() {
        //call function that converts string arr to list
        List<String> myList = converter(stringArr);

        //I used a lambda to print each element of my list, something tells me there's a better way
        myList.forEach((e) -> {
            System.out.println(e);
        });

        //Print the type at the end to prove that the Strings are now in a list
        System.out.println("\nThe list is now of: " + lst.getClass() + " type"); //if 

    }

    /** The entry point into my program. It calls my program object and tells it to go.
     *  What else would be important to add here?
     * @param args
     */
    public static void main(String[] args) {
        StringArrayToList satl = new StringArrayToList();
        satl.go();
    }
}
