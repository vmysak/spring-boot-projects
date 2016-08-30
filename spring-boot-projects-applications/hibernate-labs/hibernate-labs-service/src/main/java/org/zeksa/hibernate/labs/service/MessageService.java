package org.zeksa.hibernate.labs.service;

import org.zeksa.hibernate.labs.model.MessageDTO;

import java.util.Collection;

public interface MessageService {

	Collection<MessageDTO> findByAuthor(String name);

	MessageDTO save(MessageDTO message);
}
