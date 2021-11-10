package com.blackjack;

import java.util.List;

public class Player {
    // FIELDS
    private String name;
    private double score = 200;     // all players created with 200
    private Hand hand = new Hand(); // aced difficulty for now

    // CTORS

    public Player(String name) {
        setName(name);
    }

    public Player(String name, double score){
        this(name);
        setScore(score);
    }

    // BUSINESS
    public void hit(String key, Card card) {
        this.getHand().getCards().put(key,card);
        getHand().updateInfo();
        getHand().getCardImages().createHand(card.getSymbol(), card.getSuit());
    }

    public void stand() {
    }

    public void bet(double betAmount) {
        setScore(getScore() - betAmount);
    }


    public void addWinnings(double winnings){
        setScore(getScore() + winnings);
    }

    public void printPlayerCards(){
        getHand().getCardImages().printHand();
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

    private void setScore(double score) {
        this.score = score;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " name='" + getName() +
                ", score=" + getScore();
    }
}