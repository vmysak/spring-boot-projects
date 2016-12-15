package org.zeksa.springcore.resources._2;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.zeksa.springcore.beans._2.UserCache;
import org.zeksa.springcore.beans._2.UserCacheDTO;
import org.zeksa.springcore.resources.ResourceAbstractTest;
import org.zeksa.springcore.resources.TestStopwatch;
import org.zeksa.springcore.resources.json.JsonSerializer;
import org.zeksa.springcore.server.SpringCoreAppServer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringCoreAppServer.class)
@WebIntegrationTest
public class Resource2Test extends ResourceAbstractTest {

    private static final Logger LOG = LoggerFactory.getLogger(Resource2Test.class);
    private static final String SUPERUSER = "superuser";
    private static final String DATA = "data";
    private static int count = 5000;
    @Rule
    public TestStopwatch stopwatch = new TestStopwatch();
    private RestTemplate restTemplate = new TestRestTemplate();
    private List<UserCacheDTO> requests;
    @Autowired
    private UserCache userCache;

    @Before
    public void initTestData() {
        requests = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            UserCacheDTO request = new UserCacheDTO();
            request.setUserName(SUPERUSER);
            request.setData(DATA + i);
            requests.add(request);
        }
    }

    @Test
    public void testAddUserData() throws JsonProcessingException {
        requests.parallelStream().forEach(this::callREST);

        assertEquals(count, userCache.counter());
        assertEquals(count, requests.size());
        assertEquals(0, filterOutOfList(SUPERUSER).size());
        assertEquals(count, userCache.size(SUPERUSER));
        
        stopwatch.runtime(SECONDS);
    }

    private void callREST(UserCacheDTO request) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(JsonSerializer.toJson(request), requestHeaders);
        restTemplate.postForLocation(getResourceContextURL() + "cache", httpEntity);
    }

    private List<String> filterOutOfList(String userName) {
        List<String> filtered = getValuesList();
        filtered.removeAll(userCache.get(userName));
        return filtered;
    }

    private List<String> getValuesList() {
        return requests.stream().map(this::getData).collect(Collectors.toList());
    }

    private String getData(UserCacheDTO dto) {
        return dto.getData();
    }

    private String getResourceContextURL() {
        return StringUtils.join(getContextURL(), "/api/2/");
    }
}
