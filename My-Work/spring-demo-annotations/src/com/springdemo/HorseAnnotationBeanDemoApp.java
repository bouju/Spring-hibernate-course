package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HorseAnnotationBeanDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(HorseConfig.class);
		
		Coach horseCoach = context.getBean("horseCoach", Coach.class);
		
		System.out.println(horseCoach.getDailyWorkout());
		System.out.println(" - "+ horseCoach.getDailyfortune());
		
		context.close();
		
	}

}
