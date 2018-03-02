package org.wecancodeit.reviewssitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;
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

	public long getId() {
		return id;
	}

}
