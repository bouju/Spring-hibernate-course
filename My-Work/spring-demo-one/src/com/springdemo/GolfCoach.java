package com.springdemo;

public class GolfCoach implements Coach {

	private FortuneService fortuneService;

	public GolfCoach(FortuneService theFortuneservice) {
		fortuneService = theFortuneservice;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice Practice :p";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get fortune
		return fortuneService.getFortune();
	}

}
