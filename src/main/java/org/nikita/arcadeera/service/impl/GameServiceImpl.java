package org.nikita.arcadeera.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.request.GameCreateRequest;
import org.nikita.arcadeera.dto.request.GameUpdateRequest;
import org.nikita.arcadeera.dto.response.GameDTO;
import org.nikita.arcadeera.entity.Game;
import org.nikita.arcadeera.exception.NotUpdated;
import org.nikita.arcadeera.repository.GameRepository;
import org.nikita.arcadeera.service.GameService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
@Validated
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final Converter<Game, GameDTO> gameConverterToDTO;
    private final Converter<GameDTO, Game> gameConverterToEntity;
    private final Converter<GameCreateRequest, Game> gameCreateConverterToEntity;

    @Override
    public @NotNull(message = "Игра не найдена") GameDTO get(Integer id) {
        Game game = gameRepository.findById(id).orElse(null);

        return gameConverterToDTO.convert(game);
    }

    @Override
    public List<GameDTO> getAll() {
        List<Game> games = gameRepository.findAll(); //Находим и извлекаем все игры из репозитория

        return games.stream()
                .map(gameConverterToDTO::convert)
                .toList(); // Собираем список DTO и возвращаем его
    }

    @Override
    public GameDTO create(GameCreateRequest gameCreateRequest) {
        Game game = gameCreateConverterToEntity.convert(gameCreateRequest);
        gameRepository.save(game); // Сохраняем

        return gameConverterToDTO.convert(game);
    }

    @Override
    public GameDTO update(GameUpdateRequest gameUpdateRequest, Integer id) throws NotUpdated {
        Game game = gameRepository.findById(id).orElse(null);
        if (game == null) {
            throw new NotUpdated();
        }
        GameDTO updatedGameDTO = gameConverterToDTO.convert(game);

       updatedGameDTO.setPrice(gameUpdateRequest.getPrice())
                .setUserEvaluation(gameUpdateRequest.getUserEvaluation())
                .setHide(gameUpdateRequest.isHide());

        Game updatedGame = gameConverterToEntity.convert(updatedGameDTO);
        gameRepository.save(updatedGame);

        return updatedGameDTO;
    }

    @Override
    public void delete(Integer id) {
        gameRepository.deleteById(id); // Удаляем
    }
}
