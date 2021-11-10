package com.blackjack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandImage implements Serializable {
    String cardSymbol;
    List<StringBuilder> cardImage = new ArrayList<>();
    Map<String, String[]> tempaltes = new HashMap<>();


    public HandImage() {
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        cardImage.add(new StringBuilder());
        initializeSuitTemplates();
    }



//    String[] template = new String[]{
//            ".------.\t" + "",
//            "|" + getCardSymbol() + ".--. |\t" + "",
//            "| (\\/) |\t" + "",
//            "| :\\/: |\t" + "",
//            "| '--'" + getCardSymbol() + "|\t" + "",
//            "`------'\t" + ""
//
//    };


    public void createHand(String symbol, String suit) {
        String[] template = getTempaltes().get(suit);
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

    public void printHand() {
        for (StringBuilder row : cardImage) {
            System.out.println(row);

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
        getTempaltes().put("hearts", heartsTemplate);
        getTempaltes().put("clubs", clubsTemplate);
        getTempaltes().put("spades", spadesTemplate);
        getTempaltes().put("diamonds", diamondsTemplate);

    }

    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public Map<String, String[]> getTempaltes() {
        return tempaltes;
    }

    public void setTempaltes(Map<String, String[]> tempaltes) {
        this.tempaltes = tempaltes;
    }
}