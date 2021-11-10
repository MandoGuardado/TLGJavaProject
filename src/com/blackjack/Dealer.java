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

    public void getCard( Deck deck){
        int randomCardIndex = randomCard();
        String cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        while (this.getHand().getCards().containsKey(cardKey)){
            randomCardIndex = randomCard();
            cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        }
        Card currentCard = deck.getDeckMap().get(cardKey);


        this.getHand().getCards().put(cardKey, currentCard);

        getHand().updateInfo();
        getHand().getCardImages().createHand(currentCard.getSymbol(),currentCard.getSuit());

    }
    private int randomCard() {
        int min = 0;
        int max = 51;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
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