package com.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		// create the object
		Coach theCoach = new TrackmaniaCoach();
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());
	}

}
