# Rock-Paper-Scissors Game Web Service

This project is a simple Rock-Paper-Scissors game implemented as a RESTful web service using Spring Boot. 
It allows a player to start a game, make moves, and terminate the game via API endpoints.

## Features

- Start Game: Initializes a new game session.
- Make Move: Allows the player to submit their move (rock, paper, or scissors) and play against the computer.
- Terminate Game: Terminates the current game session.

## Requirements

- Java 17 or higher
- Maven 3.6+
- Spring Boot 3.x.x
- Optional: Postman for testing the endpoints

## Getting Started

1. Clone the repository

git clone https://github.com/PetkovSvetoslav/Rock-Paper-Scissors-Game-Task-Spring-Solution.git

cd Rock-Paper-Scissors-Game-Task-Spring-Solution

2. Build the project
mvn clean install

3. Run the project
mvn spring-boot:run

The application will be accessible at http://localhost:8080.

## Endpoints

1. Start a New Game
URL: POST /game/start

Description: Initializes a new game session.

Request:
curl -X POST http://localhost:8080/game/start

Response:
Game started. Make your move!

2. Make a Move
URL: POST /game/move?playerMove={move}

Description: Submits the player's move (rock, paper, or scissors) and returns the result of the round against the computer.

Request:
curl -X POST "http://localhost:8080/game/move?playerMove=rock"
or
curl -X POST "http://localhost:8080/game/move?playerMove=paper"
or
curl -X POST "http://localhost:8080/game/move?playerMove=scissors"

Response:
Player chose (playerMove), Computer chose (random choice). You lose! or "You win!" or "It's a tie!"

3. Terminate the Game
URL: POST /game/terminate

Description: Terminates the current game session.

Request:
curl -X POST http://localhost:8080/game/terminate

Response:
Game terminated.

## Project Structure
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── project/
│   │           └── Rock_Paper_Scissors/
│   │               ├── game/
│   │               │   ├── controllers/
│   │               │   ├── exceptions/
│   │               │   ├── services/
│   │               └── RockPaperScissorsGameApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/
└── test/

## Future Enhancements
ToDo
Add session management to track multiple games.
Add game statistics to track wins, losses, and ties.
