package org.wecancodeit.reviewssitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BookReview {
	
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String review;
	@ManyToOne
	private Category genre;
	
	@SuppressWarnings("unused")
	private BookReview() {

	}

	public BookReview(String title, String review) {
		this.title = title;
		this.review = review;
	}

	public BookReview(String title, String review, Category genre) {
		this.title = title;
		this.review = review;
		this.genre = genre;
	}

	public String getBookTitle() {
		return title;
	}

	public String getBookReview() {
		return review;
	}

	public long getId() {
		
		return id;
	}

	public Category getCategory() {
		return genre;
	}

}
