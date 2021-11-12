package com.blackjack;


import java.util.List;


public class Dealer {
    //Fields
    private Hand hand = new Hand();                                          //Variable to hold the Dealers Hand

    //Constructors
    public Dealer() {

    }

    //Business Methods'
    //method that accepts a deck and randomly selects a card for Card Enum class and adds it to hand
    public void getCard(Deck deck) {
        int randomCardIndex = randomCard();
        String cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        while (this.getHand().getHandCards().containsKey(cardKey)) {
            randomCardIndex = randomCard();
            cardKey = deck.getCardKeyReferences().get(randomCardIndex);
        }
        Card currentCard = deck.getDeckMap().get(cardKey);

        this.getHand().getHandCards().put(cardKey, currentCard);

        getHand().updateInfo();
        getHand().getCardImages().createHand(currentCard.getSymbol(), currentCard.getSuit());

    }
    //Accessory method to help create a random index inorder to get a random Car
    private int randomCard() {
        int min = 0;
        int max = 51;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    //method to print the Dealers Cards as an image.
    public List<StringBuilder> printDealerCards() {
        return getHand().getCardImages().getCardImage();
    }


    //Accessor methods ( Setter and getters)
    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

}