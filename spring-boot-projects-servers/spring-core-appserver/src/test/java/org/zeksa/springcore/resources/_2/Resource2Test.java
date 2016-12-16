package org.zeksa.springcore.resources._2;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
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
import org.zeksa.springcore.resources.json.JsonSerializer;
import org.zeksa.springcore.server.SpringCoreAppServer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringCoreAppServer.class)
@WebIntegrationTest
public class Resource2Test extends ResourceAbstractTest {

    private static final Logger LOG = LoggerFactory.getLogger(Resource2Test.class);
    private static final String SUPERUSER = "superuser";
    private static final String DATA = "data";
    private static int count = 5000;
    private RestTemplate restTemplate = new TestRestTemplate();
    private List<RestRequest> requests;
    @Autowired
    private UserCache userCache;

    @Before
    public void initTestData() {
        requests = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            UserCacheDTO data = new UserCacheDTO();
            data.setUserName(SUPERUSER);
            data.setData(DATA + i);
            RestRequest request = createRestRequest(data, RequestType.POST, getResourceContextURL() + "cache");
            requests.add(request);
        }
    }

    @Test
    public void testAddUserData() throws JsonProcessingException {
        requests.parallelStream().forEach(this::callPostRest);

        assertEquals(count, requests.size());
        assertEquals(count, userCache.counter());
        assertEquals(count, userCache.size(SUPERUSER));
    }

    private void callPostRest(RestRequest request) {
        restTemplate.postForLocation(request.getUrl(), request.getRequestEntity());
    }

    private RestRequest createRestRequest(Object data, RequestType requestType, String url) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(JsonSerializer.toJson(data), requestHeaders);
        RestRequest request = new RestRequest();
        request.setRequestType(requestType);
        request.setRequestEntity(httpEntity);
        request.setUrl(url);

        return request;
    }

    private String getResourceContextURL() {
        return StringUtils.join(getContextURL(), "/api/2/");
    }

    private enum RequestType {
        GET, POST
    }

    private class RestRequest {

        private RequestType requestType;
        private HttpEntity requestEntity;
        private String url;

        public RequestType getRequestType() {
            return requestType;
        }

        public void setRequestType(RequestType requestType) {
            this.requestType = requestType;
        }

        public HttpEntity getRequestEntity() {
            return requestEntity;
        }

        public void setRequestEntity(HttpEntity requestEntity) {
            this.requestEntity = requestEntity;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
