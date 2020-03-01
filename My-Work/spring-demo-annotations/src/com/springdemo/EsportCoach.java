package com.springdemo;

import org.springframework.stereotype.Component;

@Component
public class EsportCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "Train your APM";
	}

}
