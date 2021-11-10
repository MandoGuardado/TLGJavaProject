package com.blackjack;

public enum Card {
    ACE_CLUBS("Ace of Clubs", 11 , "A", "clubs"),
    KING_CLUBS("King of Clubs", 10, "K", "clubs"),
    QUEEN_CLUBS("Queen of Clubs", 10, "Q", "clubs"),
    JACK_CLUBS("Jack of Clubs", 10, "J", "clubs"),
    TEN_CLUBS("Ten of Clubs", 10, "10", "clubs"),
    NINE_CLUBS("Nine of Clubs", 9, "9", "clubs"),
    EIGHT_CLUBS("Eight of Clubs", 8, "8", "clubs"),
    SEVEN_CLUBS("Seven of Clubs", 7, "7", "clubs"),
    SIX_CLUBS("Six of Clubs", 6, "6", "clubs"),
    FIVE_CLUBS("Five of Clubs", 5, "5", "clubs"),
    FOUR_CLUBS("Four of Clubs", 4, "4", "clubs"),
    THREE_CLUBS("Three of Clubs", 3, "3", "clubs"),
    TWO_CLUBS("Two of Clubs", 2, "2", "clubs"),


    ACE_SPADES("Ace of Spades", 11, "A", "spades"),
    EIGHT_SPADES("Eight of Spades", 8,"8", "spades"),
    FIVE_SPADES("Five of Spades", 5,"5", "spades"),
    FOUR_SPADES("Four of Spades", 4,"4", "spades"),
    JACK_SPADES("Jack of Spades", 10,"J", "spades"),
    KING_SPADES("King of Spades", 10,"K", "spades"),
    NINE_SPADES("Nine of Spades", 9,"9", "spades"),
    QUEEN_SPADES("Queen of Spades", 10,"Q", "spades"),
    SEVEN_SPADES("Seven of Spades", 7,"7", "spades"),
    SIX_SPADES("Six of Spades", 6,"6", "spades"),
    TEN_SPADES("Ten of Spades", 10,"10", "spades"),
    THREE_SPADES("Three of Spades", 3,"3", "spades"),
    TWO_SPADES("Two of Spades", 2,"2", "spades"),

    ACE_HEARTS("Ace of Hearts", 11, "A", "hearts"),
    EIGHT_HEARTS("Eight of Hearts", 8, "8", "hearts"),
    FIVE_HEARTS("Five of Hearts", 5, "5", "hearts"),
    FOUR_HEARTS("Four of Hearts", 4, "4", "hearts"),
    JACK_HEARTS("Jack of Hearts", 10, "J", "hearts"),
    KING_HEARTS("King of Hearts", 10, "K", "hearts"),
    NINE_HEARTS("Nine of Hearts", 9, "9", "hearts"),
    QUEEN_HEARTS("Queen of Hearts", 10, "Q", "hearts"),
    SEVEN_HEARTS("Seven of Hearts", 7, "7", "hearts"),
    SIX_HEARTS("Six of Hearts", 6, "6", "hearts"),
    TEN_HEARTS("Ten of Hearts", 10, "10", "hearts"),
    THREE_HEARTS("Three of Hearts", 3, "3", "hearts"),
    TWO_HEARTS("Two of Hearts", 2, "2", "hearts"),

    ACE_DIAMONDS("Ace of Diamonds", 11, "A", "diamonds"),
    EIGHT_DIAMONDS("Eight of Diamonds", 8, "8", "diamonds"),
    FIVE_DIAMONDS("Five of Diamonds", 5, "5", "diamonds"),
    FOUR_DIAMONDS("Four of Diamonds", 4, "4", "diamonds"),
    JACK_DIAMONDS("Jack of Diamonds", 10, "J", "diamonds"),
    KING_DIAMONDS("King of Diamonds", 10, "K", "diamonds"),
    NINE_DIAMONDS("Nine of Diamonds", 9, "9", "diamonds"),
    QUEEN_DIAMONDS("Queen of Diamonds", 10, "Q", "diamonds"),
    SEVEN_DIAMONDS("Seven of Diamonds", 7, "7", "diamonds"),
    SIX_DIAMONDS("Six of Diamonds", 6, "6", "diamonds"),
    TEN_DIAMONDS("Ten of Diamonds", 10, "10", "diamonds"),
    THREE_DIAMONDS("Three of Diamonds", 3, "3", "diamonds"),
    TWO_DIAMONDS("Two of Diamonds", 2, "2", "diamonds");

    private final String name;
    private final int value;
    private final String symbol;
    private final String suit;


    Card(String name,int value, String symbol, String suit) {
        this.value = value;
        this.name = name;
        this.symbol = symbol;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSuit() {
        return suit;
    }
}