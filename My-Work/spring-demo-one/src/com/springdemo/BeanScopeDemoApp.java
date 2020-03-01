package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if they are the same
		boolean result = (myCoach == alphaCoach);
		
		// print out the result
		System.out.println("\nPointing to the same object: "+ result);
		
		System.out.println("\n Memory location for theCoach: "+ myCoach);
		System.out.println("\n Memory location for alphaCoach: "+ alphaCoach+"\n");
		
		// close the context
		context.close();
	}

}
