package org.nikita.arcadeera.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.GameConverter;
import org.nikita.arcadeera.dto.GameDTO;
import org.nikita.arcadeera.entity.Game;
import org.nikita.arcadeera.exception.EmptyParam;
import org.nikita.arcadeera.repository.GameRepository;
import org.nikita.arcadeera.service.GameService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameConverter gameConverter;

    @Override
    public GameDTO getGameById(Integer id) {
        Game game = gameRepository.findById(id).orElse(null);
        if (Objects.isNull(game)) {
            log.info("Игра не найдена");
            return null;
        }
        return gameConverter.toDTO(game);
    }

    @Override
    public List<GameDTO> getAllGames() {
        List<Game> games = gameRepository.findAll(); //Находим и извлекает все игры из репозитория
        if (CollectionUtils.isEmpty(games)) {
            log.info("Таблица games пустая");
            return Collections.emptyList();
        }
        return games.stream()
                .map(gameConverter::toDTO) // Преобразуем Entity в DTO
                .toList(); // Собираем список DTO и возвращаем его
    }

    @Override
    public void createOrUpdateGame(GameDTO gameDTO) {
        if (Objects.isNull(gameDTO))
            throw new EmptyParam("Параметр пуст");

        Game game = gameConverter.toEntity(gameDTO);
        gameRepository.save(game); // Сохраняем
    }

    @Override
    public void deleteGame(Integer id) {
        if (Objects.isNull(id))
            throw new EmptyParam("Параметр пуст");
        gameRepository.deleteById(id); // Удаляем
    }
}
