package com.swett.intro4;

import java.util.*;


/****************************************************************************
 * <b>Title:</b> PersonList.java
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



/** I made this class so that I could make Person objects with id, and name attributes
 *  I also wanted to make my own parameterized constructor to make persons more cleanly
 */
class Person {
    //just experimenting with protected access
    protected int id_;
    protected String firstname_;
    protected String lastname_;

    /**
     * Need to provide a no-arg constructor because I have the one below
     */
    Person() {
        id_ = 0;
        firstname_ = "john";
        lastname_ = "doe";
    }

    /**
     * Want to provide a parameterized contructor to make building people cleaner
     * 
     * @param id
     * @param firstname
     * @param lastname
     */
    Person(int id, String firstname, String lastname) {
        id_ = id;
        firstname_ = firstname;
        lastname_ = lastname;
    }


    //rather than using my print list function I could override the toString for my person class
    // @Override
    // public String toString() {
    //     // TODO Auto-generated method stub

    //     return super.toString();
    // }
}

public class PersonList {
    // define list
    private List<Person> lst;

    // add people to the list
    public List<Person> makeList() {

        lst = new ArrayList<>();

        Person p1 = new Person(1, "Jimi", "Hendrix");
        Person p2 = new Person(2, "Bob", "Dylan");
        Person p3 = new Person(3, "Willie", "Nelson");
        Person p4 = new Person(4, "Nelson", "Mandela");

        lst.add(p1);
        lst.add(p2);
        lst.add(p3);
        lst.add(p4);

        return lst;
    }

    /** 
     * Takes in a list and runs a forEach loop that prints every objects attributes
     * @param lst
     */
    public void displayList(List<Person> lst) {
        lst.forEach((p) -> {
            System.out.println(p.firstname_ + " " + p.lastname_ + " | ID: " + p.id_);
        });
        System.out.println(System.lineSeparator());
    }

    /**
     * Entry point into program that initializes PersonList object to use methods within it
     * @param args
     */
    public static void main(String[] args) {
        // initialize driver object
        PersonList pl = new PersonList();

        //build list
        List<Person> personList = pl.makeList();

        System.out.println("This is the list ordered by ID number: \n");
        pl.displayList(personList);

        //use static method from Collections class
        Collections.shuffle(personList);

        System.out.println("And here is the list shuffled randomly: \n");
        pl.displayList(personList);
    }
}
