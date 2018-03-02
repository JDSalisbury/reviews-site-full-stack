package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewSiteMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadTags() {
		Tag tags = new Tag("Action/Adventure");
		tags = tagRepo.save(tags);
		long tagId = tags.getId();

		entityManager.flush();
		entityManager.clear();

		tags = tagRepo.findOne(tagId);

		assertThat(tags.getTag(), is("Action/Adventure"));
	}
}
