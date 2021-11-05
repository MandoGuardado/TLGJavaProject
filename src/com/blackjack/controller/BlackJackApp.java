package com.blackjack.controller;

import com.blackjack.ShuffleCards;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class BlackJackApp {
    private Scanner scanner = new Scanner(System.in);

    public void playGame(){
        greeting();
        String name = promptName();
        char difficulty = promptDifficulty();
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

    private char promptDifficulty() {
        boolean validInput = false;
        char difficulty = 'E';

        while (!validInput){
            System.out.println("Please select your difficulty level: Easy-E, Medium-M, Hard-H\n");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("E")) {    // or M, or H here?
                difficulty = 'E';                                   // setdiff here?, does this app have the player?
                System.out.println("EASY difficulty selected");
                validInput = true;
            }
        }
        return difficulty;
    }

    private String promptName() {
        System.out.println("Please enter your name: ");
        String input = scanner.nextLine();

        return input;
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