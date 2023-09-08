package org.nikita.arcadeera.converter;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.dto.GameDTO;
import org.nikita.arcadeera.entity.Game;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class GameConverter implements Converter<Game, GameDTO> {
    @Override
    public GameDTO toDTO(Game game) {
        return new GameDTO()
                .setId(game.getId())
                .setName(game.getName())
                .setPlatform(game.getPlatform())
                .setGenre(game.getGenre())
                .setPrice(game.getPrice())
                .setAgeRating(game.getAgeRating())
                .setUserEvaluation(game.getUserEvaluation())
                .setHide(game.isHide())
                .setUsers(game.getUsers());
    }

    @Override
    public Game toEntity(GameDTO gameDTO) {
        return new Game()
                .setId(gameDTO.getId())
                .setName(gameDTO.getName())
                .setPlatform(gameDTO.getPlatform())
                .setGenre(gameDTO.getGenre())
                .setPrice(gameDTO.getPrice())
                .setAgeRating(gameDTO.getAgeRating())
                .setUserEvaluation(gameDTO.getUserEvaluation())
                .setHide(gameDTO.isHide())
                .setUsers(gameDTO.getUsers());

    }
}
