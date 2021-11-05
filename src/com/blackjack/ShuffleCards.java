package com.blackjack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShuffleCards extends Thread  {
    private String message = "" ;

    public ShuffleCards() throws IOException {
        setName("Shuffle Reader");

        setMessage(Files.readString(Path.of("shuffling_banner.txt")));

    }


    public void run(){
        System.out.print(getMessage());

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}