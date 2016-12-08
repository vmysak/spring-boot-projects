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
    private LoggingService loggingService;

    public void sendMail(String body) {
        loggingService.log(StringUtils.join("Mail service [", name, "] sending mail: ", body));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoggingService getLoggingService() {
        return loggingService;
    }

    public void setLoggingService(LoggingService loggingService) {
        this.loggingService = loggingService;
    }
}
