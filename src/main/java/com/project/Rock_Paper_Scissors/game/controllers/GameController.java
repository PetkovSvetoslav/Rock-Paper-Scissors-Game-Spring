package com.project.Rock_Paper_Scissors.game.controllers;

import com.project.Rock_Paper_Scissors.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

//    @PostMapping("/start")
    @RequestMapping(value = "/start", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> startGame() {
        gameService.startNewGame();
        return ResponseEntity.ok("Game started. Make your move!");
    }

//    @PostMapping("/move")
    @RequestMapping(value = "/move", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> makeMove(@RequestParam("playerMove") String playerMove) {
        try {
            String result = gameService.playRound(playerMove);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PostMapping("/terminate")
@RequestMapping(value = "/terminate", method = {RequestMethod.GET, RequestMethod.POST})
public ResponseEntity<String> terminateGame() {
        gameService.terminateGame();
        return ResponseEntity.ok("Game terminated.");
    }
}

