package org.zeksa.hibernate.labs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zeksa.hibernate.labs.model.MessageDTO;
import org.zeksa.hibernate.labs.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageRestController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public
    @ResponseBody
    MessageDTO save(@RequestBody MessageDTO message) {
        return messageService.save(message);
    }

    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<MessageDTO> findByAuthor(@PathVariable String authorId) {
        return messageService.findByAuthor(authorId);
    }
}
