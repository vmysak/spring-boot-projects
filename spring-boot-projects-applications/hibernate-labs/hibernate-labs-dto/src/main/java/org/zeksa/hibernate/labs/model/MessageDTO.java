package org.zeksa.hibernate.labs.model;

import lombok.Getter;
import lombok.Setter;

public class MessageDTO {

	@Getter
	@Setter
	private String authorId;

	@Getter
	@Setter
	private String text;
}
