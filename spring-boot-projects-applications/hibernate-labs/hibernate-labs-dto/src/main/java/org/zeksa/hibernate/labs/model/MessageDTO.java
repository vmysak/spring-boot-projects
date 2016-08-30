package org.zeksa.hibernate.labs.model;

import lombok.Getter;
import lombok.Setter;

public class MessageDTO {

	@Getter
	@Setter
	private String author;

	@Getter
	@Setter
	private String text;
}
