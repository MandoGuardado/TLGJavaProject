package com.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ScoreBoardTest {
    private ScoreBoard testBoard;
    private Map<Double, String> testPlayerData;
    private Map<Integer, Player> testRanksMap;

    @Before
    public void setUp(){
        testBoard = new ScoreBoard();
    }

    @Test
    public void getInstance_shouldInitiallyPopulateRanksMap_whenCalled() {
        testRanksMap = testBoard.getRankMap();

        assertEquals(5, testRanksMap.size());
        assertEquals(testRanksMap.get(1).getName(), "Jay");
        assertEquals(testRanksMap.get(2).getName(), "Armando");
        assertEquals(testRanksMap.get(3).getName(), "Rian");
        assertEquals(testRanksMap.get(4).getName(), "Peach");
        assertEquals(testRanksMap.get(5).getName(), "Mario");
    }

    @Test
    public void getInstance_shouldInitiallyPopulatePlayerData_whenCalled() {
        testPlayerData = testBoard.getPlayerData();

        assertEquals(5, testPlayerData.size());
        assertEquals("Jay", testPlayerData.get(500.0));
        assertEquals("Armando", testPlayerData.get(400.0));
        assertEquals("Rian", testPlayerData.get(300.0));
        assertEquals("Peach", testPlayerData.get(200.0));
        assertEquals("Mario", testPlayerData.get(100.0));
    }

    @Test
    public void update_shouldChangePlayerData_whenPlayerScoreIsHigher() {
        Player testPlayer = new Player("test", 450);
        testBoard.update(testPlayer);

        testPlayerData = testBoard.getPlayerData();

        assertEquals(5, testPlayerData.size());
        assertEquals("Jay", testPlayerData.get(500.0));
        assertEquals("test", testPlayerData.get(450.0));
        assertEquals("Armando", testPlayerData.get(400.0));
        assertEquals("Rian", testPlayerData.get(300.0));
        assertEquals("Peach", testPlayerData.get(200.0));
        assertNotEquals("Mario", testPlayerData.get(100.0));
        //testBoard.display();
    }

    @Test
    public void update_shouldChangeRankMap_whenPlayerScoreIsHigher() {
        Player testPlayer = new Player("test", 450);
        testBoard.update(testPlayer);

        testRanksMap = testBoard.getRankMap();

        assertEquals(5, testRanksMap.size());assertEquals(testRanksMap.get(1).getName(), "Jay");
        assertEquals(testRanksMap.get(2).getName(), "test");assertEquals(testRanksMap.get(3).getName(), "Armando");
        assertEquals(testRanksMap.get(4).getName(), "Rian");
        assertEquals(testRanksMap.get(5).getName(), "Peach");
        testBoard.display();
    }

    @Test
    public void update_shouldChangePlayerData_whenPlayerScoreIsTheSame() {
        Player testPlayer = new Player("test", 450);
    }
}