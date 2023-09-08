package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.dto.GameDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")

public interface GameController {
    @GetMapping("/{id}")
    GameDTO getGameById(@PathVariable Integer id);

    @GetMapping
    List<GameDTO> getAllGames();

    @PostMapping
    void createOrUpdateGame(@RequestBody GameDTO gameDTO);

    @DeleteMapping
    void deleteGame(@RequestParam Integer id);
}
