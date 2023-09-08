package org.nikita.arcadeera.controller.impl;

import lombok.AllArgsConstructor;
import org.nikita.arcadeera.controller.GameController;
import org.nikita.arcadeera.dto.GameDTO;
import org.nikita.arcadeera.service.GameService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GameControllerImpl implements GameController {
    private final GameService gameService;

    @Override
    public GameDTO getGameById(Integer id) {
        return gameService.getGameById(id);
    }

    @Override
    public List<GameDTO> getAllGames() {
        return gameService.getAllGames();
    }

    @Override
    public void createOrUpdateGame(GameDTO gameDTO) {
        gameService.createOrUpdateGame(gameDTO);
    }

    @Override
    public void deleteGame(Integer id) {
        gameService.deleteGame(id);
    }
}
