package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EsportCoach implements Coach {

	@Autowired
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {

		return "Train your APM";
	}

	@Override
	public String getDailyfortune() {
		return fortuneService.getFortune();
	}

}
