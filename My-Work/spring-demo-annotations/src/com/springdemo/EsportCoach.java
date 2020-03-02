package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EsportCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Value("${esport.game}")
	private String game;
	
	@Value("${esport.maximumCachPrize}")
	private String maximumCachPrize;

	@Override
	public String getDailyWorkout() {

		return "Train your APM";
	}

	@Override
	public String getDailyfortune() {
		return fortuneService.getFortune();
	}
	
	public String getGame() {
		return game;
	}

	public String getMaximumCachPrize() {
		return maximumCachPrize;
	}


}
