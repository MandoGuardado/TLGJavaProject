package com.blackjack.controller;

import com.blackjack.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BlackJackApp {
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private Dealer dealer = new Dealer();
    private Deck deck = new Deck();
    private RandomIntGenerator intGenerator = new RandomIntGenerator();
    private Map<String, Double> playerMap = loadPlayerMap();


    private boolean isGameOver = false;
    private boolean isBlackJackOver = false;


    public void playGame() {
        greeting();

        String name = promptName();
        char difficulty = promptDifficulty();
        player = new Player(name, difficulty);


        while (!isBlackJackOver) {

//        dealer.initiatesShuffleCards();

            for (int i = 0; i < 2; i++) {
                String playerRandomKey = randomCardKey();
                player.getHand().getCards().put(playerRandomKey, deck.getDeckMap().get(playerRandomKey));

                String dealerRandKey = randomCardKey();
                dealer.getHand().getCards().put(dealerRandKey, deck.getDeckMap().get(dealerRandKey));
            }
            player.getHand().updateInfo();
            dealer.getHand().updateInfo();


            while (!isGameOver) {
                Integer players_score = player.getHand().calculateScore();
                Integer dealers_score = dealer.getHand().calculateScore();

                System.out.println(name +" Cards: " + player.getHand().getArrayValues() + ", Current Score: " + players_score);
                System.out.println("Dealer Cards: " + dealer.getHand().getArrayValues() + ", Current Score: " + dealers_score);
                if (players_score == 0 || dealers_score == 0 || players_score > 21) {
                    isGameOver = true;
                } else {
                    System.out.println("Type Y to 'Hit' or N to  'Stand' ");
                    String response = scanner.nextLine().toUpperCase();
                    if ("Y".equals(response)) {
                        String randomCardKey = randomCardKey();
                        player.getHand().getCards().put(randomCardKey, deck.getDeckMap().get(randomCardKey));
                        player.getHand().updateInfo();
                    } else {
                        isGameOver = true;
                    }
                }

//            placeBet();
//            playBlackJack();
//            updateScore();
//            prompUserToContinuePlaying();
            }
            while (dealer.getHand().getHandScore() != 0 && dealer.getHand().getHandScore() < 17) {
                String randomCardKey = randomCardKey();
                dealer.getHand().getCards().put(randomCardKey, deck.getDeckMap().get(randomCardKey));
                dealer.getHand().updateInfo();
            }
            System.out.println();
            System.out.println(name + " final hand: " + player.getHand().getArrayValues() + ", final score: " + player.getHand().getHandScore());
            System.out.println("Dealers final hand: " + dealer.getHand().getArrayValues() + ", final score: " + dealer.getHand().getHandScore());


            System.out.println();
            determineWinner(name);

            System.out.println("Type 'Y' to play another hand.");
            String endOfGame = scanner.nextLine().toUpperCase();

            if (!("Y".equals(endOfGame))) {
                isBlackJackOver = true;
            } else {

                isGameOver =false;
                resetGame(name, difficulty);
            }


        }
        goodbyeMessage();

    }

    private void resetGame(String name, char difficulty) {
        player = new Player(name, difficulty);
        dealer = new Dealer();
    }


    private void determineWinner(String name) {
        int playersFinalScore = player.getHand().getHandScore();
        int dealersFinalScore = dealer.getHand().getHandScore();

        if (playersFinalScore > 21 && dealersFinalScore > 21) {
            System.out.println("Dealer Wins! " + name +" went over 21.");
        }
        if (playersFinalScore == dealersFinalScore) {
            System.out.println("Its a draw");
        } else if (dealersFinalScore == 0) {
            System.out.println( name + " looses! Dealer had BlackJack ");
        } else if (playersFinalScore == 0) {
            System.out.println(name + " wins! " + name +"has BlackJack.");
        } else if (playersFinalScore > 21) {
            System.out.println("Dealer wins! " + name +" went over.");
        } else if (dealersFinalScore > 21) {
            System.out.println( name +" wins! Dealer went over.");
        } else if (playersFinalScore > dealersFinalScore) {
            System.out.println(name + " wins! ");
        } else {
            System.out.println("Dealer wins!");
        }

    }

    private String randomCardKey() {
        return deck.getCardKeyReferences().get(intGenerator.randomIndex());
    }

    private void greeting() {
        String title = "";

        try {
            title = Files.readString(Path.of("welcome_banner.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(title);
    }

    // prompt user for Name
    // if name exists, return name and last chip value
    // if name does not exist, make new player
    private String promptName() {
        String result = "Name";

        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();

        boolean newPlayer = true;


        return result;
    }

    private char promptDifficulty() {
        boolean validInput = false;
        char difficulty = 'E';

        while (!validInput) {
            System.out.println("Please select your difficulty level: Easy-E, Medium-M, Hard-H\n");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("E")) {    // or M, or H here?
//                difficulty = 'E';                                   // setdiff here?, does this app have the player?
                System.out.println("EASY difficulty selected");
                validInput = true;
            }
        }
        return difficulty;
    }


    private void updateScore() {
        System.out.println("John Doe you score is:1000 points ");
    }

    private void playBlackJack() {
        System.out.println("Playing Blackjack ");
    }


    private void placeBet() {
        System.out.println("Please place your bet.");
    }


    private void prompUserToContinuePlaying() {
        System.out.println("Would you like to play another hand? ");
    }


    private void goodbyeMessage() {


    }

    // Accessor Methods - Setter and Getters
    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    private Map<String, Double> loadPlayerMap () {
        Map<String, Double> playerMap = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("data/player-records.csv"));
            for (String line: lines) {
                String[] tokens = line.split(",");
                String name = tokens[0];
                Double chips = Double.valueOf(tokens[1]);

                playerMap.put(name, chips);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return  playerMap;
    }


}