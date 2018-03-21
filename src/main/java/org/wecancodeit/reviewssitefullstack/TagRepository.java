package org.wecancodeit.reviewssitefullstack;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findByType(String type);
}
