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


    private void initialDeal() {

    }

    private void dealCard() {

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