package com.blackjack;

public class RandomIntGenerator {

    private static final int min = 0;
    private static final int max = 51;



    public int randomIndex() {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);

    }

}