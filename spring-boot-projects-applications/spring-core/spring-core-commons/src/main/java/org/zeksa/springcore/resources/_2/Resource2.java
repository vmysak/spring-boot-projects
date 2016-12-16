package org.zeksa.springcore.resources._2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zeksa.springcore.beans._2.UserCache;
import org.zeksa.springcore.beans._2.UserCacheDTO;

import java.util.List;

@RequestMapping("/api/2")
@RestController
public class Resource2 {

    private static final Logger LOG = LoggerFactory.getLogger(Resource2.class);

    @Autowired
    UserCache userCache;

    @RequestMapping(value = "/cache", method = RequestMethod.POST)
    public void addToCache(@RequestBody UserCacheDTO data) {
        userCache.put(data);
    }

    @RequestMapping(value = "/cache", method = RequestMethod.GET)
    @ResponseBody
    public List<UserCacheDTO> getFromCache(@RequestBody UserCacheDTO data) {
        return userCache.get(data.getUserName());
    }
}
