package com.blackjack;

import java.util.*;


public class Deck {

    private final Map<String, Card> deckMap = new HashMap<>();
    private final List<String> cardKeyReferences = new ArrayList<>();

    public Deck() {
        setUpDeckMap();
        setUpReferenceArrayList();
    }



    private void setUpDeckMap() {
        deckMap.put(Card.ACE_CLOVER.getName(), Card.ACE_CLOVER);
        deckMap.put(Card.TWO_CLOVER.getName(), Card.TWO_CLOVER);
        deckMap.put(Card.THREE_CLOVER.getName(), Card.THREE_CLOVER);
        deckMap.put(Card.FOUR_CLOVER.getName(), Card.FOUR_CLOVER);
        deckMap.put(Card.FIVE_CLOVER.getName(), Card.FIVE_CLOVER);
        deckMap.put(Card.SIX_CLOVER.getName(), Card.SIX_CLOVER);
        deckMap.put(Card.SEVEN_CLOVER.getName(), Card.SEVEN_CLOVER);
        deckMap.put(Card.EIGHT_CLOVER.getName(), Card.EIGHT_CLOVER);
        deckMap.put(Card.NINE_CLOVER.getName(), Card.NINE_CLOVER);
        deckMap.put(Card.TEN_CLOVER.getName(), Card.TEN_CLOVER);
        deckMap.put(Card.JACK_CLOVER.getName(), Card.JACK_CLOVER);
        deckMap.put(Card.QUEEN_CLOVER.getName(), Card.QUEEN_CLOVER);
        deckMap.put(Card.KING_CLOVER.getName(), Card.KING_CLOVER);

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

    private void setUpReferenceArrayList() {
        for (Map.Entry<String,Card> entry: getDeckMap().entrySet() ) {
            getCardKeyReferences().add(entry.getKey());
        }
    }

    //Accessor Methods

    public Map<String, Card> getDeckMap() {
        return deckMap;
    }

    public Collection<String> getCardKeyReferences() {
        return cardKeyReferences;
    }

    public String getKey(int index){
        return cardKeyReferences.get(index);
    }


}