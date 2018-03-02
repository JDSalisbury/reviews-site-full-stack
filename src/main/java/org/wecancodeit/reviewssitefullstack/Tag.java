package org.wecancodeit.reviewssitefullstack;

public class Tag {

	private String type;

	@SuppressWarnings("unused")
	private Tag() {
	}

	public Tag(String type) {
		this.type = type;
	}

	public String getTag() {

		return type;
	}

}
