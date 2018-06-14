package uk.co.maclon.claimant.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import uk.co.maclon.claimant.model.Claimant;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RouterTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void get() {
        webClient.get().uri("/api/claimants")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Claimant.class);
    }
}