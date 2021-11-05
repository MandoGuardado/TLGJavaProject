package com.blackjack.controller;

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

    private void shuffleCards() {
        System.out.println("Dealing cards.........");

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
        String title = "\n" +
                " __          __  _                            _______      ____  _            _    _            _    \n" +
                " \\ \\        / / | |                          |__   __|    |  _ \\| |          | |  (_)          | |   \n" +
                "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___     | | ___   | |_) | | __ _  ___| | ___  __ _  ___| | __\n" +
                "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\    | |/ _ \\  |  _ <| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n" +
                "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/    | | (_) | | |_) | | (_| | (__|   <| | (_| | (__|   < \n" +
                "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|    |_|\\___/  |____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n" +
                "                                                                                 _/ |                \n" +
                "                                                                                |__/                 \n";
        System.out.println(title);
    }


}