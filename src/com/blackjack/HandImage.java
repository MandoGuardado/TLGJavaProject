package com.blackjack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandImage implements Serializable {
    //Fields
    private String cardSymbol;
    private List<StringBuilder> cardImage = new ArrayList<>();
    private Map<String, String[]> suitTemplates = new HashMap<>();

    //Constructors
    public HandImage() {
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        initializeSuitTemplates();
    }

    //Business Methods
    public void createHand(String symbol, String suit) {
        String[] template = getSuitTemplates().get(suit);
        setCardSymbol(symbol);
        for (int i = 0; i < cardImage.size(); i++) {
            if (i == 1) {
                template[i] = "|" + getCardSymbol() + ".--. |\t" + "";
            } else if (i == 4) {
                template[i] = "| '--'" + getCardSymbol() + "|\t" + "";
            }
            cardImage.get(i).append(template[i]);
        }

    }


    private void initializeSuitTemplates() {
        String[] heartsTemplate = new String[]{
                ".------.\t" + "",
                "|" + getCardSymbol() + ".--. |\t" + "",
                "| (\\/) |\t" + "",
                "| :\\/: |\t" + "",
                "| '--'" + getCardSymbol() + "|\t" + "",
                "`------'\t" + ""

        };
        String[] diamondsTemplate = new String[]{

                ".------.\t" + "",
                "|" + getCardSymbol() + ".--. |\t" + "",
                "| :/\\: |\t" + "",
                "| (__) |\t" + "",
                "| '--'" + getCardSymbol() + "|\t" + "",
                "`------'\t" + ""

        };
        String[] spadesTemplate = new String[]{
                ".------.\t" + "",
                "|" + getCardSymbol() + ".--. |\t" + "",
                "| (\\/) |\t" + "",
                "| :\\/: |\t" + "",
                "| '--'" + getCardSymbol() + "|\t" + "",
                "`------'\t" + ""

        };
        String[] clubsTemplate = new String[]{

                ".------.\t" + "",
                "|" + getCardSymbol() + ".--. |\t" + "",
                "| :(): |\t" + "",
                "| ()() |\t" + "",
                "| '--'" + getCardSymbol() + "|\t" + "",
                "`------'\t" + ""
        };
        getSuitTemplates().put("hearts", heartsTemplate);
        getSuitTemplates().put("clubs", clubsTemplate);
        getSuitTemplates().put("spades", spadesTemplate);
        getSuitTemplates().put("diamonds", diamondsTemplate);

    }

    //Accessor Methods
    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public List<StringBuilder> getCardImage() {
        return cardImage;
    }

    public void setCardImage(List<StringBuilder> cardImage) {
        this.cardImage = cardImage;
    }

    public Map<String, String[]> getSuitTemplates() {
        return suitTemplates;
    }

    public void setSuitTemplates(Map<String, String[]> suitTemplates) {
        this.suitTemplates = suitTemplates;
    }
}