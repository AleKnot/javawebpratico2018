package br.com.bootsandbox.bean;

public class Movie {
	
	public Movie(String title, String releasedDate) {
		super();
		this.title = title;
		this.releasedDate = releasedDate;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", releasedDate=" + releasedDate + "]";
	}

	private String title;
	private String releasedDate;

	public String getReleasedDate() {
		return releasedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setReleasedDate(String releasedDate) {
		this.releasedDate = releasedDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
