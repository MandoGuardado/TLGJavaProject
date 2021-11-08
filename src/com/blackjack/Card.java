package com.blackjack;

public enum Card {
    ACE_CLUBS("Ace of Clover", 11, 1 ),
    EIGHT_CLUBS("Eight of Clover", 8, 8),
    FIVE_CLUBS("Five of Clover", 5, 5),
    FOUR_CLUBS("Four of Clover", 4, 4),
    JACK_CLUBS("Jack of Clover", 10, 10),
    KING_CLUBS("King of Clover", 10, 10),
    NINE_CLUBS("Nine of Clover", 9, 9),
    QUEEN_CLUBS("Queen of Clover", 10, 10),
    SEVEN_CLUBS("Seven of Clover", 7, 7),
    SIX_CLUBS("Six of Clover", 6, 6),
    TEN_CLUBS("Ten of Clover", 10, 10),
    THREE_CLUBS("Three of Clover", 3, 3),
    TWO_CLUBS("Two of Clover", 2, 2),


    ACE_SPADES("Ace of Spades", 11, 1 ),
    EIGHT_SPADES("Eight of Spades", 8, 8),
    FIVE_SPADES("Five of Spades", 5, 5),
    FOUR_SPADES("Four of Spades", 4, 4),
    JACK_SPADES("Jack of Spades", 10, 10),
    KING_SPADES("King of Spades", 10, 10),
    NINE_SPADES("Nine of Spades", 9, 9),
    QUEEN_SPADES("Queen of Spades", 10, 10),
    SEVEN_SPADES("Seven of Spades", 7, 7),
    SIX_SPADES("Six of Spades", 6, 6),
    TEN_SPADES("Ten of Spades", 10, 10),
    THREE_SPADES("Three of Spades", 3, 3),
    TWO_SPADES("Two of Spades", 2, 2),

    ACE_HEARTS("Ace of Hearts", 11, 1),
    EIGHT_HEARTS("Eight of Hearts", 8, 8),
    FIVE_HEARTS("Five of Hearts", 5, 5),
    FOUR_HEARTS("Four of Hearts", 4, 4),
    JACK_HEARTS("Jack of Hearts", 10, 10),
    KING_HEARTS("King of Hearts", 10, 10),
    NINE_HEARTS("Nine of Hearts", 9, 9),
    QUEEN_HEARTS("Queen of Hearts", 10, 10),
    SEVEN_HEARTS("Seven of Hearts", 7, 7),
    SIX_HEARTS("Six of Hearts", 6, 6),
    TEN_HEARTS("Ten of Hearts", 10, 10),
    THREE_HEARTS("Three of Hearts", 3, 3),
    TWO_HEARTS("Two of Hearts", 2,2),

    ACE_DIAMONDS("Ace of Diamonds", 11, 1 ),
    EIGHT_DIAMONDS("Eight of Diamonds", 8,8),
    FIVE_DIAMONDS("Five of Diamonds", 5, 5),
    FOUR_DIAMONDS("Four of Diamonds", 4, 4),
    JACK_DIAMONDS("Jack of Diamonds", 10, 10),
    KING_DIAMONDS("King of Diamonds", 10, 10),
    NINE_DIAMONDS("Nine of Diamonds", 9, 9),
    QUEEN_DIAMONDS("Queen of Diamonds", 10, 10),
    SEVEN_DIAMONDS("Seven of Diamonds", 7, 7),
    SIX_DIAMONDS("Six of Diamonds", 6, 6),
    TEN_DIAMONDS("Ten of Diamonds", 10, 10),
    THREE_DIAMONDS("Three of Diamonds", 3, 3),
    TWO_DIAMONDS("Two of Diamonds", 2,2);

    private final String name;
    private final int value;
    private final int alt_value;


    Card(String name,int value, int alt_value) {
        this.alt_value = alt_value;
        this.value = value;
        this.name = name;
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

}