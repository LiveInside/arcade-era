package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.GameCreateRequest;
import org.nikita.arcadeera.dto.request.GameUpdateRequest;
import org.nikita.arcadeera.dto.response.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO get(Integer id);

    List<GameDTO> getAll();

    GameDTO create(GameCreateRequest gameCreateRequest);

    GameDTO update(GameUpdateRequest gameUpdateRequest, Integer id);

    void delete(Integer id);
}
