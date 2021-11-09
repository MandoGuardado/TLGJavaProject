package com.blackjack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dealer {
    private Deck deck = new Deck();
    private Hand hand = new Hand(); // or Hand. Dealer

    public Dealer() {

    }
    public void initiatesShuffleCards() {
        ShuffleCards message = null;
        try {
            message = new ShuffleCards();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert message != null;
        message.start();

    }

    public void getCard(String key, Card card){
        this.getHand().getCards().put(key, card);
        getHand().updateInfo();
        getHand().getCardImages().createHand(card.getSymbol(),card.getSuit());

    }


    private void initialDeal() {

    }

    private void dealCard() {

    }
    public void printDealerCards(){
        getHand().getCardImages().printHand();
    }


    //Accessor methods ( Setter and getters)


    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

}