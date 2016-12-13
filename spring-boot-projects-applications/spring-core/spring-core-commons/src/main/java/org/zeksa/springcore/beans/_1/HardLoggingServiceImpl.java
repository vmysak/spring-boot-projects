package org.zeksa.springcore.beans._1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HardLoggingServiceImpl implements LoggingService {

    private static final Logger LOG = LoggerFactory.getLogger(HardLoggingServiceImpl.class);

    public void log(String msg) {
        LOG.info("HardLogging:");
        LOG.info(msg);
    }
}
