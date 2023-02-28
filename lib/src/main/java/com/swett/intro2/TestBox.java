package com.swett.intro2;

// JDK 11.x

/****************************************************************************
 * <b>Title:</b> Zoo.java
 * <b>Project:</b> Intro to Programming - Class 2
 * <b>Description:</b> Hello Zoo
 * 
 * This file is for messing around with stuff in CHapter 1 of the OCP book
 * 
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Evan Swett
 * @version 3.0
 * @since 02/20/2023
 *        <b>updates:</b>
 * 
 ****************************************************************************/
public class TestBox {
	private Integer i;
	private int j;

	public static void main(String[] args) {
		TestBox t = new TestBox();
		t.go();
	}

	public void go() {
		j = i;
		System.out.println(j);
		System.out.println(i);
	}
}