package org.zeksa.springcore.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/system")
@RestController
public class SystemResource {

    private static final Logger LOG = LoggerFactory.getLogger(SystemResource.class);

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseBody
    public String status() {
        return "OK";
    }
}
