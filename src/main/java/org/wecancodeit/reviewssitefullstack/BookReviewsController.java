package org.wecancodeit.reviewssitefullstack;

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
	TagRepository tagRepo;
	
	@RequestMapping("/categories")
	public String getAllCategory(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}
	
	@RequestMapping("/category")
	public String getAllReviews(@RequestParam Long id, Model model) {
		model.addAttribute("category", categoryRepo.findOne(id));
		return "category";
	}
	
	@RequestMapping("/bookReview")
	public String getABookReview(@RequestParam Long id,Model model) {
		model.addAttribute("bookReview", bookReviewRepo.findOne(id));
		return "bookReview";
	}
	
	
}
