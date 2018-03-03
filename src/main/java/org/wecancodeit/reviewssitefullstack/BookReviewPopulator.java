package org.wecancodeit.reviewssitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookReviewPopulator implements CommandLineRunner {
	
	@Resource
	private TagRepository tagRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private BookReviewRepository bookReviewRepo;

	@Override
	public void run(String... args) throws Exception {
		Category fiction = categoryRepo.save(new Category("Fiction"));
		Category nonfiction = categoryRepo.save(new Category("Non-Fiction"));
		Category tacos = categoryRepo.save(new Category("Tacos"));
		
		Tag action = new Tag("Action");
		action = tagRepo.save(action);
		Tag romance = new Tag("Romance");
		romance = tagRepo.save(romance);
		
		
		
		bookReviewRepo.save(new BookReview("LOTR", "Its long", fiction, action, romance));
		bookReviewRepo.save(new BookReview("Star Wars", "Sound shouldnt be in space", fiction, action));
		
		
	}

}
