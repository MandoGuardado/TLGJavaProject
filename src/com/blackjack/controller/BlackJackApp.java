package com.blackjack.controller;

import com.blackjack.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BlackJackApp {
    private Scanner scanner = new Scanner(System.in);
    private ScoreBoard board = ScoreBoard.getInstance();
    private Player player;
    private Dealer dealer = new Dealer();
    private Deck deck = new Deck();
    private RandomIntGenerator intGenerator = new RandomIntGenerator();

    private double pot = 0;     // pot for betting calculations
    private boolean isGameOver = false;
    private boolean isBlackJackOver = false;


    public void playGame() {
        greeting();

        String name = promptName();
        char difficulty = promptDifficulty();
        player = new Player(name, difficulty);


        while (!isBlackJackOver) {
            placeBet();

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

           // board.update(player);

            System.out.println("Type 'Y' to play another hand.");
            String endOfGame = scanner.nextLine().toUpperCase();

            if (!("Y".equals(endOfGame))) {
                isBlackJackOver = true;
            } else {

                isGameOver =false;
                resetGame(name, difficulty);
            }


        }
        board.display();
        goodbyeMessage();

    }

    private void resetGame(String name, char difficulty) {
        player = new Player(name, difficulty);
        dealer = new Dealer();
    }


    private void determineWinner(String name) {
        int playersFinalScore = player.getHand().getHandScore();
        int dealersFinalScore = dealer.getHand().getHandScore();
        String winnerCase;     // to determine win cases in updateScore()

        if (playersFinalScore > 21 && dealersFinalScore > 21) {
            System.out.println("Dealer Wins! " + name +" went over 21.");
        }
        if (playersFinalScore == dealersFinalScore) {
            System.out.println("Its a draw! Bet returned to player ");
            winnerCase = "draw";
        } else if (dealersFinalScore == 0) {
            System.out.println(name + " looses! Dealer got a BlackJack ");
            winnerCase = "lose";
        } else if (playersFinalScore == 0) {
            System.out.println(name + " wins! " + name +" got a BlackJack!");
            winnerCase = "blackjack";
        } else if (playersFinalScore > 21) {
            System.out.println("Dealer wins! " + name +" went over 21.");
            winnerCase = "lose";
        } else if (dealersFinalScore > 21) {
            System.out.println( name +" wins! Dealer went over 21.");
            winnerCase = "win";
        } else if (playersFinalScore > dealersFinalScore) {
            System.out.println(name + " wins! ");
            winnerCase = "win";
        } else {
            System.out.println("Dealer wins!");
            winnerCase = "lose";
        }
        updateScore(winnerCase);
    }

    private String randomCardKey() {
        return deck.getCardKeyReferences().get(intGenerator.randomIndex());
    }

    private void greeting() {
        String title = "";

        try {
            title = Files.readString(Path.of("images/welcome_banner.txt"));
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


    private void updateScore(String winnerCase) {
        switch (winnerCase) {
            case "lose":
                // player loses, bet taken by dealer
                // nothing happens **handled by initial bet() by Player
                break;
            case "win":
                // player wins, win bet amount; ex: bet 20, add 20*2 to score
                player.addWinnings(pot * 2);
                break;
            case "blackjack":
                // player blackJack, win bet amount x 1.5;  ex: bet 20, add 20*2.5
                player.addWinnings(pot * 2.5);
                break;
            case "draw":
                // draw (or push), player retains bet; ex: bet 20, add 20
                player.addWinnings(pot);
                break;
        }
    }

    private void playBlackJack() {
        System.out.println("Playing Blackjack ");
    }


    private void placeBet() {
        boolean validBet = false;

        while (!validBet) {
            System.out.println("Please place your bet (minimum of 5): ");
            String input = scanner.nextLine();
            double bet = Double.parseDouble(input); // is there an exception problem here if input isn't double?
            if (bet <= player.getScore() && bet >= 5) {
                player.bet(bet);
                pot += bet;
                validBet = true;
            }
        }
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

}