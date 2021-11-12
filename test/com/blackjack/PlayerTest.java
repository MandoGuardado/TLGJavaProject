package com.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;
    private Deck deck = new Deck();

    @Before
    public void setUp() {
        player = new Player("Joe");
    }

    @Test
    public void testHit_shouldHaveOneCard_WhenHitIsCalled() {
        player.hit(deck);
        int result = player.getHand().getHandCards().size();
        assertEquals(1, result);
    }

    @Test
    public void testHit_shouldHaveThreeCards_WhenHitIsCalledThreeTimes() {
        player.hit(deck);
        player.hit(deck);
        player.hit(deck);
        int result = player.getHand().getHandCards().size();
        assertEquals(3, result);
    }

    @Test
    public void tesBet_whenUserBetsAmount_shouldRemoveItFromPurse() {
        player.bet(50.00);
        assertEquals(150.00,player.getPurse(), 0.001);
    }

    @Test
    public void tesAddWinnings_whenUserWinsGame_shouldAddBettingAmountToPurse() {
        player.addWinnings(50.00);
        assertEquals(250.00,player.getPurse(), 0.001);
    }


}