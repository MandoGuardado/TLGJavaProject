package com.blackjack;

/*
 * ScoreBoard of all players
 *
 * Map<Rank, Player> scoreMap;
 *  Rank        Score       Name
 *  ----        ----        ----Score       Difficulty
 *  1           "Name", score: (finalChipValue), difficulty
 *  2           String, double, String
 *
 * Map<Integer, Player>
 *
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.*;

public class ScoreBoard implements Serializable {

    private static final String dataFilePath = "resources/scoreBoard.dat";

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

    private SortedMap<Double, String> playerData = new TreeMap<>();      // player ranked by score <Score, Name>
    private Map<Integer, Player> rankMap = loadMaps();    // Player data to display <Rank, Player(Score, Name)>


    ScoreBoard() {
        // prevent new
    }

    public void update(Player player) {

        if (player.getPurse() > playerData.firstKey()) {
            playerData.put(player.getPurse(), player.getName());
            playerData.remove(playerData.firstKey());
        }

        updateRankMap();
    }

    private Map<Integer, Player> loadMaps() {
        Map<Integer, Player> map = new TreeMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("resources/starter-scoreboard.csv"));
            for (String line: lines){
                String[] tokens = line.split(",");
                int rank = Integer.parseInt(tokens[0]);
                double score = Double.parseDouble(tokens[1]);
                String name = tokens[2];

                // fill playerMap here to get rank structure
                this.playerData.put(score, name);

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
        for (Map.Entry<Double, String> entry : playerData.entrySet()) {
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
        System.out.println("----     -----     ----");

        // printing from the playerMap
        for(Map.Entry<Integer, Player> entry : rankMap.entrySet()){

            int rank = entry.getKey();
            double score = entry.getValue().getPurse();
            String name = entry.getValue().getName();

            DecimalFormat format = new DecimalFormat("0.#");

            System.out.println(rank + "        " + format.format(score) + "       " + name);
        }

        save();
    }

    public Set<String> getRankedNames(){
        return new HashSet<>(playerData.values());
    }

    public Map<Integer, Player> getRankMap() {
        return rankMap;
    }

    public Map<Double, String> getPlayerData() {
        return playerData;
    }
}