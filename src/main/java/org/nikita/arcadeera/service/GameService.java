package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.RequestGameDTO;
import org.nikita.arcadeera.dto.response.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO getGameById(Integer id);

    List<GameDTO> getAllGames();

    GameDTO createGame(GameDTO gameDTO);

    GameDTO updateGame(RequestGameDTO gameDTO, Integer id);

    void deleteGame(Integer id);
}
