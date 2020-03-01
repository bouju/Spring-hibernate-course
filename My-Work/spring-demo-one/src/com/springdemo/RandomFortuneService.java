package com.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String[] listOfFortune = {
			"Tant qu'il y a de la vie, il y a de l'espoir",
			"L�avenir appartient � ceux qui se l�vent t�t.",
			"On n'est pas le meilleur quand on le croit, mais quand on le sait.",
			"Il y a une diff�rence entre connaitre le chemin et l'arpenter."
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(listOfFortune.length);
		return listOfFortune[index];
	}

}
