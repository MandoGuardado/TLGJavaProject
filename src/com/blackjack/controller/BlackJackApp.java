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