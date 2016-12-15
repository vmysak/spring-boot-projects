package org.zeksa.springcore.resources;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public abstract class ResourceAbstractTest {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceAbstractTest.class);
    private static final String HTTP = "http://";

    @Value("${server.port}")
    private String serverPort;
    @Value("${server.address}")
    private String serverAddress;
    @Value("${server.context-path}")
    private String contextPath;

    protected String getContextURL() {
        return StringUtils.join(HTTP, serverAddress, ":", serverPort, contextPath);
    }
}
