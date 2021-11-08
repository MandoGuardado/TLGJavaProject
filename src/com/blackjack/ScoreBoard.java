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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ScoreBoard implements Serializable {

    private static final String dataFilePath = "data/simple-scoreboard.csv";
    private Map<Double, String> scoreMap = loadScoreMap();


    public static ScoreBoard getInstance() {
        ScoreBoard board = new ScoreBoard();

        // trying to get it to work, so commented out below

//        if (Files.exists(Path.of(dataFilePath))){
//            try  {
//                ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath));
//                board = (ScoreBoard) in.readObject();
//            }
//            catch (ClassNotFoundException | IOException e) {
//                e.printStackTrace();
//            }
//        }
//        else {
//            board = new ScoreBoard();
//        }
        return board;
    }
    private Map<Double, Player> rankMap = new TreeMap<>();    // Player data to display <Score, Player>

    private  ScoreBoard() {
        // prevent new
    }

    public void update(Player player) {
        // this is really ugly right now

        for (Double score: scoreMap.keySet()) { // is there a way to just check the smallest?
            if (player.getScore() > score){
                scoreMap.put(player.getScore(), player.getName());
            }
        }


           // for (Map.Entry<Double, String>)
                // if player score is higher than lowest on scoreboard, put the new player on the board
                for (Double score : rankMap.keySet()) {
                    if (player.getScore() > score) {  // TODO: ties
                        rankMap.put(player.getScore(), player);
                    //    ObjectOutputStream o = new ObjectOutputStream()
                    }
                    // only factoring for score right now
                    // to include difficulty
                    // TODO: crop the TreeSet to 10 MAX
                }

        // else nothing
    }

    private Map<Double, String> loadScoreMap() {
        Map<Double, String> map = new TreeMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("data/simple-scoreboard.csv"));
            for (String line: lines){
                String[] tokens = line.split(",");
                Double score = Double.valueOf(tokens[0]);
                String name = tokens[1];

                map.put(score, name);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void display() {
        System.out.println("BLACKJACK BETS HIGHSCORE BOARD");
        System.out.println("==============================");

        for (Map.Entry<Double, String> entry : scoreMap.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

    }
}