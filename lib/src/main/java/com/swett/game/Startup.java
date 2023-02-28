package com.swett.game;
import java.util.ArrayList;

public class Startup {
    //declare instance variables
        //ArrayList of cell locations and the name of the startup instance
    private ArrayList<String> cellLocations = new ArrayList<String>();
    private String name;

    //setter method that updates the locations of startups
        //location comes from GameHelper's 'placeStartup' method
    public void setLocationCells(ArrayList<String> loc) {
        cellLocations = loc;
    }

    //setter method for name
    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    //function to check if user Input returns a "hit" "kill," or "miss."
        //make result string false and check cell location ArrayList for other conditions
        //use .isEmpty() and .remove() and .indexOf
        //Print message if there's a kill
    public String checkYourself(String userInput) {
        String result = "miss";
        int index = cellLocations.indexOf(userInput);
        if(index >= 0) {
            cellLocations.remove(index);

            if(cellLocations.isEmpty()) {
                result = "kill"; //possibly add print statement here, not sure if this should be handled in the Bust or here, will come back
                System.out.println("Ouch! You sunk " + name + ": ( ");
            } else {
                result = "hit";
            }
        }
        return result;
    }
}
