package com.mikt.rockpaperscissors.models;

import java.util.Random;

public enum HandType {
    ROCK, PAPER, SCISSORS;

    public static HandType getRandomHand() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
