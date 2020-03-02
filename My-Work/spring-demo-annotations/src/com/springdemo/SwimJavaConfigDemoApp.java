package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config fle
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		
		SwimCoach swimCoach = context.getBean("swimCoach",SwimCoach.class);
		
		// call a method on the bean
		System.out.println("Tennis coach: " + swimCoach.getDailyWorkout());
		System.out.println("\t - " + swimCoach.getDailyfortune());
		System.out.println(" (" + swimCoach.getEmail()+" - "+ swimCoach.getTeam() + ")");
		System.out.println();
		
		// close the context
		context.close();
	}

}
