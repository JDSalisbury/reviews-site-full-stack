package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;

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

		Tag tagRemoval = tagRepo.findOne(id);
		BookReview underReview = bookReviewRepo.findByTitle(bookReviewTitle);

		if (tagRemoval != null) {
			underReview.removeTag(id);
		}
		bookReviewRepo.save(underReview);

		return id.toString();
	}

	@RequestMapping("/add-tag")
	public Tag addTag(@RequestParam String tagName, @RequestParam String bookReviewTitle) {
		BookReview underReview = bookReviewRepo.findByTitle(bookReviewTitle);
		Tag tagToAdd = tagRepo.findByType(tagName);
		// creating relationship with BookReview
		if (tagToAdd == null) {
			tagToAdd = new Tag(tagName, underReview);
			tagRepo.save(tagToAdd);
			underReview.setTag(tagToAdd);
			bookReviewRepo.save(underReview);
		}

		return tagToAdd;
	}

}
