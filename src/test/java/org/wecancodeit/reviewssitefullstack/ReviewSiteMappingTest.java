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
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private BookReviewRepository bookReviewRepo;

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
	
	@Test
	public void shouldSaveAndLoadCategory() {
		Category genres = new Category("Fiction");
		genres = categoryRepo.save(genres);
		long genresId = genres.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		genres = categoryRepo.findOne(genresId);
		
		assertThat(genres.getCategory(), is("Fiction"));
	}
	
	@Test
	public void shouldSaveAndLoadBookReview() {
		BookReview book = new BookReview("Cat in the Hat", "It rhymes");
		book = bookReviewRepo.save(book); 
		long bookId = book.getId();
		
		entityManager.flush(); 
		entityManager.clear();
		
		book = bookReviewRepo.findOne(bookId);
		assertThat(book.getBookTitle(), is("Cat in the Hat"));
	}
	
	@Test
	public void shouldSaveGenreToBookRelationShip() {
		Category genre = categoryRepo.save(new Category("Fiction"));
		BookReview book = new BookReview("The Road", "It was Dark", genre);
		book = bookReviewRepo.save(book);
		long bookId = book.getId(); 
		
		
		
		
		entityManager.flush(); 
		entityManager.clear();
		
		book = bookReviewRepo.findOne(bookId);

		assertThat(book.getCategory(), is(genre));
	}
	
}
