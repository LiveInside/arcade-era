package org.nikita.arcadeera.converter.game;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.response.GameDTO;
import org.nikita.arcadeera.entity.Game;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class GameConverterToEntity implements Converter<GameDTO, Game> {

    @Override
    public Game convert(GameDTO gameDTO) {
        if (Objects.isNull(gameDTO)) {
            return null;
        }
        return new Game().setName(gameDTO.getName())
                .setPlatform(gameDTO.getPlatform())
                .setGenre(gameDTO.getGenre())
                .setPrice(gameDTO.getPrice())
                .setAgeRating(gameDTO.getAgeRating())
                .setUserEvaluation(gameDTO.getUserEvaluation())
                .setHide(gameDTO.isHide());
    }
}
