package com.swett.game;

import java.util.ArrayList;

public class StartupBust {
    // initialize gamehelper, make arraylist to hold startups, numguesses
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<>();
    int numGuesses = 0;

    // setupGame function makes and namess three startups, add them to arraylist
    // print instructions
    // loop through startups, get location from helper, add new locations to
    // startup's arrayList
    public void setupGame() { // this is supposed to be a private
        Startup s1 = new Startup();
        s1.setName("Evan");

        Startup s2 = new Startup();
        s2.setName("Swett");

        Startup s3 = new Startup();
        s3.setName("Tyler");

        startups.add(s1);
        startups.add(s2);
        startups.add(s3);

        System.out.println("Your goal is to sink three Startups.");
        System.out.println(s1.getName() + ", " + s2.getName() + ", " + s3.getName());
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (Startup startup : startups) {
            ArrayList<String> newLocation = helper.placeStartup(3); // this argument defines how large a ship will be
            startup.setLocationCells(newLocation);
        }
    }

    // startPlaying function loops until startups arraylist is empty
    // get user guess from helper function
    // call check user guess
    // call finish game after loop
    private void startPlaying() {
        while (!startups.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess: ");
            checkUserGuess(userGuess);
        }
        // finish game fxn
        finishGame();
    }

    // check user guess function
    // increment numguesses
    // set result to miss
    // loop through existing startups and check results
    // print result, remove if kill
    private void checkUserGuess(String userGuess) {
        numGuesses++;
        String result = "miss";
        for (Startup startup : startups) {
            result = startup.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                startups.remove(startup);
                break;
            }
        }
        System.out.println(result);
    }

    // finishGame
    // if numguesses are less than 18, print encouraging message
    // else print somnething humiliating

    // main function initializes game, calls setup, and then startPlaying
    private void finishGame() {
        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numGuesses <= 18) {
            System.out.println("It only took you " + numGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    } // close method

    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setupGame();
        game.startPlaying();
        }
}
