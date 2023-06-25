package com.mikt.rockpaperscissors;

import com.mikt.rockpaperscissors.models.HandType;
import com.mikt.rockpaperscissors.dots.PlayRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getRulesTest() {
        webTestClient.get()
                .uri("api/game/rules")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.rulesMap").isMap();
    }

    @Test
    public void playGameTest() {
        PlayRequest playRequest = new PlayRequest();
        playRequest.setHand(HandType.valueOf("ROCK"));

        webTestClient.post()
                .uri("api/game/play")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(playRequest)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.result").isNotEmpty()
                .jsonPath("$.computerHand").isNotEmpty()
                .jsonPath("$.rule").isEmpty();
    }

    @Test
    public void playGameWithExplainTest() {
        PlayRequest playRequest = new PlayRequest();
        playRequest.setHand(HandType.valueOf("SCISSORS"));

        webTestClient.post()
                .uri("api/game/play?explain=true")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(playRequest)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.result").isNotEmpty()
                .jsonPath("$.computerHand").isNotEmpty()
                .jsonPath("$.rule").isNotEmpty();
    }
}
