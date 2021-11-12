@echo off

rem     Compile the application code
javac -d classes src\com\blackjack\*.java src\com\blackjack\client\*.java src\com\blackjack\controller\*.java

rem     Build the application JAR
jar --create --file BlackJackBets-0.1.jar -C classes .