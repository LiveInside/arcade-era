package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.GameDTO;

import java.util.List;

public interface GameService{
    void createGame(GameDTO gameDTO);
    GameDTO getGameById(Integer id);
    List<GameDTO> getAllGames();
    void updateGame(Integer id, GameDTO gameDTO);
    void deleteGame(Integer id);
}
