package com.blackjack.controller;

import com.blackjack.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class BlackJackApp {
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private Dealer dealer = new Dealer();
    private Deck deck = new Deck();
    private RandomIntGenerator intGenerator = new RandomIntGenerator();


    private boolean isHandOver =false;
    private boolean isGameOver = false;


    public void playGame(){
        greeting();
//        String name = promptName();
//        char difficulty = promptDifficulty();
        player = new Player("Armando", 'E'); //todo change back to accepting

        while (!isGameOver) {

//        dealer.initiatesShuffleCards();



            for (int i = 0; i < 2; i++) {
                String playerRandomKey= randomCardKey();
                player.getHand().getCards().put(playerRandomKey, deck.getDeckMap().get(playerRandomKey));

                String dealerRandKey= randomCardKey();
                dealer.getHand().getCards().put(dealerRandKey, deck.getDeckMap().get(dealerRandKey));
            }
            player.getHand().updateInfo();
            dealer.getHand().updateInfo();



            while (!isHandOver){
                Integer players_score = player.getHand().calculateScore();
                Integer dealers_score = dealer.getHand().calculateScore();

                System.out.println("Player Cards: " + player.getHand().getArrayValues() + ", Current Score: " + players_score );
                System.out.println("Dealer Cards: " + dealer.getHand().getArrayValues() + ", Current Score: " + dealers_score);
                if (players_score == 0 || dealers_score == 0 || players_score > 21){
                    isHandOver = true;
                }
                else {
                    System.out.println("Type Y to 'Hit' or N to  'Stand' ");
                    String response = scanner.nextLine().toUpperCase();
                    if ("Y".equals(response)){
                        String randomCardKey = randomCardKey();
                        player.getHand().getCards().put(randomCardKey, deck.getDeckMap().get(randomCardKey));
                        player.getHand().updateInfo();
                    }
                    else{
                        isHandOver = true;
                    }
                }

//            placeBet();
//            playBlackJack();
//            updateScore();
//            prompUserToContinuePlaying();
            }
            while (dealer.getHand().getHandScore() != 0 && dealer.getHand().getHandScore() < 17){
                String randomCardKey = randomCardKey();
                dealer.getHand().getCards().put(randomCardKey,deck.getDeckMap().get(randomCardKey) );
                dealer.getHand().updateInfo();
            }
            System.out.println("Players final hand: " +  player.getHand().getArrayValues() + ", final score: " +  player.getHand().getHandScore());
            System.out.println("Dealers final hand: " + dealer.getHand().getArrayValues() + ", final score: " + dealer.getHand().getHandScore());

            //TODO determine the winner and update the bank amount  for player
            System.out.println();

            System.out.println("Type 'Y' to play another hand.");
            String endOfGame= scanner.nextLine().toUpperCase();

            if (!("Y".equals(endOfGame))){
                isGameOver = true;
            }
            else {
                System.out.println("Clean up player and dealer variables ");
             //TODO this is where we will clean up everything.
            }


        }
        goodbyeMessage();

    }

    private String randomCardKey() {
        return deck.getCardKeyReferences().get(intGenerator.randomIndex());
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

    private String promptName() {
        System.out.println("Please enter your name: ");

        return scanner.nextLine();
    }

    private char promptDifficulty() {
        boolean validInput = false;
        char difficulty = 'E';

        while (!validInput){
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
    public boolean isHandOver() {
        return isHandOver;
    }

    public void setHandOver(boolean handOver) {
        isHandOver = handOver;
    }



}