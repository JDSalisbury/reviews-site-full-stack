package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BookReviewTest {

	@Test
	public void shouldgetBookTitle() {
		BookReview underTest = new BookReview("Cat in the Hat", "This book rhymes.");

		String check = underTest.getBookTitle();
		assertThat(check, is("Cat in the Hat"));
	}

	@Test
	public void shouldgetBookReview() {
		BookReview underTest = new BookReview("Cat in the Hat", "This book rhymes.");

		String check = underTest.getBookReview();
		assertThat(check, is("This book rhymes."));
	}
}
