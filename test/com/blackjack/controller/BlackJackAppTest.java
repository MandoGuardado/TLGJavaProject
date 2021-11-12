package com.blackjack.controller;

import com.blackjack.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackAppTest {
    private BlackJackApp app;

    @Before
    public void setUp() {
        app = BlackJackApp.getInstance();
        Player player = new Player("John");
    }

    @Test
    public void testGetInstance_shouldReturnBlackJackObject_whenGetInstanceIsCalled() {
        assertNotNull(app);
    }

    @Test
    public void name() {
        assertSame(app.getClass(), BlackJackApp.getInstance().getClass());

    }
}