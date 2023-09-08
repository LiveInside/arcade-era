package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO getGameById(Integer id);

    List<GameDTO> getAllGames();

    void createOrUpdateGame(GameDTO gameDTO);

    void deleteGame(Integer id);
}
