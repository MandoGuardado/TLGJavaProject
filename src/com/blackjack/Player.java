package com.blackjack;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Player implements Serializable {
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
    public void hit(Deck deck) {
        int randomCardIndex = randomCard();
        String cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        while (this.getHand().getCards().containsKey(cardKey)){
            randomCardIndex = randomCard();
            cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        }
        Card currentCard = deck.getDeckMap().get(cardKey);

        this.getHand().getCards().put(cardKey,currentCard);

        getHand().updateInfo();
        getHand().getCardImages().createHand(currentCard.getSymbol(), currentCard.getSuit());
    }

    private int randomCard() {
       int min = 0;
       int max = 51;
       return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public void stand() {
        // Do we want to remove this?
    }

    public void bet(double betAmount) {
        //
        setScore(getScore() - betAmount);
    }


    public void addWinnings(double winnings){
        setScore(getScore() + winnings);
    }

    public List<StringBuilder> printPlayerCards(){
        return getHand().getCardImages().getCardImage();
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