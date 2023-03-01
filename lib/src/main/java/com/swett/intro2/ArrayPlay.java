package com.swett.intro2;

// JDK 11.x

/****************************************************************************
 * <b>Title:</b> ArrayPlay.java
 * <b>Project:</b> Intro to Programming - Class 2
 * <b>Description:</b> Anagram Indicie
 * 
 * Populate an array with 10 random integers between 0-99 and print along with corresponding row
 * 
 * 
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Evan Swett
 * @version 3.0
 * @since 02/17/2023
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class ArrayPlay {
	
	private int [] arr;
	
	public static void main(String[] args) {
		ArrayPlay ap = new ArrayPlay();
		ap.printRandomArray();
	}

	/**
	 * Declares an array of size 10, generates random number and assigns it to
	 * first element in array, then prints all
	 * @param none
	 * @return none
	 */
	public void printRandomArray() {
		//set arr size to 10
		//store a random number in index 0
		
		arr = new int[10];
		int randVal = (int) (Math.random() * 100);
		arr[0] = randVal;
		
		//print index and corresponding value
		for(int i = 0; i < arr.length; i++) {
			System.out.println("row: " + i + " holds " + arr[i]);
		}
	}
}
