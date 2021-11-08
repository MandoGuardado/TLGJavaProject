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
import java.util.Collection;
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
    private Map<Double, Player> rankMap = new TreeMap<>();    // Player data to display <Score, Player>

    private  ScoreBoard() {
        // prevent new
    }

    public void update(Player player) {

        // if player score is higher than lowest on scoreboard, put the new player on the board
        for (Double score : rankMap.keySet()){
            if (player.getScore() > score) {  // TODO: ties
                rankMap.put(player.getScore(), player);
            }
            // only factoring for score right now
            // to include difficulty
            // TODO: crop the TreeSet to 10 MAX
        }
        // else nothing
    }

    public void display() {
        System.out.println("BLACKJACK BETS HIGHSCORE BOARD");
        System.out.println("==============================");
        Collection<Player> topPlayers = rankMap.values();
        for (Player player: topPlayers) {
            System.out.println(player);
        }
        System.out.println();
    }
}