package org.wecancodeit.reviewssitefullstack;

public class Category {

	private String genre;

	@SuppressWarnings("unused")
	private Category() {
	}

	public Category(String genre) {
		this.genre = genre;
	}

	public String getCategory() {
		return genre;
	}

}
