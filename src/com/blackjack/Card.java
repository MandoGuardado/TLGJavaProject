package com.blackjack;

public enum Card {
    ACE_CLUBS("Ace of Clover", 10, 1 , Suit.CLUBS),
    EIGHT_CLUBS("Eight of Clover", 8, 8,Suit.CLUBS),
    FIVE_CLUBS("Five of Clover", 5, 5, Suit.CLUBS),
    FOUR_CLUBS("Four of Clover", 4, 4, Suit.CLUBS),
    JACK_CLUBS("Jack of Clover", 10, 10, Suit.CLUBS),
    KING_CLUBS("King of Clover", 10, 10, Suit.CLUBS),
    NINE_CLUBS("Nine of Clover", 9, 9, Suit.CLUBS),
    QUEEN_CLUBS("Queen of Clover", 10, 10, Suit.CLUBS),
    SEVEN_CLUBS("Seven of Clover", 7, 7, Suit.CLUBS),
    SIX_CLUBS("Six of Clover", 6, 6, Suit.CLUBS),
    TEN_CLUBS("Ten of Clover", 10, 10, Suit.CLUBS),
    THREE_CLUBS("Three of Clover", 3, 3, Suit.CLUBS),
    TWO_CLUBS("Two of Clover", 2, 2,Suit.CLUBS),


    ACE_SPADES("Ace of Spades", 10, 1 , Suit.SPADES),
    EIGHT_SPADES("Eight of Spades", 8, 8,Suit.SPADES),
    FIVE_SPADES("Five of Spades", 5, 5, Suit.SPADES),
    FOUR_SPADES("Four of Spades", 4, 4, Suit.SPADES),
    JACK_SPADES("Jack of Spades", 10, 10, Suit.SPADES),
    KING_SPADES("King of Spades", 10, 10, Suit.SPADES),
    NINE_SPADES("Nine of Spades", 9, 9, Suit.SPADES),
    QUEEN_SPADES("Queen of Spades", 10, 10, Suit.SPADES),
    SEVEN_SPADES("Seven of Spades", 7, 7, Suit.SPADES),
    SIX_SPADES("Six of Spades", 6, 6, Suit.SPADES),
    TEN_SPADES("Ten of Spades", 10, 10, Suit.SPADES),
    THREE_SPADES("Three of Spades", 3, 3, Suit.SPADES),
    TWO_SPADES("Two of Spades", 2, 2,Suit.SPADES),

    ACE_HEARTS("Ace of Hearts", 10, 1 , Suit.HEARTS),
    EIGHT_HEARTS("Eight of Hearts", 8, 8,Suit.HEARTS),
    FIVE_HEARTS("Five of Hearts", 5, 5, Suit.HEARTS),
    FOUR_HEARTS("Four of Hearts", 4, 4, Suit.HEARTS),
    JACK_HEARTS("Jack of Hearts", 10, 10, Suit.HEARTS),
    KING_HEARTS("King of Hearts", 10, 10, Suit.HEARTS),
    NINE_HEARTS("Nine of Hearts", 9, 9, Suit.HEARTS),
    QUEEN_HEARTS("Queen of Hearts", 10, 10, Suit.HEARTS),
    SEVEN_HEARTS("Seven of Hearts", 7, 7, Suit.HEARTS),
    SIX_HEARTS("Six of Hearts", 6, 6, Suit.HEARTS),
    TEN_HEARTS("Ten of Hearts", 10, 10, Suit.HEARTS),
    THREE_HEARTS("Three of Hearts", 3, 3, Suit.HEARTS),
    TWO_HEARTS("Two of Hearts", 2, 2,Suit.HEARTS),

    ACE_DIAMONDS("Ace of Diamonds", 10, 1 , Suit.DIAMONDS),
    EIGHT_DIAMONDS("Eight of Diamonds", 8, 8,Suit.DIAMONDS),
    FIVE_DIAMONDS("Five of Diamonds", 5, 5, Suit.DIAMONDS),
    FOUR_DIAMONDS("Four of Diamonds", 4, 4, Suit.DIAMONDS),
    JACK_DIAMONDS("Jack of Diamonds", 10, 10, Suit.DIAMONDS),
    KING_DIAMONDS("King of Diamonds", 10, 10, Suit.DIAMONDS),
    NINE_DIAMONDS("Nine of Diamonds", 9, 9, Suit.DIAMONDS),
    QUEEN_DIAMONDS("Queen of Diamonds", 10, 10, Suit.DIAMONDS),
    SEVEN_DIAMONDS("Seven of Diamonds", 7, 7, Suit.DIAMONDS),
    SIX_DIAMONDS("Six of Diamonds", 6, 6, Suit.DIAMONDS),
    TEN_DIAMONDS("Ten of Diamonds", 10, 10, Suit.DIAMONDS),
    THREE_DIAMONDS("Three of Diamonds", 3, 3, Suit.DIAMONDS),
    TWO_DIAMONDS("Two of Diamonds", 2, 2,Suit.DIAMONDS);

    private final String name;
    private final int value;
    private final int alt_value;
    private final Suit suit;

    Card(String name,int value, int alt_value,  Suit suit) {
        this.alt_value = alt_value;
        this.value = value;
        this.name = name;
        this.suit = suit;

    }

    public int getAlt_value() {
        return alt_value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public Suit getSuit() {
        return suit;
    }
}