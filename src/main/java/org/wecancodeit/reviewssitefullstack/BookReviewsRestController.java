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

		Tag tagRemoval = tagRepo.findOne(id);
		BookReview underReview = bookReviewRepo.findByTitle(bookReviewTitle);

		if (tagRemoval != null) {
			underReview.removeTag(id);
		}
		bookReviewRepo.save(underReview);
		
		return id.toString();
	}
	
	@RequestMapping("/add-tag")
	public String addTag(@RequestParam String tagName, @RequestParam String bookReviewTitle) {
		BookReview underReview = bookReviewRepo.findByTitle(bookReviewTitle);

		if(tagName != null) {
		Tag tagToAdd = new Tag(tagName,underReview); //creating relationship with BookReview
		tagRepo.save(tagToAdd);
		} 
		
		
		return underReview.getBookTitle(); 
	}
	
	

}
