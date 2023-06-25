package com.mikt.rockpaperscissors.services;

import com.mikt.rockpaperscissors.dots.PlayRequest;
import com.mikt.rockpaperscissors.dots.PlayResponse;
import com.mikt.rockpaperscissors.dots.RulesResponse;
import com.mikt.rockpaperscissors.models.HandType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@NoArgsConstructor
public class GameService {


    public RulesResponse getRules() {
        Map<String, String> rules = new HashMap<>(3);
        rules.put("ROCK", "Rock beats Scissors");
        rules.put("PAPER", "Paper beats Rock");
        rules.put("SCISSORS", "Scissors beats Paper");
        return new RulesResponse(rules);
    }

    public PlayResponse playGame(PlayRequest playRequest, boolean explain) {
        HandType userHand = playRequest.getHand();
        HandType computerHand = HandType.getRandomHand();
        String result = determineResult(userHand.toString(), computerHand.toString());
        String rule = explain ? determineRule(userHand.toString(), computerHand.toString()) : null;

        return new PlayResponse(result, computerHand, rule);
    }

    //------------------------------------- HELPERS ------------------------------------------

    private String determineResult(String userHand, String computerHand) {
        if (userHand.equals(computerHand)) {
            return "Draw";
        } else if ((userHand.equalsIgnoreCase("rock") && computerHand.equalsIgnoreCase("scissors")) ||
                (userHand.equalsIgnoreCase("scissors") && computerHand.equalsIgnoreCase("paper")) ||
                (userHand.equalsIgnoreCase("paper") && computerHand.equalsIgnoreCase("rock"))) {
            return "Win";
        } else {
            return "Lose";
        }
    }

    private String determineRule(String userHand, String computerHand) {
        if (userHand.equalsIgnoreCase(computerHand)) {
            return "It's a draw.";
        } else if (userHand.equalsIgnoreCase("Rock")) {
            return computerHand.equalsIgnoreCase("Scissors") ? "Rock beats Scissors" : "Paper beats Rock";
        } else if (userHand.equalsIgnoreCase("Paper")) {
            return computerHand.equalsIgnoreCase("Rock") ? "Paper beats Rock" : "Scissors beats Paper";
        } else {
            return computerHand.equalsIgnoreCase("Paper") ? "Scissors beats Paper" : "Rock beats Scissors";
        }
    }

}
