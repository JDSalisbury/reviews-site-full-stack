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
		
		
		Tag action = new Tag("Action");
		action = tagRepo.save(action);
		Tag romance = new Tag("Romance");
		romance = tagRepo.save(romance);
		
		
		
		bookReviewRepo.save(new BookReview("The Road", "Its a dark gloomy post apocalyptic book, full of saddness. Just watch the Movie. Its better.", fiction, "/images/lotr.jpg" ,action , romance));
		bookReviewRepo.save(new BookReview("The Mist", "People get trapped in a convinence store by a thick mist full of creatures from another dimention. Again the Movie was better as long as you watch it in black and white.", nonfiction,  "/images/starwars.jpg" , action));
		
		bookReviewRepo.save(new BookReview("The Road", "Its a dark gloomy post apocalyptic book, full of saddness. Just watch the Movie. Its better.", fiction, "/images/lotr.jpg" ,action , romance));
		bookReviewRepo.save(new BookReview("The Mist", "People get trapped in a convinence store by a thick mist full of creatures from another dimention. Again the Movie was better as long as you watch it in black and white.", nonfiction,  "/images/starwars.jpg" , action));
		
		
	}

}
