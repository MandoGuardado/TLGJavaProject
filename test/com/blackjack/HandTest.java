package com.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class HandTest {

    private Dealer dealer;

    @Before
    public void setUp() {
        dealer = new Dealer();
        Hand dealersHand = dealer.getHand();
        Map<String, Card> cards = dealersHand.getHandCards();
        cards.put(Card.SIX_HEARTS.getName(),Card.SIX_HEARTS);
        cards.put(Card.TEN_DIAMONDS.getName(), Card.TEN_DIAMONDS);
        dealersHand.updateInfo();
    }
    @Test
    public void testCalculateScore_shouldStillBeSixTeen_whenCardSixAndTenAreGiven(){
        int result = dealer.getHand().calculateScore();
        assertEquals(16, result);

    }

    @Test
    public void testCalculateScore_shouldBeZero_whenAnAceHeartsAndTenAreGiven(){
        Dealer dealerTwo = new Dealer();
        Hand dealersHand = dealerTwo.getHand();
        Map<String, Card> cards = dealersHand.getHandCards();
        cards.put(Card.ACE_HEARTS.getName(), Card.ACE_HEARTS);
        cards.put(Card.TEN_DIAMONDS.getName(), Card.TEN_DIAMONDS);
        dealersHand.updateInfo();

        int result = dealerTwo.getHand().calculateScore();
        assertEquals(0, result);
    }

    @Test
    public void testCalculateScore_shouldBeZero_whenAnAceClubsAndTenAreGiven(){
        Dealer dealerTwo = new Dealer();
        Hand dealersHand = dealerTwo.getHand();
        Map<String, Card> cards = dealersHand.getHandCards();
        cards.put(Card.ACE_CLUBS.getName(), Card.ACE_CLUBS);
        cards.put(Card.TEN_DIAMONDS.getName(), Card.TEN_DIAMONDS);
        dealersHand.updateInfo();

        int result = dealerTwo.getHand().calculateScore();
        assertEquals(0, result);
    }
    @Test
    public void testCalculateScore_shouldBeZero_whenAnAceDiamondsAndTenAreGiven(){
        Dealer dealerTwo = new Dealer();
        Hand dealersHand = dealerTwo.getHand();
        Map<String, Card> cards = dealersHand.getHandCards();
        cards.put(Card.ACE_DIAMONDS.getName(), Card.ACE_DIAMONDS);
        cards.put(Card.TEN_DIAMONDS.getName(), Card.TEN_DIAMONDS);
        dealersHand.updateInfo();

        int result = dealerTwo.getHand().calculateScore();
        assertEquals(0, result);
    }

    @Test
    public void testCalculateScore_shouldBeZero_whenAnAceSpadesAndTenAreGiven(){
        Dealer dealerTwo = new Dealer();
        Hand dealersHand = dealerTwo.getHand();
        Map<String, Card> cards = dealersHand.getHandCards();
        cards.put(Card.ACE_SPADES.getName(), Card.ACE_SPADES);
        cards.put(Card.TEN_DIAMONDS.getName(), Card.TEN_DIAMONDS);
        dealersHand.updateInfo();

        int result = dealerTwo.getHand().calculateScore();
        assertEquals(0, result);
    }

    @Test
    public void testCalculateScore_shouldBe_whenAnAceClubsAndTenAreGiven(){
        Dealer dealerTwo = new Dealer();
        Hand dealersHand = dealerTwo.getHand();
        Map<String, Card> cards = dealersHand.getHandCards();
        cards.put(Card.TEN_HEARTS.getName(), Card.TEN_HEARTS);
        cards.put(Card.THREE_DIAMONDS.getName(), Card.THREE_DIAMONDS);
        cards.put(Card.ACE_CLUBS.getName(), Card.ACE_CLUBS);
        dealersHand.updateInfo();

        int result = dealerTwo.getHand().calculateScore();
        assertEquals(14, result);
    }


    @Test
    public void testUpdateInfo_shouldReturnSixTeen_whenCardSixAndTenAreGiven(){
        int result = dealer.getHand().getHandScore();
        assertEquals(16, result);

    }

}