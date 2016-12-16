package org.zeksa.springcore.beans._2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class UserCache {

    private static final Logger LOG = LoggerFactory.getLogger(UserCache.class);
    private final Object cacheMonitor = new Object();

    private Map<String, List<String>> cache;
    private AtomicInteger counter;

    @PostConstruct
    public void init() {
        cache = new ConcurrentHashMap<>();
        counter = new AtomicInteger(0);
    }

    public void put(UserCacheDTO data) {
        if (data != null) {
            String userName = data.getUserName();
            String userData = data.getData();

            List<String> list;
            synchronized (cacheMonitor) {
                list = cache.get(userName);
                if (list == null) {
                    list = new CopyOnWriteArrayList<>();
                    cache.put(userName, list);
                }
            }
            list.add(userData);
        }
        counter.incrementAndGet();
    }

    public List<UserCacheDTO> get(String userName) {
        return cache.get(userName).parallelStream().map(data -> toUserCacheDTO(data, userName)).collect(Collectors.toList());
    }

    private UserCacheDTO toUserCacheDTO(String data, String userName){
        UserCacheDTO userCache = new UserCacheDTO();
        userCache.setData(data);
        userCache.setUserName(userName);
        return userCache;
    }

    public int size(String userName) {
        return cache.get(userName).size();
    }

    public int counter() {
        return counter.get();
    }
}
