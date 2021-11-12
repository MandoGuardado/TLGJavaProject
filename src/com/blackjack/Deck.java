package com.blackjack;

import java.util.*;


public class Deck {
    //Fields
    private final Map<String, Card> deckMap = new HashMap<>();
    private final List<String> cardKeyReferences = new ArrayList<>();

    //Constructors
    public Deck() {
        //constructor is being used to fill up map and reference array being used to utilize it index to randomly select card.
        setUpDeckMap();
        setUpReferenceArrayList();
    }

    //Business Methods
    //Method used to automatically fill in the Map of all the ENUM cards
    private void setUpDeckMap() {
        deckMap.put(Card.ACE_CLUBS.getName(), Card.ACE_CLUBS);
        deckMap.put(Card.TWO_CLUBS.getName(), Card.TWO_CLUBS);
        deckMap.put(Card.THREE_CLUBS.getName(), Card.THREE_CLUBS);
        deckMap.put(Card.FOUR_CLUBS.getName(), Card.FOUR_CLUBS);
        deckMap.put(Card.FIVE_CLUBS.getName(), Card.FIVE_CLUBS);
        deckMap.put(Card.SIX_CLUBS.getName(), Card.SIX_CLUBS);
        deckMap.put(Card.SEVEN_CLUBS.getName(), Card.SEVEN_CLUBS);
        deckMap.put(Card.EIGHT_CLUBS.getName(), Card.EIGHT_CLUBS);
        deckMap.put(Card.NINE_CLUBS.getName(), Card.NINE_CLUBS);
        deckMap.put(Card.TEN_CLUBS.getName(), Card.TEN_CLUBS);
        deckMap.put(Card.JACK_CLUBS.getName(), Card.JACK_CLUBS);
        deckMap.put(Card.QUEEN_CLUBS.getName(), Card.QUEEN_CLUBS);
        deckMap.put(Card.KING_CLUBS.getName(), Card.KING_CLUBS);

        deckMap.put(Card.ACE_DIAMONDS.getName(), Card.ACE_DIAMONDS);
        deckMap.put(Card.TWO_DIAMONDS.getName(), Card.TWO_DIAMONDS);
        deckMap.put(Card.THREE_DIAMONDS.getName(), Card.THREE_DIAMONDS);
        deckMap.put(Card.FOUR_DIAMONDS.getName(), Card.FOUR_DIAMONDS);
        deckMap.put(Card.FIVE_DIAMONDS.getName(), Card.FIVE_DIAMONDS);
        deckMap.put(Card.SIX_DIAMONDS.getName(), Card.SIX_DIAMONDS);
        deckMap.put(Card.SEVEN_DIAMONDS.getName(), Card.SEVEN_DIAMONDS);
        deckMap.put(Card.EIGHT_DIAMONDS.getName(), Card.EIGHT_DIAMONDS);
        deckMap.put(Card.NINE_DIAMONDS.getName(), Card.NINE_DIAMONDS);
        deckMap.put(Card.TEN_DIAMONDS.getName(), Card.TEN_DIAMONDS);
        deckMap.put(Card.JACK_DIAMONDS.getName(), Card.JACK_DIAMONDS);
        deckMap.put(Card.QUEEN_DIAMONDS.getName(), Card.QUEEN_DIAMONDS);
        deckMap.put(Card.KING_DIAMONDS.getName(), Card.KING_DIAMONDS);

        deckMap.put(Card.ACE_HEARTS.getName(), Card.ACE_HEARTS);
        deckMap.put(Card.TWO_HEARTS.getName(), Card.TWO_HEARTS);
        deckMap.put(Card.THREE_HEARTS.getName(), Card.THREE_HEARTS);
        deckMap.put(Card.FOUR_HEARTS.getName(), Card.FOUR_HEARTS);
        deckMap.put(Card.FIVE_HEARTS.getName(), Card.FIVE_HEARTS);
        deckMap.put(Card.SIX_HEARTS.getName(), Card.SIX_HEARTS);
        deckMap.put(Card.SEVEN_HEARTS.getName(), Card.SEVEN_HEARTS);
        deckMap.put(Card.EIGHT_HEARTS.getName(), Card.EIGHT_HEARTS);
        deckMap.put(Card.NINE_HEARTS.getName(), Card.NINE_HEARTS);
        deckMap.put(Card.TEN_HEARTS.getName(), Card.TEN_HEARTS);
        deckMap.put(Card.JACK_HEARTS.getName(), Card.JACK_HEARTS);
        deckMap.put(Card.QUEEN_HEARTS.getName(), Card.QUEEN_HEARTS);
        deckMap.put(Card.KING_HEARTS.getName(), Card.KING_HEARTS);

        deckMap.put(Card.ACE_SPADES.getName(), Card.ACE_SPADES);
        deckMap.put(Card.TWO_SPADES.getName(), Card.TWO_SPADES);
        deckMap.put(Card.THREE_SPADES.getName(), Card.THREE_SPADES);
        deckMap.put(Card.FOUR_SPADES.getName(), Card.FOUR_SPADES);
        deckMap.put(Card.FIVE_SPADES.getName(), Card.FIVE_SPADES);
        deckMap.put(Card.SIX_SPADES.getName(), Card.SIX_SPADES);
        deckMap.put(Card.SEVEN_SPADES.getName(), Card.SEVEN_SPADES);
        deckMap.put(Card.EIGHT_SPADES.getName(), Card.EIGHT_SPADES);
        deckMap.put(Card.NINE_SPADES.getName(), Card.NINE_SPADES);
        deckMap.put(Card.TEN_SPADES.getName(), Card.TEN_SPADES);
        deckMap.put(Card.JACK_SPADES.getName(), Card.JACK_SPADES);
        deckMap.put(Card.QUEEN_SPADES.getName(), Card.QUEEN_SPADES);
        deckMap.put(Card.KING_SPADES.getName(), Card.KING_SPADES);
    }
    //Method being used to fill in list array with ENUM card key's
    private void setUpReferenceArrayList() {
        for (Map.Entry<String, Card> entry : getDeckMap().entrySet()) {
            getCardKeyReferences().add(entry.getKey());
        }
    }

    //Accessor Methods
    public Map<String, Card> getDeckMap() {
        return deckMap;
    }

    public List<String> getCardKeyReferences() {
        return cardKeyReferences;
    }

}