package com.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Value("${fortune.list}")
	private String fortunes;
	
	private String[] splitFortunes;
	
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		splitFortunes= fortunes.split(",");
		int indexOfFortune = myRandom.nextInt(splitFortunes.length);
		return splitFortunes[indexOfFortune];
	}

}
