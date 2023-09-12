package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.GameCreateRequest;
import org.nikita.arcadeera.dto.request.GameUpdateRequest;
import org.nikita.arcadeera.dto.response.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO getGameById(Integer id);

    List<GameDTO> getAllGames();

    GameDTO createGame(GameCreateRequest gameCreateRequest);

    GameDTO updateGame(GameUpdateRequest gameUpdateRequest, Integer id);

    void deleteGame(Integer id);
}
