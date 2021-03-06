package org.wecancodeit.reviewssitefullstack;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookReviewsController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	BookReviewRepository bookReviewRepo;
	
	@Resource
	CommentRepository commentRepo;

	@Resource
	TagRepository tagRepo;

	@RequestMapping("/categories")
	public String getAllCategory(Model model) {
		model.addAttribute("categoriesModel", categoryRepo.findAll());
		return "categoriesList";
	}

	@RequestMapping("/category")
	public String getAllReviews(@RequestParam Long id, Model model) {
		model.addAttribute("categoryModel", categoryRepo.findOne(id));
		return "genre";
	}

	@RequestMapping("/bookReview")
	public String getABookReview(@RequestParam Long id, Model model) {
		model.addAttribute("bookReviewModel", bookReviewRepo.findOne(id));
		return "review";
	}
	
	@RequestMapping("/add-comment")
	public String addComment(String commentText, Long id)
	{
		Date date = new Date();
		BookReview review = bookReviewRepo.findOne(id);
		Comment comment = new Comment(date, commentText, review);
		comment = commentRepo.save(comment); 
		return "redirect:/bookReview?id=" + id;
	}

	@RequestMapping("/tag")
	public String getTagsWithBookReview(@RequestParam Long id, Model model) {
		model.addAttribute("tagModel", tagRepo.findOne(id));
		return "tags";
	}
	
	
	
//	@RequestMapping("/delete-tag")
//	public String deleteIndvidualTag(@RequestParam Long id, @RequestParam String bookReviewTitle) {
//		Logger logger = Logger.getLogger("delete-tag-logger");
//		logger.info("Tag id is " + id + ", and review title is " + bookReviewTitle);
//		Tag tagRemoval = tagRepo.findOne(id);
//		BookReview underReview = bookReviewRepo.findByTitle(bookReviewTitle);
//		logger.info(underReview.getBookTitle());
//		logger.info(tagRemoval.getTag());
//
//		if (tagRemoval != null) {
//			underReview.removeTag(id);
//		}
//		bookReviewRepo.save(underReview);
//		Long animeReviewid = underReview.getId();
//
//		return "redirect:/bookReview?id=" + animeReviewid;
//		
//	}
//	
		
}
