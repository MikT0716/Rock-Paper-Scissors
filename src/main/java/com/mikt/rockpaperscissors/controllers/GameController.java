package com.mikt.rockpaperscissors.controllers;

import com.mikt.rockpaperscissors.models.HandType;
import com.mikt.rockpaperscissors.dots.PlayRequest;
import com.mikt.rockpaperscissors.dots.PlayResponse;
import com.mikt.rockpaperscissors.dots.RulesResponse;
import com.mikt.rockpaperscissors.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@AllArgsConstructor
public class GameController {

    private GameService service;

    @GetMapping("/rules")
    public RulesResponse getRules() {
        return service.getRules();
    }

    @PostMapping("/play")
    public PlayResponse playGame(@RequestBody PlayRequest playRequest, @RequestParam(required = false) boolean explain) {
        return service.playGame(playRequest, explain);
    }

}
