package com.blackjack;

/*
 *  ScoreBoard of top players
 *
 *  Rank        Score       Name
 *  ----        ----        ----
 *  1
 *  2
 *
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.*;

public class ScoreBoard implements Serializable {
    // Fields
    private static final String dataFilePath = "resources/scoreBoard.dat";
    private SortedMap<Double, String> playerData = new TreeMap<>();      // player ranked by score <Score, Name>
    private Map<Integer, Player> rankMap = loadMaps();    // Player data to display <Rank, Player(Score, Name)>

    // Constructors
    ScoreBoard() {
        // prevent new
    }

    // Retrieve old scoreboard data, or create new board if first game
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

    // Business Methods
    // Used to update player data after games
    public void update(Player player) {
        if (player.getPurse() > playerData.firstKey()) {
            playerData.put(player.getPurse(), player.getName());
            playerData.remove(playerData.firstKey());
        }
        updateRankMap();
    }

    // Update the Rank structure
    private void updateRankMap(){
        int rank = 5;

        // rewrite rankMap w/ updated players
        for (Map.Entry<Double, String> entry : playerData.entrySet()) {
            Player player = new Player(entry.getValue(), entry.getKey());

            rankMap.replace(rank, player);
            rank -= 1;
        }
    }

    // Display the Highscore Board at the end of the Game
    public void display() {
        String boardBanner = "";

        try {
            boardBanner = Files.readString(Path.of("resources/highscore_board.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(boardBanner);
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

    // Load Map data at the beginning of the game
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

    // Save board for future games
    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))){
            out.writeObject(this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Accessor Methods
    public Set<String> getRankedNames(){
        return new HashSet<>(playerData.values());
    }

    public Map<Integer, Player> getRankMap() {
        return rankMap;
    }

    public Map<Double, String> getPlayerData() {
        return playerData;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " playerData=" + getPlayerData() +
                ", rankMap=" + getRankMap();
    }
}