package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HorseConfig {
	
	@Bean
	public FortuneService fortuneService() {
		return new HorseFortune();
	}
	
	@Bean
	public Coach horseCoach() {
		return new HorseRidingCoach(fortuneService());
	}

}
