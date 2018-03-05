package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;
import java.util.HashSet;
import static java.util.Arrays.asList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class BookReview {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	@Lob
	private String review;
	private String images;
	@ManyToOne
	private Category genre;

	@ManyToMany
	private Collection<Tag> tags;

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

	public BookReview(String title, String review, Category genre, Tag... tags) {
		this.title = title;
		this.review = review;
		this.genre = genre;
		this.tags = new HashSet<>(asList(tags));
	}

	public BookReview(String title, String review, Category genre, String images, Tag... tags) {
		this.title = title;
		this.review = review;
		this.genre = genre;
		this.images = images;
		this.tags = new HashSet<>(asList(tags));

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

	public String getImage() {
		return images;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return " BookReview " + " of " + title;
	}

}
