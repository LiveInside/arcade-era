package org.nikita.arcadeera.converter.game;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.response.GameDTO;
import org.nikita.arcadeera.entity.Game;
import org.nikita.arcadeera.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class GameConverterToDTO implements Converter<Game, GameDTO> {
    @Override
    public GameDTO convert(Game game) {
        if (Objects.isNull(game)) {
            throw new ResourceNotFoundException("Игра не найдена");
        }
        return new GameDTO().setName(game.getName())
                .setPlatform(game.getPlatform())
                .setGenre(game.getGenre())
                .setPrice(game.getPrice())
                .setAgeRating(game.getAgeRating())
                .setUserEvaluation(game.getUserEvaluation())
                .setHide(game.isHide());
    }
}
