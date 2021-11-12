package com.blackjack.controller;

import com.apps.util.Console;
import com.blackjack.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BlackJackApp {
    //Fields
    private Scanner scanner = new Scanner(System.in);                       // Used to prompt user
    private ScoreBoard board = ScoreBoard.getInstance();                    // BlackJack Scoreboard, keeps players historical data
    private Player player;                                                  //Player Instance
    private Dealer dealer = new Dealer();                                   //Dealer Instance
    private Deck deck = new Deck();                                         // Deck Instance

    private double pot = 0;     // pot for betting calculations             //Current Pot
    private boolean isHandBlackjack = false;                                //Boolean to determine if There is a blackjack
    private boolean isBlackJackOver = false;                                //Boolean to determine if game is over.

    //Constructor --Made private to prevent from 'new' keywords to be used in client
    private BlackJackApp() {
    }

    //Business Methods
    //Method to create a new instance of Blackjack object.
    public static BlackJackApp getInstance(){
        return new BlackJackApp();
    }

    public void playGame() {                                                //Method used to initiate game
        greeting();                                                         //Initial greeting
        String name = promptName();                                         //Prompts Player for name
        player = new Player(name);                                          // New player is instantiated
        while (!isBlackJackOver()) {
            placeBet();                                                     //Prompts user to place a bet
            for (int i = 0; i < 2; i++) {                                   //Initiates the first two cards for player and dealer
                player.hit(deck);
                dealer.getCard(deck);
            }
            while (!isHandBlackjack) {                                      //While loop to determine if Player or Dealer has "BlackJack" on initial two cards,
                Integer players_score = player.getHand().calculateScore();  //If either Player or Dealer have BlackJack, then Score will be checked to determine winner.
                Integer dealers_score = dealer.getHand().calculateScore();

                printCurrentStatus();

                if (players_score == 0 || dealers_score == 0 || players_score == 21 || dealers_score == 21 || players_score > 21) {
                    setHandBlackjack(true);                                 //If true, player will be given the option to Hit
                } else {
                    promptPlayerToHitOrStand();                             //If false, player will be prompted to either hit or stand
                }
            }
            while (isDealerDone()) {                                        // While loop that will allow dealer to continue to hit if they don't have BlackJack, or if under 17
                dealer.getCard(deck);
            }
            printCurrentStatus();                                           // Prints the current Hand of Player and Dealer, along with their total
            determineWinner(name);                                          // Determines winner
            prompUserToContinuePlayingBlackJack();                          //Prompts Player to see if they want to pay again.
        }                                    // While loops that will control if BlackJack continues
        board.display();                                                    // Displays game board
        goodbyeMessage();                                                   //Goodbye message
    }

    //Additional Business Methods (Helper Methods)

    //Greeting helper method
    private void greeting() {
        String title = "";

        try {
            title = Files.readString(Path.of("resources/welcome_banner.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(title);
    }

    //Prompting for name helper method
    private String promptName() {
        String name = "";
        Set<String> rankedNames = board.getRankedNames();

        boolean validName = false;
        while (!validName) {
            System.out.println("Please enter your name: ");
            name = scanner.nextLine();

            if (!rankedNames.contains(name)) {
                validName = true;
            } else {
                System.out.println("Oops, sorry friend, that name is already taken. Pick another name please");
            }
        }
        return name;
    }

    //Placing bets prompter helper method
    private void placeBet() {
        boolean validBet = false;

        while (!validBet) {
            if (player.getPurse() < 25) {
                System.out.println("Uh oh! Looks like you might need a loan, here's another 100 to get you going ;)");
                player.addWinnings(100);
            }

            System.out.println("Current total: " + player.getPurse() + "  Please place your bet: ");
            String input = scanner.nextLine();
            double bet = Double.parseDouble(input);
            if (bet <= player.getPurse()) {
                player.bet(bet);
                pot += bet;
                validBet = true;
            }
        }
    }

    // Printing Current Player and Dealer Hands, score and Card Images helper method along with StringBuilder printing helper method
    private void printCurrentStatus() {
        int playerScore = player.getHand().getHandScore();
        int dealerScore = dealer.getHand().getHandScore();
        System.out.println();
        printStringBuilder(player.printPlayerCards());
        System.out.println(player.getName() + " " + (isHandBlackjack() ? "Final" : "") + " hand: " + player.getHand().getCardValues() + ", " + (isHandBlackjack() ? "Final" : "") + " score: " + (playerScore == 0?"21": playerScore));
        System.out.println();
        printStringBuilder(dealer.printDealerCards());
        System.out.println("Dealers" + (isHandBlackjack() ? " Final" : "") + " hand: " + dealer.getHand().getCardValues() + ", " + (isHandBlackjack() ? "Final" : "") + " score: " + (dealerScore == 0? "21" : dealerScore));
        System.out.println();
    }

    private void printStringBuilder(List<StringBuilder> cards) {
        for (StringBuilder row : cards) {
            System.out.println(row);
        }
    }

    //Prompting player to either Hit or Stand helper method
    private void promptPlayerToHitOrStand() {
        System.out.println("Type H to 'Hit' or S to  'Stand' ");
        String response = scanner.nextLine().toUpperCase();
        while (!("H".equals(response) || "S".equals(response))) {
            System.out.println("Type H to 'Hit' or S to  'Stand' ");
            response = scanner.nextLine().toUpperCase();
        }
        if ("H".equals(response)) {
            player.hit(deck);
            Console.clear();
        } else {
            setHandBlackjack(true);
        }
    }

    //Method that helped determine winner based on current score
    private void determineWinner(String name) {
        int playersFinalScore = player.getHand().getHandScore();
        int dealersFinalScore = dealer.getHand().getHandScore();
        String winnerCase;     // to determine win cases in updateScore()
        System.out.println("*******************************************");
        if (playersFinalScore > 21 && dealersFinalScore > 21) {
            System.out.println("Dealer Wins! " + name + " went over 21.");
            winnerCase = "lose";
        } else if (playersFinalScore == dealersFinalScore) {
            System.out.println("Its a draw! Bet returned to player ");
            winnerCase = "draw";
        } else if (dealersFinalScore == 0 || dealersFinalScore == 21) {
            System.out.println(name + " looses! Dealer got a BlackJack ");
            winnerCase = "lose";
        } else if (playersFinalScore == 0 || playersFinalScore == 21) {
            System.out.println(name + " wins! " + name + " got a BlackJack!");
            winnerCase = "blackjack";
        } else if (playersFinalScore > 21) {
            System.out.println("Dealer wins! " + name + " went over 21.");
            winnerCase = "lose";
        } else if (dealersFinalScore > 21) {
            System.out.println(name + " wins! Dealer went over 21.");
            winnerCase = "win";
        } else if (playersFinalScore > dealersFinalScore) {
            System.out.println(name + " wins! ");
            winnerCase = "win";
        } else {
            System.out.println("Dealer wins!");
            winnerCase = "lose";
        }
        System.out.println("*******************************************");
        updateScore(winnerCase);
    }

    //Method used to prompt user to determine if they want to continue playing or end game, also resetting game if player wanted to continue playing
    private void prompUserToContinuePlayingBlackJack() {
        System.out.println();
        System.out.println("Would you like to play another hand? ");
        System.out.println("Type 'Y' to play another hand or 'N' to end BlackJack.");
        String endOfGame = scanner.nextLine().toUpperCase();

        while (!("Y".equals(endOfGame) || "N".equals(endOfGame))) {
            System.out.println("Type 'Y' to play another hand or 'N' to end BlackJack.");
            endOfGame = scanner.nextLine().toUpperCase();
        }

        if ("Y".equals(endOfGame)) {
            setHandBlackjack(false);
            resetGame(player.getName(), player.getPurse());
        } else {
            System.out.println("Final Score: " + player.getPurse());
            board.update(player);
            setBlackJackOver(true);
        }
    }

    private void resetGame(String name, Double score) {
        player = new Player(name, score);
        dealer = new Dealer();
    }

    //Method used to print out goodbye message
    private void goodbyeMessage() {
        String goodbye = "";

        try {
            goodbye = Files.readString(Path.of("resources/goodbye_banner.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(goodbye);
    }

    //Method used to determine if dealer is done taking additional card, if they have a BlackJack or their score is over 17
    private Boolean isDealerDone() {
        return dealer.getHand().getHandScore() != 0 && dealer.getHand().getHandScore() < 17;
    }

    // Method used to determine the Players winnings or looses
    private void updateScore(String winnerCase) {
        switch (winnerCase) {
            case "lose":
                // player loses, bet taken by dealer
                pot = 0;
                break;
            case "win":
                // player wins, win bet amount; ex: bet 20, add 20*2
                player.addWinnings(pot * 2);
                pot = 0;
                break;
            case "blackjack":
                // player wins blackJack, win bet amount x 1.5;  ex: bet 20, add 20*2.5
                player.addWinnings(pot * 2.5);
                pot = 0;
                break;
            case "draw":
                // draw (or push), player retains bet; ex: bet 20, add 20
                player.addWinnings(pot);
                pot = 0;
                break;
        }
    }

    // Accessor Methods - Setter and Getters
    public boolean isHandBlackjack() {
        return isHandBlackjack;
    }

    public void setHandBlackjack(boolean handBlackjack) {
        isHandBlackjack = handBlackjack;
    }

    public boolean isBlackJackOver() {
        return isBlackJackOver;
    }

    public void setBlackJackOver(boolean blackJackOver) {
        isBlackJackOver = blackJackOver;
    }
}