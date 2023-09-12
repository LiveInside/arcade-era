package org.nikita.arcadeera.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.request.GameCreateRequest;
import org.nikita.arcadeera.dto.request.GameUpdateRequest;
import org.nikita.arcadeera.dto.response.GameDTO;
import org.nikita.arcadeera.entity.Game;
import org.nikita.arcadeera.exception.EmptyParamException;
import org.nikita.arcadeera.repository.GameRepository;
import org.nikita.arcadeera.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final Converter<Game, GameDTO> gameConverterToDTO;
    private final Converter<GameDTO, Game> gameConverterToEntity;
    private final Converter<GameCreateRequest, Game> gameCreateConverterToEntity;

    @Override
    public GameDTO getGameById(Integer id) {
        Game game = gameRepository.findById(id).orElse(null);
        return gameConverterToDTO.convert(game);
    }

    @Override
    public List<GameDTO> getAllGames() {
        List<Game> games = gameRepository.findAll(); //Находим и извлекаем все игры из репозитория
        return games.stream()
                .map(gameConverterToDTO::convert)
                .toList(); // Собираем список DTO и возвращаем его
    }

    @Override
    public GameDTO createGame(GameCreateRequest gameCreateRequest) {
        if (gameCreateRequest.getAgeRating() == null)
            throw new EmptyParamException("Поле AgeRating обязательно к заполнению");
        if (gameCreateRequest.getGenre() == null)
            throw new EmptyParamException("Поле Genre обязательно к заполнению");
        if (gameCreateRequest.getName() == null)
            throw new EmptyParamException("Поле Name обязательно к заполнению");
        if (gameCreateRequest.getPlatform() == null)
            throw new EmptyParamException("Поле Platform обязательно к заполнению");

        Game game = gameCreateConverterToEntity.convert(gameCreateRequest);
        gameRepository.save(game); // Сохраняем
        return gameConverterToDTO.convert(game);
    }

    @Override
    public GameDTO updateGame(GameUpdateRequest gameUpdateRequest, Integer id) {
        Game game = gameRepository.findById(id).orElse(null);
        GameDTO updatedGameDTO = gameConverterToDTO.convert(game);

        if (gameUpdateRequest.getPrice() != null) {
            updatedGameDTO.setPrice(gameUpdateRequest.getPrice());
        }
        if (gameUpdateRequest.getUserEvaluation() != null) {
            updatedGameDTO.setUserEvaluation(gameUpdateRequest.getUserEvaluation());
        }
        updatedGameDTO.setHide(gameUpdateRequest.isHide());

        Game updatedGame = gameConverterToEntity.convert(updatedGameDTO);
        gameRepository.save(updatedGame);
        return updatedGameDTO;
    }

    @Override
    public void deleteGame(Integer id) {
        gameRepository.deleteById(id); // Удаляем
    }
}
