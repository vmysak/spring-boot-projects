package org.zeksa.hibernate.labs.service;

import org.zeksa.hibernate.labs.model.Message;

import java.util.Collection;

public interface MessageService {

	Collection<Message> findByAuthor(String name);

	Message save(Message message);
}
