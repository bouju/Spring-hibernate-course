package com.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Value("${fortune.list}")
	private String fortunes;
	
	private String[] splitFortunes;
	
	private Random myRandom = new Random();

	@PostConstruct
	private void init() {
		splitFortunes= fortunes.split(",");
	}
	
	@Override
	public String getFortune() {
		int indexOfFortune = myRandom.nextInt(splitFortunes.length);
		return splitFortunes[indexOfFortune];
	}

}
