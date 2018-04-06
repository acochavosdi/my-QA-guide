package com.emergya.utils;

public class UserBean {

	private String name;
	private String lastName;
	private String adress;
	private String phone;
	private String email;
	private String gender;
	private String[] hobbies;
	private String[] languages;
	private String skills;
	private String country;
	private String secondCountryTextEntry;
	private String secondCountryChoose;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String password;
	private String passwordVerified;

	public UserBean(String name, String lastName, String adress, String phone, String email, String gender,
			String[] hobbies, String[] languages, String skills, String country, String secondCountryTextEntry,
			String secondCountryChoose, String birthYear, String birthMonth, String birthDay, String password,
			String passwordVerified) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.hobbies = hobbies;
		this.languages = languages;
		this.skills = skills;
		this.country = country;
		this.secondCountryTextEntry = secondCountryTextEntry;
		this.secondCountryChoose = secondCountryChoose;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.password = password;
		this.passwordVerified = passwordVerified;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAdress() {
		return adress;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public String[] getLanguages() {
		return languages;
	}

	public String getSkills() {
		return skills;
	}

	public String getCountry() {
		return country;
	}

	public String getSecondCountryTextEntry() {
		return secondCountryTextEntry;
	}

	public String getSecondCountryChoose() {
		return secondCountryChoose;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordVerified() {
		return passwordVerified;
	}

}
