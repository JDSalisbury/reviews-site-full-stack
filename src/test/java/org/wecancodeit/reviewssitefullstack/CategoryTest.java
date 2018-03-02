package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CategoryTest {

	@Test
	public void shouldgetCategory() {
		Category underTest = new Category("Fiction");

		String check = underTest.getCategory();
		assertThat(check, is("Fiction"));
	}

}
