package org.zeksa.springcore.resources._2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.zeksa.springcore.resources.ResourceAbstractTest;
import org.zeksa.springcore.resources.TestStopwatch;
import org.zeksa.springcore.server.SpringCoreAppServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringCoreAppServer.class)
@WebIntegrationTest
public class Resource2Test extends ResourceAbstractTest {

    private static final Logger LOG = LoggerFactory.getLogger(Resource2Test.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String SUPERUSER = "superuser";
    private static final String NAME = "userName";
    private static final String DATA = "data";
    private static final String OK = "OK";
    private static int count = 5000;
    @Rule
    public TestStopwatch stopwatch = new TestStopwatch();
    private RestTemplate restTemplate = new TestRestTemplate();
    private List<Map<String, String>> requests;
    @Autowired
    private UserCache userCache;

    @Before
    public void initTestData() {
        requests = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put(NAME, SUPERUSER);
            requestBody.put(DATA, DATA + i);
            requests.add(requestBody);
        }
    }

    @Test
    public void testAddUserData() throws JsonProcessingException {
        List<String> responses = requests.parallelStream().map(this::callREST).collect(Collectors.toList());
        stopwatch.runtime(SECONDS);

        assertEquals(count, userCache.counter());
        assertEquals(count, requests.size());
        assertEquals(count, responses.size());
        assertEquals(0, filterOutOfList(SUPERUSER).size());
        assertEquals(count, userCache.size(SUPERUSER));
        responses.forEach(resp -> assertEquals(resp, OK));
    }

    private String callREST(Map<String, String> request) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        try {
            HttpEntity<String> httpEntity;
            httpEntity = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(request), requestHeaders);
            restTemplate.postForLocation(getResourceContextURL() + "cache", httpEntity);
        } catch (JsonProcessingException e) {
            LOG.error("JSON error", e);
            return "";
        }
        return OK;
    }

    private List<String> filterOutOfList(String userName) {
        List<String> filtered = getValuesList();
        filtered.removeAll(userCache.get(userName));
        return filtered;
    }

    private List<String> getValuesList() {
        return requests.stream().map(this::getData).collect(Collectors.toList());
    }

    private String getData(Map<String, String> map) {
        return map.get(DATA);
    }

    private String getResourceContextURL() {
        return StringUtils.join(getContextURL(), "/api/2/");
    }
}
