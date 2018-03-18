package org.wecancodeit.reviewssitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jayway.jsonpath.internal.function.json.Append;

@Entity
public class BookReview {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	@Lob
	private String review;
	private String images;

	@OneToMany(mappedBy = "review")
	private Collection<Comment> comments;

	public Collection<Comment> getComments() {
		return comments;
	}

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

	public void  setTag(String name) {
		Tag addedTag = new Tag(name);
		tags.add(addedTag);
	}
	
	public void removeTag(Long id) {
		Tag tagToRemove = null;
		for (Tag tag : tags) {
			if (tag.getId() == id) {
				tagToRemove = tag;
			}
		}
		
		tags.remove(tagToRemove);
	}

	@Override
	public String toString() {
		return " BookReview " + " of " + title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookReview other = (BookReview) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
