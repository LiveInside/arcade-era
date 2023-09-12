package org.nikita.arcadeera.controller.impl;

import lombok.AllArgsConstructor;
import org.nikita.arcadeera.controller.GameController;
import org.nikita.arcadeera.dto.request.GameCreateRequest;
import org.nikita.arcadeera.dto.request.GameUpdateRequest;
import org.nikita.arcadeera.dto.response.GameDTO;
import org.nikita.arcadeera.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GameControllerImpl implements GameController {
    private final GameService gameService;

    @Override
    public ResponseEntity<GameDTO> getGameById(Integer id) {
        return ResponseEntity.ok().body(gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<List<GameDTO>> getAllGames() {
        return ResponseEntity.ok().body(gameService.getAllGames());
    }

    @Override
    public ResponseEntity<GameDTO> createGame(GameCreateRequest gameCreateRequest) {
        return ResponseEntity.ok().body(gameService.createGame(gameCreateRequest));
    }

    @Override
    public ResponseEntity<GameDTO> updateGame(GameUpdateRequest gameUpdateRequest, Integer id) {
        return ResponseEntity.ok().body(gameService.updateGame(gameUpdateRequest, id));
    }

    @Override
    public ResponseEntity<Void> deleteGame(Integer id) {
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}
