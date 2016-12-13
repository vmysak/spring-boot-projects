package org.zeksa.springcore.beans._1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingServiceImpl implements LoggingService {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingServiceImpl.class);

    public void log(String msg) {
        LOG.info(msg);
    }
}
