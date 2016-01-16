package org.zeksa.hibernate.labs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeksa.hibernate.labs.model.Message;
import org.zeksa.hibernate.labs.repository.MessageRepository;

import java.util.Collection;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository messageRepository;

	@Override
	public Collection<Message> findByAuthor(String name) {
		return messageRepository.findByAuthor(name);
	}

	@Override
	public Message save(Message message) {
		return messageRepository.save(message);
	}
}
