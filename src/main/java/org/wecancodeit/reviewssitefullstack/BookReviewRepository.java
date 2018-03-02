package org.wecancodeit.reviewssitefullstack;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookReviewRepository extends CrudRepository<BookReview, Long> {
	List<BookReview> findByTitle(String title);
}
