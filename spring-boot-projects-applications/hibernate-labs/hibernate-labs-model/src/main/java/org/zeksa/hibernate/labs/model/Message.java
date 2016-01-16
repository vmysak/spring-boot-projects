package org.zeksa.hibernate.labs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue
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
