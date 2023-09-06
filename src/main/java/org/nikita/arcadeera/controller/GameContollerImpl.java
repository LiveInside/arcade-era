package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.service.GameService;
import org.nikita.arcadeera.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameContollerImpl implements GameController {
    private final GameService gameService;

    @Autowired
    public GameContollerImpl(GameService gameService) {
        this.gameService = gameService;
    }

    // Реализация методов контроллера
}
