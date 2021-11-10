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
import java.text.DecimalFormat;
import java.util.*;

public class ScoreBoard implements Serializable {

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

    private SortedMap<Double, String> playerMap = new TreeMap<>();      // player ranked by score <Score, Name>
    private Map<Integer, Player> rankMap = loadMaps();    // Player data to display <Rank, Player(Score, Name)>


    private  ScoreBoard() {
        // prevent new
    }

    public void update(Player player) {

        if (player.getPurse() > playerMap.firstKey()) {
            playerMap.put(player.getPurse(), player.getName());
            playerMap.remove(playerMap.firstKey());
        }
//
//        for (Map.Entry<Double, String> entry : playerMap.entrySet()) {
//            if (player.getPurse() >= entry.getKey()) {
//                playerMap.put(player.getPurse(), player.getName());
//                playerMap.remove(playerMap.firstKey());
//                break;
//                }
//            }

        updateRankMap();

    }

    private Map<Integer, Player> loadMaps() {
        // TODO if dat file doesn't exist, read OG from csv

        Map<Integer, Player> map = new TreeMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("data/simple-scoreboard.csv"));
            for (String line: lines){
                String[] tokens = line.split(",");
                int rank = Integer.parseInt(tokens[0]);
                double score = Double.parseDouble(tokens[1]);
                String name = tokens[2];

                // fill playerMap here to get rank structure
                this.playerMap.put(score, name);

                // fill rankMap
                Player player = new Player(name, score);
                map.put(rank, player);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private void updateRankMap(){
        int rank = 5;

        // rewrite rankMap w/ updated players
        for (Map.Entry<Double, String> entry : playerMap.entrySet()) {
            Player player = new Player(entry.getValue(), entry.getKey());

            rankMap.replace(rank, player);
            rank -= 1;
        }
    }

    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))){
            out.writeObject(this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        System.out.println("BLACKJACK BETS HIGHSCORE BOARD");
        System.out.println("==============================");
        System.out.println("Rank     Score     Name");

        // display is printing from the playerMap
        for(Map.Entry<Integer, Player> entry : rankMap.entrySet()){

            int rank = entry.getKey();
            double score = entry.getValue().getPurse();
            String name = entry.getValue().getName();

            DecimalFormat format = new DecimalFormat("0.#");

            System.out.println(rank + "        " + format.format(score) + "       " + name);
        }

        // TODO: at the end of display, rewrite the csv file to start up next time
        save();


    }

    public Set<String> getRankedNames(){
        return new HashSet<>(playerMap.values());
    }

}