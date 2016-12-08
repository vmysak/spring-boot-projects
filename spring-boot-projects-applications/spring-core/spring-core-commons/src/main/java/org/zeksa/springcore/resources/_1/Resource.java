package org.zeksa.springcore.resources._1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zeksa.springcore.beans._1.MailService;

@RequestMapping("/api/1")
@RestController
public class Resource {

    private static final Logger LOG = LoggerFactory.getLogger(Resource.class);

    @Autowired
    MailService mailService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public void sendMail(String msg) {
        mailService.sendMail(msg);
    }
}
