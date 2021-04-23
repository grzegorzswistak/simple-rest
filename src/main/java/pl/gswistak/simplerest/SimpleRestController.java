package pl.gswistak.simplerest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.invoke.MethodHandles;

@RestController
public class SimpleRestController {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/")
    public String test() {
        LOG.info("test");

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://liveobjects.orange-business.com/api/v0/whoami";
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            LOG.info(exchange.getBody());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return "OK";
    }
}
