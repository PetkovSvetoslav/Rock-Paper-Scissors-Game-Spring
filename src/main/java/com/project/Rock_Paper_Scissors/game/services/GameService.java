package com.project.Rock_Paper_Scissors.game.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class GameService {

    private boolean gameActive;
    private static final String[] MOVES = {"rock", "paper", "scissors"};
    private final Random random;

    public GameService() {
        this.random = new Random();
    }

    public void startNewGame() {
        this.gameActive = true;
    }

    public void terminateGame() {
        this.gameActive = false;
    }

    public String playRound(String playerMove) {
        if (!gameActive) {
            throw new IllegalStateException("No active game. Please start a game first.");
        }

        validatePlayerMove(playerMove);

        String computerMove = MOVES[random.nextInt(MOVES.length)];
        String outcome = determineOutcome(playerMove, computerMove);

        return "Player chose " + playerMove + ", Computer chose " + computerMove + ". " + outcome;
    }

    private void validatePlayerMove(String playerMove) {
        if (!Arrays.asList(MOVES).contains(playerMove.toLowerCase())) {
            throw new IllegalArgumentException("Invalid move. Choose rock, paper, or scissors.");
        }
    }

    private String determineOutcome(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It's a tie!";
        }

        switch (playerMove) {
            case "rock":
                return computerMove.equals("scissors") ? "You win!" : "You lose!";
            case "paper":
                return computerMove.equals("rock") ? "You win!" : "You lose!";
            case "scissors":
                return computerMove.equals("paper") ? "You win!" : "You lose!";
            default:
                throw new IllegalStateException("Unexpected value: " + playerMove);
        }
    }
}

