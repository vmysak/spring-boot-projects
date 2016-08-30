package org.zeksa.hibernate.labs.assembler;

import org.zeksa.hibernate.labs.model.Message;
import org.zeksa.hibernate.labs.model.MessageDTO;

import java.util.Collections;
import java.util.List;

public class MessageAssembler {

    public static MessageDTO toDTO(Message message) {
        MessageDTO dto = new MessageDTO();
        dto.setAuthor(message.getAuthor());
        dto.setText(message.getText());

        return dto;
    }

    public static List<MessageDTO> toDTOList(List<Message> messages) {
        List<MessageDTO> dtoList = Collections.emptyList();

        for (Message message : messages) {
            MessageDTO dto = new MessageDTO();
            dto.setAuthor(message.getAuthor());
            dto.setText(message.getText());
            dtoList.add(dto);
        }

        return dtoList;
    }

    public static Message fromDTO(MessageDTO dto) {
        Message message = new Message();
        message.setText(dto.getText());
        message.setAuthor(dto.getAuthor());

        return message;
    }

    public static List<Message> fromDTOList(List<MessageDTO> dtos) {
        List<Message> messages = Collections.emptyList();

        for (MessageDTO dto : dtos) {
            Message message = new Message();
            message.setText(dto.getText());
            message.setAuthor(dto.getAuthor());
            messages.add(message);
        }

        return messages;
    }
}
