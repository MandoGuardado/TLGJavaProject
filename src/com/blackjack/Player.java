package com.blackjack;

import java.util.List;

public class Player {
    // FIELDS
    private String name;
    private char difficulty;
    private double chips = 200;     // all players created with 200
    private Hand hand = new Hand(); // aced difficulty for now

    private List<String> currentHand;

    // CTORS

    public Player(String name, char difficulty) {
        setName(name);
        setDifficulty(difficulty);

    }

    // Player (name, chips)

    // BUSINESS
    public void hit() {
    }

    public void stand() {
    }

    public void bet() {
    }

    // GETTERS/SETTERS
    // x


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getChips() {
        return chips;
    }

    public List<String> getCurrentHand() {
        return currentHand;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public char getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(char difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return null;
    }
}