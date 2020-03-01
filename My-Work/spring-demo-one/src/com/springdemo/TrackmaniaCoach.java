package com.springdemo;

public class TrackmaniaCoach implements Coach {

	private FortuneService fortuneService;
	
	
	
	public TrackmaniaCoach() {
	}

	public TrackmaniaCoach(FortuneService theFortuneservice) {
		fortuneService = theFortuneservice;
	}
	
	@Override
	public String getDailyWorkout() {

		return "Practice Rammstein into B2 expand !";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get fortune
		return fortuneService.getFortune();
	}

}
