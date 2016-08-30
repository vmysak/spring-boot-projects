package org.zeksa.hibernate.labs.service;

import org.zeksa.hibernate.labs.model.MessageDTO;

import java.util.Collection;
import java.util.List;

public interface MessageService {

	List<MessageDTO> findByAuthor(String author);

	MessageDTO save(MessageDTO message);
}
