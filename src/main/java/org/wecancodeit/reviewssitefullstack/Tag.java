package org.wecancodeit.reviewssitefullstack;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String type;

	@ManyToMany(mappedBy = "tags")
	private Collection<BookReview> books;

	@SuppressWarnings("unused")
	private Tag() {
	}

	public Tag(String type) {
		this.type = type;
	}

	public Tag(String type, BookReview... books) {
		this.type = type;
		this.books = new HashSet<>(Arrays.asList(books));
	}

	public String getTag() {

		return type;
	}

	public long getId() {

		return id;
	}

	public Collection<BookReview> getBooks() {
		return books;
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
		Tag other = (Tag) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tag [type=" + type + "]";
	}

	
	
}
