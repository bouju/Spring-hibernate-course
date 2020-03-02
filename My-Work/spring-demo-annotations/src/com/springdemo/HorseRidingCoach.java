package com.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HorseRidingCoach implements Coach {

	
	private FortuneService fortuneService;

	public HorseRidingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice leg isolate";
	}

	@Override
	public String getDailyfortune() {
		return fortuneService.getFortune();
	}

}
