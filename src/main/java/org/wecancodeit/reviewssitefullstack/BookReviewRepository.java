package org.wecancodeit.reviewssitefullstack;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookReviewRepository extends CrudRepository<BookReview, Long> {
	BookReview findByTitle(String title);
}
