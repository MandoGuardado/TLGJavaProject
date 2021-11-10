package com.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandImage {
    String cardSymbol;
    List<StringBuilder> cardImage = new ArrayList<>();
    Map<String, String[]> suitTemplates = new HashMap<>();


    public HandImage() {
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        initializeSuitTemplates();
    }


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

    public List<StringBuilder> getCardImage() {
        return cardImage;
    }

    public void setCardImage(List<StringBuilder> cardImage) {
        this.cardImage = cardImage;
    }

    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public Map<String, String[]> getSuitTemplates() {
        return suitTemplates;
    }

    public void setSuitTemplates(Map<String, String[]> suitTemplates) {
        this.suitTemplates = suitTemplates;
    }
}