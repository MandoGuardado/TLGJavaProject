package com.blackjack;

class Player {
    // FIELDS
    private Hand hand; // or Hand. Dealer
    private String name;
    private double score; // or maybe chips. betting points

    private handDisplay handDisplay; // a hand? Dealer & Player could have 'Hands'
    private double handTotalScore;

    // CTORS
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

    @Override
    public String toString() {
        return null;
    }
}