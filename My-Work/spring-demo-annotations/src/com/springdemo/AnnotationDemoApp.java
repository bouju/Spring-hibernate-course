package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring config fle
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// getthe bean from spring container
		
		Coach tennisCoach = context.getBean("tennisCoach",Coach.class);
		Coach esportCoach = context.getBean("esportCoach",Coach.class);
		
		// call a method on the bean
		System.out.println("Tennis coach: " + tennisCoach.getDailyWorkout());
		
		
		System.out.println("Esport coach: " + esportCoach.getDailyWorkout());
		// close the context
		context.close();
	}

}
