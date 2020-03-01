package com.springdemo;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;
	
	public BaseballCoach() {
	}

	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting pactice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get fortune
		return fortuneService.getFortune();
	}
}
