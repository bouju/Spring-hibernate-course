package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	
	public TennisCoach() {
	}


	@Override
	public String getDailyWorkout() {
		
		return "Pratice your backhand volley";
	}



	@Override
	public String getDailyfortune() {
		return fortuneService.getFortune();
	}
	
	

}
