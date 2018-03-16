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

	@RequestMapping("/tag")
	public String getTagsWithBookReview(@RequestParam Long id, Model model) {
		model.addAttribute("tagModel", tagRepo.findOne(id));
		return "tags";
	}
	
	@RequestMapping("/delete-tag")
	public String deleteIndividualCourse(Long id) {
		categoryRepo.delete(id);
		return "redirect:/review";
	}
	
		
}
