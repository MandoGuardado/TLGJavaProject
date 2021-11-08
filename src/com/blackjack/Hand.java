package com.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {

    private Map<String,Card> cards = new HashMap<>();
    private List<Integer> arrayValues;
    private String cardImages;
    private Integer handScore;
    
    
    //Business methods 
    
    public void updateInfo(){
        List<Integer> result = new ArrayList<>();
        Integer sum = 0;
        for (Map.Entry<String, Card> entry: getCards().entrySet()) {
            Card card = entry.getValue();
            result.add(card.getValue());

            sum += card.getValue();
        }
        setArrayValues(result);
        setHandScore(sum);
    }

    public Integer calculateScore(){
        int result = getHandScore();

        if(getHandScore() == 21 && getArrayValues().size() == 2){
            result = 0;
        }
        if(getArrayValues().contains(11) && getHandScore() > 21){
            int returnIndex = getArrayValues().indexOf(11);
            getArrayValues().set(returnIndex, 1);
            result = getHandScore();
        }

        setHandScore(result);

        return result;
    }
    
    
    
    
    
    
    //Accessor Methods

    public Map<String, Card> getCards() {
        return cards;
    }

    public void setCards(Map<String, Card> cards) {
        this.cards = cards;
    }

    public List<Integer> getArrayValues() {
        return arrayValues;
    }

    public void setArrayValues(List<Integer> arrayValues) {
        this.arrayValues = arrayValues;
    }

    public String getCardImages() {
        return cardImages;
    }

    public void setCardImages(String cardImages) {
        this.cardImages = cardImages;
    }

    public Integer getHandScore() {
        return handScore;
    }

    public void setHandScore(Integer handScore) {
        this.handScore = handScore;
    }
    
}