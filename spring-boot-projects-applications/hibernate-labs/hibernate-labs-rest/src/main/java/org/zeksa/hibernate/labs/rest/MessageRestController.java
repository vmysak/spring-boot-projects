package org.zeksa.hibernate.labs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zeksa.hibernate.labs.model.Message;
import org.zeksa.hibernate.labs.service.MessageService;

@RestController
@RequestMapping("/api/message")
public class MessageRestController {

	@Autowired
	MessageService messageService;

	@RequestMapping(value = "/random", method = RequestMethod.POST)
	public void random() {
		messageService.save(new Message("aa", "rand"));
	}
}
