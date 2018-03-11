package br.com.pessoa.domain;

import java.time.LocalDate;

public class Pessoa {

	private Long id;
	private String name;
	private LocalDate bithDate;
	private double identification;
	private String picture;

	// construtor
	public Pessoa(String name, LocalDate birthDate, double identification, String picture) {
		this.id = System.currentTimeMillis();
		this.name = name;
		this.bithDate = birthDate;
		this.identification = identification;
		this.picture = picture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBithDate() {
		return bithDate;
	}

	public void setBithDate(LocalDate bithDate) {
		this.bithDate = bithDate;
	}

	public double getIdentification() {
		return identification;
	}

	public void setIdentification(double identification) {
		this.identification = identification;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
