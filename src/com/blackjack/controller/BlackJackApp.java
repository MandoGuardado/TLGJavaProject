package com.blackjack.controller;

public class BlackJackApp {

    public void playGame(){
        greeting();
        promptName();
        promptDifficulty();
        placeBet();
        shuffleCards();
        playBlackJack();
        updateScore();
        prompUserToContinuePlaying();
        goodbyeMessage();
    }

    private void goodbyeMessage() {
        System.out.println("Thank you for playing.");
    }

    private void prompUserToContinuePlaying() {
        System.out.println("Would you like to play another hand? ");
    }

    private void updateScore() {
        System.out.println("John Doe you score is:1000 points ");
    }

    private void playBlackJack() {
        System.out.println("Playing Blackjack ");
    }

    private void shuffleCards() {
        System.out.println("Dealing cards.........");

    }

    private void placeBet() {
        System.out.println("Please place your bet.");
    }

    private void promptDifficulty() {
        System.out.println("Level of difficulty: Hard-H, Medium-M, Easy-E");
    }

    private void promptName() {
        System.out.println("Please provide us with your name");
    }

    private void greeting() {
        System.out.println("Hello Welcome to BlackJack");
    }


}