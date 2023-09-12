package org.nikita.arcadeera.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.game.GameConverterToDTO;
import org.nikita.arcadeera.converter.game.GameConverterToEntity;
import org.nikita.arcadeera.dto.request.RequestGameDTO;
import org.nikita.arcadeera.dto.response.GameDTO;
import org.nikita.arcadeera.entity.Game;
import org.nikita.arcadeera.exception.EmptyParamException;
import org.nikita.arcadeera.exception.ResourceNotFoundException;
import org.nikita.arcadeera.repository.GameRepository;
import org.nikita.arcadeera.service.GameService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
@Log4j2
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final GameConverterToDTO gameConverterToDTO;
    private final GameConverterToEntity gameConverterToEntity;

    @Override
    public GameDTO getGameById(Integer id) {
        Game game = gameRepository.findById(id).orElse(null);
        return gameConverterToDTO.convert(game);
    }

    @Override
    public List<GameDTO> getAllGames() {
        List<Game> games = gameRepository.findAll(); //Находим и извлекаем все игры из репозитория
        if (CollectionUtils.isEmpty(games)) {
            throw new ResourceNotFoundException("Таблица games пустая");
        }
        return games.stream()
                .map(gameConverterToDTO::convert)
                .toList(); // Собираем список DTO и возвращаем его
    }

    @Override
    public GameDTO createGame(GameDTO gameDTO) {
        if (gameDTO.getAgeRating() == null)
            throw new EmptyParamException("Поле AgeRating обязательно к заполнению");
        if (gameDTO.getGenre() == null)
            throw new EmptyParamException("Поле Genre обязательно к заполнению");
        if (gameDTO.getName() == null)
            throw new EmptyParamException("Поле Name обязательно к заполнению");
        if (gameDTO.getPlatform() == null)
            throw new EmptyParamException("Поле Platform обязательно к заполнению");

        Game game = gameConverterToEntity.convert(gameDTO);
        gameRepository.save(game); // Сохраняем
        return gameConverterToDTO.convert(game);
    }

    @Override
    public GameDTO updateGame(RequestGameDTO gameDTO, Integer id) {
        Game game = gameRepository.findById(id).orElse(null);
        GameDTO updatedGameDTO = gameConverterToDTO.convert(game);

        if (gameDTO.getPrice() != null) {
            updatedGameDTO.setPrice(gameDTO.getPrice());
        }
        if (gameDTO.getUserEvaluation() != null) {
            updatedGameDTO.setUserEvaluation(gameDTO.getUserEvaluation());
        }
        updatedGameDTO.setHide(gameDTO.isHide());

        Game updatedGame = gameConverterToEntity.convert(updatedGameDTO);
        gameRepository.save(updatedGame);
        return updatedGameDTO;
    }

    @Override
    public void deleteGame(Integer id) {
        if (Objects.isNull(id))
            throw new EmptyParamException("Параметр пуст");
        gameRepository.deleteById(id); // Удаляем
    }
}
