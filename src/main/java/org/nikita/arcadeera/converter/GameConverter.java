package org.nikita.arcadeera.converter;

import org.nikita.arcadeera.dto.GameDTO;
import org.nikita.arcadeera.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameConverter implements Converter<Game, GameDTO> {
    public GameDTO toDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(game.getId());
        gameDTO.setName(game.getName());
        gameDTO.setPlatform(game.getPlatform());
        gameDTO.setGenre(game.getGenre());
        gameDTO.setPrice(game.getPrice());
        gameDTO.setAgeRating(game.getAgeRating());
        gameDTO.setUserEvaluation(game.getUserEvaluation());
        gameDTO.setHide(gameDTO.isHide());
        gameDTO.setPublisher(gameDTO.getPublisher());
        gameDTO.setUsers(gameDTO.getUsers());
        return gameDTO;
    }
}
