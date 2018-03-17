package org.wecancodeit.reviewssitefullstack;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	
	@Lob
	private String comment;
	
	@ManyToOne
	private BookReview review;

	protected Comment(){
		
	}
	
	public Comment(Date date, String comment, BookReview review) {
		this.date = date;
		this.comment = comment;
		this.review = review;
	}

	public Date getDate() {
		return date;
	}

	public String getComment() {
		return comment;
	}

	public BookReview getReview() {
		return review;
	}
	
	public Long getId() {
		return id;  
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
