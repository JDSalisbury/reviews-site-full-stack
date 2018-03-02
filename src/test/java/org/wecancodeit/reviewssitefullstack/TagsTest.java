package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TagsTest {

	@Test
	public void shouldgetTag() {
		Tag underTest = new Tag("Action/Adventure");

		String check = underTest.getTag();
		assertThat(check, is("Action/Adventure"));
	}

}
