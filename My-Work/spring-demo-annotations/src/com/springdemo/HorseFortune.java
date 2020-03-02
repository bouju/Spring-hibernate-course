package com.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HorseFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "K.I.S.S. : Keep It Stupid and Simple !";
	}

}
