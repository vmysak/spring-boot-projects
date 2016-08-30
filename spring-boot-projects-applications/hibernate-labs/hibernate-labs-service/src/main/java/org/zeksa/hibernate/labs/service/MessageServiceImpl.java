package org.zeksa.hibernate.labs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeksa.hibernate.labs.assembler.MessageAssembler;
import org.zeksa.hibernate.labs.model.Message;
import org.zeksa.hibernate.labs.model.MessageDTO;
import org.zeksa.hibernate.labs.repository.MessageRepository;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository messageRepository;

	@Override
	public List<MessageDTO> findByAuthor(String authorId) {
		List<Message> messages = (List<Message>) messageRepository.findByAuthorId(authorId);
		return MessageAssembler.toDTOList(messages);
	}

	@Override
	public MessageDTO save(MessageDTO dto) {
        Message message=MessageAssembler.fromDTO(dto);
		Message savedMessage=messageRepository.save(message);
		return MessageAssembler.toDTO(savedMessage);
	}
}
