package org.wecancodeit.reviewssitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookReview {
	
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String review;

	@SuppressWarnings("unused")
	private BookReview() {

	}

	public BookReview(String title, String review) {
		this.title = title;
		this.review = review;
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

}
