package com.blackjack;

import java.util.List;

public class Player {
    // FIELDS
    private String name;
    private char difficulty;
    private long bank = 1000; // or maybe chips. betting point
    private Hand hand = new Hand(); // or Hand. Dealer

    // CTORS

    public Player(String name, char difficulty) {
        setName(name);
        setDifficulty(difficulty);
    }

    /**
     *  do we want to make a Player Factory?
     */

    public Player(String name, double score) {
    }

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

    public char getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(char difficulty) {
        this.difficulty = difficulty;
    }

    public long getBank() {
        return bank;
    }

    public void setBank(long bank) {

        this.bank = bank;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return null;
    }
}