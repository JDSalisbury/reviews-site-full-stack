package org.wecancodeit.reviewssitefullstack;

public class BookReview {

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

}
