package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config fle
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// getthe bean from spring container
		
		Coach tennisCoach = context.getBean("tennisCoach",Coach.class);
		EsportCoach esportCoach = context.getBean("esportCoach",EsportCoach.class);
		
		// call a method on the bean
		System.out.println("Tennis coach: " + tennisCoach.getDailyWorkout());
		System.out.println("\t - " + tennisCoach.getDailyfortune());
		System.out.println();
		
		System.out.print("Esport coach: " + esportCoach.getDailyWorkout());
		System.out.println(" ("+ esportCoach.getGame()+" - "+ esportCoach.getMaximumCachPrize()+") ");
		System.out.println("\t - " + esportCoach.getDailyfortune());
		System.out.println();
		// close the context
		context.close();
	}

}
