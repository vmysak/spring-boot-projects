package org.zeksa.springcore.beans._1;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailService {

    @Value("${mailservice.name}")
    private String name;
    @Autowired
    private LoggingService loggingServiceImpl;

    public void sendMail(String body) {
        loggingServiceImpl.log(StringUtils.join("Mail service [", name, "] sending mail: ", body));
    }
}
