package com.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HandImageTest {

    private HandImage handImage;

    @Before
    public void setUp() {
        handImage = new HandImage();
        handImage.createHand(Card.EIGHT_DIAMONDS.getSymbol(), Card.EIGHT_DIAMONDS.getSuit());
    }

    @Test
    public void testCreateHand_whenNewCardIsTaken_ShouldUsePrintOutDiamondTemplate() {
        String symbol = "8 ";
        assertEquals("[.-------.\t, |8 .--. |\t, | :/\\:  |\t, | (__)  |\t, | '--'8 |\t, `-------'\t]", Arrays.toString(handImage.getCardImage().toArray(new StringBuilder[0])));

    }
}