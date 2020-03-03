package com.springdemo.mvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> languageOptions;
	private ArrayList<String> OsOptions;
	
	
	public Student() {
		// populate country otpion: used ISO country code
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("CA", "Canada");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("JP", "Japan");
		countryOptions.put("US", "United States of America");
		
		languageOptions = new LinkedHashMap<String, String>();
		languageOptions.put("Java", "Java");
		languageOptions.put("C#", "C#");
		languageOptions.put("PHP","PHP");
		languageOptions.put("Ruby", "Ruby");
		languageOptions.put("Python", "Python");
		
		OsOptions = new ArrayList<String>();
		OsOptions.add("MS Windows");
		OsOptions.add("Linux");
		OsOptions.add("Mac");
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public ArrayList<String> getOsOptions() {
		return OsOptions;
	}

	
	
	
}
