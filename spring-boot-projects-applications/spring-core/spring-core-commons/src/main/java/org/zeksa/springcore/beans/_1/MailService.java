package org.zeksa.springcore.beans._1;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class MailService {

    @Value("${mailservice.name}")
    private String name;
    @Autowired
    private LoggingService loggingServiceImpl;
    private String ID = UUID.randomUUID().toString();

    public void sendMail(String body) {
        loggingServiceImpl.log(StringUtils.join("Mail service [", ID,": ", name, "] sending mail: ", body));
    }
}
