package org.nikita.arcadeera.service;

import org.nikita.arcadeera.converter.GameConverter;
import org.nikita.arcadeera.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
    private final GameRepository gameRepository;
    private final GameConverter gameConverter;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository,
                           GameConverter gameConverter) {
        this.gameRepository = gameRepository;
        this.gameConverter = gameConverter;
    }
}
