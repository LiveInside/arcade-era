package org.nikita.arcadeera.converter.game;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.request.GameCreateRequest;
import org.nikita.arcadeera.entity.Game;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class GameCreateConverterToEntity implements Converter<GameCreateRequest, Game> {
    @Override
    public Game convert(GameCreateRequest gameCreateRequest) {
        if (Objects.isNull(gameCreateRequest)) {
            return null;
        }
        return new Game().setName(gameCreateRequest.getName())
                .setPlatform(gameCreateRequest.getPlatform())
                .setGenre(gameCreateRequest.getGenre())
                .setPrice(gameCreateRequest.getPrice())
                .setAgeRating(gameCreateRequest.getAgeRating())
                .setUserEvaluation(gameCreateRequest.getUserEvaluation())
                .setHide(gameCreateRequest.isHide());
    }
}
