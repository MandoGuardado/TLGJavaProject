package com.blackjack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand implements Serializable {
    //Fields
    private Map<String, Card> handCards = new HashMap<>();
    private List<Integer> cardValues;
    private HandImage cardImages = new HandImage();
    private Integer handScore;


    //Business methods
    public void updateInfo() {
        List<Integer> result = new ArrayList<>();
        Integer sum = 0;
        for (Map.Entry<String, Card> entry : getHandCards().entrySet()) {
            Card card = entry.getValue();
            result.add(card.getValue());

            sum += card.getValue();
        }
        setCardValues(result);
        setHandScore(sum);

    }
    //Method being used to determine if the hand contains a BlackJack
    public Integer calculateScore() {
        int result = getHandScore();

        if (getHandScore() == 21 && getCardValues().size() == 2) {
            result = 0;
        }
        if (getCardValues().contains(11) && getHandScore() > 21) {
            int returnIndex = getCardValues().indexOf(11);
            getCardValues().set(returnIndex, 1);
            updateCardValues();
            result = getHandScore();
        }

        setHandScore(result);

        return result;
    }

    private void updateCardValues() {
        int result= 0;
        for (Integer value:cardValues) {
            result += value;
        }
        setHandScore(result);
    }


    //Accessor Methods
    public Map<String, Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(Map<String, Card> handCards) {
        this.handCards = handCards;
    }

    public List<Integer> getCardValues() {
        return cardValues;
    }

    public void setCardValues(List<Integer> cardValues) {
        this.cardValues = cardValues;
    }

    public HandImage getCardImages() {
        return cardImages;
    }

    public void setCardImages(HandImage cardImages) {
        this.cardImages = cardImages;
    }

    public Integer getHandScore() {
        return handScore;
    }

    public void setHandScore(Integer handScore) {
        this.handScore = handScore;
    }

}