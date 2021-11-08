package com.blackjack;

import java.util.List;

class Player {
    // FIELDS
    private String name;
    private double score; // or maybe chips. betting points
    private char difficulty;

//    private Hand hand; // or Hand. Dealer
    private handDisplay handDisplay; // a hand? Dealer & Player could have 'Hands'
    private double handTotalScore;
    private List<String> currentHand;


    // CTORS

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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