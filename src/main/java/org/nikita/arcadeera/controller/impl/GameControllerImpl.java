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
    public ResponseEntity<GameDTO> get(Integer id) {
        return ResponseEntity.ok().body(gameService.get(id));
    }

    @Override
    public ResponseEntity<List<GameDTO>> getAll() {
        return ResponseEntity.ok().body(gameService.getAll());
    }

    @Override
    public ResponseEntity<GameDTO> create(GameCreateRequest gameCreateRequest) {
        return ResponseEntity.ok().body(gameService.create(gameCreateRequest));
    }

    @Override
    public ResponseEntity<GameDTO> update(GameUpdateRequest gameUpdateRequest, Integer id) {
        return ResponseEntity.ok().body(gameService.update(gameUpdateRequest, id));
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
