package com.blackjack;

/*
 * ScoreBoard of all players
 *
 * Map<Rank, Player> scoreMap;
 *  Rank        Player      Score
 *  ----        ----        Score       Difficulty
 *  1           "Name", score: (finalChipValue), difficulty
 *  2           String, double, String
 *
 * Map<Integer, String>
 *
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class ScoreBoard {

    private static final String dataFilePath = "data/scoreBoard.dat";

    public static ScoreBoard getInstance() {
        ScoreBoard board = null;

        if (Files.exists(Path.of(dataFilePath))){
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (ScoreBoard) in.readObject();
            }
            catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        else {
            board = new ScoreBoard();
        }
        return board;
    }

    private Map<Integer, String> scoreMap;    // Scores to compare people
    private Map<Integer, Player> rankMap = new TreeMap<>();    // Player data to display <Score, Player>



    private  ScoreBoard() {
        // prevent new
    }

    public void update() {
        // if player score is higher than lowest on scoreboard

    }

    public void display() {
        System.out.println("BLACKJACK BETS HIGHSCORE BOARD");
        System.out.println("==============================");
    }
}