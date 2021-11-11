package com.blackjack.client;

import com.blackjack.controller.BlackJackApp;

class Main {
    public static void main(String[] args) {
        BlackJackApp app = BlackJackApp.getInstance();
        app.playGame();
    }
}