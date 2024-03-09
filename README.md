# Custom Card Game Overview

This project develops a Java-based two-player card game that simulates a custom card game played by the computer. The custom game logic, card handling, and user interactions are described in detail at the end of this file. This file contains the guidelines to run this game and perform unit tests in an IDE as well as in a Terminal environment.

## Prerequisites

Before running the game, ensure you have the following:

- **Java Development Kit (JDK) 17 or higher** installed.
- **VSCode,** **IntelliJ** or any other Java IDE.
- **Gradle 7.3 or higher** if you are using **Gradle** to build the project.

## Installation

### Running on VSCode or other IDE

- Clone this repository to your local machine:
```bash
  git clone https://github.com/muhammadajlal/Custom-Card-Game.git
```

- Open the folder as a Java project in VSCode or your preferred Java IDE.

- Compile and run the game using the provided run extensions, build scripts or IDE commands.

-The output will be shown in the console.


### Running on Terminal
Please make sure the terminal is open in directory src/main/java/mycardgame.
```bash
  javac CardGame.java
```
```bash
  java CardGame
```
## Testing

In this project I have used **JUnit 5** for testing. **JUnit 5** is a popular testing framework for Java that provides a powerful and flexible way to write unit tests.

### Running Tests on VSCode or any other IDE

To run the tests, follow these steps:

- Make sure you have the necessary dependencies set up, including JUnit.

- Run the tests using your preferred method, 

  - Navigate to the `CardGameTest.java` file within your IDE and right-click and select "Run" in IDEs like VSCode IntelliJ IDEA.
  - Otherwise, click on the testing tab located on the side menu bar of your IDE e.g., in VSCode it is located on left side menu bar above the gradle tab. 
  

### Running Tests on Terminal

Make sure you are in the project root directory (C:\Users\ajlal\MyCardGame\app) when running these commands.
```bash
javac --module-path <path_to_junit_jupiter_api_and_engine_jars> -d target/test-classes --module-source-path src/test/java -m mycardgame/mycardgame.CardGameTest <your_java_version>
```
```bash
java --module-path <path_to_junit_jupiter_engine_and_platform_jars>:target/test-classes --module mycardgame/mycardgame.CardGameTest
```
These commands will compile the CardGameTest class and its dependencies, and then run the tests in the mycardgame.CardGameTest class.

Please make sure to replace placeholders with your actual data For example, if you're using Java 17, use 17 instead of <your_java_version> and etcetera.

## Game Rules and Implementation Logics 
This game is devloped by the following the special rules and logics which are good enough to test your OOP and DSA concepts. 
### Rule Logic 1: Create a shuffled deck of cards
- Each card shows a number from 1 to 10. Each number is in the deck four times for a total of 40 cards. At the beginning of the game, the deck is shuffled (Hint: Look up Fisher-Yates Shuffle Algorithm) to make sure it is in a random order. Each player receives a stack of 20 cards from the shuffled deck as their draw pile. The draw pile is kept face-down in front of the player. Each player also keeps a discard pile (see "Task 3" for more). Tests: 
  - A new deck should contain 40 cards
  - A shuffle function should shuffle a deck 
  - Hint: Consider mocking Math.random() or the equivalent of your chosen language

### Rule Logic 2: Draw cards
- Each turn, both players draw the top card. If there are no more cards in the draw pile, shuffle the discard pile and use those cards as the new draw pile. Once a player has no cards in either their draw or discard pile, that player loses. Test: 
  - If a player with an empty draw pile tries to draw a card, the discard pile is shuffled into the draw pile

### Rule Logic 3: Playing a turn
- The players present their drawn card and compare the values. The player with the higher value card, takes both cards and adds them to their discard pile, next to the draw pile. If the cards show the same value, the winner of the next turn wins these cards as well. If a tie situation appears multiple times in a row the winner after the tied rounds receives the cards from all tied rounds. Hint: The game will likely result in a stalemate, if this rule is not implemented. Tests:
  - When comparing two cards, the higher card should win
  - When comparing two cards of the same value, the winner of the next round should win 4 cards

### Rule Logic 4: Console Output
- Your program should output the cards that are played each turn and who wins. At the end the program should output the player that won.

![Screenshot 2024-03-09 135840](https://github.com/muhammadajlal/Custom-Card-Game/assets/144449514/39e6f268-3b59-426c-b791-c2a4f02c3120)

