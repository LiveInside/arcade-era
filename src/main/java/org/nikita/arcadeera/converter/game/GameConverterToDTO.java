package org.nikita.arcadeera.converter.game;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.response.GameDTO;
import org.nikita.arcadeera.entity.Game;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class GameConverterToDTO implements Converter<Game, GameDTO> {
    @Override
    public GameDTO convert(Game game) {
        if (Objects.isNull(game)) {
            log.info("Игра не найдена");
            return null;
        }
        return new GameDTO().setId(game.getId())
                .setName(game.getName())
                .setPlatform(game.getPlatform())
                .setGenre(game.getGenre())
                .setPrice(game.getPrice())
                .setAgeRating(game.getAgeRating())
                .setUserEvaluation(game.getUserEvaluation())
                .setHide(game.isHide());
    }
}
