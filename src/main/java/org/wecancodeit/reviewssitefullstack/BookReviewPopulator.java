package org.wecancodeit.reviewssitefullstack;

import java.util.Date;

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
	
	@Resource
	CommentRepository commentRepo;

	@Override
	public void run(String... args) throws Exception {
		Category fiction = categoryRepo.save(new Category("Fiction"));
		Category nonfiction = categoryRepo.save(new Category("Non-Fiction"));

		Tag action = new Tag("Action");
		action = tagRepo.save(action);
		Tag romance = new Tag("Romance");
		romance = tagRepo.save(romance);

		BookReview	road = bookReviewRepo.save(new BookReview("The Road",
				"Its a dark gloomy post apocalyptic book, full of saddness. Just watch the Movie. Its better.", fiction,
				"/images/theroad.jpg", action, romance));
		bookReviewRepo.save(new BookReview("The Mist",
				"People get trapped in a convinence store by a thick mist full of creatures from another dimension. Again the Movie was better as long as you watch it in black and white.",
				fiction, "/images/themist.jpg", action));

		bookReviewRepo.save(new BookReview("The Tao of Pooh",
				"A light hearted approach to Taoism through the eyes of Winnie the Pooh", nonfiction,
				"/images/theTaoOfPooh_.jpg", romance));
		bookReviewRepo.save(new BookReview("The Tipping Point",
				"In interesting look at how  ideas, products, messages and behaviors spread just like viruses do .",
				nonfiction, "/images/theTippingPoint.jpg", romance));

		Date date = new Date();
		Comment comment1 = new Comment(date, "",  road);
		comment1 = commentRepo.save(comment1);
	}

}
