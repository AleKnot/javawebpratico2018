package br.com.voffice.cinema.domain;

import java.time.LocalDate;

public class Movie {

	private Long id;
	private String title;
	private LocalDate releasedDate;
	private double budget;
	private String poster;

	public Movie(String title, LocalDate releasedDate, double budget, String poster) {
		this.id = System.currentTimeMillis();
		this.title = title;
		this.releasedDate = releasedDate;
		this.budget = budget;
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	public double getBudget() {
		return budget;
	}

	public String getPoster() {
		return poster;
	}

	public Long getId() {
		return id;
	}

	public String getKey() {
		return String.format("%s-%s", getReleasedDate().getYear(), getId());
	}

}
