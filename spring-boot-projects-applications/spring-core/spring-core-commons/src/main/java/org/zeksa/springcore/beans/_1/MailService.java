package org.zeksa.springcore.beans._1;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class MailService {

    private String name;
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
