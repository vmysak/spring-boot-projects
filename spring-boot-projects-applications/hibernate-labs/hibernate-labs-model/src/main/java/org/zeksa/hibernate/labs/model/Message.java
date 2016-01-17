package org.zeksa.hibernate.labs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Message {

	@Id
	@TableGenerator(name = "TABLE_MESSAGE_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
			valueColumnName = "SEQ_COUNT", pkColumnValue = "EMP_SEQ")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_MESSAGE_GEN")
	@Getter
	private Long id;

	@Getter
	@Setter
	private String author;

	@Getter
	@Setter
	private String text;

	public Message() {
	}

	public Message(String author, String text) {
		this.text = text;
		this.author=author;
	}

}
