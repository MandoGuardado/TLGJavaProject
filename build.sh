#!/usr/bin/env sh

#     Compile the application code
javac -d classes src\com\blackjack\*.java src\com\blackjack\client\*.java src\com\blackjack\controller\*.java

#     Build the application JAR
jar --create --file BlackJackBets-1.0.jar -C classes .