package com.candidate;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id ;
	private String candidateName;
	private String lastName;
	private String email;
	private Number pinCode;
	private Boolean isActive;
	private Date dob;


	
	
	public Candidate(String candidateName, String lastName, String email, Number pinCode, Boolean isActive, Date dob,
			double pricePerNight, int nbOfNight) {
		super();
		this.candidateName = candidateName;
		this.lastName = lastName;
		this.email = email;
		this.pinCode = pinCode;
		this.isActive = isActive;
		this.dob = dob;
		this.pricePerNight = pricePerNight;
		this.nbOfNight = nbOfNight;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}





	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private double pricePerNight;
	private int nbOfNight;

	public Candidate() {
	}





	public String getCandidateName() {
		return candidateName;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Number getPinCode() {
		return pinCode;
	}

	public void setPinCode(Number pinCode) {
		this.pinCode = pinCode;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getNbOfNight() {
		return nbOfNight;
	}

	public void setNbOfNight(int nbOfNight) {
		this.nbOfNight = nbOfNight;
	}
}
