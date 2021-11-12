package com.blackjack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandImage implements Serializable {
    //Fields
    private StringBuilder cardSymbol;                               //Variable that will hold the Symbol of the Card
    private List<StringBuilder> cardImage = new ArrayList<>();      //List that holds 6 rows of StringBuilder
    private Map<String, String[]> suitTemplates = new HashMap<>();  //Map to store suit Templates

    //Constructors
    public HandImage() {                                            //On instantiation crates List with six rows of String Builders
        getCardImage().add(new StringBuilder());
        getCardImage().add(new StringBuilder());
        getCardImage().add(new StringBuilder());
        getCardImage().add(new StringBuilder());
        getCardImage().add(new StringBuilder());
        getCardImage().add(new StringBuilder());
        initializeSuitTemplates();
    }

    //Business Methods
    public void createHand(String symbol, String suit) {            // Method to creates the Current Hand Image
        setCardSymbol(new StringBuilder());                         //StringBuilder Object is creates
        getCardSymbol().append(symbol);                             // It is immediately appended to include the symbol being sent it.
        String[] template = getSuitTemplates().get(suit);           // Using suit passed in as key to get correct template and assigning it to template variable
        if(!("10".equals(symbol))){                                 // If the card symbol being passed in is not '10', a space is appended to CardSymbol variable
            getCardSymbol().append(" ");
        }
        for (int i = 0; i < cardImage.size(); i++) {                //This for loop cycle through each row and appends the new card rows
            if (i == 1) {                                           //If row 2(index 1) then it inserts the cardSymbol value
                template[i] = "|" + getCardSymbol() + ".--. |\t" + "";
            } else if (i == 4) {                                    //If row 5(index 4) then it inserts the cardSymbol value
                template[i] = "| '--'" + getCardSymbol() + "|\t" + "";
            }
            cardImage.get(i).append(template[i]);                   //If not row 1 or 4 then it just adds the designated template row.
        }

    }

    //Method used when new object is create after Player is created.
    private void initializeSuitTemplates() {
        String[] heartsTemplate = new String[]{
                ".-------.\t" + "",
                "|" + getCardSymbol() + ".--. |\t" + "",
                "| (\\/)  |\t" + "",
                "| :\\/:  |\t" + "",
                "| '--'" + getCardSymbol() + "|\t" + "",
                "`-------'\t" + ""

        };
        String[] diamondsTemplate = new String[]{

                ".-------.\t" + "",
                "|" + getCardSymbol() + ".--. |\t" + "",
                "| :/\\:  |\t" + "",
                "| (__)  |\t" + "",
                "| '--'" + getCardSymbol() + "|\t" + "",
                "`-------'\t" + ""

        };
        String[] spadesTemplate = new String[]{
                ".-------.\t" + "",
                "|" + getCardSymbol() + ".--. |\t" + "",
                "| (\\/)  |\t" + "",
                "| :\\/:  |\t" + "",
                "| '--'" + getCardSymbol() + "|\t" + "",
                "`-------'\t" + ""

        };
        String[] clubsTemplate = new String[]{

                ".-------.\t" + "",
                "|" + getCardSymbol() + ".--. |\t" + "",
                "| :():  |\t" + "",
                "| ()()  |\t" + "",
                "| '--'" + getCardSymbol() + "|\t" + "",
                "`-------'\t" + ""
        };
        //This adds them to the Map, key = suit(String), value = suitTemplates(String[])
        getSuitTemplates().put("hearts", heartsTemplate);
        getSuitTemplates().put("clubs", clubsTemplate);
        getSuitTemplates().put("spades", spadesTemplate);
        getSuitTemplates().put("diamonds", diamondsTemplate);

    }

    //Accessor Methods
    public StringBuilder getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(StringBuilder cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public List<StringBuilder> getCardImage() {
        return cardImage;
    }

    public Map<String, String[]> getSuitTemplates() {
        return suitTemplates;
    }

}