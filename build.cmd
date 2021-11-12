@echo off

rem     Compile the application code
javac -d classes -classpath "lib\*" src\com\blackjack\*.java src\com\blackjack\client\*.java src\com\blackjack\controller\*.java

rem     Build the application JAR
jar --create --file BlackJackBets-1.0.jar -C classes .