package org.wecancodeit.reviewssitefullstack;


import java.util.Collection;
import java.util.HashSet;
import static java.util.Arrays.asList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;
	private String genre;

	@OneToMany(mappedBy = "genre")
	private Collection<BookReview> books;

	@SuppressWarnings("unused")
	private Category() {
	}

	public Category(String genre) {
		this.genre = genre;
	}
	
	public Category(String genre, BookReview...books) {
		this.genre = genre;
		this.books = new HashSet<>(asList(books));
	}
	
	public String getCategory() {
		return genre;
	}

	public long getId() {
		return id;
	}
	
	public Collection<BookReview> getBooks(){
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [genre=" + genre + "]";
	}

	
	
}
