package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
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
