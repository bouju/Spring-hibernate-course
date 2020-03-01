package com.springdemo;

import org.springframework.stereotype.Component;

@Component
public class EsportCoach implements Coach {

	private FortuneService fortuneService;
	
	
	
	public EsportCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Train your APM";
	}

	@Override
	public String getDailyfortune() {
		return fortuneService.getFortune();
	}

}
