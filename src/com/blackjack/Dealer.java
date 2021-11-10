package com.blackjack;


import java.util.List;


public class Dealer {
    //Fields
    private Deck deck = new Deck();
    private Hand hand = new Hand();

    //Constructors
    public Dealer() {

    }

    //Business Methods
    public void getCard(Deck deck) {
        int randomCardIndex = randomCard();
        String cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        while (this.getHand().getCards().containsKey(cardKey)) {
            randomCardIndex = randomCard();
            cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        }
        Card currentCard = deck.getDeckMap().get(cardKey);


        this.getHand().getCards().put(cardKey, currentCard);

        getHand().updateInfo();
        getHand().getCardImages().createHand(currentCard.getSymbol(), currentCard.getSuit());

    }

    private int randomCard() {
        int min = 0;
        int max = 51;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }


    public List<StringBuilder> printDealerCards() {
        return getHand().getCardImages().getCardImage();
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