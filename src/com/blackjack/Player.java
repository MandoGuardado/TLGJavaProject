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

    // BUSINESS
    public void hit(String key, Card card) {
        this.getHand().getCards().put(key,card);
        getHand().updateInfo();
        getHand().getCardImages().createHand(card.getSymbol(), card.getSuit());
    }

    public void stand() {
    }

    public void bet(double betAmount) {
        score -= betAmount;
    }


    public void addWinnings(double winnings){
        score += winnings;
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