package com.blackjack.controller;

import com.blackjack.ShuffleCards;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    private void shuffleCards(){


        ShuffleCards message = null;
        try {
            message = new ShuffleCards();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert message != null;
        message.start();

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
        String title= "";

        try {
            title = Files.readString(Path.of("welcome_banner.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(title);
    }


}