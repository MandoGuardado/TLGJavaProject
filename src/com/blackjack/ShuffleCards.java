package com.blackjack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShuffleCards extends Thread  {
    private String goodByeMessage = "" ;

    public ShuffleCards() throws IOException {
        setName("Shuffle Reader");

        setGoodByeMessage(Files.readString(Path.of("shuffling_banner.txt")));

    }


    public void run(){
        System.out.print(getGoodByeMessage());

        for (int i = 0; i < 75; i++) {
            System.out.print("*");
            try {
                Thread.sleep(50);

            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            
        }
    }

    public String getGoodByeMessage() {
        return goodByeMessage;
    }

    public void setGoodByeMessage(String goodByeMessage) {
        this.goodByeMessage = goodByeMessage;
    }
}