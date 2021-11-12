package com.blackjack;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {
    //Fields
    private String name;
    private double purse = 200;     // all players created with 200
    private Hand hand = new Hand();

    //Constructors
    //Constructor used when game begins which has a default purse amount
    public Player(String name) {
        setName(name);
    }
    //Second Constructor used when player decides to play again . They will pass in their name and a current purse amount.
    public Player(String name, double purse){
        this(name);
        setPurse(purse);
    }

    // Business Methods
    //Method used to give the player a new card. It checks to make sure player does not have the card and updates Players Hand object and recreates the Hand image
    public void hit(Deck deck) {
        int randomCardIndex = randomCard();
        String cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        while (this.getHand().getHandCards().containsKey(cardKey)){
            randomCardIndex = randomCard();
            cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        }
        Card currentCard = deck.getDeckMap().get(cardKey);
        this.getHand().getHandCards().put(cardKey,currentCard);
        getHand().updateInfo();
        getHand().getCardImages().createHand(currentCard.getSymbol(), currentCard.getSuit());
    }

    public List<StringBuilder> printPlayerCards(){
        return getHand().getCardImages().getCardImage();
    }
    //Helper method that returns a random index to pick random card from Deck
    private int randomCard() {
       int min = 0;
       int max = 51;
       return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public void bet(double betAmount) {
        setPurse(getPurse() - betAmount);
    }

    public void addWinnings(double winnings){
        setPurse(getPurse() + winnings);
    }

    //Accessor Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPurse() {
        return purse;
    }

    private void setPurse(double purse) {
        this.purse = purse;
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " name='" + getName() +
                ", score=" + getPurse();
    }
}