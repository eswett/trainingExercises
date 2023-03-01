package com.swett.intro4;

import java.util.*;


/****************************************************************************
 * <b>Title:</b> StateMap.java
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
 * @since 03/01/2023
 *        <b>updates:</b>
 * 
 ****************************************************************************/
public class StateMap {
    //hashmap used to build original, unordered map
    private Map<String, String> stateMap = new HashMap<>();

    /**
     * Function that add's state names mapped to their state code 
     * @return Map<String, String>
     */
    private Map<String, String> buildMap() {
        stateMap.put("Alabama", "AL");
        stateMap.put("Alaska", "AK");
        stateMap.put("Arizona", "AZ");
        stateMap.put("Arkansas", "AR");
        stateMap.put("California", "CA");
        stateMap.put("Colorado", "CO");
        stateMap.put("Connecticut", "CT");
        stateMap.put("Delaware", "DE");
        stateMap.put("District of Columbia", "DC");
        stateMap.put("Florida", "FL");
        stateMap.put("Georgia", "GA");
        stateMap.put("Hawaii", "HI");
        stateMap.put("Idaho", "ID");
        stateMap.put("Illinois", "IL");
        stateMap.put("Indiana", "IN");
        stateMap.put("Iowa", "IA");
        stateMap.put("Kansas", "KS");
        stateMap.put("Kentucky", "KY");
        stateMap.put("Louisiana", "LA");
        stateMap.put("Maine", "ME");
        stateMap.put("Maryland", "MD");
        stateMap.put("Massachusetts", "MA");
        stateMap.put("Michigan", "MI");
        stateMap.put("Minnesota", "MN");
        stateMap.put("Mississippi", "MS");
        stateMap.put("Missouri", "MO");
        stateMap.put("Montana", "MT");
        stateMap.put("Nebraska", "NE");
        stateMap.put("Nevada", "NV");
        stateMap.put("New Hampshire", "NH");
        stateMap.put("New Jersey", "NJ");
        stateMap.put("New Mexico", "NM");
        stateMap.put("New York", "NY");
        stateMap.put("North Carolina", "NC");
        stateMap.put("North Dakota", "ND");
        stateMap.put("Ohio", "OH");
        stateMap.put("Oklahoma", "OK");
        stateMap.put("Oregon", "OR");
        stateMap.put("Pennsylvania", "PA");
        stateMap.put("Rhode Island", "RI");
        stateMap.put("South Carolina", "SC");
        stateMap.put("South Dakota", "SD");
        stateMap.put("Tennessee", "TN");
        stateMap.put("Texas", "TX");
        stateMap.put("Utah", "UT");
        stateMap.put("Vermont", "VT");
        stateMap.put("Virginia", "VA");
        stateMap.put("Virgin Islands", "VI");
        stateMap.put("Washington", "WA");
        stateMap.put("West Virginia", "WV");
        stateMap.put("Wisconsin", "WI");
        stateMap.put("Wyoming", "WY");
        return stateMap;
    }
    
    /**
     * Takes map and returns it as a treemap
     * @param map
     * @return
     */
    private Map<String, String> reverseMap(Map<String, String> map) {
        return new TreeMap<>(map).descendingMap();
    }

/**
 * 
 * @param args
 */
    public static void main(String[] args) {
        StateMap sm = new StateMap();
        Map<String, String> newMap = sm.buildMap();

        Map<String, String> inorderMap = new TreeMap<>(newMap);
        System.out.println(newMap);
        System.out.println(inorderMap);
        System.out.println(sm.reverseMap(inorderMap));



    }
}
