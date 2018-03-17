package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Date;

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
	
	@Resource
	private CommentRepository commentRepo;

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
	public void shouldSaveCategoryToBookRelationship() {
		Category genre = categoryRepo.save(new Category("Fiction"));
		BookReview book = new BookReview("The Road", "It was Dark", genre);
		book = bookReviewRepo.save(book);
		long bookId = book.getId();

		entityManager.flush();
		entityManager.clear();

		book = bookReviewRepo.findOne(bookId);

		assertThat(book.getCategory(), is(genre));
	}
	
	@Test
	public void shouldSaveTagsToBookRelationship() {
		Tag action = tagRepo.save(new Tag("Action"));
		Tag adventure = tagRepo.save(new Tag("Adventure"));
		Category genre = categoryRepo.save(new Category("Fiction"));
		
		BookReview lotr = new BookReview("LOTR", "Lots of walking", genre, action, adventure);
		lotr = bookReviewRepo.save(lotr);
		long bookReviewId = lotr.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		lotr = bookReviewRepo.findOne(bookReviewId);
		assertThat(lotr.getTags(), containsInAnyOrder(action, adventure));
	}
	
	@Test
	public void shouldSaveCommentsToBookRelationship() {
		Date date = new Date();
		Tag action = tagRepo.save(new Tag("Action"));
		Tag adventure = tagRepo.save(new Tag("Adventure"));
		Category genre = categoryRepo.save(new Category("Fiction"));
		BookReview lotr = new BookReview("LOTR", "Lots of walking", genre, action, adventure);
		lotr = bookReviewRepo.save(lotr);
		
		Comment comment = commentRepo.save(new Comment(date, "it was long", lotr));
		long commentId = comment.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		comment = commentRepo.findOne(commentId);
		assertThat(comment.getReview(), is(lotr));
	}
}
