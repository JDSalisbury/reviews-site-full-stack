package org.wecancodeit.reviewssitefullstack;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookReviewsRestController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	BookReviewRepository bookReviewRepo;

	@Resource
	CommentRepository commentRepo;

	@Resource
	TagRepository tagRepo;

	@RequestMapping("/delete-tag")
	public String deleteIndvidualTag(@RequestParam Long id, @RequestParam String bookReviewTitle) {
		Logger logger = Logger.getLogger("delete-tag-logger");
		logger.info("Tag id is " + id + ", and review title is " + bookReviewTitle);
		Tag tagRemoval = tagRepo.findOne(id);
		BookReview underReview = bookReviewRepo.findByTitle(bookReviewTitle);
		logger.info(underReview.getBookTitle());
		logger.info(tagRemoval.getTag());

		if (tagRemoval != null) {
			underReview.removeTag(id);
		}
		bookReviewRepo.save(underReview);
		Long animeReviewid = underReview.getId();

		return id.toString();
	}

}
